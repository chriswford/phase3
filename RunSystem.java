
public class RunSystem
{
	public static void main(String args[])
	{
		UI760 ui = new SimpleMenu();
	//  UI760 ui = new GUIMenu();
		Tool760 tool= new SimpleTool(ui);
		ui.setTool(tool);
		tool.run();
		System.out.println("Exiting run().");
		System.exit(0);
	}//main

}
