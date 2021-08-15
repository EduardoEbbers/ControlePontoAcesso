package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {
    @Autowired
    private TipoDataService tipoDataService;

    @PostMapping
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData) {
        try {
            if((tipoData.getIdTipoData() == null)
                    || (tipoData.getDescricao() == null)) {
                throw new Error("Tipo Data Id e Descrição são Obrigatórios!");
            }
            if(tipoData.getIdTipoData() <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            return new ResponseEntity<>(
                    tipoDataService.create(tipoData),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoData>> getAllTipoData() {
        try {
            return new ResponseEntity<>(
                    tipoDataService.findAll(),
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

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("idTipoData") Long idTipoData) {
        try {
            if(idTipoData == null) {
                throw new Error("Tipo Data Id é Obrigatório!");
            }
            if(idTipoData <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            return new ResponseEntity<>(
                    tipoDataService.findById(idTipoData),
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
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData) {
        try {
            if((tipoData.getIdTipoData() == null)
                    || (tipoData.getDescricao() == null)) {
                throw new Error("Tipo Data Id e Descrição são Obrigatórios!");
            }
            if(tipoData.getIdTipoData() <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            return new ResponseEntity<>(
                    tipoDataService.update(tipoData),
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

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity deleteTipoData(@PathVariable("idTipoData") Long idTipoData) {
        try {
            if(idTipoData == null) {
                throw new Error("Tipo Data Id é Obrigatório!");
            }
            if(idTipoData <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            tipoDataService.delete(idTipoData);
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
