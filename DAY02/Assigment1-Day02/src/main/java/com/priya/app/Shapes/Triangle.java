package com.priya.app.Shapes_Area;

public abstract class Triangle extends  Shape{

    public int b;
    public int h;

    public  Triangle(int b, int h){
        this.b = b;
        this.h = h;
    }
    @Override
    public int Area() {
        return (int) (0.5 * b * h);
    }

    public abstract int area();
}
