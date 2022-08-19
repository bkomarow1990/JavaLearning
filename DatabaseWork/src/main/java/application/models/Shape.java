package application.models;

import application.interfaces.IShape;
import lombok.Data;

@Data
public abstract class Shape implements IShape {
    private int side1;
    public Shape(int side1){
        this.side1=side1;
    }
    public Shape(){

    }
}
