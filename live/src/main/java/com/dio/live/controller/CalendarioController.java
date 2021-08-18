package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import com.dio.live.service.TipoDataService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @Autowired
    private TipoDataService tipoDataService;

    @PostMapping
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario) {
        try {
            if(calendario.getDataEspecial() == null) {
                throw new Error("Data Especial é Obrigatório com o formato DD/MM/YYYY");
            }
            if((calendario.getIdCalendario() == null)
                    || (calendario.getIdTipoData() == null)
                    || (calendario.getDescricao() == null)) {
                throw new Error("Calendário Id, Tipo Data Id e Descrição são Obrigatórios!");
            }
            if(calendario.getIdCalendario() <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            if(calendario.getIdTipoData() <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            return new ResponseEntity<>(
                    calendarioService.create(calendario),
                    HttpStatus.CREATED);
        }  catch(NoSuchElementException e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        } catch(Error e) {
            return new ResponseEntity(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Calendario>> getAllCalendario() {
        try {
            return new ResponseEntity<>(
                    calendarioService.findAll(),
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

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable("idCalendario") Long idCalendario) {
        try {
            if(idCalendario == null) {
                throw new Error("Calendário Id é Obrigatório!");
            }
            if(idCalendario <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            return new ResponseEntity<>(
                    calendarioService.findById(idCalendario),
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
    public ResponseEntity<Calendario> updateCalendario(@RequestBody Calendario calendario) {
        try {
            if((calendario.getIdCalendario() == null)
                    || (calendario.getIdTipoData() == null)
                    || (calendario.getDescricao() == null)
                    || (calendario.getDataEspecial() == null)) {
                throw new Error("Calendário Id, Tipo Data Id, Descrição e Data Especial são Obrigatórios!");
            }
            if(calendario.getIdCalendario() <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            if(calendario.getIdTipoData() <= 0) {
                throw new Error("Tipo Data Id está incorreto!");
            }
            return new ResponseEntity<>(
                    calendarioService.update(calendario),
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

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity deleteCalendario(@PathVariable("idCalendario") Long idCalendario) {
        try {
            if(idCalendario == null) {
                throw new Error("Calendário Id é Obrigatório!");
            }
            if(idCalendario <= 0) {
                throw new Error("Calendário Id está incorreto!");
            }
            calendarioService.delete(idCalendario);
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
