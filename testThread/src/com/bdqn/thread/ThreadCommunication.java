package com.bdqn.thread;

//���ݴ洢�ռ�
class Data
{
	private String name;//����
	private String sex;//�Ա�
	boolean bFull=false;//�Ƿ�����
    //������
	public synchronized  void put(String name,String sex)
	{
		
		try {
			if(bFull==true)
			{
				wait();//�ȴ������߳̽���ͬһ����������notifyΪֹ
			}  
		    this.name=name;
			Thread.sleep(10);
			this.sex=sex;
			bFull=true;//���ݴ�ź��޸�����״̬Ϊtrue
			notify();//����ͬһ������������е���wait�ĵ�һ���߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//������
	public synchronized void get()
	{
		try
		{
			if(!bFull)
			{
				wait();//�ȴ������߳̽���ͬһ����������notifyΪֹ
			}  
			System.out.println(name+"---->"+sex);
			bFull=false;//����ȡ����޸�����״̬Ϊfalse
			notify();//����ͬһ������������е���wait�ĵ�һ���߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
class Produce implements Runnable
{
    Data q=null;
    public Produce(Data q)
    {
    	this.q=q;
    }
	public void run() {
		int i=0;
		while(true)
		{
			if(i==0)
			{
				q.put("����","��");//iΪ0ʱ�������
			}else
			{
				q.put("����","Ů");//iΪ1ʱ�������
			}
			i=(i+1)%2;// i��0,1�л�
		}
	}
}


class Consume implements Runnable
{
    Data q;
    public Consume(Data q)
    {
    	this.q=q;
    }
	public void run() {
		while(true)
		{
			q.get();//ȡ����
		}
	}
}

public class ThreadCommunication {
	public static void main(String[] args) {
		Data q=new Data();
		new Thread(new Produce(q)).start();//�����������߳�
		new Thread(new Consume(q)).start();//�����������߳�
	}
	
}
