
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class Clienteview extends javax.swing.JFrame {

    private Color cor = null;
    private JColorChooser escolherCor = new JColorChooser();
    public String textoFormatado ="";
    private String negrito = "não",italico = "não",sublinhado = "não",fonte = "Noto Sans Plain ",tamanho ="12";
    
     public Clienteview() {
        initComponents();
        tamanhosNaCombo(tamanhoLetra);
        fontesNaCombo(tipoLetra);
        botaoEnviar.setEnabled(false);
    }
     
      public String configuracaoTexto(){
        return ("Configuração do texto - Itálico: " + italico + " | Negrito: " + negrito + " | Sublinhado: " + sublinhado + 
                " | Fonte: "+ fonte +" | Tamanho da Fonte: "+ tamanho);
    }
      private void tamanhosNaCombo(JComboBox combo) {
        for (int i = 8; i <= 72; i += 2) {
            combo.addItem(i);
        }
    }
      private void fontesNaCombo(JComboBox combo) {
        String[] fontes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (String fonte : fontes) {
            combo.addItem(fonte);
        }
    }
      
      public void criarEstilo() {
        StyledDocument documento = (StyledDocument) Areatexto.getDocument();
        Style estilo = documento.getStyle(documento.addStyle("StyleAdd", null)
                .getName());
        // sublinhado, negrito, itálico
        if (checkNegrito.isSelected()){
            negrito = "Negrito";
        }else{
            negrito = "Não";
        }
        if (checkItalico.isSelected()){
            italico = "Italico";
        }else{
            italico = "Não";
        }
        if (checkSublinhado.isSelected()){
            sublinhado = "Sublinhado";
        }else{
            sublinhado = "Não";
        }
        
        StyleConstants.setBold(estilo, checkNegrito.isSelected());
        StyleConstants.setItalic(estilo, checkItalico.isSelected());
        StyleConstants.setUnderline(estilo, checkSublinhado.isSelected());
        // fonte
        fonte = (String) tipoLetra.getSelectedItem();
        if (fonte != null) {
            StyleConstants.setFontFamily(estilo, fonte);
        }
        // tamanho
        int tamanhoFonte = 10;
        tamanhoFonte = (Integer) tamanhoLetra.getSelectedItem();
        tamanho = String.valueOf(tamanhoFonte);
        StyleConstants.setFontSize(estilo, tamanhoFonte);
        textoFormatado = Areatexto.getText();
        Areatexto.setText("");
        documento.addStyle("Style", estilo);
        try {
            documento.insertString(documento.getLength(), textoFormatado,
                    estilo);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        botaoEnviar.setEnabled(true);
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Areatexto = new javax.swing.JTextPane();
        checkNegrito = new javax.swing.JCheckBox();
        checkItalico = new javax.swing.JCheckBox();
        checkSublinhado = new javax.swing.JCheckBox();
        botaoEnviar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tipoLetra = new javax.swing.JComboBox<>();
        tamanhoLetra = new javax.swing.JComboBox<>();
        criarEstilo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(Areatexto);

        checkNegrito.setText("Negrito");

        checkItalico.setText("Italico");

        checkSublinhado.setText("Sublinhado");

        botaoEnviar.setText("Enviar");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tipoLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoLetraActionPerformed(evt);
            }
        });

        tamanhoLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanhoLetraActionPerformed(evt);
            }
        });

        criarEstilo.setText("Criar");
        criarEstilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarEstiloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkNegrito)
                            .addComponent(checkItalico))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkSublinhado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(tamanhoLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(criarEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(criarEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkSublinhado)
                            .addComponent(checkNegrito))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tamanhoLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkItalico))
                        .addGap(68, 68, 68)
                        .addComponent(tipoLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] mensagem = new byte[300];
            byte[] mensagem1 = new byte[400];
            String m = textoFormatado; 
            mensagem = m.getBytes();
            mensagem1 = configuracaoTexto().getBytes();
            DatagramPacket pacoteConfiguracao = new DatagramPacket(
                    mensagem1,mensagem1.length ,InetAddress.getByName("127.0.0.1") ,1500 );
            DatagramPacket pacote = new DatagramPacket(
                    mensagem,mensagem.length ,InetAddress.getByName("127.0.0.1") ,1500 );
            socket.send(pacote);
            socket.send(pacoteConfiguracao);
            socket.close();
            Areatexto.setText("");
            botaoEnviar.setEnabled(false);
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tipoLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoLetraActionPerformed

    private void criarEstiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarEstiloActionPerformed
       criarEstilo();
       
    }//GEN-LAST:event_criarEstiloActionPerformed

    private void tamanhoLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanhoLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanhoLetraActionPerformed

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
            java.util.logging.Logger.getLogger(Clienteview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clienteview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clienteview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clienteview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clienteview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Areatexto;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JCheckBox checkItalico;
    private javax.swing.JCheckBox checkNegrito;
    private javax.swing.JCheckBox checkSublinhado;
    private javax.swing.JButton criarEstilo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tamanhoLetra;
    private javax.swing.JComboBox<String> tipoLetra;
    // End of variables declaration//GEN-END:variables
}
