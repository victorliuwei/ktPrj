package com.bdqn.thread;

public class MultiThread {
	
	public static void main(String[] args) {
		
//		Thread t=Thread.currentThread();//得到当前执行的线程
//		t.setName("大D豪");
//		t.setPriority(10);//最低优先级
//		System.out.println(t);
		
		TortoiseThread t=new TortoiseThread();
		t.setPriority(Thread.MAX_PRIORITY);
//		t.run();//还是在原来的main线程中运行
		t.start();//启动新的乌龟线程，并调用run方法
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("------->兔子领先了，乌龟加油啊!");
		}
		
	}
}

class TortoiseThread extends Thread{
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("======>乌龟领先了，免子加油啊!");
		}
	}
}


