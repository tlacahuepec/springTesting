package com.apress.prospring3.ch2;

public class HelloWorldDecoupledWithFactory {
	public static void main(String[] args) {
		MessageSupportFactory msf = MessageSupportFactory.getInstance();
		MessageRenderer mr = msf.getRenderer();
		MessageProvider mp = msf.getProvider();

		mr.setMessageProvider(mp);
		mr.render();
	}
}
