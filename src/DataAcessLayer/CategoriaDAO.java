package DataAcessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO
{
  private ResultSet rs;
  private Connection connect;
  private CallableStatement cs = null;
  
  public CategoriaDAO()
  {
    try
    {
      conexao conexao = new conexao("localhost", "3306", "mydb", "root", "");
      this.connect = conexao.getConnection();
    }
    catch (SQLException localSQLException) {}catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public void cadastrarcategoria(String Nome)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call proc_categoria(?)}");
    this.cs.setString(1, Nome);
    this.cs.executeQuery();
  }
  
  public void atualizacategoria(int idCategoria, String Nome)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call AtualizaCategoria(?,?)}");
    this.cs.setInt(1, idCategoria);
    this.cs.setString(2, Nome);
    this.cs.executeQuery();
  }
  
  public void ApagarCategoria(int idCategoria)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call apagarCategoria(?)}");
    this.cs.setInt(1, idCategoria);
    this.cs.executeQuery();
  }
  
  public ResultSet ListaCategoria()
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call  ListarCategoria()}");
    this.rs = this.cs.executeQuery();
    
    return this.rs;
  }
}
