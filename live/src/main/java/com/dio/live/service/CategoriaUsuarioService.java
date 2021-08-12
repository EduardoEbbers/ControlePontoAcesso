package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {
    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuario create(CategoriaUsuario categoriaUsuario) {
        try {
            Optional<CategoriaUsuario> catUsuario = categoriaUsuarioRepository.findById(categoriaUsuario.getIdCategoriaUsuario());
            if(catUsuario.isPresent()) {
                throw new Error("Categoria Usuário já existe!");
            }
            return categoriaUsuarioRepository.save(categoriaUsuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<CategoriaUsuario> findAll() {
        try {
            return categoriaUsuarioRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public CategoriaUsuario findById(Long id) {
        try {
            return categoriaUsuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
        try {
            categoriaUsuarioRepository
                    .findById(categoriaUsuario.getIdCategoriaUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            return categoriaUsuarioRepository.save(categoriaUsuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            categoriaUsuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            categoriaUsuarioRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
