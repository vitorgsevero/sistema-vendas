package com.vitorgsevero.io.sistemavendas.model;

import com.vitorgsevero.io.sistemavendas.auditing.VendedorAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 */
@Data
@Entity
public class Vendedor extends VendedorAudit {

    @Id
    @GeneratedValue
    private Long id;

    private int identificadorVendedor = 001;

    private String cpf;

    private String nome;

    private double salario;


}
