package com.bdqn.thread;

public class TestWaitNotify {
	
	public static void main(String[] args) {
		ComputeThread c=new ComputeThread();
		c.start();//�����̵߳ķ���
		c.show();//��ͨ����
	}
	

}

class ComputeThread extends Thread{
	
	private int sum=0;
	public void run(){
		synchronized(this){
			for (int i = 1; i <= 100; i++) {
				sum+=i;
			}
			System.out.println("�������");
			notify();//����
		}
	}
	
	public void show(){
		synchronized(this){
			try{
				System.out.println("��ʼ����");
				wait();//�ȴ�
				System.out.println("�ڴ˵ȴ�������");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			System.out.println("������:"+sum);
		}
	}
	
}
