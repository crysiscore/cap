package Presentation;

import Service.ReadWriteTextFileJDK7;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.accessibility.AccessibleContext;
import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Nidas
  extends JFrame
{
  static final String FILE_NAME = "C:\\serial_geral\\nida\\nidas.txt";
  static final String OUTPUT_FILE_NAME = "C:\\serial_geral\\nida\\log.txt";
  ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();
  static final String HISTORY_FILE = "C:\\serial_geral\\nida\\history.txt";
  String USER_NAME = "";
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Date date = new Date();
  private JButton btn_clear;
  private JButton btn_print;
  private JComboBox cmbCategoria;
  private JLabel jLabel1;
  private JLabel jLabel11;
  private JLabel jLabel5;
  private JLabel jLabel7;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JScrollPane jScrollPane2;
  private JLabel lbl_user_name;
  private JTextField tfquantidade;
  private JTextArea txt_area_output;
  
  public Nidas()
  {
    initComponents();
    populacombo();
  }
  
  public Nidas(String username)
  {
    this.USER_NAME = username;
    initComponents();
    this.lbl_user_name.setText(username);
    populacombo();
  }
  
  public void populacombo()
  {
    try
    {
      List<String> lines = this.text.readSmallTextFile("C:\\serial_geral\\nida\\nidas.txt");
      for (int i = 0; i < lines.size(); i++)
      {
        String get = (String)lines.get(i);
        this.cmbCategoria.addItem(get);
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this, "Erro " + e.getMessage());
    }
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jPanel3 = new JPanel();
    this.jScrollPane2 = new JScrollPane();
    this.txt_area_output = new JTextArea();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.tfquantidade = new JTextField();
    this.jLabel7 = new JLabel();
    this.cmbCategoria = new JComboBox();
    this.btn_print = new JButton();
    this.jLabel5 = new JLabel();
    this.lbl_user_name = new JLabel();
    this.btn_clear = new JButton();
    this.jLabel11 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Nidas");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jPanel1.setOpaque(false);
    this.jPanel1.setLayout(new AbsoluteLayout());
    
    this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Output", 0, 0, new Font("Tahoma", 0, 14)));
    this.jPanel3.setOpaque(false);
    
    this.txt_area_output.setColumns(20);
    this.txt_area_output.setRows(5);
    this.jScrollPane2.setViewportView(this.txt_area_output);
    
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jScrollPane2, -1, 768, 32767)
      .addContainerGap()));
    
    jPanel3Layout.setVerticalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addComponent(this.jScrollPane2, -2, 204, -2)
      .addGap(0, 20, 32767)));
    
    this.jPanel1.add(this.jPanel3, new AbsoluteConstraints(50, 380, 800, 250));
    this.jPanel3.getAccessibleContext().setAccessibleName("Nidas");
    
    this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Imprimir Nidas", 0, 0, new Font("Tahoma", 0, 14)));
    this.jPanel2.setOpaque(false);
    this.jPanel2.setLayout(new AbsoluteLayout());
    
    this.jLabel1.setFont(new Font("Tahoma", 0, 16));
    this.jLabel1.setText("Quantidade :");
    this.jPanel2.add(this.jLabel1, new AbsoluteConstraints(40, 100, -1, -1));
    
    this.tfquantidade.setBackground(new Color(246, 244, 244));
    this.jPanel2.add(this.tfquantidade, new AbsoluteConstraints(140, 100, 150, 28));
    
    this.jLabel7.setFont(new Font("Tahoma", 0, 16));
    this.jLabel7.setText("Nida de :");
    this.jPanel2.add(this.jLabel7, new AbsoluteConstraints(40, 50, -1, -1));
    
    this.cmbCategoria.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Nidas.this.cmbCategoriaActionPerformed(evt);
      }
    });
    this.jPanel2.add(this.cmbCategoria, new AbsoluteConstraints(140, 50, 150, 30));
    
    this.btn_print.setText("Print");
    this.btn_print.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Nidas.this.btn_printActionPerformed(evt);
      }
    });
    this.jPanel2.add(this.btn_print, new AbsoluteConstraints(40, 180, 110, 30));
    
    this.jPanel1.add(this.jPanel2, new AbsoluteConstraints(50, 60, 780, 240));
    
    this.jLabel5.setName("");
    this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(0, 0, 900, 690));
    this.jPanel1.add(this.lbl_user_name, new AbsoluteConstraints(760, 20, -1, -1));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 940, 610));
    
    this.btn_clear.setText("Clear");
    this.btn_clear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Nidas.this.btn_clearActionPerformed(evt);
      }
    });
    getContentPane().add(this.btn_clear, new AbsoluteConstraints(60, 630, 99, 30));
    
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    getContentPane().add(this.jLabel11, new AbsoluteConstraints(0, 0, 910, 720));
    
    setSize(new Dimension(912, 730));
    setLocationRelativeTo(null);
  }
  
  private void btn_printActionPerformed(ActionEvent evt)
  {
    String quantidade = this.tfquantidade.getText();
    if (quantidade.isEmpty())
    {
      this.txt_area_output.setText("");
      JOptionPane.showMessageDialog(this.rootPane, "Quantidade nao pode ser vazia", "", 3, null);
    }
    else if (this.cmbCategoria.getSelectedIndex() == 0)
    {
      this.txt_area_output.setText("");
      JOptionPane.showMessageDialog(this.rootPane, "Selecione o tipo de Nida", "", 3, null);
    }
    else
    {
      try
      {
        Integer.parseInt(quantidade);
        this.txt_area_output.setText("");
        
        File batchFile = new File("C:\\serial_geral\\nida\\archivos_bat\\" + this.cmbCategoria.getSelectedItem().toString());
        
        File outputFile = new File(String.format("C:\\serial_geral\\nida\\log.txt", new Object[0]));
        
        ProcessBuilder processBuilder = new ProcessBuilder(new String[] { batchFile.getAbsolutePath(), quantidade });
        
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(outputFile);
        
        Process process = processBuilder.start();
        int exitStatus = process.waitFor();
        
        List<String> lines = this.text.readSmallTextFile("C:\\serial_geral\\nida\\log.txt");
        for (int i = 0; i < lines.size(); i++)
        {
          String get = (String)lines.get(i);
          this.txt_area_output.append(get + "\n");
        }
        this.txt_area_output.append("" + exitStatus);
        
        List<String> history = this.text.readSmallTextFile("C:\\serial_geral\\nida\\history.txt");
        
        history.add(this.USER_NAME + " " + "Imprimiu :" + quantidade + " " + this.cmbCategoria.getSelectedItem().toString() + " em :" + this.dateFormat.format(this.date));
        this.text.writeSmallTextFile(history, "C:\\serial_geral\\nida\\history.txt");
        this.cmbCategoria.setSelectedIndex(0);
        this.tfquantidade.setText("");
      }
      catch (NumberFormatException e)
      {
        JOptionPane.showMessageDialog(this.rootPane, "Introduzir Numeros apenas" + e, "", 3, null);
      }
      catch (Exception e)
      {
        System.out.println(e);
        JOptionPane.showMessageDialog(this.rootPane, "Ocorreu algum erro!!!\n" + e, "", 3, null);
      }
    }
  }
  
  private void btn_clearActionPerformed(ActionEvent evt)
  {
    this.txt_area_output.setText("");
  }
  
  private void cmbCategoriaActionPerformed(ActionEvent evt) {}
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        Nidas ni = new Nidas();
        ni.setTitle("Imprimir Nidas");
        ni.setVisible(true);
      }
    });
  }
}
