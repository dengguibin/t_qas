<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		<table border="1">
			<tr>
			  <#list headTable as headColumn>						
				<th>${headColumn!''}</th>	
			  </#list> 
			</tr>
		  <#list detailList as detail>					
			<tr>
			  <#list detail as detailColumn>						
				<td>${detailColumn!''}</td>	
			  </#list>
			</tr>
		  </#list>
	   </table>
	</body>
</html>