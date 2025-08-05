/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.dao;

import com.mycompany.projescolamvc.model.entities.Disciplina;
import com.mycompany.projescolamvc.model.file.FilePersistence;
import com.mycompany.projescolamvc.model.file.SerializadorJSONDisciplina;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class DisciplinaDAOFile implements IDao {
    private SerializadorJSONDisciplina serializador = new SerializadorJSONDisciplina();//Inversao dependencia
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public DisciplinaDAOFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cpf) {
       
        Disciplina disciplinaExcluir = this.find(cpf);
        
        if(disciplinaExcluir != null){
            List<Disciplina> disciplinas = this.findAll();
            disciplinas.remove(disciplinaExcluir);
            
            String jsonData = serializador.toFile(disciplinas);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Disciplina removida com sucesso do arquivo.");
        }
    }

    @Override
    public Disciplina find(String cod) {
        List<Disciplina> disciplinas = this.findAll();
        
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(cod)){
                return disciplina;
            }      
        }
        return null;
    }
    
    @Override
    public List<Disciplina> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cpf, Object newAluno ) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void save(Object newAluno) {
        Disciplina a = (Disciplina) newAluno;
        List<Disciplina> alunos = findAll();
        alunos.add(a);
        
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Disciplina salva com sucesso no arquivo.");
    }
}

