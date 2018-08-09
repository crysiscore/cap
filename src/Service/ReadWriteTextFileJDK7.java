package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadWriteTextFileJDK7
{
  static final Charset ENCODING = StandardCharsets.UTF_8;
  
  public List<String> readSmallTextFile(String aFileName)
    throws IOException
  {
    Path path = Paths.get(aFileName, new String[0]);
    return Files.readAllLines(path, ENCODING);
  }
  
  public void writeSmallTextFile(List<String> aLines, String aFileName)
    throws IOException
  {
    Path path = Paths.get(aFileName, new String[0]);
    Files.write(path, aLines, ENCODING, new OpenOption[0]);
  }
  
  public void readLargerTextFile(String aFileName)
    throws IOException
  {
    Path path = Paths.get(aFileName, new String[0]);
    try
    {
      Scanner scanner = new Scanner(path, ENCODING.name());
      while (scanner.hasNextLine()) {
        log(scanner.nextLine());
      }
    }
    catch (Exception localException) {}
  }
  
  public void readLargerTextFileAlternate(String aFileName)
    throws IOException
  {
    Path path = Paths.get(aFileName, new String[0]);
    try
    {
      BufferedReader reader = Files.newBufferedReader(path, ENCODING);
      String line = null;
      while ((line = reader.readLine()) != null) {
        log(line);
      }
    }
    catch (Exception localException) {}
  }
  
  public void writeLargerTextFile(String aFileName, List<String> aLines)
    throws IOException
  {
    Path path = Paths.get(aFileName, new String[0]);
    BufferedWriter writer;
    try
    {
      writer = Files.newBufferedWriter(path, ENCODING, new OpenOption[0]);
      for (String line : aLines)
      {
        writer.write(line);
        writer.newLine();
      }
    }
    catch (Exception localException) {}
  }
  
  private static void log(Object aMsg)
  {
    System.out.println(String.valueOf(aMsg));
  }
}
