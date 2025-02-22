package com.hohuuan.Exercise.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hohuuan.Exercise.model.orderDetail.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "Product")
public class Product {
    @Id
    @Column(unique = true)
    private String id;
    private String name;

    @Column(unique = false, nullable = true, length = 100000)
    private byte[] illustration;

    private int price;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("id")
    @JsonManagedReference
    private List<OrderDetail> orderItems = new ArrayList<>();
}
