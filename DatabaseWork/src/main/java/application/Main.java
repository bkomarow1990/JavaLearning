package application;

import application.interfaces.IShape;
import application.models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Bread", 22.2f, 30);
        //product.set
        SaleProduct saleProduct = new SaleProduct(2, "Beer", 18f, 21, 20);
        //saleProduct.setCount();
        ArrayList<IShape> iShapes = new ArrayList<>();
        iShapes.add(new Rectangle(2, 3));
        iShapes.add(new Square(12));
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Square(12));
    }
}
