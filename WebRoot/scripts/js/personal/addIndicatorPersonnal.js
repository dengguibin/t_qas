var ctx;
$(document).ready(function() {
	
	ctx=$("#ctxvalue").val();      //根路径
	
	getTreeHeight();	          //根据父窗口的高度计算出树形结构所占的高度
	
	getInputBlur();              //input标签获取焦点
	
	searchHideAndShow();        //搜索框的显示隐藏
	
	//获取树形结构数据（QasTIndicatorcatalog）
	loadTreeData('${ctx}/personal/intercalate/intercalateIsMonitorTree.action','');
	
	/**
	 * 1.表单提交验证
	 * 2.表单提交成功后加载树形结构
	 */
	tableValidate();
	
	//下拉框
	$("#type,#indicatordatatrend,#ismon,#name-s").select2({
		width:'resolve',
	});
});


//根据父窗口的高度计算出树形结构所占的高度
function getTreeHeight() {
	var _hMax = window.parent.document.getElementById("mainContent").offsetHeight; // 获取父窗口frame的高度
	if (_hMax) { 	//根据父窗口的高度计算出树形结构所占的高度
		var ht = $("body>.title").innerHeight() ? $("body>.title")
				.innerHeight() : 0;
		var htop = $(".top-txt").innerHeight() ? ($(".top-txt").innerHeight() + 12)
				: 0;
		var _h = _hMax - ht - htop - 16 * 2;
		$("#content>.box-r").css({
			"height" : _h + "px",
			"overflow" : "auto",
		});
		var _h_ztree = _h - $(".box-s").innerHeight() - 24; // 树的高度
		$("#dia_tree").css({
			"height" : _h_ztree + "px",
			"overflow" : "auto"
		})
	}
}

//获取指标树形数据
function loadTreeData(url, key, selectNodeId) {
	$.post(url, {
		key : key
	}, function(result) {
		if (result && result.obj) {
			bindTree(result.obj, selectNodeId);
			var count = result.data.count;
			var html = '';
			$(count).each(
					function(i, c) {
						html += c['NAME_'] + '指标<span class="col-1">'
								+ c['COUNT'] + '</span>个，'
					})
			$("#count").empty();
			$("#count").append(html.substr(0, html.length - 1));
		} else {
			layer.msg(result.msg, {
				icon : 2,
				time : 1500    // 1.5s后关闭
			});
		}
		// 调用最顶层页面的方法
		window.top.closeLoad();
	});
}
	
function bindTree(zNodes,selectNodeId){
	formatNode(zNodes); // 初始化ztree
	var zTree = $.fn.zTree.init($("#dia_tree"), setting, zNodes);
	if (zNodes.length > 0) {
		var nodes = zTree.getNodes();
		var node = getChildren1(nodes[0], "");
		if (selectNodeId) {
			node = zTree.getNodeByParam('id', selectNodeId);
		}
		if (node) {
			if ($.trim($("#indicatorKey").val()) === "") {
				zTree.expandNode(node);
			} else {
				zTree.expandAll(true);
			}
			zTree.selectNode(node);
			onClick(node);
		}
	}
}

function formatNode (zNodes){
	$.each(zNodes, function(i) {
		if (this['indicatortype'] != '0') {
			this['isParent'] = true;
		} else {
			this['isParent'] = false;
		}
	});
}

var selectedNode = null;
var setting = {				//ztree
	callback: {
		beforeClick: function (treeId, treeNode) {
			onClick(treeNode);
            return true;
        },//用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作,可用于判断是否允许用户选择或取消点击操作
		beforeCheck: null, //根据返回值确定是否允许 勾选 或 取消勾选
		//onClick: onClick, //用于捕获节点被点击的事件回调函数
	},
	data: {
		key: {
			name: "name_"
		},
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "parentid"
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
			"Y": "ps",
			"N": "ps"
		}, //勾选 checkbox 对于父子节点的关联关系,此选项是父子相互联系
		chkStyle: "checkbox", //多选。（如果是单选框）chkStyle:"radio",radioType:{ "Y": "ps", "N": "ps" },
		enable: false, //是否显示单选框或者是多选框
	}
};

//树形结构点击事件
function onClick(treeNode) {
	window.top.openLoad("加载中");
	$("#remark_f").hide(); 							// 隐藏指标备注
	selectedNode = treeNode; 					   // 为取消事件准备值
	if (treeNode == null || treeNode.pId == 1) {  // ztree单击事件（判断指标树形结构是否有值）
		return treeNode.name;
	} else {
		getTreeOnclick(treeNode); 			   // 指标树形结构点击事件（有值）
	}
}

