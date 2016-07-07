<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Pagination Browser</title>
<link href="css/kendo.common.min.css" rel="stylesheet">
<link href="css/kendo.default.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h3>City Pagination Browser</h3>
				<kendo:grid name="CreateRequest" pageable="true" resizable="true">
					<kendo:grid-editable mode="popup"/>
					<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
					<kendo:grid-toolbar>
						<kendo:grid-toolbarItem name="create" text="Add"/>
					</kendo:grid-toolbar>
					<kendo:dataSource pageSize="5" serverPaging="true">
						<kendo:dataSource-transport>
							<kendo:dataSource-transport-read url="CityPaginateController"/>
							<kendo:dataSource-transport-create url="CityPaginateController?action=Create" type="post"/>
							<kendo:dataSource-transport-update url="CityPaginateController?action=Update" type="post"/>
							<kendo:dataSource-transport-destroy url="CityPaginateController?action=Delete" type="post"/>                	
						</kendo:dataSource-transport>
						<kendo:dataSource-schema total="total" data="data">
							<kendo:dataSource-schema-model id="cityId"/>
						</kendo:dataSource-schema>
					</kendo:dataSource>
					<kendo:grid-columns>
						<kendo:grid-column title="Name" field="cityName"></kendo:grid-column>
						<kendo:grid-column title="Country Code" field="cityCountryCode"></kendo:grid-column>
						<kendo:grid-column title="District" field="cityDistrict"></kendo:grid-column>
						<kendo:grid-column title="Population" field="cityPopulation"></kendo:grid-column>
						<kendo:grid-column title="&nbsp;" width="250px">
							<kendo:grid-column-command>
								<kendo:grid-column-commandItem name="edit" />
								<kendo:grid-column-commandItem name="destroy" />
							</kendo:grid-column-command>
						</kendo:grid-column>
					</kendo:grid-columns>
				</kendo:grid>
			</div>
		</div>
	</div>
</body>
</html>

