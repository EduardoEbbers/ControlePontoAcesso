package com.dio.live.controller;

import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;
}
