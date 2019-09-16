package com.oliveira.raimundo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.oliveira.raimundo.model.CustomerOpenOut;
import com.oliveira.raimundo.repositories.CustomerOpenOutRepository;
import com.oliveira.raimundo.services.CustomerOpenOutService;
import com.oliveira.raimundo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/customeropenout")
public class CustomerOpenOutController {

  @Autowired
  private CustomerOpenOutService service;

  @GetMapping(name = "/{id}")
  public ResponseEntity<CustomerOpenOut> find(@PathVariable Long id) {
    CustomerOpenOut obj = service.search(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping(value = "/page")
  public ResponseEntity<Page<CustomerOpenOutDTO>> findPage(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
    Page<CustomerOpenOut> list = service.searchPage(page, linesPerPage, orderBy, direction);
    Page<CustomerOpenOutDTO> listDto = list.map(obj -> new CustomerOpenOutDTO(obj));
    return ResponseEntity.ok().body(listDto);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Void> create(@Valid @RequestBody CustomerOpenOutDTO objDto) {
    CustomerOpenOut obj = service.fromDTO(objDto);
    obj = service.createCustomerOpenOut(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }


}