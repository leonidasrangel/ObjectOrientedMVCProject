/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.model.dao;

import com.mycompany.projescolamvc.model.entities.Professor;
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
public class ProfessorDAOBanco implements IDao {
    private Connection connection;

    public ProfessorDAOBanco(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Object professorN) {
        Professor professor = (Professor) professorN;
        String sql = "INSERT INTO professor (cpf, nome, idade, sexo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getCpf());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdade());
            stmt.setString(4, professor.getSexo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar professor: " + e.getMessage());
        }
    }

    @Override
    public void update(String cpf, Object professorN) {
        Professor professor = (Professor) professorN;   
        String sql = "UPDATE professor SET cpf = ?, nome = ?, idade = ?,  sexo = ? WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getCpf());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdade());
            stmt.setString(4, professor.getSexo());
            stmt.setString(5, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String cpf) {
        String sql = "DELETE FROM professor WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }
    }

    @Override
    public Professor find(String cpf) {
        String sql = "SELECT * FROM professor WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Professor(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Professor> findAll() {
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                professores.add(new Professor(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
        return professores;
    }
}