function autoSetTableWidth(dom) {
	var $table = dom;
	var $cols = $table.find("thead").find("td").not("[colspan]"); //获取没有合并列的th的高度
	var table_width = 0;
	var get_width = function(text) {
		var text_len = text.length;
		var ret_width_value = 0;
		if(text_len > 31) {
			ret_width_value = 250;
		}
		if(text == false) {
			ret_width_value = 30;
		}
		return ret_width_value;
	};
	$cols.each(function(i) {
		var th_width = 0;
		var text = $(this).text();
		if($(this).attr("width")) {
			th_width = parseInt($(this).attr("width").replace("px", ''));
		} else {
			th_width = get_width(text);
			$(this).css("width", th_width + "px");
		}
		table_width += th_width;
	});
	table_width_z = table_width + $cols.length + ($cols.length * 30);
	$(".list_table").css("width", table_width + "px")
//	$table.css("width", table_width_z + "px");
}

$(document).ready(function(){
	autoSetTableWidth($("#dataTable"));
	init();
	$(window).resize(function(){
		init();
	});
	function init(){
		//计算table的高度
		//获取父窗口frame的高度
		var _hMax = window.parent.document.getElementById("mainContent").offsetHeight;
		if(_hMax){
			var ht = $("body>.title").innerHeight()?$("body>.title").innerHeight():0;
			var htool = $(".tool-bar").innerHeight()?$(".tool-bar").innerHeight():0;
			var hpage = $(".pagin").innerHeight()?$(".pagin").innerHeight():0;
			var hthead = $(".list_table").find("thead").innerHeight()?$(".list_table").find("thead").innerHeight():0;
			var h = _hMax - ht - htool - hpage - hthead - 10 *2;
			var tbtrNum = $(".list_table").find("tbody").find("tr").length;
			var htbody = $(".list_table").find("tbody").find("tr").innerHeight() * tbtrNum;
			var wbox = $(".table-box").innerWidth();
			var wtable = $(".list_table").innerWidth();
			if(wtable >wbox){
				h = h - 20;
			};
			if(htbody >h){
				console.log(htbody,h)
				$(".list_table").find("tbody").css("height",h + "px");
				$(".list_table thead,.list_table tbody").css({
					"overflowY":"scroll",
					"overflowX":"hidden"
				});
			}else{
				$(".list_table thead,.list_table tbody").css({
					"overflowY":"auto",
					"overflowX":"hidden"
				});
			}
		}
	}
})

