package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Promoter")
public class Promoter extends Model {

//    @OneToOne
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    private Customer customer;

    @Id
    @Column(name = "promoterId")
    private String promoterId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @ManyToMany
    @JoinTable(name="promotes")
    private List<Product> products;
}
