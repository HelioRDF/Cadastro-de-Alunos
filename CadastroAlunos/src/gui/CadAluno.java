package gui;

import Factory.ConexaoFactory;
import static Factory.ConexaoFactory.con;
import dao.AlunoDAO;
import dao.CidadeDAO;
import entity.Cidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author helio
 */
public class CadAluno extends javax.swing.JDialog {

    Statement stmt;

    public CadAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarBD();

    }

    public CadAluno() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfcodigo = new javax.swing.JTextField();
        tfnome = new javax.swing.JTextField();
        tfsobrenome = new javax.swing.JTextField();
        btprimeiro = new javax.swing.JButton();
        btanterior = new javax.swing.JButton();
        btproximo = new javax.swing.JButton();
        btultimo = new javax.swing.JButton();
        Novo = new javax.swing.JButton();
        btsalvar = new javax.swing.JButton();
        btexcluir = new javax.swing.JButton();
        btpesquisar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        cbCidade = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 49, -1, -1));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 105, -1, -1));

        jLabel3.setText("Sobrenome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 139, -1, -1));

        jLabel4.setText("Cod Cidade:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 177, -1, -1));

        tfcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcodigoActionPerformed(evt);
            }
        });
        getContentPane().add(tfcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 44, 163, -1));
        getContentPane().add(tfnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 100, 203, -1));

        tfsobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfsobrenomeActionPerformed(evt);
            }
        });
        getContentPane().add(tfsobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 134, 302, -1));

        btprimeiro.setText("<<");
        btprimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btprimeiroActionPerformed(evt);
            }
        });
        getContentPane().add(btprimeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 211, -1, -1));

        btanterior.setText("<");
        btanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btanteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btanterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 211, -1, -1));

        btproximo.setText(">");
        btproximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btproximoActionPerformed(evt);
            }
        });
        getContentPane().add(btproximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 211, -1, -1));

        btultimo.setText(">>");
        btultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btultimoActionPerformed(evt);
            }
        });
        getContentPane().add(btultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 211, -1, -1));

        Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon (1).png"))); // NOI18N
        Novo.setText("Limpar");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        getContentPane().add(Novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        btsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/diskette.png"))); // NOI18N
        btsalvar.setText("Gravar");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        btexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon.png"))); // NOI18N
        btexcluir.setText("Excluir");
        btexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btexcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        btpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tool.png"))); // NOI18N
        btpesquisar.setText("Buscar");
        btpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btpesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/arrows.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 90, 40));

        cbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(cbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 300, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcodigoActionPerformed

    private void tfsobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfsobrenomeActionPerformed


    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed

        try {
            int cod = Integer.parseInt(tfcodigo.getText());
            String nome = tfnome.getText();
            String sobrenome = tfsobrenome.getText();
            String codCidade = cbCidade.getSelectedItem().toString();
            int auxCodCidade;

            auxCodCidade = cidadeDao.getCodCidadeByNome(codCidade);

            Aluno aluno = new Aluno();

            aluno.setCod(cod);
            aluno.setNome(nome);
            aluno.setSobrenome(sobrenome);
            aluno.setCodcidade(auxCodCidade);

            alunoDao.salvarRegistro(aluno);

            JOptionPane.showMessageDialog(this, "Aluno Salvo com sucesso");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }finally{
            limparCampos();
        }


    }//GEN-LAST:event_btsalvarActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed

        
        limparCampos();


    }//GEN-LAST:event_NovoActionPerformed

    private void btexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexcluirActionPerformed

        String cod = tfcodigo.getText();

        try {
            alunoDao.excluirRegistro(Integer.parseInt(cod));
            JOptionPane.showMessageDialog(this, "Excluindo Info...");

        } catch (SQLException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            limparCampos();
        }

    }//GEN-LAST:event_btexcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        //Fecha a interface gráfica.
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void btpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisarActionPerformed

        int cod = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código"));

        try {
            Aluno aluno = alunoDao.pesquisarAluno(cod);

            if (aluno != null) {
                mostrarDados(aluno);
                JOptionPane.showMessageDialog(this, "Aluno encontrado...");

            } else {
                JOptionPane.showMessageDialog(this, "O aluno não foi encontrado...");

            }

        } catch (SQLException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btpesquisarActionPerformed

    private void btprimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btprimeiroActionPerformed
        primeiro();

    }//GEN-LAST:event_btprimeiroActionPerformed

    private void btanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btanteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btanteriorActionPerformed

    private void btproximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btproximoActionPerformed
        proximo();
    }//GEN-LAST:event_btproximoActionPerformed

    private void btultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btultimoActionPerformed

        ultimo();
    }//GEN-LAST:event_btultimoActionPerformed

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCidadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadAluno dialog = new CadAluno(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Novo;
    private javax.swing.JButton btanterior;
    private javax.swing.JButton btexcluir;
    private javax.swing.JButton btpesquisar;
    private javax.swing.JButton btprimeiro;
    private javax.swing.JButton btproximo;
    private javax.swing.JButton btsalvar;
    private javax.swing.JButton btultimo;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfcodigo;
    private javax.swing.JTextField tfnome;
    private javax.swing.JTextField tfsobrenome;
    // End of variables declaration//GEN-END:variables

    private dao.AlunoDAO alunoDao;
    private dao.CidadeDAO cidadeDao;
    

    private void iniciarBD() {

        try {

            alunoDao = new AlunoDAO();
            cidadeDao=new CidadeDAO();
            montarListaCidade();
            primeiro();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void montarListaCidade() {
      
        try {
            
            List<Cidade> listaCidade=cidadeDao.montarListaCidade();
        
        
        for(Cidade cidade:listaCidade){
            cbCidade.addItem(cidade.getNomeCidade());
        }
        
        
        
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
       }
        
    }

    //Atualizar as informações dos campos de texto.
    public void mostrarDados(Aluno aluno) {

        try {

            tfcodigo.setText(String.valueOf(aluno.getCod()));
            tfnome.setText(aluno.getNome());
            tfsobrenome.setText(aluno.getSobrenome());

            String nomeCidade
                    = cidadeDao.getNomeCidadeByCod(aluno.getCodcidade());

            cbCidade.setSelectedItem(nomeCidade);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Sem registro no DB. \n" + e);

        } catch (SQLException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void primeiro() {

        Aluno aluno;

        try {
            aluno = alunoDao.primeiro();

            if (aluno != null) {
                mostrarDados(aluno);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }

    }

    public void anterior() {

        Aluno aluno;

        try {
            aluno = alunoDao.anterior();

            if (aluno != null) {
                mostrarDados(aluno);

            } else {
                JOptionPane.showMessageDialog(this, "Primeiro item selecionado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }

    }

    public void proximo() {

        Aluno aluno;

        try {
            aluno = alunoDao.proximo();

            if (aluno != null) {
                mostrarDados(aluno);

            } else {
                JOptionPane.showMessageDialog(this, "Ultimo item selecionado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }

    }

    public void ultimo() {

        Aluno aluno;

        try {
            aluno = alunoDao.ultimo();

            if (aluno != null) {
                mostrarDados(aluno);

            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());

        }

    }

    private void limparCampos() {
        //Apaga as informações dos campos de texto da interface gráfica.
        tfcodigo.setText("");
        tfnome.setText("");
        tfsobrenome.setText("");
        cbCidade.setSelectedIndex(0);
        tfcodigo.requestFocus();
    
    
    }

}
