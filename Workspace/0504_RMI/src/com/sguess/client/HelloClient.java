package com.sguess.client;

import java.net.MalformedURLException;  
import java.rmi.Naming;  
import java.rmi.NotBoundException;  
import java.rmi.RemoteException;

import com.sguess.common.IHelloService;  
  
public class HelloClient {  
    public static void main(String[] args) {  
        try {  
            IHelloService api = (IHelloService)Naming.lookup("rmi://127.0.0.1:1099/HelloAPI");  
            System.out.println(api.sayHello("Tom"));  
        } catch (MalformedURLException e) {  
            e.printStackTrace();
        } catch (RemoteException e) {  
            e.printStackTrace();  
        } catch (NotBoundException e) {  
        	e.printStackTrace();  
        }  
    }  
}  