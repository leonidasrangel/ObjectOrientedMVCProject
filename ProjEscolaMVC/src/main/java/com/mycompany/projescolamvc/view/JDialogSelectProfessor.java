/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.projescolamvc.view;

import com.mycompany.projescolamvc.connection.SQLiteConnector;
import com.mycompany.projescolamvc.controller.DisciplinaController;
import com.mycompany.projescolamvc.controller.ProfessorController;
import com.mycompany.projescolamvc.model.dao.DisciplinaDAOBanco;
import com.mycompany.projescolamvc.model.dao.IDao;
import com.mycompany.projescolamvc.model.dao.ProfessorDAOBanco;
import com.mycompany.projescolamvc.model.entities.Disciplina;
import com.mycompany.projescolamvc.model.entities.Professor;
import com.mycompany.projescolamvc.view.tablemodels.TMCadProfessor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangel
 */
public class JDialogSelectProfessor extends javax.swing.JDialog {
    private boolean editando;
    private String cpfEscolhido;
    private ProfessorController professorController;
    private DisciplinaController disciplinaController;
    private Disciplina dis;
    private Professor professorEscolhido;
   


    public JDialogSelectProfessor(java.awt.Frame parent, boolean modal,  Disciplina d) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        
        //IDao disciplinaDao = new DisciplinaDAOFile("ListagemDisciplinas.json");
        
        SQLiteConnector conexao = new SQLiteConnector("banco.sqlite");
        IDao disciplinaDao = new DisciplinaDAOBanco(conexao.getConnection());
        this.disciplinaController = new DisciplinaController(disciplinaDao);
        
        
        //IDao alunoDao =new ProfessorDAOFile("ListagemProfessores.json");
        
