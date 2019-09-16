package com.oliveira.raimundo.model;

import java.util.List;

import com.oliveira.raimundo.controller.CustomerDTO;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper  {
	private static final long serialVersionUID = 1L;

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
