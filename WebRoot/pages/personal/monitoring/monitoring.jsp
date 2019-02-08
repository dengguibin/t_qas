<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/plugins/bootstrap/css/bootstrap-3.3.7.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/analy.css" />
<!--<script type="text/javascript" src="${ctx}/scripts/js/jquery.min.js" ></script>-->
<script type="text/javascript" src="${ctx}/scripts/plugins/select2-master/dist/js/select2.full.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/js/common/echarts_3.7.2.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/js/monitoring/chart.js" ></script>
<link rel="stylesheet"
	href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnoseScheme.css" />
<script type="text/javascript"
	src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/js/diagnose/diagnoseSchemeList.js"></script>



<style>
	.sbox-t>.sbox-t-unq,.sbox-t>.sbox-t-q{
		display: none;
	}
</style>
<body>
	<div class="wrapper analy monitoring">
		<div class="main">
			<div class="main-content container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 content-r">
						<div class='row box2' id='sub_con_0'>
						
							<!--指标过程结果-->
							<c:forEach var="warning" items="${findNameBywarning}" varStatus="status">
								<div class="col-lg-6 col-md-6 col-sm-6 box2-1">
									<div class="sbox">
										<div class="sbox-t-b clear">
												<h6 class="sbox-t" id="${warning.name_}">
													${warning.name_}
												</h6>	
												<span class="right right-box">
													<input type="hidden" value="${warning.id }" id="id"/> 
											    	<input type="hidden" value="${warning.name_}" id="name"/>
											    	<span class="add-temp cancel" target="rightFrame">指标详情</span>	
													<!-- ztree 写法-->
													<span class="sys-class right">
														<span class="sys-txt" id="objName-${status.index}" index="${status.index}"></span>
														<span class="right menu-more" aria-hidden="更多"></span>
														<div id="dia_tree_${status.index}" class="sys-more ztree"></div>
													</span>
												</span>
												
											    
												
										</div>
										<div class="hr2">
											<div id="${warning.id}" class="chart_col_lg_6"></div>
										</div>
										<div id="montype_${status.index}">
										</div>
									</div>
								</div>	
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function(){
		var _wr = parseInt($(".content-r").width());
		var _hr2 = _wr * 0.26;
		$(".chart_col_lg_6").css({
			"height":_hr2 +"px",
		});
		var _length = $(".box2-1>.sbox").length;
		var temp = 0
		for(var i = 0;i < _length;i++){
			var _h = $(".box2-1>.sbox").eq(i).height();
			if(_h){
				temp = _h > temp ? _h : temp;
			}
		};
		for(var k = 0;k < _length;k++){
			var _hsbox = $(".box2-1>.sbox").eq(k).height();
			if(_hsbox < temp){
				var _hd = temp - _hsbox;
				$(".box2-1>.sbox").eq(k).find(".chart_col_lg_6").css("height",_hr2 + _hd + "px");
			}
		};
		$(".box2-1>.sbox").css({
			"height":temp +"px",
		});
		
		//ztree
		var setting = {
			callback: {
				onClick: onClick
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			view: {
		        showLine: false,
		    },
			check: {
				autoCheckTrigger: false, //自动关联勾选时是否触发 beforeCheck / onCheck 事件回调函数。
				chkboxType: {
					"Y": "ps",
					"N": "ps"
				}, //勾选 checkbox 对于父子节点的关联关系,此选项是父子相互联系 
				chkStyle: "checkbox", //多选。（如果是单选框）chkStyle:"radio",radioType:{ "Y": "ps", "N": "ps" },
				enable: false, //是否显示单选框或者是多选框
			}
		};
		var _h_ztree = $(".sbox").innerHeight()  - 80;
		
		$(".sys-more").hide();
		$(".chart_col_lg_6").each(function (index, obj) {
		$(".sys-more").hide();
		var id = $(this).attr("id");
			$.ajax({
				type:"GET",
				dataType:"json",
				url:"${ctx}/personal/monitoring/barChart.action",
				data:{"indicatorid":id},
				success:function (json) {
					var monitoringcontent = json.data.monitoring;
					var tree = json.data.selectData;
					var zNodes = [];
					var type=json.data.type;
				    var chart = echarts.init(document.getElementById(id));//echarts图表初始化
					if(type == 2) {
						$("#montype_"+index).val(1);
						singchar(chart,monitoringcontent);
					}
					if(type == 1) {
						$("#montype_"+index).val(2);
						doublechar(chart,monitoringcontent);
					}
					var firstTree = 
					$.each(tree,function(i,val){
						var obj = {
							tid:val.id,
							id:val.id,
							pId:val.pid,
							name:val.name
						};
						zNodes.push(obj);
					});
					
					var treeObj = $.fn.zTree.init($("#dia_tree_" + index), setting, zNodes);				
					var nodes = treeObj.getNodes();
					if (nodes.length>0) {
						treeObj.selectNode(nodes[0]);
						var node = nodes[0].name;
						$("#objName-" + index).text(node);
					}
				}
			});
			
			
			//ztree 写法
			$("#dia_tree_" + index).css({
				"height":_h_ztree + "px",
				"overflow":"auto"
			});
		});
		
		$(".sys-txt").click(function(e) {
			//防止冒泡
			if(window.event){       //这是IE浏览器
	            e.cancelBubble=true;//阻止冒泡事件
	            e.returnValue=false;//阻止默认事件
	            if(e.stopPropagation){
	            	e.stopPropagation();//阻止冒泡事件
	            	e.preventDefault();//阻止默认事件
	            }
	        }else if(e && e.stopPropagation){     //这是其他浏览器
	            e.stopPropagation();//阻止冒泡事件
	            e.preventDefault();//阻止默认事件
	        }else{
	        	e.stopPropagation();//阻止冒泡事件
	            e.preventDefault();//阻止默认事件
	        };
			var idx = $(this).attr("index");
			$("#dia_tree_"+idx).show();
		});


		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj(treeId),
			nodes = zTree.getSelectedNodes(),
			v = "",
			idArr = treeId.split("_");
			var inx=treeId.replace(/[^0-9]/ig,""); //获取index
			v = nodes[0].name;
			$("#objName-" + idArr[2]).text(v);
			$("#" + treeId).hide();
			
			//更新视图
			var monid=$("#montype_"+inx).val();
			$.ajax({
				type:"GET",
				dataType:"json",
				url:"${ctx}/personal/monitoring/barcharChange.action",
				data:{"type":monid} ,
				success:function (json) {
					var monitoringcontent = json.data.monitoring;
					var t = $("#char_"+inx).val();
					if(monid == 1) {
						var id = $("#" + treeId).parents(".sbox").find(".hr2").find(".chart_col_lg_6").attr("id");
						//获取echarts初始化对象
						var compareChart = echarts.getInstanceByDom(document.getElementById(id));
						compareChart.clear();
						window.clearInterval(timeArr[inx]);
						singchar(compareChart,monitoringcontent,inx);
					}
					if(monid == 2) {
						var id = $("#" + treeId).parents(".sbox").find(".hr2").find(".chart_col_lg_6").attr("id");
						debugger
						var compareChart = echarts.getInstanceByDom(document.getElementById(id));
						compareChart.clear();
						window.clearInterval(timeArr[inx]);
						doublechar(compareChart,monitoringcontent,inx);
					}
				}
			});
		}
		
	});
	
	//单柱状图
	var timeArr = [];
	function singchar(echarts,singData,idx){
		var data = eval('(' + singData + ')');
		singleBarChart(echarts,data,"该值随便写","该值随便写","A类课程数对比","A类课程数",2100,idx);
	}
	
	//双柱状图
	function doublechar(echarts,doubleData,idx){
		var data = eval('(' + doubleData + ')');
		doubleBarChart(echarts,data,"毕业生对教学满意的人数","毕业生总人数","该值随便写","毕业生的教学满意度",2500,idx);
	};
	
	//resize：窗口发生改变的时候触发
	$(window).resize(function(){
		$(".chart_col_lg_6").each(function (index, obj) {
			var id = $(this).attr("id");
			echarts.init(document.getElementById(id)).resize();
        });
	});
	
</script>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
