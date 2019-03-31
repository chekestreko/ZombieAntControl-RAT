package ZAC.Classes;

import ZAC.MainClasses.ServerConnection;

import java.io.*;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ClientThread extends Thread{


    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    public boolean stopThread;
    public  boolean isStoped;
    public boolean isOnline;

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
            server.addConnection(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.addLog("<"+getName()+"> Connected", "#53aced");


        stopThread = false;
        isStoped = false;

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            StartTimerConnection();

            while(!stopThread){

                isOnline = false;

                sleep(0);//help thread from not stopping
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            server.removeConnection(this);
            isStoped = true;
            server.addLog("<"+getName()+"> Disconnected", "#E70E00");
            System.out.println("stop done");
        }
    }

    public void StartTimerConnection(){

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if(isOnline){

                    out.println("check");
                    out.flush();
                }else{

                    stopThread = true;
                }
            }
        }, 5000, 5000);
    }
}
