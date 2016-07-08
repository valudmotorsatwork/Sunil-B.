<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Browser</title>
<link rel="stylesheet" href="styles/kendo.common.min.css"/>
<link rel="stylesheet" href="styles/kendo.default.min.css"/>
<link rel="stylesheet" href="styles/bootstrap.min.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h3>City Browser</h3>
				<kendo:grid name="CreateRequest" pageable="true" resizable="true" sortable="true">
					<kendo:grid-filterable mode="row"/>
					<kendo:grid-editable mode="popup"/>
					<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
					<kendo:grid-toolbar>
						<kendo:grid-toolbarItem name="create" text="Add"/>
					</kendo:grid-toolbar>
					<kendo:dataSource pageSize="5">
						<kendo:dataSource-transport>
							<kendo:dataSource-transport-read url="CityController" />
							<kendo:dataSource-transport-create
								url="CityController?action=Create" type="post" />
							<kendo:dataSource-transport-update
								url="CityController?action=Update" type="post" />
							<kendo:dataSource-transport-destroy
								url="CityController?action=Delete" type="post" />
						</kendo:dataSource-transport>
						<kendo:dataSource-schema>
							<kendo:dataSource-schema-model id="cityId">
								<kendo:dataSource-schema-model-fields>
									<kendo:dataSource-schema-model-field name="cityName" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="cityCountryCode" type="" >
										<kendo:dataSource-schema-model-field-validation required="true"/>
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="cityDistrict" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="cityPopulation" type="number">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
								</kendo:dataSource-schema-model-fields>
							</kendo:dataSource-schema-model>
						</kendo:dataSource-schema>
					</kendo:dataSource>
					<kendo:grid-columns>
						<kendo:grid-column title="City Name" field="cityName"></kendo:grid-column>
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
<!-- 			<kendo:dropDownList name="countries" dataTextField="countryCode" dataValueField="countryName">
				<kendo:dataSource>
				<kendo:dataSource-transport read="CountryController">
				</kendo:dataSource-transport>
				</kendo:dataSource>
				</kendo:dropDownList>
-->	
			</div>
		</div>
	</div>
</body>
</html>

