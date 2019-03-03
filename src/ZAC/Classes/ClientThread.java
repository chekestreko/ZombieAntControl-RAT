package ZAC.Classes;

import ZAC.MainClasses.ServerConnection;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{


    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private boolean stopThread;
    public  boolean isStoped;

    ServerConnection server;

    public ClientThread(Socket socket, String name, ServerConnection server){

        this.socket = socket;
        this.server = server;
        setName(name);
    }

    @Override
    public void run(){

        super.run();

        try {
            server.checkDuplicated(this.getName());
            server.ClientList.add(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Client up bro");
        stopThread = false;
        isStoped = false;

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(!stopThread){

                sleep(0);//help thread from not stopping
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            isStoped = true;
            System.out.println("stop done");
        }
    }

    public void stopConnection() {

        stopThread = true;
    }
}
