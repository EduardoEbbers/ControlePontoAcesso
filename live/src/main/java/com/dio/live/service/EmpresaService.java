package com.dio.live.service;

import com.dio.live.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
}
