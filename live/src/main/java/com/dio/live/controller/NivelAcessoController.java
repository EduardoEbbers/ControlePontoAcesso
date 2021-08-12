package com.dio.live.controller;

import com.dio.live.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NivelAcessoController {
    @Autowired
    private NivelAcessoService nivelAcessoService;
}
