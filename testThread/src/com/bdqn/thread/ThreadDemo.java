package com.bdqn.thread;

public class ThreadDemo {
	
	public static void main(String[] args) {
		
		OtherThread other=new OtherThread();
//		other.start();//启动另外一个继承了Thread的线程
		Thread t=new Thread(other);
		t.setName("小可爱线程");
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();//启动另外一个实现了Runnable的线程
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("-----------------");
		}
	}

}

//class OtherThread extends Thread
class OtherThread implements Runnable
{
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println("当前线程:"+Thread.currentThread());
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("||||||||||||||||||||");
		}
	}
	
}
