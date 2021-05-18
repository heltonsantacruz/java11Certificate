package exception;

public class LackOfInformationException extends InformationException{
	
	public LackOfInformationException() {             // t1
	      //super("");
	   }
	   public LackOfInformationException(String s) {     // t2
	      this(new Exception(s));
	   }
	   public LackOfInformationException(Exception c) {  // t3
	      super();
	   }
	   @Override public String getMessage() {
	      return "lackOf";
	   }
	   
	   public void ________() {
		   StringBuilder sb = new StringBuilder("radical").insert(sb.length(), "robots");
		   System.out.println(sb);
		   
	   }
	   
	   public void $fdfd$() {
		   
	   }

}
