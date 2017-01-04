<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<div class="row-header">
	<div class="col-lg-12">
		<h1>
			<tiles:insertAttribute name="headerTitle"/>
			<small>
				<tiles:insertAttribute name="headerDescription"/>
			</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/jpaproject"><i class="icon-dashboard"></i> Home</a></li>
			<li class="active"><i class="icon-file-alt"></i> <tiles:insertAttribute name="breadcrumbs"/></li>
		</ol>
	</div>
</div>
<hr>
<!-- /.row -->