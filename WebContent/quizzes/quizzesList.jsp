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
<%@ page import="cs4111.form.quizzesForm" %>


<%
    String realpath = request.getContextPath();
    List queryResult = null;    //VideoForm 列表
    if (request.getAttribute("list") != null) {
        queryResult = (List) request.getAttribute("list");
    }
    String currentPage = (String) request.getAttribute("currentPage");
	if(currentPage=="2")
	{
		out.print("<script>alert('Congratulations! Correct Answer!');</script>");
	}
	if(currentPage=="3")
	{
		out.print("<script>alert('Sorry! Your answer is wrong!');</script>");
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
<table width="100%" align="center" cellpadding="0" cellspacing="0">
<tr class="font12blue sortable mytablegray " style="border-collapse:collapse" align="center">
	<td><a href="<%=realpath%>/music/musicList.jsp"><font size=4>Music</font></a></td>
	<td><a href="<%=realpath%>/episode/episodeList.jsp"><font size=4>Episode</font></a></td>
	<td><a href="<%=realpath%>/character/characterList.jsp"><font size=4>Character</font></a></td>
	<td><a href="<%=realpath%>/cast/castList.jsp"><font size=4>Cast</font></a></td>
	<td><a href="<%=realpath%>/season/seasonList.jsp"><font size=4>Season</font></a></td>
	<td><a href="<%=realpath%>/director/directorList.jsp"><font size=4>Director</font></a></td>
	<td><a href="<%=realpath%>/quizzes/quizzesList.jsp"><font size=4>Quizzes</font></a></td>
	<td><a href="<%=realpath%>/quizzes/referenceList.jsp"><font size=4>Reference</font></a></td>
	<td><a href="<%=realpath%>/rank/rankList.jsp"><font size=4>Ranks</font></a></td>
</tr>
</table>
<html:form method="post" action="/quizzes.do?method=queryQuizzes">
    <html:hidden property="quiz_no"/>
    <html:hidden property="correct_answer"/>
    <input type="hidden" id="real_path" value="<%=realpath%>"/>

<table id="search" width="100%" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center"><h2 class="myh2">Quizzes</h2></td>
    </tr>
</table>


 <table id="search_table" width="100%" align="center" class="font12blue mytablegray  tdbgcolor" cellpadding="0" cellspacing="0">
        <tr class="font12blue tdbgcolor">
        	<td colspan="3">This Page includes the information for Quizzes!</td>
        </tr>
        <tr class="gridviewheadertall">
            <td width="20%"  align="center">Search Way</td>
            <td width="60%"  align="center">Key word</td>
            <td width="20%"  align="center">Search!</td>
        </tr>
        <tr>
            <td  align="center">
                Quizzes No.
            </td>
            <td  align="center">
                <input type="text" name="fname" style="width:100%; display:block;" />
            </td>
            <td  align="center">
                <input type="button" value="Search" class="btn_2k3" onmouseout="this.className='btn_2k3'"
                       onmouseover="this.className='btn3_mouseover'" onclick='searchVideo()'>
            </td>

        </tr>
    </table>
    
    <table id="tblSort" width="100%"  class="font12blue sortable mytablegray " cellpadding="0" cellspacing="0" style="border-collapse:collapse">
    <tr id="tablehead">
        <td align="center" bgcolor="#cccccc">No.</td>
        <td align="center" bgcolor="#cccccc">Topic</td>
        <td align="center" bgcolor="#cccccc">Question</td>
        <td align="center" bgcolor="#cccccc">AnswerA</td>
        <td align="center" bgcolor="#cccccc">AnswerB</td>
        <td align="center" bgcolor="#cccccc">&nbsp;</td>
        <td align="center" bgcolor="#cccccc">&nbsp;</td>
    </tr>
    <%
    if(queryResult!=null)
    {
        for (int i = 0; i < queryResult.size(); i++) {

            quizzesForm tempForm = (quizzesForm) queryResult.get(i);
    %>
      <tr>
        <td align="center"><%=tempForm.getQuiz_no()%>
        </td>
        <td align="center"><%=tempForm.getTopic()%>
        </td>
        <td align="center"><%=tempForm.getQuestion()%>
        </td>
        <td align="center" width="10%"><%=tempForm.getAnswera()%>
        </td>
        <td align="center" width="10%"><%=tempForm.getAnswerb()%>
        </td>
        <td align="center"><input type="button" class="btn_2k3" onmouseout="this.className='btn_2k3'"
                                  onmouseover="this.className='btn3_mouseover'"
                                  onclick="validateA('<%=tempForm.getQuiz_no()%>')" value="answer is A"
                />
         <td align="center"><input type="button" class="btn_2k3" onmouseout="this.className='btn_2k3'"
                                  onmouseover="this.className='btn3_mouseover'"
                                  onclick="validateB('<%=tempForm.getQuiz_no()%>')" value="answer is B"
                />
      <tr>
    <%
        }
    }
    %>
</table>

<script language="javascript">
	function doQuery(currentPage)
	{
    var form = document.forms[0];
    form.action = "<%=realpath%>/quizzes.do?method=queryQuzzies&currentPage=" + currentPage;
    form.submit();
	}

    function searchVideo()
    {
    	//alert(document.getElementsByName("fname")[0].value);
    	document.getElementsByName("quiz_no")[0].value=document.getElementsByName("fname")[0].value;
    	document.getElementsByName("correct_answer")[0].value = null;
        document.forms[0].action = "<%=realpath%>/quizzes.do?method=queryQuizzes";
        document.forms[0].submit();
    }
    
    function validateA(quzz_no)
    {
    	document.getElementsByName("quiz_no")[0].value = quzz_no;
    	document.getElementsByName("correct_answer")[0].value = 'A';
        document.forms[0].action = "<%=realpath%>/quizzes.do?method=answerQuizzes";
        document.forms[0].submit();
    }
    
    function validateB(quzz_no)
    {
    	document.getElementsByName("quiz_no")[0].value = quzz_no;
    	document.getElementsByName("correct_answer")[0].value = 'B';
        document.forms[0].action = "<%=realpath%>/quizzes.do?method=answerQuizzes";
        document.forms[0].submit();
    }


</script>
</html:form>
</body>
</html>
