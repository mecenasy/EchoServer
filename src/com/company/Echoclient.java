package com.company;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Echoclient {
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());

        try {
            String host = args[0];
            String name = args[1];
            Registry registry = LocateRegistry.getRegistry(host);

            Echo echo = (Echo) registry.lookup(name);
            System.out.println(echo.echo(args[3]));
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
