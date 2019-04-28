package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "Seller")
public class Seller extends Model {

//    @OneToOne
////    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
////    private Customer customer;
    @Id
    @Column(name = "sellerId")
    private String sellerId;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "category")
    private String category;

//    @ManyToMany
//    private List<BookM> books;


//    public String getId() {
//        return Id;
//    }
//
//    public void setId(String id) {
//        Id = id;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public List<BookM> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<BookM> books) {
//        this.books = books;
//    }
}