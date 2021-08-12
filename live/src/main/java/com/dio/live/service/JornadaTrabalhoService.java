package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {
    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho create(JornadaTrabalho jornadaTrabalho) {
        try {
            Optional<JornadaTrabalho> jornTrabalho = jornadaTrabalhoRepository.findById(jornadaTrabalho.getIdJornadaTrabalho());
            if(jornTrabalho.isPresent()) {
                throw new Error("Jornada Trabalho já existe!");
            }
            return jornadaTrabalhoRepository.save(jornadaTrabalho);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<JornadaTrabalho> findAll() {
        try {
            return jornadaTrabalhoRepository.findAll();
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public JornadaTrabalho findById(Long id) {
        try {
            return jornadaTrabalhoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho) {
        try {
            jornadaTrabalhoRepository
                    .findById(jornadaTrabalho.getIdJornadaTrabalho())
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho não existe!"));
            return jornadaTrabalhoRepository.save(jornadaTrabalho);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            jornadaTrabalhoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Jornada Trabalho Usuário não existe!"));
            jornadaTrabalhoRepository.deleteById(id);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
