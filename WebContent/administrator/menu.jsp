<%@ page pageEncoding="UTF-8"%>
<nav class="menu" id="mymenu">
	<ul class="nav nav-primary">
		<li class="nav-parent show"><a href="javascript:;"> 商品管理</a>
			<ul class="nav">
				<li ${param.tag == 'ad_index' ? "class='active'" : ""}><a
					href="${ctx}/administrator/products"><i class="icon-shopping-cart"></i>
						商品列表<i class="icon-chevron-right"></i></a></li>
				<li ${param.tag == 'add' ? "class='active'" : ""}><a
					href="${ctx}/administrator/product/add.jsp"><i class="icon-map-marker"></i>
						增加商品<i class="icon-chevron-right"></i></a></li>
				<li ${param.tag == 'delete' ? "class='active'" : ""}><a
					href="${ctx}/administrator/product/delete.jsp"><i class="icon-map-marker"></i>
						删除商品<i class="icon-chevron-right"></i></a></li>
				<li ${param.tag == 'alter' ? "class='active'" : ""}><a
					href="${ctx}/administrator/product/alter.jsp"><i class="icon-map-marker"></i>
						修改商品<i class="icon-chevron-right"></i></a></li>
			</ul></li>
		<li class="nav-parent show"><a href="javascript:;"> 销售管理</a>
			<ul class="nav">
				<li ${param.tag == 'profile' ? "class='active' " : ""}><a
					href="${ctx}/administrator/sale/report.jsp"><i class="icon-user"></i> 统计报表<i
						class="icon-chevron-right"></i></a></li>
				<li ${param.tag == 'order' ? "class='active' " : ""}><a
					href="${ctx}/administrator/sale/order"><i class="icon-eye-open"></i>
						订单管理<i class="icon-chevron-right"></i></a></li>
			</ul></li>
	</ul>
</nav>