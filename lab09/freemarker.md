#FreeMarker (templates framework)

maven dependency:
```xml
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.31</version>
        </dependency>

```

web.xml
```xml
    <servlet>
        <servlet-name>freemarker</servlet-name>
        <servlet-class>freemarker.ext.servlet.FreemarkerServlet</servlet-class>

        <!--
          Init-param documentation:
          https://freemarker.apache.org/docs/api/freemarker/ext/servlet/FreemarkerServlet.html
        -->

        <!-- FreemarkerServlet settings: -->
        <init-param>
            <param-name>TemplatePath</param-name>
            <param-value>classpath:/templates</param-value>
        </init-param>
        <init-param>
            <param-name>NoCache</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <param-name>ResponseCharacterEncoding</param-name>
            <!-- Use the output_encoding setting of FreeMarker: -->
            <param-value>fromTemplate</param-value>
        </init-param>
        <init-param>
            <param-name>ExceptionOnMissingTemplate</param-name>
            <!-- true => HTTP 500 on missing template, instead of HTTP 404. -->
            <param-value>true</param-value>
        </init-param>

        <!-- FreeMarker engine settings: -->
        <init-param>
            <param-name>incompatible_improvements</param-name>
            <param-value>2.3.28</param-value>
            <!--
              Recommended to set to a high value.
              See: https://freemarker.apache.org/docs/pgui_config_incompatible_improvements.html
            -->
        </init-param>
        <init-param>
            <param-name>template_exception_handler</param-name>
            <!-- Use "html_debug" during development! -->
            <param-value>rethrow</param-value>
        </init-param>
        <init-param>
            <param-name>template_update_delay</param-name>
            <!-- Use 0 during development! Consider what value you need otherwise. -->
            <param-value>30 s</param-value>
        </init-param>
        <init-param>
            <param-name>default_encoding</param-name>
            <!-- The encoding of the template files: -->
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>output_encoding</param-name>
            <!-- The encoding of the template output; Note that you must set
                 "ResponseCharacterEncodring" to "fromTemplate" for this to work! -->
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>locale</param-name>
            <!-- Influences number and date/time formatting, etc. -->
            <param-value>en_US</param-value>
        </init-param>
        <init-param>
            <param-name>number_format</param-name>
            <param-value>0.##########</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>freemarker</servlet-name>
        <url-pattern>*.ftl</url-pattern>
        <!-- HTML and XML auto-escaped if incompatible_improvements >= 2.3.24: -->
        <url-pattern>*.ftlh</url-pattern>
        <url-pattern>*.ftlx</url-pattern>
    </servlet-mapping>

```

make template: (index.ftl)
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome</h1>

<div>

<table>
    <#list tblData as lst>
        <tr>
            <td>${lst.field1}</td><td>${lst.field2}</td><td>${lst.field3}</td>
        </tr>
    </#list>
</table>
</div>
<p>
</body>
</html>
```

web servlet:

