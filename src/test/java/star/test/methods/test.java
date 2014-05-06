package star.test.methods;

public class test implements Runnable {  
	//int i;
     public void run() {  
          synchronized(this) {  
               for (int i = 0; i < 15; i++) {  
                    System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);  
               }  
          }  
     }  
     public static void main(String[] args) {  
          test t1 = new test();  
          Thread ta = new Thread(t1, "A");  
          Thread tb = new Thread(t1, "B");  
          Thread tc = new Thread(t1, "C"); 
          ta.start();  
          tb.start();  
          tc.start();
     } 
}