/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.valid;

import com.mycompany.projescolamvc.model.entities.Aluno;
import com.mycompany.projescolamvc.model.exceptions.AlunoException;

/**
 *
 * @author Rangel
 */
public class ValidacaoAluno {
    public Aluno validacao(String cpf, String nome, String idade, String matricula, String anoIngresso){
        Aluno a = new Aluno();
        if(cpf.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'CPF'.");
        a.setCpf(cpf);
        
        if(nome.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'Nome'.");
        a.setNome(nome);
        
        
        if(idade.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'Idade'.");
        
        if(idade.matches("[A-Za-z]*"))
            throw new AlunoException("Error - Valor inválido no campo 'Idade'.");
        
        int valorIdade = 0;
        valorIdade = Integer.parseInt(idade);
        a.setIdade(valorIdade);
         
        if(matricula.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'Matricula'.");
        a.setMatricula(matricula);
        
        if(anoIngresso.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'Ano Ingresso'.");
        a.setAnoIngresso(anoIngresso);
        
        return a;
        
    }
}
