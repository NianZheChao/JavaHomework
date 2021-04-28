package com.company;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class LAB4 {
    class Rectangle {
        double width = 1, height = 1;

        Rectangle(double x, double y) {
            width = x;
            height = y;
        }

        double getAear() {
            return width * height;
        }

        double getPerimeter() {
            return (width + height) * 2;
        }
    }

    public void LAB4_1() {
        Rectangle rectangle1 = new Rectangle(4, 40);
        System.out.print("the width:" + rectangle1.width + ",the height:" + rectangle1.height);
        System.out.println("the area:" + rectangle1.getAear() + ",the perimeter:" + rectangle1.getPerimeter());
        Rectangle rectangle2 = new Rectangle(3.5, 39.5);
        System.out.print("the width:" + rectangle2.width + ",the height:" + rectangle2.height);
        System.out.println("the area:" + rectangle2.getAear() + ",the perimeter:" + rectangle2.getPerimeter());
    }

    class Stock {
        String symbol, name;
        double previousClosingPrice = 34.5, currentPrice;

        Stock(String s, String s1) {
            symbol = s;
            name = s1;
        }

        double getChangePercent() {
            return (currentPrice - previousClosingPrice) / previousClosingPrice;
        }

    }

    public void LAB4_2() {
        Scanner input = new Scanner(System.in);
        Stock stock = new Stock("ORCL", "OracleCorporation");
        System.out.print("enter the current price: ");
        stock.currentPrice = input.nextDouble();
        System.out.println("the percent is " + stock.getChangePercent() + "%");
    }

    public void LAB4_3() {
        java.util.Date date = new java.util.Date();
        date.setTime(10000);
        System.out.println(date);
        date.setTime(100000);
        System.out.println(date);
        date.setTime(1000000);
        System.out.println(date);
        date.setTime(10000000);
        System.out.println(date);
        date.setTime(100000000);
        System.out.println(date);
        date.setTime(1000000000);
        System.out.println(date);
        date.setTime(10000000000l);
        System.out.println(date);
        date.setTime(100000000000l);
        System.out.println(date);
    }

    public void LAB4_4() {
        Random random1 = new Random(1000);
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(random1.nextInt(100) + " ");
        }
    }

    public void LAB4_5() {
        GregorianCalendar date = new GregorianCalendar();
        System.out.print(date.get(GregorianCalendar.YEAR) + "-");
        System.out.print(date.get(GregorianCalendar.MONTH) + "-");
        System.out.println(date.get(GregorianCalendar.DAY_OF_MONTH));
        date.setTimeInMillis(1234567898765L);
        System.out.print(date.get(GregorianCalendar.YEAR) + "-");
        System.out.print(date.get(GregorianCalendar.MONTH) + "-");
        System.out.println(date.get(GregorianCalendar.DATE));
    }

    class Stopwatch {
        java.util.Date date = new java.util.Date();
        private long startTime, endTime;

        Stopwatch() {
            startTime = date.getTime();
        }

        void start() {
            startTime = date.getTime();
        }

        void stop() {
            endTime = date.getTime();
        }

        long getElapsedTime() {
            return endTime - startTime;
        }
    }

    public void LAB4_6() {
        Stopwatch time = new Stopwatch();
        System.out.println("the time is " + time.getElapsedTime());
    }

    class Account {
        private int id;
        private double balance;
        private double annualInterestRate;
        private final java.util.Date dateCreated;

        Account() {
            dateCreated = new java.util.Date();
        }

        Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            dateCreated = new java.util.Date();
        }

        int getid() {
            return id;
        }

        double getbalance() {
            return balance;
        }

        double getannualInterestRate() {
            return annualInterestRate;
        }

        void setid(int id) {
            this.id = id;
        }

        void setbalance(double balance) {
            this.balance = balance;
        }

        void setannualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        Date getdateCreated() {
            return dateCreated;
        }

        double getMonthlyInterest() {
            return balance * (annualInterestRate / 100 / 12);
        }

        void withDraw(double amount1) {
            balance -= amount1;
        }

        void deposit(double amount2) {
            balance += amount2;
        }
    }

    public void LAB4_7() {
        Account account = new Account(1122, 20000);
        account.setannualInterestRate(4.5);
        account.withDraw(2500);
        account.deposit(3000);
        System.out.println(account.getbalance());
        System.out.println("Monthly interest: " + account.getMonthlyInterest());
        System.out.println(account.getdateCreated());
    }

    static class Fan {
        int SLOW = 1;
        static int MEDIUM = 2;
        static int FAST = 3;
        private int speed = SLOW;
        private boolean on = false;
        private double radius = 5;
        String color = "blue";

        int getspeed() {
            return speed;
        }

        boolean geton() {
            return on;
        }

        double getradius() {
            return radius;
        }

        String getcolor() {
            return color;
        }

        void setspeed(int speed) {
            this.speed = speed;
        }

        void seton(boolean on) {
            this.on = on;
        }

        void setradius(double radius) {
            this.radius = radius;
        }

        void setcolor(String color) {
            this.color = color;
        }

        Fan() {
        }

        public String toString() {
            if (on == true) {
                System.out.println("the speed of the fan is " + speed);
                System.out.println("the color of the fan is " + color);
                System.out.println("the radius of the fan is " + radius);
            } else
                System.out.println("fan is off");
            return color;
        }
    }

    public void LAB4_8() {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        System.out.println("the fan1:");
        fan1.setspeed(Fan.FAST);
        fan1.setradius(10);
        fan1.setcolor("yellow");
        fan1.seton(true);
        fan1.toString();
        System.out.println("the fan2:");
        fan2.setspeed(Fan.MEDIUM);
        fan2.setradius(5);
        fan2.setcolor("blue");
        fan2.seton(false);
        fan2.toString();
    }

    class RegularPolygon {
        private int n = 3;
        private double side = 1;
        private double x = 0;
        private double y = 0;

        RegularPolygon() {
        }

        RegularPolygon(int n, double side) {
            this.n = n;
            this.side = side;
        }

        RegularPolygon(int n, double side, double x, double y) {
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }

        int getn() {
            return n;
        }

        double getside() {
            return side;
        }

        double getx() {
            return x;
        }

        double gety() {
            return y;
        }

        void setn(int n) {
            this.n = n;
        }

        void setside(double side) {
            this.side = side;
        }

        void setx(double x) {
            this.x = x;
        }

        void sety(double y) {
            this.y = y;
        }

        double getPerimeter() {
            return n * side;
        }

        double getArea() {
            return (n * side * side) / (4 * Math.tan(Math.PI / n));
        }
    }

    public void LAB4_9() {
        RegularPolygon polygon1 = new RegularPolygon();
        System.out.println("the polygon1:");
        System.out.println(polygon1.getPerimeter());
        System.out.println(polygon1.getArea());
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        System.out.println("the polygon2:");
        System.out.println(polygon2.getPerimeter());
        System.out.println(polygon2.getArea());
        RegularPolygon polygon3 = new RegularPolygon(6, 4, 5.6, 7.8);
        System.out.println("the polygon3:");
        System.out.println(polygon3.getPerimeter());
        System.out.println(polygon3.getArea());
    }

    class QuadraticEquation {
        private final double a;
        private final double b;
        private final double c;

        QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double geta(double a) {
            return a;
        }

        double getb(double b) {
            return b;
        }

        double getc(double c) {
            return c;
        }

        double getDiscriminant() {
            return b * b - 4 * a * c;
        }

        double getRoot1() {
            if (getDiscriminant() < 0)
                return 0;
            else
                return -b + Math.sqrt(getDiscriminant()) / a / 2;
        }

        double getRoot2() {
            if (getDiscriminant() < 0)
                return 0;
            else
                return -b - Math.sqrt(getDiscriminant()) / a / 2;
        }
    }

    public void LAB4_10() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double discriminant = equation.getDiscriminant();
        if (discriminant < 0) {
            System.out.println("The equation has no roots");
        } else if (discriminant == 0) {
            System.out.println("The root is " + equation.getRoot1());
        } else {
            System.out.println("The roots are " + equation.getRoot1()
                    + " and " + equation.getRoot2());
        }
    }

    class LinearEquation {
        private final double a;
        private final double b;
        private final double c;
        private final double d;
        private final double e;
        private final double f;

        LinearEquation(double a, double b, double c, double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        double geta(double a) {
            return a;
        }

        double getb(double b) {
            return b;
        }

        double getc(double c) {
            return c;
        }

        double getd(double d) {
            return d;
        }

        double gete(double e) {
            return e;
        }

        double getf(double f) {
            return f;
        }

        boolean isSolvable() {
            return a * d - b * c != 0;
        }

        double getx() {
            return (e * d - b * f) / (a * d - b * c);
        }

        double gety() {
            return (a * f - e * c) / (a * d - b * c);
        }
    }

    public void LAB4_11() {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        if (equation.isSolvable()) {
            System.out.println("x is " +
                    equation.getx() + " and y is " + equation.gety());
        } else
            System.out.println("The equation has no solution");
    }

    public void LAB4_12() {
        Scanner input = new Scanner(System.in);
        double x1, y1, x2, y2;
        double x3, y3, x4, y4;
        double a, b, c, d, e, f;
        System.out.println("enter two points:");
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        System.out.println("enter another two points:");
        x3 = input.nextDouble();
        y3 = input.nextDouble();
        x4 = input.nextDouble();
        y4 = input.nextDouble();
        a = y1 - y2;
        b = x2 - x1;
        e = x1 * (y1 - y2) + y1 * (x2 - x1);
        c = y3 - y4;
        d = x4 - x3;
        f = x3 * (y3 - y4) + y3 * (x4 - x3);
        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        if (equation.isSolvable()) {
            System.out.println("The intersecting point is: (" +
                    equation.getx() + ", " + equation.gety() + ")");
        } else {
            System.out.println("The two lines do not cross ");
        }
    }

    static class Location {
        static int row;
        static int column;
        static double maxValue;

        public static Location locateLargest(double[][] a) {
            maxValue = a[0][0];
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] > maxValue) {
                        maxValue = a[i][j];
                        row = i;
                        column = j;
                    }
                }
            System.out.println("the location of the largest element is " + maxValue + "at (" + row + "," + column + ")");
            return null;
        }
    }

    public void LAB4_13() {
        Scanner input = new Scanner(System.in);
        System.out.print
                ("Enter the number of rows and columns of the array: ");
        int numberOfRows = input.nextInt();
        int numberOfColumns = input.nextInt();
        double[][] a = new double[numberOfRows][numberOfColumns];
        System.out.println("Enter the array: ");
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = input.nextDouble();
        Location location = new Location();
        Location.locateLargest(a);
    }

    public static void main(String[] args) {

    }
}
