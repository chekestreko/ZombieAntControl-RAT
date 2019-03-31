package ZAC.MainClasses;

import ZAC.Classes.ClientThread;
import ZAC.Stages.ServerControl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerConnection extends Thread{

    public List<ClientThread> ClientList = new CopyOnWriteArrayList<>();

    private int port;

    public ServerConnection(int port){

        this.port = port;
    }

    @Override
    public void run(){

        super.run();

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            addLog("Server Online!","#999966");

            while(true) {

                Socket client = serverSocket.accept();
                String ip = client.getRemoteSocketAddress().toString().replace("/", "").split(":")[0];

                new ClientThread(client, ip, this).start();
            }
        } catch (IOException e) {
            addLog("Server <9191> is online already","#FF0C00");
        }
    }

    public void checkDuplicated(String ip) throws InterruptedException {

        for (ClientThread thread : ClientList) {

            if(thread.getName().equals(ip)){

                System.out.println(ip+" + "+thread.getName());
                thread.stopThread = true;

                while(!thread.isStoped){
                    sleep(500);
                    System.out.println(thread.getName()+"stopping");
                }

                System.out.println("something was stoped!");
            }
        }
    }

    public void addLog(String text, String webColor){

        ServerControl.mController.serverControl_terminal.addLog("@Server! ", "#006600", text, webColor);
    }

    //add connection to list and target list
    public void addConnection(ClientThread connection){

        ClientList.add(connection);
        ServerControl.mController.serverControl_target.addViewClient(connection.getName());

    }

    //remove connection to list and target list
    public void removeConnection(ClientThread connection){

        ClientList.remove(connection);
        ServerControl.mController.serverControl_target.removeViewClient(connection.getName());

    }
}
