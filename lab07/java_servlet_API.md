#JAVA Servlet API

Реализация:

Tomcat

https://tomcat.apache.org/download-10.cgi

https://jakarta.ee/specifications/servlet/6.0/jakarta-servlet-spec-6.0.html

## Протокло HTTP

HTTP - протокол верхнего уровня. В качестве транспорта HTTP использует протокол TCP/IP

### Запрос (Request)
Запрос
Header

[BODY]
```
GET /lab07/simple HTTP/1.1\n\r -  начало заголовка
Host: localhost:8080\n\r
...
\n\r
```

### Ответ (Response)

```
_Header_
HTTP/1.1 200 \n\r
Content-Length: 73
...
\n\r
_Body (73 byte)_
0:0:0:0:0:0:0:1\n
http\n
8080\n
HTTP/1.1\n
0:0:0:0:0:0:0:1\n
0:0:0:0:0:0:0:1\n
36368\n
```

## Java Servlet

class:
```java
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

public class SimpleServlet implemets Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```
_Задание_

Написать программу - web-приложение:
Вывести список пассажиров, летавших из Шереметьево
10.09.2017 г.