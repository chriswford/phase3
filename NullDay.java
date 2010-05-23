
public class NullDay extends Day
{
	public NullDay(String dname,int dayWeek, int dayMonth)
	{
		super(dname,dayWeek, dayMonth);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		//return an "X" representing the value of a day not included in the month's day range
		return " X";
	}

}