/**
 * 指标树形结构点击事件（有值） 
 * 1.获取树形结构数据 
 * 2.进行当前指标的层级显示 
 * 3.根据数据类型进行相应的页面显示（指标、非指标）
 */
function getTreeOnclick(treeNode) {
	var _node = treeNode.getPath();         //获取刚节点的所有父节点，包括他本身（获取到的是一个数组）
	var txt = "";
	for(var j = 0; j < _node.length; j++) {		//循环获取当前页指标的层级显示
		if(j == _node.length - 1) {
			txt += _node[j].name_;
		} else {
			txt += _node[j].name_ + "  &gt;&gt;  ";
		}
	}
	$("#tab_name").html(txt);				 //当前指标的层级显示
	$(".btn-s-c").hide();					//隐藏保存、取消按钮
	
	var type = treeNode.indicatortype;
	if(type!='0') {						   //判断当前数据是指标还是非指标（类型，项目，要素）
		$("#modify").hide();			  //隐藏修改按钮
		getNoIndicator(treeNode);		  //点击事件（非指标）
	} else {
		$("#modify").show();
		getIndicator(treeNode);          //点击事件（指标）
	}
}

//点击事件（非指标）
function getNoIndicator(treeNode) {
	$(".add-indicat i").removeClass("add-metrics-unable").addClass("add-metrics-icon");
	$(".add-index i").removeClass("add-index-unable").addClass("add-index-icon");
	if(treeNode.children.length>0){
		$(".delete i").removeClass("delete-icon").addClass("delete-unable");
	}else{
		$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	}
	$(".content-item").hide();
	$(".content-list").show();
	$(".content-list").find("input,select,textarea").attr("disabled","disabled");
	$(".content-list").find("input,select,textarea").addClass("disabled");
	$(".content-list").find(".must").hide();
	$(".content-list").find(".input-view").show();
	var id = treeNode.id;
	$.post('/t_qas/indicator/indicatorcontent/queryInfo.action', {"bean.id":id}, function(result) {  //获取指标内容表
		var extend = result.data.exten;
		if(result.success){
			if(extend == null){
				$("#indicatorcatalogids").val("");
				$("#problemoverviews").val("");
				$("#suggestionoverviews").val("");
				$("#problemoverviews").next().text("");
				$("#suggestionoverviews").next().text("");
			}else{
				$("#indicatorcatalogids").val(extend.indicatorcatalogid);
				$("#problemoverviews").val(extend.problemoverview);
				$("#suggestionoverviews").val(extend.suggestionoverview);
				$("#problemoverviews").next().text(extend.problemoverview);
				$("#suggestionoverviews").next().text(extend.suggestionoverview);
			}
		}else{
			 layer.msg(result.msg, {
					icon: 2,
					time:1500//1.5s后关闭
				});
		 }
		window.top.closeLoad();
	});
	var _nodename = treeNode.name_;
	var _nodeRe = treeNode.remark;
	$("#catalog_id").val(treeNode.id);
	$("#catalog_pid").val(treeNode.parentid);
	$("#project").val(_nodename);
	$("#remark_t").val(_nodeRe);
	$("#remark_t").next().text(_nodeRe);
}

//点击事件（指标）
function getIndicator(treeNode) {
	var id = treeNode.id;					// 指标id
	getcontentbyindicator(id);			   // 获取指标内容表（QasTIndicatorcontent）
	getWaring(id);	   				      // 获取监视记录表（EarlyWarning）
	
	$(".add-indicat i").removeClass("add-metrics-icon").addClass("add-metrics-unable");
	$(".add-index i").removeClass("add-index-icon").addClass("add-index-unable");
	$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	$(".content-list").hide();
	$(".content-item").show();
	$(".content-item").find("input,select,textarea").attr("disabled","disabled");
	$(".content-item").find("input,select,textarea").addClass("disabled");
	$(".content-item").find(".must").hide();
	$(".content-item").find(".label").show();
	$(".content-item").find(".input-view").show();
	$("#set_role").hide();
	$("#indicatoridbywaring").val(id);
	$("#content_id").val(treeNode.id);
	$("#content_pid").val(treeNode.parentid);
}


// 获取监视记录表（EarlyWarning）
function getWaring(id) {
	$.post(ctx+"/personal/intercalate/querInfo.action", {"indicatorId":id},function(result){
		if(result.success){
			var early = result.data.early;
			var content = result.data.content;
			assignmentIsmonitor(early);			//赋值给是否监控
			assignmentWarningValue(content,early);	//赋值给分值设置
		}else{
			layer.msg(result.msg, {
				icon: 2,
				time:2500//1.5s后关闭
			});
		}
	});
}


