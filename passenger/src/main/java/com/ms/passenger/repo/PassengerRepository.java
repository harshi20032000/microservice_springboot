package com.ms.passenger.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.passenger.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
