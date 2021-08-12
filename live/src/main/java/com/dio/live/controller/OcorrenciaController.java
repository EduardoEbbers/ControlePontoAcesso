package com.dio.live.controller;

import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;
}
