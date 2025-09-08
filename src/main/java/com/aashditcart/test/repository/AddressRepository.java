package com.aashditcart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

	}
