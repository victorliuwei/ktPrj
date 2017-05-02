package com.bdqn.thread;
/** 
* һ���򵥵������� 
* ��DeadLock��Ķ���flag==1ʱ��td1����������o1,˯��500���� 
* ��td1��˯�ߵ�ʱ����һ��flag==0�Ķ���td2���߳�������������o2,˯��500���� 
* td1˯�߽�������Ҫ����o2���ܼ���ִ�У�����ʱo2�ѱ�td2������ 
* td2˯�߽�������Ҫ����o1���ܼ���ִ�У�����ʱo1�ѱ�td1������ 
* td1��td2�໥�ȴ�������Ҫ�õ��Է���������Դ���ܼ���ִ�У��Ӷ������� 
*/  
public class DeadLock2 implements Runnable {  
    public int flag = 1;  
    //��̬������������ж������  
    private static Object o1 = new Object(), o2 = new Object();  
    @Override  
    public void run() {  
        System.out.println("flag=" + flag);  
        if (flag == 1) {  
            synchronized (o1) {  
                try {  
                    Thread.sleep(500);  
//                    wait();
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                synchronized (o2) {  
                    System.out.println("1");  
                }  
            }  
        }  
        if (flag == 0) {  
            synchronized (o2) {  
                try {  
                    Thread.sleep(500);  
//                    notify();
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                synchronized (o1) {  
                    System.out.println("0");  
                }  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
          
        DeadLock2 td1 = new DeadLock2();  
        DeadLock2 td2 = new DeadLock2();  
        td1.flag = 1;  
        td2.flag = 0;  
        //td1,td2�����ڿ�ִ��״̬����JVM�̵߳�����ִ���ĸ��߳��ǲ�ȷ���ġ�  
        //td2��run()������td1��run()֮ǰ����  
        new Thread(td1).start();  
        new Thread(td2).start();  
  
    }  
}  
