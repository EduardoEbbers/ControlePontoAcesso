package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private CalendarioService calendarioService;

    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao) {
        try {
            if((movimentacao.getIdMovimentacao() == null)
                    || (movimentacao.getIdUsuario() == null)
                    || (movimentacao.getIdOcorrencia() == null)
                    || (movimentacao.getIdCalendario() == null)
                    || (movimentacao.getEntradaDataMovimentacao() == null)
                    || (movimentacao.getSaidaDataMovimentacao() == null)
                    || (movimentacao.getPeriodoPermanencia() == null)) {
                throw new Error("Movimentação Id, Usuário Id, Ocorrência Id, Calendário Id, Entrada Data Movimentação, Saída Data Movimentação e Período Permanência são Obrigatórios!");
            }
            if(movimentacao.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            if(movimentacao.getIdUsuario() <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            if(movimentacao.getIdOcorrencia() <= 0) {
                throw new Error("Ocorrência Id está incorreto!");
            }
            if(movimentacao.getIdCalendario() <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    movimentacaoService.create(movimentacao),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> getAllMovimentacao() {
        try {
            return new ResponseEntity<>(
                    movimentacaoService.findAll(),
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

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable("idMovimentacao") Long idMovimentacao) {
        try {
            if(idMovimentacao == null) {
                throw new Error("Movimentação Id é Obrigatório!");
            }
            if(idMovimentacao <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            return new ResponseEntity<>(
                    movimentacaoService.findById(idMovimentacao),
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
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody Movimentacao movimentacao) {
        try {
            if((movimentacao.getIdMovimentacao() == null)
                    || (movimentacao.getIdUsuario() == null)
                    || (movimentacao.getIdOcorrencia() == null)
                    || (movimentacao.getIdCalendario() == null)
                    || (movimentacao.getEntradaDataMovimentacao() == null)
                    || (movimentacao.getSaidaDataMovimentacao() == null)
                    || (movimentacao.getPeriodoPermanencia() == null)) {
                throw new Error("Movimentação Id, Usuário Id, Ocorrência Id, Calendário Id, Entrada Data Movimentação, Saída Data Movimentação e Período Permanência são Obrigatórios!");
            }
            if(movimentacao.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            if(movimentacao.getIdUsuario() <= 0) {
                throw new Error("Usuário Id está incorreto!");
            }
            if(movimentacao.getIdOcorrencia() <= 0) {
                throw new Error("Ocorrência Id está incorreto!");
            }
            if(movimentacao.getIdCalendario() <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    movimentacaoService.update(movimentacao),
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

    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity deleteCalendario(@PathVariable("idMovimentacao") Long idMovimentacao) {
        try {
            if(idMovimentacao == null) {
                throw new Error("Movimentação Id é Obrigatório!");
            }
            if(idMovimentacao <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            movimentacaoService.delete(idMovimentacao);
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
