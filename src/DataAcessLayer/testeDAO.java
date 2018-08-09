package DataAcessLayer;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testeDAO
{
  private ResultSet rs;
  public Connection connect;
  private CallableStatement cs = null;
  private PreparedStatement st = null;
  
  public testeDAO()
  {
    try
    {
      conexao conexao = new conexao("localhost", "3306", "demografia", "agnaldo", "holahola");
      this.connect = conexao.getConnection();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
  
  public ResultSet get_printed_cards(String perm_id)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call getChildByPermID(?)}");
    this.cs.setString(1, perm_id);
    this.rs = this.cs.executeQuery();
    
    return this.rs;
  }
  
  public static void main(String[] args)
  {
    testeDAO t = new testeDAO();
    try
    {
      ResultSet rs = t.get_printed_cards("3501-004-04");
      while (rs.next())
      {
        System.out.println(rs.getInt("cartaoid"));
        System.out.println(rs.getString("perm_id"));
        System.out.println(rs.getString("name"));
        System.out.println(rs.getString("sex"));
        System.out.println("-----------------------------------------------------");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
