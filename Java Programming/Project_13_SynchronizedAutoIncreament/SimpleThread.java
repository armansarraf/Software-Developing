
public class SimpleThread implements Runnable{

	Resource resource;
	private long sleepTime;
	
	public void run() {
		for(int i = 0; i<10; i++){
			try {
			
			System.out.println(resource.increment());
			
			Thread.sleep(sleepTime);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	SimpleThread(Resource resource, long sleep){
		this.resource = resource;
		this.sleepTime=sleep;
	}
	
	public static void main(String args[]) {
		Resource resource = new Resource();
		SimpleThread myT1 = new SimpleThread(resource, 1);
		SimpleThread myT2 = new SimpleThread(resource, 1);
		
		Thread thread1 = new Thread(myT1);
		Thread thread2 = new Thread(myT2);
		
		thread1.start();
		thread2.start();
	}
}

