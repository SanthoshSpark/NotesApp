<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notes Application</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Notes</h1>
    <div id="notes-list">
        <!-- Notes will be displayed here -->
        <jsp:include page="notes.jsp"/>
    </div>
    <h2>Add Note</h2>
    <form action="AddNoteServlet" method="post">
        <input type="text" name="title" placeholder="Title" required>
        <textarea name="content" placeholder="Content" required></textarea>
        <button type="submit">Add Note</button>
    </form>
</body>
</html>
