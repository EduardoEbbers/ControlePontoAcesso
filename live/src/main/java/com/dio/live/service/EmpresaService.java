package com.dio.live.service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Empresa create(Empresa empresa) {
        try {
            Optional<Empresa> emp = empresaRepository
                    .findById(empresa.getIdEmpresa());
            if(emp.isPresent()) {
                throw new Error("Empresa já existe!");
            }
            return empresaRepository.save(empresa);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<Empresa> findAll() {
        try {
            return empresaRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Empresa findById(Long id) {
        try {
            return empresaRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Empresa update(Empresa empresa) {
        try {
            empresaRepository
                    .findById(empresa.getIdEmpresa())
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            return empresaRepository.save(empresa);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            var matchUsuario = usuarioRepository
                    .findAll()
                    .stream()
                    .anyMatch(usuario -> usuario.getEmpresa().getIdEmpresa() == id);

            if(matchUsuario) {
                throw new Error("Usuário possui Empresa!");
            }
            empresaRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Empresa não existe!"));
            empresaRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
