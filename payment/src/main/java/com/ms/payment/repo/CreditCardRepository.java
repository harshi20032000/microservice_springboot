package com.ms.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.payment.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String> {

}
