package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    private LocalidadeService localidadeService;

    @Autowired
    private NivelAcessoService nivelAcessoService;

    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade) {
        try {
            if((localidade.getIdLocalidade() == null)
                    || (localidade.getIdNivelAcesso() == null)
                    || (localidade.getDescricao() == null)) {
                throw new Error("Localidade Id, Nível Acesso Id e Descrição são Obrigatórios!");
            }
            if(localidade.getIdLocalidade() <= 0) {
                throw new Error("Localidade Id está incorreto!");
            }
            if(localidade.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            return new ResponseEntity<>(
                    localidadeService.create(localidade),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Localidade>> getAllLocalidade() {
        try {
            return new ResponseEntity<>(
                    localidadeService.findAll(),
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

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) {
        try {
            if(idLocalidade == null) {
                throw new Error("Localidade Id é Obrigatório!");
            }
            if(idLocalidade <= 0) {
                throw new Error("Localidade Id está incorreto!");
            }
            return new ResponseEntity<>(
                    localidadeService.findById(idLocalidade),
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
    public ResponseEntity<Localidade> updateLocalidade(@RequestBody Localidade localidade) {
        try {
            if((localidade.getIdLocalidade() == null)
                    || (localidade.getIdNivelAcesso() == null)
                    || (localidade.getDescricao() == null)) {
                throw new Error("Localidade Id, Nível Acesso Id e Descrição são Obrigatórios!");
            }
            if(localidade.getIdLocalidade() <= 0) {
                throw new Error("Localidade Id está incorreto!");
            }
            if(localidade.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            return new ResponseEntity<>(
                    localidadeService.update(localidade),
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

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity deleteLocalidade(@PathVariable("idLocalidade") Long idLocalidade) {
        try {
            if(idLocalidade == null) {
                throw new Error("Localidade Id é Obrigatório!");
            }
            if(idLocalidade <= 0) {
                throw new Error("Localidade Id está incorreto!");
            }
            localidadeService.delete(idLocalidade);
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
