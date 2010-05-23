
public class GenericCalendar extends Calendar
{
	public GenericCalendar(String cname,int smonth,int sday,int syear,int emonth,int eday,int eyear)
	{
		super(cname,smonth,sday,syear,emonth,eday,eyear);
		
		//look through each year (start_month - end_month) and create each month
		for(int curyear=syear;curyear<=eyear;curyear++)
		{
			int last_month=12;
			if(curyear==eyear)
				last_month=emonth;
			for(int curmonth=smonth;curmonth<=last_month;curmonth++)
			{
				int new_start_day=1;
				int new_end_day=CalendarCalc.calcEndDay(curyear, curmonth);
				String new_month_name=CalendarCalc.monthName(curmonth);
				if(curyear==syear && curmonth==smonth)
					new_start_day=sday;
				if(curyear==eyear && curmonth==emonth)
					new_end_day=eday;

				weeksContainer.add(new Month(new_month_name,curmonth,curyear,new_start_day,new_end_day));
			}
		}

	}
/*	
	public static void main(String args[])
	{
		Calendar gencal=new GenericCalendar("Year Calendar",1,6,2010,12,11,2010);
		
		System.out.println(gencal);
		System.out.println("\n\ndone");
	}
*/
}
