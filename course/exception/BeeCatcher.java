package exception;

import java.io.IOException;

public class BeeCatcher {

     public static void main(String[] b) throws IOException {
        var s = new Suit();
        var t = new Suit();
        try (t; s) {
	          throw new StungException();
        } catch (StungException e) {
            //s = null;
       } catch (Exception e) {
          //s = null;
       } finally {
    	   
       }
     }
}
