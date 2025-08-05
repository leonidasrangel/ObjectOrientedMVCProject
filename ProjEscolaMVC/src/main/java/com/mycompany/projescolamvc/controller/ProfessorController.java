/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.controller;

import com.mycompany.projescolamvc.model.dao.IDao;
import com.mycompany.projescolamvc.model.entities.Professor;
import com.mycompany.projescolamvc.model.valid.ValidacaoProfessor;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class ProfessorController {
    private IDao repositorio;

    public ProfessorController(IDao repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarProfessor(String cpf, String nome, String idade, String sexo) {
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoProfessor = valid.validacao(cpf, nome, idade, sexo);
        
        repositorio.save(novoProfessor);
    }

    public void removerProfessor(String cpf) {
        repositorio.delete(cpf);
    }

    public Professor buscarProfessor(String cpf) {
        return (Professor) repositorio.find(cpf);
    }

    public List<Professor> listarProfessores() {
        return repositorio.findAll();
    }

    public void atualizarProfessor(String cpfAntigo, String cpf, String nome, String idade, String sexo) {
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoP = valid.validacao(cpf, nome, idade, sexo);
        
        repositorio.update(cpfAntigo, novoP);
    }
}
