package com.harshikesh.irs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshikesh.irs.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String> {

}
