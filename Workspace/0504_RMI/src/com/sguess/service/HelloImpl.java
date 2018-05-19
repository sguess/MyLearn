package com.sguess.service;

import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;

import com.sguess.common.IHelloService;  
  
public class HelloImpl extends UnicastRemoteObject implements IHelloService {  
	
	private static final long serialVersionUID = -3915881068961772180L;

	public HelloImpl() throws RemoteException{  
        super();  
    }  
  
    public String sayHello(String name) throws RemoteException {  
        return "Hello, "+name;  
    }  
}  