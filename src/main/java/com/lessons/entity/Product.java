package com.lessons.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User seller;
    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<User> potentialBuyers;
}
