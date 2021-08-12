package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
        this.jornadaTrabalhoService = jornadaTrabalhoService;
    }

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getAllJornadaTrabalho() {
        return jornadaTrabalhoService.findAllJornadaTrabalho();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaTrabalhoById(@PathVariable("idJornada") Long idJornada) {
        return ResponseEntity.ok(jornadaTrabalhoService.getJornadaTrabalhoById(idJornada).orElseThrow(() -> new NoSuchElementException("Not Found.")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }
}
