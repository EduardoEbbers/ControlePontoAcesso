package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NivelAcessoService {
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso create(NivelAcesso categoriaUsuario) {
        try {
            Optional<NivelAcesso> nivAcesso = nivelAcessoRepository.findById(categoriaUsuario.getIdNivelAcesso());
            if(nivAcesso.isPresent()) {
                throw new Error("Nível Acesso já existe!");
            }
            return nivelAcessoRepository.save(categoriaUsuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<NivelAcesso> findAll() {
        try {
            return nivelAcessoRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public NivelAcesso findById(Long id) {
        try {
            return nivelAcessoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public NivelAcesso update(NivelAcesso categoriaUsuario) {
        try {
            nivelAcessoRepository
                    .findById(categoriaUsuario.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            return nivelAcessoRepository.save(categoriaUsuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            nivelAcessoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            nivelAcessoRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
