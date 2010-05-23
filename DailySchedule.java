import java.util.ArrayList;

public class DailySchedule extends WeekContainer
{
	ArrayList<String> contentData=new ArrayList();
	
	DailySchedule(String name,int myear,int sday,int eday,ArrayList content)
	{
		super(name);
		//now creates dailyWeek objects for the schedule and adds them to teh weeks container
	}
	
	public String toString()
	{
		//prints name then iterates through weeks and prints and calls each week's toString()
		return "";
	}
}
