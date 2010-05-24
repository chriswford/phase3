/************************************************************
* CLASS: Loader
* FILENAME: Loader.java
* DESCRIPTION: Loads FullNames from a file.
* CONTAINS:
*  Vector load() - loads from file.
*  static void main() - for testing Loader.
* HISTORY:
*   09/07/05 - Hartrum - Initial version.
************************************************************/

/*
import java.util.*;
import java.io.*;

public class Loader
  {
  private UI760 ui = null;
  //==================================
  // Constructor
  //==================================
  public Loader(UI760 u)
    { ui = u; }//Constructor

  //==================================
  // METHOD: load()
  //==================================
  public Vector load()
    {
    Vector names = new Vector();
    String fname;
    String first, middle, last;
    BufferedReader infile;
    String line; 
    FullName fn;

    fname = ui.getString("Enter filename:");
    try {
        infile = new BufferedReader(new FileReader(fname));
        line = infile.readLine();
        while (line != null)
          {
          StringTokenizer tokens = new StringTokenizer(line, "|");
          first = tokens.nextToken();
          middle = tokens.nextToken();
          last = tokens.nextToken();
          fn = new FullName();
          fn.setFirst(first);
          fn.setMiddle(middle);
          fn.setLast(last);
          names.add(fn);
          line = infile.readLine();
          }//while
        infile.close();
        }//try
    catch(IOException e)
      {ui.showMessage("File error.");}
    return(names);
    }//load

    public static void main(String [] args)
      {
      System.out.println("Hello World");
      UI760 myui = new SimpleMenu();
      Loader lo = new Loader(myui);
      Vector v = lo.load();
      for (int i = 0; i < v.size(); i++)
        {
        FullName n = (FullName) v.get(i);
        myui.showMessage(n.getFirst()+" "+n.getMiddle()+" "+n.getLast());
        }//while
      }//main

  }//Loader
//----------------------------------

*/
