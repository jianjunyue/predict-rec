package Test;

import java.util.List;

public class DoubleCheckedSingleton implements ItShopModel{
	   private static DoubleCheckedSingleton singleton= null;  
 
		@Override
		public List<String> predict(String ctx) {
	    	System.out.println(String.format("getSingleInstance ctx:%s",ctx));
			return null;
		}
	   
		
	    public static DoubleCheckedSingleton getInstance(){  
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
