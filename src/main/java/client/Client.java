package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{

    private BufferedReader in;

    private PrintWriter out;

    private Socket socket;

    public Client() throws IOException
    {
    }

    public void connect() throws IOException
    {
	socket = new Socket("0.0.0.0", 9898);
	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	out = new PrintWriter(socket.getOutputStream(), true);

	System.out.println("Connection created");
    }

    public void communicate() throws IOException
    {

	while (true)
	{
	    while (in.ready())
	    {
		System.out.println(in.readLine() + "\n");
	    }

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String content = br.readLine();

	    System.out.println("eddig--------kliens-------------------");
	    out.println(content);
	    String response;
	    try
	    {
		response = in.readLine();
		if (response == null || response.equals(""))
		{
		    System.exit(0);
		}
	    }
	    catch (IOException ex)
	    {
		response = "Error: " + ex;
	    }

	    System.out.println("Response: " + response + "\n\n");
	}
    }

    public static void main(String[] args) throws Exception
    {
	Client client = new Client();
	client.connect();
	client.communicate();
    }
}
