package com.bdqn.thread;

public class DeadLock {
	
	public static void main(String[] args)
	{
		final Friend zhang=new Friend("������");
		final Friend li=new Friend("������");
		
		new Thread(new Runnable()
		{
			public void run(){
				li.bow(zhang);
			}
		}).start();
		
		new Thread(new Runnable()
		{
			public void run(){
				zhang.bowback(li);
			}
		}).start();
		
	}

}

class Friend
{
	private final String name;
	
	public Friend(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public synchronized void bow(Friend bower)
	{
		System.out.println(this.name+"˵"+bower.getName()+"�Ѿ����Ҿ���");
		bower.bowback(this);
	}
	public synchronized void bowback(Friend bower)
	{
		System.out.println(this.name+"˵"+bower.getName()+"���һ�����");
		bower.bow(this);
	}
}