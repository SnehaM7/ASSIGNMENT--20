<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h1>Student Form</h1>
    <form action="students" method="post">
        <input type="hidden" name="action" value="insert">
        <table>
            <tr>
                <td>Student ID:</td>
                <td><input type="text" name="studentId" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Insert" onclick="this.form.action.value='insert';" />
                    <input type="submit" value="Fetch" onclick="this.form.action.value='fetch';" />
                    <input type="submit" value="Update" onclick="this.form.action.value='update';" />
                    <input type="submit" value="Delete" onclick="this.form.action.value='delete';" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
