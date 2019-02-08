$(document).ready(function(){
	//新增模型
	$("#add_program").click(function(){
		//点击出来一个弹窗
		layer.open({
			id: 'addDiagnoseSchemeform',
		  	type: 2,
		  	skin: 'layui-layer-demo', //加上边框
		  	area: ['500px', '360px'], //宽高
			shadeClose: true,
		  	shade: 0.4,
		  	title:"新建诊断模型",
		  	content: 'addDiagnoseScheme.action?menuId='+$("#menuId").val(),
		  	title:'<i class="s_logo"></i>新建诊断模型',
		  	btn:["下一步"],
		  	yes:function(){
		  		var frameId=document.getElementById('addDiagnoseSchemeform').getElementsByTagName("iframe")[0].id;
		  	    $('#'+frameId)[0].contentWindow.mySubmit();
		  	}
		});
	})
	
	//配置、修改、删除按钮的显示隐藏
	//
	$("#in_list").find(".in-list-item").hover(function(){
		$(this).find(".btn-list").addClass("show");
		$(this).find(".btn-list").removeClass("hide");
	},function(){
		$(this).find(".btn-list").addClass("hide");
		$(this).find(".btn-list").removeClass("show");
	});
	
	//排序列表的显示隐藏
	$(".sort-icon").click(function(){
		$(".sort-list").show();
	})
	$(".sort-list").on("click","li",function(){
		$(".sort-list").hide();
	});
	
	//获取父窗口frame的高度
	var _hMax = window.parent.document.getElementById("mainContent").offsetHeight;
	var _hPagin = $(".pagin").innerHeight() ? $(".pagin").innerHeight() : 0;
	var a = $(".top").innerHeight();
	var b = $("body>.title").innerHeight()
	var _h = _hMax - $(".top").innerHeight() - $("body>.title").innerHeight() - 16 * 2;
	
	$(".list").css({
		"height":_h+"px",
		"overflow":"auto",
	});
	
	$(".year-t").each(function(){
		$(this).click(function(){
			var status = $(this).find("input");
			if(status.val()==0){
				status.val("1")
				$(this).find("i").addClass("tubiao2").removeClass("tubiao1");
				$(this).find("span").text("点击隐藏全部");
				$(this).next().children().show();
			}else{
				status.val("0")
				$(this).find("i").addClass("tubiao1").removeClass("tubiao2");
				$(this).find("span").text("点击展开全部");
				$(this).next().children().hide();
			}
		});
	});
})
//回车搜索
$(document).keydown(function(e) {
	if(e.keyCode == 13) {
		opreate('','query');
	}
});
function  opreate1(args,opCode){
	var baseUrl = "${ctx}/diagnose/diagnosescheme/";
	//加上随机请求参数，防止浏览器缓存显示数据不正确
	var query = "?bean.id="+args+"&v="+Math.random();
	 if('queryList' === opCode){
		baseUrl += "queryList.action";
		$("#updatedtime").val(args);
		$("#opForm").attr("action",baseUrl).submit();
	}else if('query' === opCode){
		$("#opForm").submit();
	}
}

function  opreate2(args,opCode){
	var baseUrl = "${ctx}/diagnose/diagnosescheme/";
	//加上随机请求参数，防止浏览器缓存显示数据不正确
	var query = "?bean.id="+args+"&v="+Math.random();
	 if('queryList' === opCode){
		baseUrl += "queryList.action";
		$("#rangetype").val(args);
		$("#opForm").attr("action",baseUrl).submit();
	}else if('query' === opCode){
		$("#opForm").submit();
	}
}

function  opreate(args,opCode){
	var baseUrl = "${ctx}/diagnose/diagnosescheme/";
	//加上随机请求参数，防止浏览器缓存显示数据不正确
	var query = "?v="+Math.random();
	 if('queryList' === opCode){
		baseUrl += "queryList.action";
		if(args == 'time'){
			$("#updatedtime").val("2017-1-1");
		}else if(args == "type"){
			$("#rangetype").val("1");
		}else{
			$("#id").val(args);
		}
		$("#opForm").attr("action",baseUrl).submit();
	}else if('query' === opCode){
		$("#opForm").submit();
	}
}


//删除
function del(obj,id){
	layer.confirm('您确定要删除该指标吗？', {
		title:"提示",
		icon: 7,
		btn: ['确定','取消'] //按钮
	}, function(){
		$.post("${ctx}/diagnose/diagnosescheme/remove.action",{"diagnose.id":id},function(data){
			if(data.success){
				layer.msg(data.msg, {
					icon: 1,
					time:1500//1.5s后关闭
				});
				$(obj).parent().parent().parent().remove();
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

