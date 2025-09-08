package com.aashditcart.test.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashditcart.test.model.Address;
import com.aashditcart.test.repository.AddressRepository;
import com.aashditcart.test.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	 @Autowired
	    private AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		 try {
		        return addressRepository.save(address);
		    } catch (Exception e) {
		        logger.error("Error saving address: {}", e.getMessage(), e);
		        return null;
		    }
	}

	@Override
	public Address getAddressById(Long id) {
		try {
	        return addressRepository.findById(id).orElse(null);
	    } catch (Exception e) {
	        logger.error("Error retrieving address by ID {}: {}", id, e.getMessage(), e);
	        return null;
	    }

	}

	@Override
	public Address updateAddress(Address address) {
		 try {
		        return addressRepository.save(address);
		    } catch (Exception e) {
		        logger.error("Error updating address with ID {}: {}", address.getId(), e.getMessage(), e);
		        return null;
		    }
	}

	@Override
	public void deleteAddress(Long id) {
		try {
	        addressRepository.deleteById(id);
	    } catch (Exception e) {
	        logger.error("Error deleting address with ID {}: {}", id, e.getMessage(), e);
	    }

	}

	@Override
	public List<Address> getAddressesByUser(Long userId) {
		 try {
		        return addressRepository.findByUserId(userId);
		    } catch (Exception e) {
		        logger.error("Error retrieving addresses for user ID {}: {}", userId, e.getMessage(), e);
		        return Collections.emptyList();
		    }
}
}
