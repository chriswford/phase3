/************************************************************
* CLASS:      Tool760
* FILENAME:   Tool760.java
* AUTHOR:     Thomas C. Hartrum
* LOGIN:      w001tch
* ASSIGNMENT: CEG 760 SP04, Example #1.
* SYSTEM & COMPILER: JDK v1.4
* DESCRIPTION: This interface defines the tool methods.
* CONTAINS:
*    void display();
*    void doOther(String arg);
*    void evaluate();
*    void exit();
*    void load();
*    void run();
* INHERITS:
*    None
* HISTORY:
*   03/30/04 - Initial version.
************************************************************/
public interface Tool760
{
  void display();
       //Displays the expression.
  void doOther(String arg);
       //Process unspecified input.
  void evaluate();
       //Evaluates the expression.
  void exit();
       //Exits the tool.
  void load();
       //Loads the expression.
  void run();
       //Runs the tool.
};//Tool760
//------------------------