<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/plat/frame/header.jsp" %>
<script>
/*
$(document).ready(function(){
		$("#dataTable").chromatable({
				width: "100%",
				height: "450px",
				scrolling: "yes"
				
			});	
	});
*/

</script>
<STYLE>
</STYLE>
<body >
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<x:page var="datas" stmt="plat.test" params="${bean}" ></x:page>
<div class="tabBlock">	
		<div class="editBlock">
		<form action="${ctx}/plat/auth/tRmsAppinfo!list.action" method="post">
		  <table>
            <tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                <th width="120">地区分公司：</th>
                <td><select name="city" id="city">
                  <option>----请选择分公司----</option>
				  <option>广东省公司</option>
				  <option>广州分公司</option>
                </select></td>
                <th width="120">集团名称：</th>
                <td><input type="text" class="inputText" name="textfield22" /></td>
              </tr>
              <tr>
                <th>集团代码：</th>
                <td><input type="text" class="inputText" name="textfield2" /></td>
                <th width="120">集团状态：</th>
                <td><select name="city" id="city">
                  <option>-----请选择状态-----</option>
				  <option>报停</option>
				  <option>欠费拆机</option>
                </select></td>
              </tr>
			  <tr>
                <th width="120">短信代码：</th>
                <td><input type="text" class="inputText" name="textfield2"  /></td>
                <th width="120">排序：</th>
                <td><select name="select" id="select">
                  <option>---请选择排序方式--</option>
                  <option>时间</option>
                  <option>集团代码</option>
				  <option>短信代码</option>
                </select></td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;"><input name="button" type="button" class="inputButton" value=" 查 询 " />                </td>
              </tr>
            </tbody>
          </table>
          </form>
		</div>
		<div class="dataGrid">
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th width="160">集团代码</th>
                <th width="200">短信代码</th>
                <th width="200">集团名称</th>
                <th width="200">发展人</th>
                <th width="50">联系人</th>
				<th width="80">联系电话</th>
				<th width="80">建档时间</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
	                <td>&nbsp;${item.CHITEMNAME }</td>
	                <td>&nbsp;${item.CHREQUIREMENTS }</td>
	                <td>&nbsp;${item.CHMETHOD }</td>
	                <td>&nbsp;${item.CHBASIS }</td>
	                <td>&nbsp;${item.CHECKITEMCODE }</td>
	                <td>&nbsp;<input type="checkbox"></td>
	            	<td>&nbsp;</td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/plat/frame/page.jsp" %> 
  </div>
</div>
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>