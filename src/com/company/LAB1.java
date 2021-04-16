package com.company;

import java.util.Random;
import java.util.Scanner;

public class LAB1 {
    static void test(){
        System.out.println("hello");
    }
    static void LAB1_1(){
        System.out.println("a\t\ta^2\t\ta^3");
        for (int i = 1;i < 5;i++){
            System.out.println(i + "\t\t" + i*i + "\t\t" + i*i*i);
        }
    }

    static void LAB1_2(){
        int res = 1;
        System.out.print("1");
        for (int i = 2; i < 9; i++) {
            res += i;
            System.out.print("+" + i);
        }
        res += 9;
        System.out.print("+9=" + res);
    }

    static void LAB1_3(){
        double pi = 1 ,temp = 3, t = -1;
        while (temp < 100000){
            pi += t / temp;
            temp += 2;
            t *= -1;
        }
        pi *= 4;
        System.out.println(pi);
    }

    static void LAB1_4(){
        double plus = 60.0*60*24 / 7 + 60.0*60*24 / 45;
        double sub = 60.0*60*24 / 13;
        int num = 312032486;
        for (int i = 1; i < 6; i++) {
            num = (int)(plus - sub) * 365 + num;
            System.out.println("the " + i + " year:" + num);
        }
    }

    static void LAB1_5(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int res = num/100 + num%10 + num/10%10;
        System.out.println(res);
    }

    static void LAB1_6(){
        Scanner input = new Scanner(System.in);
        System.out.println("weight: ");
        double W = input.nextDouble();
        System.out.println("initial temperature: ");
        double IT = input.nextDouble();
        System.out.println("final temperature: ");
        double FT = input.nextDouble();
        double E = (FT - IT) * W * 4184;
        System.out.println("Energy needed: " + (int)E);
    }

    static void LAB1_7(){
        Scanner input = new Scanner(System.in);
        System.out.print("speed: ");
        double V = input.nextDouble();
        System.out.print("acceleration: ");
        double a = input.nextDouble();
        System.out.println("min runway length: " + V * V / (2 * a));
    }

