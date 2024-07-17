package note;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/AddNoteServlet")
public class AddNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (title != null && !title.trim().isEmpty() && content != null && !content.trim().isEmpty()) {
            Note newNote = new Note(title, content);
            HttpSession session = request.getSession();
            List<Note> notes = (List<Note>) session.getAttribute("notes");
            notes.add(newNote);
            session.setAttribute("notes", notes);
        }

        response.sendRedirect("index.jsp");
    }
}
