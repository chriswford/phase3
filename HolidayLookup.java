import java.util.ArrayList;
import java.util.HashMap;


public class HolidayLookup
{
	ArrayList<HolidayResult> holidays=new ArrayList();
	public HolidayLookup()
	{

	}

	public void addHoliday(String name,String month,int day)
	{
		holidays.add(new HolidayResult(name,month,day));
	}
	public HolidayResult findHoliday(int month_num,int day_num)
	{
		for(int i=0;i<holidays.size();i++)
		{
			int cmonth=holidays.get(i).getMonth();
			int cday=holidays.get(i).getDay();
			if(cmonth==month_num && cday==day_num)
				return holidays.get(i);
		}
		return null;
	}

	public String toString()
	{
		String returnString="";
		for(int i=0;i<holidays.size();i++)
		{
			String cname=holidays.get(i).getName();
			int cmonth=holidays.get(i).getMonth();
			int cday=holidays.get(i).getDay();
			returnString+=cname+" "+cmonth+" "+cday+"\n";
		}
		return returnString;
	}
}
