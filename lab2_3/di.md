# IoC (Inversion of Control) Инверсия управления

 - Модули верхнего уровня не должны зависеть от модулей нижнего уровня. 
 И те, и другие должны зависеть от абстракции.
 - Абстракции не должны зависеть от деталей.
Детали должны зависеть от абстракций.


Все зависимости модулей должны строятся на абстракциях этих модулях, 
а не их конкретных реализациях.

```java
// Плохой способ
// Есть сильная зависимость класса Weather от реализации WeatherService
class Weather {

    String getWeather(int days) {
        WeatherService service = new WeatherService();
        return service.getWeather(days);        
    }
}
```
# Dependecies Injections - Внедрение зависимостей

```java
// 1.
class Weather {

    WeatherService service;
    
    void setWeatherService (WeatherService service) {
        this.service = service;    
    }
    
    String getWeather(int days) {
        return service.getWeather(days);        
    }
}
```

```java
// 2.
class Weather {

    WeatherService service;
    
    public Weather(WeatherService service) {
        this.service = service;    
    }
    
    String getWeather(int days) {
        return service.getWeather(days);        
    }
}
```

Следующий способ нуждается в контейнере управления
(IoC container, example: Tomcat - контейнер сервлетов)
```java
// 3.
class Weather {

    @Inject
    WeatherService service;
    
    String getWeather(int days) {
        return service.getWeather(days);        
    }
}
```

```java
// 4. Наиболее абстрактный способ внедрения зависимости
class Weather {

    @Inject
    IWeatherService service; //используема интерфейс как тип переменной
    
    String getWeather(int days) {
        return service.getWeather(days);        
    }
}

class WeatherServiceYandex implements IWeatherService {
    void getWeather(int days) {
        ...
    }
}

class WeatherServiceGisMeteo implements IWeatherService {
    void getWeather(int days) {
        ...
    }
}
```