package com.bdqn.thread;

public class TestSaleTicketsThread {
	public static void main(String[] args) {
		/*SaleTicketsThread t=new SaleTicketsThread();
		t.setName("������Ʊ��");
		t.start();
		
		SaleTicketsThread t2=new SaleTicketsThread();
		t2.setName("�Ӷ���Ʊ��");
		t2.start();*/
		
		SaleTicketsThread t=new SaleTicketsThread();
		Thread t1=new Thread(t);
		t1.setName("1������Ʊ��");
		t1.start();
		
		Thread t2=new Thread(t);
		t2.setName("2�Ӷ���Ʊ��");
		t2.start();
		
		Thread t3=new Thread(t);
		t3.setName("3������Ʊ��");
		t3.start();
	}
}

//class SaleTicketsThread extends Thread{
class SaleTicketsThread implements Runnable{
	
	private int tickets=100;
	
	private Object o=new Object();//������󶼿ɵ����߳���
	
	
	public synchronized void sale(){
		if(tickets>0)
		{
			System.out.println(Thread.currentThread().getName()+"��������:"+tickets--);
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
				sale();//����ͬ������
				
				if(tickets<=0){
					break;
				}
//			}
		}
		
	}
}
