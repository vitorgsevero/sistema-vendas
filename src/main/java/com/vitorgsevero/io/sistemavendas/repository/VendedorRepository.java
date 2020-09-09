package com.vitorgsevero.io.sistemavendas.repository;

import com.vitorgsevero.io.sistemavendas.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
