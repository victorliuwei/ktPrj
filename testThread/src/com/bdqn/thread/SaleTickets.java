package com.bdqn.thread;

public class SaleTickets {
	
	public static void main(String[] args) {
		
		/*SaleThread t1=new SaleThread();
		t1.setName("河西售票点");
		SaleThread t2=new SaleThread();
		t2.setName("河东售票点");
		SaleThread t3=new SaleThread();
		t3.setName("城北售票点");
		SaleThread t4=new SaleThread();
		t4.setName("城南售票点");*/
		
		SaleThread s=new SaleThread();
		
		Thread t1=new Thread(s);
		t1.setName("河西售票点");
		Thread t2=new Thread(s);
		t2.setName("河东售票点");
		Thread t3=new Thread(s);
		t3.setName("城北售票点");
		Thread t4=new Thread(s);
		t4.setName("城南售票点");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}
}

//class SaleThread extends Thread{//继承Thread类实现卖票
class SaleThread implements Runnable{
	private int tickets=100;//票源
	//private Object object=new Object();//对象锁
	
	
	public synchronized void sell(){//同步方法
		
		if(tickets>=1){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"正在销售:"
			+tickets--);
		}
	}
	
	@Override
	public void run() {
		
			while(true)
			{
//				synchronized(this)//同步块
//				{
				
					sell();//调用同步方法
					if(tickets<=0){
						break;
					}
//				}
				
				
			}
		}
		
}
	

