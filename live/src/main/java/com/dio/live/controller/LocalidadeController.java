package com.dio.live.controller;

import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    private LocalidadeService localidadeService;
}
