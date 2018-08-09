package Presentation;

import Service.ReadWriteTextFileJDK7;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class LoginPage
  extends JFrame
{
  ResultSet rs;
  ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();
  static final String USER_FILE_NAME = "C:\\serial_geral\\serialno\\users.txt";
  private JButton btnCancel;
  private JButton btnLogin;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JLabel lbl_loginpage_erro;
  private JLabel lbl_password1;
  private JLabel lbl_username1;
  private JPasswordField tf_login_password;
  private JTextField tf_login_userName;
  
  public LoginPage()
  {
    initComponents();
  }
  
  private void initComponents()
  {
    this.jPanel2 = new JPanel();
    this.jPanel3 = new JPanel();
    this.lbl_username1 = new JLabel();
    this.tf_login_userName = new JTextField();
    this.tf_login_password = new JPasswordField();
    this.lbl_password1 = new JLabel();
    this.btnLogin = new JButton();
    this.btnCancel = new JButton();
    this.lbl_loginpage_erro = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel1 = new JLabel();
    
    setDefaultCloseOperation(3);
    setTitle("Entrar no sistema");
    setResizable(false);
    
    this.jPanel2.setLayout(new AbsoluteLayout());
    
    this.jPanel3.setOpaque(false);
    this.jPanel3.setLayout(new AbsoluteLayout());
    
    this.lbl_username1.setFont(new Font("Segoe UI", 1, 14));
    this.lbl_username1.setText("Nome do Usuario :");
    this.jPanel3.add(this.lbl_username1, new AbsoluteConstraints(12, 46, -1, -1));
    
    this.tf_login_userName.setFont(new Font("Segoe UI", 0, 14));
    this.tf_login_userName.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        LoginPage.this.tf_login_userNameActionPerformed(evt);
      }
    });
    this.tf_login_userName.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent evt)
      {
        LoginPage.this.tf_login_userNameKeyTyped(evt);
      }
    });
    this.jPanel3.add(this.tf_login_userName, new AbsoluteConstraints(151, 51, 181, -1));
    
    this.tf_login_password.setFont(new Font("Segoe UI", 0, 14));
    this.tf_login_password.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent evt)
      {
        LoginPage.this.tf_login_passwordKeyTyped(evt);
      }
    });
    this.jPanel3.add(this.tf_login_password, new AbsoluteConstraints(151, 95, 181, 27));
    
    this.lbl_password1.setFont(new Font("Segoe UI", 1, 14));
    this.lbl_password1.setText("Senha :");
    this.jPanel3.add(this.lbl_password1, new AbsoluteConstraints(12, 96, -1, -1));
    
    this.btnLogin.setText("Login");
    this.btnLogin.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent evt)
      {
        LoginPage.this.btnLoginMouseEntered(evt);
      }
    });
    this.btnLogin.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        LoginPage.this.btnLoginActionPerformed(evt);
      }
    });
    this.jPanel3.add(this.btnLogin, new AbsoluteConstraints(151, 133, 67, -1));
    
    this.btnCancel.setText("Cancel");
    this.btnCancel.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent evt)
      {
        LoginPage.this.btnCancelMouseEntered(evt);
      }
    });
    this.btnCancel.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        LoginPage.this.btnCancelActionPerformed(evt);
      }
    });
    this.jPanel3.add(this.btnCancel, new AbsoluteConstraints(228, 133, -1, -1));
    
    this.lbl_loginpage_erro.setFont(new Font("Tahoma", 1, 12));
    this.lbl_loginpage_erro.setForeground(new Color(249, 50, 24));
    this.lbl_loginpage_erro.setText(" ");
    this.jPanel3.add(this.lbl_loginpage_erro, new AbsoluteConstraints(10, 10, 303, 27));
    
    this.jPanel2.add(this.jPanel3, new AbsoluteConstraints(180, 70, 348, 183));
    
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/lock.png")));
    this.jPanel2.add(this.jLabel2, new AbsoluteConstraints(20, 100, -1, -1));
    
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/bg_Login.jpg")));
    this.jPanel2.add(this.jLabel1, new AbsoluteConstraints(0, 0, 580, 300));
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jPanel2, -1, -1, 32767));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jPanel2, -1, -1, 32767));
    
    setBounds(250, 200, 573, 309);
  }
  
  private void tf_login_userNameActionPerformed(ActionEvent evt) {}
  
  private void btnLoginActionPerformed(ActionEvent evt)
  {
    String username = this.tf_login_userName.getText();
    
    String password = this.tf_login_password.getText();
    
    this.lbl_loginpage_erro.setText("");
    try
    {
      List<String> lines = this.text.readSmallTextFile("C:\\serial_geral\\serialno\\users.txt");
      for (int i = 0; i < lines.size(); i++)
      {
        String get = (String)lines.get(i);
        String u = get.substring(0, get.indexOf(" "));
        if (u.contentEquals(username))
        {
          String pass = get.substring(get.indexOf(" ") + 1, get.lastIndexOf(" "));
          if (pass.contentEquals(password))
          {
            String cat = get.substring(get.lastIndexOf(" ") + 1, get.length());
            
            Trick tr = new Trick(u, cat);
            tr.setVisible(true);
            dispose();
          }
          else
          {
            this.lbl_loginpage_erro.setText("Incorrect Password!!!");
          }
        }
        else
        {
          this.lbl_loginpage_erro.setText("Incorrect username!!!");
        }
      }
    }
    catch (Exception ex)
    {
      System.out.println("" + ex + ex.getLocalizedMessage());
    }
  }
  
  private void btnCancelActionPerformed(ActionEvent evt)
  {
    System.exit(0);
  }
  
  private void tf_login_userNameKeyTyped(KeyEvent evt)
  {
    this.lbl_loginpage_erro.setText(null);
  }
  
  private void tf_login_passwordKeyTyped(KeyEvent evt)
  {
    this.lbl_loginpage_erro.setText(null);
  }
  
  private void btnLoginMouseEntered(MouseEvent evt)
  {
    this.btnLogin.setCursor(new Cursor(12));
  }
  
  private void btnCancelMouseEntered(MouseEvent evt)
  {
    this.btnCancel.setCursor(new Cursor(12));
  }

  public static void main(String[] args)
  {
    try
    {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
        if ("Nimbus".equals(info.getName()))
        {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (UnsupportedLookAndFeelException ex)
    {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new LoginPage().setVisible(true);
      }
    });
  }
}
