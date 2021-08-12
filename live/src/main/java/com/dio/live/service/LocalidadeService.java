package com.dio.live.service;

import com.dio.live.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {
    @Autowired
    private LocalidadeRepository localidadeRepository;
}
