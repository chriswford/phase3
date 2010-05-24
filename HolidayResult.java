
public class HolidayResult
{
	private String name;
	private int month_num;
	private int day_num;
	
	public HolidayResult(String hname,String month_name,int hday)
	{
		name=hname;
		month_num=CalendarCalc.monthNum(month_name);
		day_num=hday;
	}
	public String getName()
	{
		return name;
	}
	public int getMonth()
	{
		return month_num;
	}
	public int getDay()
	{
		return day_num;
	}
	
}
