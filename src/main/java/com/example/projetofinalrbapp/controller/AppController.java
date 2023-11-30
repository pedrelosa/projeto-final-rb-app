package com.example.projetofinalrbapp.controller;

import com.example.projetofinalrbapp.model.Estudante;
import com.example.projetofinalrbapp.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private EstudanteService service;

    @RequestMapping("/")
    public String paginaInicial(Model model){
        List<Estudante> estudantes = service.listarTodos();

        estudantes.sort(Comparator.comparingLong(Estudante::getId));

        model.addAttribute("estudantes", estudantes);

        return "index";

    }

}
