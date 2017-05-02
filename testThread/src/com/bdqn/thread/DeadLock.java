package com.bdqn.thread;

public class DeadLock {
	
	public static void main(String[] args)
	{
		final Friend zhang=new Friend("张先生");
		final Friend li=new Friend("李先生");
		
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
		System.out.println(this.name+"说"+bower.getName()+"已经向我敬礼");
		bower.bowback(this);
	}
	public synchronized void bowback(Friend bower)
	{
		System.out.println(this.name+"说"+bower.getName()+"向我回了礼");
		bower.bow(this);
	}
}