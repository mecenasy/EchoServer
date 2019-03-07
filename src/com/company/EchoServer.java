package com.company;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer extends UnicastRemoteObject implements Echo {
    protected EchoServer() throws RemoteException {
    }

    @Override
    public String echo(String msg) throws RemoteException {
        System.out.println("EchoServer - wiedomość to:" + msg);
        return msg;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());

        String name = args[0];

        try {
            EchoServer server = new EchoServer();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, server);System.out.println("EchoServer server zarejestrowany");
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
