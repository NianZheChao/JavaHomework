package com.company;

import java.util.*;

public class LAB2 {

    static void LAB2_1() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter point1 in degrees: ");
        double latitude1 = in.nextDouble();
        double longitude1 = in.nextDouble();
        System.out.print("enter point2 in degrees: ");
        double latitude2 = in.nextDouble();
        double longitude2 = in.nextDouble();
        double radium = 6371.01;
        double distance = radium * Math.acos(Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) +
                Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(longitude1 - longitude2)));
        System.out.println("the distance between the two points is " + distance + " km");
    }

    static void LAB2_2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an ASCII code:");
        int a = input.nextInt();
        if (a > 0 && a <= 127) {
            System.out.printf("The character for ASCII code %d is %<c\r\n", a);
        }
    }

    static void LAB2_3() {
        //todo:another way to solve this question without so many lib functions.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter hex number:");
        String hexstr = input.next();

        Integer num = Integer.parseInt(hexstr, 16);
        System.out.println(Integer.toBinaryString(num));
        input.close();
    }

    static void LAB2_4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an uppercase letter: ");
        String a = input.nextLine();
        char ch = a.charAt(0);
        if (Character.isLetter(ch)) {
            ch = Character.toLowerCase(ch);
            if (ch >= 'a' && ch <= 'c')
                System.out.println("2");
            else if (ch >= 'd' && ch <= 'f')
                System.out.println("3");
            else if (ch >= 'g' && ch <= 'i')
                System.out.println("4");
            else if (ch >= 'j' && ch <= 'l')
                System.out.println("5");
            else if (ch >= 'm' && ch <= 'o')
                System.out.println("6");
            else if (ch >= 'p' && ch <= 's')
                System.out.println("7");
            else if (ch >= 't' && ch <= 'v')
                System.out.println("8");
            else if (ch >= 'w' && ch <= 'z')
                System.out.println("9");
        } else
            System.out.println(ch + " is an invalid input.");
    }

    static void LAB2_5() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter a year: ");
        int year = in.nextInt();
        System.out.print("enter a month: ");
        String month = in.next();
        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                System.out.println(month + " " + year + " " + "has 31 days");
                break;
            case "Feb":
                System.out.println(month + " " + year + " " + "has 29 days");
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                System.out.println(month + " " + year + " " + "has 30 days");
                break;
        }
    }

    static void LAB2_6() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter a SSN: ");
        String s = in.nextLine();
        if (s.charAt(3) == '-' && s.charAt(6) == '-')
            System.out.println(s + " is a valid social security number.");
        else
            System.out.println(s + " is an invalid social security number.");
    }

    static void LAB2_7() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter string s1: ");
        String s1 = in.nextLine();
        System.out.print("enter string s2: ");
        String s2 = in.nextLine();
        if (s1.contains(s2))
            System.out.println(s2 + " is a substring of " + s1);
        else
            System.out.println(s2 + " is not a substring of " + s1);
    }

    static void LAB2_8() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter employee's name: ");
        String name = in.nextLine();
        System.out.print("enter number of hours worked in a week: ");
        int time = in.nextInt();
        System.out.print("enter hourly pay rate: ");
        double rate = in.nextDouble();
        System.out.print("enter federal tax withholding rate: ");
        double rate1 = in.nextDouble();
        System.out.print("enter state tax withholding rate: ");
        double rate2 = in.nextDouble();
        System.out.println(" ");
        System.out.println("employee name: " + name);
        System.out.println("hours worked: " + time);
        System.out.println("pay rate: $" + rate);
        System.out.println("gross pay: $" + rate * 10);
        System.out.println("deductions: ");
        System.out.println("federal withdolding(20.0%): $" + rate * 10 * 0.2);
        System.out.println("state withdolding(9.0%): $" + rate * 10 * 0.09);
        System.out.println("total deduction: $" + (rate * 10 * 0.2 + rate * 10 * 0.09));
        System.out.println("net pay : $" + (rate * 10 - (rate * 10 * 0.2 + rate * 10 * 0.09)));
    }

    static void LAB2_9() {
        System.out.println("英里\t千米\t\t千米\t英里");
        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            System.out.printf("%d\t%.3f\t\t%d\t%.3f\n", i, (i * 1.609), j, (j / 1.609));
        }
    }

    static void LAB2_10() {
        Scanner in = new Scanner(System.in);
        int max1 = -1, max2 = -1;
        int num = 0;
        System.out.print("enter the number of students: ");
        num = in.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("the " + (i + 1) + " student's score is ");
            score[i] = in.nextInt();
        }
        for (int i = 0; i < num; i++)
            if (max1 < score[i])
                max1 = score[i];
        for (int i = 0; i < num; i++)
            if (max2 < score[i] && score[i] != max1)
                max2 = score[i];
        System.out.println("these " + num + "students's highest score is " + max1 + " the secode is " + max2);
    }

    static void LAB2_11() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i;
        for (i = 2; i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                if (n != 1)
                    System.out.print(i + "  ");
                else
                    System.out.print(i);

            }
        }
    }

    static void LAB2_12() {
        for (int i = 1; i < 9; i++) {
            print(i);
        }
    }

    public static void print(int i) {
        for (int j = 0; j < 8 - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i - 1; j++) {
            System.out.print(1 << j);
        }
        System.out.print(1 << (i - 1));
        for (int j = 0; j < i - 1; j++) {
            System.out.print((1 << (i - 1)) >> (j + 1));
        }
        System.out.println();
    }

    static void LAB2_13() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter loan amount: ");
        double amount = in.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int years = in.nextInt();
        System.out.print("Enter yearly interest rate: ");
        double rate = in.nextDouble();
        double monthrate = rate / 12 / 100;
        double MonthlyPayment = 865.26;
        double TotalPayment = 10383.2;
        System.out.println("MonthlyPayment: " + MonthlyPayment);
        System.out.println("TotalPayment: " + TotalPayment);
        for (int i = 1; i <= years * 12; i++) {
            double interest = monthrate * amount;
            double principal = MonthlyPayment - interest;
            amount = amount - principal;
            System.out.print(i + "\t\t" + interest + "\t\t" + principal + "\t\t" + amount + "\n");
        }
    }

    static void LAB2_14() {
        double i = 1.0;
        double sum = 0;
        for (i = 1.0; i <= 97; i += 2) {
            sum += i / (i + 2);
        }
        System.out.println("sum=" + sum);
    }

    static void LAB2_15() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the year: ");
        int year = in.nextInt();
        int sum = 0;
        int[] day = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            for (int i = 2; i <= 12; i++)
                day[i]++;
        String[] Week = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        for (int i = 1; i <= 12; i++) {
            sum = 0;
            sum = year - 1;
            sum = sum + sum / 4 - sum / 100 + sum / 400;
            sum = sum + day[i - 1];
            sum += 1;
            sum = sum % 7;
            System.out.println(year + "year " + i + "month 1th is " + Week[sum]);
        }
    }

    static void LAB2_16() {
        int sum = 0;
        for (int i = 6; i <= 10000; i++) {
            sum = 0;
            for (int j = 1; j < i; j++)
                if (i % j == 0)
                    sum += j;
            if (sum == i)
                System.out.println(i + "是完全数");
        }
    }

    static void LAB2_17() {
        Scanner in = new Scanner(System.in);
        System.out.print("输入一个十进制数");
        int i = 0;
        int data = 0;
        data = in.nextInt();
        System.out.print("十进制数" + data + "转八进制为");
        fun(data);
    }

    static void fun(int n) {
        if (n / 8 != 0)
            fun(n / 8);
        System.out.print(n % 8);
    }

    static void LAB2_18() {
        double a = 0;
        double sum = 0;
        for (a = 0.1; sum < 30000; a += 0.1) {
            sum = 0;
            if (a <= 5000)
                sum += 5000 + 5000 * 0.08;
            if (a > 5000 && a <= 10000)
                sum += a - 5000 + (a - 5000) * 0.10;
            if (a > 10000)
                sum += (a - 10000) + (a - 10000) * 0.12;
        }
        System.out.println("销售额为" + a + "时，工资为" + sum);
    }

    static void LAB2_19() {
        Scanner in = new Scanner(System.in);
        int max = 0;
        int count = 1;
        int num = 0;
        System.out.print("enter numbers: ");
        while (true) {
            num = in.nextInt();
            if (num == 0)
                break;
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num)
                count++;
        }
        System.out.println("the largest number is " + max + " the count is " + count);
    }

    static void LAB2_20() {

    }

    static void LAB2_21() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the first 12 digits of an ISBN-13 as a string: ");
        String s = in.nextLine();
        int sum1 = 0, sum2 = 0, sum = 0;
        int i;
        for (i = 0; i < s.length() - 1; i += 2)
            sum1 += s.charAt(i);
        for (i = 1; i < s.length(); i += 2)
            sum2 += 3 * (s.charAt(i));
        sum = sum1 + sum2;
        int d13 = 10 - sum % 10;
        if (d13 == 10)
            d13 = 0;
        System.out.println("the ISBN-13 number is " + s + d13);
    }

    public static void main(String[] args) {
        LAB2_1();
    }
}