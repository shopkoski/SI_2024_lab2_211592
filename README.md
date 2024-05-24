# Втора лабораториска вежба по Софтверско инженерство
# Гоце Шопкоски, бр. на индекс 211592
## Control Flow Graph 
![cfg](https://github.com/shopkoski/SI_2024_lab2_211592/assets/163521657/f56a357a-3a32-4e1d-a630-c802a97e3611)


## Цикломатската комплексност 
E= 36 (број на рабови/конекции) N=28 (број на јазли) C=E-N+2= 36-28+2= 10

## Тест случаи според критериумот Every branch
1.	allItems==null -Листата е празна, throws exception
2.	allitems!=null name="bread" barcode="012345" discount>0 price>300 payment>sum -Сите услови да се исполнети
3.	allitems!=null name=null barcode="0-12345" -Услов не е исполнет за barcode (allowed.indexOf(c) == -1) throws exception
4.	allitems!=null name==null barcode="012345" discount=0 payment<sum - Услов не е исполнет (item.getDiscount() > 0) и (sum <= payment)
5.	allitems!=null name=null barcode=null -Услов не е исполнет (item.getBarcode() != null) throws exception

## Тест случаи според Multiple Condition

![image](https://github.com/shopkoski/SI_2024_lab2_211592/assets/163521657/ce471790-edc7-4759-8adc-ece30d9cedc7)
