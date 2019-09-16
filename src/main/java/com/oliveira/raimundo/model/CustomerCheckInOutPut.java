package com.oliveira.raimundo.model;

import java.time.LocalDateTime;

import com.oliveira.raimundo.controller.CustomerDTO;


public class CustomerCheckInOutPut  {
	private static final long serialVersionUID = 1L;

	//Cliente
	public CustomerDTO customer;

	//Entrada data
	public LocalDateTime inDate;

	//Saída data
	public LocalDateTime outDate;

	//Documento do cliente
	public Boolean add;



}
