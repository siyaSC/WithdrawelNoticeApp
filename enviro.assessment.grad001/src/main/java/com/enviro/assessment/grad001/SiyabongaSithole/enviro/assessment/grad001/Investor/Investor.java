package com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Investor;

import com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public record Investor(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id, String firstName, String lastName, String address, String email, String contactNumber, @OneToMany(mappedBy = "investor") List<Product> products, Long dateOfBirth) {

    private static BigDecimal balance;

    public Investor(Long id, String firstName, String lastName, String address, String email, String contactNumber, List<Product> products) {
        this(id, firstName, lastName, address, email, contactNumber, products, null);  // Initialize dateOfBirth to null
    }

    // New constructor
    public Investor(Long id, String firstName, String lastName, String address, String email, String contactNumber, List<Product> products, Long dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
        this.products = products;
        this.dateOfBirth = dateOfBirth;
    }

    // Method to calculate the investor's age
    public int getAge() {
        if (dateOfBirth == null) {
            return -1; 
        }

        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.ofEpochDay(dateOfBirth), currentDate).getYears();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
