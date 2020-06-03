/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaPrincipal;
//importando os modulos de conexão

import java.sql.*;
import Modelo.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanyuratakano
 */
public class TelaProdutos extends javax.swing.JFrame {
    // usando a variavel conexao do modelo

    Connection conexao = null;
// variaveis para a conexao com o banco 
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        initComponents();
        conexao = Conexao.conector();
    }

    //metodo para consultar produtos
    private void consultar() {
        String sql = "select * from produtos where cod_prod=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodProd.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNomeProd.setText(rs.getString(1));
                txtLinhaProd.setText(rs.getString(3));
                txtPreco.setText(rs.getString(4));
                txtQuant.setText(rs.getString(5));
            } else {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            //caso CPF inexistente apagar os campos
            txtNomeProd.setText(null);
            txtLinhaProd.setText(null);
            txtPreco.setText(null);
            txtQuant.setText(null);
        }
    }

    //metodo para adicionar usuarios
    private void adicionar() {
        String sql = "insert into produtos(nome_prod, cod_prod, linha_prod, preco_prod, quant_prod) values (?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeProd.getText());
            pst.setString(2, txtCodProd.getText());
            pst.setString(3, txtLinhaProd.getText());
            pst.setString(4, txtPreco.getText());
            pst.setString(5, txtQuant.getText());

            //Validando campos obrigatorios
            if (txtNomeProd.getText().isEmpty() || txtCodProd.getText().isEmpty() || txtLinhaProd.getText().isEmpty() || txtPreco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                // validar campos obrigatorios            
                //comando para atualizar a tabela usuario com os dados do formulario
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
                    txtNomeProd.setText(null);
                    txtCodProd.setText(null);
                    txtLinhaProd.setText(null);
                    txtPreco.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // metodo para alterar dados do produto
    private void alterar(){
        String sql = "update produtos set nome_prod = ?, linha_prod = ?, preco_prod = ?, quant_prod = ? where cod_prod = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeProd.getText());
            pst.setString(2, txtLinhaProd.getText());
            pst.setString(3, txtPreco.getText());
            pst.setString(4, txtCodProd.getText());
            pst.setString(5, txtQuant.getText());
            
            //Validando campos obrigatorios
            if (txtNomeProd.getText().isEmpty() || txtCodProd.getText().isEmpty() || txtLinhaProd.getText().isEmpty() || txtPreco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {

                //comando para atualizar a tabela produtos com os dados do formulario
                // e confimar que foi alterado corretamente
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do produto atulizado com sucesso.");
                    txtNomeProd.setText(null);
                    txtCodProd.setText(null);
                    txtLinhaProd.setText(null);
                    txtPreco.setText(null);                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Metodo para remover cliente
    private void remover() {
        
        //estrutura para remover usuario
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este produto", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from produtos where cod_prod = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtCodProd.getText());
                int apagado = pst.executeUpdate();
                if(apagado > 1){
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                    txtNomeProd.setText(null);
                    txtCodProd.setText(null);
                    txtLinhaProd.setText(null);
                    txtPreco.setText(null); 
                    txtQuant.setText(null);
                }
            } catch (Exception e) {
            }
        }
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
        txtNomeProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLinhaProd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Produto");

        jLabel1.setText("Nome do Produto:");

        txtNomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdActionPerformed(evt);
            }
        });

        jLabel2.setText("Código do Prod: ");

        jLabel3.setText("Linha: ");

        jLabel4.setText("Preço:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel5.setText("* Todos os campos são obrigatórios");

        jLabel6.setText("Quantidade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodProd)
                            .addComponent(txtLinhaProd)
                            .addComponent(txtPreco)
                            .addComponent(txtNomeProd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtQuant))
                        .addGap(6, 6, 6))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinhaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPreco)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btSalvar)
                    .addComponent(btConsultar))
                .addGap(39, 39, 39))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btConsultar, btEditar, btExcluir, btSalvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        // chamando o metodo consultar
        consultar();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // chamando o metodo adicionar
        adicionar();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // chamando o metodo remover
        remover();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // chamando o metodo alterar
        alterar();
    }//GEN-LAST:event_btEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtLinhaProd;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuant;
    // End of variables declaration//GEN-END:variables
}
