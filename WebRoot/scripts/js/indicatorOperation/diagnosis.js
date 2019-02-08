$(document).ready(function() {
	
	getTreeHeight();             //获取父窗口frame的高度
	
	getValidform();             //表单验证（表单提交成功后加载树形结构）
	
	selectShowAndHide();       //搜索框的显示隐藏
	
	initSqlTextArea();        //EditArea在线编辑器
	
	hierarchyTips();         //添加指标、添加层级处的tips提示
	
	addDatarule();          //添加数据规则
	
	//加载树形结构
	loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','');
	
	//添加指标、添加层级处理的点击事件
	//事件代理,通过li的index判断当前点击的是哪一个
	hierarchyClick();
	
	/**
	 * 文本框根据输入内容自适应高度
	 * @param                {HTMLElement}           输入框元素
	 * @param                {Number}                设置光标与输入框保持的距离(默认0)
	 * @param                {Number}                设置最大高度(可选)
	 */
	calculateHeight();
	
	//input获取焦点
	$("input.inputxt,select,textarea").focus(function(){
		$(this).addClass("in-focus");
	});
	$("input,select,textarea").blur(function(){
		$(this).removeClass("in-focus");
	})
	
	//下拉框
	$("#indicatordatatype,#indicatorDataTrend,#ismonitor,#name-s").select2({
		width:'resolve',
	});
	
	//ztree 单击之前的事件
	function beforeClick(treeId, treeNode, clickFlag) {
	}

});


//获取父窗口的高度并计算出树形结构的高度
function  getTreeHeight() {  
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
	}
}


