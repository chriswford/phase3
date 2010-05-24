
public class NullDay extends Day
{
	public NullDay(String dname,int dayWeek, int dayMonth)
	{
		super(dname,dayWeek, dayMonth);
		// TODO Auto-generated constructor stub
	}
	public Boolean isNull()
	{
		return true;
	}
	public String toString()
	{
		//return an "X" representing the value of a day not included in the month's day range
		return " X";
	}

        public SimpleXMLDocument toXML()
        {
            return new SimpleXMLDocument();
        }

}
