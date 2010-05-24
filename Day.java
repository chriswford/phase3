
public abstract class Day
{
	private int day_of_week;
	private int day_of_month;
	private String name;
	public Day(String dname,int day_week,int day_month)
	{
		day_of_week=day_week;
		day_of_month=day_month;
		name=dname;
	}
	
	public String getName()
	{
		return name;
	}

        public String getNameShort()
        {
            return CalendarCalc.getDayNameShort(day_of_week);
        }

	public int getDayOfMonth()
	{
		return day_of_month;
	}
	public int getDayOfWeek()
	{
		return day_of_week;
	}
	public Boolean isHoliday()	//specialized subclasses overwrite
	{
		return false;
	}
	public Boolean isNull()		//specialized subclasses overwrite
	{
		return false;
	}
	public abstract String toString();	//subclasses must implement

        public abstract SimpleXMLDocument toXML();
}
