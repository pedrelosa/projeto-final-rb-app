package com.example.projetofinalrbapp.model;

public enum AnoEscolar {
    PRIMERO_ANO_ENSINO_MEDIO ("Primeiro ano do ensino médio"),
    SEGUNDO_ANO_ENSINO_MEDIO ("Segundo ano do ensino médio"),
    TERCEIRO_ANO_ENSINO_MEDIO ("Terceiro ano do ensino médio");

    private final String descricao;

    AnoEscolar(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

}
