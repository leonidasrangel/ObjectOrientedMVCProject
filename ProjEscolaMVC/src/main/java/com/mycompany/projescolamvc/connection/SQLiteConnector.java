/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projescolamvc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rangel
 */
public class SQLiteConnector {

    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(url);

        criarTabelaAluno();
        criarTabelaProfessor();
        criarTabelaDisciplina();
    }

    public Connection getConnection() {
        return connection;
    }

    private void criarTabelaAluno() {
        String sql = "CREATE TABLE IF NOT EXISTS aluno ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cpf TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " idade INTEGER NOT NULL,"
                + " matricula TEXT NOT NULL,"
                + " anoIngresso TEXT NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    
    private void criarTabelaProfessor() {
        String sql = "CREATE TABLE IF NOT EXISTS professor ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cpf TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " idade INTEGER NOT NULL,"
                + " sexo TEXT NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    
    private void criarTabelaDisciplina() {
        String sql = "CREATE TABLE IF NOT EXISTS disciplina ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cod TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " semestre TEXT NOT NULL,"
                + " horario TEXT NOT NULL,"
                + " profM TEXT NOT NULL,"
                + " alunos TEXT NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}
