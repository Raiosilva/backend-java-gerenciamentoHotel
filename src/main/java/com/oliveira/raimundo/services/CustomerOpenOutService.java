package com.oliveira.raimundo.services;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.oliveira.raimundo.controller.CheckInDTO;
import com.oliveira.raimundo.controller.CustomerDTO;
import com.oliveira.raimundo.controller.CustomerOpenOutDTO;
import com.oliveira.raimundo.model.Customer;
import com.oliveira.raimundo.model.CustomerCheckInOutPut;
import com.oliveira.raimundo.model.CustomerOpenOut;
import com.oliveira.raimundo.repositories.CustomerOpenOutRepository;
import com.oliveira.raimundo.services.exceptions.DataIntegrityException;
import com.oliveira.raimundo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CustomerOpenOutService {

  @Autowired
  private CustomerOpenOutRepository repo;

  public CustomerOpenOut search(Long customerId) {
    Optional<CustomerOpenOut> obj = repo.findByCustomerId(customerId);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Documento: " + customerId + ", Tipo: " + CustomerOpenOut.class.getName()));
  }

  public CustomerOpenOut createCustomerOpenOut(CustomerOpenOut obj) {
    obj.setId(null);
    return repo.saveAll(obj);
  }

  // validando na criação do cliente e na atualização
  public CustomerOpenOut fromDTO(CustomerOpenOutDTO objDto) {

    throw new UnsupportedOperationException();
  }

  public CustomerOpenOut update(CustomerOpenOut obj) {
    search(obj.getId());
    return repo.saveAll(obj);
  }

  public void delete(Long id) {
    search(id);
    try {
      repo.deleteById(id);
    } catch (DataIntegrityException e) {
      throw new DataIntegrityException("Não pode excluir!");
    }
  }

  // Paginação
  public Page<CustomerOpenOut> searchPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
    return repo.findAll(pageRequest);
  }

  /**
   * Criar CheckIn
   *
   * @param checkinDTO
   * @return
   */
  public CustomerCheckInOutPut createOrUpdateCheckIn(CheckInDTO checkinDTO) {
    CustomerOpenOut checkin = new CustomerOpenOut();

    if (checkinDTO.id != null) {
      Optional<CustomerOpenOut> c = repo.findAllById(checkinDTO.id);
      checkin = c.isPresent() ? c.get() : checkin;
    }

    Optional<Customer> customer = repo.findCustomerById(checkinDTO.customerId);
    if (customer.isPresent()) {
      checkin.setCustomer(customer.isPresent() ? customer.get() : null);
    } else {
      throw new IllegalArgumentException();
    }

    checkin.setAdd(checkinDTO.add);
    checkin.setCheckInDate(checkinDTO.inDate);
    checkin.setCheckOutDate(checkinDTO.outDate);
    repo.save(checkin);
    return toCheckinDTO(checkin);
  }

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

  // private String format(Double value){
  //   DecimalFormat df = new DecimalFormat("0.00");
  //   return df.format(value);
  // }


  /**
   * @param checkin informações da hospedagem do cliente.
   * @return
   *
   */

  //  private Double getValueHosted(CustomerOpenOut openOut) {
  //   //lógica
  //   return ;
  //  }

  // private Double getValueDaysWeek(List<LocalDateTime> hostedDay, LocalDateTime endDate, boolean add) {
  //   Long weekend = hostedDay.stream().filter(data -> data.getDayOfWeek()
  //   .equals(DayOfWeek.SATURDAY) && data.getDayOfWeek().equals(DayOfWeek.SUNDAY)).count();


  // }

  // private Double getWeekValueDay(List<LocalDateTime> hostedDay, boolean add) {


  //   return ;
  // }



}