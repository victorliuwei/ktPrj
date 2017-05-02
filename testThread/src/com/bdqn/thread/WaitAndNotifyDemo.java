package com.bdqn.thread;

public class WaitAndNotifyDemo {
	
	public static void main(String[] args) {
		KtThread t=new KtThread();
		
		t.start();//��������һ�����̣߳�����
		t.synchMethod();//��main����������
		
	}

}

class KtThread extends Thread{
	
	private int total=0;
	public void run(){
		synchronized(this){
			for (int i = 0; i <= 100; i++) {
				total+=i;
			}
			System.out.println("�������");
			notify();
		}
		
	}
	
	public void synchMethod(){
		synchronized(this){
			try
			{
				System.out.println("�ڴ˵ȴ��������....");
				wait();
				System.out.println("���ؼ������");
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			System.out.println("������:"+total);
		}
		
	}
	
}
