package controllers.comments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;

/**
 * Servlet implementation class CommentsNewServlet
 */
@WebServlet("/comments/new")
public class CommentsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("_token", request.getSession().getId());

        String report_id = request.getParameter("report_id");
        request.setAttribute("report_id", report_id);

        Comment c = new Comment();
        request.setAttribute("comment", c);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/comments/new.jsp");
        rd.forward(request, response);
    }

}
