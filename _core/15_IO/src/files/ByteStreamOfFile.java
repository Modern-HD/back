package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamOfFile {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		final String PATH_OUT = "outFile.txt";
		final String PATH_IN = "inFile.txt";
		
		fos = new FileOutputStream(PATH_OUT);
		fis = new FileInputStream(PATH_IN);
		
		int n;
		try {
			while ((n = fis.read()) != -1) {
				System.out.print(n);
				fos.write(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (fis != null) {
			fis.close();
		}
		if (fos != null) {
			fos.close();
		}
	}
	
}
