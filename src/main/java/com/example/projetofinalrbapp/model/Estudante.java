package com.example.projetofinalrbapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobreNome;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private AnoEscolar anoEscolar;

    private Double primeiraNota;
    private Double pesoPrimeiraNota;
    private Double segundaNota;
    private Double pesoSegundaNota;
    private Double terceiraNota;
    private Double pesoTerceiraNota;

}
