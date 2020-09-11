package com.vitorgsevero.io.sistemavendas.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 */

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue
    private int id;

    private int identificadorVenda = 003;

    private int quantidade;

    private double precoItem;

    private String nomeVendedor;


}
