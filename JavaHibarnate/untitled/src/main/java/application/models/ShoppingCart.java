package application.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="tblShoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_Id")
    private User user;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ShoppingCart_Product",
            joinColumns = { @JoinColumn(name = "shoppingCart_Id") },
            inverseJoinColumns = { @JoinColumn(name = "product_Id") }
    )
    Set<Product> products = new HashSet<>();


}
