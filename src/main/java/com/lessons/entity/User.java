package com.lessons.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mail;
    private String password;
    private String name;
    private String surname;
    private BigDecimal balance;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Product> productsOnSale;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "bucket",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> productsOnBasket;

    public boolean addProductOnBasket(Product product){
        if(product==null)
            return false;
        product.getPotentialBuyers().add(this);
        return productsOnBasket.add(product);
    }

    public boolean removeProductFromBasket(Product product){
        if(product==null)
            return false;
        product.getPotentialBuyers().remove(this);
        return productsOnBasket.remove(product);
    }
}
