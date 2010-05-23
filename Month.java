import java.util.ArrayList;

public class Month extends WeekContainer
{
	private int year;
	private int month_num;
	private int max_days;
	private int start_day;
	private int end_day;	//day month ends on (any range from 1-last_day)
	private int last_day;	//last day of month (28-31)
	private ArrayList<Day> days=new ArrayList();
	
	public Month(String mname,int mnum,int myear,int sday,int eday)
	{
		super(mname);

		month_num=mnum;
		year=myear;
		start_day=sday;
		end_day=eday;
		last_day=CalendarCalc.calcEndDay(year, month_num);
		//loop through start_day to end_day and add days into months day container
		int curweek=0;
		weeks.add(new FullWeek());
		for(int c=0;c<CalendarCalc.getDayNumOfWeek(year, month_num,1);c++)
		{
			int new_day_of_week=CalendarCalc.getDayNumOfWeek(year, month_num,c);
			String new_day_name=CalendarCalc.getDayName(new_day_of_week);
			weeks.get(0).addDay(new NullDay(new_day_name,new_day_of_week,c));
		}
		for(int curday=1;curday<=last_day;curday++)
		{
			int new_day_of_week=CalendarCalc.getDayNumOfWeek(year, month_num, curday);
			String new_day_name=CalendarCalc.getDayName(new_day_of_week);
			//if current day is less or greater than specified start/end, add NullDays
			//	for formatting purposes, otherwise add regular days
			if(curday>end_day || curday<start_day)
				days.add(new NullDay(new_day_name,new_day_of_week,curday));
			else
				days.add(new GenericDay(new_day_name,new_day_of_week,curday));
			
			if(new_day_of_week==0)	//if Monday, start a new week
			{
				curweek++;
				weeks.add(new FullWeek());
			}
			weeks.get(curweek).addDay(days.get(curday-1));	//add current new day to current week
			if(curday==last_day)
			{
				for(int c=new_day_of_week;c<6;c++)
				{
					new_day_name=CalendarCalc.getDayName(new_day_of_week+c);
					weeks.get(curweek).addDay(new NullDay(new_day_name,new_day_of_week+c,curday));
				}
			}
		}

	
	}

	public String toString()
	{
		//iterates through weeks collection and appends the output of the month name,
		//and year, followed by a the weeks toString() output.
		String returnString=getName()+" "+year+"\n S  M  T  W  T  F  S\n";
		int new_line_count=0;
		for(int c=0;c<weeks.size();c++)
		{
			returnString+=weeks.get(c).toString();

			new_line_count+=weeks.get(c).numDays();
			if(new_line_count>=7)
			{
				new_line_count=0;
				returnString+="\n";
			}
		}

		return returnString+"\n\n";
	}

}
