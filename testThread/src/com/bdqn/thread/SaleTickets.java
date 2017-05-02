package com.bdqn.thread;

public class SaleTickets {
	
	public static void main(String[] args) {
		
		/*SaleThread t1=new SaleThread();
		t1.setName("������Ʊ��");
		SaleThread t2=new SaleThread();
		t2.setName("�Ӷ���Ʊ��");
		SaleThread t3=new SaleThread();
		t3.setName("�Ǳ���Ʊ��");
		SaleThread t4=new SaleThread();
		t4.setName("������Ʊ��");*/
		
		SaleThread s=new SaleThread();
		
		Thread t1=new Thread(s);
		t1.setName("������Ʊ��");
		Thread t2=new Thread(s);
		t2.setName("�Ӷ���Ʊ��");
		Thread t3=new Thread(s);
		t3.setName("�Ǳ���Ʊ��");
		Thread t4=new Thread(s);
		t4.setName("������Ʊ��");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}
}

//class SaleThread extends Thread{//�̳�Thread��ʵ����Ʊ
class SaleThread implements Runnable{
	private int tickets=100;//ƱԴ
	//private Object object=new Object();//������
	
	
	public synchronized void sell(){//ͬ������
		
		if(tickets>=1){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"��������:"
			+tickets--);
		}
	}
	
	@Override
	public void run() {
		
			while(true)
			{
//				synchronized(this)//ͬ����
//				{
				
					sell();//����ͬ������
					if(tickets<=0){
						break;
					}
//				}
				
				
			}
		}
		
}
	

