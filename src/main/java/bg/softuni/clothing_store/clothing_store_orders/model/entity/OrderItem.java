package bg.softuni.clothing_store.clothing_store_orders.model.entity;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.ColorName;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.SizeName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private SizeName sizes;

    @Column
    @Enumerated(EnumType.STRING)
    private ColorName colors;

    @Column(nullable = false)
    private long userId;

    @ManyToOne(targetEntity = Order.class)
    private Order order;

    public OrderItem() {
    }


}
