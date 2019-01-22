<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<html>
<head>
    <script> function validateForm() {
        if (document.frm.address.value == "") {
            alert("address should not be blank..");
            document.frm.address.focus();
            return false;
        } else if (document.frm.phone.value == "") {
            alert("phone number should not be blank");
            document.frm.phone.focus();
            return false;
        }
    } </script>
</head>
<body>
<form name="frm" method="get" action="/secret" onSubmit="return validateForm()">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="22%"></td>
            <td width="78%"></td>
        </tr>
        <tr>
            <td>Enter your address</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Enter your phone number</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>

