package com.example.projetofinalrbapp.controller;

import com.example.projetofinalrbapp.model.Estudante;
import com.example.projetofinalrbapp.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/novo")
    public String cadastroEstudante(Model model){

        Estudante estudante = new Estudante();
        model.addAttribute("estudante", estudante);

        return "cadastrar-estudante";
    }


    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarEstudante(@ModelAttribute("estudante") Estudante estudante){
        service.adicionarEstudante(estudante);
        return "redirect:/";
    }


    @RequestMapping("/editar/{id}")
    public ModelAndView editarIdEstudante(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("editar-estudante");

        Estudante estudante = service.modificar(id);

        mav.addObject("estudante", estudante);

        return mav;
    }

}
