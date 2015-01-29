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
<%@ page import="cs4111.form.episodeForm" %>


<%
    String realpath = request.getContextPath();
    List queryResult = null;    //VideoForm 列表
    if (request.getAttribute("list") != null) {
        queryResult = (List) request.getAttribute("list");
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
<html:form method="post" action="/episode.do?method=queryEpisode">
    <html:hidden property="ep_name"/>
    <input type="hidden" id="real_path" value="<%=realpath%>"/>

<table id="search" width="100%" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center"><h2 class="myh2">Episode</h2></td>
    </tr>
</table>


 <table id="search_table" width="100%" align="center" class="font12blue mytablegray  tdbgcolor" cellpadding="0" cellspacing="0">
        <tr class="font12blue tdbgcolor">
        	<td colspan="3">This Page includes the information for episode!</td>
        </tr>
        <tr class="gridviewheadertall">
            <td width="20%"  align="center">Search Way</td>
            <td width="60%"  align="center">Key word</td>
            <td width="20%"  align="center">Search!</td>
        </tr>
        <tr>
            <td  align="center">
                Episode name
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
        <td align="center" bgcolor="#cccccc">Episode id </td>
        <td align="center" bgcolor="#cccccc">Episode name</td>
        <td align="center" bgcolor="#cccccc">Season id</td>
        <td align="center" bgcolor="#cccccc">Brief Introduction</td>
        <td align="center" bgcolor="#cccccc">Script</td>
        <td align="center" bgcolor="#cccccc">Video</td>
    </tr>
    <%
    if(queryResult!=null)
    {
        for (int i = 0; i < queryResult.size(); i++) {

            episodeForm tempForm = (episodeForm) queryResult.get(i);
    %>
      <tr>
        <td align="center"><%=tempForm.getEp_id()%>
        </td>
        <td align="center"><%=tempForm.getEp_name()%>
        </td>
        <td align="center"><%=tempForm.getSeason_id()%>
        </td>
        <td align="center"  width="60%"><%=tempForm.getSynopsis()%>
        </td>
        <td>
        <a href="<%=tempForm.getScript_link()%>" target="_blank">LINK</a>
        </td>
                <td>
        <a href="<%=tempForm.getVideo_link()%>" target="_blank">LINK</a>
                </td>

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
    form.action = "<%=realpath%>/episode.do?method=queryEpisode&currentPage=" + currentPage;
    form.submit();
	}

    function searchVideo()
    {
    	//alert(document.getElementsByName("fname")[0].value);
    	document.getElementsByName("ep_name")[0].value=document.getElementsByName("fname")[0].value;
        document.forms[0].action = "<%=realpath%>/episode.do?method=queryEpisode";
        document.forms[0].submit();
    }


</script>
</html:form>
</body>
</html>
