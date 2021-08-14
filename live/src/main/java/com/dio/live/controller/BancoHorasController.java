package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.MovimentacaoService;
import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {
    @Autowired
    private BancoHorasService bancoHorasService;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        try {
            if((bancoHoras.getIdBancoHoras() == null) || (bancoHoras.getIdMovimentacao() == null) || (bancoHoras.getCategoriaUsuario() == null) || (bancoHoras.getDataTrabalhada() == null) || (bancoHoras.getQuantidadeHorasTrabalhadas() == null) || (bancoHoras.getSaldoHorasTrabalhadas() == null)) {
                throw new Error("Banco Horas Id, Movimentação Id, Categoria Usuário, Data Trabalhada, Quantidade Horas Trabalhadas e Saldo Horas Trabalhadas são Obrigatórios!");
            }
            if(bancoHoras.getIdBancoHoras() <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            if(bancoHoras.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHorasService.create(bancoHoras),
                    HttpStatus.CREATED);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<BancoHoras>> getAllBancoHoras() {
        try {
            return new ResponseEntity<>(
                    bancoHorasService.findAll(),
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

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHorasById(@PathVariable("idBancoHoras") Long idBancoHoras) {
        try {
            if(idBancoHoras == null) {
                throw new Error("BancoHoras Id é Obrigatório!");
            }
            if(idBancoHoras <= 0) {
                throw new Error("BancoHoras Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHorasService.findById(idBancoHoras),
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
    public ResponseEntity<BancoHoras> updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        try {
            if((bancoHoras.getIdBancoHoras() == null) || (bancoHoras.getIdMovimentacao() == null) || (bancoHoras.getCategoriaUsuario() == null) || (bancoHoras.getDataTrabalhada() == null) || (bancoHoras.getQuantidadeHorasTrabalhadas() == null) || (bancoHoras.getSaldoHorasTrabalhadas() == null)) {
                throw new Error("Banco Horas Id, Movimentação Id, Categoria Usuário, Data Trabalhada, Quantidade Horas Trabalhadas e Saldo Horas Trabalhadas são Obrigatórios!");
            }
            if(bancoHoras.getIdBancoHoras() <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            if(bancoHoras.getIdMovimentacao() <= 0) {
                throw new Error("Movimentação Id está incorreto!");
            }
            return new ResponseEntity<>(
                    bancoHorasService.update(bancoHoras),
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

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteBancoHoras(@PathVariable("idBancoHoras") Long idBancoHoras) {
        try {
            if(idBancoHoras == null) {
                throw new Error("Banco Horas Id é Obrigatório!");
            }
            if(idBancoHoras <= 0) {
                throw new Error("Banco Horas Id está incorreto!");
            }
            bancoHorasService.delete(idBancoHoras);
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
