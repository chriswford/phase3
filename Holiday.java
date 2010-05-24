
public class Holiday extends Day
{
    private String holidayName;

	public Holiday(String dname,int dayWeek, int dayMonth, String hname)
	{
		super(dname,dayWeek, dayMonth);
                holidayName = hname;
	}
	public Boolean isHoliday()
	{
		return true;
	}
	public String toString()
	{
		//returns day of month and an "H"
		return getDayOfMonth()+"H";
	}

        public String getHolidayName()
        {
            return holidayName;
        }

        public SimpleXMLDocument toXML()
        {
            SimpleXMLDocument returnDoc = new SimpleXMLDocument();

            returnDoc.PushElement("holiday", "name", this.getHolidayName());

            returnDoc.AddAttribute("day_of_week", this.getNameShort());
            returnDoc.AddAttribute("day_of_month", "" + this.getDayOfMonth());

            returnDoc.PopElement();



            return returnDoc;
        }
}
