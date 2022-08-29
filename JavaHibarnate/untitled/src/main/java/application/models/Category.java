package application.models;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tblCategories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")

    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200)
    private String image;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_Id")
    private Product product;
}
