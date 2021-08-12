package com.dio.live.controller;

import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;
}
