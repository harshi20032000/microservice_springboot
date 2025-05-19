/**
 * 
 */
package com.ms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.entity.Customer;
import com.ms.user.entity.LoginDetails;
import com.ms.user.exception.ExceptionConstants;
import com.ms.user.exception.InfyGoServiceException;
import com.ms.user.repo.CustomerRepository;

/**
 * The Class AadharService.
 */
@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	public boolean isUserValid(LoginDetails customerLogin) throws InfyGoServiceException {

		Customer customer = customerRepository.findById(customerLogin.getUserId()).get();

		if (customer == null) {
			throw new InfyGoServiceException(ExceptionConstants.USER_NOT_FOUND.toString(), "User record not found");
		} else if (!(customer.getPassword().equals(customerLogin.getPassword()))) {
			throw new InfyGoServiceException(ExceptionConstants.USER_INVALID.toString(), "Invalid credentials");
		}
		return true;

	}

}
