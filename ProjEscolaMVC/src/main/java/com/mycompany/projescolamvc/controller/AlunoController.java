/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.controller;

import com.mycompany.projescolamvc.model.dao.IDao;
import com.mycompany.projescolamvc.model.entities.Aluno;
import com.mycompany.projescolamvc.model.valid.ValidacaoAluno;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class AlunoController {
    private IDao repositorio;
    
    public AlunoController(IDao repositorio){
        this.repositorio = repositorio;
    }
    
    public void adicionarAluno(String cpf, String nome, String idade, String matricula, String anoIngresso) {
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validacao(cpf, nome, idade, matricula, anoIngresso);
        
        repositorio.save(novoAluno);
    }

    public void removerAluno(String cpf) {
        repositorio.delete(cpf);
    }

    public Aluno buscarAluno(String cpf) {
        return (Aluno) repositorio.find(cpf);
    }

    public List<Aluno> listarAlunos() {
        return repositorio.findAll();
    }

    public void atualizarAluno(String cpfAntigo, String cpf, String nome, String idade, String matricula, String anoIngresso) {
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validacao(cpf, nome, idade, matricula, anoIngresso);
        
        repositorio.update(cpfAntigo, novoAluno);
    }
}
