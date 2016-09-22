package com.example.SocketProgram.Handler;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    List<Client> clients = new ArrayList();

    public void addClient(Client c) {
        clients.add(c);
    }

    public boolean removeClient(Client client) {
        for (Client c : clients) {
            if (c.equals(clients)) {
                clients.remove(c); //removed from the list Clients
                return true;
            }

        }
        return false;
    }

    public List<Client> getAll() {
        return clients; //returned the clients List
    }

    public Client getByName(String username) {
        for (Client c : clients) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c; //return the Client
            }

        }
        return null;
    }

    public Client getBySocket(Socket s) {
        for (Client c : clients) {
            if (c.getSocket().equals(s)) {
                return c;
            }

        }
        return null;

    }
}
