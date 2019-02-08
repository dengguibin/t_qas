<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    	<meta http-equiv="X-UA-Compatible" content="ie=edge"/>
		<title>诊断报告模板</title>
		
		
		<style>
		
			*{
				margin: 0;
				padding: 30px;
				font-size: 16px;
				font-family: "微软雅黑";
				font-family: "宋体";
			}
			body{
				margin: 0;
				padding: 0;
				padding: 30px;
            	width: 600px;
			}
			ul {
				display: block;
				margin: 0;
				padding: 0;
				list-style: none;
			}
			li {
				display: block;
				margin: 0;
				padding: 0;
			}
			img {
				border: 0;
			}
			
			table {
				border-collapse: collapse;
				border-spacing: 0;
			}
			h2 {
				font-weight: normal;
			}

			.weight{
				font-weight: 600;
			}
			.green{
				color: #29c353;	
			}
			.black{
				color: #000;
			}
			.red{
				color: #ff3700;
			}
			.paragraph{
				padding-bottom: 10px;
			}
			.title{
				text-align: center;
				font-weight: 500;
				color: #000;
			}
			.title-1{
				font-weight: 500;
				font-size: 40px;
			}
			.title-2{
				font-weight: 600;
				
			}
			.title-3{
				font-weight: 600;
			}

			/*段落*/
			/*一级标题*/
			.title-one{
				font-weight: 600;
				font-size: 24px;
				padding: 20px 0;
			}
			p.content{
				text-indent: 2em;
				color: #333;
				line-height: 2;
			}
			p.content-not{
				color: #333;
				line-height: 1.6;
			}
			p.content-item{
				color: #333;
				line-height: 1.6;
			}
			.img-box{
				text-align: center;
				width:200px;
				height:100px;
				margin:0 ;
				margin-bottom: 10px;
			}
			.img-box1{
				text-align: center;
				width:450px;
				height:100px;
				margin:0 auto;
				margin-bottom: 10px;
			}
			.img-box>img{
				/*width: 100%;*/
				width:200px;
				height:100px;
				margin:0 auto;
				margin-bottom: 10px;
			}
			.img-box .img-msg{
				width: 94px;
            	height: 134px;
				text-align: center;
				padding-bottom: 10px;
			}

			/*二级标题*/
			.title-sub{
				font-weight: 600;
				font-size: 22px;
				padding: 16px 0;
			}
			/* 三级标题*/
			.title-third{
				font-weight: 600;
				font-size: 20px;
				padding: 14px 0;
			}

			/*list列表*/
			.list{
				text-indent:2em;
			}
			.list .item .item-t{
				display:inline;
				font-weight: 600px;
				line-height: 1.6;
				padding-bottom: 6px;
			}
			.item-q,.item-s{
				padding-bottom: 6px;
			}
			.item-q>span,.item-s>span{
				line-height: 1.6;
			}
			.content-t{
				line-height: 2;
			}
			/*行内块元素的列表*/
			.list-inline{
				padding: 10px 0;
			}
			.item-inline{
				margin-right: 20px;
			}
			.item-inline>img{
				width: 20px;
			}
			.item-inline .czjz{
				position: relative;
				top: -6px;
			}

			/*表格*/
			.table{
				width: 100%;
				table-layout: fixed;
				border-right: 1px solid #ccc;
				border-bottom: 1px solid #ccc;
			}
			.table td,.table th{
				border-left: 1px solid #ccc;
				border-top: 1px solid #ccc;
				padding: 10px 6px;
				font-size: 14px;
			}
			.table td{
				line-height: 1.6;
			}
			.table th{
				color: #000;
				background: #d2e9f9;
			}

		
		</style>
		
		
		
	</head>
	<body>
		<div class="title">
			<br/><br/>
			<div class="title-1">${analyGeneral.generalOverview.objName}内部质量保证体系自我诊改报告</div>
			<br/>
			<div class="title-2">(${time})</div>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
			<p class="title-3">深圳市德信软件技术有限公司</p>
			<div class="img-box1">
					<!-- 公司logo-->
					<img src="D:\logs\deceen.png" style="width: 60%;" />
			</div><br/><br/>
		</div>
		
		<!--模块-->
		<div>
			<!-- 1.	总体概况-->
			<div class="paragraph">
				<h1 class="title-one">1. 总体概述</h1>
				<p class="content">
					&nbsp;本报告由德信软件技术有限公司安质量保证系统根据学校《${analyGeneral.generalOverview.objName}诊断方案》，以${time}的数据作为诊断数据源，对${analyGeneral.generalOverview.objName}进行综合诊断分析，并形成该诊断报告。
				</p>
				<p class="content">
					根据《${analyGeneral.generalOverview.objName}》的指标体系及计分规则，本次诊断综合评分为：
					
					<span class="green weight">
							${analyGeneral.generalOverview.score}</span>分，
						其中量化指标:${analyGeneral.generalOverview.quantitativeMap.num}
						,得分:${analyGeneral.generalOverview.quantitativeMap.score}分
						(合格：${analyGeneral.generalOverview.quantitativeMap.qualifiedNum}个，
						预警：${analyGeneral.generalOverview.quantitativeMap.earlyWarningNum}个，
						不合格：${analyGeneral.generalOverview.quantitativeMap.unqualifiedNum}个)，
						标志性成果:${analyGeneral.generalOverview.signMap.num},
						达成度:${analyGeneral.generalOverview.signMap.achieve}%,


						国家级：0个，省级：0个，地市级：0，院校级：0个)。
				</p>
				<p class="content">
					本次诊断产品造型设计专业位列第${analyGeneral.generalOverview.ranking!''}名，诊断结论为：
					<span class="green weight">
						${analyGeneral.generalOverview.fruit}
					</span>
					。
				</p>
				<div class="img-box">
					<img src="D:\logs\001.png" style="width: 60%;"/>
					<p class="img-msg">图1 得分对比分析</p>
				</div>
				
				<!-- h2 1.1.	合格率分析-->
				<h2 class="title-sub">1.1.	合格率分析</h2>
				<p class="content">
					本次从${analyGeneral.itemsMap.itemsAndObj}进行了诊断，总体达标率为：
					<span class="black weight">
						${analyGeneral.itemsMap.standardRate}
					</span>
					。
				</p>
				<div class="img-box">
					<!-- 雷达图 -->
					<img src="D:\logs\11.png" style="width: 60%;" />
					<p class="img-msg">图2 各诊断项目合格率分析</p>
				</div>
				
				<!---->
				<h2 class="title-sub">1.2.	该项目存在的问题描述及改进意见：</h2>
				<ul class="list">
				
				<#list analyGeneral.questionList as questionMap>
					<li class="item">
						<div class="item-q">
							<span class="padding: 16px 0;">${questionMap.name}</span><br/>
							<span class="red">问题描述：</span><br/>
							<span class="item-msg">
								&nbsp;&nbsp;${questionMap.questioninfo}
							</span>
						</div>
						<div class="item-s">
							<span class="green">改进建议：</span><br/>
							<span class="item-msg">
								&nbsp;&nbsp;${questionMap.suggestioninfo}
							</span>
						</div>
					</li>
					</#list>
				</ul>	
			</div>
			<h2 class="title-sub">1.3.	指标诊断明细</h2>
					<div class="table-box">
					
					<table class="table">
							<thead>
								<tr>
									<th width="15%">序号</th>
									<th width="60%">指标名称</th>
									<th width="15%">诊断结果</th>
									<th width="10%">合格值</th>
								</tr>
							</thead>
							
							<tbody>
							
							
								<tr>
									<td>1</td>
									<td>00</td>
									<td>000</td>
									<td>000</td>
								</tr>
							</tbody>
						</table>
				</div>
			
				<h2 class="title-sub">1.5.	标志性成果</h2>
			
			<!-- 2.	项目详情-->
			<div class="paragraph">
				<h1 class="title-one">2.	项目详情</h1>
				<#list itemPageResult as itemPage>
					<h2 class="title-sub">2.${itemPage_index+1}	${itemPage.itemName}</h2>
					
						<p class="content-item">
						&nbsp;&nbsp;本次从<#list itemPage.elements as eleme>${eleme.elementName},</#list>
						这些方面对${itemPage.itemName}进行了诊断，总体达标率为 
						
						<span class="green weight">${itemPage.standardRate}</span>。<br/>
								<span class="">&nbsp;&nbsp;诊断要素的诊断情况如下：</span>
									<span class="green weight">
										<#list itemPage.elements as basicMap><span>${basicMap.elementName},</span></#list> 
						</span><br/>
								<span>&nbsp;&nbsp;诊断结论为：</span>
								<span class="green weight">
									${itemPage.diagnosisConclusion}
								</span>
						</p>
					
						<!---->
						
						<span>
							该项目存在的问题描述及改进意见：
						</span>
			
						
									<ul class="list">
											<#if itemPageResult??>
												<#if itemPageResult.elements?exists>
													<#list itemPage.elements as questionMap>
										<li class="item">
											<div class="item-q">
												<span class="padding: 16px 0;">${(questionMap.elementName)!}有待提升</span><br/>
												<span class="red">问题描述：</span><br/>
												<span class="item-msg">
													&nbsp;&nbsp;${(questionMap.problemDescription)!}
												</span>
											</div>
											<div class="item-s">
												<span class="green">改进建议：</span><br/>
												<span class="item-msg">
													&nbsp;&nbsp;${(questionMap.suggestionImprovement)!}
												</span>
											</div>
										</li>
										</#list>
									</#if>
								</#if>	
						</ul>
								
					
						<#list itemPage.elements as basicMap>
						<span>
							<#list basicMap.indicators as indi>
								
								<h4 class="title-third">2.${itemPage_index+1}.${indi_index+1} ${(indi.indicatorName)!}</h4>
								<span>
									&nbsp;&nbsp;本专业${time}${(indi.indicatorName)!}为24，较本专业${time1}基本持平,合格值:${(indi.qualifiedValue)!} ,
									在全校专业中处于较好水平，诊断结论为:${(indi.resultState)!}
								</span>
								
									<div class="img-box">
										<img src="${indi.imgUrl}" />
											<p class="img-msg">图${indi_index+1}${(indi.indicatorName)!} </p>
									</div>
								
							</#list>		
						</span>
					</#list>
				</#list>						
			
			</div>	
			
			<div class="paragraph">
				<h1 class="title-one">3.	内部质量自我诊改报告</h1>
				<p class="content">
					注：该报告根据对学校的指标诊断结果动态生成，仅供学校进行参考
				</p>
				<div class="table-box">
					<table class="table">
						<thead>
							<tr>
								<th width="15%">诊断项目</th>
								<th width="15%">诊断要素</th>
								<th width="35%">自我诊断意见</th>
								<th width="35%">改进措施</th>
							</tr>
						</thead>
						<tbody>
							<!-- rowspan：合并行  colspan：合并列-->
							<tr>
								<td rowspan="2">教师情况诊断</td>
								<td>企业、行业经验</td>
								<td>
									教师企业实践经验不足。从一定程度上反映出本专业专任教师中具有企业、行业经验的教
									师数量偏低。教师企业经验不足，不愿进入企业实践，在教学工作中，容易与企业需求脱节。
									导致学生掌握的各项技能与用人单位需求产生偏差，不利于学生的就业。
								</td>
								<td>
									加强和企业的沟通联系，强化教师企业实践。从专业层面，加强与企业之间的互动，组织教师到与
									专业相融合的行业、企业顶岗实践。实行专业教师挂职锻炼制度，并监控教师下企业情况，将理论
									与实践紧密的结合起来。充分发挥校企双方的资源特色，共促人才培养提高。
								</td>
							</tr>
							<tr>
								<td>教师教学</td>
								<td>
									教学工作任务较重，教学质量不高。专任教师平均周学时较高，教学任务较重。同时教学前期准备
									工作不足，教学质量不高，督导反馈评分偏低
								</td>
								<td>
									合理安排教学任务，加强教学质量监控。加强优质教师引进，减轻教师教学工作量。加强教师课前备
									课准备工作监督，提
								</td>
							</tr>
							<tr>
								<td>
									学生情况诊断
								</td>
								<td>
									毕业就业
								</td>
								<td>
									毕业生就业情况有待提高。反映出该校学生在就业市场上的竞争力较低，学生的综合能力不强，
									学生掌握的知识与能力不能与社会需求同步。专业在人才培养方面，未能真正实现以市场需求为导向，
									人才培养模式与用人单位实际需求之前存在偏差；在就业指导服务方面，就业服务平台未能给予该专业
									充分支持，专业的职业发展与指导工作未落实到位。
								</td>
								<td>
									强化学生能力要求，提高专业实践能力。可根据实际产业的发展要求，在日常教学中进一步加强实习
									实践环节的培养，不断强化学生的实践操作能力，更好地指导学生将所学知识运用于实际领域，从而
									促进专业技能的提升，增加专业工作岗位的竞争力，提升专业整体的就业质量。同时有针对性的开展
									学生就业规划指导工作，为学
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
