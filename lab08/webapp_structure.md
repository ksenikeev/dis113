# Структура web-приложения

/META-INF
/WEB-INF -
        /classes
        /lib
        web.xml
/resources -
        /css
        /js
        /img
index.html

## Дескриптор развертывания (deploymet descripter)
### web.xml

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="4.0" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
   http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">

    <display-name>lab08</display-name>

    <session-config>
        <session-timeout>60</session-timeout>
    </session-config>


    <servlet>
        <servlet-name>simple_servlet</servlet-name>
        <servlet-class>ru.itis.dis.lab08.SimpleServlet</servlet-class>
        <init-param>
            <param-name>aaa</param-name>
            <param-value>111</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>simple_servlet</servlet-name>
        <url-pattern>/demo</url-pattern>
    </servlet-mapping>

</web-app>
```

```
POST /lab08/index HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 27
Cache-Control: max-age=0
sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="90"
sec-ch-ua-mobile: ?0
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 (Chromium GOST)
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8080/lab08/index.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7
\n\r
login=kamil&password=secret
```