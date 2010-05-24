import java.io.*;

public class SimpleMenu implements UI760
{
	private Tool760 tool;

	public SimpleMenu()
	{tool = null;}

	public SimpleMenu(Tool760 t)
	{tool = t;}

	public String getString(String prompt)
	{
		String result = null;
		System.out.println(prompt);
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			result = in.readLine();
		}//try
		catch(IOException e)
		{System.out.println("IO exception in getString().");}
			return result;
	}//getString

	public void run()
	{
		String choice = "";
		boolean done;

		done = false;
		while(!done)
		{
	    System.out.println();
	    System.out.println();
	    System.out.println("A - to load.");
	    System.out.println("B - to display.");
	    System.out.println("C - to evaluate.");
	    System.out.println("D - to exit.");
	    System.out.println("X - to test.");
	    System.out.print("Enter choice: ");
	    try
	    {
	    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    	choice = in.readLine();
	    }//try
	    catch(IOException e)
	    {System.out.println("IO exception in run().");}
	    if ( choice.equals("A") || choice.equals("a"))
	    	tool.load();
	    else if ( choice.equals("B") || choice.equals("b"))
	    	tool.display();
	    else if ( choice.equals("C") || choice.equals("c"))
	    	tool.evaluate();
	    else if ( choice.equals("D") || choice.equals("d"))
	    {
	    	tool.exit();
	    	done = true;
	    }
	    else
	    {
	    	tool.doOther(choice);
	    }
    }//while
  }//Run

public void setTool(Tool760 t)
  {tool = t;}

public void showError(String msg)
  {System.out.println("SimpleMenu ERROR: ");
   System.out.println(msg);}

public void showMessage(String msg)
  {System.out.println("SimpleMenu message: ");
   System.out.println(msg);}

public void shutdown()
  {System.out.println("SimpleMenu shutting down.");}

}//SimpleMenu
//---------------------------------------------------