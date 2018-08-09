package Presentation;

import Service.ReadWriteTextFileJDK7;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class CadUsuarios
  extends JFrame
{
  ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();
  static final String USER_FILE = "C:\\serial_geral\\serialno\\users.txt";
  private JButton jBCancelar;
  private JButton jBGuardar;
  private JComboBox jCCategoria;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel4;
  private JTextField jTNome;
  private JPasswordField jTSenha;
  
  public CadUsuarios()
  {
    initComponents();
    habilitados();
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jPanel4 = new JPanel();
    this.jBGuardar = new JButton();
    this.jBCancelar = new JButton();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jCCategoria = new JComboBox();
    this.jLabel3 = new JLabel();
    this.jTNome = new JTextField();
    this.jTSenha = new JPasswordField();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Usuario Do Sistema");
    setCursor(new Cursor(0));
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jPanel1.setBorder(BorderFactory.createTitledBorder("CADASTROS DE USUARIOS"));
    this.jPanel1.setOpaque(false);
    
    this.jPanel4.setOpaque(false);
    
    this.jBGuardar.setText("GUARDAR");
    this.jBGuardar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        CadUsuarios.this.jBGuardarActionPerformed(evt);
      }
    });
    this.jBCancelar.setText("CANCELAR");
    this.jBCancelar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        CadUsuarios.this.jBCancelarActionPerformed(evt);
      }
    });
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addComponent(this.jBGuardar, -2, 120, -2)
      .addGap(34, 34, 34)
      .addComponent(this.jBCancelar, -2, 100, -2)
      .addGap(566, 566, 566)));
    
    jPanel4Layout.setVerticalGroup(jPanel4Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
      .addContainerGap(20, 32767)
      .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jBGuardar, -2, 27, -2)
      .addComponent(this.jBCancelar))
      .addContainerGap()));
    
    jPanel4Layout.linkSize(1, new Component[] { this.jBCancelar, this.jBGuardar });
    
    this.jPanel2.setOpaque(false);
    
    this.jLabel1.setText("NOME  :");
    
    this.jLabel2.setText("SENHA :");
    
    this.jCCategoria.setModel(new DefaultComboBoxModel(new String[] { "Centro de dados\t", "Demografia" }));
    
    this.jLabel3.setText("Departamento:");
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addGap(23, 23, 23)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING)
      .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING)
      .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING))
      .addGap(18, 18, 18)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(this.jCCategoria, -2, 336, -2)
      .addComponent(this.jTNome, -1, 432, 32767)
      .addComponent(this.jTSenha))
      .addContainerGap(212, 32767)));
    
    jPanel2Layout.setVerticalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addGap(26, 26, 26)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel1)
      .addComponent(this.jTNome, -2, -1, -2))
      .addGap(18, 18, 18)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel2)
      .addComponent(this.jTSenha, -2, -1, -2))
      .addGap(18, 18, 18)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel3)
      .addComponent(this.jCCategoria, -2, -1, -2))
      .addContainerGap(53, 32767)));
    
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(62, 62, 62)
      .addComponent(this.jPanel4, -2, 509, -2))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jPanel2, -1, -1, 32767)))
      .addContainerGap())
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(0, 778, 32767)
      .addComponent(this.jLabel4)
      .addGap(0, 0, 32767))));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(this.jPanel2, -2, -1, -2)
      .addGap(175, 175, 175)
      .addComponent(this.jPanel4, -1, -1, 32767)
      .addGap(19, 19, 19))
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(0, 211, 32767)
      .addComponent(this.jLabel4)
      .addGap(0, 212, 32767))));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 11, 790, 450));
    
    this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    getContentPane().add(this.jLabel5, new AbsoluteConstraints(0, 0, 900, 480));
    
    setBounds(220, 170, 826, 511);
  }
  
  public boolean verificadados()
  {
    if ((this.jTNome.getText().equals("")) && (this.jTNome.getText().equals("")) && (this.jCCategoria.getSelectedItem().equals("")))
    {
      JOptionPane.showMessageDialog(this.rootPane, "INTRODUZA DADOS ANTES DE GUARDA-LOS");
      habilitados();
      return true;
    }
    if (this.jTNome.getText().equals(""))
    {
      JOptionPane.showMessageDialog(this.rootPane, "INTRODUZA NOME ANTES DE SALVAR");
      
      return true;
    }
    if (this.jTSenha.getText().equals(""))
    {
      JOptionPane.showMessageDialog(this.rootPane, "INTRODUZA A SENHA");
      
      return true;
    }
    return false;
  }
  
  public int CredentialPolicy(String username, String pass)
  {
    int token = 1;
    if (username.length() < 4)
    {
      token = 0;
      JOptionPane.showMessageDialog(this.rootPane, "Username deve ter no minimo 4 caracteres");
    }
    if (pass.length() < 4)
    {
      token = 0;
      JOptionPane.showMessageDialog(this.rootPane, "Username deve ter no minimo 4 caracteres");
    }
    return token;
  }
  
  public final void desabilitados()
  {
    this.jTNome.setEnabled(false);
    this.jTSenha.setEnabled(false);
    this.jCCategoria.setEnabled(false);
  }
  
  public void habilitados()
  {
    this.jTNome.setText("");
    this.jTSenha.setText("");
    this.jCCategoria.setSelectedItem("");
  }
  
  private void jBGuardarActionPerformed(ActionEvent evt)
  {
    if (!verificadados()) {
      try
      {
        List<String> users = this.text.readSmallTextFile("C:\\serial_geral\\serialno\\users.txt");
        if (CredentialPolicy(this.jTNome.getText(), this.jTSenha.getText()) == 1)
        {
          int categoria = this.jCCategoria.getSelectedIndex();
          
          users.add(this.jTNome.getText() + " " + this.jTSenha.getText() + " " + categoria);
          this.text.writeSmallTextFile(users, "C:\\serial_geral\\serialno\\users.txt");
          this.jTNome.setText("");
          this.jTSenha.setText("");
          JOptionPane.showMessageDialog(this.rootPane, "Usuario adicionado");
        }
      }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(this.rootPane, "NAO FOI POSSIVEL CADASTRAR O USUARIO" + ex);
      }
    }
  }
  
  private class RowListenermexertabela
    implements ListSelectionListener
  {
    private RowListenermexertabela() {}
    
    public void valueChanged(ListSelectionEvent event)
    {
      if (event.getValueIsAdjusting()) {}
    }
  }
  
  private void jBCancelarActionPerformed(ActionEvent evt)
  {
    dispose();
  }
  
  public static void main(String[] args)
    throws SQLException
  {
    new CadUsuarios().setVisible(true);
    new CadUsuarios().setTitle("UNIDADES");
    EventQueue.invokeLater(new Runnable()
    {
      public void run() {}
    });
  }
}
