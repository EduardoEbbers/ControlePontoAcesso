package com.dio.live.controller;

import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tipoData")
public class TipoDataController {
    @Autowired
    private TipoDataService tipoDataService;
}
