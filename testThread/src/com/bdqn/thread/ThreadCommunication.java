package com.bdqn.thread;

//数据存储空间
class Data
{
	private String name;//姓名
	private String sex;//性别
	boolean bFull=false;//是否已满
    //存数据
	public synchronized  void put(String name,String sex)
	{
		
		try {
			if(bFull==true)
			{
				wait();//等待其他线程进入同一监视器调用notify为止
			}  
		    this.name=name;
			Thread.sleep(10);
			this.sex=sex;
			bFull=true;//数据存放后修改已满状态为true
			notify();//唤醒同一个对象监视器中调用wait的第一个线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//存数据
	public synchronized void get()
	{
		try
		{
			if(!bFull)
			{
				wait();//等待其他线程进入同一监视器调用notify为止
			}  
			System.out.println(name+"---->"+sex);
			bFull=false;//数据取完后修改已满状态为false
			notify();//唤醒同一个对象监视器中调用wait的第一个线程
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
				q.put("张三","男");//i为0时存放张三
			}else
			{
				q.put("李四","女");//i为1时存放李四
			}
			i=(i+1)%2;// i在0,1切换
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
			q.get();//取数据
		}
	}
}

public class ThreadCommunication {
	public static void main(String[] args) {
		Data q=new Data();
		new Thread(new Produce(q)).start();//启动生产者线程
		new Thread(new Consume(q)).start();//启动消费者线程
	}
	
}
