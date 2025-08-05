/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.valid;

import com.mycompany.projescolamvc.model.entities.Professor;
import com.mycompany.projescolamvc.model.exceptions.ProfessorException;

/**
 *
 * @author Rangel
 */
public class ValidacaoProfessor {
    
    public Professor validacao(String cpf, String nome, String idade, String sexo){
        Professor p = new Professor();
        
        if(nome.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'Nome'.");
        p.setNome(nome);
        
        
        if(idade.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'Idade'.");
        
        if(idade.matches("[A-Za-z]*"))
            throw new ProfessorException("Error - Valor invalido no campo 'Idade'.");
        
        int valorIdade = 0;
        valorIdade = Integer.parseInt(idade);
        p.setIdade(valorIdade);
        
        
        if(sexo.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'Sexo'.");
        p.setSexo(sexo);
        
        if(cpf.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'CPF'.");
        p.setCpf(cpf);
        
        return p;
        
    }
}
