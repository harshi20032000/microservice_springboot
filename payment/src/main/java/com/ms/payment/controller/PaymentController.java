package com.ms.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.payment.entity.CreditCardDetails;
import com.ms.payment.entity.Ticket;
import com.ms.payment.repo.CreditCardRepository;

@RestController
public class PaymentController {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${booking.api.url}")
	private String bookingApiUrl;

	@RequestMapping(value = "/payment/{pnr}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> validateCreditCard(@PathVariable("pnr") String pnr,
			@RequestBody CreditCardDetails creditCard) {
		CreditCardDetails cardDetails;
		boolean result = false;
		try {

			cardDetails = (CreditCardDetails) creditCardRepository.findById(creditCard.getCardNumber()).get();

			if (cardDetails != null) {
				ResponseEntity<Ticket> ticket = restTemplate.getForEntity(bookingApiUrl + pnr, Ticket.class);
				double fare = ticket.getBody().getTotalFare();
				if (creditCard.getApin().equals(cardDetails.getApin())
						&& creditCard.getCvv().equals(cardDetails.getCvv())
						&& creditCard.getCardHolderName().equals(cardDetails.getCardHolderName())) {
					cardDetails.setTotalBill(cardDetails.getTotalBill()+fare);
					creditCardRepository.saveAndFlush(cardDetails);
					result = true;
				}
			}
			restTemplate.getForEntity(bookingApiUrl + "update/" + pnr, Void.class);

		} catch (Exception a) {

			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}
}
