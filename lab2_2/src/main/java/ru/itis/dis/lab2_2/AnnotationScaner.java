package ru.itis.dis.lab2_2;

import ru.itis.dis.lab2_2.annotations.Component;
import ru.itis.dis.lab2_2.annotations.Inject;
import ru.itis.dis.lab2_2.components.TestClass;
import ru.itis.dis.lab2_2.components.TestComponent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *  IoC Inversion of Control
 *
 *  DI Dependency Injection
 *
 */
public class AnnotationScaner {

    public static String PATH_FOR_SCAN = "ru.itis.dis.s2lab1.components";

    public static void main(String[] arg) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN+":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        if (classList != null)
            classList.forEach(c->System.out.println("\t" + c.getSimpleName()));

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());

            for (Field field : cl.getDeclaredFields()) {
                System.out.println("\t\t" + field.getName() + " of type " + field.getType().getCanonicalName());

                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    System.out.println("raw type: " + pt.getRawType());
                    System.out.println("owner type: " + pt.getOwnerType());
                    System.out.println("actual type args:");
                    for (Type t : pt.getActualTypeArguments()) {
                        System.out.println("    " + t);
                    }
                }

            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }
        }


        System.out.println("STEP 4: scan class annotations:");
        Annotation[] annotations = TestComponent.class.getAnnotations();
        if (annotations != null) {
            for (Annotation a1 : annotations) {
                if (a1.annotationType().equals(Component.class)) {
                    System.out.println("\tTestComponent is Component!");
                    break;
                }

            }
        }

        System.out.println("STEP 5: scan fields annotations:");

        Field[] fields = TestClass.class.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] fannotations = f.getAnnotations();
            for (Annotation a2 : fannotations) {
                if (a2.annotationType().equals(Inject.class)) {
                    System.out.println(String.format("\tField %s %s Inject!", f.getType().getName(),f.getName()));
                }
            }
        }


        System.out.println("...");

    }
}
