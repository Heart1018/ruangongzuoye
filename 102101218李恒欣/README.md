# 作业要求

[软件工程实践第一次作业-CSDN社区](https://bbs.csdn.net/topics/617294583)

# 项目源码



# 作业目标

完成一个具有可视化界面的计算器

# 1、界面及效果展示

![img](https://img-blog.csdnimg.cn/dc3dcf298b114c6c9ca83b580df44eb8.gif)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)编辑

# 2、PSP表格

| PSP                                     | Personal Software Process Stages        | 预估耗时（分钟） | 实际耗时（分钟） |
| --------------------------------------- | --------------------------------------- | ---------------- | ---------------- |
| Planning                                | 计划                                    | 20               | 30               |
| • Estimate                              | • 估计这个任务需要多少时间              | 15               | 10               |
| Development                             | 开发                                    | 120              | 180              |
| • Analysis                              | • 需求分析 (包括学习新技术）            | 300              | 360              |
| • Design Spec                           | • 生成设计文档                          | 60               | 60               |
| • Design Review                         | • 设计复审                              | 15               | 20               |
| • Coding Standard                       | • 代码规范 (为目前的开发制定合适的规范) | 10               | 15               |
| • Design                                | • 具体设计                              | 30               | 60               |
| • Coding                                | • 具体编码                              | 240              | 300              |
| • Code Review                           | • 代码复审                              | 60               | 90               |
| • Test                                  | • 测试（自我测试，修改代码，提交修改）  | 60               | 120              |
| Reporting                               | 报告                                    | 90               | 120              |
| • Test Repor                            | • 测试报告                              | 60               | 30               |
| • Size Measurement                      | • 计算工作量                            | 20               | 10               |
| • Postmortem & Process Improvement Plan | • 事后总结, 并提出过程改进计划          | 20               | 60               |
|                                         | 合计                                    | 1060             | 1465             |



# 3、解题思路描述

​    1、通过Java的swing进行计算器的窗口可视化；

​    2、在每个按键上安装监听器ActionListener对鼠标的点击操作进行监听，并编写代码实现计算器对“事件”做出相应反应；

​    3、编写计算器代码。

# 4、核心代码展示

```java
public Double calulate(String str1_,String op,String str2_){
        Double result=0.0;
        if(op.equals("+")){
            Double num1=Double.valueOf(str1_);
            Double num2=Double.valueOf(str2_);
            result=num1+num2;
        }
        else if(op.equals("-")){
            Double num1=Double.valueOf(str1_);
            Double num2=Double.valueOf(str2_);
            result=num1-num2;
        }
        else if(op.equals("×")){
            Double num1=Double.valueOf(str1_);
            Double num2=Double.valueOf(str2_);
            result=num1*num2;
        }
        else if(op.equals("÷")){
            Double num1=Double.valueOf(str1_);
            Double num2=Double.valueOf(str2_);
            if(num2!=0)
                result=num1/num2;
            else
                result=null;
        }
        else if(op.equals("l"))
        {
            String replace=str2_.replace("ln","");
            result=Math.log(Double.valueOf(replace));
        }
        else if(op.equals("s"))
        {
            String replace=str2_.replace("sin","");
            result=Math.sin(Double.valueOf(replace));
        }
        else if(op.equals("c"))
        {
            String replace=str2_.replace("cos","");
            result=Math.cos(Double.valueOf(replace));
        }
        else if(op.equals("t"))
        {
            String replace=str2_.replace("tan","");
            result=Math.tan(Double.valueOf(replace));
        }
        else if(op.equals("!"))
        {
            int index=str1_.indexOf(".");
            if(index==-1) {
                String replace = str1_.replace("!", "");
                Integer temp = Integer.valueOf(replace);
                Double res = 1.0;
                for (Integer i = temp; i > 0; i--) {
                    res *= i;
                }
                result=res;
            }
            else{
                result=null;
            }
        }
        else if(op.equals("S"))
        {
            String replace=str2_.replace("sqrt(","");
            result=Math.sqrt(Double.valueOf(replace));
        }
        else if(op.equals("^"))
        {
            Double num1=Double.valueOf(str1_);
            Double num2=Double.valueOf(str2_);
            result=Math.pow(num1,num2);
        }
        return result;
    }
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

# 5、设计和实现

​    1、导入需要用到的库：

```
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.text.NumberFormat;
```

​    2、使用JFrame初始化一个可视化窗口并命名为“计算器”；

​    3、private JPanel jPanel1=new JPanel();//创建上方控件,用于放置运算

​       private JTextField input=new JTextField();//输入区域

​       private JPanel jPanel2=new JPanel();//创建下方控件，用于放置数字和运算符

​       完成计算器可视化的基础构建；

​    4、将可视化窗口中填入按钮与数据，完成计算机的可视化；

​    5、对每个按钮安装监听器ActionListener，并完成actionPerformed函数实现对每个按钮点击时的计算器会做出反应；

​    6、编写函数calulate实现计算器的计算功能；

​    7、编写函数format保证输出数据的标准化；

​    8、运行计算器。

# 6、性能改进

​    1、一开始构建可视化界面时，我将每个按键都用一个单独的变量进行定义，再挨个进行创建和排版，工程量大，实现不方便。也不便于后续对按钮监听器的安装；

​    2、起初是在actionPerformed函数对监听器触发的事件进行处理时实现函数calulate的计算功能的，后续将函数calulate进行单独分装后，大大增加了代码的可读性，便于后续进行测试与修改。

# 7、单元测试

```java
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
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

测试结果：

![img](https://img-blog.csdnimg.cn/379977a5255e42aba33f81cfc04d2c70.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)编辑

# 8、心得体会

​    虽然这几天的学习过程充满艰辛，但还是收获满满！

​    这是我学习JAVA后编写的第一个程序，同时也是我编写的第一个可视化的程序，虽然花费的时间很多，可以实现的内容不多，也都相对简单，但我觉得这是我迈出的非常坚实且有意义的一步。

​    收到作业时我才刚刚自学了一周的JAVA的知识且从未接触过可视化的相关代码，所以萌生了使用JAVA完成此次作业的想法。在几天的学习其他优秀的博客与视频后我学习到了JAVA.swing的可视化知识，深入了解了JAVA可视化与监听功能的使用，对JAVA相关技能有了相对牢固的掌握。

​    在学习的过程中我也不断向身边优秀的同学请教，也学习和掌握了如何进行“单元测试”与进行项目开发前应如何进行合理的分析与时间规划。