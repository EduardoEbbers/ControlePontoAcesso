package com.dio.live.service;

import com.dio.live.model.Usuario;
import com.dio.live.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public Usuario create(Usuario usuario) {
        try {
            categoriaUsuarioRepository
                    .findById(usuario.getIdCategoriaUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            empresaRepository
                    .findById(usuario.getIdEmpresa())
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            nivelAcessoRepository
                    .findById(usuario.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            jornadaTrabalhoRepository
                    .findById(usuario.getIdJornadaTrabalho())
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
            Optional<Usuario> us = usuarioRepository.findById(usuario.getIdUsuario());
            if(us.isPresent()) {
                throw new Error("Usuário já existe!");
            }
            return usuarioRepository.save(usuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Usuario> findAll() {
        try {
            return usuarioRepository.findAll();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Usuários não existem!");
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Usuario findById(Long id) {
        try {
            return usuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Usuario update(Usuario usuario) {
        try {
            categoriaUsuarioRepository
                    .findById(usuario.getIdCategoriaUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            empresaRepository
                    .findById(usuario.getIdEmpresa())
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            nivelAcessoRepository
                    .findById(usuario.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            jornadaTrabalhoRepository
                    .findById(usuario.getIdJornadaTrabalho())
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
            usuarioRepository
                    .findById(usuario.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            return usuarioRepository.save(usuario);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            usuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            usuarioRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
