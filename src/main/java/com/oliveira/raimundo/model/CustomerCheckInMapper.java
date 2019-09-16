package com.oliveira.raimundo.model;

import com.oliveira.raimundo.controller.CustomerDTO;
import com.oliveira.raimundo.controller.PastedHostedCustomerDTO;

import org.springframework.stereotype.Component;

@Component
public class CustomerCheckInMapper  {
	private static final long serialVersionUID = 1L;

	public CustomerCheckInOutPut toCheckinDTO(CustomerOpenOut entity) {
		if (entity == null) {
				return null;
		}

		CustomerCheckInOutPut dto = new CustomerCheckInOutPut();
		dto.add = entity.getAdd();
		dto.inDate = entity.getCheckInDate();
		dto.outDate = entity.getCheckOutDate();
		dto.customer = customerDTO(entity.getCustomer());
		return dto;
	}

	public PastedHostedCustomerDTO toPastHostedCustomersDTO(CustomerOpenOut entity) {
		if (entity == null) {
				return null;
		}

		PastedHostedCustomerDTO dto = new PastedHostedCustomerDTO();
		dto.nameCustomer = entity.getCustomer().getName();
		return dto;
	}

	public CustomerDTO customerDTO(Customer obj) {
		if (obj == null) {
				return null;
		}

		CustomerDTO dto = new CustomerDTO();
		dto.name = obj.getName();
		dto.phone = obj.getPhone();
		dto.documentId = obj.getDocumentId();
		dto.createDate = obj.getCreateDate();
		dto.id = obj.getId();
		return dto;
	}

}
