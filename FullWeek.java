
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
			returnString+=days.get(c).toString()+" ";
		}
		return returnString;
	}
}
