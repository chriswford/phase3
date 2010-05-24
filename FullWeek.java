
public class FullWeek extends Week
{

	public FullWeek()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		//prints out each day separated by spaces and adds new line
		String returnString="";
		for(int c=0;c<days.size();c++)
		{
			if(days.get(c).getDayOfMonth()<10 && !days.get(c).isHoliday() && !days.get(c).isNull() || (days.get(c).isHoliday() && days.get(c).getDayOfMonth()<10))
				returnString+=" "+days.get(c).toString();
			else
				returnString+=days.get(c).toString();
			if(!days.get(c).isHoliday())
				returnString+="  ";
			else
				returnString+=" ";
		}
		return returnString;
	}

        public SimpleXMLDocument toXML()
        {
            SimpleXMLDocument returnDoc = new SimpleXMLDocument();
            for(int c=0;c<days.size();c++)
            {
            	returnDoc.AddXMLBody((days.get(c)).toXML());
            }

            ;
            return returnDoc;
        }

}
