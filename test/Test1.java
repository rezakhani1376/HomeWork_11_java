package test;

import main.Main2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Test1 {

    @Test
    public void testInitMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("main.Main2").getDeclaredMethod("initList");
        method.setAccessible(true);
        Main2 main = new Main2();
        List list = (List) method.invoke(main);
        Assertions.assertEquals(99, list.size());
    }

    @Test
    public void testFilterMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main2 main = new Main2();
        Method filter = Main2.class.getDeclaredMethod("filterbynameandbreedtype", List.class);
        filter.setAccessible(true);
        Method init = Main2.class.getDeclaredMethod("initList");
        init.setAccessible(true);
        List list = (List) init.invoke(main);
        List list1 = (List) filter.invoke(main, list);
        Assertions.assertEquals(11, list1.size());


    }
}
