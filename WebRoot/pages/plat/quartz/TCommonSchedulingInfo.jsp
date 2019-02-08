<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-9 19:13:31
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="editBlock">
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>调度设置信息查看</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">调度设置信息 </td>
			</tr>
       <tbody>
       <tr>
    	   <th width="120">任务名称：</th>
           <td>${bean.taskname}</td>
        </tr>
       <tr>
    	   <th width="120">实例方式：</th>
           <td>
           		<x:cache subject="ISTMED_TYPE" option="false" key="${bean.istmed}"></x:cache>
           </td>
        </tr>
       <tr>
    	   <th width="120">任务实现类：</th>
           <td>${bean.jobclass}</td>
        </tr>
       <tr>
    	   <th width="120">是否有效：</th>
           <td>${bean.valid}</td>
        </tr>
       <tr>
    	   <th width="120">任务类型：</th>
           <td>
           		<x:cache subject="SCHEDULING_TYPE" option="false" key="${bean.type}"></x:cache>
           </td>
        </tr>
       <tr>
    	   <th width="120">cron表达式：</th>
           <td>${bean.cron}</td>
        </tr>
       <tr>
    	   <th width="120">任务状态：</th>
           <td>
           		<x:cache subject="ENABLE_STATUS" option="false" key="${bean.states}"></x:cache>
            </td>
        </tr>
       <tr>
    	   <th width="120">任务参数JSON数据：</th>
           <td>${bean.params}</td>
        </tr>
       <tr>
    	   <th width="120">排序号：</th>
           <td>${bean.seq}</td>
        </tr>
       <tr>
    	   <th width="120">备注说明：</th>
           <td>${bean.des}</td>
        </tr>
       <tr>
    	   <th width="120">已运行次数：</th>
           <td>${bean.runtimes}</td>
        </tr>
	  			 <tr>
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
 </div>   <!--editBlock END-->
  </form>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
