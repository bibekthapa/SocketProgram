package com.example.SocketProgram;

import com.example.SocketProgram.Handler.Client;
import com.example.SocketProgram.Handler.ClientHandler;
import com.example.SocketProgram.Handler.ClientListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        try {
            int port = 9000;
            ServerSocket server = new ServerSocket(port); // Running the server at 9000 port number
            System.out.println("System is running at" + port);
            ClientHandler handler=new ClientHandler();
           
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection from " + socket.getInetAddress().getHostAddress());
                ClientListener listener = new ClientListener(socket,handler);
                listener.run();

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
