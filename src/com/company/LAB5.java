package com.company;

import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LAB5 {
    class Time {
        int hour, minute, second;

        Time() {
            this(System.currentTimeMillis());
        }

        Time(long passtime) {
            setTime(passtime);
        }

        Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        int gethour() {
            return hour;
        }

        int getminute() {
            return minute;
        }

        int getsecond() {
            return second;
        }

        void setTime(long passtime) {
            long totalseconds = passtime / 1000;
            second = (int) totalseconds % 60;
            long totalminutes = totalseconds / 60;
            minute = (int) totalminutes % 60;
            long totalhours = totalminutes / 60;
            hour = (int) totalhours % 24;
        }
    }

    void LAB5_1() {
        Time time1 = new Time();
        System.out.println("hour " + time1.gethour() + " minutes: " + time1.getminute() + " seconds: " + time1.getsecond());
        Time time2 = new Time(555550000);
        System.out.println("hour " + time2.gethour() + " minutes: " + time2.getminute() + " seconds: " + time2.getsecond());
    }

    class MyInteger {
        int value;

        MyInteger(int value) {
            this.value = value;
        }

        int getvalue() {
            return value;
        }

        boolean isEven(int value) {
            return value % 2 == 0;
        }

        boolean isOdd(int value) {
            return value % 2 != 0;
        }

        boolean isPrime(int value) {
            if (value == 1 || value == 2)
                return true;
            for (int i = 2; i < value / 2; i++) {
                if (value % 2 == 0)
                    return false;
            }
            return true;
        }

        boolean equals(int value) {
            return this.value == value;
        }

        boolean isEven(MyInteger n) {
            return n.getvalue() % 2 == 0;
        }

        boolean isOdd(MyInteger n) {
            return n.getvalue() % 2 != 0;
        }

        boolean isPrime(MyInteger n) {
            if (n.getvalue() == 1 || n.getvalue() == 2)
                return true;
            for (int i = 2; i < n.getvalue() / 2; i++) {
                if (n.getvalue() % 2 == 0)
                    return false;
            }
            return true;
        }

        boolean equals(MyInteger n) {
            return this.value == n.getvalue();
        }

        int parselnt(char[] numbers) {
            int num = 0;
            for (int i = 0; i < numbers.length; i++)
                num = num * 10 + (numbers[i] - '0');
            return num;
        }

        int parselnt(String s) {
            int num = 0;
            for (int i = 0; i < s.length(); i++)
                num = num * 10 + (s.charAt(i) - '0');
            return num;
        }
    }

    void LAB5_2() {
        MyInteger m1 = new MyInteger(5);
        System.out.println(m1.getvalue());
        System.out.println(m1.isEven(5));
        System.out.println(m1.isOdd(5));
        System.out.println(m1.isPrime(5));
        System.out.println(m1.equals(5));
    }

    static class MyPoint {
        private double x;
        private double y;

        public MyPoint() {
        }

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance(MyPoint secondPoint) {
            return distance(this, secondPoint);
        }

        public static double distance(MyPoint p1, MyPoint p2) {
            return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
                    * (p1.y - p2.y));
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    void LAB5_3() {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.distance(p1, p2));
    }

    class StackofIntegers {
        int number;

        int[] factor(int number) {
            int i, j = 0;
            int[] factors = new int[100];
            for (i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    for (int k = 2; k < Math.sqrt(i); k++) {
                        if (i % k == 0)
                            break;
                        else {
                            if (i == k)
                                factors[j] = i;
                        }
                    }
                    j++;
                }
            }
            return factors;
        }
    }

    void LAB5_4() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a number: ");
        int n = input.nextInt();
        StackofIntegers s = new StackofIntegers();
    }

    void LAB5_6() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\nMain menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("Enter a choice: ");
            choice = input.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Wrong choice, try again: ");
            } else
                break;
        }
    }

    class Tax {
        public final static int SINGLE_FILER = 1;
        public final static int MARRIED_JOINTLY = 2;
        public final static int MARRIED_SEPARATELY = 3;
        public final static int HEAD_OF_HOUSEHOLD = 4;

        private int filingStatus = SINGLE_FILER;

        private int[][] brackets = {
                {27050, 65550, 136750, 297350}, // Single filer
                {45200, 109250, 166500, 297350}, // married filing jointly
                {22600, 54625, 83250, 148675}, // married filing separately
                {36250, 93650, 151650, 297350} // head of household
        };

        private double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
        private double taxableIncome = 100000;

        public Tax() {
        }

        public Tax(int filingStatus, int[][] brackets, double[] rates,
                   double taxableIncome) {
            this.filingStatus = filingStatus;
            this.brackets = brackets;
            this.rates = rates;
            this.taxableIncome = taxableIncome;
        }

        public void setBrackets(int[][] brackets) {
            this.brackets = brackets;
        }

        public void setRates(double[] rates) {
            this.rates = rates;
        }

        public double getTaxableIncome() {
            return taxableIncome;
        }

        public void setTaxableIncome(double taxableIncome) {
            this.taxableIncome = taxableIncome;
        }

        public int getFilingStatus() {
            return filingStatus;
        }

        public void setFilingStatus(int filingStatus) {
            this.filingStatus = filingStatus;
        }

        public double findTax() {
            double tax = 0;

            // Compute tax in the first bracket
            if (taxableIncome <= brackets[filingStatus][0])
                return tax = taxableIncome * rates[0];
            else
                tax = brackets[filingStatus][0] * rates[0];

            int i;

            // Compute tax in the possible 2nd, 3rd, 4th, and 5th brackets
            for (i = 1; i < brackets[0].length; i++) {
                if (taxableIncome > brackets[filingStatus][i])
                    tax += (brackets[filingStatus][i] - brackets[filingStatus][i - 1]) *
                            rates[i];
                else {
                    tax += (taxableIncome - brackets[filingStatus][i - 1]) * rates[i];
                    break;
                }
            }

            // Compute tax in the possible last bracket
            if (i == brackets[0].length && taxableIncome > brackets[filingStatus][i - 1])
                tax += (taxableIncome - brackets[filingStatus][i - 1]) * rates[i];

            return tax;
        }
    }

    void LAB5_7() {
        int[][] bracketsFor2001 = {
                {27050, 65550, 136750, 297350}, // Single filer
                {45200, 109250, 166500, 297350}, // married filing jointly
                {22600, 54625, 83250, 148675}, // married filing separately
                {36250, 93650, 151650, 297350} // head of household
        };

        double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

        int[][] bracketsFor2002 = {
                {6000, 27950, 67700, 141250, 307050}, // Single filer
                {12000, 46700, 112850, 171950, 307050}, // married filing jointly
                {6000, 23350, 56425, 85975, 153525}, // married filing separately
                {10000, 37450, 96700, 156600, 307050} // head of household
        };

        double[] ratesFor2002 = {0.1, 0.15, 0.27, 0.30, 0.35, 0.386};

        Tax taxFor2001 = new Tax(0, bracketsFor2001, ratesFor2001, 50000);
        System.out.println("2001 Tax Table");
        System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
        System.out.println("Income\tSingle\tJoint\tSeparate\ta House");
        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
            taxFor2001.setTaxableIncome(taxableIncome);
            taxFor2001.setFilingStatus(0);
            int taxForStatus0 = (int) taxFor2001.findTax();
            taxFor2001.setFilingStatus(1);
            int taxForStatus1 = (int) taxFor2001.findTax();
            taxFor2001.setFilingStatus(2);
            int taxForStatus2 = (int) taxFor2001.findTax();
            taxFor2001.setFilingStatus(3);
            int taxForStatus3 = (int) taxFor2001.findTax();
            System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
                    taxForStatus1 + "\t" + taxForStatus2 + "\t" +
                    taxForStatus3);
        }

        Tax taxFor2002 = new Tax(0, bracketsFor2002, ratesFor2002, 50000);
        System.out.println("2002 Tax Table");
        System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
        System.out.println("Income\tSingle\tJoint\tSeparate\ta House");
        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
            taxFor2002.setTaxableIncome(taxableIncome);
            taxFor2002.setFilingStatus(0);
            int taxForStatus0 = (int) taxFor2002.findTax();
            taxFor2002.setFilingStatus(1);
            int taxForStatus1 = (int) taxFor2002.findTax();
            taxFor2002.setFilingStatus(2);
            int taxForStatus2 = (int) taxFor2002.findTax();
            taxFor2002.setFilingStatus(3);
            int taxForStatus3 = (int) taxFor2002.findTax();
            System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
                    taxForStatus1 + "\t" + taxForStatus2 + "\t" +
                    taxForStatus3);
        }
    }

    class CourseNew {
        private final String name;
        private String[] students = new String[2];
        private int numberOfStudents;

        public CourseNew(String name) {
            this.name = name;
        }

        public void addStudent(String student) {
            if (numberOfStudents == students.length) {
                increaseSize();
            }
            students[numberOfStudents] = student;
            numberOfStudents++;
        }

        private void increaseSize() {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }

        public String[] getStudents() {
            return students;
        }

        public int getNumberOfStudents() {
            return numberOfStudents;
        }

        public void clear() {
            for (int i = 0; i < numberOfStudents; i++)
                students[i] = null;
            numberOfStudents = 0;
        }

        public void dropStudent(String student) {
            for (int i = 0; i < numberOfStudents; i++) {
                if (students[i].equals(student)) {

                    for (int k = i + 1; k < numberOfStudents; k++) {
                        students[k - 1] = students[k];
                    }

                    numberOfStudents--;
                    break;
                }
            }
        }
    }

    void LAB5_8() {
        CourseNew course1 = new CourseNew("Data Structures");
        CourseNew course2 = new CourseNew("Database Systems");
        course1.addStudent("Peter Jones");
        course1.addStudent("Brian Smith");
        course1.addStudent("Anne Kennedy");
        course1.addStudent("Susan Kennedy");
        course1.addStudent("John Kennedy");
        course1.addStudent("Kim Johnson");
        course1.addStudent("S1");
        course1.addStudent("S2");
        course1.addStudent("S3");
        course1.addStudent("S4");
        course1.addStudent("S5");
        course1.addStudent("S6");
        course1.addStudent("S7");

        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");
        System.out.println("Number of students in course1: "
                + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");
        System.out.println();
        System.out.print("Number of students in course2: "
                + course2.getNumberOfStudents());
        course1.dropStudent("S1");
        System.out.println("Number of students in course1: "
                + course1.getNumberOfStudents());
        students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");
        course1.clear();
        System.out.println("\nNumber of students in course1: "
                + course1.getNumberOfStudents());
    }

    class Queue {
        private int[] elements;
        private int size;

        public Queue() {
            elements = new int[8];
        }

        public void enqueue(int value) {
            if (size >= elements.length) {
                int[] temp = new int[elements.length * 2];
                System.arraycopy(elements, 0, temp, 0, elements.length);
                elements = temp;
            }
            elements[size++] = value;
        }

        public int dequeue() {
            int v = elements[0];
            for (int i = 0; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return v;
        }

        public boolean empty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }
    }

    void LAB5_9() {
        Queue queue = new Queue();
        for (int i = 0; i <= 20; i++)
            queue.enqueue(i);
        while (!queue.empty())
            System.out.print(queue.dequeue() + " ");
    }

    class Circle2D {
        double x, y;
        double radius;

        Circle2D() {
            x = 0;
            y = 0;
            radius = 0;
        }

        Circle2D(double x, double y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        double getx(double x) {
            return x;
        }

        double gety(double y) {
            return y;
        }

        double getradius(double radius) {
            return radius;
        }

        double getAear() {
            return radius * radius * Math.PI;
        }

        double getPerimeter() {
            return 2 * radius * Math.PI;
        }

        boolean contains(double x, double y) {
            return x <= this.radius + this.x && y <= this.radius + this.y;
        }

        boolean contains(Circle2D circle) {
            double distance;
            distance = Math.sqrt((circle.x - this.x) * (circle.x - this.x) + (circle.y - this.y) + (circle.y - this.y));
            return distance <= this.radius;
        }

        boolean overlaps(Circle2D circle) {
            double distance;
            distance = Math.sqrt((circle.x - this.x) * (circle.x - this.x) + (circle.y - this.y) + (circle.y - this.y));
            return distance < (this.radius + radius);
        }
    }

    void LAB5_10() {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println(c1.getAear());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
    }

    static class Triangle2D {
        // MyPoint is defined in Exercise09_04
        private MyPoint p1, p2, p3;

        public Triangle2D() {
            p1 = new MyPoint(0, 0);
            p2 = new MyPoint(1, 1);
            p3 = new MyPoint(2, 2);
        }

        public Triangle2D(double x1, double y1, double x2, double y2,
                          double x3, double y3) {
            this.p1 = new MyPoint(x1, y1);
            this.p2 = new MyPoint(x2, y2);
            this.p3 = new MyPoint(x3, y3);
        }

        public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        public MyPoint getP1() {
            return p1;
        }

        public void setP1(MyPoint p1) {
            this.p1 = p1;
        }

        public MyPoint getP2() {
            return p2;
        }

        public void setP2(MyPoint p2) {
            this.p2 = p2;
        }

        public MyPoint getP3() {
            return p3;
        }

        public void setP3(MyPoint p3) {
            this.p3 = p3;
        }

        public double getPerimeter() {
            return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
        }

        public double getArea() {
            double side1 = p1.distance(p2);
            double side2 = p1.distance(p3);
            double side3 = p2.distance(p3);

            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        public boolean contains(double x, double y) {
            double maxX = Math.max(p1.getX(), Math.max(p2.getX(), p3.getX()));
            double minX = Math.min(p1.getX(), Math.min(p2.getX(), p3.getX()));
            double maxY = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
            double minY = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));

            if (x < minX || x > maxX || y < minY || y > maxY) {
                return false;  // Outside the bounding rectangle of the triangle
            }

            Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
            Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

            if (side1.contains(x, y) || side2.contains(x, y) || side3.contains(x, y)) {
                return true; // On the border of the triangle
            }

            double topY = -10;
            if (x == p1.getX()) {
                topY = p1.getY();
            } else if (x == p2.getX()) {
                topY = p2.getY();
            } else if (x == p3.getX()) {
                topY = p3.getY();
            }

            Line2D line;
            if (y < topY)
                line = new Line2D.Double(x, y, x, minY);
            else
                line = new Line2D.Double(x, y, x, maxY);

            int hits = 0;
            if (line.intersectsLine(side1))
                hits++;

            if (line.intersectsLine(side2))
                hits++;

            if (line.intersectsLine(side3))
                hits++;

            return hits % 2 != 0;
        }

        /**
         * Return true if a triangle is contained in this triangle
         */
        public boolean contains(Triangle2D t) {
            // If a triangle is contained in this triangle, all its three points must contain in this triangle
            return contains(t.getP1().getX(), t.getP1().getY()) &&
                    contains(t.getP2().getX(), t.getP2().getY()) &&
                    contains(t.getP3().getX(), t.getP3().getY());
        }

        /**
         * Return true if a triangle overlaps with this triangle
         */
        public boolean overlaps(Triangle2D t) {
            // Two triangles overlap if one is inside the other or a side in
            // one triangle intersects a side in the other triangle
            Line2D line1 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
            Line2D line2 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
            Line2D line3 = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());

            Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
            Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

            return contains(t) || t.contains(this) ||
                    line1.intersectsLine(side1) ||
                    line1.intersectsLine(side2) ||
                    line1.intersectsLine(side3) ||
                    line2.intersectsLine(side1) ||
                    line2.intersectsLine(side2) ||
                    line2.intersectsLine(side3) ||
                    line3.intersectsLine(side1) ||
                    line3.intersectsLine(side2) ||
                    line3.intersectsLine(side3);
        }
    }

    void LAB5_11() {
        Triangle2D r1 = new Triangle2D(2, 2, 5.5, 4.9, 9.0, 10.3);
        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new Triangle2D(4, 5, 10.5, 3.2, -0.5, -10.5)));
        System.out.println(r1.overlaps(new Triangle2D(3, 5, 2.3, 6.7, 5.5, 8.8)));
    }

    class MyRectangle2D {
        double x, y;
        double width, height;

        double getX(double x) {
            return x;
        }

        double getY(double y) {
            return y;
        }

        void setX(double x) {
            this.x = x;
        }

        void setY(double y) {
            this.y = y;
        }

        double getWidth(double width) {
            return width;
        }

        double getHeight(double height) {
            return height;
        }

        void setWidth(double width) {
            this.width = width;
        }

        void setHeught(double height) {
            this.height = height;
        }

        MyRectangle2D() {
            x = 0;
            y = 0;
            width = 1;
            height = 1;
        }

        MyRectangle2D(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        double getArea() {
            return width * height;
        }

        double getPerimeter() {
            return (width + height) * 2;
        }

        boolean contains(double x, double y) {
            return (this.x + this.width) >= x && (this.y + this.height) >= y;
        }

        boolean contains(MyRectangle2D r) {
            return Math.abs(r.x - this.x) < this.width / 2 && Math.abs(r.y - this.y) < this.height / 2;
        }

        boolean overlaps(MyRectangle2D r) {
            return Math.abs(r.x - this.x) > this.width / 2 && Math.abs(r.y - this.y) > this.height / 2 && Math.abs(r.x + this.x) < (this.width / 2 + r.width / 2) && Math.abs(r.y + this.y) < (this.height / 2 + r.height / 2);
        }
    }

    void LAB5_12() {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }

    class MyDate {
        int year, month, day;

        MyDate() {
            GregorianCalendar date = new GregorianCalendar();
            year = date.get(Calendar.YEAR);
            month = date.get(Calendar.MONTH);
            day = date.get(Calendar.DAY_OF_MONTH);
        }

        MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        int getYear() {
            return year;
        }

        int getMonth() {
            return month;
        }

        int getDay() {
            return day;
        }

        MyDate(long elapsedTime) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(elapsedTime);
            year = date.get(Calendar.YEAR);
            month = date.get(Calendar.MONTH);
            day = date.get(Calendar.DAY_OF_MONTH);
        }
    }

    void LAB5_13() {
        MyDate date = new MyDate();
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("day: " + date.getDay());

        MyDate date1 = new MyDate(561555550000L);
        System.out.println("year: " + date1.getYear());
        System.out.println("month: " + date1.getMonth());
        System.out.println("day: " + date1.getDay());
    }

    void LAB5_15() {
        BigInteger bigNum = new BigInteger(
                "10000000000000000000000000000000000000000000000000");
        bigNum.add(BigInteger.ONE);
        int count = 1;
        while (count <= 10) {
            if (bigNum.remainder(new BigInteger("2")).equals(BigInteger.ZERO) ||
                    bigNum.divide(new BigInteger("3")).equals(BigInteger.ZERO)) {
                System.out.println(bigNum);
                count++;
            }
            bigNum = bigNum.add(BigInteger.ONE);
        }
    }

    void LAB5_16() {
        final BigInteger MAXLONG = new BigInteger(Long.MAX_VALUE + "");
        BigInteger n = new BigInteger("" + (long) (Math.sqrt(Long.MAX_VALUE)));
        for (; n.multiply(n).compareTo(MAXLONG) < 0;
             n = n.add(BigInteger.ONE))
            ;
        for (int i = 0; i < 10; i++) {
            System.out.println(n.multiply(n));
            n = n.add(BigInteger.ONE);
        }
    }

    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) == 0 ||
                num.compareTo(new BigInteger("2")) == 0) {
            return true;
        }
        BigInteger halfNum = num.divide(new BigInteger("2"));
        for (BigInteger divisor = new BigInteger("2");
             divisor.compareTo(halfNum) <= 0;
             divisor = divisor.add(BigInteger.ONE)) {
            if (num.remainder(divisor).equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }

    void LAB5_17() {
        long startTime = System.currentTimeMillis();
        BigInteger bigNum = new BigInteger(Long.MAX_VALUE + "");
        bigNum.add(BigInteger.ONE);
        int count = 1;
        while (count <= 5) {
            if (isPrime(bigNum)) {
                System.out.println(bigNum);
                count++;
            }
            bigNum = bigNum.add(BigInteger.ONE);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time spent is " +
                (endTime - startTime) + " milliseconds");
    }

    void LAB5_18() {
        final BigInteger TWO = new BigInteger("2");
        BigInteger bigNum = TWO;
        for (long p = 2; p <= 100; p++) {
            bigNum = bigNum.multiply(TWO);

            // Display each number in five positions
            if (isPrime(bigNum.subtract(BigInteger.ONE))) {
                System.out.println(p + "\t" +
                        bigNum.subtract(BigInteger.ONE));
            }
        }
    }

    void LAB5_20() {
        BigDecimal e = BigDecimal.ONE;
        BigDecimal item = BigDecimal.ONE;
        for (int i = 1; i <= 1000; i++) {
            item = item.divide(new BigDecimal(i + ""), 25, BigDecimal.ROUND_UP);
            e = e.add(item);
            if (i % 100 == 0)
                System.out.println("The e is " + e + " for i = " + i);
        }
    }

    static class MyString1 {
        private final char[] chars;

        public MyString1(char[] chars) {
            this.chars = new char[chars.length];
            System.arraycopy(chars, 0, this.chars, 0, chars.length);
        }

        public int length() {
            return chars.length;
        }

        public char charAt(int index) {
            return chars[index];
        }

        public MyString1 substring(int begin, int end) {
            char[] temp = new char[end - begin];
            for (int i = begin; i < end; i++) {
                temp[i - begin] = chars[i];
            }
            return new MyString1(temp);
        }

        public MyString1 toLowerCase() {
            char[] temp = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                temp[i] = Character.toLowerCase(chars[i]);
            }

            return new MyString1(temp);
        }

        public static MyString1 valueOf(int i) {
            char[] temp = new char[40];
            int size = 0;
            while (i != 0) {
                int number = i % 10;
                i = i / 10;
                temp[size] = (char) (number + '0');
                size++;
            }
            char[] temp2 = new char[size];
            for (int k = size - 1; k >= 0; k--) {
                temp2[k] = temp[size - k - 1];
            }
            return new MyString1(temp2);
        }

        public char[] toChars() {
            return chars;
        }
    }

    static class MyString2 {
        private final char[] chars;

        public MyString2(char[] chars) {
            this.chars = new char[chars.length];
            System.arraycopy(chars, 0, this.chars, 0, chars.length);
        }

        public int compare(MyString2 s) {
            return 1;
        }

        public MyString2 toUppercase() {
            char[] temp = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                temp[i] = Character.toUpperCase(chars[i]);
            }

            return new MyString2(temp);
        }

        public static MyString2 valueOf(boolean d) {
            if (d)
                return new MyString2(new char[]{'t', 'r', 'u', 'e'});
            else
                return new MyString2(new char[]{'f', 'a', 'l', 's', 'e'});
        }

        public MyString2 substring(int begin) {
            char[] temp = new char[chars.length - begin];
            for (int i = begin; i < chars.length; i++) {
                temp[i - begin] = chars[i];
            }
            return new MyString2(temp);
        }

        public char[] toChars() {
            return chars;
        }
    }

    static class MyCharacter {
        private final char value;

        public MyCharacter(char value) {
            this.value = value;
        }

        public char charValue() {
            return value;
        }

        public int compareTo(MyCharacter anotherCharacter) {
            return value - anotherCharacter.value;
        }

        public boolean equals(MyCharacter anotherCharacter) {
            return value == anotherCharacter.value;
        }

        public boolean isDigit() {
            return isDigit(value);
        }

        public static boolean isDigit(char ch) {
            return ch <= '9' && ch >= '0';
        }

        public static boolean isLetter(char ch) {
            return (ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A');
        }

        public static boolean isLetterOrDigit(char ch) {
            return isLetter(ch) || isDigit(ch);
        }

        public static boolean isLowerCase(char ch) {
            return (ch <= 'z' && ch >= 'a');
        }

        public static boolean isUpperCase(char ch) {
            return (ch <= 'Z' && ch >= 'A');
        }

        public static char toUpperCase(char ch) {
            if (isLowerCase(ch))
                return (char) (ch - 'a' + 'A');
            else
                return ch;
        }

        public static char toLowerCase(char ch) {
            if (isUpperCase(ch))
                return (char) (ch - 'A' + 'a');
            else
                return ch;
        }
    }

    public static String insertBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }

    void LAB5_25(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java Calculator \"operand1 operator operand2\"");
            System.exit(1);
        }
        int result = 0;
        String s = insertBlanks(args[0]);
        String[] tokens = s.split("\\s+");
        switch (tokens[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
                break;
            case '-':
                result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
                break;
            case '*':
                result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
                break;
            case '/':
                result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
        }

        System.out.println(tokens[0] + ' ' + tokens[1] + ' ' + tokens[2] + " = " + result);
    }
}
