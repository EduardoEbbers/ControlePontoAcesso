package com.dio.live.controller;

import com.dio.live.model.BancoHora;
import com.dio.live.service.BancoHoraService;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHora")
public class BancoHoraController {
    @Autowired
    private BancoHoraService bancoHoraService;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<BancoHora> createBancoHoras(@RequestBody BancoHora bancoHora) {
        try {
            if((bancoHora.getIdBancoHora() == null)
                    || (bancoHora.getIdMovimentacao() == null)
                    || (bancoHora.getCategoriaUsuario() == null)
                    || (bancoHora.getDataTrabalhada() == null)
                    || (bancoHora.getQuantidadeHorasTrabalhada() == null)
                    || (bancoHora.getSaldoHorasTrabalhada() == null)) {
                throw new Error("Banco Horas Id, Movimentação Id, Categoria Usuário, Data Trabalhada, Quantidade Horas Trabalhada e Saldo Horas Trabalhada são Obrigatórios!");
            }
            if(bancoHora.getIdBancoHora() <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            if(bancoHora.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHoraService.create(bancoHora),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<BancoHora>> getAllBancoHoras() {
        try {
            return new ResponseEntity<>(
                    bancoHoraService.findAll(),
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

    @GetMapping("/{idBancoHora}")
    public ResponseEntity<BancoHora> getBancoHorasById(@PathVariable("idBancoHora") Long idBancoHora) {
        try {
            if(idBancoHora == null) {
                throw new Error("Banco Horas Id é Obrigatório!");
            }
            if(idBancoHora <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHoraService.findById(idBancoHora),
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
    public ResponseEntity<BancoHora> updateBancoHoras(@RequestBody BancoHora bancoHora) {
        try {
            if((bancoHora.getIdBancoHora() == null)
                    || (bancoHora.getIdMovimentacao() == null)
                    || (bancoHora.getCategoriaUsuario() == null)
                    || (bancoHora.getDataTrabalhada() == null)
                    || (bancoHora.getQuantidadeHorasTrabalhada() == null)
                    || (bancoHora.getSaldoHorasTrabalhada() == null)) {
                throw new Error("Banco Horas Id, Movimentação Id, Categoria Usuário, Data Trabalhada, Quantidade Horas Trabalhada e Saldo Horas Trabalhada são Obrigatórios!");
            }
            if(bancoHora.getIdBancoHora() <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            if(bancoHora.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHoraService.update(bancoHora),
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

    @DeleteMapping("/{idBancoHora}")
    public ResponseEntity deleteBancoHoras(@PathVariable("idBancoHora") Long idBancoHora) {
        try {
            if(idBancoHora == null) {
                throw new Error("Banco Horas Id é Obrigatório!");
            }
            if(idBancoHora <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            bancoHoraService.delete(idBancoHora);
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
