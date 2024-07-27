//package bg.softuni.clothing_store.clothing_store_orders.model.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column
//    private String address;
//
//    @Column
//    private String city;
//
//    @Column
//    private String country;
//
//    @Column
//    private String zip;
//
////    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
////    private List<Role> roles;
//
//    @OneToMany(targetEntity = Order.class, mappedBy = "user")
//    private List<Order> orders;
//
//    public User() {
//
//        this.orders = new ArrayList<>();
////        this.roles = new ArrayList<>();
//    }
//
//    //#################################################################################
//
//
//}
