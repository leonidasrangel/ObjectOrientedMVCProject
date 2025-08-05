/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.dao;

import com.mycompany.projescolamvc.model.entities.Aluno;
import com.mycompany.projescolamvc.model.file.FilePersistence;
import com.mycompany.projescolamvc.model.file.SerializadorJSONAluno;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class AlunoDAOFile implements IDao {
    private SerializadorJSONAluno serializador = new SerializadorJSONAluno();//Inversao dependencia
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public AlunoDAOFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cpf) {
       
        Aluno alunoExcluir = this.find(cpf);
        
        if(alunoExcluir != null){
            List<Aluno> alunos = this.findAll();
            alunos.remove(alunoExcluir);
            
            //mesma rotina para que aprendemos nas aulas de persistencia
            String jsonData = serializador.toFile(alunos);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Aluno removido com sucesso do arquivo.");
        }
    }

    @Override
    public Aluno find(String cpf) {
        List<Aluno> alunos = this.findAll();
        
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)){
                return aluno;
            }      
        }
        return null;
    }
    
    @Override
    public List<Aluno> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cpf, Object newAluno ) {
        Aluno alunoAtualizado = (Aluno) newAluno;
    
        // Procura o aluno pelo CPF
        Aluno alunoExistente = this.find(cpf);
    
        if (alunoExistente != null) {
        // Se o aluno for encontrado, substitua-o na lista
        List<Aluno> alunos = this.findAll();
        
        // Remove o aluno antigo
        alunos.remove(alunoExistente);
        
        // Adiciona o novo aluno atualizado
        alunos.add(alunoAtualizado);
        
        // Atualiza o arquivo com a lista modificada
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Aluno atualizado com sucesso no arquivo.");
    } else {
        System.out.println("Aluno com CPF " + cpf + " não encontrado.");
    }
    }

    @Override
    public void save(Object newAluno) {
        Aluno a = (Aluno) newAluno;
        List<Aluno> alunos = findAll();
        alunos.add(a);
        
        //mesma rotina para que aprendemos nas aulas de persistencia
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Aluno salvo com sucesso no arquivo.");
    }
}
