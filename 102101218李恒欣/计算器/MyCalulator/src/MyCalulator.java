import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MyCalulator extends JFrame implements ActionListener {
    private JPanel jPanel1=new JPanel();//创建上方控件,用于放置运算
    private JTextField input=new JTextField();//输入区域
    private JPanel jPanel2=new JPanel();//创建下方控件，用于放置数字和运算符
    private String str1="";//第一个数字
    private String op="";//操作数
    private String str2="";//第二个数字
    public static void main(String[] args){
        new MyCalulator().Caluculator();
    }
    public String[] key={"1","2","3","+","=","tan",
            "4","5","6","-","ln","!",
            "7","8","9","×","sin","sqrt",
            "0",".","C","÷","cos","^"};//一开始我构建可视化界面时每个按键都定义一个单独的变量，再挨个进行创建和排版，工程量大，实现不方便
    public  void Caluculator(){
        //窗口初始化
        JFrame frame=new JFrame("计算器");
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        //初始化运算显示栏
        input.setPreferredSize(new Dimension(450,100));
        jPanel1.add(input);
        frame.add(jPanel1,BorderLayout.NORTH);//放置在窗口“南方”（上方）
        input.setHorizontalAlignment(JLabel.RIGHT);
        //初始化按键区
        jPanel2.setLayout(new GridLayout(4,5));//4行5列的按键区
        for(int i=0;i< key.length;i++){
            JButton button=new JButton();
            button.setText(key[i]);
            button.addActionListener(this::actionPerformed);
            jPanel2.add(button);
        }
        frame.add(jPanel2,BorderLayout.CENTER);

        frame.setVisible(true);
    }//完成计算器的可视化

    //实现按键的监听
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if(".0123456789".indexOf(str)!=-1){
            //如果点击的按键的值是.0123456789
            input.setText(input.getText()+str);
        }
        else if(str.matches("[\\+\\-×÷]{1}")){
            //如果点击的按键是+-×÷（+和-前面要使用转义字符）
            op=str;//保存操作符
            str1=input.getText();//保存第一个操作数
            input.setText("");//清空操作栏
        }
        else if(str.equals("ln")){
            //如果点击的按键是ln
            op="l";//保存操作符
            input.setText("ln");
        }
        else if(str.equals("sin")){
            //如果点击的按键是sin
            str1="";
            op="s";//保存操作符
            input.setText("sin");
        }
        else if(str.equals("cos")){
            //如果点击的按键是cos
            str1="";
            op="c";//保存操作符
            input.setText("cos");
        }
        else if(str.equals("tan")){
            //如果点击的按键是tan
            str1="";
            op="t";//保存操作符
            input.setText("tan");
        }
        else if(str.equals("!")){
            //如果点击的按键是!
            str1=input.getText();
            op="!";//保存操作符
            input.setText(str1+"!");
            str2="";
        }
        else if(str.equals("sqrt")){
            //如果点击的按键是sqrt
            str1="";
            op="S";//保存操作符
            input.setText("sqrt(");
        }
        else if(str.equals("^")){
            //如果点击的按键是^2
            op=str;//保存操作符
            str1=input.getText();//保存第一个操作数
            input.setText("");//清空操作栏
        }
        else if(str.equals("=")){
            str2=input.getText();
            if(calulate(str1,op,str2)==null){
                if(op.equals("÷"))
                    input.setText("除数不能为零");
                else
                    input.setText("阶乘对象必须为整数");
            }

            else
                input.setText(format(calulate(str1,op,str2)));
        }
        else if(str.equals("C")) {
            String str1="";
            String op="";
            String str2="";//所有已输入数据初始化
            input.setText("");
        }

    }
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
    public String format(double d){
        String form="";
        NumberFormat nf=NumberFormat.getInstance();
        form=nf.format(d);
        return form;
    }
}
