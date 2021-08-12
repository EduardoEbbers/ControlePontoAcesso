package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {
    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAllJornadaTrabalho() {
        return jornadaTrabalhoRepository.findAll();
    }

    public Optional<JornadaTrabalho> getJornadaTrabalhoById(Long idJornada) {
        return jornadaTrabalhoRepository.findById(idJornada);
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public void deleteJornadaTrabalho(Long idJornada) {
        jornadaTrabalhoRepository.deleteById(idJornada);
    }
}
