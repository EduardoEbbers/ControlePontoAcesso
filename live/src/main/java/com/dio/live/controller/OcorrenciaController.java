package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        try {
            if((ocorrencia.getIdOcorrencia() == null) || (ocorrencia.getNome() == null) || (ocorrencia.getDescricao() == null)) {
                throw new Error("Ocorrência Id, Nome e Descrição são Obrigatórios!");
            }
            if(ocorrencia.getIdOcorrencia() <= 0) {
                throw new Error("Ocorrencia Id está incorreto!");
            }
            return new ResponseEntity<>(
                    ocorrenciaService.create(ocorrencia),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> getAllOcorrencia() {
        try {
            return new ResponseEntity<>(
                    ocorrenciaService.findAll(),
                    HttpStatus.OK);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        } catch(NoSuchElementException e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable("idOcorrencia") Long idOcorrencia) {
        try {
            if(idOcorrencia == null) {
                throw new Error("Ocorrência Id é Obrigatório!");
            }
            if(idOcorrencia <= 0) {
                throw new Error("Ocorrência Id está incorreto!");
            }
            return new ResponseEntity<>(
                    ocorrenciaService.findById(idOcorrencia),
                    HttpStatus.OK);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        } catch(NoSuchElementException e1) {
            return new ResponseEntity(
                    e1.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        try {
            if((ocorrencia.getIdOcorrencia() == null) || (ocorrencia.getNome() == null) || (ocorrencia.getDescricao() == null)) {
                throw new Error("Ocorrência Id, Nome e Descrição são Obrigatórios!");
            }
            if(ocorrencia.getIdOcorrencia() <= 0) {
                throw new Error("Ocorrência Id está incorreto!");
            }
            return new ResponseEntity<>(
                    ocorrenciaService.update(ocorrencia),
                    HttpStatus.OK
            );
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        } catch(NoSuchElementException e1) {
            return new ResponseEntity(
                    e1.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity deleteOcorrencia(@PathVariable("idOcorrencia") Long idOcorrencia) {
        try {
            if(idOcorrencia == null) {
                throw new Error("Ocorrência Id é Obrigatório!");
            }
            if(idOcorrencia <= 0) {
                throw new Error("Ocorrência Id está incorreto!");
            }
            ocorrenciaService.delete(idOcorrencia);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        } catch(NoSuchElementException e1) {
            return new ResponseEntity(
                    e1.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }
}
