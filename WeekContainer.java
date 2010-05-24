import java.util.ArrayList;

public abstract class WeekContainer
{
	private String name;
	protected ArrayList<Week> weeks=new ArrayList();

	public WeekContainer(String wname)
	{
		name=wname;
	}
	public String getName()
	{
		return name;
	}
	public abstract String toString();	//subclasses must implement

}
