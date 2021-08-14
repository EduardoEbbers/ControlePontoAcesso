package com.dio.live.service;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia create(Ocorrencia ocorrencia) {
        try {
            Optional<Ocorrencia> ocorr = ocorrenciaRepository.findById(ocorrencia.getIdOcorrencia());
            if(ocorr.isPresent()) {
                throw new Error("Ocorrência já existe!");
            }
            return ocorrenciaRepository.save(ocorrencia);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Ocorrencia> findAll() {
        try {
            return ocorrenciaRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Ocorrencia findById(Long id) {
        try {
            return ocorrenciaRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Ocorrencia update(Ocorrencia ocorrencia) {
        try {
            ocorrenciaRepository
                    .findById(ocorrencia.getIdOcorrencia())
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            return ocorrenciaRepository.save(ocorrencia);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            ocorrenciaRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Ocorrência não existe!"));
            ocorrenciaRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
