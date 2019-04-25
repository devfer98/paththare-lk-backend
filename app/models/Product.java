package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product extends Model {

    public static Finder<String, Product> findProduct=new Finder<>(Product.class);

    @Id
    @Column(name = "productId")
    private String Id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "SellerId")

    @ManyToMany(mappedBy = "products")
    private List<Promoter> promoters;

    private Seller seller;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
