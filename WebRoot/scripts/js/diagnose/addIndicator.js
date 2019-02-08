var url = "${ctx}/diagnose/diagnosescheme/getTree.action"
/**
 * 表单验证
 */
var saveShcemeCatalog;
var saveIndicatorRate;
//ztree
var selectedNode = null;
var zTree;

$(document).ready(function() {
	
	getTreeHeight();              //获取父窗口frame的高度(计算树形结构的高度)
	
	getValidform();              //表单验证（表单提交成功后加载树形结构）
	
	loadTreeData(url,''); 		//加载树形结构
	
	selectShowAndHide();       //搜索框的显示隐藏
	
	hierarchyTips();          //添加指标、添加层级处的tips提示
	
	autoSetRightValue();	 //自动填充分值范围右值
	
	selectChange();         //下拉框赋值（可升级）
	
	//保存,取消按钮的隐藏
	if($("#_status").val()==1){    		
		$(".valid").hide();
	}
	
	//添加指标、添加层级处理的点击事件
	//事件代理,通过li的index判断当前点击的是哪一个
	hierarchyClick();
	
	//input获取焦点
	$("input.inputxt,select,textarea").focus(function(){
		$(this).addClass("in-focus");
	});
	$("input,select,textarea").blur(function(){
		$(this).removeClass("in-focus");
	})
	
	//下拉框
	$("#type,#dis_type").select2({
		width:'resolve',
	});
})


//获取父窗口frame的高度(计算出树形结构的高度)
function getTreeHeight() {
	var _hMax = window.parent.document.getElementById("mainContent").offsetHeight;
	if(_hMax){
		var _h = _hMax - $(".top-txt").innerHeight() - 16 *2 - 40;
		$("#add-content>.box-r").css({
			"height":_h+"px",
			"overflow":"auto",
		});
		// 左边
		var _l_s_h = _h - $(".box-s").innerHeight();
		$(".box-d").css({
			"height":_h + "px",	
		})
		$(".ztree").css({
			"height":_l_s_h - 10*2 + "px"
		})
		var _h_ztree = _h - $(".box-s").innerHeight();
		var b_h =  _h_ztree - $(".title-tab").innerHeight() - $(".btn-s-c") - 4;
		$(".content-program,.content-item,.content-list").css({
			"height":b_h + "px",
			"overflowY":"auto"
		})
	}
}

//表单验证（表单提交成功后加载树形结构）
function getValidform() {
	saveShcemeCatalog = $("#saveShcemeCatalog").Validform({
		tiptype:function(msg){
			layer.msg(msg, {
				icon: 2,
				time:2500//1.5s后关闭
			});
		},
		tipSweep:true,
		postonce:false,
		datatype:{
			"weight":function(gets,obj,curform,regxp){
				if(gets==""||parseFloat(gets)>1||parseFloat(gets)<0){return false;}
				selectedNode.WEIGHT = parseFloat(gets);
				return true;
			},
		},
		beforeSubmit:function(curform){
			window.top.openLoad("正在提交。。。请稍后");
			var form = $("#saveShcemeCatalog");
			var id = $("#schemeid_p").val();
			$.post(form.attr("action"),form.serialize(),function(result){
				if(result.success){
					layer.msg(result.msg, {
						icon: 1,
						time:1500//1.5s后关闭
					});
					
					loadTreeData(url, "", id)
				}else{
					layer.msg(result.msg, {
						icon: 2,
						time:2500//1.5s后关闭
					});
				}
				window.top.closeLoad();
			});
			return false;
		},
	});
	
	saveIndicatorRate = $("#saveIndicatorRate").Validform({
		ignoreHidden:true,
		tiptype:function(msg){
			layer.msg(msg, {
				icon: 2,
				time:2500//1.5s后关闭
			});
		},
		tipSweep:true,
		postonce:false,
		datatype:{
			"score"	:function(gets,obj,curform,regxp){
				if(!regxp.n.test(gets)){return false;}
				if(parseInt(gets)>parseInt($("#score").val())){return false;}
				if(parseInt(gets)>parseInt($(obj).parent().parent().prev().find("input.score").eq(0).val())){return false;}
				return true;
			},
			"leftvalue"	:function(gets,obj,curform,regxp){
				if(!regxp.n.test(gets)){return false;}
				if(parseInt(gets)>parseInt($("#score").val())){return false;}
				if(parseInt(gets)>=parseInt($(obj).parent().find("input").eq(2).val())){return false;}
				return true;
			}
		},
		beforeSubmit:function(curform){
			window.top.openLoad("正在提交。。。请稍后");
			var form = $("#saveIndicatorRate");
			var id = $("#schemeid_c").val();
			$.post(form.attr("action"),form.serialize(),function(result){
				if(result.success){
					layer.msg(result.msg, {
						icon: 1,
						time:1500//1.5s后关闭
					});
					loadTreeData(url, "", id);
				}else{
					layer.msg(result.msg, {
						icon: 2,
						time:2500//1.5s后关闭
					});
				}
				window.top.closeLoad();
			});
			return false;
		},
	});
	
}

