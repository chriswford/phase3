import java.util.ArrayList;

public abstract class Week
{
	protected ArrayList<Day> days=new ArrayList();
    private int weekNumber;
	
	public Week()
	{
		//***** Refactoring out=>iterates through colleciton of days and adds refrence of each obj
		//to its days[] collection
	}
	public void addDay(Day day)
	{
		days.add(day);
	}
	public int numDays()
	{
		return days.size();
	}
        public int getNumber()
        {
            return weekNumber;
        }

	public abstract String toString();	//subclasses must implement

}
