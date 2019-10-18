<%--
  Created by IntelliJ IDEA.
  User: mbeta
  Date: 18.10.2019
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST File Upload</title>
</head>
<body>
<form method="POST" action="/SpringRestExample/api/rest/employee-management/employees/1/photo/multiple"
      enctype="multipart/form-data">
    <table>
        <tr>
            <td>Select first file to upload</td>
            <td><input type="file" name="files" /></td>
        </tr>
        <tr>
            <td>Select second file to upload</td>
            <td><input type="file" name="files" /></td>
        </tr>
        <tr>
            <td>Select third file to upload</td>
            <td><input type="file" name="files" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
