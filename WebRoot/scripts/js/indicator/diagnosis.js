$(document).ready(function() {
	
	getTreeHeight();     	   //获取父窗口frame的高度(计算出树形结的高度)
	
	getValidform();    	      //表单验证（表单提交成功后加载树形结构）
	
	selectShowAndHide();     //搜索框的显示隐藏
	
	hierarchyTips();        //添加指标、添加层级处的tips提示
	
	addDatarule();         //添加数据规则
	
	//加载树形结构
	loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action',''); 
	
	//添加指标、添加层级处的点击事件
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
	$("#type,#name-s").select2({      
		width:'resolve',
	});
	
	 //ztree 单击之前的事件
	function beforeClick(treeId, treeNode, clickFlag) {
	}
});



//获取父窗口frame的高度(计算出树形结的高度)
function getTreeHeight() {
	var _hMax = window.parent.document.getElementById("mainContent").offsetHeight;
	if(_hMax){
		var ht = $("body>.title").innerHeight()?$("body>.title").innerHeight():0;
		var htop = $(".top-txt").innerHeight()?($(".top-txt").innerHeight() + 12):0;
		var _h = _hMax - ht - htop - 16*2;
		$("#content>.box-r").css({
			"height":_h+"px",
			"overflow":"auto",
		});
		//树的高度
		var _h_ztree = _h - $(".box-s").innerHeight() - 24;
		$("#dia_tree").css({
			"height":_h_ztree + "px",
			"overflow":"auto"
		})
	};
}

