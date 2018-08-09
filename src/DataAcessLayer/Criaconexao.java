package DataAcessLayer;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Criaconexao
{
  public static Connection getConexao()
    throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Conexao ao Banco");
      return DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
    }
    catch (ClassNotFoundException e)
    {
      throw new SQLException(e.getMessage());
    }
  }
}
