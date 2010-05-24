
public class GenericDay extends Day
{

	public GenericDay(String dname,int dayWeek, int dayMonth)
	{
		super(dname,dayWeek, dayMonth);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		//returns the string form of the integer value of the day of month
		String returnString=Integer.toString(getDayOfMonth());
		return returnString;
	}

        public SimpleXMLDocument toXML()
        {
            SimpleXMLDocument returnDoc = new SimpleXMLDocument();

            returnDoc.PushElement("day");

            returnDoc.AddAttribute("day_of_week", this.getNameShort());
            returnDoc.AddAttribute("day_of_month", "" + this.getDayOfMonth());

            returnDoc.PopElement();

            

            return returnDoc;
        }

}
