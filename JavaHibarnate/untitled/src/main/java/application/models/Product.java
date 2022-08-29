package application.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="tblProducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(name = "price")
    private float price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Category category;
    @ManyToMany(mappedBy = "products")
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();


}
