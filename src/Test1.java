import com.meng.wang.RefleEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by meng on 17-7-1.
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        int i=10;
        System.out.println(i+"2");
        Test1 test1=new Test1();

        RefleEntity entity = new RefleEntity();
        String name = entity.getClass().getName();
        System.out.println(name);//com.meng.wang.RefleEntity

        //实例化一般采用这种方式。
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        try {
            class1 = Class.forName("com.meng.wang.RefleEntity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        class2 = new RefleEntity().getClass();
        class3 = RefleEntity.class;

        System.out.println();
        System.out.println("Test1.main");
        System.out.println("class3 = " + class3);
        System.out.println("args = [" + args + "]");

        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());


        try {
            RefleEntity refleEntity = (RefleEntity) class1.newInstance();
            refleEntity.sing("今天--刘德华");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



        Field[] declaredFields = class1.getDeclaredFields();
        for (int j = 0; j < declaredFields.length; j++) {
            Class<?> type = declaredFields[j].getType();
            String simpleName =declaredFields[j].getName();
            String name1 = type.getName();
            System.out.println(simpleName+":"+name1);
        }

        System.out.println("*****************************************");

        try {
            Method sing = class1.getMethod("sing",String.class);
            sing.invoke(class1.newInstance(),"星语心愿--张柏芝");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }



}
