<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/dTasks.css" />
<script type="text/javascript" src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/select2-master/dist/js/select2.min.js" ></script>
<body class="layer_btn">
	<div class="title clear">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" /> &gt; 
		<c:choose>
			<c:when test="${diagnosetask==null}">新增任务</c:when>
			<c:otherwise>修改</c:otherwise>
		</c:choose>
		<span class="right return-box" onclick="self.location=document.referrer;">
			<i class="return-icon icon"></i>
			<a class="return" href="javascript:">返回</a> 
		</span>
	</div>
	<s:hidden id="_ids"></s:hidden>
	<div class="wrapper d-tasks-m">
		<!--<div class="top">
			<div class="configure clear">
				<div class="left return" onclick="self.location=document.referrer;">
					<i class="return-icon icon"></i>
					<a class="return" href="javascript:">返回</a> 
				</div>
			</div>
		</div>-->

		<div class="d-t-m-con">
		
			<form id="saveTask" name="saveTask" action="${ctx}/diagnose/diagnoseTask/save.action" method="post">
			<s:token></s:token>
			<s:hidden name="menuId" id="menuId" />
			<s:hidden name="diagnosetask.id" value="%{#request.diagnosetask.id }" id="diagnosetaskid"/>
			<s:hidden name="diagnosetaskobj.diagnoseobjid" id="taskObjid"></s:hidden>
			<s:hidden name="idsCopy" id="idsCopy"></s:hidden>
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>任务名称：</label>
					</div>
					<div class="row-r">
						<input type="text" class="inputxt" name="diagnosetask.taskname" placeholder="请填写任务名称" value="${diagnosetask.taskname }" datatype="*" nullmsg="请输入任务名称！"/>
					</div>
				</div>
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>模型类型：</label>
					</div>
					<div class="row-r in-radio ">
						<span class="add-radio">	
							<s:hidden id="type" value="%{#request.type }"></s:hidden>
							<input type="hidden" name="diagnosetaskobj.diagnoseobjidtype" id="types">
							<x:cache subject="SCHEMETYPEOBJ" var="types"></x:cache>
							<c:forEach items="${ types}" var="t" >
							<label><input name="type" type="radio" value="${t.subcode }" onclick="getSelectType()"  <c:if test='${type eq t.subcode}'>checked='checked'</c:if> >${t.cname } </label> 
							<%--<label><input name="type" type="radio" value="${t.subcode }" onclick="getSelectType()"  <c:if test='${type eq t.subcode or } '>checked='checked'</c:if> >${t.cname } </label> 
							--%></c:forEach>
						</span>
					</div>
				</div>
			
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>可视角色：</label>
					</div>
					<div class="row-r in-radio ">
						<span class="add-radio">	
							<!-- <input type="hidden" name="diagnosetask.roleid" id="roleid"> -->
							<%-- <x:cache subject="SCHEMETYPEOBJ" var="types"></x:cache> --%>
							<s:hidden id="roleid" value="%{#request.diagnosetask.roleid }"></s:hidden>
							<c:forEach items="${roleList}" var="t" >
							<label>
							<input name="diagnosetask.roleid" type="checkbox" value="${t.JSID}" 
							<%-- <s:if test="roleid.contains('${t.JSID}')"> checked='checked'</s:if>   --%>
							 placeholder="请重新选择可视角色！" datatype="*" nullmsg="请重新选择可视角色！">${t.JSMC}
							</label> 
							</c:forEach>
						</span>
					</div>
				</div>	
			
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>诊断模型：</label>
					</div>
					<div class="row-r">
						<s:hidden id="schemeid" value="%{#request.diagnosetask.schemeid}"></s:hidden>
						<select class="select" id="d_t_m_type" name="diagnosetask.schemeid" style="width: 300px;">
						</select>
					</div>
				</div>
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>诊断对象：</label>
					</div>
					<div class="row-r">
						<span class="d-t-m-obox">
							<input type="text" class="inputxt" id="d-t-obj" value="${diagnosetaskobj.diagnoseobjname}" placeholder="请填写诊断对象" datatype="*" nullmsg="请选择诊断对象！"/>
							<!-- <span class="icon-box">
								<i  class="icon dia-obj"></i>
							</span> -->
						</span>
					</div>
				</div>
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>等级设置：</label>
					</div>
					<div class="row-r">
						<table style="table-layout: fixed;width: 90%;" class="d-t-m-table" id="level_list">
							<thead>
								<tr>
									<th width="33%">
										等级名称
									</th>
									<th width="33%">
										等级范围
									</th>
									<th width="33%">
										操作
									</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
								<c:when test="${diagnosetasklevels!=null}">
									<c:forEach items="${diagnosetasklevels}" var="item"  varStatus="stat">
										<c:choose>
											<c:when test="${stat.index==0}">
												<tr class="be-add item">
													<td width="33%">
														<input type="text"class="inputxt" value="${item.tasklevel }" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字"/>
													</td>
													<td width="33%">
														<input type="text" class="table-input" value="${item.leftvalue }" datatype="leftvalue" nullmsg="等级范围不可有空值！" errormsg="数值范围必须为数字且符合判断"/>
														<span>≤x≤</span>
														<input type="text" class="table-input" readonly = "readonly" value="100"/>
													</td>
													<td width="33%">
													</td>
												</tr>
											</c:when>
											<c:when test="${stat.index< fn:length(diagnosetasklevels)-1&&stat.index>0}">
												<tr class="be-add item">
													<td width="33%">
														<input type="text" class="inputxt" value="${item.tasklevel }" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字"/>
													</td>
													<td width="33%">
														
														<input type="text" class="table-input" value="${item.leftvalue }"  datatype="leftvalue" nullmsg="等级范围不可有空值！" errormsg="数值范围必须为数字且符合判断"/>
														<span>≤x<</span>
														<input type="text" class="table-input" value="${item.rightvalue }"  datatype="*" nullmsg="等级范围不可有空值！"/>
													</td>
													<td width="33%">
														<span class="d-t-m-d" onclick="deleteLevel(this)">删除</span>
													</td>
												</tr>
											</c:when>
											<c:when test="${stat.index== fn:length(diagnosetasklevels)-1}">
												<tr id="foo" class="item">
													<td width="33%">
														<input type="text" class="inputxt" value="${item.tasklevel }"  datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字"/>
													</td>
													<td width="33%">
														<input type="text" class="table-input" readonly = "readonly" value="0"/>
														<span>≤x<</span>
														<input type="text" class="table-input" value="${item.rightvalue }"  datatype="*" nullmsg="等级范围不可有空值！"/>
													</td>
													<td width="33%">
														
													</td>
												</tr>
											</c:when>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class="item">
										<td width="33%">
											<input type="text" class="inputxt" value="1" readonly="readonly" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字" name="index"/>
										</td>
										<td width="33%">
											<input type="text" class="table-input"  datatype="leftvalue" nullmsg="等级范围不可有空值！" errormsg="数值范围必须为数字且符合判断"/>
											<span>≤X≤</span>
											<input type="text" class="table-input" readonly = "readonly" value="100"/>
										</td>
										<td width="33%">
											
										</td>
									</tr>
									<tr class="be-add item">
										<td width="33%">
											<input type="text" class="inputxt"  value="2" readonly="readonly" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字" name="index"/>
										</td>
										<td width="33%">
											
											<input type="text" class="table-input" datatype="leftvalue" nullmsg="等级范围不可有空值！" errormsg="数值范围必须为数字且符合判断"/>
											<span>≤X<</span>
											<input type="text" class="table-input" datatype="*" nullmsg="等级范围不可有空值！"/>
										</td>
										<td width="33%">
											<span class="d-t-m-d" onclick="deleteLevel(this)">删除</span>
										</td>
									</tr>
									<tr id="foo" class="item">
										<td width="33%">
											<input type="text" class="inputxt" value="3" readonly="readonly" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字" name="index"/>
										</td>
										<td width="33%">
											<input type="text" class="table-input" readonly = "readonly" value="0"/>
											<span>≤X<</span>
											<input type="text" class="table-input" datatype="*" nullmsg="等级范围不可有空值！" />
										</td>
										<td width="33%">
											
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
						
						<div class="d-t-m-add">
							<span class="d-t-m-d" onclick="addLevel()"> + 添加</span>
						</div>
					</div>
				</div>
				<div class="row clear">
					<div class="row-l">
						<label>自动诊断频率：</label>
					</div>
					<div class="row-r">
						<%--<select class="select" id="d_t_m_diagnosis" style="width: 230px;" disabled="disabled" class="disabled">--%>
						<select class="select" id="d_t_m_diagnosis" name="diagnosetask.frequency" style="width: 230px;" class="disabled">
							<option value="0">按月诊断</option>
							<option value="1">按学期诊断</option>
							<option value="2">按周诊断</option>
							<option value="3">按学年诊断</option>
						</select>
					</div>
				</div>
	
				<div class="row clear">
					<div class="row-l">
						<i class="must"></i>
						<label>执行时段：</label>
					</div>
					<div class="row-r">
						<input type="text" onClick="new WdatePicker()" placeholder="" name="diagnosetask.starttime" class="date" datatype="*" nullmsg="执行时段不可为空！" 
						value="<fmt:formatDate  value="${diagnosetask.starttime }" type="date" pattern="yyyy-MM-dd" />"/>
						<span class="date-pad">至</span>
						<input type="text" onClick="new WdatePicker()" placeholder="" name="diagnosetask.endtime" class="date"  datatype="*" nullmsg="执行时段不可为空！"
						value="<fmt:formatDate  value="${diagnosetask.endtime }" type="date" pattern="yyyy-MM-dd" />"/>
					</div>
				</div>
				
				<div class="btn-s-c">
					<input type="button" class="sumbit" value="提交" onclick="savaData()">
					<input type="button" class="cancel" value="取消" onclick="self.location=document.referrer;">
				</div>	
			</form>
		</div>

	</div>
	<script>
			$(document).ready(function() {
				var schemeid = $("#schemeid").val().trim();
				getSelectType(schemeid);
				var len = $(".row-r").find("table tbody tr").length;
				autoSetRightValue();
				var _w = $(".inputxt").innerWidth();
				var _w_2 = _w - 2;
				var _w_input = _w_2 - 6 * 2;
				$(".d-t-m-table").css("width",_w + "px");
				$(".d-t-m-obox").css("width",_w_2 + "px");
				$(".d-t-m-obox .inputxt").css("width",_w_input + "px");
				
				//校验
				saveTask = $("#saveTask").Validform({
					tiptype:function(msg){
						layer.msg(msg, {
							icon: 2,
							time:2500//1.5s后关闭
						});
					},
					tipSweep:true,
					postonce:false,
					datatype:{
						"leftvalue"	:function(gets,obj,curform,regxp){
							if(!regxp.n.test(gets)){return false;}
							if(parseInt(gets)>=parseInt($(obj).next().next().val())){return false;}
							return true;
						}
					}
				});
				//诊断方案 下拉框
//				$("#d_t_m_type").select2({
//					width:'resolve',
//				});
//				$("#d_t_m_diagnosis").select2({
//					width:'resolve',
//				});
				
				//添加按钮
//				$(".d-t-m-add .d-t-m-d").click(function(){
//					var html = _html.clone();
//					$(".d-t-m-table tbody tr").eq(-2).after(_html);
//					html.insertBefore("#foo");
//					autoSetRightValue();
//				})
				
				//选择诊断对象
				var nodeCopy;
				$(".d-t-m-con").on("click","#d-t-obj",function(){
					var tasktype = $("input[name='type']:checked").val();
					//取出复选框的角色ID值（多个id以“,”分割）
					obj = document.getElementsByName("role");
				    check_val = [];
				    for(k in obj){
				        if(obj[k].checked)
				            check_val.push(obj[k].value);
				    }
					var roleStr = check_val.join(",");
					
					debugger;
					if(tasktype){
						if(tasktype == "5"){
							var title = "学院";
						}else if(tasktype == "6"){
							var title = "专业";
						};
						debugger;
						layer.open({
						  	type: 2,
						  	
						  	title: '<i class="s_logo"></i>请选择' + title,
						  	shadeClose: true,
						  	shade: 0.4,
						  	area: ['600px','420px'],
						  	btn:["确定","关闭"],
						  	yes:function(index, layero){
					  			var body = layer.getChildFrame('body', index);
					  	   	    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
					  	 	    var nodes =iframeWin.getCheckNodes();//该变量装有诊断对象的id和名称以及其父类的id和名称
					  	 	    nodeCopy=nodes;//相当于是复制了一份
				  	 	    
				  	 	    	debugger;
					  	 	    for(var i=0;i<nodes.length;i++){
		           				    if(nodes[i].isParent==true){
		             			    /*  node.majorname+=nodes[i].majorname+","; */
		             			    //node.push(nodes[i].majorname+nodes[i].id);
		             			    
		               			    nodes.splice(i,1);////遍历剔除该变量里的父类的id和名称
		          	  				}
		          	  			};
								var names =[];
								var ids =[];
								for (var i in nodes){//该变量仅装有诊断对象的id和名称，遍历取名称
		    						names.push(nodes[i].majorname);
		    					};
		    					for (var i in nodes){//该变量仅装有诊断对象的id和名称，遍历取id
		    						ids.push(nodes[i].id);
		    					};
	    					
	    						var idsCopy=[];
		    					for (var i in nodeCopy){//该变量装有诊断对象的id和名称以及其父类的id和名称
		    						idsCopy.push(nodeCopy[i].id);//遍历取父类id和子类对象id装进数组 
		    					};
	    						$("#idsCopy").val(idsCopy.join(','));//向隐藏文本域中赋值
	    					
								$("#d-t-obj").val(names.join(','));
								$("#taskObjid").val(ids.join(','));
				  			},
						  	content: '${ctx }/diagnose/diagnoseTask/Professional.action' //iframe的url
						}); 
					}else{
						layer.msg("请先选择模型类型", {
							icon: 2,
							time:2500//1.5s后关闭
						});
					}
					
				});
				
			});
			
			//保存数据
			function savaData() {
				debugger;
	            var count = $(".item").length;
	            $(".item").each(function(index, value) {
	                $(value).find("input").eq(0).attr("name", "diagnosetasklevels[" + index + "].tasklevel");
	                $(value).find("input").eq(1).attr("name", "diagnosetasklevels[" + index + "].leftvalue");
	                $(value).find("input").eq(2).attr("name", "diagnosetasklevels[" + index + "].rightvalue");
	            });
	            
	            $("#saveTask").submit();
	            return false;
	        };
	        
	        //删除登记设置
	        function deleteLevel(obj){
	        	$(obj).parent().parent().remove();
	        	var length = $("#level_list").find("tbody").find("tr").length;
	        	for(var i = 0; i < length; i++){
	        		$("#level_list").find("tbody").find("tr").eq(i).find("input[name='index']").val(i + 1);
	        	}
	        	autoSetRightValue();
	        }
	        
	        function addLevel(){
	        	var length = $("#level_list").find("tbody").find("tr").length;
	        	if(length < 5){
	        		var html = '<tr class="be-add item">'+
								'<td width="33%">'+
									'<input type="text" class="inputxt"  value="' + (length ) + '" readonly="readonly" datatype="n" nullmsg="等级名称不可有空值！" errormsg="等级名称必须为数字" name="index"/>'+
								'</td>'+
								'<td width="33%">'+
									'<input type="text" class="table-input" datatype="leftvalue" nullmsg="等级范围不可有空值！" errormsg="数值范围必须为数字且符合判断"/>'+
									'<span>≤x<</span>'+
									'<input type="text" class="table-input" datatype="*" nullmsg="等级范围不可有空值！"/>'+
								'</td>'+
								'<td width="33%">'+
									'<span class="d-t-m-d" onclick="deleteLevel(this)">删除</span>'+
								'</td>'+
							'</tr>';
					$("#foo").before(html);
					$("#foo").find("input[name='index']").val(length + 1);
				
	        	}else{
		        	layer.msg("设置级别最大个数为5", {
								icon: 2,
								time:2500//1.5s后关闭
							});
	        	};
	        	autoSetRightValue();
	        	
	        }
			
		
			
			///自动填充分值范围右值
		    function autoSetRightValue() {
		        $(".item").each(function(index, value) {
		            if (index < ($(".item").length - 1)) {
		                $(value).find("input[disabled!='disabled']").eq(1).blur(function() {
		                    $(value).next().find("input[disabled!='disabled']").eq(2).val($(this).val());
		                });
		            }
		        });
		    };
		    
		 
		</script>
		<script>
				function getSelectType(schemeid){
				var type = $("input[name='type']:checked").val()
				$("#types").val(type);
				
				$.get('${ctx}/diagnose/diagnosescheme/getSelectType.action',{"diagnose.rangetype":type},function(result){
					var list = result.obj;
					var option = "";
					for(var i in list){
						if(schemeid == list[i].id){
							option +="<option value='"+list[i].id+"' selected='selected' >"+list[i].schemename+"</option>"
						}else{
							option +="<option value='"+list[i].id+" '>"+list[i].schemename+"</option>"
						}
					};
					$("#d_t_m_type").empty();
					if(!schemeid){
						$("#d-t-obj").val("");
					}
					$("#d_t_m_type").append(option);
					//诊断方案 下拉框
					$("#d_t_m_type").select2({
						width:'resolve',
						placeholder:'请选择',
					});
					$("#d_t_m_diagnosis").select2({
						width:'resolve',
						placeholder:'请选择',
					});
				});
			};
		
		</script>
</body>
