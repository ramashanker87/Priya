package com.priya.app.Shapes_Area;

public abstract class Rectangle extends Shape{

    public int w;
    public int h;

    public  Rectangle(int w, int h){
        this.w = w;
        this.h = h;
    }
    @Override
    public int Area() {
        return (int) (w * h);
    }

        public abstract int area();

}
