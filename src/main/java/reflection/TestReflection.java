package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<ConcreteClass> test = ConcreteClass.class;
        //Class<?> test = Class.forName("reflection.ConcreteClass");
        // Class<? extends ConcreteClass> test = new ConcreteClass(5).getClass();
       test.getResource("//");
        Method[] allMethods = test.getMethods();
        Class<?>[] allClasess = test.getClasses();
        Class<?>[] declearedClass = test.getDeclaredClasses();
        Field[] allFields = test.getFields();
        Constructor<?>[] publicConstructors = Class.forName("reflection.ConcreteClass").getConstructors();

      /*  System.out.println(Arrays.toString(publicConstructors));
        System.out.println(Arrays.toString(allFields));
        System.out.println(Arrays.toString(allMethods));
        System.out.println(Arrays.toString(allClasess));
        System.out.println(Arrays.toString(declearedClass));
        System.out.println(test.getCanonicalName());
        System.out.println(test.getSuperclass());*/

        Field field = test.getField("publicInt");
        ConcreteClass concreteClass=new ConcreteClass(10);
        field.setInt(concreteClass,12);
        Field[] declearedFiled = test.getDeclaredFields();
       // System.out.println(Arrays.toString(declearedFiled));
        System.out.println(field.get(concreteClass));

        Method t = test.getMethod("method4", null);
        t.invoke(concreteClass);



    }
}
