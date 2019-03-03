package ZAC.MainClasses;

import ZAC.Classes.ClientThread;
import ZAC.Stages.ServerControl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection extends Thread{

    public List<ClientThread> ClientList = new ArrayList<>();

    private int port;
    private ServerControl controller;

    public ServerConnection(int port, ServerControl controller){

        this.port = port;
        this.controller = controller;
    }

    @Override
    public void run(){

        super.run();

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            addLog("Server Online!");

            while(true) {

                Socket client = serverSocket.accept();
                String ip = client.getRemoteSocketAddress().toString().replace("/", "").split(":")[0];

                new ClientThread(client, ip, this).start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void checkDuplicated(String ip) throws InterruptedException {

        for (ClientThread thread : ClientList) {
            if(thread.getName().equals(ip)){

                System.out.println(ip+" + "+thread.getName());
                thread.stopConnection();

                while(!thread.isStoped){
                    sleep(500);
                    System.out.println(thread.getName()+"stopping");
                }

                System.out.println("something was stoped!");
            }
        }
    }

    public void addLog(String text){

        ServerControl.mController.serverControl_terminal.addLog("@Server/", "#006600", text, "#999966");
    }
}
