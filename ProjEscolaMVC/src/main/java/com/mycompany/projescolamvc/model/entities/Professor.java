/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.entities;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Professor extends Pessoa {
    private String sexo;
    
    public Professor(String cpf, String nome, int idade, String sexo) {
        super(cpf, nome, idade);
        this.sexo = sexo;
    }

    public Professor() {
        super();
        this.sexo = "";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.sexo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        return Objects.equals(this.sexo, other.sexo);
    }

    @Override
    public String toString() {
    return "[CPF=" + super.cpf + ", Nome=" + super.nome + ", Sexo=" + sexo + ", Idade=" + super.idade + "]\n" ;
}
    
    public void imprimir(){
        System.out.println(this);
    }
     
}

