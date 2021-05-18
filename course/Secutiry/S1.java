package Secutiry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.List;

public class S1 {
	
	public List<String> accessNetworkList(String fileName) {
		
		return AccessController.doPrivileged(new PrivilegedAction<List<String>>() {
		       public List<String> run() {
		          try {
		             return Collections.unmodifiableList(Files.readAllLines(Path.of(fileName)));
		          } catch (IOException e) {
		             throw new SecurityException("No access");
		          } 
		         } 
		   });
	}
}
