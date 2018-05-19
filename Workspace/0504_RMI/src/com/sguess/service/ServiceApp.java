package com.sguess.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.sguess.common.IHelloService;

public class ServiceApp {
	public static void main(String[] args) {
		try {
			IHelloService h = new HelloImpl();
			LocateRegistry.createRegistry(1099);
			System.out.println("HelloServer ready");
			Naming.bind("rmi://127.0.0.1:1099/HelloAPI", h);
			System.out.println("HelloServer Running");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
