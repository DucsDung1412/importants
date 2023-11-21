package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changeLayout
 */
@WebServlet({ "/change-layout/home", "/change-layout/about", "/change-layout/contact" })
public class changeLayout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeLayout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("home")) {
			request.getSession().setAttribute("mess", "Trang chủ");
		} else if(request.getRequestURI().contains("about")) {
			request.getSession().setAttribute("mess", "Giới thiệu");
		} else if(request.getRequestURI().contains("contact")) {
			request.getSession().setAttribute("mess", "Liên hệ");
		} 
		response.sendRedirect("../home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
