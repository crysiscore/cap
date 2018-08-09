package Presentation;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class MenuPainel
  extends JFrame
{
  String Username = "";
  String Categoria = "";
  private JButton btn_cartao;
  private JButton btn_new_nida;
  private JButton btn_nida;
  private JButton btn_serie;
  private JLabel jLabel2;
  private JPanel jPanel1;
  private JPanel jPanel3;
  
  public MenuPainel()
  {
    initComponents();
  }
  
  public MenuPainel(String username, String cat)
  {
    this.Username = username;
    this.Categoria = cat;
    initComponents();
    if (this.Categoria.contains("0"))
    {
      this.btn_cartao.setEnabled(false);
    }
    else if (this.Categoria.contains("1"))
    {
      this.btn_new_nida.setEnabled(false);
      this.btn_nida.setEnabled(false);
      this.btn_serie.setEnabled(false);
    }
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jPanel3 = new JPanel();
    this.btn_serie = new JButton();
    this.btn_nida = new JButton();
    this.btn_cartao = new JButton();
    this.btn_new_nida = new JButton();
    this.jLabel2 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Menu");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jPanel1.setBorder(new SoftBevelBorder(0));
    this.jPanel1.setOpaque(false);
    
    this.jPanel3.setOpaque(false);
    
    this.btn_serie.setText("Imprimir Nr de Serie");
    this.btn_serie.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        MenuPainel.this.btn_serieActionPerformed(evt);
      }
    });
    this.btn_nida.setText("Imprimir Nida");
    this.btn_nida.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        MenuPainel.this.btn_nidaActionPerformed(evt);
      }
    });
    this.btn_cartao.setText("Imprimir Cartao");
    this.btn_cartao.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        MenuPainel.this.btn_cartaoActionPerformed(evt);
      }
    });
    this.btn_new_nida.setText("Novo tipo de Nida");
    this.btn_new_nida.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        MenuPainel.this.btn_new_nidaActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addGap(97, 97, 97)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(this.btn_nida, -1, 289, 32767)
      .addComponent(this.btn_serie, -1, -1, 32767))
      .addComponent(this.btn_cartao, -2, 149, -2)
      .addComponent(this.btn_new_nida, -2, 149, -2))
      .addContainerGap(157, 32767)));
    
    jPanel3Layout.linkSize(0, new Component[] { this.btn_cartao, this.btn_new_nida, this.btn_nida, this.btn_serie });
    
    jPanel3Layout.setVerticalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addComponent(this.btn_nida, -2, 36, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.btn_serie, -2, 38, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(this.btn_cartao, -2, 30, -2)
      .addGap(18, 18, 18)
      .addComponent(this.btn_new_nida, -2, 39, -2)
      .addGap(57, 57, 57)));
    
    jPanel3Layout.linkSize(1, new Component[] { this.btn_cartao, this.btn_new_nida, this.btn_nida, this.btn_serie });
    
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jPanel3, -2, -1, -2)
      .addContainerGap(11, 32767)));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(52, 52, 52)
      .addComponent(this.jPanel3, -2, 252, -2)
      .addContainerGap(80, 32767)));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(30, 20, 570, 390));
    
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    this.jLabel2.setPreferredSize(new Dimension(400, 400));
    getContentPane().add(this.jLabel2, new AbsoluteConstraints(0, 0, 610, 470));
    
    setSize(new Dimension(622, 501));
    setLocationRelativeTo(null);
  }
  
  private void btn_serieActionPerformed(ActionEvent evt)
  {
    Series se = new Series(this.Username);
    se.setVisible(true);
    dispose();
  }
  
  private void btn_nidaActionPerformed(ActionEvent evt)
  {
    Nidas se = new Nidas(this.Username);
    se.setVisible(true);
    dispose();
  }
  
  private void btn_cartaoActionPerformed(ActionEvent evt)
  {
    cards ca = new cards(this.Username);
    ca.setVisible(true);
    dispose();
  }
  
  private void btn_new_nidaActionPerformed(ActionEvent evt)
  {
    CadNida cad = new CadNida();
    cad.setVisible(true);
    dispose();
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new MenuPainel().setVisible(true);
      }
    });
  }
}
