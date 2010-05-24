
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
	//iterate back through the weeks of each month, and using the holidayLookup object
	//	that was built form the holidays file, change the day to a holiday if it is found in the lookup
	public void addHolidays(HolidayLookup hols)
	{
		for(int c=0;c<weeksContainer.size();c++)
		{
			Month curmonth=(Month) weeksContainer.get(c);
			for(int i=0;i<curmonth.weeks.size();i++)
			{
				for(int d=0;d<curmonth.weeks.get(i).numDays();d++)
				{
					Day curday=curmonth.weeks.get(i).days.get(d);
					HolidayResult hol_result=hols.findHoliday(curmonth.monthNum(),curday.getDayOfMonth());
					if(hol_result!=null && !curday.isNull())
					{
		
						//public Holiday(String dname,int dayWeek, int dayMonth, String hname)
						int day_of_week=curday.getDayOfWeek();
						int day_of_month=curday.getDayOfMonth();
						String dname=curday.getName();
						curmonth.weeks.get(i).days.set(d, new Holiday(dname,day_of_week,day_of_month,hol_result.getName()));
					}
				}
			}
		}
	}
/*	
	public static void main(String args[])
	{
		Calendar gencal=new GenericCalendar("Year Calendar",1,6,2010,12,11,2010);
		
		System.out.println(((GenericCalendar)gencal).toXML());

                System.out.println("\n\n\n");

                System.out.println(gencal);
	}
*/
        public SimpleXMLDocument toXML()
        {
            SimpleXMLDocument returnDoc = new SimpleXMLDocument();

            returnDoc.PushElement("calendar", "name", this.getName());

            returnDoc.PushElement("year", "number" , "2005");

		for(int i=0;i<weeksContainer.size();i++)
		{
			returnDoc.AddXMLBody(((Month)weeksContainer.get(i)).toXML());
		}

            returnDoc.PopElement();

            returnDoc.PopElement();

            return returnDoc;
        }

}
