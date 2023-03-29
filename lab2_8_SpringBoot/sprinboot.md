# Spring Boot

1. На сайте
https://start.spring.io/ сформировали каркас приложения

2. Добавили зависимости:
   - PostgreSQL
   - lombook

3. Исправили `application.properties` - добавили
    - настрока порта
    - настройка подключения к базе данных

4. Сформировали конфигурацию приложения `Config.java` 
 - указали расположение статических ресурсов

5. Создали CRUD репозиторий для работы с базой данных
 - интерфейс [AccessProtocolRepository.java](src%2Fmain%2Fjava%2Fru%2Fitis%2Flab2_8%2Frepository%2FAccessProtocolRepository.java)

6. Создали *.ftlh шаблоны страниц

7. Создали контроллеры для обработки http запросов
 - [IndexController.java](src%2Fmain%2Fjava%2Fru%2Fitis%2Flab2_8%2Fcontrollers%2FIndexController.java)
 - [LoginController.java](src%2Fmain%2Fjava%2Fru%2Fitis%2Flab2_8%2Fcontrollers%2FLoginController.java)

8. Для передачи данных формы создали класс DTO (data transfer object)
 [LoginDto.java](src%2Fmain%2Fjava%2Fru%2Fitis%2Flab2_8%2Fdto%2FLoginDto.java)

Домашнее задание:
1. Запустить приложение lab2_8
2. Дополнить приложение страницей просмотра логов попыток доступа
   (вывести содержимое таблицы AccessProtocol)