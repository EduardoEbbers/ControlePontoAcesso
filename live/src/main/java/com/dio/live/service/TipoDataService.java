package com.dio.live.service;

import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDataService {
    @Autowired
    private TipoDataRepository tipoDataRepository;
}
