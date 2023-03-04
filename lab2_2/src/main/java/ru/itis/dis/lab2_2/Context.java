package ru.itis.dis.lab2_2;

import ru.itis.dis.lab2_2.annotations.Component;
import ru.itis.dis.lab2_2.annotations.Inject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Context {

    /*
     * 1. Сканирование структуры программы
     *  1.1 ищем компоненты @Component -> Map<Name, Type>
     *  1.2 ищем поля @Inject
     *
     * 2. Инициализация полей @Inject
     *
     * 3. Запуск основного класса приложения
     */

    private String componentPath;

    private List<Class<?>> classesInPath;

    private Map<String, Object> components = new HashMap<>();


    public Context() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Properties properties = new Properties();
        try {
            properties.load(Application.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        componentPath = (String) properties.get("componentpath");

        classesInPath = PathScan.find(componentPath);

        // find component
        for (Class<?> cl : classesInPath) {

            //System.out.println(cl.getCanonicalName());

            Annotation[] annotations = cl.getAnnotations();//reflection API
            for (Annotation a : annotations) {
                if (Component.class.equals(a.annotationType())) {
                    Constructor constructor = cl.getConstructor();
                    Object o = constructor.newInstance();
                    components.put(cl.getSimpleName(), o);
                    break;
                }
            }
        }

        // find injections
        for (Class<?> cl : classesInPath) {
            for (Field field : cl.getDeclaredFields()) {
                //get fields annotations
                Annotation[] annotations = field.getAnnotations();

                for (Annotation a : annotations) {
                    if (Inject.class.equals(a.annotationType())) {
                        field.setAccessible(true);// доступ к приватным полям

                        // set field value  (в какой объект вставляем, объект для вставки)
                        field.set(components.get(cl.getSimpleName()), components.get(field.getType().getSimpleName()));
                        break;
                    }
                }
            }
        }

    }

    // Запуск программы на исполнение, пример Context.run(Main.class)
    public static void run(Class<?> type) {

        try {
            Context context = new Context();

            Runnable mainApp = (Runnable) context.components.get(type.getSimpleName());

            mainApp.run();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

}
