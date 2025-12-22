const API_BASE = "http://localhost:8000";

const form = document.getElementById("noteForm");
const notesList = document.getElementById("notesList");

// Fetch all notes from backend
async function loadNotes() {
  const response = await fetch(`${API_BASE}/notes`);
  const notes = await response.json();

  notesList.innerHTML = "";
  notes.forEach(note => {
    const li = document.createElement("li");
    li.innerHTML = `<strong>${note.title}</strong><p>${note.content}</p>`;
    notesList.appendChild(li);
  });
}

// Send new note to backend
form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const title = document.getElementById("title").value;
  const content = document.getElementById("content").value;

  await fetch(`${API_BASE}/notes`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ title, content })
  });

  form.reset();
  loadNotes();
});

// Load notes on page load
loadNotes();
