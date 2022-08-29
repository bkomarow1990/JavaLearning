package application.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="tblUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ShoppingCart shoppingCart;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "User_Role",
            joinColumns = { @JoinColumn(name = "user_Id") },
            inverseJoinColumns = { @JoinColumn(name = "role_Id") }
    )
    Set<Role> roles = new HashSet<>();
}
