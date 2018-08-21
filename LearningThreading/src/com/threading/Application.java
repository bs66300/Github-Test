package com.threading;

public class Application {

	public static void main(String[] args) {
		
		 //Task mytask = ;
		 System.out.println("Starting Thread 1!!!");
		 Thread t1= new Thread(new Task("FirstThread"));
		 t1.start();
		 //mytask.start();
		 /*
		 try {
			mytask.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		 System.out.println("Starting Thread 2!!!");
		 //mytask.start();

		 
		 Task mytask2 = new Task("SecondThread");
		 Thread t2= new Thread(mytask2);	
		 t2.start();
		 //mytask2.start();
		 
		 Thread t3 = new Thread(new Runnable() {
				@Override
				public void run() {
					
					Thread.currentThread().setName("Thread3");
					for(int i=0;i<1000;i++) {
						System.out.println(Thread.currentThread().getName() +",number :" + i);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			 
		 });
		 t3.start();
	}

}


class Task implements Runnable // Thread
{

	String name;
	public Task(String name) {
		this.name= name;
	}
	
	@Override
	public void run() {
		
		Thread.currentThread().setName(name);
		for(int i=0;i<1000;i++) {
			System.out.println(Thread.currentThread().getName() +",number :" + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}