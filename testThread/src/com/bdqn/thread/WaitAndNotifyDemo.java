package com.bdqn.thread;

public class WaitAndNotifyDemo {
	
	public static void main(String[] args) {
		KtThread t=new KtThread();
		
		t.start();//启动另外一个子线程，运行
		t.synchMethod();//在main方法中运行
		
	}

}

class KtThread extends Thread{
	
	private int total=0;
	public void run(){
		synchronized(this){
			for (int i = 0; i <= 100; i++) {
				total+=i;
			}
			System.out.println("计算完成");
			notify();
		}
		
	}
	
	public void synchMethod(){
		synchronized(this){
			try
			{
				System.out.println("在此等待计算完成....");
				wait();
				System.out.println("返回计算完成");
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			System.out.println("计算结果:"+total);
		}
		
	}
	
}