//表单验证（表单成功提交后加载树形结构）
function getValidform() {
	frmAddOrEditCatalog = $("#frmAddOrEditCatalog").Validform({ //表单验证
		tiptype:function(msg){
			layer.msg(msg, {    //提示框
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
		beforeSubmit:function(curform){     //表单提交成功
			if($("#indicatortype").val()==1){
				$("#name-d").val($("#name-s").find("option:selected").text());
			}
			var form = $("#frmAddOrEditCatalog");
			$.post(form.attr("action"),form.serialize(),function(result){
				if(result.success){
					loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
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
			return false;
		}
	});
	
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
			var form = $("#frmAddOrEditContent");
			$.post(form.attr("action"),form.serialize(),function(result){
				if(result.success){
					loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
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
	})
}

//添加数据规则
function addDatarule() {
	$(".content-item").on("click","#set_role",function(){
		//点击出来一个弹窗
		layer.open({
			title:'<i class="s_logo"></i>添加数据规则',
		  	type: 1,
		  	skin: 'layui-layer-demo', //加上边框
		  	area: ['420px', '240px'], //宽高
		  	title:"数据规则",
		  	content: '暂时不支持修改！'
		});
	})
}


//添加指标、添加层级处的点击事件
//事件代理,通过li的index判断当前点击的是哪一个
function hierarchyClick() {
	$("#a_d").on("click","li",function(){
		var idx = $(this).index();
		var type = parseInt(selectedNode.indicatortype)
		if(type == 0 && idx != 3){
			return ;
		}else if(type != 0 && idx == 3&&selectedNode.children.length>0){
			return ;
		}
		if(idx !=0&&idx!=3){
			$(".btn-s-c").show();
			if($(".row-r").find("select#type")){
				$(".row-r").find("select#type").show();
				$("#type").next(".select2").show();
				$(".row-r").find("#type-d").hide();
			};
			$("#a_d .icon").removeClass("select");
			$(this).find(".icon").addClass("select");
		};
		
		if(idx == 0){//移动层级
			return;
		}else if(idx == 1){//添加
			$("#modify").hide();
			if(type == 3){
				$("#content_pid").val(selectedNode.id);
				showContent();
			}else{
				setNodeLevel(type+1);
				$("#indicatortype").val(type+1);
				$("#catalog_pid").val(selectedNode.id);
				showCatalog();
			}
			showInputText();
		}else if(idx == 2){//添加层级
			$("#modify").hide();
			$("#indicatortype").val(type);
			$("#catalog_pid").val(selectedNode.parentid);
			setNodeLevel(type);
			showCatalog();
			if(type == 1){
				showSelectText();
			}else{
				showInputText();
			}
		}else{//删除
			var id = selectedNode.id;
			var pid = selectedNode.parentid;
			layer.confirm('您确定要删除该指标吗？', {
				title:'提示',
			  	btn: ['确定','取消'] //按钮
			}, function(){
				$.post("${ctx}/indicator/indicatorcatalog/remove.action",{"bean.id":id},function(data){
					if(data.success){
						layer.msg(data.msg, {
							icon: 1,
							time:1500//1.5s后关闭
						});
						loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',pid);
					}else{
						layer.msg(data.msg, {
							icon: 1,
							time:1500//1.5s后关闭
						});
					}
				});
			}, function(){
			  	layer.msg('已取消该操作', {
			  		icon: 2,
			  		time:1500//1.5s后关闭
			  	});
			});
		}
	});
}

//ztree
var selectedNode = null;
var setting = {
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

//回车搜索
$(document).keydown(function(e) {
	if(e.keyCode == 13) {
		searchByKey();
	}
});

function searchByKey() {
	//调用最顶层页面的方法
	window.top.openLoad("搜索中");
	
	var indicatorKey = $("#indicatorKey").val();
    loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action',indicatorKey);
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

//树形结构点击事件
function onClick(treeNode) {
	window.top.openLoad("加载中");
	selectedNode = treeNode
	//ztree单击事件
	if(treeNode == null || treeNode.pId == 1) {   //树形结构加载失败
		return treeNode.name;
	} else {                                     //树形结构加载成功(点击事件)
		getTreeSuccess (treeNode);
	}

}

//树形结构加载成功(点击事件)
function getTreeSuccess (treeNode) {
	var _node = treeNode.getPath(); //获取刚节点的所有父节点，包括他本身（获取到的是一个数组）
	var txt = "";
	for(var j = 0; j < _node.length; j++) {
		if(j == _node.length - 1) {
			txt += _node[j].name_;
		} else {
			txt += _node[j].name_ + "  &gt;&gt;  ";
		}
	}
	$("#tab_name").html(txt);      //当前指标的层级显示
	
	var type = treeNode.indicatortype;		//0代表指标，1代表类型，2代表项目，3代表要素
	setNodeLevel(treeNode.indicatortype)
	setIndicatTitle(treeNode.indicatortype);
	if(type == '1'){ 			// 修改事件的显示与隐藏
		$("#modify").hide();//隐藏
	}else{
		$("#modify").show();//显示
	}
	$(".btn-s-c").hide();    // 保存，取消事件的隐藏
	if(type!='0') {         // 非指标（类型，项目，要素）树形结构点击事件
		noIndex(treeNode);
	} else {               //指标树形结构点击事件
		index(treeNode);
	}
}

// 非指标（类型，项目，要素）树形结构点击事件
function noIndex(treeNode) {
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
	var _nodename = treeNode.name_ ? treeNode.name_ : "";
	var _nodeRe = treeNode.remark ? treeNode.remark : "";
	var _leadDeptDept = treeNode.leadDept ? treeNode.leadDept : "";
	var _synergeticDept = treeNode.synergeticDept ? treeNode.synergeticDept : "";
	$("#leadDept").val(_leadDeptDept);
    $("#synergeticDept").val(_synergeticDept);
	$("#catalog_id").val(treeNode.id);
	$("#catalog_pid").val(treeNode.parentid);
	$("#project").val(_nodename);
	$("#remark_t").val(_nodeRe);
	$("#remark_t").next().text(_nodeRe);
	window.top.closeLoad();
}

//指标树形结构点击事件
function index(treeNode) {
	$(".add-indicat i").removeClass("add-metrics-icon").addClass("add-metrics-unable");
	$(".add-index i").removeClass("add-index-icon").addClass("add-index-unable");
	$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	//查询数据库
	var result;
	var id = treeNode.id;
	$.post("/t_qas/indicator/indicatorcontent/queryInfo.action", {"bean.id":id}, function(results) {
		
		if(results.success){
			 result =results.data.bean;
			 if(result!=null){
				 var _nodename = result.name_ ? result.name_ : "暂无数据";
				 var _nodeRe = result.remark ? result.remark : "暂无数据";
				 $("#standard").val(result.standard);
				 $("#name").val(_nodename);
				 $("#name").parent().attr("title",_nodename);
				 $("#remark_f").val(_nodeRe);
				 $("#remark_f").next().text(_nodeRe);
				 $("#type").val(result.indicatordatatype).trigger("change");
				 var _nodeRole = $("#type").find("option:selected").text();//数据类型
				 if($(".row-r").find("select#type")){
					 $(".row-r").find("select#type").hide();
					 $(".row-r").find("#type-d").show().html(_nodeRole);
					 $(".content-item").find(".label").show();
					 $("#set_role").hide();
				 }
			 }
		 } else {
			layer.msg(results.msg, {
				icon : 2,
				time : 1500
				// 1.5s后关闭
			});
		}
		window.top.closeLoad();
	});
	
	$(".content-list").hide();
	$(".content-item").show();
	$(".content-item").find("input,select,textarea").attr("disabled","disabled");
	$(".content-item").find("input,select,textarea").addClass("disabled");
	$(".content-item").find(".must").hide();
	$(".content-item").find(".input-view").show();
	$("#content_id").val(treeNode.id);
	$("#content_pid").val(treeNode.parentid);
}

function loadTreeData(url, key, selectNodeId) {
	$.post(url, {
		key: key
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
			//调用最顶层页面的方法
		}else{
			layer.msg(result.msg, {
				icon: 2,
				time:1500//1.5s后关闭
			});
		}
		window.top.closeLoad();
	});
}
	
function bindTree(zNodes,selectNodeId){
	formatNode(zNodes);
	//初始化ztree
	var zTree = $.fn.zTree.init($("#dia_tree"), setting, zNodes);
	if(zNodes.length > 0){
		var nodes = zTree.getNodes();
		var node = getChildren(nodes[0], "");
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
	$.each(zNodes,function(i){
		if(this['indicatortype']!='0'){
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

function setNodeLevel(type) {
	showInputText();
	$("#leadDeptDeptDiv").hide();
	$("#synergeticDeptDiv").hide();
    switch (type) {
        case 1:
            $("#nameTitle").html("诊断类型：");
            break;
        case 2:
            $("#nameTitle").html("诊断项目：");
            break;
        case 3:
            $("#nameTitle").html("诊断要素：");
            $("#leadDeptDeptDiv").show();
            $("#synergeticDeptDiv").show();
            break;
        case 4:
            $("#nameTitle").html("诊断点：");
            break;
        default:
            $("#nameTitle").html("诊断项目：");
            break;
    }
}

function showSelectText(){
	$("#inputText").find("input,select").attr("disabled","disabled");
	 $("#selectText").show();
	 $("#inputText").hide();
}

function showInputText(){
	$("#selectText").find("input,select").attr("disabled","disabled");
	 $("#selectText").hide();
	 $("#inputText").show();
}

function setIndicatTitle(type) {
    switch (type) {
        case 1:
            $("#indicat-title").html("添加项目");
            break;
        case 2:
        	$("#indicat-title").html("添加要素");
            break;
        case 3:
        	$("#indicat-title").html("添加指标");
            break;
        default:
            $("#indicat-title").html("添加");
            break;
    }
}

function showContent(){
	//显示添加指标
	$(".content-item").show();
	$(".content-list").hide();
	$(".content-item").find("input,select,textarea").removeAttr("disabled");
	$(".content-item").find("input,select,textarea").removeClass("disabled")
	$(".content-item").find(".label").hide();
	$(".content-item").find(".input-view").hide();
	$(".content-item").find(".must").css("display","inline-block");
	$("#set_role").css("display","inline-block");
	$("#content_id").val('');
	$("#name").val('');
	$("#remark_f").val('');
}

function showCatalog(){
	//显示添加层级
	$(".content-list").show();
	$(".content-item").hide();
	$(".content-list").find("input,select,textarea").removeAttr("disabled");
	$(".content-list").find("input,select,textarea").removeClass("disabled")
	$(".content-list").find(".must").css("display","inline-block");
	$(".content-list").find(".input-view").hide();
	$(".btn-s-c").show();
	$("#catalog_id").val('');
	$("#project").val('');
	$("#remark_t").val('');
}

//保存诊断指标
function saveCatalog(obj){
	var form = $("#frmAddOrEditCatalog");
	$.post(form.attr("action"),form.serialize(),function(result){
		if(result.success){
			loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
		}
	});
}
//保存指标内容
function saveContent(obj){
	var form = $("#frmAddOrEditContent");
	$.post(form.attr("action"),form.serialize(),function(result){
		if(result.success){
			loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
		}
	});
}

//修改事件
function update(){
	$("#modify").hide();
	//层级修改显示
	$(".content-list").find("input,select,textarea").removeAttr("disabled");
	$(".content-list").find("input,select,textarea").removeClass("disabled")
	$(".content-list").find(".must").css("display","inline-block");
	$(".content-list").find(".input-view").hide();
	//指标修改显示
	$(".content-item").find("input,select,textarea").removeAttr("disabled");
	$(".content-item").find("input,select,textarea").removeClass("disabled")
	$(".content-item").find(".label").hide();
	$(".content-item").find(".must").css("display","inline-block");
	$(".content-item").find(".input-view").hide();
	$("#type").next(".select2").show();
	$("#set_role").hide();
	$("#set_role").css("display","inline-block");
	$(".btn-s-c").show();
	$("#name-d").attr("disabled","disabled");
}

//取消事件
function cancelModify() {
	$("#modify").show();
	onClick(selectedNode);
}