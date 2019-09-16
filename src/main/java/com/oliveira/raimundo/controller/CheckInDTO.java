package com.oliveira.raimundo.controller;

import java.io.Serializable;
import java.time.LocalDateTime;


public class CheckInDTO implements Serializable {
	private static final long serialVersionUID = 1L;

/**
     * Identificador único do checkin
     */
    public Long id;

    /**
     * Id do cliente
     */
    public Long customerId;

    /**
     * Data de entrada
     */
    public LocalDateTime inDate;

    /**
     * Data de saída
     */
    public LocalDateTime outDate;

    /**
     * Documento do cliente
     */
    public boolean add;


}