//赋值给是否监控
function assignmentIsmonitor(early) {
	if (early != null) {
		$("#ismon").val(early.beMonitored).trigger("change");
	} else {
		$("#ismon").val(0).trigger("change");
	}
}


//赋值给分值设置
function assignmentWarningValue(content,early) {
	if (content != null) {
		if (content.indicatordatatrend == '0') { // 上行指标
			$("#leftvalue").val("");
			$("#rightvalue").val("");
			if (early != null) {
				$("#leftvalue").val(early.warningValueCeiling);
				$("#rightvalue").val(early.warningValueFloor);
			}
			$("#ceiling").hide();
			$("#floor").show();
		} else if (content.indicatordatatrend == '1') { // 下行指标
			$("#leftvalue").val("");
			$("#rightvalue").val("");
			if (early != null) {
				$("#leftvalue").val(early.warningValueCeiling);
				$("#rightvalue").val(early.warningValueFloor);
			}
			$("#ceiling").show();
			$("#floor").hide();
		} else { // 不存在值
			$("#ceiling").show();
			$("#floor").hide();
		}
	} else {
		$("#ceiling").show();
		$("#floor").hide();
	}
}


// 获取指标内容表（QasTIndicatorcontent）
function getcontentbyindicator(id) {  
	$.post(ctx+'/indicator/indicatorcontent/queryInfo.action', {"bean.id":id}, function(results) {
		if (results.success) {
			getextend(results.data.exten); // 获取指标目录扩展表（QasTIndicatorcatalogextend）
			getcontent(results.data.bean); // 获取指标内容表（QasTIndicatorcontent）
		} else {
			layer.msg(results.msg, {
				icon : 2,
				time : 1500			// 1.5s后关闭
			});
		}
		window.top.closeLoad();
	});
}


//获取指标目录扩展表（QasTIndicatorcatalogextend）
function getextend(extend) {
	if (extend != null) {
		$("#indicatorcatalogid").val(extend.indicatorcatalogid);
		$("#problemoverview").val(extend.problemoverview);
		$("#suggestionoverview").val(extend.suggestionoverview);
		$("#problemoverview").next().text(extend.problemoverview);
		$("#suggestionoverview").next().text(extend.suggestionoverview);
	} else {
		$("#indicatorcatalogid").val('');
		$("#problemoverview").val('');
		$("#suggestionoverview").val('');
		$("#problemoverview").next().text('');
		$("#suggestionoverview").next().text('');
	}
}

//获取指标内容表（QasTIndicatorcontent）
function getcontent(result) {
	if (result != null) {
		var _nodename = result.name_;
		var _nodeRe = result.remark;
		var _standard = result.standard;
		var _sqlstring = result.sqlstring;
		// 数值类型
		$("#type").val(result.indicatordatatype).trigger("change");
		
		if(result.indicatordatatype == 2) {  //判断指标数值类型为判断型时隐藏预警设置
			$("#warningValue").hide();
			$("#datatrend").hide();
		}
		if(result.indicatordatatype == 1) {
			$("#warningValue").show();
			$("#datatrend").show();
		}
		// 数据走势
		$("#indicatordatatrend").val(result.indicatordatatrend).trigger(
				"change");
		$("#name").val(_nodename);
		$("#standard").val(_standard);
		$("#name").parent().attr("title", _nodename);
		$("#remark_f").val(_nodeRe);
		$("#remark_f").next().text(_nodeRe);
		var atomStyle = "";		// 指标样式
	}
}

/**
 * 1.表单提交验证
 * 2.表单提交成功后加载树形结构
 */
function tableValidate() {
	frmAddOrEditContent = $("#frmAddOrEditContent").Validform({
		tiptype:function(msg){
			layer.msg(msg, {
				icon: 2,
				time:2500//1.5s后关闭
			});
		},
		tipSweep:true,
		postonce:false,
		datatype:{
			"notnull":function(gets,obj,curform,regxp){
				var display =$(obj).parent().css('display');
				if(display == 'none'){return true;}
				if(gets  == null || gets == ""){return false;}
				return true;
			},
		},
		beforeSubmit:function(curform){
			//$("#sqlstring").val(editAreaLoader.getValue('sqlstring'));
			var form = $("#frmAddOrEditContent");
			var id;
			$.post(form.attr("action"),form.serialize(),function(result){
				if(result.success){
					id=result.data.id
					loadTreeData('${ctx}/personal/intercalate/intercalateIsMonitorTree.action','',id);
					layer.msg(result.msg, {
						icon: 1,
						time:1500//1.5s后关闭
					});
				}else{
					layer.msg(result.msg, {
						icon: 2,
						time:2500//1.5s后关闭
					});
				}
			});
			getWaring(id);			// 获取监视记录表（EarlyWarning）
			return false;
		},
	});
}

