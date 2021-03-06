package server;

import java.net.ServerSocket;

import client.Player;

public class Server
{
    public static void main(String[] args) throws Exception
    {
	System.out.println("The capitalization server is running.");
	ServerSocket listener = new ServerSocket(9898);
	System.out.println(listener.getInetAddress());
	try
	{
	    while (true)
	    {
		new Casino(listener.accept(), new Player("Balint", 1000)).start();
	    }
	}
	finally
	{
	    listener.close();
	}
    }
}
