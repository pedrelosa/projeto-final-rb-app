package com.example.projetofinalrbapp.service;

import com.example.projetofinalrbapp.model.Estudante;
import com.example.projetofinalrbapp.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    EstudanteRepository eRepo;

    public void adicionarEstudante(Estudante estudante){
        eRepo.save(estudante);
    }

    public List<Estudante> listarTodos() {

        List<Estudante> estudante = eRepo.findAll();

        for(Estudante e : estudante) {
            System.out.println(e.getNome());
        }

        return eRepo.findAll();
    }

    public Estudante modificar(Long id) {
        return eRepo.findById(id).get();
    }

    public void deletarPorId(Long id) {
        eRepo.deleteById(id);
    }

}
