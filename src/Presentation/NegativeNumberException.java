package Presentation;

public class NegativeNumberException
  extends Exception
{
  public String getMessage()
  {
    return super.getMessage();
  }
  
  public NegativeNumberException(String message)
  {
    super(message);
  }
}
