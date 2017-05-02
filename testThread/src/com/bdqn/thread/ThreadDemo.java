package com.bdqn.thread;

public class ThreadDemo {
	
	public static void main(String[] args) {
		
		OtherThread other=new OtherThread();
//		other.start();//��������һ���̳���Thread���߳�
		Thread t=new Thread(other);
		t.setName("С�ɰ��߳�");
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();//��������һ��ʵ����Runnable���߳�
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
			System.out.println("��ǰ�߳�:"+Thread.currentThread());
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("||||||||||||||||||||");
		}
	}
	
}
