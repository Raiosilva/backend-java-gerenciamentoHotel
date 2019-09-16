package com.oliveira.raimundo.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.oliveira.raimundo.model.Customer;
import com.oliveira.raimundo.model.CustomerOpenOut;


public class CustomerOpenOutDTO implements Serializable {
	private static final long serialVersionUID = 1L;

  //identificador chickIn
  private Long id;

  //Id Cliente
	private Long customerId;

  //Documento cliente
	private Boolean add;

  //Data Entrada
	private LocalDateTime checkInDate;

  //Data Saída
	private LocalDateTime checkOutDate;

  public CustomerOpenOutDTO() {}

  public CustomerOpenOutDTO(CustomerOpenOut obj) {
    id = obj.getId();
    customerId = obj.getCustomerId();
    add = obj.getAdd();
    checkInDate = obj.getCheckInDate();
    checkOutDate = obj.getCheckOutDate();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Boolean getAdd() {
    return add;
  }

  public void setAdd(Boolean add) {
    this.add = add;
  }

  public LocalDateTime getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(LocalDateTime checkInDate) {
    this.checkInDate = checkInDate;
  }

  public LocalDateTime getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(LocalDateTime checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

}
