package com.example.pm.controller;

import com.example.pm.exception.ResourceNotFoundException;
import com.example.pm.model.Payment;
import com.example.pm.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository pr;

    @GetMapping
    public List<Payment> getAllPayments(){
        return pr.findAll();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment){
        return pr.save(payment);
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable long id){
        Payment payment = pr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id:" + id));
        return ResponseEntity.ok(payment);
    }

    @PutMapping("{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable long id,@RequestBody Payment paymentDetails) {
        Payment updatePayment = pr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));

        updatePayment.setPid(paymentDetails.getPid());
        updatePayment.setAcc(paymentDetails.getAcc());
        updatePayment.setUnit(paymentDetails.getUnit());
        updatePayment.setPrice(paymentDetails.getPrice());

        pr.save(updatePayment);

        return ResponseEntity.ok(updatePayment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable long id){

        Payment payment = pr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));

        pr.delete(payment);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
