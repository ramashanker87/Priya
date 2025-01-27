package com.priya.app.Shapes_Area;

public abstract class Circle extends Shape {

    public int r;

    public Circle (int r){
        this.r = r;
    }
@Override
public int Area(){
        return (int) (Math.PI*r*r);
}


    public abstract int area();
}


