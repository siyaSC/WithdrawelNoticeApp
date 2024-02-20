package com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Investor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controller class
@RestController
@RequestMapping("/investor")
public class InvestorInformationController {
    @Autowired
    private final InvestorRepository investorRepository;

    @GetMapping("/{id}")
    private ResponseEntity<Investor> findById(@PathVariable Long id) {
        Optional<Investor> investorOptional = investorRepository.findById(id);
        if (investorOptional.isPresent()) {
            return ResponseEntity.ok(investorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public List<Investor> getAllInvestors() {
        return (List<Investor>) investorRepository.findAll();
    }

    private InvestorInformationController(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @PostMapping
    public Investor createInvestor(@RequestBody Investor investor) {
        return investorRepository.save(investor);
    }
}
