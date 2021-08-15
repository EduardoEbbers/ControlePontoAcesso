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
            if((jornadaTrabalho.getIdJornadaTrabalho() == null)
                    || (jornadaTrabalho.getDescricao() == null)) {
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

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaTrabalhoById(@PathVariable("idJornada") Long idJornada) {
        try {
            if(idJornada == null) {
                throw new Error("Jornada Trabalho Id é Obrigatório!");
            }
            if(idJornada <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    jornadaTrabalhoService.findById(idJornada),
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
    public ResponseEntity<JornadaTrabalho> updateJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho) {
        try {
            if((jornadaTrabalho.getIdJornadaTrabalho() == null)
                    || (jornadaTrabalho.getDescricao() == null)) {
                throw new Error("Jornada Trabalho Id e Descrição são Obrigatórios!");
            }
            if(jornadaTrabalho.getIdJornadaTrabalho() <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    jornadaTrabalhoService.update(jornadaTrabalho),
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

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteJornadaTrabalho(@PathVariable("idJornada") Long idJornada) {
        try {
            if(idJornada == null) {
                throw new Error("Jornada Trabalho Id é Obrigatório!");
            }
            if(idJornada <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            jornadaTrabalhoService.delete(idJornada);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
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
}
