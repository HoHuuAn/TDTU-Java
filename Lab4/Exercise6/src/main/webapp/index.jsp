<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Exercise6</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 400px;
        }

        input, select, textarea {
            box-sizing: border-box;
        }

        input[type="text"], select {
            height: 24px;
        }

        td {
            padding: 4px;
        }
    </style>
</head>
<body>

<form method="post" action="/register">
    <table class="table table-striped table-borderless">
        <tr>
            <td>Your Name</td>
            <td>
                <input name="name" type="text" style="width: 200px" placeholder="Full Name">
            </td>
        </tr>
        <tr>
            <td>Email Address</td>
            <td><input name="email" type="text" style="width: 200px" placeholder="Email"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input name="birthday" type="date" style="width: 200px"></td>
        </tr>
        <tr>
            <td>Birthtime</td>
            <td><input name="birthtime" type="time" style="width: 200px"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" value="male" name="gender"> Male
                <input type="radio" value="female" name="gender"> Female
            </td>
        </tr>
        <tr>
            <td>From</td>
            <td>
                <select name="country" style="width: 200px">
                    <option>Select a country</option>
                    <optgroup label="Asia">
                        <option>Vietnam</option>
                        <option>Laos</option>
                        <option>Cambodia</option>
                        <option>Singapore</option>
                    </optgroup>
                    <optgroup label="Europe">
                        <option>France</option>
                        <option>Belgium</option>
                        <option>Italy</option>
                        <option>Finland</option>
                        <option>Ireland</option>
                    </optgroup>
                </select>
            </td>
        </tr>
        <tr>
            <td style="vertical-align: text-top">Favorite IDE</td>
            <td>
                <div><input type="checkbox" name="favorite_ide[]" value="Visual Studio Code"> Visual Studio Code</div>
                <div><input type="checkbox" name="favorite_ide[]" value="Sublime Text"> Sublime Text</div>
                <div><input type="checkbox" name="favorite_ide[]" value="Eclipse"> Eclipse</div>
                <div><input type="checkbox" name="favorite_ide[]" value="Atom"> Atom</div>
                <div><input type="checkbox" name="favorite_ide[]" value="Intelij Idea"> Intelij Idea</div>
            </td>
        </tr>
        <tr>
            <td>TOEIC Score</td>
            <td><input name="toeic" type="range" style="width: 200px" min="5" max="990" step="5"></td>
        </tr>
        <tr>
            <td style="vertical-align: text-top">Message</td>
            <td>
                <textarea name="message" rows="5" style="width: 200px"></textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Register</button>
                <button type="reset">Again</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>