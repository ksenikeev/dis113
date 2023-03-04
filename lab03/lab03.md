# Основы разработки информационных систем
## Лабораторная работа 3
### Работа с XML докуентами

Структура xml документа:

+ Заголовок (декларация): ``` <?xml version="1.0" encoding="UTF-8" standalone="yes"?>```
+ Корневой элемент (root element): ``` <bank> ```
+ Набор тегов (tags): каждый тег должен обязательно закрываться: ``` <clients> ... </clients> ```
+ Теги могут быть вложенны друг в друга, но содержимое не должно пересекаться
    
    - Правильно! ``` <client> <name>Client 1</name> <passport>1111</passport></client>```
    - Ошибка! ``` <client> <name>Client 1<passport> </name> 1111</passport></client>```

``` xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<bank>
    <clients>
        <client>
            <name>Клиент1</name>
            <passport>1111 111111</passport>
        </client>
        <client>
            <name>Клиент2</name>
            <passport>2222 222222</passport>
        </client>
    </clients>
    <name>Банк</name>
</bank>
```

### Преобразование объекта в документ и обратно

Структура данных:

Bank {
    name,
    clients[]
}
Client {
    name,
    passport
}


Правильно описываем классы:




### Библиотека JAXB

Зависимости:

>        <dependency>
>             <groupId>javax.xml.bind</groupId>
>             <artifactId>jaxb-api</artifactId>
>             <version>2.3.1</version>
>         </dependency>
>        <dependency>
>            <groupId>com.sun.xml.bind</groupId>
>            <artifactId>jaxb-impl</artifactId>
>            <version>2.3.1</version>
>        </dependency>
>        <dependency>
>            <groupId>com.sun.istack</groupId>
>            <artifactId>istack-commons-runtime</artifactId>
>            <version>4.1.1</version>
>        </dependency>


Преобразование класса в документ назывется _МАРШАЛИЗАЦИЯ_

``` java
            JAXBContext context = JAXBContext.newInstance(Bank.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(bank, new File("bank.xml"));
```

Преобразование документа в класс 

``` java
        JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
        Unmarshaller un = jaxbContext.createUnmarshaller();

        return (Bank) un.unmarshal(new File("bank.xml"));
 ```

Задание 3:

Написать программу (клиент - сервер), реализует вклад денег в банк

1. Клиент отправляет перевод денег в банк:
    
    + формирует XML документ:
    
        ``` xml
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <tranzaction>
                    <client>
                        <name>Клиент1</name>
                        <passport>1111 111111</passport>
                    </client>
                    <summ>1000.00</summ>
                    <date>yyyyMMddHH:mm</date>
                </tranzaction>
        ``` 

    + отправляет его через сокет на сервер

2. Сервер получает XML документ.
    + Ищет клиента по паспорту
    + Если клиент найден, то прибавляет указанную сумму на счёте
    + Если клиент не найден,то создает нового и кладет сумму на счёт
    + Отправляет клиенту ответ - XML документ:
        ``` xml
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <accountinfo>
                    <accountnumber>101</accountnumber>
                    <summ>2000.00</summ>
                    <date>yyyyMMddHH:mm</date>
                </accountinfo>
        ``` 
3. Передача данных должна осуществляться через сокеты 

    протокол:
        * 4 байта - длина сообщения
        * сообщение (XML документ)