package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import handler.FileHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardSerivice;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardCtrl.class);
	private final String UTF8 = "utf-8";
	private BoardSerivice bsv;
	private RequestDispatcher rdp;
	private int isUp;
	private String destPage;
	private String savePath;
	
    public BoardCtrl() {
    	bsv = new BoardServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : " + path);
		
		switch (path) {
		case "register":
			destPage = "/board/register.jsp";
			break;
		case "insert":
			try {
			String savePath = getServletContext().getRealPath("/_fileUpload");
			File fileDir = new File(savePath);
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(fileDir);
			fileItemFactory.setSizeThreshold(2*1024*1024); // 저장을 위한 임시 메모리 저장용량: byte단위
			
			BoardVO bvo = new BoardVO();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			List<FileItem> itemList = fileUpload.parseRequest(req);
			for (FileItem item : itemList) {
				switch (item.getFieldName()) {
				case "title":
					bvo.setTitle(item.getString(UTF8));
					break;
				case "price":
					bvo.setPrice(Integer.parseInt(item.getString(UTF8)));
					break;
				case "made_by":
					bvo.setMade_by(item.getString(UTF8));
					break;
				case "writer":
					bvo.setWriter(item.getString(UTF8));
					break;
				case "category":
					bvo.setCategory(item.getString(UTF8));
					break;
				case "description":
					bvo.setDescription(item.getString(UTF8));
					break;
				case "imageFile":
					if (item.getSize() > 0) {

						String fileName = item.getName() // 경로가 포함된 전체 이름
								.substring(item.getName().lastIndexOf(File.separator)+1); 
						// \로 구분된 경로 이후의 파일이름
						
						// 실제 저당될 path로 파일을 객체화
						fileName = System.currentTimeMillis() + "_" + fileName;
						File UploadFilePath = new File(fileDir + File.separator + fileName);
						
						try {
							item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
							bvo.setImage_file(fileName);
							//_java/lec/_jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/06_final_jsp_fileUpload/_fileUpload
							
							Thumbnails.of(UploadFilePath)
									.size(100, 100)
									.toFile(new File(fileDir + File.separator + "th_" + fileName));
							
							// 썸네일 작업: 리스트 페이지에서 트래픽 과다사용 방지
						} catch (Exception e) {
							log.info(">>> File Writer on disk Fail");
							e.printStackTrace();
						}
						
					}
					isUp = bsv.register(bvo);
					log.info(">>> BoardCtrl > insert > {}", isUp > 0 ? "OK":"Fail");
					destPage = "list";
					break;
				default:
					break;
				}
			}
			
			} catch (FileUploadException e) {
				
				e.printStackTrace();
				
			}
			break;
		case "list":
			req.setAttribute("list", bsv.getList());
			destPage  = "/board/list.jsp";
			break;
		case "detail":
			req.setAttribute("bvo", bsv.getDetail(Long.parseLong(req.getParameter("bno"))));
			destPage = "/board/detail.jsp";
			break;
		case "modify":
			req.setAttribute("bvo", bsv.getDetail(Long.parseLong(req.getParameter("bno"))));
			destPage = "/board/modify.jsp";
			break;
		case "update":
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(2*1024*1024); // 저장을 위한 임시 메모리 저장용량: byte단위
				
				BoardVO bvo = new BoardVO();
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

				List<FileItem> itemList = fileUpload.parseRequest(req);
				
				String old_file = null;
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "bno":
						bvo.setBno(Integer.parseInt(item.getString(UTF8)));
					case "title":
						bvo.setTitle(item.getString(UTF8));
						break;
					case "price":
						bvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "made_by":
						bvo.setMade_by(item.getString(UTF8));
						break;
					case "writer":
						bvo.setWriter(item.getString(UTF8));
						break;
					case "category":
						bvo.setCategory(item.getString(UTF8));
						break;
					case "description":
						bvo.setDescription(item.getString(UTF8));
						break;
					case "image_file":
						old_file = item.getString(UTF8);
						break;
					case "new_file":
						if (item.getSize() > 0) {
							
							if (old_file != null) {
								FileHandler fileHandler = new FileHandler();
								savePath = getServletContext().getRealPath("/_fileUpload");
								
								isUp = fileHandler.deleteFile(old_file, savePath);
							}
							
							String fileName = item.getName() // 경로가 포함된 전체 이름
									.substring(item.getName().lastIndexOf(File.separator)+1); 
							// \로 구분된 경로 이후의 파일이름
							
							// 실제 저당될 path로 파일을 객체화
							fileName = System.currentTimeMillis() + "_" + fileName;
							File UploadFilePath = new File(fileDir + File.separator + fileName);
							
							try {
								item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
								bvo.setImage_file(fileName);
								//_java/lec/_jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/06_final_jsp_fileUpload/_fileUpload
								
								Thumbnails.of(UploadFilePath)
										.size(100, 100)
										.toFile(new File(fileDir + File.separator + "th_" + fileName));
								
								// 썸네일 작업: 리스트 페이지에서 트래픽 과다사용 방지
							} catch (Exception e) {
								log.info(">>> File Writer on disk Fail");
								e.printStackTrace();
							}
						} else {
							bvo.setImage_file(old_file);
						}
						isUp = bsv.modify(bvo);
						log.info(">>> BoardCtrl > Update > {}", isUp > 0 ? "OK":"Fail");
						destPage = "detail?bno=" + bvo.getBno();
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "remove":
			// 방법 1: get 방식 이용 (detail.jsp 수정 필요)
//			if (req.getParameter("image_file") != null && req.getParameter("image_file") != "") {
//				log.info("check1");
//				FileHandler fileHandler = new FileHandler();
//				fileHandler.deleteFile(req.getParameter("image_file"), getServletContext().getRealPath("/_fileUpload"));
//			}
			
			// 방법 2: getDetail 이용
			BoardVO bvo = bsv.getDetail(Long.parseLong(req.getParameter("bno")));
			if (bvo.getImage_file() != null && bvo.getImage_file()  != "") {
				log.info("check1");
				FileHandler fileHandler = new FileHandler();
				fileHandler.deleteFile(bvo.getImage_file(), getServletContext().getRealPath("/_fileUpload"));
			}
			
			isUp = bsv.remove(Long.parseLong(req.getParameter("bno")));
			log.info(">>> BoardCtrl > Remove > {}", isUp > 0 ? "OK":"Fail");
			destPage = "list";
			break;
		default:
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
