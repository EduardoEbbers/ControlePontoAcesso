package com.dio.live.service;

import com.dio.live.model.BancoHora;
import com.dio.live.model.Movimentacao;
import com.dio.live.repository.BancoHoraRepository;
import com.dio.live.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BancoHoraService {
    @Autowired
    private BancoHoraRepository bancoHoraRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public BancoHora create(BancoHora bancoHora) {
        try {
            Movimentacao mov = movimentacaoRepository
                    .findById(bancoHora.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            Optional<BancoHora> bancHora = bancoHoraRepository
                    .findById(bancoHora.getIdBancoHora());
            if(bancHora.isPresent()) {
                throw new Error("Banco Hora já existe!");
            }
            bancoHora.setMovimentacao(mov);
            var bancHoraRepo = bancoHoraRepository.save(bancoHora);
            bancHoraRepo.setIdMovimentacao(bancoHora.getIdMovimentacao());
            return bancHoraRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<BancoHora> findAll() {
        try {
            return bancoHoraRepository.findAll();
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public BancoHora findById(Long id) {
        try {
            return bancoHoraRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Banco Hora não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public BancoHora update(BancoHora bancoHora) {
        try {
            Movimentacao mov = movimentacaoRepository
                    .findById(bancoHora.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            bancoHoraRepository
                    .findById(bancoHora.getIdBancoHora())
                    .orElseThrow(() -> new NoSuchElementException("Banco Hora não existe!"));
            bancoHora.setMovimentacao(mov);
            var bancHoraRepo = bancoHoraRepository.save(bancoHora);
            bancHoraRepo.setIdMovimentacao(bancoHora.getIdMovimentacao());
            return bancHoraRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            bancoHoraRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Banco Hora não existe!"));
            bancoHoraRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
