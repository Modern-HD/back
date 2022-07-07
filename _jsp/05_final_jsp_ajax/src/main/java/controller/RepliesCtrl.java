package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.RepliesVO;
import service.RepliesService;
import service.RepliesServiceImpl;


@WebServlet("/rps/*")
public class RepliesCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	private RepliesService rsv;
	private int isUp;
	
    public RepliesCtrl() {
    	rsv = new RepliesServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/rps/") + 5); // list/10
		log.info(">>> paths : " + path);
		
		String pathVar = "";
		if(path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/")+1); // 10
			path = path.substring(0, path.lastIndexOf("/"));
		}
		switch (path) {
		case "post":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null ) {
					sb.append(line);
				}
				log.info(">>> sb : {}", sb.toString());
				
				JSONParser parser = new JSONParser();
				
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				isUp = rsv.register(new RepliesVO(Integer.parseInt(jsonObj.get("pno").toString()), 
										jsonObj.get("replier").toString(),
										jsonObj.get("reply").toString()
										));
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				log.info(">>> ReplierCtrl > list > Error");
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<RepliesVO> list = rsv.getList(Integer.parseInt(pathVar));
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); // key: value
					jsonObjArr[i].put("rno", list.get(i).getRno());
					jsonObjArr[i].put("pno", list.get(i).getPno());
					jsonObjArr[i].put("replier", list.get(i).getReplier());
					jsonObjArr[i].put("reply", list.get(i).getReply());
					jsonObjArr[i].put("reg_at", list.get(i).getReg_at());
					jsonObjArr[i].put("mod_at", list.get(i).getMod_at());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				log.info(">>> ReplierCtrl > list > Error");
			}
			break;
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				JSONParser parser = new JSONParser();
				
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				isUp = rsv.modify(new RepliesVO(Long.parseLong(jsonObj.get("rno").toString()),
										jsonObj.get("reply").toString()));
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				JSONParser parser = new JSONParser();
				
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				isUp = rsv.remove(Long.parseLong(jsonObj.get("rno").toString()));
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
