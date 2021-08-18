package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.model.Movimentacao;
import com.dio.live.model.Ocorrencia;
import com.dio.live.model.Usuario;
import com.dio.live.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private BancoHoraRepository bancoHoraRepository;
    public Movimentacao create(Movimentacao movimentacao) {
        try {
            Usuario usuar = usuarioRepository
                    .findById(movimentacao.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            Ocorrencia ocorr = ocorrenciaRepository
                    .findById(movimentacao.getIdOcorrencia())
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            Calendario calend = calendarioRepository
                    .findById(movimentacao.getIdCalendario())
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            Optional<Movimentacao> mov = movimentacaoRepository
                    .findById(movimentacao.getIdMovimentacao());
            if(mov.isPresent()) {
                throw new Error("Movimentação já existe!");
            }
            movimentacao.setUsuario(usuar);
            movimentacao.setOcorrencia(ocorr);
            movimentacao.setCalendario(calend);
            var movRepo = movimentacaoRepository.save(movimentacao);
            movRepo.setIdUsuario(movimentacao.getIdUsuario());
            movRepo.setIdOcorrencia(movimentacao.getIdOcorrencia());
            movRepo.setIdCalendario(movimentacao.getIdCalendario());
            return movRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Movimentacao> findAll() {
        try {
            return movimentacaoRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Movimentacao findById(Long id) {
        try {
            return movimentacaoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Movimentacao update(Movimentacao movimentacao) {
        try {
            Usuario usuar = usuarioRepository
                    .findById(movimentacao.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            Ocorrencia ocorr = ocorrenciaRepository
                    .findById(movimentacao.getIdOcorrencia())
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            Calendario calend = calendarioRepository
                    .findById(movimentacao.getIdCalendario())
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            movimentacaoRepository
                    .findById(movimentacao.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            movimentacao.setUsuario(usuar);
            movimentacao.setOcorrencia(ocorr);
            movimentacao.setCalendario(calend);
            var movRepo = movimentacaoRepository.save(movimentacao);
            movRepo.setIdUsuario(movimentacao.getIdUsuario());
            movRepo.setIdOcorrencia(movimentacao.getIdOcorrencia());
            movRepo.setIdCalendario(movimentacao.getIdCalendario());
            return movRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            var matchBancHora = bancoHoraRepository
                    .findAll()
                    .stream()
                    .anyMatch(bancoHora -> bancoHora.getMovimentacao().getIdMovimentacao() == id);
            if(matchBancHora) {
                throw new Error("Movimentação possui Banco Hora!");
            }
            movimentacaoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            movimentacaoRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