//搜索框的显示与隐藏
function selectShowAndHide() {
	var a = 0;
	$("#search_btn").click(function(){
		a++;//第一次点击的时候为1，即a为单数的时候s_b是隐藏的
		var s_b_w = $(".box-d").innerWidth() * 0.9;
		var s_w = s_b_w - 34;
		$(".search-input").css("width", s_w + "px");
		var s_b = $("#s_b");
		if(a % 2 == 0){
			s_b.hide();
			$(this).removeClass("arrow-up");
			$(this).find(".search-icon").removeClass("search-select");
		}else{
			s_b.show();
			$(this).addClass("arrow-up");
			$(this).find(".search-icon").addClass("search-select");
		}
	})
}

//添加指标、添加层级处的tips提示
function hierarchyTips() {
	$(".show-tip").hover(function(){
		var $tip = $(this).find(".tip");
		var _w = $tip.innerWidth() / 2;
		$tip.css({
			"marginLeft": -_w + "px",
		});
		$tip.show();
	},function(){
		var $tip = $(this).find(".tip");
		$tip.hide();
	});
}

/**
 * 添加指标、添加层级处理的点击事件
 * 事件代理,通过li的index判断当前点击的是哪一个
 */
function hierarchyClick() {	
	$("#a_d").on("click","li",function(){
		var idx = $(this).index();
		var rangetype = $("#rangetype").val();
		var diagnoseid = $("#diagnoseid").val();
		var type = $("#_type").val();
		if(type != '0' && idx == 2&&selectedNode.children){
			return ;
		}
		if(idx !=0){
			$(".btn-s-c").show();
		};
		if($(".row-r").find("select#type")){
			$(".row-r").find("select#type").show();
			$("#type").next(".select2").show();
			$(".row-r").find("#type-d").hide();
		};
		$("#a_d .icon").removeClass("select");
		$(this).find(".icon").addClass("select");
		if(idx == 0){
			// 移动层级
			layer.open({
			  	type: 2,
			  	title: '<i class="s_logo"></i>请选择指标模板',
			  	shadeClose: true,
			  	shade: 0.4,
			  	area: ['600px','420px'],
			  	btn:["确定","关闭"],
			  	yes:function(index, layero){
			  		var body = layer.getChildFrame('body', index);
			  	    var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			  	  iframeWin.saveScheme($("#_diagnoseId").val());
			  	},
			  	content: 'checkScheme.action?diagnose.rangetype='+rangetype+'&diagnose.id='+diagnoseid// iframe的url
			}); 
			
		}else if(idx == 1){
			// 添加指标
			layer.open({
			  	type: 2,
			  	title: '<i class="s_logo"></i>请选择指标',
			  	shadeClose: true,
			  	shade: 0.4,
			  	area: ['600px','420px'],
			  	btn:["确定","关闭"],
			  	yes:function(index, layero){
			  		var body = layer.getChildFrame('body', index);
			  	    var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			  	  iframeWin.getCheckNodes($("#_diagnoseId").val());
			  	},
			  	content: 'checkIndicator.action' // iframe的url
			});
		}else{
			// 删除
			layer.confirm('您确定要删除该指标吗？', {
				title:"提示",
			  	btn: ['确定','取消'] // 按钮
			}, function(){
				$.post("${ctx}/diagnose/diagnosescheme/remove.action",{"scheme.id":selectedNode.ID},function(data){
					if(data.success){
						layer.msg(data.msg, {
							icon: 1,
							time:1500// 1.5s后关闭
						});
						loadTreeData(url,'',selectedNode.PARENTID);
					}else{
						layer.msg(data.msg, {
							icon: 1,
							time:1500// 1.5s后关闭
						});
					}
				});
			}, function(){
			  	layer.msg('已取消该操作', {
			  		icon: 2,
			  		time:1500// 1.5s后关闭
			  	});
			});
		}
	});
}

