package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.model.TipoData;
import com.dio.live.repository.CalendarioRepository;
import com.dio.live.repository.MovimentacaoRepository;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CalendarioService {
    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private TipoDataRepository tipoDataRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Calendario create(Calendario calendario) {
        try {
            TipoData tipData = tipoDataRepository
                    .findById(calendario.getIdTipoData())
                    .orElseThrow(() -> new NoSuchElementException("Tipo Data não existe!"));
            Optional<Calendario> calend = calendarioRepository
                    .findById(calendario.getIdCalendario());
            if(calend.isPresent()) {
                throw new Error("Calendário já existe!");
            }
            calendario.setTipoData(tipData);
            var calendRepo = calendarioRepository.save(calendario);
            calendRepo.setIdTipoData(calendario.getIdTipoData());
            return calendRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Calendario> findAll() {
        try {
            return calendarioRepository.findAll();
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Calendario findById(Long id) {
        try {
            return calendarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Calendario update(Calendario calendario) {
        try {
            TipoData tipData = tipoDataRepository
                    .findById(calendario.getIdTipoData())
                    .orElseThrow(() -> new NoSuchElementException("Tipo Data não existe!"));
            calendarioRepository
                    .findById(calendario.getIdCalendario())
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            calendario.setTipoData(tipData);
            var calendRepo = calendarioRepository.save(calendario);
            calendRepo.setIdTipoData(calendario.getIdTipoData());
            return calendRepo;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            var matchMov = movimentacaoRepository
                    .findAll()
                    .stream()
                    .anyMatch(movimentacao -> movimentacao.getCalendario().getIdCalendario() == id);

            if(matchMov) {
                throw new Error("Movimentação possui Calendário!");
            }
            calendarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Calendário não existe!"));
            calendarioRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
