package Test;

public class DoubleCheckedSingleton {
	   private static DoubleCheckedSingleton singleton= null;  
 
	    public static DoubleCheckedSingleton getSingleInstance(){  
	        if(null == singleton ) {
	              synchronized(DoubleCheckedSingleton.class){
	                     if(null == singleton)
	                    	 singleton = new DoubleCheckedSingleton();
	              }
	         } 
	       return singleton;
	    }
	    
	    public void test() {
	    	System.out.println("getSingleInstance");
	    }
	    
	    private DoubleCheckedSingleton(){  
	    }  
 
}
