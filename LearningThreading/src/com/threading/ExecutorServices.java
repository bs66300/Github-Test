package com.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executorservice = Executors.newSingleThreadExecutor();
		Future future = executorservice.submit(new Callable()
				{
				public  String call() {
					System.out.println("Executor Services Executed for newSingleThreadExecutor()");
					return "CallableRETURN";
				}
			
			
				}
				);
		
		try {
			System.out.println( "executor services  isTerminated:" +future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorservice.shutdown();
		try {
			System.out.println( "executor services  isTerminated:" +future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		ExecutorService executorservice2 = Executors.newFixedThreadPool(10);
	 
		executorservice2.execute(new Runnable()
				{
				public  void run() {
					System.out.println("Executor Services Executed for newFixedThreadPool()");
				}
			
			
				}
				);
		

		
		
	}

}
