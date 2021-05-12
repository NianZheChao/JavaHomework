package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class LAB6 {
    private static final int Integer = 0;
    private static final int ArrayList = 0;
    private static Scanner input;

    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0)
            return null;

        int result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (result < list.get(i))
                result = list.get(i);
        return result;
    }

    public static void LAB6_4() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;
        do {
            value = input.nextInt();
            if (value != 0)
                list.add(value);
        } while (value != 0);
        System.out.print("The maximum number is " + max(list));
    }

    public static void shuffle(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = (int) (Math.random() * 10);
            int temp = list.get(index);
            list.set(index, list.get(i));
            list.set(i, temp);
        }

    }

    public static void LAB6_7() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void LAB6_9() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();

        System.out.print("enter the array size n: ");
        int n = input.nextInt();
        int[][] array = new int[n][n];
        System.out.println("enter the array");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 2);
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = list.get(i);
            int min_index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (min > list.get(j)) {
                    min = list.get(j);
                    min_index = j;
                }
            }
            if (min_index != i) {
                list.set(min_index, list.get(i));
                list.set(i, min);
            }
        }
    }

    public static double sum(ArrayList<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++)
            sum += list.get(i);
        return sum;
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (!list1.contains(list.get(i))) {
                list1.add(list.get(i));
            }
        }
        list.clear();
        for (int i = 0; i < list1.size(); i++)
            list.add(list1.get(i));
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++)
            list3.add(list1.get(i));
        for (int i = 0; i < list2.size(); i++)
            list3.add(list2.get(i));
        return list3;
    }

    public void LAB6_1() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter three sides: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);

        System.out.print("enter the color: ");
        String color = input.nextLine();
        triangle.setColor(color);

        System.out.println("enter a boolean for filled: ");
        boolean filled = input.nextBoolean();
        triangle.setFilled(filled);

        System.out.println("The area is " + triangle.getArea());
        System.out.println("The perimeter is " + triangle.getPerimeter());
        System.out.println("the color is " + triangle.getColor());
        System.out.println("the filled is " + triangle.getFilled);
        System.out.println(triangle);
    }

    public void LAB6_10() {
        Scanner input = new Scanner(System.in);
        MyStack stack = new MyStack();
        for (int i = 0; i < 5; i++) {
            stack.push(input.nextLine());
        }
        System.out.println(stack.getSize() + "strings are: ");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    public void LAB6_11() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("enter 5 numbers: ");
        for (int i = 0; i < 5; i++)
            list.add(input.nextInt());
        sort(list);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }

    public void LAB6_12() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("enter 5 numbers: ");
        for (int i = 0; i < 5; i++)
            list.add(input.nextInt());
        System.out.println("the sum is " + sum(list));
    }

    public void LAB6_13() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        input = new Scanner(System.in);
        System.out.println("enter ten integers: ");
        for (int i = 0; i < 10; i++)
            list.add(input.nextInt());

        removeDuplicate(list);

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }

    public void LAB6_14() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println("enter five integers for list1:");
        for (int i = 0; i < 5; i++) {
            list1.add(i, input.nextInt());
        }
        System.out.println("enter five integers for list2:");
        for (int i = 0; i < 5; i++) {
            list2.add(i, input.nextInt());
        }
        ArrayList<Integer> list3 = union(list1, list2);
        System.out.print("The combined list is ");
        for (int i = 0; i < list3.size(); i++)
            System.out.print(list3.get(i) + " ");
    }

    public void LAB6_15() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of the points: ");
        int number = input.nextInt();
        System.out.println("enter the coordinates of the points:");
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            x.add(input.nextDouble());
            y.add(input.nextDouble());
        }
        double area = 0;
    }

    public void LAB6_16() {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        Scanner input = new Scanner(System.in);
        System.out.print("what is " + number1 + " + " + number2 + " ?");
        int answer = input.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(answer);
        while (number1 + number2 != answer) {
            System.out.print("wrong answer.try again.what is " + number1 + " + " + number2 + " ?");
            answer = input.nextInt();
            if (list.contains(answer)) {
                System.out.println("you already entered " + answer);
            } else
                list.add(answer);
        }
        System.out.println("you got it!");
    }

    public void LAB6_17() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);

        System.out.print("enter an integer m: ");
        int m = input.nextInt();
        int number = m;
        int i = 2;
        while (i <= number) {
            if (number % i == 0) {
                list.add(i);
                number = number / i;
            } else
                i++;
        }

        int n = 1;
        int j = 0;
        while (j < list.size() - 1) {
            if (list.get(j) != list.get(j + 1)) {
                n *= list.get(j);
                j += 1;
            } else
                j += 2;
        }
        if (j == list.size() - 1)
            n *= list.get(j);

        System.out.println("the smallest number n for m*n to be a perfect square is " + n);
        System.out.println("m*n=" + m * n);
    }

    class GeometricObject {
        private String color = "white";
        private boolean filled;
        private final java.util.Date dateCreated;

        public GeometricObject() {
            dateCreated = new java.util.Date();
        }

        public GeometricObject(String color, boolean filled) {
            dateCreated = new java.util.Date();
            this.color = color;
            this.filled = filled;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public java.util.Date getDateCreated() {
            return dateCreated;
        }

        public String toString() {
            return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }
    }

    class Triangle extends GeometricObject {
        public String getFilled;
        double side1, side2, side3;

        public Triangle() {
            side1 = 1.0;
            side2 = 1.0;
            side3 = 1.0;
        }

        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getSide1() {
            return side1;
        }

        public double getSide2() {
            return side2;
        }

        public double getSide3() {
            return side3;
        }

        public double getArea()  //海伦公式
        {
            double p = (side1 + side2 + side3) / 2;
            double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
            return area;
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        @Override
        public String toString() {
            return "Triangle:side1=" + side1 + " side2=" + side2 + " side3=" + side3;
        }
    }

    class Person {
        String name;
        String address;
        String phone_number;
        String email;

        public String toString() {
            return "person";
        }

    }

    class Student extends Person {
        final int dayi = 1;
        final int daer = 2;
        final int dasan = 3;
        final int dasi = 4;

        public String toString() {
            return "student";
        }
    }

    class Employee extends Person {
        String office;
        int salary;
        Calendar dateHired;

        public String toString() {
            return "Employee";
        }
    }

    class Faculty extends Employee {
        String officetime;
        char grade1 = 'A';
        char grade2 = 'B';

    }

    class Staff extends Employee {
        String staff_name;
    }

    class MyStack extends java.util.ArrayList<Object> {
        private final ArrayList<Object> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int getSize() {
            return list.size();
        }

        public Object peek() {
            return list.get(getSize() - 1);
        }

        public Object pop() {
            Object o = list.get(getSize() - 1);
            list.remove(getSize() - 1);
            return o;
        }

        public void push(Object o) {
            list.add(o);
        }

        public String toString() {
            return "stack: " + list.toString();
        }
    }
}
