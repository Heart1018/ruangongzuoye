import static org.junit.Assert.*;

public class MyCalulatorTest {

    @org.junit.Test
    public void calulate() {
        //测试加法
        MyCalulator test1=new MyCalulator();
        Double result1= test1.calulate("1","+","2");
        assertEquals(result1,(Double) 3.0);

        //测试减法
        MyCalulator test2=new MyCalulator();
        Double result2= test2.calulate("2","-","1");
        assertEquals(result2,(Double) 1.0);

        //测试乘法
        MyCalulator test3=new MyCalulator();
        Double result3= test3.calulate("2","×","3");
        assertEquals(result3,(Double) 6.0);

        //测试除法(除数不为零)
        MyCalulator test4=new MyCalulator();
        Double result4= test4.calulate("15","÷","3");
        assertEquals(result4,(Double) 5.0);

        //测试除法(除数为零)
        MyCalulator test5=new MyCalulator();
        Double result5= test5.calulate("15","÷","0");
        assertEquals(result5,null);

        //测试输入数字有小数点
        MyCalulator test6=new MyCalulator();
        Double result6= test6.calulate("1.2","+","1.4");
        assertEquals(result6,(Double) 2.6, 0.001);

        //测试sin
        MyCalulator test7=new MyCalulator();
        Double result7= test7.calulate("","s","1.7");
        assertEquals(result7,(Double) 0.9916648104524686);

        //测试阶乘
        MyCalulator test8=new MyCalulator();
        Double result8= test8.calulate("4","!","");
        assertEquals(result8,(Double) 24.0);

        //测试开根号
        MyCalulator test9=new MyCalulator();
        Double result9= test9.calulate("","S","9");
        assertEquals(result9,(Double) 3.0);

        //测试n次方
        MyCalulator test10=new MyCalulator();
        Double result10= test10.calulate("2","^","3");
        assertEquals(result10,(Double) 8.0);

    }
}