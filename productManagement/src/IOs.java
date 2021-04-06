import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOs {
	
	
	public static void main(String[] args) throws IOException {
		
		String path1 = "E:\\Projetos\\gitHub\\java11Certificate\\productManagement\\ios";
		Path backup = Path.of("E:\\Projetos\\gitHub\\java11Certificate\\productManagement\\ios\\backup\\docs");
		//Files.createDirectory(backup);
		Files.createDirectories(backup);
	}

}
