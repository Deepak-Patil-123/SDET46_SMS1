import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreDataInPropertyFile {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos=new FileOutputStream("./src/test/resources/Common Data/commonData.properties",true);
		
		Properties p=new Properties();
		
		p.setProperty("timeouts","10");
		p.store(fos, "New data is added!");
		
		fos.close();
		p.clear();
	}

}
