package com.oliveira.raimundo.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.oliveira.raimundo.model.Customer;

import org.hibernate.validator.constraints.Length;


public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

  //retorna identificador
  public Long id;

  //retorn documento cliente
  public String documentId;

  //retorna nome
  @NotNull(message = "Preenchimento obrigatório")
  @Length(min = 3, max = 100, message = "Deve ter entre 3 e 80 caracteres")
  public String name;

  //retorna telefone
  public String phone;

  //retorna data criação
  public LocalDateTime createDate;

  public CustomerDTO () {}

  public CustomerDTO(Customer obj) {
    id = obj.getId();
    name = obj.getName();
    phone = obj.getPhone();
    createDate = obj.getCreateDate();
    documentId = obj.getDocumentId();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }

  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

}
