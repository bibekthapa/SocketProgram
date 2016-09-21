package com.example.SocketProgram.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

public class ClientListener extends Thread {

    private Socket socket;
    private List<Client> clients;
    private PrintStream ps;
    private BufferedReader reader;

    public ClientListener(Socket socket, List<Client> clients) throws IOException {
        this.socket = socket;
        this.clients = clients;
        ps = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

       
            //PrintStream is required write
            ps.print("Hello world");
            ps.print("\n");
            doLogin();


        
    }

    void doLogin() {
        
        try{
            System.out.println("Enter your name \n");
            String name = reader.readLine();
            ps.println("Hello " + name);
            System.out.println("Hello " + name);
        }catch(IOException ioe)
        {
            ioe.getMessage();
            }
    }
}
