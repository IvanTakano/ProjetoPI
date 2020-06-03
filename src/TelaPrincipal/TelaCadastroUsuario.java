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
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ivanyuratakano
 */
public class TelaCadastroUsuario extends javax.swing.JInternalFrame {
// usando a variavel conexao do modelo    

    Connection conexao = null;
// variaveis para a conexao com o banco 
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroUsuario() {
        initComponents();
        conexao = Conexao.conector();
        System.out.println(conexao);
    }

    //metodo para consultar funcionario
    private void consultar() {
        String sql = "select * from funcionario where cod_func=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodFunc.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNome.setText(rs.getString(1));
                txtTel.setText(rs.getString(3));
                txtFuncao.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
            //caso codigo do funcionario inexistente apagar os campos
            txtNome.setText(null);
            txtTel.setText(null);
            txtFuncao.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
            //caso codigo do funcionario inexistente apagar os campos
            txtNome.setText(null);
            txtTel.setText(null);
            txtFuncao.setText(null);
        }
    }

    //metodo para adicionar usuarios
    private void adicionar() {
        String sql = "insert into funcionario(nome_func, cod_func, tel_func, funcao_func) values (?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(2, txtCodFunc.getText());
            pst.setString(1, txtNome.getText());
            pst.setString(3, txtTel.getText());
            pst.setString(4, txtFuncao.getText());

            //Validando campos obrigatorios
            if (txtCodFunc.getText().isEmpty() || txtNome.getText().isEmpty() || txtTel.getText().isEmpty() || txtFuncao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {

                //comando para atualizar a tabela usuario com os dados do formulario
                // e confimar que foi adicionado corretamente
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
                    txtCodFunc.setText(null);
                    txtNome.setText(null);
                    txtTel.setText(null);
                    txtFuncao.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo para editar dados do usuario
    private void alterar() {
        String sql = "update funcionario set nome_func = ?, tel_func = ?, funcao_func = ? where cod_func = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtTel.getText());
            pst.setString(3, txtFuncao.getText());
            pst.setString(4, txtCodFunc.getText());

            //Validando campos obrigatorios
            if (txtCodFunc.getText().isEmpty() || txtNome.getText().isEmpty() || txtTel.getText().isEmpty() || txtFuncao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {

                //comando para atualizar a tabela usuario com os dados do formulario
                // e confimar que foi alterado corretamente
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário atulizado com sucesso.");
                    txtCodFunc.setText(null);
                    txtNome.setText(null);
                    txtTel.setText(null);
                    txtFuncao.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Metodo para remover usuario
    private void remover() {
        
        //estrutura para remover usuario
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from funcionario where cod_func = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtCodFunc.getText());
                int apagado = pst.executeUpdate();
                if(apagado > 1){
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                    txtCodFunc.setText(null);
                    txtNome.setText(null);
                    txtTel.setText(null);
                    txtFuncao.setText(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFram = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodFunc = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        salvarFunc = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        deletFunc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);

        jLabel1.setText("Código do funcionário");

        jLabel2.setText("Nome do funcionário");

        jLabel3.setText("Telefone do funcionario");

        salvarFunc.setText("Salvar");
        salvarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarFuncActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        deletFunc.setText("Excluir");

        jLabel4.setText("Função");

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel5.setText("* Todos os campos são obrigatórios");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jFramLayout = new javax.swing.GroupLayout(jFram);
        jFram.setLayout(jFramLayout);
        jFramLayout.setHorizontalGroup(
            jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramLayout.createSequentialGroup()
                        .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodFunc)
                            .addComponent(txtNome)
                            .addComponent(txtFuncao)
                            .addComponent(txtTel))
                        .addGap(134, 134, 134))
                    .addGroup(jFramLayout.createSequentialGroup()
                        .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFramLayout.createSequentialGroup()
                                .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                                .addGap(38, 38, 38)
                                .addComponent(salvarFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(38, 38, 38)
                                .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(deletFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(146, 146, 146))))
        );
        jFramLayout.setVerticalGroup(
            jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addGroup(jFramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btConsultar)
                    .addComponent(salvarFunc)
                    .addComponent(btEditar)
                    .addComponent(deletFunc))
                .addGap(54, 54, 54))
        );

        jFramLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btConsultar, btEditar, deletFunc, salvarFunc});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 662, 414);
    }// </editor-fold>//GEN-END:initComponents

    private void salvarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarFuncActionPerformed
        // chamando o metodo adicionar
        adicionar();
    }//GEN-LAST:event_salvarFuncActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        // chamando o metodo consultar
        consultar();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // chamando o metodo alterar
        alterar();
    }//GEN-LAST:event_btEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton deletFunc;
    private javax.swing.JPanel jFram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salvarFunc;
    private javax.swing.JTextField txtCodFunc;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