    static void LAB1_8(){
        Scanner input = new Scanner(System.in);
        double amount = 0;
        System.out.print("amount each month: ");
        double each = input.nextDouble();
        System.out.print("interest rate: ");
        double rate = input.nextDouble();
        rate /= 1200;
        System.out.print("months: ");
        int month = input.nextInt();

        for (int i = 0; i < month; i++) {
            amount += each;
            amount *= (1+rate);
        }
        System.out.println("After" + month + "months, account value is " + amount);
    }
    static void LAB1_9(){
        System.out.print("weight: ");
        Scanner input = new Scanner(System.in);
        double w = input.nextDouble();
        System.out.print("height: ");
        double h = input.nextDouble();
        w *= 0.45359237;
        h *= 0.0254;
        System.out.println("BMI: " + w/(h*h));
    }
    static void LAB1_10(){
        Scanner input = new Scanner(System.in);
        System.out.print("side: ");
        double s = input.nextDouble();
        System.out.println("area: " + (3*Math.sqrt(3)/2)*s*s);

    }
    static void LAB1_11(){
        Scanner input = new Scanner(System.in);
        System.out.print("balance and annual interest rate: ");
        double b = input.nextDouble();
        double r = input.nextDouble();
        System.out.printf("interest: %.3f",b*(r/1200));
    }
    static void LAB1_12(){
        Scanner input = new Scanner(System.in);
        System.out.print("enter a b c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double delta = b * b - 4 * a * c;
        if (delta > 0){
            System.out.println("roots: " + ((-1 * b)-Math.pow(delta,0.5))/2*a + " and " + ((-1 * b)+Math.pow(delta,0.5))/2*a);
        }
        else if(delta == 0){
            System.out.println("root: "+ (-1 * b)/2*a);
        }
        else{
            System.out.println("no real root");
        }
    }
    static void LAB1_13(){
        Random rand = new Random();
        int a = rand.nextInt(9), b = rand.nextInt(9), c = rand.nextInt(9);
        System.out.println("three numbers are:" + a +" " + b +" "+ c);
        System.out.print("guess: ");
        Scanner input = new Scanner(System.in);
        int res = input.nextInt();
        if (res == a+b+c){
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
    }
    static void LAB1_14(){
        Scanner input = new Scanner(System.in);
        int ISBN = input.nextInt(), res = 0, temp = 9;
        int I = ISBN;
        System.out.println(I);
        //todo: the begin zero input processing
        for (int i = 0; i < 9; i++) {
            res += ISBN % 10 * temp;
            ISBN /= 10;
            temp--;
        }
        res %= 11;
        if(res == 10){
            System.out.println(I + "X");
        }
        else {
            System.out.print(I);
            System.out.print(res);
        }
    }
    static void LAB1_15(){
        Scanner input = new Scanner(System.in);
        System.out.print("plz input a three-digit integer: ");
        int n = input.nextInt();
        if(n % 10 == n / 100){
            System.out.println("Right");
        }
        else{
            System.out.println("Wrong");
        }
    }
    static void LAB1_16(){
        Scanner input = new Scanner(System.in);
        System.out.print("scissor(0), rock(1), paper(2): ");
        Random rand = new Random();
        int R = rand.nextInt(3), r = input.nextInt();
        if(R == 0 && r == 0){
            System.out.println("scissor to scissor, draw!");
        }
        else if(R == 1 && r == 1){
            System.out.println("rock to rock, draw!");
        }
        else if(R == 2 && r == 2){
            System.out.println("paper to paper, draw!");
        }
        else if(R == 0 && r == 1){
            System.out.println("scissor to rock, win!");
        }
        else if(R == 0 && r == 2){
            System.out.println("scissor to paper, lose!");
        }
        else if(R == 1 && r == 0){
            System.out.println("rock to scissor, lose!");
        }
        else if(R == 1 && r == 2){
            System.out.println("rock to paper, win!");
        }
        else if(R == 2 && r == 0){
            System.out.println("paper to scissor, win!");
        }
        else if(R == 2 && r == 1){
            System.out.println("paper to rock, lose!");
        }
    }
    static void LAB1_17(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year(e.g.2012): ");
        int y = input.nextInt();
        System.out.print("Enter month(1-12): ");
        int m = input.nextInt();
        System.out.print("Enter the day of the month(1-31): ");
        int d = input.nextInt();
        if (m < 3) {m += 12; y--;}
        int q = d + (26*(m+1)/10) + y%100 + y%100/4 + y/400 + 5*y/100;
        q %= 7;
        if(q == 0){
            System.out.println("It's Saturday");
        }
        else if(q == 1){
            System.out.println("It's Sunday");
        }
        else if(q == 2){
            System.out.println("It's Monday");
        }
        else if(q == 3){
            System.out.println("It's Tuesday");
        }
        else if (q == 4){
            System.out.println("It's Wednesday");
        }
        else if (q == 5){
            System.out.println("It's Thursday");
        }
        else if(q == 6){
            System.out.println("It's Friday");
        }
    }
    static void LAB1_18(){
        Random rand = new Random();
        int number = rand.nextInt(13);
        int color = rand.nextInt(4);
        System.out.print("The card you picked is ");
        if (number < 10){
            System.out.print(number+1 + " ");
        }
        else if (number == 10) System.out.print("Jack ");
        else if (number == 11) System.out.print("Queen ");
        else if (number == 12) System.out.print("King ");
        if (color == 0) System.out.print("of Clubs.");
        else if (color == 1) System.out.print("of Diamonds.");
        else if (color == 2) System.out.print("of Hearts.");
        else System.out.print("of Spades.");
    }
    static void LAB1_19(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();
        if ((num%5==0) && (num%6==0)){
            System.out.println("both can");
        }
        if ((num%5==0) || (num%6==0)){
            System.out.println("at least one can");
        }
        if ((num%5==0)^(num%6==0)){
            System.out.println("one can but another can't");
        }
    }
    static void LAB1_20(){
        Scanner input = new Scanner(System.in);
        System.out.print("exchange rate from dollars to RMB:");
        double r = input.nextDouble();
        System.out.print("0:dollars to RMB; 1:vice versa;");
        int d = input.nextInt();
        System.out.print("Enter your amount:");
        double a = input.nextDouble();
        if (d==0){
            a *= r;
        }
        else a/=r;
        System.out.println("After exchange: " + a);
    }
    static void LAB1_21(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three points for p0, p1 and p2:");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double res = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        if (res > 0) System.out.println("Left side");
        else if (res < 0) System.out.println("Right side");
        else System.out.println("just on");
    }


    public static void main(String[] args) {
        LAB1_21();
    }
}
