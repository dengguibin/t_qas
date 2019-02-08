//by su.ke

//jquery based
$(document).ready(function() {

////////////////////// 导航菜单 begin //////////////////////
	$("#topLogo").find("span").hover(function(){$(this).addClass("hover")},function(){$(this).removeClass("hover")});
	$("#leftBar").find("span").hover(function(){$(this).addClass("hover")},function(){$(this).removeClass("hover")});
	$("#btBack").click(function(){ history.back() })
	$("#btForward").click(function(){ history.forward() })
	$("#btHomepage").click(function(){ $("#helpMainFrame").get(0).src="welcome.html" })
	$("#showIcon").hide();
	$("#toggleMenu").click(function(){ $("#leftBar").hide();$("#showIcon").show() })
	$("#showIcon").click(function(){ $("#leftBar").show();$("#showIcon").hide() })
////////////////////// 导航菜单 end ////////////////////////

})

