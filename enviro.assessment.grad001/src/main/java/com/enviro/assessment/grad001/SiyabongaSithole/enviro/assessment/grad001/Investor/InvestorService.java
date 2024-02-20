package com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Investor;

import com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Products.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    public void withdrawAmount(Long investorId, BigDecimal withdrawalAmount) {
        // Retrieve investor by ID
        Investor investor = investorRepository.findById(investorId)
                .orElseThrow(() -> new EntityNotFoundException("Investor not found with ID: " + investorId));

        // Check PRODUCT condition
        for (Product product : investor.getProduct()) {
            if ("RETIREMENT".equals(product.getName())) {
                // Assuming age is a property of the Investor class
                if (investor.getAge() <= 65) {
                    throw new ValidationException("Investor must be greater than 65 years old for RETIREMENT product.");
                }
            } else {
                throw new ValidationException("Invalid PRODUCT type");
            }
        }

        // Check WITHDRAWAL AMOUNT condition
        if (withdrawalAmount.compareTo(investor.getBalance()) > 0) {
            throw new ValidationException("Withdrawal amount cannot be greater than current balance.");
        }

        // Check 90% of current BALANCE condition
        BigDecimal maxWithdrawal = investor.getBalance().multiply(BigDecimal.valueOf(0.9));
        if (withdrawalAmount.compareTo(maxWithdrawal) > 0) {
            throw new ValidationException("Withdrawal amount cannot exceed 90% of the current balance.");
        }

        // Update balance after successful withdrawal
        investor.setBalance(investor.getBalance().subtract(withdrawalAmount));
        investorRepository.save(investor);
    }
}
