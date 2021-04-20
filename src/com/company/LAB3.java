package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class LAB3 {
    public static void LAB3_1(int n) {  //getPentagonalNumber(int n)
        for (int i = 1; i < n + 1; i++) {
            System.out.print(i * (3 * i - 1) / 2 + "  ");
            if (i % 10 == 0) System.out.print("\n");
        }
    }

    public static void LAB3_2(long n) {  //sumDigits(long n)
        long m = 0, sum = 0;
        while (n > 0) {
            m = n % 10;
            sum += m;
            n /= 10;
        }
        System.out.println(sum);
    }

    public static class footMeterTrans {
        public static double footToMeters(double foot) {
            double meter;
            meter = foot * 0.305;
            return meter;
        }

        public static double meterToFoot(double meter) {
            double foot;
            foot = meter * 3.279;
            return foot;
        }

        public static void table() {
            System.out.println("inch\tmeter\t\tmeter\tinch");
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "\t\t" + footToMeters(i) + "\t\t\t" + i + "\t\t" + meterToFoot(i));
            }
        }
    }

    public static void LAB3_4(char ch1, char ch2, int numberPerLine) {  //printfChars
        int i = 0;
        while (ch2 >= ch1) {
            System.out.print(ch1 + " ");
            ch1++;
            i++;
            if (i % 10 == 0) System.out.print("\n");
        }
    }

    public static void LAB3_5(double i) {
        System.out.println("i\tm(i)");
        for (double j = 1; j < i + 1; j++) {
            double sum = 0, temp = j;
            while (temp >= 1) {
                sum += temp / (temp + 1);
                temp--;
            }
            System.out.printf("%.0f\t%.4f\n", j, sum);
        }
    }

    public static void LAB3_6(int n) { //printMatrix(int n)
        Random r = new Random(1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rand = r.nextInt(2);
                System.out.print(rand + " ");
            }
            System.out.print("\n");
        }
    }

    public static void LAB3_7(String n) {
        int num = 0;
        if (n.length() < 8) {
            System.out.println("Invalid Password");
            return;
        }
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i)) && !Character.isLetter(n.charAt(i))) {
                System.out.println("Invalid Password");
                return;
            }
            if (!Character.isDigit(n.charAt(i))) num++;
        }
        if (num > 1)
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
        return;
    }

    public static double LAB3_8(long n){  //double sqrt(long n)
        double tem = 1, nextGuess = 1, lastGuess = 1;
        while (tem>0.00001){
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
            tem = Math.abs(lastGuess-nextGuess);
        }
        return nextGuess;
    }

    public static boolean isPrime(int n){
        if(n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n%i==0) return false;
        }
        return true;
    }
    public static void LAB3_9(int p){
        System.out.println("p\t\t2^p-1");
        for (int i = 2; i <= p; i++) {
            if (isPrime(i))
                System.out.println(i + "\t" + (Math.pow(2,i)-1));
        }
    }

    public static void LAB3_10(int n){
        for (int i = 4; i < n+1; i++) {
            if (isPrime(i) && isPrime(i-2))
                System.out.println("("+(i-2)+","+i+")");
        }
    }

    public static void LAB3_11(){
        Random r = new Random(5);
        int a = r.nextInt(7),b = r.nextInt(7),c=0,d=0;
        System.out.println("first toss:"+a+" and "+b);
        if (a+b==2||a+b==3||a+b==12){
            System.out.println("lose with "+ a +" and "+ b);
        }
        else if (a+b==7||a+b==11)
            System.out.println("win with "+a+" and "+b);
        else {
            while (c+d!=a+b||c+d!=7){
                c = r.nextInt(7);d = r.nextInt(7);
                if (c+d==a+b){
                    System.out.println("win with another toss:"+c+" and "+d);
                    return;
                }
                else if (c+d==7){
                    System.out.println("lose with another toss:"+c+" and "+d);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        //LAB3_1(100);
        //LAB3_2(234);
        //footMeterTrans.table();
        //LAB3_4('l','z',10);
        //LAB3_5(20);
        //LAB3_6(3);
        //LAB3_7("test1235");
        //System.out.println(LAB3_8(10));
        //LAB3_9(31);
        //LAB3_10(1000);
        LAB3_11();
    }
}
