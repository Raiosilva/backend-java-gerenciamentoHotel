package com.oliveira.raimundo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.oliveira.raimundo.model.Customer;
import com.oliveira.raimundo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @GetMapping(value = "/")
  public ResponseEntity<List<CustomerDTO>> findAll() {
    List<Customer> list = service.searchAll();
    List<CustomerDTO> listDto = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> find(@PathVariable Long id) {
    Customer obj = service.search(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping(value = "/page")
  public ResponseEntity<Page<CustomerDTO>> findPage(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
    Page<Customer> list = service.searchPage(page, linesPerPage, orderBy, direction);
    Page<CustomerDTO> listDto = list.map(obj -> new CustomerDTO(obj));
    return ResponseEntity.ok().body(listDto);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Void> create(@Valid @RequestBody CustomerDTO objDto) {
    Customer obj = service.fromDTO(objDto);
    obj = service.createCustomer(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@Valid @RequestBody CustomerDTO objDto, @PathVariable Long id) {
    Customer obj = service.fromDTO(objDto);
    obj.setId(id);
    obj = service.update(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
