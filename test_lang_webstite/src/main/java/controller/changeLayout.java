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
@WebServlet({ "/change-layout/home", "/change-layout/about", "/change-layout/contact", "/change-layout/faq", "/change-layout/signin", "/change-layout/signup", "/change-layout/signout", "/change-layout/changep", "/change-layout/favorites", "/change-layout/forgot", "/change-layout/profile" })
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
			request.getSession().setAttribute("mess", "home");
		} else if(request.getRequestURI().contains("about")) {
			request.getSession().setAttribute("mess", "about");
		} else if(request.getRequestURI().contains("contact")) {
			request.getSession().setAttribute("mess", "contact");
		} else if(request.getRequestURI().contains("faq")) {
			request.getSession().setAttribute("mess", "faq");
		} else if(request.getRequestURI().contains("signin")) {
			request.getSession().setAttribute("mess", "signin");
		} else if(request.getRequestURI().contains("signup")) {
			request.getSession().setAttribute("mess", "signup");
		} else if(request.getRequestURI().contains("signout")) {
			request.getSession().setAttribute("mess", "signout");
		} else if(request.getRequestURI().contains("favorites")) {
			request.getSession().setAttribute("mess", "favorites");
		} else if(request.getRequestURI().contains("changep")) {
			request.getSession().setAttribute("mess", "changep");
		} else if(request.getRequestURI().contains("profile")) {
			request.getSession().setAttribute("mess", "profile");
		} else if(request.getRequestURI().contains("forgot")) {
			request.getSession().setAttribute("mess", "forgot");
		} 
//		response.sendRedirect("../NewFile.jsp");
		response.sendRedirect("../index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
