# SpringBootSecurity
проект демонстрирует базовые возможности __SpringBootSecurity__

добавление зависимости в проект
````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>...</version>
</dependency>
````
наделяет приложение формой ввода _логина_ и _пароля_
(логин по умолчанию: __user__, пароль можно подсмотреть в логах при старте приложения)

Для задания своего имени пользователя и пароля используйте настройки файла _application.properties_:

````
spring.security.user.name=admin
spring.security.user.password=admin 
````