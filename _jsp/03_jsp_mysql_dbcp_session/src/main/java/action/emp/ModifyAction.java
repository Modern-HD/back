package action.emp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImpl;
public class ModifyAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ModifyAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImpl();
		int isUp = esv.modify(new EmpVO(Integer.parseInt(req.getParameter("empno")), "test",req.getParameter("ename"), req.getParameter("job"),
				Integer.parseInt(req.getParameter("mgr")), 
				"test", 
				Double.parseDouble(req.getParameter("sal")), 
				Double.parseDouble(req.getParameter("comm")), Integer.parseInt(req.getParameter("deptno"))
				));
		log.info(">>> Emp Update {}", isUp > 0 ? "Success" : "Fail");
	}
}
