package server;

import controller.Controller;
import form.FrmMain;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbProperties;
import thread.ProcessClientsRequests;
import thread.ThreadUpdateTable;

public class StartServerThread extends Thread {

    private ServerSocket serverSocket;
    public static int portNumber = 9000;
    public static List<ProcessClientsRequests> clients = new ArrayList<>();
    private static boolean working = false;
    FrmMain frm;

    public StartServerThread(FrmMain frm) {
        try {

            this.frm = frm;
        } catch (Exception ex) {
            System.out.println("There has been an error. Server socket has not been created.");
            working = false;
        }
    }

    @Override
    public void run() {
        try {
            DbProperties properties = new DbProperties();
            portNumber = Integer.parseInt(properties.returnDbPort());
            serverSocket = new ServerSocket(portNumber);
            working = true;
            while (!isInterrupted()) {

                System.out.println("Server has been started");
                Socket socket = serverSocket.accept();

                ProcessClientsRequests okz = new ProcessClientsRequests(socket);
                okz.start();
                clients.add(okz);
                ThreadUpdateTable tut = new ThreadUpdateTable(frm);
                tut.start();

                System.out.println("Client connected to the server!");
            }
        } catch (SocketException ex) {
            interrupt();
            System.out.println("Connection with the server has been broken.");
            working = false;
        } catch (IOException e) {
            interrupt();
            System.out.println("Error while trying to establish connection with the client.");
            working = false;
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static boolean isWorking() {
        return working;
    }

    public static void setWorking(boolean working) {
        StartServerThread.working = working;
    }

    public void stopAllThreads() {
        try {
            int i = 1;
            working = false;
            serverSocket.close();
            for (ProcessClientsRequests clientThread : clients) {
                System.out.println("Logg outin client no: " + i);
                i++;
                Controller.getInstance().getActiveUsers().remove(clientThread.getUser());
                clients.remove(clientThread);
                clientThread.getSocket().close();
            }
        } catch (Exception ex) {
            System.out.println("Server has been stopped");
            working = false;
        }
    }

}