//获取第一个叶子节点
function getChildren1(treeNode, result) {
	    if (treeNode.isParent) {
		var childrenNodes = treeNode.children;
		if (childrenNodes.length > 0) {
			result = getChildren1(treeNode.children[0]);
		} else {
			result = treeNode;
		}
	} else {
		result = treeNode;
	}
	return result;
}

function showSelectText(){
	$("#inputText").find("input,select").attr("disabled", "disabled");
	$("#selectText").show();
	$("#inputText").hide();
}

function showInputText(){
	$("#selectText").find("input,select").attr("disabled", "disabled");
	$("#selectText").hide();
	$("#inputText").show();
}

//取消事件
function cancelModify() {
	$("#modify").show();
	onClick(selectedNode);
}

$(document).keydown(function(e) {		//回车搜索
	if(e.keyCode == 13) {
		searchByKey();
	}
});

function searchByKey() {
	window.top.openLoad("搜索中"); // 调用最顶层页面的方法
	var indicatorKey = $("#indicatorKey").val();
	loadTreeData('${ctx}/personal/intercalate/intercalateIsMonitorTree.action',indicatorKey);
}

function addDiyDom(treeId, treeNode) {
    var key = $("#indicatorKey").val();
    if (key !== "") {
        var aObj = $("#" + treeNode.tId + "_span");
        aObj.html(aObj.html().replace(key, "<span style='color:red'>" + key + "</span>"));
    }
}

function getFont(treeId, node) {
    return node.font ? node.font : {};
}

//修改事件
function update() {
	$("#modify").hide();
	//层级修改显示
	$(".content-list").find(".must").css("display","inline-block");
	$(".content-list").find(".input-view").hide();
	//指标修改显示
	$(".content-item").find(".label").hide();
	$(".content-item").find(".must").css("display","inline-block");
	$(".content-item").find(".input-view").hide();
	$("#set_role").hide();
	$("#set_role").css("display","inline-block");
	$(".btn-s-c").show();
	$("#name-d").attr("disabled","disabled");
	
	/*
	 * 取消disabled（失效，不能进行数据输入以及将数据提交到表单）
	 */
	
	//保存按钮
	$("#sumbit").removeAttr("disabled");
	$("#sumbit").removeClass("disabled");
	//取消按钮
	$("#cancel").removeAttr("disabled");
	$("#cancel").removeClass("disabled");
	//分值设置
	$("#warningValue").find("input").removeAttr("disabled");
	$("#warningValue").find("input").removeClass("disabled");
	
	//是否监控
	$("#ismonitor").find("select").removeAttr("disabled");
	$("#ismonitor").find("select").removeClass("disabled");
	
	$("#indicatoridbywaring").removeAttr("disabled");
	$("#indicatoridbywaring").removeClass("disabled");
	//指标备注
	$("#remark_f").show();
}

//搜索框的显示隐藏
function searchHideAndShow() {
	var a = 0;
	$("#search_btn").click(function() {
		a++;// 第一次点击的时候为1，即a为单数的时候s_b是隐藏的
		var s_b_w = $(".box-d").innerWidth() * 0.9;
		var s_w = s_b_w - 34;
		$(".search-input").css("width", s_w + "px");
		var s_b = $("#s_b");
		if (a % 2 == 0) {
			s_b.hide();
			$(this).removeClass("arrow-up");
			$(this).find(".search-icon").removeClass("search-select");
		} else {
			s_b.show();
			$(this).addClass("arrow-up");
			$(this).find(".search-icon").addClass("search-select");
		}
	})
}

//input标签获取焦点
function getInputBlur () {
	$("input.inputxt,select,textarea").focus(function() {
		$(this).addClass("in-focus");
	});
	$("input,select,textarea").blur(function() {
		$(this).removeClass("in-focus");
	})
}

//模糊查询
function searchByKey() {
	//调用最顶层页面的方法
	window.top.openLoad("搜索中");
	debugger
	var indicatorKey = $("#indicatorKey").val();
    loadTreeData('${ctx}/personal/intercalate/intercalateIsMonitorTree.action',indicatorKey);
}