        SQLiteConnector conexao2 = new SQLiteConnector("banco.sqlite");
        IDao professorDao = new ProfessorDAOBanco(conexao2.getConnection());
        this.professorController = new ProfessorController(professorDao);
        initData();
        this.dis = d;
    }
    
    public JDialogSelectProfessor(java.awt.Dialog parent, boolean modal,  Disciplina d) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        
        //IDao disciplinaDao = new DisciplinaDAOFile("ListagemDisciplinas.json");
        SQLiteConnector conexao = new SQLiteConnector("banco.sqlite");
        IDao disciplinaDao = new DisciplinaDAOBanco(conexao.getConnection());
        this.disciplinaController = new DisciplinaController(disciplinaDao);
        
        //IDao alunoDao =new ProfessorDAOFile("ListagemProfessores.json");
        SQLiteConnector conexao2 = new SQLiteConnector("banco.sqlite");
        IDao professorDao = new ProfessorDAOBanco(conexao2.getConnection());
        this.professorController = new ProfessorController(professorDao);
        initData();
        this.dis = d;
    }
    private void initData(){

        this.editando = true;

        this.habilitarCampos(false);
        this.limparCampos();

        this.atualizarTabela();
    }
    
    public void habilitarCampos(boolean flag) {
        edtCPF.setEnabled(flag);
        edtSexo.setEnabled(flag);
        edtNome.setEnabled(flag);
        edtIdade.setEnabled(flag);
    }

    public void limparCampos() {
        edtCPF.setText("");
        edtSexo.setText("");
        edtNome.setText("");
        edtIdade.setText("");
    }

    public void objetoParaCampos(Professor p) {
       edtCPF.setText(p.getCpf());
       edtSexo.setText(p.getSexo());
       edtNome.setText(p.getNome());
       edtIdade.setText(p.getIdade() + "");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblAluno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnMatricular = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        edtCPF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdProfessor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAluno.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblAluno.setText("Selecionar Professor");
        jPanel1.add(lblAluno);

        btnNovo.setBackground(new java.awt.Color(204, 204, 204));
        btnNovo.setForeground(new java.awt.Color(0, 0, 0));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo-arquivo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSelecionar.setBackground(new java.awt.Color(204, 204, 204));
        btnSelecionar.setForeground(new java.awt.Color(0, 0, 0));
        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar-texto.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnMatricular.setBackground(new java.awt.Color(204, 204, 204));
        btnMatricular.setForeground(new java.awt.Color(0, 0, 0));
        btnMatricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar-arquivo.png"))); // NOI18N
        btnMatricular.setText("Matricular");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnNovo)
                    .addGap(5, 5, 5)
                    .addComponent(btnSelecionar)
                    .addGap(5, 5, 5)
                    .addComponent(btnCancelar)
                    .addGap(5, 5, 5)
                    .addComponent(btnMatricular)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNovo)
                        .addComponent(btnSelecionar)
                        .addComponent(btnCancelar)
                        .addComponent(btnMatricular))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 20, 0, 0);
        jPanel3.add(lblSexo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 173;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        jPanel3.add(edtSexo, gridBagConstraints);

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 6, 0, 0);
        jPanel3.add(lblNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 172;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 6, 13, 0);
        jPanel3.add(edtNome, gridBagConstraints);

        lblIdade.setForeground(new java.awt.Color(255, 255, 255));
        lblIdade.setText("Idade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 18, 0, 0);
        jPanel3.add(lblIdade, gridBagConstraints);

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 171;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 12, 13, 10);
        jPanel3.add(edtIdade, gridBagConstraints);

        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setText("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        jPanel3.add(lblCPF, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 176;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 0, 0);
        jPanel3.add(edtCPF, gridBagConstraints);

        grdProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        grdProfessor.setSelectionBackground(new java.awt.Color(0, 102, 102));
        grdProfessor.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(grdProfessor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        JDialogProfessor tela = null;
        try {
            tela = new JDialogProfessor(this,true);
        } catch (SQLException ex) {
            Logger.getLogger(JDialogSelectProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        tela.setVisible(true);
        atualizarTabela();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        this.professorEscolhido = this.getObjetoSelecionadoNaGrid();

        String CPFEscolhido = professorEscolhido.getCpf();

        Professor professorExistente = professorController.buscarProfessor(CPFEscolhido);

        if (professorExistente == null) {
            JOptionPane.showMessageDialog(this, "Não existe professor com esse cpf.");
        } else {
            this.habilitarCampos(true);
            this.objetoParaCampos(professorExistente);
            this.editando = true;
            this.cpfEscolhido = professorExistente.getCpf();
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        Professor a = this.professorEscolhido;  // Obtém o aluno selecionado na interface

        if (a != null) {
            this.disciplinaController.atualizarDisciplinaP(dis, edtCPF.getText(), edtNome.getText(), edtIdade.getText(), edtSexo.getText());

            JOptionPane.showMessageDialog(this, "Professor adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um professor primeiro.");
        }

        this.limparCampos();
        this.habilitarCampos(false);
        this.atualizarTabela();
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void edtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdadeActionPerformed
    private void grdProfessorMouseClicked(java.awt.event.MouseEvent evt) {                                       
       Professor p = this.getObjetoSelecionadoNaGrid();
       this.objetoParaCampos(p);
    }
    
    public Professor getObjetoSelecionadoNaGrid() {
        int linhaSelecionada = grdProfessor.getSelectedRow();

        if (linhaSelecionada >= 0) {
            TMCadProfessor tmCadProfessor = (TMCadProfessor) grdProfessor.getModel();

             Professor professor = tmCadProfessor.getObjetoAluno(linhaSelecionada);
            return professor;
        }
        
        return null;
    }
    
    public void atualizarTabela() {
        List<Professor> lista = this.professorController.listarProfessores();
        TMCadProfessor tmcadProfessor = new TMCadProfessor(lista);
        grdProfessor.setModel(tmcadProfessor);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMatricular;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JTable grdProfessor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    // End of variables declaration//GEN-END:variables
}
