package application.models;

import lombok.Data;

@Data
public class Rectangle extends Shape{
    @Override
    public int getPerimeter() {
        return 0;
    }

    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public void print() {
        //for (int i=0; i<getSide1())
        System.out.println("Rectangle");
    }
    public Rectangle(int side1, int side2){
        super(side1);

    }
}
