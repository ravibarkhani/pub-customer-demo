package com.bawnya.ravid.learning.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bawnya.ravid.learning.persistance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
