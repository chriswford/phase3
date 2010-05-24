/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike
 */

import java.util.Stack;
import java.util.StringTokenizer;

public class SimpleXMLDocument {

    private String document;
    private String header;
    private Stack elementStack;

    public SimpleXMLDocument()
    {

        header = "<?xml version=\"1.0\"?>";
        document = new String();
        elementStack  = new Stack();
    }

    //Adds element to the XML element stack, adds element header to document
    public void PushElement(String type, String identifierType, String identifier)
    {
        document += "\n";

        for(int i = 0; i < elementStack.size(); i++)
        {
            document += "\t";
        }

        document += "<" + type + " " + identifierType +  "=\"" + identifier + "\">";

        elementStack.push(type);
    }

    //Adds element without identifier to XML element stack
    public void PushElement(String type)
    {
        document += "\n";

        for(int i = 0; i < elementStack.size(); i++)
        {
            document += "\t";
        }

        document += "<"+ type + ">";

        elementStack.push(type);
    }

    //Adds an attribute to the current XML element; does not add to stack
    public void AddAttribute(String type, String value)
    {
        document += "\n";

        for(int i = 0; i < (elementStack.size() + 1); i++)
        {
            document += "\t";
        }

        document += "<" + type + ">" + value + "</" + type + ">";
    }

    //Ends the top element on the XML stack
    public void PopElement()
    {
        document += "\n";

        for(int i = 0; i < (elementStack.size() - 1); i++)
        {
            document += "\t";
        }

        document += "</" +(String)elementStack.pop() + ">";
    }

    //Adds the body of a given XML document to the current element
    public void AddXMLBody(SimpleXMLDocument xmlDoc)
    {
        String tempBody = xmlDoc.BodyToString();

        //Tokenizes string of given doc by line
        StringTokenizer tokens = new StringTokenizer(tempBody, "\n");


        int totalTokens = tokens.countTokens();


        //For each line, add spacing based on spacing of current element
        for(int j = 0; j < totalTokens; j++)
        {
                  document += "\n";

                  for(int i = 0; i < (elementStack.size()); i++)
                  {
                     document += "\t";
                  }

                  String tString = tokens.nextToken();

                  document += tString;

        }


    }

    //Returns the entire XML document as a string
    public String toString()
    {
        int index = elementStack.size();
        for (int i = 0; i < index; i++) this.PopElement();
        return header + document;
    }

    //Returns just the body as a string
    public String BodyToString()
    {
        int index = elementStack.size();
        for (int i = 0; i < index; i++) this.PopElement();
        return document;
    }

}
