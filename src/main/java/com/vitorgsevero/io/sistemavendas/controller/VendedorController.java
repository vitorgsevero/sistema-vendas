package com.vitorgsevero.io.sistemavendas.controller;

import com.vitorgsevero.io.sistemavendas.model.Vendedor;
import com.vitorgsevero.io.sistemavendas.repository.VendedorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/receita")
@Api(value = "All Vendedor operations", tags = "Vendedor Controller")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @PostMapping
    @ApiOperation(value = "It creates a new Vendedor", response = Vendedor[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendedor CREATED"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public Vendedor save(@RequestBody Vendedor vendedor) throws InterruptedException {
        return vendedorRepository.save(vendedor);
    }


}
