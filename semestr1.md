#Семестровая 1
##Клиент - Банк

1. Разработать программу с графическим интерфейсом, работающую с БД (Банк)

2. Разработать программу с графическим интерфейсом, работающей по TCP 
   с Банком (Клиент)
   
3. Протоколы
    1) Логин 
```xml
        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <login>
                    <account>11111</account>
                    <password>qwerty</password>
                </login>
```    
```xml
       <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
               <loginresponse>
                   <name>Ахмад</name>
                   <summ>10000</summ>
               </loginresponse>
```    
    
    2) Добавление счета 
```xml
        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <newaccount>
                    <name>Ahmad</name>
                    <passport>11111</passport>
                    <birthdate>2002-11-03</birthdate>
                    <gender>m</gender>
                    <summ>100000</summ>
                </newaccount>
```    
```xml
        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <accountresponse>
                    <accountnumber>1111</accountnumber>
                </accountresponse>
```    
    3) Перечисление денег
```xml    
     <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <tranzaction>
            <src_account>11111</src_account>
            <dst_account>22222</dst_account>
            <summ>1000.00</summ>
        </tranzaction>
```
```xml    
     <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <tranzactionresponse>
            <status>success, error</status>
            <description>22222</description>
            <summ>1000.00</summ> <!--  остаток -->
        </tranzaction>
```
    4)
```xml    
     <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <accounts>
        </accounts>
```
```xml    
     <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <accountsresponse>
            <account>
                <accountnumber></accountnumber>
                <name></name>
            </account>
            <account>
                <accountnumber></accountnumber>
                <name></name>
            </account>
        </accountsresponse>
```
    