package com.jpa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.models.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
