package application.models;

import lombok.Data;

@Data
public class Square extends Shape {
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

    }
    public Square(int side1){
        super(side1);
    }
}
