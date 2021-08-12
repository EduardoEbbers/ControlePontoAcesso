package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoDataService {
    @Autowired
    private TipoDataRepository tipoDataRepository;

    public TipoData create(TipoData tipoData) {
        try {
            Optional<TipoData> tipData = tipoDataRepository.findById(tipoData.getIdTipoData());
            if(tipData.isPresent()) {
                throw new Error("Tipo Data já existe!");
            }
            return tipoDataRepository.save(tipoData);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<TipoData> findAll() {
        try {
            return tipoDataRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public TipoData findById(Long id) {
        try {
            return tipoDataRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Tipo Data não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public TipoData update(TipoData tipoData) {
        try {
            tipoDataRepository
                    .findById(tipoData.getIdTipoData())
                    .orElseThrow(() -> new NoSuchElementException("Tipo Data não existe!"));
            return tipoDataRepository.save(tipoData);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            tipoDataRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Tipo Data não existe!"));
            tipoDataRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