//下拉框赋值
function selectChange() {
	$("#select-y-n-1").change(function(){
		if($("#select-y-n-1").val() == '是'){
			$("#select-y-n-2").val("否");
		}else{
			$("#select-y-n-2").val("是");
		}
	});
	$("#select-y-n-2").change(function(){
		if($("#select-y-n-2").val() == '是'){
			$("#select-y-n-1").val("否");
		}else{
			$("#select-y-n-1").val("是");
		}
	});
}

var setting = {
	callback: {
		beforeClick:function (treeId, treeNode) {
			onClick(treeNode);
            return true;
        }, //用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作,可用于判断是否允许用户选择或取消点击操作
		beforeCheck: null, //根据返回值确定是否允许 勾选 或 取消勾选
		//onClick: onClick, //用于捕获节点被点击的事件回调函数
	},
	data: {
		key: {
			name: "NAME_"
		},
		simpleData: {
			enable: true,
			idKey: "INDICATORCATALOGID",
			pIdKey: "PARENTID"
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
	selectedNode = treeNode
	//ztree单击事件
	if(treeNode == null || treeNode.pId == 1) {  //树形结构加载失败
		return treeNode.name;
	} else {		//树形结构加载成功
		getTreeSuccess(treeNode);
	}
}

//树形结构加载成功
function getTreeSuccess(treeNode) {
	
	hierarchy(treeNode); 		  //当前指标的层级显示
	
	weight(treeNode);    		 //计算权重 的相关显示隐藏
	
	if(treeNode.isParent) {	   //判断该节点是否还有子节点
		noIndex(treeNode);    // 非指标（类型，项目，要素）树形结构点击事件
	} else {
		index(treeNode);     //指标树形结构点击事件
	}
	setNodeLevel(treeNode.INDICATORTYPE);   //诊断类型
	
	$("#_type").val(treeNode.INDICATORTYPE);
	
}

//当前指标的层级显示
function hierarchy(treeNode) {
	var _node = treeNode.getPath(); //获取刚节点的所有父节点，包括他本身(获取到的是一个数组)
	var txt = "";
	for(var j = 0; j < _node.length; j++) {
		if(j == _node.length - 1) {
			txt += _node[j].NAME_;
		} else {
			txt += _node[j].NAME_ + "  &gt;&gt;  ";
		}
	}
	$("#tab_name").html(txt);    // 当前指标的层级显示
}
// 非指标（类型，项目，要素）树形结构点击事件
function noIndex(treeNode) {
	saveShcemeCatalog.resetForm();
	$(".parentId").val(treeNode.PARENTID);
	$.get('getSchemeCatalog.action',{"scheme.id":treeNode.ID},function(result){
		if(result.success){
			if(result.obj.score>0){
				$("#schemeScore").val(result.obj.score);
			}
			if(result.obj.weight>0){
				$("#schemeWeight").val(result.obj.weight);
			}
			
		}
		window.top.closeLoad();
	});
	$("#schemeid_p").val(treeNode.ID);
	if(treeNode.children.length>0){
		$(".delete i").removeClass("delete-icon").addClass("delete-unable");
	}else{
		$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	}
	$(".content-index").hide();
	$(".content-program").show();
	$(".content-program").find("#c_p_project").val(treeNode.NAME_);
	$(".content-program").find("#c_p_remark").val(treeNode.REMARK);
}

//指标树形结构点击事件
function index(treeNode) {
	saveIndicatorRate.resetForm();
	$(".parentId").val(treeNode.PARENTID);
	$.get('getIndicatorRate.action',{"scheme.id":treeNode.ID},function(result){
		if(result.success){
			if(result.data!=null){
				var indicatorcontent = result.data.indicatorcontent;
				var indicatordatatype = indicatorcontent.indicatordatatype
				$("#dis_type_1").val(indicatordatatype).trigger("change");
				var datas = result.data.datas;
				var scheme = result.data.scheme;
				if(indicatordatatype == 1){
					$("#datatype-1").show();
					
					$("#datatype-2").find("select,input").attr("disabled","disabled")
					$("#datatype-2").hide();
					var status=$("#status").val();
					if(status == '0'){
						$("#datatype-1").find("select,input").removeAttr("disabled","disabled")
						$("#lock1").attr("disabled",true);
					}
					if(datas.length>0){
						$(".item").eq(0).find("input").eq(0).val(datas[0].leftvalue);
						$(".item").eq(0).find("input").eq(3).val(datas[0].score);
						$(".item").eq(1).find("input").eq(0).val(datas[1].leftvalue);
						$(".item").eq(1).find("input").eq(2).val(datas[1].rightvalue);
						$(".item").eq(1).find("input").eq(3).val(datas[1].score);
						$(".item").eq(2).find("input").eq(2).val(datas[2].rightvalue);
						$(".item").eq(2).find("input").eq(3).val(datas[2].score);
					}
				}else if(indicatordatatype == 2){
					$("#datatype-2").show();
					
					$("#datatype-1").find("select,input").attr("disabled","disabled")
					$("#datatype-1").hide();
					var status=$("#status").val();
					if(status == '0'){
						$("#datatype-2").find("select,input").removeAttr("disabled","disabled")
						$("#lock2").attr("disabled",true);
					}
					if(datas.length>0){
						$(".item").eq(3).find("input.score").eq(0).val(datas[0].score);
						$(".item").eq(4).find("input.score").eq(0).val(datas[1].score);
						$("#select-y-n-1").val(datas[0].operator).trigger("change");
						$("#select-y-n-2").val(datas[1].operator).trigger("change");
					}
				}
			}
			$(".content-index").find("#score").val();
			
		}
		window.top.closeLoad();
	});
	$("#schemeid_c").val(treeNode.ID);
	$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	$(".content-program").hide();
	$(".content-index").show();
	$(".content-index").find("#c_i_name").val(treeNode.NAME_);
	$(".content-index").find("#c_i_remark").val(treeNode.REMARK);
}

function weight(treeNode) {
	if(treeNode.INDICATORTYPE == 1){   //计算权重的显示与隐藏
		$("#weight").hide();
	}else{
		$("#weight").show();
	}
	if(treeNode.INDICATORTYPE == 2){  //计算权重项目的输入提示的显示与隐藏
		$("#hint_2").show();
		$("#hint_3").hide();
	}
	if(treeNode.INDICATORTYPE == 3){  //计算权重要素的输入提示的显示与隐藏
		$("#hint_2").hide();
		$("#hint_3").show();
	}
}
function searchByKey() {
	//调用最顶层页面的方法
	window.top.openLoad("搜索中");
	
	var indicatorKey = $("#indicatorKey").val();
    loadTreeData(url,indicatorKey);
    
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

function updateTreeNode(node){
	if(node.PARENTID){
		node.icon = getIcon(node.ISVALID,node.INDICATORTYPE,node.WEIGHT);
		zTree.updateNode(node);
		var parentNode = node.getParentNode()
		var childrenNodes = parentNode.children;
		var b = true;
		for (var i in childrenNodes) {
			if(childrenNodes[i].ISVALID == 0||childrenNodes[i].WEIGHT>=0){
				b = false;
				break;
			}
		}
		if(b){
			parentNode.ISVALID = 1;
			updateTreeNode(parentNode);
		}
	}
}

function loadTreeData(url, key, selectNodeId) {
	$.post(url, {
		key: key,
		'schemeId': $("#_diagnoseId").val()
	}, function(result) {
		if(result.success){
			if(result && result.obj) {
				bindTree(result.obj, selectNodeId);
			}
			var count = result.data.count;
			var html = '';
			$(count).each(function(i, c) {
				html += c['NAME_'] + '指标<span class="col-1">' + c['COUNT'] + '</span>个，'
			})
			$("#count").empty();
			$("#count").append(html.substr(0, html.length - 1));
		}else{
			layer.msg(result.msg, {
				icon: 2,
				time:1500//1.5s后关闭
			});
		}
		//调用最顶层页面的方法
		window.top.closeLoad();
	});
	
	
}

function bindTree(zNodes,selectNodeId){
	formatNode(zNodes);
	// 初始化ztree
	zTree =$.fn.zTree.init($("#dia_tree_m"), setting, zNodes);
	if(zNodes.length > 0){
		var nodes = zTree.getNodes();
		var node = getChildren(nodes[0], "");
		if (selectNodeId) {
	       node = zTree.getNodeByParam('ID', selectNodeId);
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
	var ids = [];
	$.each(zNodes,function(i){
		ids.push(this['INDICATORCATALOGID']);
		if(this['INDICATORTYPE']!=0){
			this['isParent'] = true;
			if(this['INDICATORTYPE']!=1){
				this['icon'] = getIcon(this['ISVALID'],this['INDICATORTYPE'],this['WEIGHT']);
			}
		}else{
			this['isParent'] = false;
			this['icon'] = getIcon(this['ISVALID'],this['INDICATORTYPE']);
		}
	});
	$("#_ids").val(ids.join(','));
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

function getIcon(isvalid,indicatortype,weight){
	
	var schemeweight=$("#schemeWeight").val();
	var path = $("#path").val();
	if(isvalid == 0){
		if(indicatortype == 0){
			return path+'/scripts/img/ztree/icon_quantitative_nocomp.png';
			
		}else {
				
			if(weight>0){
				if(schemeweight>=0){
					return path+'/scripts/img/ztree/icon_project_alertcomp.png';// 蓝色警告
				}else{
					return path+'/scripts/img/ztree/icon_project_nocomp.png';
				}
			}else{
				return path+'/scripts/img/ztree/icon_project_nocomp.png';
			}
		}
	}else{
		if(indicatortype == 0){
			return path+'/scripts/img/ztree/icon_quantitative_comp.png';
		}else{
			if(weight>=0){
				return path+'/scripts/img/ztree/icon_project_comp.png';
			}else{
				return path+'/scripts/img/ztree/icon_project_nocomp.png';
			}
		}
	}
}

function setNodeLevel(type) {
    switch (type) {
        case 1:
            $("#nameTitle").html("诊断类型：");
            break;
        case 2:
            $("#nameTitle").html("诊断项目：");
            break;
        case 3:
            $("#nameTitle").html("诊断要素：");
            break;
        case 4:
            $("#nameTitle").html("诊断点：");
            break;
        default:
            $("#nameTitle").html("诊断项目：");
            break;
    }
}

///自动填充分值范围右值
function autoSetRightValue() {
    $(".item").each(function(index, value) {
        if (index < ($(".item").length - 1)) {
            $(value).find("input").eq(0).blur(function() {
                $(value).next().find("input").eq(2).val($(this).val());
            });
        }
    });
};


//发布
function publish(){
	$.post("${ctx}/diagnose/diagnosescheme/publish.action",{"diagnose.id":$("#_diagnoseId").val()},function(result){
		if(result.success){
			$(".valid").hide();
			layer.msg(result.msg, {
				icon: 1,
				time:1500//1.5s后关闭
			});
		}else{
			layer.msg(result.msg, {
				icon: 2,
				time:1500//1.5s后关闭
			});
		}
	});
}
