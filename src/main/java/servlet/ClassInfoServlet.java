package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ClassInfoServlet
 */
@WebServlet("/ClassInfoServlet")
public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        try{
		ClassInfoDAO dao = new ClassInfoDAO();
		HttpSession session = request.getSession(true);
		LoginBean lb = (LoginBean)session.getAttribute("currentSessionUser");
		ArrayList<ClassInfo> clist = dao.getClassesByProf(lb.getUsername());
		int clen = clist.size();
		String par1 = "";
		String par2 = "";
		for(int i = 0; i < clen; i++){
			par1 = clist.get(i).getStringDeptid();
			par2 = clist.get(i).getStringCid();
			if(request.getParameter(par1 + " : " + par2)!=null){
				session.setAttribute("Sel", clist.get(i));
				break;
			}
		}
		request.setAttribute("formAction", "getTheInfo");
		RequestDispatcher rd = request.getRequestDispatcher("/ClassInfoPage.jsp");
        rd.forward(request, response);
        }catch(Exception e){
            
        }
	}

}
