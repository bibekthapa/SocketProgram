package com.example.SocketProgram.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

public class ClientListener extends Thread {

    private Socket socket;
   
    private PrintStream ps;
    private BufferedReader reader;
    private final ClientHandler handler;
    private Client client;

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        ps = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            //PrintStream is required write
            ps.print("Hello world");
            ps.print("\n");
            doLogin();  // HERE is DOLOGIN
            String line = "";
            while (!(line=reader.readLine()).equalsIgnoreCase("exit")) {
                
           
            ps.println(client.getUsername()+"says >"+line);
                System.out.println(client.getUsername()+"says >"+line);

            }
            
            handler.removeClient(client);
            //Remove the client after getting out from the while loop

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    void doLogin() {

        try {
            System.out.println("Enter your name \n");
            String name = reader.readLine();
            client=new Client(name, socket);
            ps.println("Hello " + name);
            System.out.println("Hello " + name);
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }
}
