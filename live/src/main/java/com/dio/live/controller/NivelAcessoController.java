package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelAcesso")
public class NivelAcessoController {
    @Autowired
    private NivelAcessoService nivelAcessoService;

    @PostMapping
    public ResponseEntity<NivelAcesso> createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        try {
            if((nivelAcesso.getIdNivelAcesso() == null)
                    || (nivelAcesso.getDescricao() == null)) {
                throw new Error("Nível Acesso Id e Descrição são Obrigatórios!");
            }
            if(nivelAcesso.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            return new ResponseEntity<>(
                    nivelAcessoService.create(nivelAcesso),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<NivelAcesso>> getAllNivelAcesso() {
        try {
            return new ResponseEntity<>(
                    nivelAcessoService.findAll(),
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

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso") Long idNivelAcesso) {
        try {
            if(idNivelAcesso == null) {
                throw new Error("Nível Acesso Id é Obrigatório!");
            }
            if(idNivelAcesso <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            return new ResponseEntity<>(
                    nivelAcessoService.findById(idNivelAcesso),
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
    public ResponseEntity<NivelAcesso> updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        try {
            if((nivelAcesso.getIdNivelAcesso() == null)
                    || (nivelAcesso.getDescricao() == null)) {
                throw new Error("Nível Acesso Id e Descrição são Obrigatórios!");
            }
            if(nivelAcesso.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            return new ResponseEntity<>(
                    nivelAcessoService.update(nivelAcesso),
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

    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity deleteNivelAcesso(@PathVariable("idNivelAcesso") Long idNivelAcesso) {
        try {
            if(idNivelAcesso == null) {
                throw new Error("Nível Acesso Id é Obrigatório!");
            }
            if(idNivelAcesso <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            nivelAcessoService.delete(idNivelAcesso);
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
