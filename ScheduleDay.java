
public class ScheduleDay extends Day
{
	private int month_num;	//number of month for printing purposes (1-12)
	private String content;	//day's content data
	
	public ScheduleDay(String dname,int dayWeek, int dayMonth,int mnum)
	{
		super(dname,dayWeek, dayMonth);
		month_num=mnum;
	}

	public String toString()
	{
		//returns ex. M(5/31) followed by content
		return null;
	}

        public SimpleXMLDocument toXML()
        {
            return null;
        }

	
}
