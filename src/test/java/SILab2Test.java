import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void testNullItemsList() {
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100),
                "Expected RuntimeException for null allItems list");
    }

    @Test
    public void testEmptyItemsList() {
        List<Item> items = new ArrayList<>();
        assertTrue(SILab2.checkCart(items, 100),
                "Empty list should always return true (sufficient payment)");
    }

    @Test
    public void testValidItemsAndSufficientPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("bread", "12345", 50, 0.1f));
        items.add(new Item("milk", "67890", 80, 0));
        assertTrue(SILab2.checkCart(items, 150),
                "Valid items and sufficient payment should return true");
    }

    @Test
    public void testValidItemsAndInsufficientPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("bread", "12345", 50, 0.1f));
        items.add(new Item("milk", "67890", 80, 0));
        assertFalse(SILab2.checkCart(items, 100),
                "Valid items and insufficient payment should return false");
    }

    @Test
    public void testInvalidBarcodeCharacter() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("bread", "123x5", 50, 0.1f)); // Invalid 'x' in barcode
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100),
                "Expected RuntimeException for invalid barcode character");
    }

    @Test
    public void testNoBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("bread", null, 50, 0.1f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100),
                "Expected RuntimeException for null barcode");
    }

    @Test
    public void testDiscountAbove300WithZeroBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("bread", "01234", 350, 0.2f));
        assertTrue(SILab2.checkCart(items, 1000),
                "Discount should be applied and extra 30 subtracted for price above 300 and zero barcode");
    }
}
