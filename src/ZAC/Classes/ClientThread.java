package ZAC.Classes;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{


    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private boolean stopThread;
    public  boolean isStoped;

    public ClientThread(Socket socket, String name){

        this.socket = socket;
        this.setName(name);
        this.start();
    }

    @Override
    public void run(){

        super.run();
        System.out.println("Client up bro");
        stopThread = false;
        isStoped = false;

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(!stopThread){

                sleep(0);//stops thread from not stopping
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
