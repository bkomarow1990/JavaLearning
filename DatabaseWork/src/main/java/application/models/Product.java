package application.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Product {
    private int id;
    private String name;
    private String Name;
    private float price;
    @Setter(AccessLevel.PROTECTED)
    protected int count;
    public Product(int id, String name, float price, int count){

        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public Product(){

    }
}
