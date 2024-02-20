package com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Products;

import com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Investor.Investor;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId; // Unique product identifier
    private String type; // Type of product (RETIREMENT/SAVINGS)
    private String name;
    private double currentBalance;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    public Product(String productId, String type, String name, double currentBalance, Investor investor) {
        this.productId = productId;
        this.type = type;
        this.name = name;
        this.currentBalance = currentBalance;
        this.investor = investor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
