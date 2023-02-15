package ru.itis.lab2_1.injection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    1. Управление программой
    2. Поиск компонент @Component и создание объекта (new instance)
    3. Поиск зависемостей @Inject и создание, внедрение объекта (new instance)

 */
public class Context {

    private String componentPath = "ru.itis.lab2_1";

    private List<Class<?>> classesInPath;

    private Map<String, Object> components = new HashMap<>();

    public Context() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        classesInPath = PathScan.find(componentPath);

        // find component
        for (Class<?> cl : classesInPath) {
            Annotation[] annotations = cl.getAnnotations();
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
                Annotation[] annotations = field.getAnnotations();
                for (Annotation a : annotations) {
                    if (Inject.class.equals(a.annotationType())) {
                        field.setAccessible(true);
                        field.set(components.get(cl.getSimpleName()), components.get(field.getType().getSimpleName()));
                        break;
                    }
                }
            }
        }

    }


}
