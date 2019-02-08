<%@ page pageEncoding="UTF-8" language="java"
	contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnosis.css" />
<script type="text/javascript" src="${ctx}/scripts/js/jquery.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/js/jquery.ztree.all.min.js"></script>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
			html,body,{
				margin: 0;
				padding: 0;
				width: 100%;
				height: 100%;
			
			}
			
			body{
				min-width: 400px;
			}
			.in-temp .search-box>input{
				padding: 8px 2px;
			}
			
			.in-temp .list{
				width: 92%;
				padding: 10px 2%;
				margin: 0 auto;
				background-color: #fff;
				height: 250px;
				overflow-y: auto;
			}
			.in-temp .search-box{
				width: 94%;
			}
			.top{
				margin-bottom: 10px;
			}
			.in-temp .search-box .search-icon{
				top: 4px;
			}
			.ztree{
				padding-top: 0;
			}
			body .wrapper{
				background: none;
				padding-bottom: 0px;
			}

		</style>
	<body>
		<div class="wrapper in-temp">
			<!-- <div class="top">
				<div class="search-box">
					<input type="text" placeholder="请填写专业" class="search-input" id="indicatorKey"/>
					<span class="search-icon icon" onclick="searchByKey()"></span>
				</div>
			</div> -->
			
			<div class="list">
				<s:hidden id="id"></s:hidden>
				<!--Ztree-->
				<div class="ztree">
					<div id="s_i_tree"></div>
				</div>
			</div>
		</div>
		
<script>
var status = $('#types',window.parent.document).val();
var taskid = $('#diagnosetaskid',window.parent.document).val();
$(document).ready(function(){
	var _w = $(".search-box").innerWidth() - 34;
	$(".in-temp .search-box>input").css({
		"width":_w + "px",
		"background":"#fff"
		});
		loadTreeDatas('${ctx}/diagnose/diagnoseTask/getTree.action',status,taskid);
	});
	//ztree
	var setting = {
		callback: {
			beforeClick: null, //用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作,可用于判断是否允许用户选择或取消点击操作
			beforeCheck: null, //根据返回值确定是否允许 勾选 或 取消勾选
			onClick: null, //用于捕获节点被点击的事件回调函数
		},
		data: {
			key: {
				name: "majorname"
				/* checked: "CHECKED" */
			},
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "organizationid"
			}
		},
		view: {
	        fontCss: getFont,
	        nameIsHTML: true,
	        showLine: false,
	        addDiyDom: addDiyDom
	    },
		check: {
			autoCheckTrigger: false, //自动关联勾选时是否触发 beforeCheck / onCheck 事件回调函数。
			chkboxType: {
				"Y": "s",
				"N": "ps"
			}, //勾选 checkbox 对于父子节点的关联关系,此选项是父子相互联系
			chkStyle: "checkbox",//多选。（如果是单选框）chkStyle:"radio",radioType:{ "Y": "ps", "N": "ps" },
			enable: true, //是否显示单选框或者是多选框
		}
	};
	
//回车搜索
/* $(document).keydown(function(e) {
	if(e.keyCode == 13) {
		searchByKey();
		
	}
}); */

//搜索
/* debugger;
function searchByKey() {
	var indicatorKey = $("#indicatorKey").val();
	loadTreeData('${ctx}/system/organization/getTree.action',indicatorKey,status);
} */

//		
function addDiyDom(treeId, treeNode) {
    var key = $("#indicatorKey").val();
    if (key !== "") {
        var aObj = $("#" + treeNode.tId + "_span");
        aObj.html(aObj.html().replace(key, "<span style='color:red'>" + key + "</span>"));
    }
}

//
function getFont(treeId, node) {
    return node.font ? node.font : {};
}

//
/* debugger;
function loadTreeData(url, key,status, selectNodeId){
	$.post(url, { key: key , status: status }, function (result) {
        if (result && result.obj) {
            bindTree(result.obj, selectNodeId);
        }
    });
} */

function loadTreeDatas(url, status,taskid, selectNodeId){
	$.post(url, { status: status , taskid: taskid}, function (result) {
        if (result && result.obj) {
            bindTree(result.obj, selectNodeId);
        }
    });
}


//				
function bindTree(zNodes,selectNodeId){
	debugger;
	formatNode(zNodes);
	var checkId=parent.$("#_ids").val().split(',');
	//初始化ztree
	var zTree = $.fn.zTree.init($("#s_i_tree"), setting, zNodes);
	if(zNodes.length > 0){
		zTree.expandAll(true);
	}
	for(var i in checkId){
	 var node = zTree.getNodeByParam("id",checkId[i]);
	 zTree.checkNode(node, true, false);
	}
}

function formatNode (zNodes){
	$.each(zNodes,function(i){
		if(this['unit_type']=='2'){
			this['isParent'] = true;
		}else{
			this['isParent'] = false;
		}
	});
}
			
//获取第一个叶子节点
function getChildren(treeNode, result) {
	if (treeNode.isParent) {
	   var childrenNodes = treeNode.children;
	   if (childrenNodes.length>0) {
	       result = getChildren(treeNode.children[0]);
	   }else{
	   	result = treeNode;
	   }
	} else {
	   result = treeNode;
	}
	return result;
}

function getCheckNodes(){
	var treeObj=$.fn.zTree.getZTreeObj("s_i_tree");
    nodes=treeObj.getCheckedNodes(true);
    var node,nodename;
      /*  for(var i=0;i<nodes.length;i++){
            if(nodes[i].isParent==true){
                node.majorname+=nodes[i].majorname+","; 
                nodes.splice(i,1);
            }
       } */
    	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		   	parent.layer.close(index); //再执行关闭
    return nodes;
}
</script>
</body>