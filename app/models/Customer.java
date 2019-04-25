package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer extends Model {

    public Customer(String id, String fName, String lName, String email, String phoneNo) {
        Id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public static Finder<String, Customer> findCustomer = new Finder<>(Customer.class);

    @Id
    @Column(name = "customerId")
    private String Id;

    @Column(name = "fName")
    private String fName;

    @Column(name = "lName")
    private String lName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;
}
