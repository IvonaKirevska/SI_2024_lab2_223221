Втора лабораториска вежба по Софтверско инженерство

Ивона Киревска 223221

2.Control Flow Graph:

![Untitled Diagram (2)](https://github.com/IvonaKirevska/SI_2024_lab2_223221/assets/139162357/bbd62efe-d663-4a20-bd6c-ba62085eed2f)


3.Цикломатската комплексност на кодот е 10, ја добив според формулата P+1 каде што Р е бројот на предикатни јазли. Во кодот Р=9, Р=9+1=10 цикломатска комплексност. 

4.За здоволување на Every Branch критериумот имам 9 тестови: 
1.testNullAllItems() 
2.testEmptyAllItems()
3.testItemWithNullNameAndValidBarcode()
4.testItemWithInvalidBarcodeCharacter()
5.testItemWithNullBarcode()
6.testItemWithDiscount()
7.testItemWithoutDiscount()
8.testItemPriceDiscountBarcodeCondition()
9.testInsufficientPayment()

5.За условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)== '0') имам 8 тестови. Комбинациите се: 
T && T && T
T && T && F
T && F && T
T && F && F
F && T && T
F && T && F
F && F && T
F && F && F
T && T && T:
Тестови: 
1.T && T && T - price>300, discount>0, barcode започнува со 0.
2.T && T && F -  price>300, discount>0, barcode не започнува со 0.
3.T && F && T -  price>300, discount=0, barcode започнува со 0.
4.T && F && F -  price>300, discount=0, barcode не започнува со 0.
5.F && T && T -  price<=300, discount>0, barcode започнува со 0.
6.F && T && F -  price<=300, discount>0, barcode не започнува со 0.
7.F && F && T -  price<=300, discount=0, barcode започнува со 0.
8.F && F && F -  price<=300, discount=0, barcode не започнува со 0.
