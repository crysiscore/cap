package Presentation;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class About
  extends JFrame
{
  private JLabel jLabel13;
  private JLabel jLabel15;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel19;
  private JLabel jLabel2;
  private JLabel jLabel21;
  private JLabel jLabel22;
  private JLabel jLabel23;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel7;
  private JLabel jLabel9;
  private JPanel jPanel1;
  private JPanel jPanel2;
  
  public About()
  {
    initComponents();
  }
  
  private void initComponents()
  {
    this.jLabel7 = new JLabel();
    this.jLabel13 = new JLabel();
    this.jLabel15 = new JLabel();
    this.jPanel1 = new JPanel();
    this.jLabel2 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel9 = new JLabel();
    this.jLabel16 = new JLabel();
    this.jLabel17 = new JLabel();
    this.jLabel19 = new JLabel();
    this.jLabel21 = new JLabel();
    this.jLabel22 = new JLabel();
    this.jLabel23 = new JLabel();
    this.jPanel2 = new JPanel();
    
    this.jLabel7.setText("jLabel7");
    
    this.jLabel13.setText("jLabel13");
    
    this.jLabel15.setText("jLabel15");
    
    setDefaultCloseOperation(2);
    setTitle("Sobre os Autores");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jLabel2.setFont(new Font("Tahoma", 0, 12));
    this.jLabel2.setText("Autor ");
    
    this.jLabel4.setFont(new Font("Tahoma", 0, 12));
    this.jLabel4.setText("Agnaldo Samuel");
    
    this.jLabel5.setText("---------------------------------------------------------------------------------------------------------");
    
    this.jLabel9.setText("--------------------------------------------------------------------------------------------------------");
    
    this.jLabel16.setFont(new Font("Tahoma", 0, 12));
    this.jLabel16.setText("846133851");
    
    this.jLabel17.setFont(new Font("Tahoma", 0, 12));
    this.jLabel17.setText("Email :  Agnaldosamuel3@gmail.com");
    
    this.jLabel19.setFont(new Font("Tahoma", 0, 12));
    this.jLabel19.setText("Nome :");
    
    this.jLabel21.setFont(new Font("Tahoma", 0, 12));
    this.jLabel21.setText("Profissao :");
    
    this.jLabel22.setFont(new Font("Tahoma", 0, 12));
    this.jLabel22.setText("Gestor de dados");
    
    this.jLabel23.setFont(new Font("Tahoma", 0, 12));
    this.jLabel23.setText("Contacto :");
    
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel9)
      .addComponent(this.jLabel2)
      .addComponent(this.jLabel5)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel21)
      .addComponent(this.jLabel23)
      .addComponent(this.jLabel19))
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel16)
      .addComponent(this.jLabel4)
      .addComponent(this.jLabel22)))
      .addComponent(this.jLabel17))
      .addContainerGap(170, 32767)));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jLabel2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel9)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jLabel5)
      .addGap(18, 18, 18)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel19)
      .addComponent(this.jLabel4))
      .addGap(18, 18, 18)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel21)
      .addComponent(this.jLabel22))
      .addGap(18, 18, 18)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel23)
      .addComponent(this.jLabel16))
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(this.jLabel17)
      .addContainerGap(219, 32767)));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 10, 600, 410));
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 600, 32767));
    
    jPanel2Layout.setVerticalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 55, 32767));
    
    getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 378, 600, -1));
    
    pack();
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new About().setVisible(true);
      }
    });
  }
}
