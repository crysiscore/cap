package Presentation;

import DataAcessLayer.CartaoDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class PrintedNidas
  extends JFrame
{
  String userName;
  private JButton btnPrintAll;
  private JButton btnPrintNew;
  private JLabel jLabel2;
  private JLabel jLabel4;
  private JScrollPane jScrollPane1;
  private JTextArea jtxtPermIDs;
  private JFileChooser picker_nidas;
  
  public PrintedNidas()
  {
    initComponents();
  }
  
  public PrintedNidas(ResultSet r, String UserName)
  {
    initComponents();
    this.userName = UserName;
    preencheertabela(r);
  }
  
  public void preencheertabela(ResultSet r)
  {
    try
    {
      while (r.next()) {
        this.jtxtPermIDs.append(r.getString("perm_id") + "   " + r.getString("name") + "\n");
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this, e.getMessage());
    }
  }
  
  private void initComponents()
  {
    this.picker_nidas = new JFileChooser();
    this.btnPrintAll = new JButton();
    this.btnPrintNew = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.jtxtPermIDs = new JTextArea();
    this.jLabel4 = new JLabel();
    this.jLabel2 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Nidas - warning");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.btnPrintAll.setText("Imprimir Todos");
    this.btnPrintAll.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        PrintedNidas.this.btnPrintAllActionPerformed(evt);
      }
    });
    getContentPane().add(this.btnPrintAll, new AbsoluteConstraints(130, 180, -1, -1));
    
    this.btnPrintNew.setText("Imprimir novos");
    this.btnPrintNew.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        PrintedNidas.this.btnPrintNewActionPerformed(evt);
      }
    });
    getContentPane().add(this.btnPrintNew, new AbsoluteConstraints(420, 180, -1, -1));
    
    this.jtxtPermIDs.setColumns(20);
    this.jtxtPermIDs.setRows(5);
    this.jScrollPane1.setViewportView(this.jtxtPermIDs);
    
    getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(50, 30, 530, 140));
    
    this.jLabel4.setText("Os cartoes Ja foram impressos, deseja imprimir novamente?");
    getContentPane().add(this.jLabel4, new AbsoluteConstraints(50, 10, -1, -1));
    
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    this.jLabel2.setPreferredSize(new Dimension(400, 400));
    getContentPane().add(this.jLabel2, new AbsoluteConstraints(0, 0, 640, 230));
    
    setSize(new Dimension(651, 258));
    setLocationRelativeTo(null);
  }
  
  private void btnPrintAllActionPerformed(ActionEvent evt)
  {
    try
    {
      ResultSet fn = null;
      
      Process process = new ProcessBuilder(new String[] { "C:\\Program Files\\Seagull\\BarTender Suite\\bartend", "/P", "/X", "C:\\cartao\\cartao.btw" }).start();
      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      process.waitFor();
      if (process.exitValue() == 0)
      {
        fn = new CartaoDAO().FinalisePrinting(this.userName);
        JOptionPane.showMessageDialog(this.rootPane, "Cartoes Impressos");
      }
      else
      {
        JOptionPane.showMessageDialog(this.rootPane, "Error nr :" + process.exitValue());
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
    }
    dispose();
  }
  
  private void btnPrintNewActionPerformed(ActionEvent evt)
  {
    try
    {
      ResultSet rs = null;
      ResultSet fn = null;
      rs = new CartaoDAO().DeletePrinteCards();
      
      Process process = new ProcessBuilder(new String[] { "C:\\Program Files\\Seagull\\BarTender Suite\\bartend", "/P", "/X", "C:\\cartao\\cartao.btw" }).start();
      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      process.waitFor();
      if (process.exitValue() == 0)
      {
        fn = new CartaoDAO().FinalisePrinting(this.userName);
        JOptionPane.showMessageDialog(this.rootPane, "Cartoes Impressos");
      }
      else
      {
        JOptionPane.showMessageDialog(this.rootPane, "Error nr :" + process.exitValue());
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
    }
    dispose();
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        PrintedNidas cad = new PrintedNidas();
        cad.setTitle("Impimir Cartao");
        cad.setVisible(true);
      }
    });
  }
}
