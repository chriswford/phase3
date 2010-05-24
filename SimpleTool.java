/************************************************************
* CLASS:      SimpleTool
* FILENAME:   SimpleTool.java
* ORIGINAL AUTHOR:     Thomas C. Hartrum
* MODIFICATIONS BY:	   Chris Ford
* LOGIN:      w001tch
* ASSIGNMENT: CEG 760 SP04, Example #1.
* SYSTEM & COMPILER: JDK v1.4
* DESCRIPTION: A simple implementation of the tool methods.
* CONTAINS:
*    SimpleTool() - constructor
*    SimpleTool(UI760 *u) - constructor
*    void display() - Displays the expression.
*    void doOther(String arg) - Process unspecified input.
*    void evaluate() - Evaluates the expression.
*    void exit() - Exits the tool.
*    void load() - Loads the expression.
*    void run() - Runs the tool.
* INHERITS:
*    None
* HISTORY:
*   03/30/04 - Hartrum - Initial version.
*   09/06/05 - Hartrum - Added class Loader, Vector names.
************************************************************/
import java.util.*;
import java.io.*;
public class SimpleTool implements Tool760
{
	private UI760 ui;
	private GenericCalendar cal;
	public SimpleTool()
	{
		ui = null; //lo = new Loader(ui);
	}

	public SimpleTool(UI760 u)
	{
		ui = u; //lo = new Loader(ui);
	}

	public void display()
	{
		if(cal==null)
			ui.showError("No calendar or schedule loaded");
		else
			ui.showMessage(cal.toString());
	}
	public void doOther(String arg)
	{
		ui.showError("SimpleTool DoOther("+arg+") called.");
	}
	public void evaluate()
	{
		String outfile=ui.getString("Save loaded object to file:");
		String file_type=ui.getString("Text output - T\nXML output - X\n:");
		
		try
		{
			// Create file 
			FileWriter fstream = new FileWriter(outfile);
			BufferedWriter out = new BufferedWriter(fstream);
			if(file_type.equals("X"))
			{
				out.write(cal.toXML().toString());
			}
			else if(file_type.equals("T"))
			{
				out.write(cal.toString());
			}
			else
			{
				ui.showError("Unkown output type");
			}
			//Close the output stream
			out.close();
		}
		catch (Exception e)
		{//Catch exception if any
			ui.showError("There was an error saving the file: " + e.getMessage());
		}
		ui.showMessage(outfile+" saved successfully");
	}
	public void exit()
	{
		ui.showMessage("SimpleTool Exit() called.");
		ui.shutdown();
	}//exit

	public void load()
	{
		String choice=ui.getString("Load with the following options: \n\tCalendar - C\n\tSchedule - S\n: ");
		
		if(choice.equals("C"))
		{
			//get Calendar files
			String cal_file="spring2010.txt";//ui.getString("Calendar File: ");
			String holidays_file="holidays2010.txt";//ui.getString("Holidays File: ");
			HolidayLookup hols=loadHolidays(holidays_file);
			//get the calendar, created form text file;
			cal=loadCalendar(cal_file);
			cal.addHolidays(hols);
			ui.showMessage(cal.getName()+" successfully loaded");
		}
		else
		if(choice.equals("S"))
		{
			//get Schedule files
			
		}
	}

	public void run()
	{
		ui.run();
	}
	public GenericCalendar loadCalendar(String fname)
	{
		BufferedReader infile;
		String line,name;
		int start_day,end_day,start_year,end_year,start_month,end_month;;
		try
	    {
	    	infile = new BufferedReader(new FileReader(fname));
	        line = infile.readLine();

        	StringTokenizer tokens = new StringTokenizer(line, "|");
        	name = tokens.nextToken();
        	start_month = CalendarCalc.monthNum(tokens.nextToken());
        	start_day = Integer.parseInt(tokens.nextToken());
        	start_year = Integer.parseInt(tokens.nextToken());
        	end_month = CalendarCalc.monthNum(tokens.nextToken());
        	end_day = Integer.parseInt(tokens.nextToken());
        	end_year = Integer.parseInt(tokens.nextToken());

        	line = infile.readLine();
	        infile.close();
	        //create calender
	        return new GenericCalendar(name,start_month,start_day,start_year,end_month,end_day,end_year); 
        }//try
	    catch(IOException e)
	    {
	    	ui.showMessage("File error.");
	    }		
		return null;
	}
	public HolidayLookup loadHolidays(String fname)
	{
		BufferedReader infile;
		String line,name,month,day;
		HolidayLookup hol_lookup=new HolidayLookup();
		try
	    {
	    	infile = new BufferedReader(new FileReader(fname));
	        line = infile.readLine();
	        while (line != null)
	        {
	        	StringTokenizer tokens = new StringTokenizer(line, "|");
	        	name = tokens.nextToken();
	        	month = tokens.nextToken();
	        	day = tokens.nextToken();
	        	hol_lookup.addHoliday(name,month,Integer.parseInt(day));
	        	line = infile.readLine();
	        }//while
	        infile.close();
        }//try
	    catch(IOException e)
	    {
	    	ui.showMessage("File error.");
	    }		
		
	    return hol_lookup;
	}
}//SimpleTool
//------------------------