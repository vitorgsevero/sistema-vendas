package com.vitorgsevero.io.sistemavendas.repository;

import com.vitorgsevero.io.sistemavendas.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
