package com.company;

import java.util.Scanner;

public class Review {
    class preJava{
        //声明常量
        //final datatype CONSTANTNAME = value
        //幂运算
        //Math.pow(a, b)
        //键盘输入
        //Scanner input = new Scanner(System.in);
        //int intValue = input.nextInt();

        //格式化输出：System.out.printf()
        //格式和C一样

        //直接量
        //正常情况下自动匹配数据类型
        //整数默认为int型 若声明long型整型直接量 数字后加L 如2147483648L
        //浮点型直接量带小数点默认为double型 若声明float型 数字后加F

        //数值类型转换
        //不同类型操作数二元运算时 总是进行类型拓宽的转换后再进行计算
        //不进行类型转换的计算则以原类型进行 如System.out.println(1 / 2) 输出为0 正常输出0.5应编码如 System.out.println((double)1 / 2)

        //尽量不要进行两个浮点数是否相等的判断 机器数有精度误差

        //boolean类型
        //&&与 ||或 ^异或

        //char类型
        //char letter = 'A'

        //String类型
        //String message = "Welcome"
        //长度：message.length()
        //获取字符：message.charAt(0) 即'W'
        //连接：String s3 = s1.concat(s2) 或 String s3 = s1 + s2
        //从控制台读字符串：
        //String s1 = input.next() 读取以空白字符结束的字符串
        //String s2 = input.nextLine() 读取一行文本
        //字符串比较：equals(s1)等 P113 不能用 '=='
        //提取子串：substring(beginIndex, endIndex) 更多方法见P115
        //类型转换：Integer.parseInt

        //三元操作符
        //boolean-expression ? expression1 : expression2
        //布尔为true执行exp1 为false执行exp2

        //操作符优先级表P90

        //Unix时间戳
        //System.currentTimeMillis()方法返回1970.1.1 00:00:00至现在的毫秒数
        //可以用该返回值%10产生随机数

        //增强赋值操作符
        //如+= -=等 在表达式中所有其他操作符计算完成后执行


        //选择结构
        //swith语句
        //switch()中可以是char byte short int String类型
        //case()中必须和switch()中数据类型相同 必须为常量

        //while循环
        /*
        int i = 0;
        while(i < 10){
            i++;
        }
        */

        //输入重定向
        //java ClassName < input.txt
        //输出重定向
        //java ClassName > output.txt
        //同时使用
        //java ClassName <input.txt> output.txt

        //do-while循环
        /*
        int i = 0;
        do{
            i++;
        }while(i < 100)
        */
        //至少执行一次

        //for循环
        //和C一样

        //while和for称为前测循环
        //do-while称为后测循环


    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
