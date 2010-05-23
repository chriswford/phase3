/************************************************************
* CLASS:      UI760
* FILENAME:   UI760.java
* AUTHOR:     Thomas C. Hartrum
* LOGIN:      w001tch
* ASSIGNMENT: CEG 760 SP04, Example #1.
* SYSTEM & COMPILER: JDK v1.4
* DESCRIPTION: This defines the tool user interface.
* CONTAINS:
*   String getString(String prompt);
*   void run();
*   void setTool(Tool760 t);
*   void showError(String msg);
*   void showMessage(String msg);
*   void shutdown();
* INHERITS:
*    None
* HISTORY:
*   03/30/04 - Initial version.
************************************************************/
public interface UI760
  {
  String getString(String prompt);
       //Displays prompt, returns user input.
  void run();
       //Gets user input, calls tool methods appropriately.
  void setTool(Tool760 t);
       //Tool providing methods to be called.
  void showError(String msg);
       //Display the input error message to the user.
  void showMessage(String msg);
       //Display the input String to the user.
  void shutdown();
       //Shut down the user interface as needed.
  }//UI760
//-----------------------------------------
