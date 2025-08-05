/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.dao;

import com.mycompany.projescolamvc.model.entities.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class AlunoDAOBanco implements IDao{
    private Connection connection;

    public AlunoDAOBanco(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Object alunoN) {
        Aluno aluno = (Aluno) alunoN;
        String sql = "INSERT INTO aluno (cpf, nome, idade, matricula, anoIngresso) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, aluno.getMatricula());
            stmt.setString(5, aluno.getAnoIngresso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    @Override
    public void update(String cpf, Object alunoN) {
        Aluno aluno = (Aluno) alunoN;   
        String sql = "UPDATE aluno SET cpf = ?, nome = ?, idade = ?,  matricula = ?, anoIngresso = ? WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, aluno.getMatricula());
            stmt.setString(5, aluno.getAnoIngresso());
            stmt.setString(6, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    @Override
    public void delete(String cpf) {
        String sql = "DELETE FROM aluno WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }

    @Override
    public Aluno find(String cpf) {
        String sql = "SELECT * FROM aluno WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Aluno(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("matricula"),
                        rs.getString("anoIngresso")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("matricula"),
                        rs.getString("anoIngresso")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return alunos;
    }
}
