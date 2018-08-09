package Presentation;

import BussinessLogic.Previlegio;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Trick
  extends JFrame
{
  public String USERNAME = "";
  public String CATEGORIA = "";
  Previlegio p = new Previlegio();
  private JButton jButton3;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel15;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel18;
  private JLabel jLabel19;
  private JLabel jLabel20;
  private JLabel jLabel21;
  private JLabel jLabel22;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenu jMenu4;
  private JMenu jMenu5;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem11;
  private JMenuItem jMenuItem3;
  private JMenuItem jMenuItem7;
  private JPanel jPanel2;
  private JToolBar.Separator jSeparator1;
  private JPopupMenu.Separator jSeparator2;
  private JPopupMenu.Separator jSeparator3;
  private JToolBar jToolBar1;
  private JMenuItem jmenu_add_user;
  private JMenuItem jmenu_cartao;
  private JMenu jmenu_cartao_printed;
  private JMenuItem jmenu_new_nida;
  private JMenuItem jmenu_nida;
  private JMenuItem jmenu_printed_card;
  private JMenuItem jmenu_serie;
  private JLabel lblTabPaneProdutos;
  private JLabel lblTabPaneVendas;
  private JLabel lbl_UserCod;
  private JLabel lbl_UserName;
  private JLabel lbl_login_username;
  private JPanel panelPrincipal;
  private JPanel panelTabVendas;
  private JPanel panelTabprodutos;
  
  public Trick()
  {
    initComponents();
    HabilitarTabProdutos();
    setLocation(50, 50);
  }
  
  public Trick(String username, String categoria)
  {
    this.USERNAME = username;
    this.CATEGORIA = categoria;
    initComponents();
    
    this.lbl_login_username.setText(this.lbl_login_username.getText() + " " + this.USERNAME);
    setLocation(5, 5);
    if (this.CATEGORIA.contentEquals("0"))
    {
      this.p.canPrintnidas = true;
      VerificarPrevilegio(this.p);
      this.jmenu_add_user.setEnabled(false);
    }
    else if (this.CATEGORIA.contains("1"))
    {
      this.p.canPrintCard = true;
      VerificarPrevilegio(this.p);
      this.jmenu_add_user.setEnabled(false);
    }
  }
  
  public void UserInfo(String userName, String codUsuario)
  {
    this.lbl_UserName.setText(this.lbl_UserName.getText() + userName + "  ");
    this.lbl_UserCod.setText(codUsuario);
    this.lbl_UserCod.setVisible(false);
  }
  
  public void VerificarPrevilegio(Previlegio prev)
  {
    if (!prev.CanPrintnidas())
    {
      this.jLabel9.setVisible(false);
      this.jLabel10.setVisible(false);
      this.jLabel11.setVisible(false);
      this.jLabel12.setVisible(false);
      this.jmenu_new_nida.setEnabled(false);
      this.jmenu_nida.setEnabled(false);
      this.jmenu_serie.setEnabled(false);
    }
    if (!prev.CanPrintcard())
    {
      this.jLabel15.setVisible(false);
      this.jLabel20.setVisible(false);
      this.jLabel21.setVisible(false);
      this.jLabel22.setVisible(false);
      this.jLabel16.setVisible(false);
      this.jLabel17.setVisible(false);
      this.jmenu_printed_card.setEnabled(false);
      this.jmenu_cartao.setEnabled(false);
    }
  }
  
  private void initComponents()
  {
    this.jToolBar1 = new JToolBar();
    this.jButton3 = new JButton();
    this.jSeparator1 = new JToolBar.Separator();
    this.jLabel7 = new JLabel();
    this.lbl_UserName = new JLabel();
    this.panelPrincipal = new JPanel();
    this.jLabel4 = new JLabel();
    this.lblTabPaneVendas = new JLabel();
    this.jLabel6 = new JLabel();
    this.lblTabPaneProdutos = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel1 = new JLabel();
    this.jPanel2 = new JPanel();
    this.panelTabVendas = new JPanel();
    this.jLabel20 = new JLabel();
    this.jLabel15 = new JLabel();
    this.jLabel21 = new JLabel();
    this.jLabel16 = new JLabel();
    this.jLabel22 = new JLabel();
    this.jLabel17 = new JLabel();
    this.panelTabprodutos = new JPanel();
    this.jLabel9 = new JLabel();
    this.jLabel12 = new JLabel();
    this.jLabel10 = new JLabel();
    this.jLabel11 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel13 = new JLabel();
    this.jLabel18 = new JLabel();
    this.jLabel19 = new JLabel();
    this.jLabel8 = new JLabel();
    this.lbl_login_username = new JLabel();
    this.lbl_UserCod = new JLabel();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenuItem3 = new JMenuItem();
    this.jSeparator2 = new JPopupMenu.Separator();
    this.jmenu_add_user = new JMenuItem();
    this.jSeparator3 = new JPopupMenu.Separator();
    this.jMenuItem7 = new JMenuItem();
    this.jMenu2 = new JMenu();
    this.jmenu_serie = new JMenuItem();
    this.jMenu5 = new JMenu();
    this.jmenu_nida = new JMenuItem();
    this.jmenu_new_nida = new JMenuItem();
    this.jmenu_cartao_printed = new JMenu();
    this.jmenu_cartao = new JMenuItem();
    this.jmenu_printed_card = new JMenuItem();
    this.jMenuItem1 = new JMenuItem();
    this.jMenu4 = new JMenu();
    this.jMenuItem11 = new JMenuItem();
    
    setDefaultCloseOperation(3);
    setTitle("serial geral");
    setMinimumSize(new Dimension(400, 550));
    setPreferredSize(new Dimension(400, 550));
    setResizable(false);
    addWindowListener(new WindowAdapter()
    {
      public void windowClosed(WindowEvent evt)
      {
        Trick.this.TrickLogout(evt);
      }
      
      public void windowClosing(WindowEvent evt)
      {
        Trick.this.windowClose(evt);
      }
    });
    getContentPane().setLayout(new AbsoluteLayout());
    
    this.jToolBar1.setRollover(true);
    this.jToolBar1.setOpaque(false);
    
    this.jButton3.setIcon(new ImageIcon(getClass().getResource("/images/barcode_add.png")));
    this.jButton3.setToolTipText("Imprimir Nida/Serie/Cartao");
    this.jButton3.setFocusable(false);
    this.jButton3.setHorizontalTextPosition(0);
    this.jButton3.setVerticalTextPosition(3);
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jButton3ActionPerformed(evt);
      }
    });
    this.jToolBar1.add(this.jButton3);
    
    this.jSeparator1.setBorder(BorderFactory.createCompoundBorder());
    this.jSeparator1.setPreferredSize(new Dimension(6, 4));
    this.jToolBar1.add(this.jSeparator1);
    
    this.jLabel7.setText("      ");
    this.jToolBar1.add(this.jLabel7);
    
    this.lbl_UserName.setFont(new Font("Segoe UI", 0, 13));
    this.jToolBar1.add(this.lbl_UserName);
    
    getContentPane().add(this.jToolBar1, new AbsoluteConstraints(0, 0, 860, 40));
    
    this.panelPrincipal.setMinimumSize(new Dimension(400, 550));
    this.panelPrincipal.setPreferredSize(new Dimension(400, 550));
    this.panelPrincipal.setLayout(new AbsoluteLayout());
    
    this.jLabel4.setFont(new Font("Segoe UI", 1, 16));
    this.jLabel4.setText("Cartoes");
    this.jLabel4.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel4MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel4MouseEntered(evt);
      }
    });
    this.panelPrincipal.add(this.jLabel4, new AbsoluteConstraints(530, 100, -1, -1));
    
    this.lblTabPaneVendas.setIcon(new ImageIcon(getClass().getResource("/images/slice4.gif")));
    this.lblTabPaneVendas.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.lblTabPaneVendasMouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.lblTabPaneVendasMouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.lblTabPaneVendasMouseExited(evt);
      }
    });
    this.panelPrincipal.add(this.lblTabPaneVendas, new AbsoluteConstraints(420, 90, 310, 40));
    
    this.jLabel6.setFont(new Font("Segoe UI", 1, 16));
    this.jLabel6.setText("Sereagem");
    this.jLabel6.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel6MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel6MouseEntered(evt);
      }
    });
    this.panelPrincipal.add(this.jLabel6, new AbsoluteConstraints(220, 100, -1, -1));
    
    this.lblTabPaneProdutos.setIcon(new ImageIcon(getClass().getResource("/images/slice2.gif")));
    this.lblTabPaneProdutos.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.lblTabPaneProdutosMouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.lblTabPaneProdutosMouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.lblTabPaneProdutosMouseExited(evt);
      }
    });
    this.panelPrincipal.add(this.lblTabPaneProdutos, new AbsoluteConstraints(120, 90, 300, 40));
    
    this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/images/slice1.gif")));
    this.panelPrincipal.add(this.jLabel3, new AbsoluteConstraints(120, 90, 900, 40));
    
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/Untitled-3.png")));
    this.jLabel1.setText("jLabel1");
    this.jLabel1.setPreferredSize(new Dimension(1300, 94));
    this.panelPrincipal.add(this.jLabel1, new AbsoluteConstraints(0, 50, 1090, 70));
    
    this.jPanel2.setMinimumSize(new Dimension(400, 550));
    this.jPanel2.setPreferredSize(new Dimension(400, 550));
    this.jPanel2.setLayout(new AbsoluteLayout());
    
    this.panelTabVendas.setOpaque(false);
    this.panelTabVendas.setLayout(new AbsoluteLayout());
    
    this.jLabel20.setFont(new Font("Segoe UI", 1, 14));
    this.jLabel20.setText("Imprimir Cartoes");
    this.jLabel20.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel20MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel20MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel20, new AbsoluteConstraints(50, 20, 140, -1));
    
    this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel15.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel15MouseClicked(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel15MouseExited(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel15MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel15, new AbsoluteConstraints(10, 10, -1, 40));
    
    this.jLabel21.setFont(new Font("Segoe UI", 1, 14));
    this.jLabel21.setText("Cartoes Impressos");
    this.jLabel21.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel21MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel21MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel21, new AbsoluteConstraints(50, 70, -1, -1));
    
    this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel16.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel16MouseClicked(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel16MouseExited(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel16MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel16, new AbsoluteConstraints(10, 60, -1, 40));
    
    this.jLabel22.setFont(new Font("Segoe UI", 1, 14));
    this.jLabel22.setText("Criancas sem cartao");
    this.jLabel22.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel22MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel22MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel22, new AbsoluteConstraints(50, 120, -1, -1));
    
    this.jLabel17.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel17.setText("Lista de criancas");
    this.jLabel17.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel17MouseClicked(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel17MouseExited(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel17MouseEntered(evt);
      }
    });
    this.panelTabVendas.add(this.jLabel17, new AbsoluteConstraints(10, 110, 230, 40));
    
    this.jPanel2.add(this.panelTabVendas, new AbsoluteConstraints(400, 50, 260, 160));
    
    this.panelTabprodutos.setOpaque(false);
    this.panelTabprodutos.setLayout(new AbsoluteLayout());
    
    this.jLabel9.setFont(new Font("Segoe UI", 1, 13));
    this.jLabel9.setText("Imprimir Nrs de Serie");
    this.jLabel9.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel9MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel9MouseEntered(evt);
      }
    });
    this.panelTabprodutos.add(this.jLabel9, new AbsoluteConstraints(60, 20, -1, 20));
    
    this.jLabel12.setFont(new Font("Segoe UI", 1, 14));
    this.jLabel12.setText("Imprimir Nidas");
    this.jLabel12.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel12MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel12MouseEntered(evt);
      }
    });
    this.panelTabprodutos.add(this.jLabel12, new AbsoluteConstraints(60, 70, -1, -1));
    
    this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel10.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel10MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel10MouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel10MouseExited(evt);
      }
    });
    this.panelTabprodutos.add(this.jLabel10, new AbsoluteConstraints(10, 10, -1, 40));
    
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel11.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel11MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel11MouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel11MouseExited(evt);
      }
    });
    this.panelTabprodutos.add(this.jLabel11, new AbsoluteConstraints(10, 60, -1, 40));
    
    this.jPanel2.add(this.panelTabprodutos, new AbsoluteConstraints(110, 50, 250, 140));
    
    this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/images/slice3.gif")));
    this.jPanel2.add(this.jLabel5, new AbsoluteConstraints(90, 20, 900, 310));
    
    this.jLabel13.setText("jLabel13");
    this.jPanel2.add(this.jLabel13, new AbsoluteConstraints(800, 120, -1, -1));
    
    this.jLabel18.setText("jLabel18");
    this.jPanel2.add(this.jLabel18, new AbsoluteConstraints(770, 50, -1, -1));
    
    this.jLabel19.setText("jLabel19");
    this.jPanel2.add(this.jLabel19, new AbsoluteConstraints(760, 110, -1, -1));
    
    this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
    this.jLabel8.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Trick.this.jLabel8MouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.jLabel8MouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.jLabel8MouseExited(evt);
      }
    });
    this.jPanel2.add(this.jLabel8, new AbsoluteConstraints(120, 60, -1, 40));
    
    this.panelPrincipal.add(this.jPanel2, new AbsoluteConstraints(30, 110, 1000, 380));
    
    this.lbl_login_username.setFont(new Font("Segoe UI", 0, 13));
    this.lbl_login_username.setForeground(new Color(27, 133, 250));
    this.lbl_login_username.setText("Welcome:");
    this.lbl_login_username.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent evt)
      {
        Trick.this.lbl_login_usernameMouseEntered(evt);
      }
      
      public void mouseExited(MouseEvent evt)
      {
        Trick.this.lbl_login_usernameMouseExited(evt);
      }
    });
    this.panelPrincipal.add(this.lbl_login_username, new AbsoluteConstraints(870, 10, 220, 20));
    this.panelPrincipal.add(this.lbl_UserCod, new AbsoluteConstraints(1230, 10, -1, -1));
    
    getContentPane().add(this.panelPrincipal, new AbsoluteConstraints(0, 0, 1090, 540));
    
    this.jMenuBar1.setFont(new Font("Segoe UI", 0, 19));
    this.jMenuBar1.setPreferredSize(new Dimension(243, 27));
    
    this.jMenu1.setText("File");
    
    this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(80, 2));
    this.jMenuItem3.setText("Novo ");
    this.jMenuItem3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jMenuItem3ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem3);
    this.jMenu1.add(this.jSeparator2);
    
    this.jmenu_add_user.setAccelerator(KeyStroke.getKeyStroke(83, 2));
    this.jmenu_add_user.setText("Add user");
    this.jmenu_add_user.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_add_userActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jmenu_add_user);
    this.jMenu1.add(this.jSeparator3);
    
    this.jMenuItem7.setText("Sair");
    this.jMenuItem7.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jMenuItem7ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem7);
    
    this.jMenuBar1.add(this.jMenu1);
    
    this.jMenu2.setText("Sereagem");
    
    this.jmenu_serie.setText("Imprimir Numero de serie");
    this.jmenu_serie.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_serieActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jmenu_serie);
    
    this.jMenuBar1.add(this.jMenu2);
    
    this.jMenu5.setText("Nidas");
    
    this.jmenu_nida.setText("Imprimir Nidas");
    this.jmenu_nida.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_nidaActionPerformed(evt);
      }
    });
    this.jMenu5.add(this.jmenu_nida);
    
    this.jmenu_new_nida.setText("Novo tipo de nida");
    this.jmenu_new_nida.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_new_nidaActionPerformed(evt);
      }
    });
    this.jMenu5.add(this.jmenu_new_nida);
    
    this.jMenuBar1.add(this.jMenu5);
    
    this.jmenu_cartao_printed.setText("Cartoes");
    this.jmenu_cartao_printed.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_cartao_printedActionPerformed(evt);
      }
    });
    this.jmenu_cartao.setText("Imprimir Cartoes");
    this.jmenu_cartao.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_cartaoActionPerformed(evt);
      }
    });
    this.jmenu_cartao_printed.add(this.jmenu_cartao);
    
    this.jmenu_printed_card.setText("Cartoes impressos");
    this.jmenu_printed_card.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jmenu_printed_cardActionPerformed(evt);
      }
    });
    this.jmenu_cartao_printed.add(this.jmenu_printed_card);
    
    this.jMenuItem1.setText("Criancas sem Cartoes");
    this.jmenu_cartao_printed.add(this.jMenuItem1);
    
    this.jMenuBar1.add(this.jmenu_cartao_printed);
    
    this.jMenu4.setText("Ajuda");
    this.jMenu4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jMenu4ActionPerformed(evt);
      }
    });
    this.jMenuItem11.setText("Sobre");
    this.jMenuItem11.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Trick.this.jMenuItem11ActionPerformed(evt);
      }
    });
    this.jMenu4.add(this.jMenuItem11);
    
    this.jMenuBar1.add(this.jMenu4);
    
    setJMenuBar(this.jMenuBar1);
    
    setSize(new Dimension(1103, 715));
    setLocationRelativeTo(null);
  }
  
  private void HabilitarTabVendas()
  {
    this.lblTabPaneVendas.setIcon(new ImageIcon(getClass().getResource("/images/slicemeio.gif")));
    this.lblTabPaneProdutos.setIcon(null);
    this.panelTabVendas.setVisible(true);
    this.jLabel4.setVisible(true);
    this.jLabel4.setFont(new Font("Segoe UI", 1, 16));
    this.jLabel4.setForeground(Color.BLACK);
    
    this.panelTabprodutos.setVisible(false);
  }
  
  private void HabilitarTabProdutos()
  {
    this.lblTabPaneProdutos.setIcon(new ImageIcon(getClass().getResource("/images/slice2.gif")));
    this.panelTabprodutos.setVisible(true);
    this.lblTabPaneVendas.setIcon(null);
    this.jLabel4.setForeground(Color.white);
    this.panelTabVendas.setVisible(false);
  }
  
  private void jLabel8MouseEntered(MouseEvent evt)
  {
    this.jLabel8.setCursor(new Cursor(12));
    this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel8MouseExited(MouseEvent evt)
  {
    this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void jLabel10MouseEntered(MouseEvent evt)
  {
    this.jLabel10.setCursor(new Cursor(12));
    this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel10MouseExited(MouseEvent evt)
  {
    this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void jLabel15MouseEntered(MouseEvent evt)
  {
    this.jLabel15.setCursor(new Cursor(12));
    this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel15MouseExited(MouseEvent evt)
  {
    this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void jLabel16MouseEntered(MouseEvent evt)
  {
    this.jLabel16.setCursor(new Cursor(12));
    this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel16MouseExited(MouseEvent evt)
  {
    this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void lblTabPaneVendasMouseEntered(MouseEvent evt)
  {
    this.lblTabPaneVendas.setCursor(new Cursor(12));
    this.jLabel4.setForeground(Color.getHSBColor(120.0F, 87.0F, 225.0F));
  }
  
  private void lblTabPaneVendasMouseExited(MouseEvent evt)
  {
    this.jLabel4.setForeground(Color.BLACK);
  }
  
  private void jLabel4MouseEntered(MouseEvent evt)
  {
    this.jLabel4.setCursor(new Cursor(12));
    this.jLabel4.setForeground(Color.getHSBColor(120.0F, 87.0F, 225.0F));
  }
  
  private void lblTabPaneVendasMouseClicked(MouseEvent evt)
  {
    HabilitarTabVendas();
  }
  
  private void jLabel4MouseClicked(MouseEvent evt)
  {
    HabilitarTabVendas();
  }
  
  private void lblTabPaneProdutosMouseClicked(MouseEvent evt)
  {
    HabilitarTabProdutos();
  }
  
  private void lblTabPaneProdutosMouseEntered(MouseEvent evt)
  {
    this.lblTabPaneProdutos.setCursor(new Cursor(12));
    this.jLabel6.setForeground(Color.getHSBColor(120.0F, 87.0F, 225.0F));
  }
  
  private void lblTabPaneProdutosMouseExited(MouseEvent evt)
  {
    this.jLabel6.setForeground(Color.BLACK);
  }
  
  private void jLabel6MouseClicked(MouseEvent evt)
  {
    HabilitarTabProdutos();
  }
  
  private void jLabel6MouseEntered(MouseEvent evt)
  {
    this.jLabel6.setCursor(new Cursor(12));
  }
  
  private void lbl_login_usernameMouseEntered(MouseEvent evt)
  {
    this.lbl_login_username.setCursor(new Cursor(12));
    this.lbl_login_username.setForeground(Color.red);
  }
  
  private void lbl_login_usernameMouseExited(MouseEvent evt)
  {
    this.lbl_login_username.setForeground(new Color(27, 133, 250));
  }
  
  private void jLabel10MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Series se = new Series(userName);
    se.setVisible(true);
  }
  
  private void jmenu_add_userActionPerformed(ActionEvent evt)
  {
    CadUsuarios u = new CadUsuarios();
    u.setVisible(true);
  }
  
  private void jMenuItem3ActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    MenuPainel mp = new MenuPainel(userName, this.CATEGORIA);
    mp.setVisible(true);
  }
  
  private void jMenuItem7ActionPerformed(ActionEvent evt)
  {
    System.exit(0);
  }
  
  private void jLabel20MouseEntered(MouseEvent evt)
  {
    this.jLabel20.setCursor(new Cursor(12));
    this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel21MouseEntered(MouseEvent evt)
  {
    this.jLabel21.setCursor(new Cursor(12));
    this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    
    MenuPainel mp = new MenuPainel(userName, this.CATEGORIA);
    mp.setVisible(true);
  }
  
  private void jMenuItem11ActionPerformed(ActionEvent evt)
  {
    About b = new About();
    b.setVisible(true);
  }
  
  private void windowClose(WindowEvent evt) {}
  
  private void jLabel15MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    cards ca = new cards(userName);
    ca.setVisible(true);
  }
  
  private void jLabel20MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    cards ca = new cards(userName);
    ca.setVisible(true);
  }
  
  private void jLabel8MouseClicked(MouseEvent evt) {}
  
  private void jLabel9MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Series se = new Series(userName);
    se.setVisible(true);
  }
  
  private void jmenu_nidaActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Nidas ni = new Nidas(userName);
    ni.setVisible(true);
  }
  
  private void jLabel16MouseClicked(MouseEvent evt) {}
  
  private void jLabel21MouseClicked(MouseEvent evt) {}
  
  private void jmenu_printed_cardActionPerformed(ActionEvent evt) {}
  
  private void jmenu_cartaoActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    cards ca = new cards(userName);
    ca.setVisible(true);
  }
  
  private void jmenu_new_nidaActionPerformed(ActionEvent evt)
  {
    CadNida cad = new CadNida();
    cad.setVisible(true);
  }
  
  private void TrickLogout(WindowEvent evt) {}
  
  private void jmenu_cartao_printedActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    cards ca = new cards(userName);
    ca.setVisible(true);
  }
  
  private void jLabel11MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Nidas ni = new Nidas(userName);
    ni.setVisible(true);
  }
  
  private void jLabel11MouseEntered(MouseEvent evt)
  {
    this.jLabel12.setCursor(new Cursor(12));
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel11MouseExited(MouseEvent evt)
  {
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void jmenu_serieActionPerformed(ActionEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Series se = new Series(userName);
    se.setVisible(true);
  }
  
  private void jLabel12MouseEntered(MouseEvent evt)
  {
    this.jLabel11.setCursor(new Cursor(12));
    this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel9MouseEntered(MouseEvent evt)
  {
    this.jLabel9.setCursor(new Cursor(12));
    this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel12MouseClicked(MouseEvent evt)
  {
    String us = this.lbl_login_username.getText();
    String userName = us.substring(us.lastIndexOf(" ") + 1, us.length());
    Nidas ni = new Nidas(userName);
    ni.setVisible(true);
  }
  
  private void jMenu4ActionPerformed(ActionEvent evt) {}
  
  private void jLabel17MouseClicked(MouseEvent evt) {}
  
  private void jLabel17MouseExited(MouseEvent evt)
  {
    this.jLabel17.setIcon(new ImageIcon(getClass().getResource("/images/sliceLabel.gif")));
  }
  
  private void jLabel17MouseEntered(MouseEvent evt)
  {
    this.jLabel17.setCursor(new Cursor(12));
    this.jLabel17.setIcon(new ImageIcon(getClass().getResource("/images/sliceHover.gif")));
  }
  
  private void jLabel22MouseClicked(MouseEvent evt) {}
  
  private void jLabel22MouseEntered(MouseEvent evt) {}
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Trick().setVisible(true);
      }
    });
  }
}
