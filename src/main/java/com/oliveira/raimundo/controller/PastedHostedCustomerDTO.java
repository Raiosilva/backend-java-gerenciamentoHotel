package com.oliveira.raimundo.controller;

import java.io.Serializable;


public class PastedHostedCustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

  //retorna id do banco
  public Long id;

  //retorn nome cliente
  public String nameCustomer;

  //retorna documento
  public String registerId;

  //retorna telefone
  public String phone;

  //valor da hospedagem
  public String lastHostedValue;

  //Soma dos hospedes
  public String allhostedValue;


}
