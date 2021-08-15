package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaUsuarioService categoriaUsuarioService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private NivelAcessoService nivelAcessoService;

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;
    
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        try {
            if((usuario.getIdUsuario() == null)
                    || (usuario.getIdCategoriaUsuario() == null)
                    || (usuario.getIdEmpresa() == null)
                    || (usuario.getIdNivelAcesso() == null)
                    || (usuario.getIdJornadaTrabalho() == null)
                    || (usuario.getNome() == null)
                    || (usuario.getToleranciaAtraso() == null)
                    || (usuario.getInicioJornadaTrabalho() == null)
                    || (usuario.getSaidaJornadaTrabalho() == null)) {
                throw new Error("Usuário Id, Categoria Usuário Id, Empresa Id, Nível Acesso Id, Jornada Trabalho Id, Nome, Tolerância Atraso, Início Jornada Trabalho e Saída Jornada Trabalho são Obrigatórios!");
            }
            if(usuario.getIdUsuario() <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            if(usuario.getIdCategoriaUsuario() <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            if(usuario.getIdEmpresa() <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            if(usuario.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            if(usuario.getIdJornadaTrabalho() <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    usuarioService.create(usuario),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        try {
            return new ResponseEntity<>(
                    usuarioService.findAll(),
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

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Long idUsuario) {
        try {
            if(idUsuario == null) {
                throw new Error("Usuário Id é Obrigatório!");
            }
            if(idUsuario <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    usuarioService.findById(idUsuario),
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
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        try {
            if((usuario.getIdUsuario() == null)
                    || (usuario.getIdCategoriaUsuario() == null)
                    || (usuario.getIdEmpresa() == null)
                    || (usuario.getIdNivelAcesso() == null)
                    || (usuario.getIdJornadaTrabalho() == null)
                    || (usuario.getNome() == null)
                    || (usuario.getToleranciaAtraso() == null)
                    || (usuario.getInicioJornadaTrabalho() == null)
                    || (usuario.getSaidaJornadaTrabalho() == null)) {
                throw new Error("Usuário Id, Categoria Usuário Id, Empresa Id, Nível Acesso Id, Jornada Trabalho Id, Nome, Tolerância Atraso, Início Jornada Trabalho e Saída Jornada Trabalho são Obrigatórios!");
            }
            if(usuario.getIdUsuario() <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            if(usuario.getIdCategoriaUsuario() <= 0) {
                throw new Error("Categoria Usuário Id está incorreto!");
            }
            if(usuario.getIdEmpresa() <= 0) {
                throw new Error("Empresa Id está incorreto!");
            }
            if(usuario.getIdNivelAcesso() <= 0) {
                throw new Error("Nível Acesso Id está incorreto!");
            }
            if(usuario.getIdJornadaTrabalho() <= 0) {
                throw new Error("Jornada Trabalho Id está incorreto!");
            }
            return new ResponseEntity<>(
                    usuarioService.update(usuario),
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

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity deleteUsuario(@PathVariable("idUsuario") Long idUsuario) {
        try {
            if(idUsuario == null) {
                throw new Error("Usuário Id é Obrigatório!");
            }
            if(idUsuario <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            usuarioService.delete(idUsuario);
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
