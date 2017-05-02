package com.bdqn.thread;

public class TestThread {
	
	public static void main(String[] args) {
		/*MyThread my=new MyThread();//�������̶߳���
		my.start();//�������߳�
		
		MyThread my2=new MyThread();//�������̶߳���
		my2.start();//�������߳�
		
		MyThread my3=new MyThread();//�������̶߳���
		my3.start();//�������߳�
     */		
		MyThread my=new MyThread();
		Thread t1=new Thread(my);
		t1.setName("������Ʊ��");
		t1.start();
		
		Thread t2=new Thread(my);
		t2.setName("�Ӷ���Ʊ��");
		t2.start();
		
		Thread t3=new Thread(my);
		t3.setName("������Ʊ��");
		t3.start();
	}
	
}
//class MyThread extends Thread{
class MyThread implements Runnable{
	
	private int tickets=100;//100��ƱҪ������
	
	private Object lock=new Object();
	
	
	public synchronized void sell(){//ͬ������,��������
		if(tickets>0)
		{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+"��������"+tickets--);
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
			
			sell();//����ͬ������
			
			if(tickets<=0){
				break;//����ѭ��
			}
			
			/*synchronized(lock)//ͬ����
			{
				if(tickets>0)
				{
					Thread t=Thread.currentThread();
					System.out.println(t.getName()+"��������"+tickets--);
				}else{
					break;
				}
			}*/
			
		}
		
	}
}
