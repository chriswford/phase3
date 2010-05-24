import java.util.ArrayList;
public abstract class Calendar
{
	private int cur_year;
	private String name;
	private int start_day;
	private int start_month;
	private int end_month;
	private int end_day;
	private int start_year;
	private int end_year;
	protected ArrayList<WeekContainer> weeksContainer=new ArrayList();
	
	public Calendar(String cname,int smonth,int sday,int syear,int emonth,int eday,int eyear)
	{
		name=cname;
		start_month=smonth;
		start_day=sday;
		start_year=syear;
		end_month=emonth;
		end_day=eday;
		end_year=eyear;
		
	}

        public String getName()
        {
            return name;
        }

	public String toString()
	{
		String returnString="";
		for(int i=0;i<weeksContainer.size();i++)
		{
			returnString+=weeksContainer.get(i).toString();
		}
		return returnString;
	}

}

