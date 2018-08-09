package Presentation;

import java.awt.Toolkit;
import java.util.Random;
import javax.swing.SwingWorker;

public class Task
  extends SwingWorker<Void, Void>
{
  public Void doInBackground()
  {
    Random random = new Random();
    int progress = 0;
    setProgress(0);
    try
    {
      Thread.sleep(200L);
      while ((progress < 100) && (!isCancelled()))
      {
        Thread.sleep(random.nextInt(120));
        
        progress += random.nextInt(10);
        setProgress(Math.min(progress, 100));
      }
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public void done()
  {
    Toolkit.getDefaultToolkit().beep();
  }
}
