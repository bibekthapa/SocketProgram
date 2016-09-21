package com.example.SocketProgram.Handler;

import java.net.Socket;

public class Client {
    
    private String Username;
    private Socket socket;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
}
