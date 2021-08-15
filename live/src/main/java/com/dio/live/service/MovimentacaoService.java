package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.CalendarioRepository;
import com.dio.live.repository.MovimentacaoRepository;
import com.dio.live.repository.OcorrenciaRepository;
import com.dio.live.repository.UsuarioRepository;
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
    
    public Movimentacao create(Movimentacao movimentacao) {
        try {
            usuarioRepository
                    .findById(movimentacao.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            ocorrenciaRepository
                    .findById(movimentacao.getIdOcorrencia())
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            calendarioRepository
                    .findById(movimentacao.getIdCalendario())
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            Optional<Movimentacao> mov = movimentacaoRepository
                    .findById(movimentacao.getIdMovimentacao());
            if(mov.isPresent()) {
                throw new Error("Movimentação já existe!");
            }
            return movimentacaoRepository.save(movimentacao);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Movimentacao> findAll() {
        try {
            return movimentacaoRepository.findAll();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Movimentações não existem!");
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
            usuarioRepository
                    .findById(movimentacao.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            ocorrenciaRepository
                    .findById(movimentacao.getIdOcorrencia())
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            calendarioRepository
                    .findById(movimentacao.getIdCalendario())
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            movimentacaoRepository
                    .findById(movimentacao.getIdMovimentacao())
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            return movimentacaoRepository.save(movimentacao);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            movimentacaoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Movimentação não existe!"));
            movimentacaoRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
