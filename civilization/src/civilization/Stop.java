package civilization;

public class Stop extends Thread{
	
	  volatile boolean finished = false;

	  public void stopMe()
	  {
	    finished = true;
	  }

	  public void run()
	  {
	    while (!finished)
	    {
	      //do dirty work
	    }
	  }
	}

