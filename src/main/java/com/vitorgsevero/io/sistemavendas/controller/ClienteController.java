package com.vitorgsevero.io.sistemavendas.controller;

import com.vitorgsevero.io.sistemavendas.exception.ResourceNotFoundException;
import com.vitorgsevero.io.sistemavendas.model.Cliente;
import com.vitorgsevero.io.sistemavendas.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@Api(value = "All Client operations", tags = "Client Controller")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ApiOperation(value = "It creates a new Client", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client created"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public Cliente createClient(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping
    @ApiOperation(value = "Return all clients", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all clients created"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "To find a Client by ID", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client by ID find"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public ResponseEntity<?> findClientById(@PathVariable(value = "id") Integer id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Associate not found."));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a specified Client", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete an Client by Id"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable(value = "id") Integer id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Associate not found."));
        clienteRepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
}
