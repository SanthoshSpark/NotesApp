package note;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/EditNoteServlet")
public class EditNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldTitle = request.getParameter("title");
        String newTitle = request.getParameter("newTitle");
        String newContent = request.getParameter("newContent");

        HttpSession session = request.getSession();
        List<Note> notes = (List<Note>) session.getAttribute("notes");

        for (Note note : notes) {
            if (note.getTitle().equals(oldTitle)) {
                note.setTitle(newTitle);
                note.setContent(newContent);
                break;
            }
        }

        session.setAttribute("notes", notes);
        response.sendRedirect("index.jsp");
    }
}
