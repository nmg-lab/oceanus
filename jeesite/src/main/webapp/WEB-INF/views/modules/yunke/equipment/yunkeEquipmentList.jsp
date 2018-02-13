<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基础信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/yunke/equipment/yunkeEquipment/">基础信息列表</a></li>
		<shiro:hasPermission name="yunke:equipment:yunkeEquipment:edit"><li><a href="${ctx}/yunke/equipment/yunkeEquipment/form">基础信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="yunkeEquipment" action="${ctx}/yunke/equipment/yunkeEquipment/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备型号：</label>
				<form:input path="model" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>维保厂商</th>
				<th>物理位置</th>
				<th>设备类型</th>
				<th>设备型号</th>
				<th>出场日期</th>
				<th>序列号</th>
				<th>存储总容量</th>
				<th>插槽数量</th>
				<th>权属</th>
				<th>负责人</th>
				<th>监控</th>
				<th>运行</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yunke:equipment:yunkeEquipment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="yunkeEquipment">
			<tr>
				<td><a href="${ctx}/yunke/equipment/yunkeEquipment/form?id=${yunkeEquipment.id}">
					${yunkeEquipment.factory}
				</a></td>
				<td>
					${yunkeEquipment.position}
				</td>
				<td>
					${fns:getDictLabel(yunkeEquipment.type, 'device_type', '')}
				</td>
				<td>
					${yunkeEquipment.model}
				</td>
				<td>
					<fmt:formatDate value="${yunkeEquipment.outtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${yunkeEquipment.sequencenumber}
				</td>
				<td>
					${yunkeEquipment.sum}
				</td>
				<td>
					${yunkeEquipment.cardnumber}
				</td>
				<td>
					${yunkeEquipment.power}
				</td>
				<td>
					${yunkeEquipment.people}
				</td>
				<td>
					${fns:getDictLabel(yunkeEquipment.monitor, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(yunkeEquipment.run, 'yes_no', '')}
				</td>
				<td>
					<fmt:formatDate value="${yunkeEquipment.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${yunkeEquipment.remarks}
				</td>
				<shiro:hasPermission name="yunke:equipment:yunkeEquipment:edit"><td>
    				<a href="${ctx}/yunke/equipment/yunkeEquipment/form?id=${yunkeEquipment.id}">修改</a>
					<a href="${ctx}/yunke/equipment/yunkeEquipment/delete?id=${yunkeEquipment.id}" onclick="return confirmx('确认要删除该基础信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>