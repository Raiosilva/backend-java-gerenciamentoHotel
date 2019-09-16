package com.oliveira.raimundo.repositories;

import java.util.Optional;

import com.oliveira.raimundo.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findAllById(Long id);

	// Optional<Customer> findById(Long id);

  // Customer findByCustomerById(Long id);

  // Customer findByDocumentId(String documentId);



  // PageResult customerSearch(String q, Long page, Long size);

  // PageResult findCustomersToCheckin(boolean pastHosted,Long page, Long size);

  // @Override
  // public PageResult customerSearch(String a, Long page, Long size) {
  //   CCustomer customer = CCustomer.customerHotel;
  //   JPAQuery<Customer> query = select(customer).from(customer);
  //   if(!StringUtils.isEmpty(q)) {
  //     String[] t = q.replaceAll("\\s+", " ").trim().split("\\s");
  //     BooleanExpression predicate = null;
  //     for(String t : t) {
  //       BooleanExpression namePredicate = customer.name.containsIgnoreCase(t);
  //       BooleanExpression registerNumberPredicate = customer.registerId.containsIgnoreCase(t);
  //       BooleanExpression phoneNumberPredicate = customer.phone.containsIgnoreCase(t);
  //       predicate = predicate == null ? namePredicate.or(registerNumberPredicate).or(phoneNumberPredicate) : namePredicate.or(registerNumberPredicate).or(phoneNumberPredicate);
  //     }
  //     if (predicate != null) {
  //       query.where(predicate);
  //     }
  //   }
  //   PageRequest page = new PageRequest(page, size);
  //   return getPagedQuery(query, page);
  // }


  // @Override
  // public PageResult findCustomersToCheckin(boolean pastHosted, Long page, Long size) {
  //   LocalDateTime now = LocalDateTime.now();
  //   CCustomerOpenOut openout = CCustomerOpenOut.customerOpenOut;
  //   JPAQuery<UUID> check = select(openout.customerId).from(openout);
  //   if (pastHosted) {
  //     check.where(openout.checkOuDate.before(now));
  //   } else {
  //     check.where(openout.checkOuDate.after(now).and(openout.checkInDate.before(now)));
  //   }

  //   CCustomer customer = CCustomer.customerHotel;
  //   JPAQuery<Customer> query = select(customer).from(customer);
  //   query.where(customer.id.in(checkInQuery));

  //   PageRequest pageRequest = new PageRequest(page, size);
  //   return getPagedQuery(query, pageRequest);
  // }
}
