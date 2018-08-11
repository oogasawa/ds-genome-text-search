<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

<table>

<c:forEach var="resultInfo" items="${resultInfoList}">
<tr>
<td width="150" align="left">
<a href="${resultInfo.jbrowseUrl}">
<img src="/static/images/506708890-612x612.jpg" width="30" height="30" />
</a>
</td>
<td>${resultInfo.seqid}</td>
<td>${resultInfo.source}</td>
<td>${resultInfo.type}</td>
<td>${resultInfo.start}</td>
<td>${resultInfo.end}</td>
<td>${resultInfo.score}</td>
<td>${resultInfo.strand}</td>
<td>${resultInfo.phase}</td>
<td>${resultInfo.attributes}</td>
</tr>

</c:forEach>

</table>

</div>