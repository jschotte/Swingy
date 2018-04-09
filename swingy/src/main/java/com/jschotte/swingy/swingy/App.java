package com.jschotte.swingy.swingy;

import com.jschotte.swingy.controller.ConsoleControler;
import com.jschotte.swingy.controller.Controler;
import com.jschotte.swingy.controller.GameControler;
import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.view.GUIView;
import com.jschotte.swingy.view.consoleView;

public class App 
{
    public static void main( String[] args )
    {
    	Controler gameControler;
    	Game game = new Game();
    	try
    	{
	    	if (args[0].equals("console"))
	    		gameControler = new ConsoleControler(new consoleView(), game);
	    	else if (args[0].equals("gui"))
	    		gameControler = new GameControler(new GUIView(), game);
	    	else
	    	{
	    		System.out.println("Usage: [console/gui]");
	    		System.exit(0);
	    		return;
	    	}
	    	
	    	//gameControler.homeSelection();
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
