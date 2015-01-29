<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!-- This import is necessary for JDBC -->
<%@ page import="java.sql.*"%>
<%@ page import="oracle.jdbc.pool.OracleDataSource"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="cs4111.form.userForm" %>


<%
    String realpath = request.getContextPath();
    List queryResult = null;    //VideoForm 列表
    if (request.getAttribute("list") != null) {
        queryResult = (List) request.getAttribute("list");
    }
    String fail = (String) request.getAttribute("fail");
    if(fail=="yes")
    {
    	out.print("<script>alert('wrong information! try it agian!');</script>");
    }
%>
<html>
<link href="<%=realpath%>/css/commonNew.css" rel="stylesheet" type="text/css">
<link href="<%=realpath%>/css/styleblue/css/mystyle.css" rel="stylesheet" type="text/css">
<link href="<%=realpath%>/character/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=realpath%>/character/css/button.css" rel="stylesheet"type="text/css" />
<script type="text/javascript" src="<%=realpath%>/js/ymPrompt/ymPrompt.js"></script>
<script src="<%=realpath%>/js/dialog/lhgcore.min.js" type="text/javascript"></script>
<script src="<%=realpath%>/js/dialog/lhgdialog.js" type="text/javascript"></script>

<head>
<title>test</title>
</head>

<body>

<html:form method="post" action="/login.do?method=queryUser">
<html:hidden property="username"/>
<html:hidden property="password"/>
    <input type="hidden" id="real_path" value="<%=realpath%>"/>

<table id="search" width="100%" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center"><h2 class="myh2">Login</h2></td>
    </tr>
</table>


 <table id="search_table" width="60%" align="center" class="font12blue mytablegray  tdbgcolor" cellpadding="0" cellspacing="0">
       <tr>&nbsp;</tr>


        <tr class="font12blue tdbgcolor">
        	<td colspan="3">Enter username and password!</td>
        </tr>
        <tr>
            <td width="50%"  align="center">Username</td>
             <td  align="center">
                 <input type="text" name="usernameText" style="width:100%; display:block;" />
            </td>
        </tr>
        <tr>
            <td width="50%"  align="center">Password</td>
            <td  align="center">
                <input type="text" name="passwordText" style="width:100%; display:block;" />
            </td>
        </tr>
        <tr>
               <td>
                <input type="button" value="login" class="btn_2k3" onmouseout="this.className='btn_2k3'"
                       onmouseover="this.className='btn3_mouseover'" onclick='login()'>
            </td>
        </tr>
    </table>
    
<script language="javascript">

    function login()
    {
    	//alert(document.getElementsByName("fname")[0].value);
    	if(document.getElementsByName("usernameText")[0].value=="")
    	{
    		alert("fill in username!");
    	}
    	if(document.getElementsByName("passwordText")[0].value=="")
    		{
    		alert("fill in password!");
    		}
    	if(document.getElementsByName("usernameText")[0].value!=""&&document.getElementsByName("passwordText")[0].value!="")
    	{
    	document.getElementsByName("username")[0].value=document.getElementsByName("usernameText")[0].value;
    	document.getElementsByName("password")[0].value=document.getElementsByName("passwordText")[0].value;
        document.forms[0].action = "<%=realpath%>/login.do?method=queryUser";
        document.forms[0].submit();
    	}
    }


</script>
</html:form>
</body>
</html>
