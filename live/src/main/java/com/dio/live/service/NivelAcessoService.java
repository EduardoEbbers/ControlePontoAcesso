package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.repository.NivelAcessoRepository;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NivelAcessoService {
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public NivelAcesso create(NivelAcesso nivelAcesso) {
        try {
            Optional<NivelAcesso> nivAcesso = nivelAcessoRepository
                    .findById(nivelAcesso.getIdNivelAcesso());
            if(nivAcesso.isPresent()) {
                throw new Error("Nível Acesso já existe!");
            }
            return nivelAcessoRepository.save(nivelAcesso);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<NivelAcesso> findAll() {
        try {
            return nivelAcessoRepository.findAll();
        } catch(Error e) {
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

    public NivelAcesso update(NivelAcesso nivelAcesso) {
        try {
            nivelAcessoRepository
                    .findById(nivelAcesso.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            return nivelAcessoRepository.save(nivelAcesso);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            var matchUsuario = usuarioRepository
                    .findAll()
                    .stream()
                    .anyMatch(usuario -> usuario.getNivelAcesso().getIdNivelAcesso() == id);
            var matchLocalidade = localidadeRepository
                    .findAll()
                    .stream()
                    .anyMatch(localidade -> localidade.getNivelAcesso().getIdNivelAcesso() == id);
            if(matchUsuario) {
                throw new Error("Nível Acesso possui Usuário!");
            }
            if(matchLocalidade) {
                throw new Error("Nível Acesso possui Localidade!");
            }
            nivelAcessoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            nivelAcessoRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
