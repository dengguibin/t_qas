$(document).ready(function() {

	//表格的操作按钮
	//发布按钮
	$(".opt").on("click",".td-opt-btn",function(){
		var _class = $(this).attr("class");
		if(RegExp("td-opt-modify").test(_class)){
			//修改
			window.location.href = "../pages/dTasksModify.html";
		}else if(RegExp(" td-opt-detail").test(_class)){
			//查看
			window.location.href = "../pages/dTasksDetail.html";
		}else if(RegExp("td-opt-release").test(_class)){
			//发布
			layer.confirm('您确定要发布吗？', {
				title:'提示',
				icon: 3,//4是锁的图标
				btn: ['确定', '取消'] //按钮
			}, function() {
				layer.msg('已发布', {
					icon: 1,
					time: 1500 //1.5s后关闭
				});
			}, function() {
				layer.msg('已取消该操作', {
					icon: 2,
					time: 1500 //1.5s后关闭
				});
			});
		}else if(RegExp("td-opt-delect").test(_class)){
			//删除
			layer.confirm('您确定要删除该任务吗？', {
				title:'提示',
				icon: 7,//4是锁的图标
				btn: ['确定', '取消'] //按钮
			}, function() {
				layer.msg('已删除', {
					icon: 1,
					time: 1500 //1.5s后关闭
				});
			}, function() {
				layer.msg('已取消该操作', {
					icon: 2,
					time: 1500 //1.5s后关闭
				});
			});
		}
		
	})

})
