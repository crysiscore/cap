package Service;

import java.io.PrintStream;
import java.util.Scanner;

public class TesteService
{
  public static void main(String[] args)
  {
    String userpass = "celso hilario 1";
    Scanner in = new Scanner(System.in);
    System.out.println("user :");
    String user = in.nextLine();
    System.out.println("Pass :");
    String p = in.nextLine();
    
    String u = userpass.substring(0, userpass.indexOf(" "));
    if (user.contentEquals(u))
    {
      String pass = userpass.substring(userpass.indexOf(" ") + 1, userpass.lastIndexOf(" "));
      if (pass.contentEquals(p))
      {
        String cat = userpass.substring(userpass.lastIndexOf(" ") + 1, userpass.length());
        System.out.println("user :" + u);
        System.out.println("Pass :" + pass);
        System.out.println("Pass :" + cat);
      }
      else
      {
        System.out.println("Incorrect password");
      }
    }
    else
    {
      System.out.println("Incoret username ");
    }
  }
}
