package Presentation;

import Service.ReadWriteTextFileJDK7;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class CadNida
  extends JFrame
{
  static final String NIDA_FILE_NAME = "C:\\serial_geral\\nida\\nidas.txt";
  static final String OUTPUT_FILE_NAME = "C:\\serial_geral\\nida\\log.txt";
  ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();
  private JButton btnCancelar;
  private JButton btnSalvar;
  private JButton jButton1;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JScrollPane jScrollPane2;
  private JFileChooser picker_nidas;
  private JTextArea txt_area_btw;
  
  public CadNida()
  {
    initComponents();
    preencheertabela();
  }
  
  public void preencheertabela()
  {
    try
    {
      List<String> lines = this.text.readSmallTextFile("C:\\serial_geral\\nida\\nidas.txt");
      for (int i = 1; i < lines.size(); i++)
      {
        String get = (String)lines.get(i);
        
        int pos = get.lastIndexOf(".");
        if (pos > 0) {
          get = get.substring(0, pos);
        }
        this.txt_area_btw.append(get + "\n");
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this, e.getMessage());
    }
  }
  
  public void cadastro() {}
  
  private static String getFileExtension(File file)
  {
    String fileName = file.getName();
    if ((fileName.lastIndexOf(".") != -1) && (fileName.lastIndexOf(".") != 0)) {
      return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    return "";
  }
  
  private void initComponents()
  {
    this.picker_nidas = new JFileChooser();
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.btnCancelar = new JButton();
    this.btnSalvar = new JButton();
    this.jPanel3 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jLabel3 = new JLabel();
    this.jScrollPane2 = new JScrollPane();
    this.txt_area_btw = new JTextArea();
    this.jLabel2 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Adicionar novo tipo de nida");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jPanel1.setBorder(new SoftBevelBorder(0));
    this.jPanel1.setOpaque(false);
    
    this.jPanel2.setOpaque(false);
    
    this.btnCancelar.setText("Cancelar");
    this.btnCancelar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        CadNida.this.btnCancelarActionPerformed(evt);
      }
    });
    this.btnSalvar.setText("Salvar");
    this.btnSalvar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        CadNida.this.btnSalvarActionPerformed(evt);
      }
    });
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.btnSalvar, -2, 91, -2)
      .addGap(18, 18, 18)
      .addComponent(this.btnCancelar)
      .addContainerGap(-1, 32767)));
    
    jPanel2Layout.linkSize(0, new Component[] { this.btnCancelar, this.btnSalvar });
    
    jPanel2Layout.setVerticalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addGap(26, 26, 26)
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.btnSalvar, -2, 31, -2)
      .addComponent(this.btnCancelar))
      .addContainerGap(-1, 32767)));
    
    jPanel2Layout.linkSize(1, new Component[] { this.btnCancelar, this.btnSalvar });
    
    this.jPanel3.setOpaque(false);
    
    this.jLabel1.setFont(new Font("Tahoma", 0, 13));
    this.jLabel1.setText("Tipo de Nida :");
    
    this.jButton1.setText("Escolher label btw");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        CadNida.this.jButton1ActionPerformed(evt);
      }
    });
    this.jLabel3.setText("Nidas");
    
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel3, -2, 46, -2)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addComponent(this.jLabel1, -2, 81, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(this.jButton1, -2, 149, -2)))
      .addContainerGap(-1, 32767)));
    
    jPanel3Layout.setVerticalGroup(jPanel3Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
      .addGap(29, 29, 29)
      .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jLabel1, -2, 25, -2)
      .addComponent(this.jButton1))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
      .addComponent(this.jLabel3)));
    
    this.txt_area_btw.setColumns(20);
    this.txt_area_btw.setRows(5);
    this.jScrollPane2.setViewportView(this.txt_area_btw);
    
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(28, 28, 28)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jPanel3, -2, -1, -2)
      .addComponent(this.jPanel2, -2, -1, -2)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(10, 10, 10)
      .addComponent(this.jScrollPane2, -2, 388, -2)))
      .addContainerGap(-1, 32767)));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(46, 46, 46)
      .addComponent(this.jPanel3, -2, -1, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(this.jScrollPane2, -2, 112, -2)
      .addGap(27, 27, 27)
      .addComponent(this.jPanel2, -2, -1, -2)
      .addContainerGap(-1, 32767)));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(20, 20, 570, -1));
    
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    this.jLabel2.setPreferredSize(new Dimension(400, 400));
    getContentPane().add(this.jLabel2, new AbsoluteConstraints(0, 0, 610, 470));
    
    setSize(new Dimension(622, 501));
    setLocationRelativeTo(null);
  }
  
  private void btnSalvarActionPerformed(ActionEvent evt)
  {
    JOptionPane.showMessageDialog(this, "File saved.");
  }
  
  private void btnCancelarActionPerformed(ActionEvent evt)
  {
    dispose();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    String path_to_btw = "C:\\serial_geral\\nida\\archivos_btw\\";
    
    int returnVal = this.picker_nidas.showOpenDialog(this);
    if (returnVal == 0)
    {
      File file = this.picker_nidas.getSelectedFile();
      if (getFileExtension(file).contentEquals("btw")) {
        try
        {
          Files.copy(file.toPath(), new File(path_to_btw + file.getName()).toPath(), new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
          
          List<String> lines = this.text.readSmallTextFile("C:\\serial_geral\\nida\\nidas.txt");
          String fname = file.getName();
          int pos = fname.lastIndexOf(".");
          if (pos > 0) {
            fname = fname.substring(0, pos);
          }
          int can = 0;
          for (int i = 1; i < lines.size(); i++)
          {
            String get = (String)lines.get(i);
            if (get.contentEquals(fname + ".bat"))
            {
              can = 1;
              break;
            }
          }
          if (can == 0)
          {
            lines.add(fname + ".bat");
            this.text.writeSmallTextFile(lines, "C:\\serial_geral\\nida\\nidas.txt");
          }
          this.txt_area_btw.setText("");
          for (int i = 0; i < lines.size(); i++)
          {
            String get = (String)lines.get(i);
            this.txt_area_btw.append(get + "\n");
          }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(this, e.getMessage());
        }
      } else {
        JOptionPane.showMessageDialog(this, "ficheiro invalido");
      }
    }
    else
    {
      JOptionPane.showMessageDialog(this, "File access cancelled by user.");
    }
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        CadNida cad = new CadNida();
        cad.setTitle("Adicionar novo tipo de nida");
        cad.setVisible(true);
      }
    });
  }
}
