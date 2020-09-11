package com.vitorgsevero.io.sistemavendas.model;

import com.vitorgsevero.io.sistemavendas.auditing.VendedorAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private double salario;


}
