package com.jschotte.swingy.swingy;

import com.jschotte.swingy.controller.GameControler;
import com.jschotte.swingy.model.Game;
import com.jschotte.swingy.view.GUIView;
import com.jschotte.swingy.view.ViewInterface;
import com.jschotte.swingy.view.consoleView;

public class App 
{
    public static void main( String[] args )
    {
    	GameControler gameControler;
    	Game game = new Game();
    	ViewInterface view;
    	try
    	{
	    	if (args[0].equals("console"))
	    		view = new consoleView();
	    	else if (args[0].equals("gui"))
	    		view = new GUIView();
	    	else
	    	{
	    		System.out.println("Usage: [console/gui]");
	    		System.exit(0);
	    		return;
	    	}
	    	gameControler = new GameControler(view, game);
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
