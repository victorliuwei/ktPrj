package com.bdqn.thread;

public class TestThread {
	
	public static void main(String[] args) {
		/*MyThread my=new MyThread();//创建新线程对象
		my.start();//启动新线程
		
		MyThread my2=new MyThread();//创建新线程对象
		my2.start();//启动新线程
		
		MyThread my3=new MyThread();//创建新线程对象
		my3.start();//启动新线程
     */		
		MyThread my=new MyThread();
		Thread t1=new Thread(my);
		t1.setName("河西售票点");
		t1.start();
		
		Thread t2=new Thread(my);
		t2.setName("河东售票点");
		t2.start();
		
		Thread t3=new Thread(my);
		t3.setName("河南售票点");
		t3.start();
	}
	
}
//class MyThread extends Thread{
class MyThread implements Runnable{
	
	private int tickets=100;//100张票要被共享
	
	private Object lock=new Object();
	
	
	public synchronized void sell(){//同步方法,用隐含锁
		if(tickets>0)
		{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+"正在销售"+tickets--);
		}
	}
	
	public void run(){
		
		while(true)
		{
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sell();//调用同步方法
			
			if(tickets<=0){
				break;//跳出循环
			}
			
			/*synchronized(lock)//同步块
			{
				if(tickets>0)
				{
					Thread t=Thread.currentThread();
					System.out.println(t.getName()+"正在销售"+tickets--);
				}else{
					break;
				}
			}*/
			
		}
		
	}
}