//表单验证(表单提交成功后加载树形结构)
function getValidform() {
	frmAddOrEditCatalog = $("#frmAddOrEditCatalog").Validform({   //表单验证
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
			if($("#indicatortype").val()==1){
				$("#name-d").val($("#name-s").find("option:selected").text());
			}
			var form = $("#frmAddOrEditCatalog");
			$.post(form.attr("action"),form.serialize(),function(result){ //表单提交成功
				if(result.success){
					loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);  //加载树形结构
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
			$("#sqlstring").val(editAreaLoader.getValue('sqlstring'));
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

//搜索框的显示隐藏
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


//添加指标、添加层级处理的点击事件
//事件代理,通过li的index判断当前点击的是哪一个
function hierarchyClick() {
	$("#a_d").on("click","li",function(){
		var idx = $(this).index();                             //返回指定元素相对于其他指定元素的 index位置
		var type = parseInt(selectedNode.indicatortype)       //树形结构类型（指标，要素，项目，类型）
		if(type == 0 && idx != 3){			                 //指标
			return ;
		}else if(type != 0 && idx == 3 && selectedNode.children.length>0){        //非指标
			return ;
		}
		if(idx != 0 && idx != 3){
			$(".btn-s-c").show();
			if($(".row-r").find("select#type")){
				$(".row-r").find("select#type").show();
				$("#type").next(".select2").show();
				$(".row-r").find("#type-d").hide();
			};
			$("#a_d .icon").removeClass("select");
			$(this).find(".icon").addClass("select");
		};
		if(idx == 0){
			return;
			//移动层级
			var zTree = $("#dia_tree").html();
			layer.open({
			  	type: 1,
			  	title:'<i class="s_logo"></i>请选择指标保存路径',
			  	skin: 'layui-layer-demo', //样式类名
			  	area: ['600px', '340px'], //宽高
			  	anim: 2,
			  	btn:["新建层级","确定","关闭"],
			  	shadeClose: true, //开启遮罩关闭
			  	content: '<div class="ztree"><div id="tree_2"></div></div>',
			  	success: function(layero, index){
					var setting2 = {
						callback: {
							beforeClick: null, //用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作,可用于判断是否允许用户选择或取消点击操作
							beforeCheck: null, //根据返回值确定是否允许 勾选 或 取消勾选
							onClick: null, //用于捕获节点被点击的事件回调函数
							beforeRemove:beforeRemove,//用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
							beforeRename:beforeRename,//用于捕获节点编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新节点名称数据之前的事件回调函数，并且根据返回值确定是否允许更改名称的操作
							onRemove:onRemove,//用于捕获删除节点之后的事件回调函数。
							onRename:onRename,//用于捕获节点编辑名称结束之后的事件回调函数。
						},
						check: {
							autoCheckTrigger: false, //自动关联勾选时是否触发 beforeCheck / onCheck 事件回调函数。
							chkboxType: {
								"Y": "ps",
								"N": "ps"
							}, //勾选 checkbox 对于父子节点的关联关系,此选项是父子相互联系
							chkStyle: "radio", //多选。（如果是单选框）chkStyle:"radio",radioType:{ "Y": "ps", "N": "ps" },
							enable: false, //是否显示单选框或者是多选框
							
						},
						edit:{
							enable:true,
							removeTitle:"删除",
							renameTitle:"重命名",
							drag:{
								isCopy:false,//
								isMove:true,//
								borderMax:10,//拖拽节点成为根节点时的 Tree 内边界范围 (单位：px)，默认10
								borderMin:-5,//拖拽节点成为根节点时的 Tree 外边界范围 (单位：px)，默认是-5
							},
							showRemoveBtn:true,
							showRenameBtn:true,
						}
					};
//					$.fn.zTree.init($("#tree_2"), setting2, zNodes);
					
				},
			  	yes:function(index, layero){
			  		//实际上是左边第一个按钮的回调，在这里就是新建层级的回调
			  		//这里的操作只是前台页面改了，数据库没有改，具体操作可在回调函数里面设置
			  		var treeObj = $.fn.zTree.getZTreeObj("tree_2");
			  		var _node = treeObj.getSelectedNodes()[0];
			  		var parentNode = _node?_node:null;
			  		var newNode = {name:"新建层级"};
			  		newNode = treeObj.addNodes(parentNode, newNode);//新建节点
			  		treeObj.editName(newNode[0]);//设置新建的节点进入编辑模式
			  		
			  	},
			  	btn2:function(){
			  		//确定按钮的回调
			  		
			  	},
			  	btn3:function(){
			  		//取消按钮回调
			  	},
			  	cancel:function(index, layero){
			  		//右上角关闭按钮触发的回调
			  	}
			});
		}else if(idx == 1){
			$("#modify").hide();
			if(type == 3){
				$("#content_pid").val(selectedNode.id);
				showContent();
			}else{
				setNodeLevel(type+1);
				$("#indicatortype").val(type+1);
				$("#catalog_pid").val(selectedNode.id);
				showCatalog();
				showInputText();
			}
		}else if(idx == 2){
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
		}else{
			//删除
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

//添加指标、添加层级处的tips提示
function hierarchyTips() {
	$(".show-tip").hover(function(){ //鼠标悬停时执行的两个方法
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
	$(".content-item").on("click", "#set_role", function() {
		// 点击出来一个弹窗
		layer.open({
			title : '<i class="s_logo"></i>添加数据规则',
			type : 1,
			skin : 'layui-layer-demo', // 加上边框
			area : [ '420px', '240px' ], // 宽高
			title : "数据规则",
			content : 'html内容'
		});
	})
} 

/**
 * 文本框根据输入内容自适应高度
 * @param                {HTMLElement}           输入框元素
 * @param                {Number}                设置光标与输入框保持的距离(默认0)
 * @param                {Number}                设置最大高度(可选)
 */
function calculateHeight() {
	
	var autoTextarea = function(elem, extra, maxHeight) {
		extra = extra || 0;
		var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
			isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
			addEvent = function(type, callback) {
				elem.addEventListener ?
					elem.addEventListener(type, callback, false) :
					elem.attachEvent('on' + type, callback);
			},
			getStyle = elem.currentStyle ? function(name) {
				var val = elem.currentStyle[name];

				if(name === 'height' && val.search(/px/i) !== 1) {
					var rect = elem.getBoundingClientRect();
					return rect.bottom - rect.top -
						parseFloat(getStyle('paddingTop')) -
						parseFloat(getStyle('paddingBottom')) + 'px';
				};

				return val;
			} : function(name) {
				return getComputedStyle(elem, null)[name];
			},
			minHeight = parseFloat(getStyle('height'));

		elem.style.resize = 'none';

		var change = function() {
			var scrollTop, height,
				padding = 0,
				style = elem.style;

			if(elem._length === elem.value.length) return;
			elem._length = elem.value.length;

			if(!isFirefox && !isOpera) {
				padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
			};
			scrollTop = document.body.scrollTop || document.documentElement.scrollTop;

			elem.style.height = minHeight + 'px';
			if(elem.scrollHeight > minHeight) {
				if(maxHeight && elem.scrollHeight > maxHeight) {
					height = maxHeight - padding;
					style.overflowY = 'auto';
				} else {
					height = elem.scrollHeight - padding;
					style.overflowY = 'hidden';
				};
				style.height = height + extra + 'px';
				scrollTop += parseInt(style.height) - elem.currHeight;
				document.body.scrollTop = scrollTop;
				document.documentElement.scrollTop = scrollTop;
				elem.currHeight = parseInt(style.height);
			};
		};

		addEvent('propertychange', change);
		addEvent('input', change);
		addEvent('focus', change);
		addEvent('blur', change);
		addEvent('load', change);
		change();
	};
	var _prov = document.getElementById("problemoverview");
	var _sugv = document.getElementById("suggestionoverview");
	autoTextarea(_prov); 
	autoTextarea(_sugv); 
}


//二级弹窗中的相关操作事件
function beforeRemove(treeId,treeNode){
	
};
function beforeRename(treeId,treeNode,newName,isCancel){
	
};
function onRemove(){
	
};
function onRename(){
	
};

//EditArea在线编辑器
function initSqlTextArea(){
	editAreaLoader.init({
		id: "sqlstring"	// id of the textarea to transform		
		,start_highlight: true	// if start with highlight
		,allow_resize: "both"
		,allow_toggle: false
		,word_wrap: true
		,toolbar: "fullscreen,|,test_select,search, |, undo, redo, highlight, reset_highlight, |"
		,plugins: "test"
		,language: "zh"
		,syntax: "sql"	
	});
}

/*var checkAllParents = (function f(treeNode){
	 	//判断父节点是否是tree最顶端的祖先节点
		if (treeNode==null || treeNode.index== 1) {
			return treeNode;
		}
		else{
			treeNode.checked=true;
			var _name = f(treeNode.getParentNode()).name;
			return f(treeNode.getParentNode());
		}
	})*/
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
	if(treeNode == null || treeNode.pId == 1) {		//树形结构加载失败
		return treeNode.name;
	} else {									  //树形结构加载成功
		getTreeSuccess(treeNode);
	}

}
//加载树形结构成功
function getTreeSuccess (treeNode) {
	var _node = treeNode.getPath(); // 获取刚节点的所有父节点，包括他本身（获取到的是一个数组）
	var txt = "";
	for ( var j = 0; j < _node.length; j++) {
		if (j == _node.length - 1) {
			txt += _node[j].name_;
		} else {
			txt += _node[j].name_ + "  &gt;&gt;  ";
		}
	}
	$("#tab_name").html(txt);        // 当前指标的层级显示

	var type = treeNode.indicatortype;   //0代表指标，1代表类型，2代表项目，3代表要素
	setNodeLevel(treeNode.indicatortype)
	setIndicatTitle(treeNode.indicatortype); // 层级事件操作（删除，增加）

	if (type == '1') { // 修改事件的显示与隐藏
		$("#modify").hide();
	} else {
		$("#modify").show();
	}
	$(".btn-s-c").hide();       // 保存，取消事件的隐藏
	if (type != '0') {         // 非指标（类型，项目，要素）树形结构点击事件
		noIndex(treeNode);
	} else {
		index(treeNode);     // 指标树形结构点击事件
	}
}

function  noIndex(treeNode) {
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
	var extend;
	$.post('${ctx}/indicatorOperation/indicatorcatalog/queryInfo.action', {"bean.id":id}, function(result) {
		extend = result.data.exten;
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

function index (treeNode) {
	$(".add-indicat i").removeClass("add-metrics-icon").addClass("add-metrics-unable");
	$(".add-index i").removeClass("add-index-icon").addClass("add-index-unable");
	$(".delete i").removeClass("delete-unable").addClass("delete-icon");
	//查询数据库
	var result;
	var extend;
	var id = treeNode.id;
	$.post('${ctx}/indicatorOperation/indicatorcontent/queryInfo.action', {"bean.id":id}, function(results) {
		debugger
		if(results.success){
			result = results.data.bean;
			extend = results.data.exten;
			var catalog  = results.data.catalog;
			if(extend != null){
				$("#indicatorcatalogid").val(extend.indicatorcatalogid);
				$("#problemoverview").val(extend.problemoverview);
				$("#suggestionoverview").val(extend.suggestionoverview);
				$("#problemoverview").next().text(extend.problemoverview);
				$("#suggestionoverview").next().text(extend.suggestionoverview);
			}else{
				$("#indicatorcatalogid").val('');
				$("#problemoverview").val('');
				$("#suggestionoverview").val('');
				$("#problemoverview").next().text('');
				$("#suggestionoverview").next().text('');
			}
			if(result != null){
				var _nodename = result.name_ ;
				var _nodeRe = result.remark;
				var _standard  = result.standard;
				var _sqlstring = result.sqlstring;
				$("#name").val(_nodename);
				$("#standard").val(_standard);
				$("#name").parent().attr("title",_nodename);
				$("#remark_f").val(_nodeRe);
				$("#remark_f").next().text(_nodeRe);
				 //加载数据字典
				$("#indicatordatatype").val(result.indicatordatatype).trigger("change");  
				$("#indicatorDataTrend").val(result.indicatordatatrend).trigger("change");
				
				if (result.indicatordatatype == 2) {     //指标数据类型为判断型不显示数据走势
					$("#datatrend").hide();
				}
				if (result.indicatordatatype == 1) {
					$("#datatrend").show();
				}
				editAreaLoader.setValue("sqlstring",_sqlstring);
				var atomStyle = "";//指标样式
				$("select option").each(function(index,value){
					//console.log($(this).val());
					if($(this).val()==result.atomid){
						$(this).prop("selected",true);
						atomStyle = $(this).text();
					}
				});
				if($(".row-r").find("select#type")){
					$(".row-r").find("select#type").hide();
					$("#type").next(".select2").hide();
					$(".row-r").find("#type-d").show().text(atomStyle);
				}
			}
			if(catalog != null) {
				$("#ismonitor").val(catalog.ismonitor).trigger("change");
			}
		}else{
			 layer.msg(results.msg, {
					icon: 2,
					time:1500//1.5s后关闭
				});
		 }
		window.top.closeLoad();
	});
	$(".content-list").hide();
	$(".content-item").show();
	$(".content-item").find("input,select,textarea").attr("disabled","disabled");
	$(".content-item").find("input,select,textarea").addClass("disabled");
	$(".content-item").find(".must").hide();
	$(".content-item").find(".label").show();
	$(".content-item").find(".input-view").show();
	$("#set_role").hide();
	$("#content_id").val(treeNode.id);
	$("#content_pid").val(treeNode.parentid);
}
//加载树形结构
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
				time : 1500
			// 1.5s后关闭
			});
		}
        window.top.closeLoad();    // 调用最顶层页面的方法
	});
}
	
function bindTree(zNodes,selectNodeId){
	formatNode(zNodes);
	var zTree = $.fn.zTree.init($("#dia_tree"), setting, zNodes);   //初始化ztree
	if(zNodes.length > 0){
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

//判断是否为指标
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
function getChildren1(treeNode, result) {
    if (treeNode.isParent) {
        var childrenNodes = treeNode.children;
        if (childrenNodes.length>0) {
            result = getChildren1(treeNode.children[0]);
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


function showContent(){
	//显示添加指标
	$(".content-item").show();
	$(".content-list").hide();
	$(".content-item").find("input,select,textarea").removeAttr("disabled");
	$(".content-item").find("input,select,textarea").removeClass("disabled");
	$(".content-item").find(".label").hide();
	$(".content-item").find(".input-view").hide();
	$(".content-item").find(".must").css("display","inline-block");
	$(".content-item").find("textarea").css("height","74px");
	$("#set_role").css("display","inline-block");
	$("#content_id").val('');
	$("#name").val('');
	$("#remark_f").val('');
	$("#problemoverview").val('');
	$("#problemdetail").val('');
	$("#suggestionoverview").val('');
	$("#suggestiondetail").val('');
}
function showCatalog(){
	//显示添加层级
	$(".content-list").show();
	$(".content-item").hide();
	$(".content-list").find("input,select,textarea").removeAttr("disabled");
	$(".content-list").find("input,select,textarea").removeClass("disabled")
	$(".content-list").find(".must").css("display","inline-block");
	$(".content-list").find(".input-view").hide();
	$(".content-list").find("textarea").css("height","74px")
	$(".btn-s-c").show();
	$("#catalog_id").val('');
	$("#project").val('');
	$("#remark_t").val('');
	$("#problemoverviews").val('');
	$("#problemdetails").val('');
	$("#suggestionoverviews").val('');
	$("#suggestiondetails").val('');
}
//保存诊断指标
function saveCatalog(obj){
	$("#name-d").val($("#name-s").find("option:selected").text());
	var form = $("#frmAddOrEditCatalog");
	$.post(form.attr("action"),form.serialize(),function(result){
		if(result.success){
			loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
		}
	});
}
//保存指标内容
function saveContent(obj){
	$("#sqlstring").val(editAreaLoader.getValue('sqlstring'));
	var form = $("#frmAddOrEditContent");
	$.post(form.attr("action"),form.serialize(),function(result){
		if(result.success){
			loadTreeData('${ctx}/indicator/indicatorcatalog/getTree.action','',result.data.id);
		}
	});
}

//修改点击事件
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
	$("#indicatordatatype").next(".select2").show();
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