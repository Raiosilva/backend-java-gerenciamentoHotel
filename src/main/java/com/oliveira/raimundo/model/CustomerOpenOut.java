package com.oliveira.raimundo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "customer_open_out")
public class CustomerOpenOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "customer_id", nullable = false)
	private Long customerId;

	@Column(name = "addition", nullable = false)
	private Boolean add;

	@Column(name = "checkin_date", nullable = false)
	private LocalDateTime checkInDate;

	@Column(name = "checkout_date", nullable = false)
	private LocalDateTime checkOutDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer", referencedColumnName = "ID",
	insertable = false, nullable = false)
	private Customer customer;



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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.setCustomerId(customer.getId());
		this.customer = customer;
	}

	public CustomerOpenOut(){}

	public CustomerOpenOut(Long id, Long customerId, Boolean add, LocalDateTime checkInDate, LocalDateTime checkOutDate,
			Customer customer) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.add = add;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOpenOut other = (CustomerOpenOut) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static Optional<CustomerOpenOut> findById(Long id2) {
		return null;
	}

}
