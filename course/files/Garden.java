package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Garden {

	
	public static void main(String[] args) throws IOException {
		
		try (var s = System.out) {
			   System.out.print("1");
			} finally {
			   System.out.print("3");
			}
		
		
		
		
//		String path = "E:\\Projetos\\gitHub\\java11Certificate\\course\\files";
//		
//		Files.createDirectories(Path.of(path + "\\garden"));
//		Files.createDirectory(Path.of(path + "\\nursery"));
//		 
//		Files.move(Path.of(path + "\\flower\\rose.txt"),
//		   Paths.get(path + "\\garden\\rose.txt"), StandardCopyOption.REPLACE_EXISTING);
//		Files.move(new File(path+ "\\garden\\rose.txt").toPath(),
//		   Paths.get(path+ "\\nursery\\rose.txt"), StandardCopyOption.ATOMIC_MOVE);

	}
}
