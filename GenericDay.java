
public class GenericDay extends Day
{

	public GenericDay(String dname,int dayWeek, int dayMonth)
	{
		super(dname,dayWeek, dayMonth);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		//returns the string form of the integer value of the day of month
		String returnString=Integer.toString(getDayOfMonth());
		if(getDayOfMonth()<10)
			returnString=" "+returnString;
		return returnString;
	}

}
