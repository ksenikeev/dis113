package ru.itis.lab2_1.injection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

public class AnnotationScanner {
    public static String PATH_FOR_SCAN = "ru.itis.lab2_1";

    public static void main(String[] arg) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN+":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        if (classList != null)
            classList.forEach(c->System.out.println("\t" + c.getSimpleName()));

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            for (Field field : cl.getDeclaredFields()) {
                Annotation[] fannotations = field.getAnnotations();
                for (Annotation a2 : fannotations) {
                    // find Inject annotation
                    if (a2.annotationType().equals(Inject.class)) {
                        System.out.println(String.format("\tField %s %s Inject!", field.getType().getName(),field.getName()));

                        //create new Object
                        Class c = field.getType();
                        try {
                            Object o = c.getDeclaredConstructor(null).newInstance();
                            System.out.println(o);
                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }


/*
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
*/


        System.out.println("...");

    }

}
