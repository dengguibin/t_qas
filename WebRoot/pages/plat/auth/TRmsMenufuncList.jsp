<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-5-20 15:03:20
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsMenufunc";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.funcid="+args+"&v="+Math.random();
			if('update' === opCode || 'add' === opCode){
				baseUrl += "!toEdit.action"+query+"&bean.cdid="+$("#cdid").val();
				$.dialog({
				lock: true, 
				max: false, 
    			min: false ,
				title:'编辑菜单功能',
				width:'640px',
				height:'480px',
				content: 'url:'+baseUrl});
			}else if('remove' === opCode){
				var ids = '';
				//单条删除操作
				if(args && $.trim(args) != ''){
					ids = args;
				}else{
					//选择批量删除操作
					if($(".chk:checked").size() > 0){
						$(".chk:checked").each(function(){
							ids += ","+$(this).val();
						});
					}
					//删除第一个","号
					ids = ids.substring(1);
				}
				if( $.trim(ids) != ''){
					$.dialog.confirm('你确定要删除选中的数据吗?', function(){
					    query = "?bean.fcname="+ids;
						baseUrl += "!remove.action"+query;
						$.getJSON(baseUrl,{},function(data){
							if(data && data.status == '1'){
								opreate('','query');
							}else if(data && data.status == '2'){
							     alert(data.message);
							}else{
								alert('删除数据失败!');
							}
						});
					}, function(){
					    $.dialog.tips('执行取消操作');
					});
				}else{
					$.dialog.alert('请选中需要删除的行数据!');
				}
			}else if('queryInfo' === opCode){
				baseUrl += "!queryInfo.action";
				$("#funcid").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
		
	//下拉输入的效果	
	$(function(){
	  $('#select9').select2({
	  	 /* tags: "true" 如果要输入*/
	  });
	})
//-->
</script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="dataGrid">	
<form action="${ctx}/plat/auth/tRmsMenufunc!queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.cdid" id="cdid" />
<!--	
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>功能名称：</th>
                <td><s:textfield name="bean.fcname" cssClass="inputText"></s:textfield></td>
                <td>
                <th>权限码：</th>
                <td>
                 <select class="select2" name="bean.code" >
                 	<option value=''>--请选择--</option>
				    <c:forEach var="item" items="${perms }">
				    	<option value="${item.id }" ${ item.id eq bean.code ? 'selected' : ''  } >${item.name }[${item.id }]</option>
				    </c:forEach>
					</select>
                </td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div>
 -->			
		<!--filter end-->
		
	
		
		<div class="formtitle2"><A>${menu.menuName }功能清单</a>
			<div class="tools">
			<ul class="toolbar">
			<c:if test="${qx.add }"><li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li></c:if>
	          <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
	        </ul>
		</div><!--tools end-->
		</div>	
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>功能名称</th>
                <th>权限码</th>
                <th>权限名称</th>
                <th>功能连接地址</th>
                <th>功能描述</th>
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.NAME}</td>
                   	<td>&nbsp;${item.CODE}</td>
                   	<td>&nbsp;${item.QXMC}</td>
                   	<td>&nbsp;${item.URL}</td>
                   	<td>&nbsp;${item.DESCRIP}</td>
                 	 <c:if test="${qx.update or qx.delete}">
                 	 <td style='width:120px;'>&nbsp;
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.FUNCID }','update');">修改</a></c:if>
                 	 	<c:if test="${qx.delete}"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.FUNCID }','remove');">删除</a></c:if>
                 	 </td>
                 	 </c:if>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
</form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
