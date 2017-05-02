package com.bdqn.thread;

public class TestWaitNotify {
	
	public static void main(String[] args) {
		ComputeThread c=new ComputeThread();
		c.start();//启动线程的方法
		c.show();//普通方法
	}
	

}

class ComputeThread extends Thread{
	
	private int sum=0;
	public void run(){
		synchronized(this){
			for (int i = 1; i <= 100; i++) {
				sum+=i;
			}
			System.out.println("计算完成");
			notify();//唤醒
		}
	}
	
	public void show(){
		synchronized(this){
			try{
				System.out.println("开始计算");
				wait();//等待
				System.out.println("在此等待计算结果");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			System.out.println("计算结果:"+sum);
		}
	}
	
}
