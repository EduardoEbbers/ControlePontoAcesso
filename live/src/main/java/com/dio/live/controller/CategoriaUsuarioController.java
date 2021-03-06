package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {
    @Autowired
    private CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public ResponseEntity<CategoriaUsuario> createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        try {
            if((categoriaUsuario.getIdCategoriaUsuario() == null)
                    || (categoriaUsuario.getDescricao() == null)) {
               throw new Error("Categoria Usuário Id e Descrição são Obrigatórios!");
            }
            if(categoriaUsuario.getIdCategoriaUsuario() <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    categoriaUsuarioService.create(categoriaUsuario),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> getAllCategoriaUsuario() {
        try {
            return new ResponseEntity<>(
                    categoriaUsuarioService.findAll(),
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

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("idCategoria") Long idCategoria) {
        try {
            if(idCategoria == null) {
                throw new Error("Categoria Usuário Id é Obrigatório!");
            }
            if(idCategoria <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    categoriaUsuarioService.findById(idCategoria),
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
    public ResponseEntity<CategoriaUsuario> updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        try {
            if((categoriaUsuario.getIdCategoriaUsuario() == null)
                    || (categoriaUsuario.getDescricao() == null)) {
                throw new Error("Categoria Usuário Id e Descrição são Obrigatórios!");
            }
            if(categoriaUsuario.getIdCategoriaUsuario() <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    categoriaUsuarioService.update(categoriaUsuario),
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

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity deleteCategoriaUsuario(@PathVariable("idCategoria") Long idCategoria) {
        try {
            if(idCategoria == null) {
                throw new Error("Categoria Usuário Id é Obrigatório!");
            }
            if(idCategoria <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            categoriaUsuarioService.delete(idCategoria);
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
