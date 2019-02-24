package ZAC.MainClasses;

import ZAC.Classes.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection extends Thread{

    private List<ClientThread> ClientList = new ArrayList<>();

    private int port;

    public ServerConnection(int port){

        this.port = port;
    }

    @Override
    public void run(){

        super.run();

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            while(true) {
                Socket client = serverSocket.accept();
                String ip = client.getRemoteSocketAddress().toString().replace("/", "").split(":")[0];
                checkDuplicated(ip);
                ClientList.add(new ClientThread(client, ip));

                System.out.println(ip);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void checkDuplicated(String ip) throws InterruptedException {

        for (ClientThread thread : ClientList) {
            if(thread.getName().equals(ip)){

                thread.stopConnection();

                while(!thread.isStoped){
                    sleep(500);
                    System.out.println(thread.getName()+"stopping");
                }

                System.out.println("something was stoped!");
            }
        }
    }
}
