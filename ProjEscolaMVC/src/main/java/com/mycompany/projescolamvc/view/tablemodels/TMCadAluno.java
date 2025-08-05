/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.view.tablemodels;

import com.mycompany.projescolamvc.model.entities.Aluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rangel
 */
public class TMCadAluno extends AbstractTableModel{
    
    private List<Aluno> alunos;
    
    private final int COL_CPF = 0;
    private final int COL_NOME = 1;
    private final int COL_IDADE = 2;
    private final int COL_MATRICULA = 3;
    private final int COL_ANOINGRESSO = 4;
    
    
    public TMCadAluno(List<Aluno> alunos){
        this.alunos = alunos;
    }
    
    @Override
    public int getRowCount() {
        return this.alunos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    
    public Aluno getObjetoAluno(int row){
       return this.alunos.get(row);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno a = this.alunos.get(rowIndex);
        switch (columnIndex) {
            case COL_CPF:
                return a.getCpf();
            case COL_NOME:
                return a.getNome();
            case COL_IDADE:
                return a.getIdade();
            case COL_MATRICULA:
                return a.getMatricula();
            case COL_ANOINGRESSO:
                return a.getAnoIngresso();
            default:
                break;
        }
        return "-";
        
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        //qual o nome da coluna
         if(columnIndex == COL_CPF){
             return "CPF";
         }else if(columnIndex == COL_NOME){
            return "Nome";
        }else if(columnIndex == COL_IDADE){
            return "Idade";
        }else if(columnIndex == COL_MATRICULA){
            return "Matricula";
        }else if(columnIndex == COL_ANOINGRESSO){
            return "Ano de Ingresso";
        }

        return "";
    }

    
}

