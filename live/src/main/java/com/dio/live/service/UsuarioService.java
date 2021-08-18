package com.dio.live.service;

import com.dio.live.model.*;
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

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Usuario create(Usuario usuario) {
        try {
            CategoriaUsuario catUsuario = categoriaUsuarioRepository
                    .findById(usuario.getIdCategoriaUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            Empresa emp = empresaRepository
                    .findById(usuario.getIdEmpresa())
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            NivelAcesso nivAcesso = nivelAcessoRepository
                    .findById(usuario.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            JornadaTrabalho jornTrab = jornadaTrabalhoRepository
                    .findById(usuario.getIdJornadaTrabalho())
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
            Optional<Usuario> us = usuarioRepository.findById(usuario.getIdUsuario());
            if(us.isPresent()) {
                throw new Error("Usuário já existe!");
            }
            usuario.setCategoriaUsuario(catUsuario);
            usuario.setEmpresa(emp);
            usuario.setNivelAcesso(nivAcesso);
            usuario.setJornadaTrabalho(jornTrab);
            var usuar = usuarioRepository.save(usuario);
            usuar.setIdCategoriaUsuario(usuario.getIdCategoriaUsuario());
            usuar.setIdEmpresa(usuario.getIdEmpresa());
            usuar.setIdNivelAcesso(usuario.getIdNivelAcesso());
            usuar.setIdJornadaTrabalho(usuario.getIdJornadaTrabalho());
            return usuar;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Usuario> findAll() {
        try {
            return usuarioRepository.findAll();
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
            CategoriaUsuario catUsuario = categoriaUsuarioRepository
                    .findById(usuario.getIdCategoriaUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Categoria Usuário não existe!"));
            Empresa emp = empresaRepository
                    .findById(usuario.getIdEmpresa())
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            NivelAcesso nivAcesso = nivelAcessoRepository
                    .findById(usuario.getIdNivelAcesso())
                    .orElseThrow(() -> new NoSuchElementException("Nível Acesso não existe!"));
            JornadaTrabalho jornTrab = jornadaTrabalhoRepository
                    .findById(usuario.getIdJornadaTrabalho())
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
            usuarioRepository
                    .findById(usuario.getIdUsuario())
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            usuario.setCategoriaUsuario(catUsuario);
            usuario.setEmpresa(emp);
            usuario.setNivelAcesso(nivAcesso);
            usuario.setJornadaTrabalho(jornTrab);
            var usuar = usuarioRepository.save(usuario);
            usuar.setIdCategoriaUsuario(usuario.getIdCategoriaUsuario());
            usuar.setIdEmpresa(usuario.getIdEmpresa());
            usuar.setIdNivelAcesso(usuario.getIdNivelAcesso());
            usuar.setIdJornadaTrabalho(usuario.getIdJornadaTrabalho());
            return usuar;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            var matchMov = movimentacaoRepository
                    .findAll()
                    .stream()
                    .anyMatch(movimentacao -> movimentacao.getUsuario().getIdUsuario() == id);

            if(matchMov) {
                throw new Error("Movimentação possui Usuário!");
            }
            usuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Usuário não existe!"));
            usuarioRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
