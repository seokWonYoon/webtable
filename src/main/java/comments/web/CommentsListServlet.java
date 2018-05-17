package comments.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.service.CommentsService;
import comments.service.CommentsServiceInf;

@WebServlet("/CommentsListServlet")
public class CommentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentsServiceInf Service;
	
    public CommentsListServlet() {
        super();
        Service = new CommentsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
