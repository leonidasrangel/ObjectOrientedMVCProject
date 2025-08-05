/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.valid;

import com.mycompany.projescolamvc.model.entities.Disciplina;
import com.mycompany.projescolamvc.model.exceptions.DisciplinaException;

/**
 *
 * @author Rangel
 */
public class ValidacaoDisciplina {
    public Disciplina validacao(String cod,String nome, String semestre, String horario) {
    Disciplina d = new Disciplina();
    
    if(cod.isEmpty())
        throw new DisciplinaException("Error - Campo vazio: 'Cod'.");
    d.setCod(cod);
    
    if (nome.isEmpty())
        throw new DisciplinaException("Error - Campo vazio: 'Nome'.");
    d.setNome(nome);
    
    if (semestre.isEmpty())
        throw new DisciplinaException("Error - Campo vazio: 'Semestre'.");
    d.setSemestre(semestre);
    
    if (horario.isEmpty())
        throw new DisciplinaException("Error - Campo vazio: 'Horario'.");
    d.setHorario(horario);
    
    
    return d;
}

}
