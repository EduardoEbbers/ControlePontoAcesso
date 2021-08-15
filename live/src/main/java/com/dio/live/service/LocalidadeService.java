package com.dio.live.service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LocalidadeService {
    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    public Localidade create(Localidade localidade) {
        try {
            nivelAcessoRepository
                    .findById(localidade.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            Optional<Localidade> loc = localidadeRepository
                    .findById(localidade.getIdLocalidade());
            if(loc.isPresent()) {
                throw new Error("Localidade já existe!");
            }
            return localidadeRepository.save(localidade);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Localidade> findAll() {
        try {
            return localidadeRepository.findAll();
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("Localidades não existem!");
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Localidade findById(Long id) {
        try {
            return localidadeRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Localidade não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Localidade update(Localidade localidade) {
        try {
            nivelAcessoRepository
                    .findById(localidade.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            localidadeRepository
                    .findById(localidade.getIdLocalidade())
                    .orElseThrow(() -> new NoSuchElementException("Localidade não existe!"));
            return localidadeRepository.save(localidade);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            localidadeRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Localidade não existe!"));
            localidadeRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
