package com.dio.live.controller;


import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho) {
        try {
            if((jornadaTrabalho.getIdJornadaTrabalho() == null) || (jornadaTrabalho.getDescricao() == null)) {
                throw new Error("Jornada Trabalho Id e Descrição são Obrigatórios!");
            }
            if(jornadaTrabalho.getIdJornadaTrabalho() <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    jornadaTrabalhoService.create(jornadaTrabalho),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getAllJornadaTrabalho() {
        try {
            return new ResponseEntity<>(
                    jornadaTrabalhoService.findAll(),
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

    @GetMapping("/{idJornadaTrabalho}")
    public ResponseEntity<JornadaTrabalho> getJornadaTrabalhoById(@PathVariable("idJornadaTrabalho") Long idJornadaTrabalho) {
        try {
            if(idJornadaTrabalho == null) {
                throw new Error("Jornada Trabalho Id é Obrigatório!");
            }
            if(idJornadaTrabalho <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    jornadaTrabalhoService.findById(idJornadaTrabalho),
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
    public ResponseEntity<JornadaTrabalho> updateJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho) {
        try {
            if((jornadaTrabalho.getIdJornadaTrabalho() == null) || (jornadaTrabalho.getDescricao() == null)) {
                throw new Error("Jornada Trabalho Id e Descrição são Obrigatórios!");
            }
            if(jornadaTrabalho.getIdJornadaTrabalho() <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    jornadaTrabalhoService.update(jornadaTrabalho),
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

    @DeleteMapping("/{idJornadaTrabalho}")
    public ResponseEntity deleteJornadaTrabalho(@PathVariable("idJornadaTrabalho") Long idJornadaTrabalho) {
        try {
            if(idJornadaTrabalho == null) {
                throw new Error("Jornada Trabalho Id é Obrigatório!");
            }
            if(idJornadaTrabalho <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            jornadaTrabalhoService.delete(idJornadaTrabalho);
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
