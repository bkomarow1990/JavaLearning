package application.models;

import lombok.Data;

@Data
public class SaleProduct extends Product{
    private int discount;
    private void Test(){
        System.out.println("Test");
    }
    public void TestMethodTest(){
        Test();
    }

    public SaleProduct(int id, String name, float price, int count, int discount) {
        super(id, name, price, count);
        this.discount = discount;
    }
}
