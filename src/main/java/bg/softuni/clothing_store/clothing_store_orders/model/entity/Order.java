package bg.softuni.clothing_store.clothing_store_orders.model.entity;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.DeliveryType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.PaymentType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = OrderItem.class)
    private List<OrderItem> orderItemsRest;

    @Column(nullable = false)
    private BigDecimal total;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    @Column
    private Long user;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String Address;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zip;

    public Order() {
        this.orderItemsRest = new ArrayList<>();
    }


}
