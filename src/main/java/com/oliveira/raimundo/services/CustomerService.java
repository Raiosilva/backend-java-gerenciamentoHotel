package com.oliveira.raimundo.services;

import java.util.List;
import java.util.Optional;

import com.oliveira.raimundo.controller.CustomerDTO;
import com.oliveira.raimundo.model.Customer;
import com.oliveira.raimundo.repositories.CustomerRepository;
import com.oliveira.raimundo.services.exceptions.DataIntegrityException;
import com.oliveira.raimundo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repo;

  public List<Customer> searchAll(){
    return repo.findAll();
  }

  public Customer search(Long id) {
    Optional<Customer> obj = repo.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Documento: "
      + id + ", Tipo: " + Customer.class.getName()));
  }

  /**
   * Método que cria um novo cliente.
   *
   * @param customer com as informações do cliente .
   * @return DTO com as informações do cliente .
   */
  public Customer createCustomer(Customer obj) {
    obj.setId(null);
    return repo.save(obj);
  }

  //validando na criação do cliente e na atualização
  public Customer fromDTO(CustomerDTO objDto) {
    return new Customer(objDto.getId(), objDto.getName(), objDto.getPhone(), objDto.getPhone(), objDto.getCreateDate());
  }

  public Customer update(Customer obj) {
    search(obj.getId());
    return repo.save(obj);
  }

  public void delete(Long id) {
    search(id);
    try {
      repo.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não pode excluir!");
    }
  }

  //Paginação
  public Page<Customer> searchPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
    return repo.findAll(pageRequest);
  }
}