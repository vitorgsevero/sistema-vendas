package com.vitorgsevero.io.sistemavendas.controller;

import com.vitorgsevero.io.sistemavendas.exception.ResourceNotFoundException;
import com.vitorgsevero.io.sistemavendas.model.Cliente;
import com.vitorgsevero.io.sistemavendas.model.Venda;
import com.vitorgsevero.io.sistemavendas.repository.ClienteRepository;
import com.vitorgsevero.io.sistemavendas.repository.VendaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
@Api(value = "All selling operations", tags = "Selling Controller")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping
    @ApiOperation(value = "It creates a new selling", response = Venda[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Selling done"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public Venda createSelling(@RequestBody Venda venda){
        return vendaRepository.save(venda);
    }

    @GetMapping
    @ApiOperation(value = "Return all selling", response = Venda[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all selling"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(vendaRepository.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "To find a Selling by ID", response = Venda[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Selling by ID find"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public ResponseEntity<?> findSellingById(@PathVariable(value = "id") Long id){
        Venda venda = vendaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Selling not found."));
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a specified Selling", response = Venda[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete an selling by Id"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSelling(@PathVariable(value = "id") Long id){
        Venda venda = vendaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Selling not found."));
        vendaRepository.delete(venda);
        return ResponseEntity.ok().build();
    }

}
