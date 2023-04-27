#

1. Создали шаблон страницы с формой [groupp.ftlh](src%2Fmain%2Fresources%2Ftemplates%2Fgroupp.ftlh)
2. Создали контроллер, который обрабатывает шаблон [GrouppController.java](src%2Fmain%2Fjava%2Fru%2Fitis%2Flab2_10%2Fcontrollers%2FGrouppController.java)
3. Создаем объект DTO для передачи данных формы в контроллер
4. Создаем метод `@PostMapping` который обрабатывает ресурс (`action="..."`), аргумент метода принимает DTO 