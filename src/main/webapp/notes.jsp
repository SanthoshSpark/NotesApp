<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="note.Note" %>

<%
    // Initialize notes list if not already in session
    List<Note> notes = (List<Note>) session.getAttribute("notes");
    if (notes == null) {
        notes = new ArrayList<>();
        session.setAttribute("notes", notes);
    }
%>

<% for (Note note : notes) { %>
    <div class="note">
        <h3><%= note.getTitle() %></h3>
        <p><%= note.getContent() %></p>
        <form action="DeleteNoteServlet" method="post" style="display:inline;">
            <input type="hidden" name="title" value="<%= note.getTitle() %>">
            <button type="submit">Delete</button>
        </form>
        <form action="EditNoteServlet" method="post" style="display:inline;">
            <input type="hidden" name="title" value="<%= note.getTitle() %>">
            <input type="hidden" name="content" value="<%= note.getContent() %>">
            <button type="submit">Edit</button>
        </form>
    </div>
<% } %>
