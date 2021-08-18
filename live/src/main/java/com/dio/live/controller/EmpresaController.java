package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        try {
            if((empresa.getIdEmpresa() == null)
                    || (empresa.getDescricao() == null)
                    || (empresa.getCnpj() == null)
                    || (empresa.getEndereco() == null)
                    || (empresa.getBairro() == null)
                    || (empresa.getCidade() == null)
                    || (empresa.getEstado() == null)
                    || (empresa.getTelefone() == null)) {
                throw new Error("Empresa Id, Descrição, CNPJ, Endereço, Bairro, Cidade, Estado e Telefone são Obrigatórios!");
            }
            if(empresa.getIdEmpresa() <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            if(empresa.getCnpj().length() > 14) {
                throw new Error("CNPJ deve possuir 14 dígitos!");
            }
            return new ResponseEntity<>(
                    empresaService.create(empresa),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresa() {
        try {
            return new ResponseEntity<>(
                    empresaService.findAll(),
                    HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) {
        try {
            if(idEmpresa == null) {
                throw new Error("Empresa Id é Obrigatório!");
            }
            if(idEmpresa <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            return new ResponseEntity<>(
                    empresaService.findById(idEmpresa),
                    HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa) {
        try {
            if((empresa.getIdEmpresa() == null)
                    || (empresa.getDescricao() == null)
                    || (empresa.getCnpj() == null)
                    || (empresa.getEndereco() == null)
                    || (empresa.getBairro() == null)
                    || (empresa.getCidade() == null)
                    || (empresa.getEstado() == null)
                    || (empresa.getTelefone() == null)) {
                throw new Error("Empresa Id, Descrição, CNPJ, Endereço, Bairro, Cidade, Estado e Telefone são Obrigatórios!");
            }
            if(empresa.getIdEmpresa() <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            return new ResponseEntity<>(
                    empresaService.update(empresa),
                    HttpStatus.OK
            );
        } catch(NoSuchElementException e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity deleteEmpresa(@PathVariable("idEmpresa") Long idEmpresa) {
        try {
            if(idEmpresa == null) {
                throw new Error("Empresa Id é Obrigatório!");
            }
            if(idEmpresa <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            empresaService.delete(idEmpresa);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch(NoSuchElementException e1) {
            return new ResponseEntity(
                    e1.getMessage(),
                    HttpStatus.NOT_FOUND);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
