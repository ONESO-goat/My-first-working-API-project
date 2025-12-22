from flask import request, Flask, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

notes = []

@app.route("/notes", methods=["GET"])
def get_notes():
    return jsonify(notes)




@app.route("/notes", methods=["POST"])
def make_notes():
    data = request.get_json()
    notes.append({
        "title": data["title"],
        "content": data["content"]
    })
    return jsonify({"message": "success creating the ntoe!"}), 201


if __name__ == "__main__":
    app.run(port=8000)
