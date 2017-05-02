package com.bdqn.thread;

public class TestSaleTicketsThread {
	public static void main(String[] args) {
		/*SaleTicketsThread t=new SaleTicketsThread();
		t.setName("河西售票点");
		t.start();
		
		SaleTicketsThread t2=new SaleTicketsThread();
		t2.setName("河东售票点");
		t2.start();*/
		
		SaleTicketsThread t=new SaleTicketsThread();
		Thread t1=new Thread(t);
		t1.setName("1河西售票点");
		t1.start();
		
		Thread t2=new Thread(t);
		t2.setName("2河东售票点");
		t2.start();
		
		Thread t3=new Thread(t);
		t3.setName("3河中售票点");
		t3.start();
	}
}

//class SaleTicketsThread extends Thread{
class SaleTicketsThread implements Runnable{
	
	private int tickets=100;
	
	private Object o=new Object();//任意对象都可当作线程锁
	
	
	public synchronized void sale(){
		if(tickets>0)
		{
			System.out.println(Thread.currentThread().getName()+"正在销售:"+tickets--);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run(){
		
		while(true){
//			synchronized(o)
//			{
				sale();//调用同步方法
				
				if(tickets<=0){
					break;
				}
//			}
		}
		
	}
}
