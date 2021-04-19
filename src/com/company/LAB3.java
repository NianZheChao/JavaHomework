package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class LAB3 {
    public static void LAB3_1(int n){  //getPentagonalNumber(int n)
        for (int i = 1; i < n+1; i++) {
            System.out.print(i*(3*i-1)/2 + "  ");
            if (i % 10 == 0) System.out.print("\n");
        }
    }
    public static void LAB3_2(long n){  //sumDigits(long n)
        long m = 0, sum = 0;
        while(n > 0){
            m = n % 10;
            sum += m;
            n /= 10;
        }
        System.out.println(sum);
    }
    public static class footMeterTrans{
        public static double footToMeters(double foot){
            double meter;
            meter = foot * 0.305;
            return meter;
        }
        public static double meterToFoot(double meter){
            double foot;
            foot = meter * 3.279;
            return foot;
        }
        public static void table(){
            System.out.println("inch\tmeter\t\tmeter\tinch");
            for (int i = 0; i < 10; i++) {
                System.out.println(i+"\t\t"+footToMeters(i)+"\t\t\t"+i+"\t\t"+meterToFoot(i));
            }
        }
    }
    public static void LAB3_4(char ch1, char ch2, int numberPerLine){  //printfChars
        int i = 0;
        while (ch2>=ch1){
            System.out.print(ch1+ " ");
            ch1++;
            i++;
            if (i % 10 == 0) System.out.print("\n");
        }
    }
    public static void LAB3_5(double i){
        System.out.println("i\tm(i)");
        for (double j = 1; j < i + 1; j++) {
            double sum = 0, temp = j;
            while (temp >= 1){
                sum += temp / (temp + 1);
                temp--;
            }
            System.out.printf("%.0f\t%.4f\n",j,sum);
        }
    }
    public static void LAB3_6(int n){ //printMatrix(int n)
        Random r = new Random(1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rand = r.nextInt(2);
                System.out.print(rand + " ");
            }
            System.out.print("\n");
        }
    }
    public static void LAB3_7(String n){
        int num = 0;
        if (n.length() < 8) {
            System.out.println("Invalid Password");
            return;
        }
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i)) && !Character.isLetter(n.charAt(i))){
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
    public static void main(String[] args) {
        //LAB3_1(100);
        //LAB3_2(234);
        //footMeterTrans.table();
        //LAB3_4('l','z',10);
        //LAB3_5(20);
        //LAB3_6(3);
        LAB3_7("test1235");
    }
}
