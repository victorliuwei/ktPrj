package com.bdqn.thread;

public class MultiThread {
	
	public static void main(String[] args) {
		
//		Thread t=Thread.currentThread();//�õ���ǰִ�е��߳�
//		t.setName("��D��");
//		t.setPriority(10);//������ȼ�
//		System.out.println(t);
		
		TortoiseThread t=new TortoiseThread();
		t.setPriority(Thread.MAX_PRIORITY);
//		t.run();//������ԭ����main�߳�������
		t.start();//�����µ��ڹ��̣߳�������run����
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("------->���������ˣ��ڹ���Ͱ�!");
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
			System.out.println("======>�ڹ������ˣ����Ӽ��Ͱ�!");
		}
	}
}


