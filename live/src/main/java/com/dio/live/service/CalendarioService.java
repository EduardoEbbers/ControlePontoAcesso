package com.dio.live.service;

import com.dio.live.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarioService {
    @Autowired
    private CalendarioRepository calendarioRepository;
}
