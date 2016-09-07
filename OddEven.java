package test;

public class OddEven {
	public OddEven(){
	}
	
	public String print(int number) {
		if(isPrime(number)) return String.valueOf(number);
		else if (isEven(number)) return "even";
		else if (isOdd(number)) return "odd";
		return "";
	}
	
	public boolean isEven(int number){
		if(number != 2 && number%2 == 0)return true;
		return false;
	}
	
	public boolean isOdd(int number){
		if(number % 2 != 0)return true;
		return false;
	}
	 private boolean isPrime(int number) {
	        if (number == 1) return false;
	        for (int i = 2; i <= Math.sqrt(number); i ++) {
	            if (number % i == 0)
	                return false;
	        }
	        return true;
	    }
	 
	 public String print(int start, int end) {
	        StringBuilder res = new StringBuilder();
	        for (int i = start; i <= end; i++) {
	            res.append(print(i) + ", ");
	        }
	        return res.substring(0, res.length() - 2);
	    }
}
