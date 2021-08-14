package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.repository.MovimentacaoRepository;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BancoHorasService {
    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public BancoHoras create(BancoHoras bancoHoras) {
        try {
            movimentacaoRepository
                    .findById(bancoHoras.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            Optional<BancoHoras> bancHoras = bancoHorasRepository.findById(bancoHoras.getIdBancoHoras());
            if(bancHoras.isPresent()) {
                throw new Error("BancoHoras já existe!");
            }
            return bancoHorasRepository.save(bancoHoras);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<BancoHoras> findAll() {
        try {
            return bancoHorasRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public BancoHoras findById(Long id) {
        try {
            return bancoHorasRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("BancoHoras não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public BancoHoras update(BancoHoras bancoHoras) {
        try {
            movimentacaoRepository
                    .findById(bancoHoras.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            bancoHorasRepository
                    .findById(bancoHoras.getIdBancoHoras())
                    .orElseThrow(() -> new NoSuchElementException("BancoHoras não existe!"));
            return bancoHorasRepository.save(bancoHoras);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            bancoHorasRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("BancoHoras não existe!"));
            bancoHorasRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
