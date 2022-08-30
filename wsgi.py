from flask import Flask, render_template, url_for

app = Flask(__name__)


@app.route("/loss")
def petsloss():
    return render_template("form_pet_loss.html")


@app.route("/find")
def petsfind():
    return render_template("form_pet_find.html")


with app.test_request_context():
    url_for('static', filename='form_pet_loss.css')
    url_for('static', filename='form_pet_find.css')
