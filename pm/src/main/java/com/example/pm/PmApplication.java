package com.example.pm;

import com.example.pm.model.Payment;
import com.example.pm.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PmApplication.class, args);
    }

    @Autowired
    private PaymentRepository pr;

    @Override
    public void run(String... args) throws Exception {




    }
}
