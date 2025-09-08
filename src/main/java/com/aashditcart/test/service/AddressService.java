package com.aashditcart.test.service;

import java.util.List;

import com.aashditcart.test.model.Address;

public interface AddressService  {

	Address saveAddress(Address address);
    Address getAddressById(Long id);
    Address updateAddress(Address address);
    void deleteAddress(Long id);
	
	List<Address> getAddressesByUser(Long userId);

}
