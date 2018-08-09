package DataAcessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartaoDAO
{
  private ResultSet rs;
  private Connection connect;
  private CallableStatement cs = null;
  private CallableStatement fps = null;
  
  public CartaoDAO()
    throws SQLException, ClassNotFoundException
  {
    conexao conexao = new conexao("172.16.236.244", "3306", "demografia", "cartao", "demografia");
    this.connect = conexao.getConnection();
  }
  
  public ResultSet getChildByRegion(String region)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call sp_getChildByRegion(?)}");
    this.cs.setString(1, region);
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
  
  public ResultSet getChildByPermID(String perm_id)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call sp_getChildByPermID(?)}");
    this.cs.setString(1, perm_id);
    this.fps = this.connect.prepareCall("{call sp_print_cards_familyID(?)}");
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
  
  public ResultSet getChildByFamilyID(String family_id)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call sp_getChildByFamilyID(?)}");
    this.cs.setString(1, family_id);
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
  
  public ResultSet CheckPrintedCards()
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call  sp_get_printed_cards()}");
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
  
  public ResultSet FinalisePrinting(String userName)
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call  sp_send_printed_cards_tologs(?)}");
    this.cs.setString(1, userName);
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
  
  public ResultSet DeletePrinteCards()
    throws SQLException
  {
    this.cs = this.connect.prepareCall("{call  sp_delete_printed_cards()}");
    this.rs = this.cs.executeQuery();
    return this.rs;
  }
}
