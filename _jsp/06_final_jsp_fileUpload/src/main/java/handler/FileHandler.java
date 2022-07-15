package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);

	public int deleteFile(String imageFileName, String savePath) {
		try {
			File fileDir = new File(savePath);
			
			File removeFile = new File(fileDir + File.separator + imageFileName);
			File removeThumbFile = new File(fileDir + File.separator + "th_" + imageFileName);
			
			boolean isDel = true;
			if(removeFile.exists() || removeThumbFile.exists()) {
				isDel = removeFile.delete();
				if(isDel) {
					isDel = removeThumbFile.delete();
				}
			}
			log.info(">>> FileHandler Remove is {}", isDel ? "OK" : "Fail");
			return isDel ? 1 : 0;
		} catch (Exception e) {
			log.info(">>> FileHandler > Remove > Error");
			e.printStackTrace();
		}
		return 0;
	}
}
