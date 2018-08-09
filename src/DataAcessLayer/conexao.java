package DataAcessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao
{
  private static String host;
  private static String port;
  private static String bd;
  private static String user;
  private static String password;
  
  public static String getBd()
  {
    return bd;
  }
  
  public static void setBd(String bd)
  {
    bd = bd;
  }
  
  public static String getHost()
  {
    return host;
  }
  
  public static void setHost(String host)
  {
    host = host;
  }
  
  public static String getPassword()
  {
    return password;
  }
  
  public static void setPassword(String password)
  {
    password = password;
  }
  
  public static String getPort()
  {
    return port;
  }
  
  public static void setPort(String port)
  {
    port = port;
  }
  
  public static String getUser()
  {
    return user;
  }
  
  public static void setUser(String user)
  {
    user = user;
  }
  
  public conexao(String host, String port, String bd, String user, String password)
  {
    host = host;
    port = port;
    bd = bd;
    user = user;
    password = password;
  }
  
  public static Connection getConnection()
    throws SQLException, ClassNotFoundException
  {
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + bd, user, password);
  }
}
