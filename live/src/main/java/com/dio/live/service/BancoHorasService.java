package com.dio.live.service;

import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoHorasService {
    @Autowired
    private BancoHorasRepository bancoHorasRepository;
}
