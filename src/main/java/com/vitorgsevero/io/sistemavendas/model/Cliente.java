package com.vitorgsevero.io.sistemavendas.model;

import com.sun.istack.NotNull;
import com.vitorgsevero.io.sistemavendas.auditing.ClienteAudit;
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
public class Cliente extends ClienteAudit {

    @Id
    @GeneratedValue
    private Long id;

    private int identificadorCliente = 002;

    @NotBlank(message = "CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String businessArea;


}
