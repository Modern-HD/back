package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import handler.FileHandler;
import service.BoardSerivice;
import service.BoardServiceImpl;


/**
 * Servlet implementation class FileCtrl
 */
@WebServlet("/file/*")
public class FileCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	private int isUp;
	private BoardSerivice bsv;
	
    public FileCtrl() {
    	bsv = new BoardServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/file/") + 6); // file/10
		log.info(">>> paths : " + path);
		
		String pathVar = "";
		if(path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/")+1); // 10
			path = path.substring(0, path.lastIndexOf("/"));
		}
		
		switch (path) {
		case "remove":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				String imageFileName = jsonObj.get("img_file").toString();
				long bno = Long.parseLong(jsonObj.get("bno").toString());
				
				FileHandler fileHandler = new FileHandler();
				
				String savePath = getServletContext().getRealPath("/_fileUpload");
				isUp = fileHandler.deleteFile(imageFileName, savePath);
				if(isUp > 0) {
					isUp = bsv.removeFile(bno);
				}
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
