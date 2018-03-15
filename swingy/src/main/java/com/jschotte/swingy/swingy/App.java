package com.jschotte.swingy.swingy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
	    	if (args[0].equals("console"))
	    		System.out.println( "Hello World!" );
	    	else if (args[0].equals("gui"))
	    		System.out.println("GUI");
	    	else
	    	{
	    		System.out.println("Usage: [console/gui]");
	    		System.exit(0);
	    	}
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		System.out.println("Usage: java -jar swingy.jar [console/gui]");
    	}
    	catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
}
