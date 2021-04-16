package com.company;

import java.util.Scanner;

public class LAB2 {
    static void LAB2_1(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point1(latitude and longitude) in degrees: ");
        double x1 = Math.toRadians(input.nextDouble());
        double y1 = Math.toRadians(input.nextDouble());
        System.out.print("Enter point2(latitude and longitude) in degrees: ");
        double x2 = Math.toRadians(input.nextDouble());
        double y2 = Math.toRadians(input.nextDouble());
        double d = 637.01 * Math.acos(Math.sin(x1)*Math.sin(x2) + Math.cos(x1)*Math.cos(x2)*Math.cos(y1 - y2));
        System.out.println(d);
    }


    public static void main(String[] args) {
        LAB2_1();
    }
}
