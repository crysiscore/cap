package Presentation;

import BussinessLogic.Child;
import DataAcessLayer.CartaoDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.ResultSet;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class cards
  extends JFrame
{
  private ResultSetTableModel tableModel;
  RowListenerChildren childRowListner = new RowListenerChildren(null);
  private JButton btnPrintCards;
  private JButton btnProcurar;
  private JLabel jLabel1;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JPanel jPanel1;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JScrollPane jScrollPane1;
  private JComboBox jcmbPrintType;
  private JLabel jlblHouse;
  private JLabel jlblPermID;
  private JPanel jpnlDetails;
  private JPanel jpnlDetails1;
  private JPanel jpnlDetails2;
  private JTable jtblDetails;
  private JTextField jtxtHouse;
  private JTextField jtxtPermID;
  private JTextField jtxtRegion;
  private JLabel lblBirthDate;
  private JLabel lblCategoriaP;
  private JLabel lblCodigoP;
  private JLabel lblFamilyID;
  private JLabel lblName;
  private JLabel lblNomeP;
  private JLabel lblPermID;
  private JLabel lblPrecoP;
  private JLabel lblQuantidadeP;
  private JLabel lblRegion;
  private JLabel lblSex;
  private JLabel lblUnidadeP;
  private JLabel lblUsername;
  private JLabel lbl_user_name;
  
  public cards()
  {
    initComponents();
    this.jtxtHouse.setEditable(false);
    this.jtxtHouse.setText("");
    this.jtxtRegion.setEditable(false);
    this.jtxtRegion.setText("");
    this.jtxtPermID.setEditable(true);
    this.jcmbPrintType.setSelectedIndex(1);
    this.jpnlDetails1.setOpaque(false);
    this.jpnlDetails2.setOpaque(false);
    this.jpnlDetails.setVisible(false);
    this.btnPrintCards.setEnabled(false);
  }
  
  public cards(String username)
  {
    initComponents();
    this.jtxtHouse.setEditable(false);
    this.jtxtHouse.setText("");
    this.jtxtRegion.setEditable(false);
    this.jtxtRegion.setText("");
    this.jtxtPermID.setEditable(true);
    this.jcmbPrintType.setSelectedIndex(1);
    this.jpnlDetails1.setOpaque(false);
    this.jpnlDetails2.setOpaque(false);
    this.jpnlDetails.setVisible(false);
    this.lblUsername.setText(username);
    this.btnPrintCards.setEnabled(false);
  }
  
  public void resetTable()
  {
    this.jtblDetails.getSelectionModel().removeListSelectionListener(this.childRowListner);
    this.jtblDetails.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } }, new String[] { "Perm_id", "Name", "Sex", "birth date", "mother name" }));
    
    this.jpnlDetails.setVisible(false);
    this.btnPrintCards.setEnabled(false);
  }
  
  public void setPrintType(String print_type)
  {
    resetTable();
    if (print_type.contentEquals("Regiao"))
    {
      this.jtxtHouse.setEditable(false);
      this.jtxtHouse.setText("");
      this.jtxtPermID.setEditable(false);
      this.jtxtPermID.setText("");
      this.jtxtRegion.setEditable(true);
    }
    else if (print_type.contentEquals("PermID"))
    {
      this.jtxtHouse.setEditable(false);
      this.jtxtHouse.setText("");
      this.jtxtRegion.setEditable(false);
      this.jtxtRegion.setText("");
      this.jtxtPermID.setEditable(true);
    }
    else if (print_type.contentEquals("Agregado"))
    {
      this.jtxtRegion.setEditable(false);
      this.jtxtRegion.setText("");
      this.jtxtPermID.setEditable(false);
      this.jtxtPermID.setText("");
      this.jtxtHouse.setEditable(true);
    }
  }
  
  public ResultSet getDataTypeOption()
  {
    String print_type = (String)this.jcmbPrintType.getSelectedItem();
    String searchParameter = "";
    ResultSet rs = null;
    if (print_type.contentEquals("Regiao"))
    {
      searchParameter = this.jtxtRegion.getText();
      if ((searchParameter.isEmpty() | searchParameter.contentEquals(""))) {
        JOptionPane.showMessageDialog(this.rootPane, "Bairro nao pode ser Vazio");
      } else if (!searchParameter.matches("^[0-9]{4}")) {
        JOptionPane.showMessageDialog(this.rootPane, "Bairro incorreto");
      } else {
        try
        {
          rs = new CartaoDAO().getChildByRegion(searchParameter);
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
        }
      }
    }
    else if (print_type.contentEquals("PermID"))
    {
      searchParameter = this.jtxtPermID.getText();
      if ((searchParameter.isEmpty() | searchParameter.contentEquals(""))) {
        JOptionPane.showMessageDialog(this.rootPane, "Nao pode ser vazio");
      } else if (!searchParameter.matches("^[0-9]{4}-[0-9]{3}-[0-9]{2}")) {
        JOptionPane.showMessageDialog(this.rootPane, "Perm_id incorreto");
      } else {
        try
        {
          rs = new CartaoDAO().getChildByPermID(searchParameter);
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
        }
      }
    }
    else if (print_type.contentEquals("Agregado"))
    {
      searchParameter = this.jtxtHouse.getText();
      if ((searchParameter.isEmpty() | searchParameter.contentEquals(""))) {
        JOptionPane.showMessageDialog(this.rootPane, "Nao pode ser vazio");
      } else if (!searchParameter.matches("^[0-9]{4}-[0-9]{3}")) {
        JOptionPane.showMessageDialog(this.rootPane, "Agregado incorreto");
      } else {
        try
        {
          rs = new CartaoDAO().getChildByFamilyID(searchParameter);
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
        }
      }
    }
    return rs;
  }
  
  private class RowListenerChildren
    implements ListSelectionListener
  {
    private RowListenerChildren() {}

        private RowListenerChildren(Object object) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    public void valueChanged(ListSelectionEvent event)
    {
      if (event.getValueIsAdjusting()) {
        return;
      }
      Child ch = new Child();
      int index_perm_id = 0;
      int index_name = 1;
      int index_sex = 2;
      int index_birth_date = 3;
      int index_family_id = 4;
      int index_moth_name = 4;
      int linha = cards.this.jtblDetails.getSelectedRow();
      String pemr_id = "";
      String moth_name = "";
      String family_id = "";
      pemr_id = cards.this.jtblDetails.getValueAt(linha, index_perm_id).toString();
      String name = cards.this.jtblDetails.getValueAt(linha, index_name).toString();
      String sex = cards.this.jtblDetails.getValueAt(linha, index_sex).toString();
      String birth_date = cards.this.jtblDetails.getValueAt(linha, index_birth_date).toString();
      
      family_id = cards.this.jtblDetails.getValueAt(linha, index_family_id).toString();
      
      ch.setPerm_id(pemr_id);
      ch.setName(name);
      ch.setSex(sex);
      ch.setName(name);
      ch.setBirth_date(birth_date);
      ch.setFamily_id(family_id);
      try
      {
        cards.this.jpnlDetails.setVisible(true);
        cards.this.setChildDetails(ch);
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(cards.this.rootPane, e.getMessage() + " " + "Contacte o Desenvolvedor do software", "", 3, null);
      }
    }
  }
  
  private void setChildDetails(Child p)
  {
    this.lblPermID.setText(p.getPerm_id().toString());
    this.lblSex.setText(p.getSex().toString());
    this.lblName.setText(p.getName().toString());
    this.lblBirthDate.setText(p.getBirth_date().toString());
    this.lblFamilyID.setText(p.getFamily_id().toString());
  }
  
  private void ResetChildDetails()
  {
    this.lblPermID.setText("");
    this.lblSex.setText("");
    this.lblName.setText("");
    this.lblBirthDate.setText("");
    this.lblFamilyID.setText("");
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jcmbPrintType = new JComboBox();
    this.lbl_user_name = new JLabel();
    this.jLabel12 = new JLabel();
    this.jPanel5 = new JPanel();
    this.btnProcurar = new JButton();
    this.jtxtRegion = new JTextField();
    this.lblRegion = new JLabel();
    this.jlblHouse = new JLabel();
    this.jtxtHouse = new JTextField();
    this.jtxtPermID = new JTextField();
    this.jlblPermID = new JLabel();
    this.jPanel4 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.jtblDetails = new JTable();
    this.jpnlDetails = new JPanel();
    this.jLabel5 = new JLabel();
    this.lblCodigoP = new JLabel();
    this.lblNomeP = new JLabel();
    this.lblPrecoP = new JLabel();
    this.lblCategoriaP = new JLabel();
    this.lblQuantidadeP = new JLabel();
    this.lblUnidadeP = new JLabel();
    this.jpnlDetails2 = new JPanel();
    this.jLabel2 = new JLabel();
    this.jLabel1 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel13 = new JLabel();
    this.jpnlDetails1 = new JPanel();
    this.lblSex = new JLabel();
    this.lblPermID = new JLabel();
    this.lblBirthDate = new JLabel();
    this.lblFamilyID = new JLabel();
    this.lblName = new JLabel();
    this.btnPrintCards = new JButton();
    this.lblUsername = new JLabel();
    this.jLabel11 = new JLabel();
    
    setDefaultCloseOperation(2);
    setTitle("Numero de Series");
    setResizable(false);
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jPanel1.setOpaque(false);
    this.jPanel1.setLayout(new AbsoluteLayout());
    
    this.jcmbPrintType.setModel(new DefaultComboBoxModel(new String[] { "Regiao", "PermID", "Agregado" }));
    this.jcmbPrintType.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        cards.this.jcmbPrintTypeActionPerformed(evt);
      }
    });
    this.jPanel1.add(this.jcmbPrintType, new AbsoluteConstraints(170, 50, 160, -1));
    this.jPanel1.add(this.lbl_user_name, new AbsoluteConstraints(770, 20, -1, -1));
    
    this.jLabel12.setText("Tipo de Impressao :");
    this.jPanel1.add(this.jLabel12, new AbsoluteConstraints(20, 50, -1, -1));
    
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Imprimir", 0, 0, new Font("Ubuntu", 0, 14)));
    this.jPanel5.setOpaque(false);
    
    this.btnProcurar.setText("Procurar");
    this.btnProcurar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        cards.this.btnProcurarActionPerformed(evt);
      }
    });
    this.jtxtRegion.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        cards.this.jtxtRegionFocusLost(evt);
      }
    });
    this.jtxtRegion.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        cards.this.jtxtRegionMouseClicked(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        cards.this.jtxtRegionMouseExited(evt);
      }
    });
    this.jtxtRegion.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent evt)
      {
        cards.this.jtxtRegionKeyTyped(evt);
      }
    });
    this.lblRegion.setText("Regiao :");
    
    this.jlblHouse.setText("House :");
    
    this.jlblPermID.setText("Perm_id :");
    
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
      .addGap(23, 23, 23)
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      .addGroup(jPanel5Layout.createSequentialGroup()
      .addComponent(this.lblRegion)
      .addGap(18, 18, 18)
      .addComponent(this.jtxtRegion, -2, 220, -2))
      .addComponent(this.btnProcurar)
      .addGroup(jPanel5Layout.createSequentialGroup()
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jlblHouse, GroupLayout.Alignment.TRAILING)
      .addComponent(this.jlblPermID, GroupLayout.Alignment.TRAILING))
      .addGap(18, 18, 18)
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jtxtPermID, -2, 220, -2)
      .addComponent(this.jtxtHouse, -2, 220, -2))))
      .addContainerGap(34, 32767)));
    
    jPanel5Layout.setVerticalGroup(jPanel5Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
      .addGap(15, 15, 15)
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.lblRegion)
      .addComponent(this.jtxtRegion, -2, 29, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jtxtHouse, -2, 28, -2)
      .addComponent(this.jlblHouse))
      .addGap(18, 18, 18)
      .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.jtxtPermID, -2, 28, -2)
      .addComponent(this.jlblPermID))
      .addGap(30, 30, 30)
      .addComponent(this.btnProcurar, -2, 32, -2)
      .addContainerGap(-1, 32767)));
    
    this.jPanel1.add(this.jPanel5, new AbsoluteConstraints(20, 100, 370, 230));
    
    this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Details", 0, 0, new Font("Cambria", 0, 16)));
    this.jPanel4.setOpaque(false);
    
    this.jtblDetails.setFont(new Font("Ubuntu", 0, 10));
    this.jtblDetails.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } }, new String[] { "Perm_id", "Name", "Sex", "birth date", "mother name" }));
    
    this.jtblDetails.setRowHeight(26);
    this.jtblDetails.setShowVerticalLines(false);
    this.jScrollPane1.setViewportView(this.jtblDetails);
    
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jScrollPane1, -1, 544, 32767)
      .addContainerGap()));
    
    jPanel4Layout.setVerticalGroup(jPanel4Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jScrollPane1, -1, 229, 32767)
      .addContainerGap()));
    
    this.jPanel1.add(this.jPanel4, new AbsoluteConstraints(20, 360, 580, 280));
    
    this.jpnlDetails.setBorder(BorderFactory.createTitledBorder(null, "Membro", 0, 0, new Font("Tahoma", 0, 14)));
    this.jpnlDetails.setFont(new Font("Tahoma", 0, 14));
    this.jpnlDetails.setOpaque(false);
    
    this.jLabel5.setFont(new Font("Segoe UI", 0, 12));
    this.jLabel5.setText("MotherID:");
    
    this.lblCodigoP.setFont(new Font("Segoe UI", 0, 12));
    
    this.lblNomeP.setFont(new Font("Segoe UI", 0, 12));
    
    this.lblPrecoP.setFont(new Font("Segoe UI", 0, 12));
    
    this.lblCategoriaP.setFont(new Font("Segoe UI", 0, 12));
    
    this.lblQuantidadeP.setFont(new Font("Segoe UI", 0, 12));
    
    this.lblUnidadeP.setFont(new Font("Segoe UI", 0, 12));
    
    this.jLabel2.setFont(new Font("Ubuntu", 0, 13));
    this.jLabel2.setText("Nome :");
    
    this.jLabel1.setFont(new Font("Ubuntu", 0, 13));
    this.jLabel1.setText("Perm_id :");
    
    this.jLabel3.setFont(new Font("Ubuntu", 0, 13));
    this.jLabel3.setText("Sex :");
    
    this.jLabel4.setFont(new Font("Ubuntu", 0, 13));
    this.jLabel4.setText("Birth Date :");
    
    this.jLabel13.setFont(new Font("Ubuntu", 0, 13));
    this.jLabel13.setText("Family_id :");
    
    GroupLayout jpnlDetails2Layout = new GroupLayout(this.jpnlDetails2);
    this.jpnlDetails2.setLayout(jpnlDetails2Layout);
    jpnlDetails2Layout.setHorizontalGroup(jpnlDetails2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetails2Layout.createSequentialGroup()
      .addGroup(jpnlDetails2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel1)
      .addComponent(this.jLabel2)
      .addComponent(this.jLabel3)
      .addComponent(this.jLabel4)
      .addComponent(this.jLabel13))
      .addGap(0, 4, 32767)));
    
    jpnlDetails2Layout.setVerticalGroup(jpnlDetails2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetails2Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jLabel1)
      .addGap(24, 24, 24)
      .addComponent(this.jLabel2)
      .addGap(18, 18, 18)
      .addComponent(this.jLabel3)
      .addGap(18, 18, 18)
      .addComponent(this.jLabel4)
      .addGap(18, 18, 18)
      .addComponent(this.jLabel13)
      .addContainerGap(-1, 32767)));
    
    this.lblSex.setFont(new Font("Ubuntu", 0, 13));
    this.lblSex.setText("jLabel6");
    
    this.lblPermID.setFont(new Font("Ubuntu", 0, 13));
    this.lblPermID.setText("jLabel6");
    
    this.lblBirthDate.setFont(new Font("Ubuntu", 0, 13));
    this.lblBirthDate.setText("jLabel6");
    
    this.lblFamilyID.setFont(new Font("Ubuntu", 0, 13));
    this.lblFamilyID.setText("jLabel6");
    
    this.lblName.setFont(new Font("Ubuntu", 0, 13));
    this.lblName.setText("jLabel6");
    
    GroupLayout jpnlDetails1Layout = new GroupLayout(this.jpnlDetails1);
    this.jpnlDetails1.setLayout(jpnlDetails1Layout);
    jpnlDetails1Layout.setHorizontalGroup(jpnlDetails1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetails1Layout.createSequentialGroup()
      .addGroup(jpnlDetails1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.lblPermID)
      .addComponent(this.lblName)
      .addComponent(this.lblSex)
      .addComponent(this.lblBirthDate)
      .addComponent(this.lblFamilyID))
      .addGap(0, 216, 32767)));
    
    jpnlDetails1Layout.setVerticalGroup(jpnlDetails1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetails1Layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addComponent(this.lblPermID)
      .addGap(23, 23, 23)
      .addComponent(this.lblName)
      .addGap(18, 18, 18)
      .addComponent(this.lblSex)
      .addGap(18, 18, 18)
      .addComponent(this.lblBirthDate)
      .addGap(18, 18, 18)
      .addComponent(this.lblFamilyID)
      .addGap(60, 60, 60)));
    
    GroupLayout jpnlDetailsLayout = new GroupLayout(this.jpnlDetails);
    this.jpnlDetails.setLayout(jpnlDetailsLayout);
    jpnlDetailsLayout.setHorizontalGroup(jpnlDetailsLayout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGap(28, 28, 28)
      .addComponent(this.jLabel5, -2, 73, -2))
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addContainerGap()
      .addComponent(this.jpnlDetails2, -2, -1, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jpnlDetails1, -2, -1, -2)))
      .addGap(5, 5, 5)
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.lblQuantidadeP, GroupLayout.Alignment.TRAILING, -1, 527, 32767)
      .addComponent(this.lblUnidadeP, -1, 527, 32767)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGap(167, 167, 167)
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.lblCategoriaP, -1, 360, 32767)
      .addComponent(this.lblPrecoP, -1, 360, 32767)
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(this.lblCodigoP, -1, 360, 32767)
      .addComponent(this.lblNomeP)))))
      .addGap(27, 27, 27)));
    
    jpnlDetailsLayout.setVerticalGroup(jpnlDetailsLayout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGap(24, 24, 24)
      .addComponent(this.lblCodigoP))
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addGroup(jpnlDetailsLayout.createSequentialGroup()
      .addGap(33, 33, 33)
      .addComponent(this.lblNomeP)
      .addGap(18, 18, 18)
      .addComponent(this.lblPrecoP)
      .addGap(18, 18, 18)
      .addComponent(this.lblCategoriaP))
      .addComponent(this.jpnlDetails1, -1, -1, 32767)
      .addComponent(this.jpnlDetails2, -1, -1, 32767))
      .addGap(161, 161, 161)
      .addGroup(jpnlDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel5)
      .addComponent(this.lblQuantidadeP))
      .addGap(18, 18, 18)
      .addComponent(this.lblUnidadeP)))
      .addContainerGap(-1, 32767)));
    
    this.jPanel1.add(this.jpnlDetails, new AbsoluteConstraints(610, 360, 370, 280));
    
    this.btnPrintCards.setText("Imprimir");
    this.btnPrintCards.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        cards.this.btnPrintCardsActionPerformed(evt);
      }
    });
    this.jPanel1.add(this.btnPrintCards, new AbsoluteConstraints(757, 660, 180, 30));
    
    this.lblUsername.setText("jLabel6");
    this.jPanel1.add(this.lblUsername, new AbsoluteConstraints(780, 20, -1, -1));
    
    getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 970, 700));
    
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/Fundo.png")));
    getContentPane().add(this.jLabel11, new AbsoluteConstraints(0, 0, 990, 730));
    
    setSize(new Dimension(983, 745));
    setLocationRelativeTo(null);
  }
  
  private void jcmbPrintTypeActionPerformed(ActionEvent evt)
  {
    String print_type = (String)this.jcmbPrintType.getSelectedItem();
    setPrintType(print_type);
  }
  
  private void btnProcurarActionPerformed(ActionEvent evt)
  {
    try
    {
      this.tableModel = new ResultSetTableModel(getDataTypeOption());
      this.jtblDetails.setModel(this.tableModel);
      if (this.tableModel.getRowCount() >= 1) {
        this.btnPrintCards.setEnabled(true);
      } else {
        this.btnPrintCards.setEnabled(false);
      }
      this.jtblDetails.setFillsViewportHeight(true);
      this.jtblDetails.setRowSelectionAllowed(true);
      this.jtblDetails.getSelectionModel().addListSelectionListener(this.childRowListner);
      ResetChildDetails();
      this.jpnlDetails.setVisible(false);
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
    }
  }
  
  private void jtxtRegionFocusLost(FocusEvent evt) {}
  
  private void jtxtRegionMouseClicked(MouseEvent evt)
  {
    if (this.jtxtRegion.getText().contentEquals("Nome ou Codigo do produto...")) {
      this.jtxtRegion.setText("");
    }
  }
  
  private void jtxtRegionMouseExited(MouseEvent evt) {}
  
  private void jtxtRegionKeyTyped(KeyEvent evt)
  {
    if (this.jtxtRegion.getText().contentEquals("Nome ou Codigo do produto...")) {
      this.jtxtRegion.setText("");
    }
  }
  
  private void btnPrintCardsActionPerformed(ActionEvent evt)
  {
    ResultSet rs = null;
    ResultSet fn = null;
    try
    {
      rs = new CartaoDAO().CheckPrintedCards();
      if (rs.next())
      {
        rs.beforeFirst();
        PrintedNidas p = new PrintedNidas(rs, this.lblUsername.getText());
        p.setVisible(true);
        resetTable();
      }
      else
      {
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
          fn = new CartaoDAO().FinalisePrinting(this.lblUsername.getText());
          JOptionPane.showMessageDialog(this.rootPane, "Cartoes Impressos");
        }
        else
        {
          JOptionPane.showMessageDialog(this.rootPane, "Error nr :" + process.exitValue());
        }
        resetTable();
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.rootPane, e.getMessage());
    }
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        cards se = new cards();
        
        se.setVisible(true);
      }
    });
  }
}
