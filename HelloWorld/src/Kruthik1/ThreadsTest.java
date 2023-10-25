package Kruthik1;

public class ThreadsTest {
	public static class PrinterThread extends Thread{
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 10 ; i++) {
				System.out.println(Thread.currentThread()+" "+i);
			}
		}
	}
	
	public static class PrinterThreadByInterface implements Runnable{
@Override
		public void run() {
			for (int i = 0; i < 10 ; i++) {
				System.out.println(Thread.currentThread()+" "+i);
			}
		}
	}
	
	public static void main(String[] args) {
		// new PrinterThread().start();
//		PrinterThread pt=new PrinterThread();
//		pt.start();
//		PrinterThread pt1=new PrinterThread();
//		pt1.start();
		new Thread(new PrinterThreadByInterface()).start();
		//Anonymous class invoking a thread
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10 ; i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			}
		}).start();
		for (int i = 0; i < 10 ; i++) {
			System.out.println(Thread.currentThread()+" "+i);
		}
	}
}
