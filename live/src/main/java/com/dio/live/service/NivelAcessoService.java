package com.dio.live.service;

import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelAcessoService {
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;
}
