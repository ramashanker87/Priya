package com.priya.app.Shapes_Area;

public class Main {
    public static void main(String[] args) {


        Circle circle = new Circle(6) {
            @Override
            public int area() {
                return 0;
            }
        };
        System.out.println("Area of Circle: " + circle.Area());

        Rectangle rectangle = new Rectangle(12, 34) {
            @Override
            public int area() {
                return 0;
            }
        };


        System.out.println("Area of Rectangle: " + rectangle.Area());


        Triangle Tri= new Triangle(10, 4) {
            @Override
            public int area() {
                return 0;
            }
        };


        System.out.println("Area of Triangle: " + Tri.Area());


    }}
