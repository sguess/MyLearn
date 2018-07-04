package com.sguess.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloService extends Remote {
    public String sayHello(String name) throws RemoteException;
}
