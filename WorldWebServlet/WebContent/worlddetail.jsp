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
				<h2>City Browser</h2>
				<kendo:grid name="CreateRequest" pageable="true" resizable="true" sortable="true">
					<kendo:grid-filterable mode="row"/>
					<kendo:grid-editable mode="popup"/>
					<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
				
					<kendo:dataSource pageSize="5">
						<kendo:dataSource-transport>
							<kendo:dataSource-transport-read url="CountryController" />
							<kendo:dataSource-transport-create url="CountryController?action=Create" type="post" />
						</kendo:dataSource-transport>
						<kendo:dataSource-schema>
							<kendo:dataSource-schema-model id="countryCode">
							<kendo:dataSource-schema-model-fields>
									<kendo:dataSource-schema-model-field name="countryName" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="countryContinent" type="string" >
										<kendo:dataSource-schema-model-field-validation required="true"/>
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="countryRegion" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="countryPopulation" type="number">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="countryCapital" type="number">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="city.cityName" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
									<kendo:dataSource-schema-model-field name="language.countryLanguage" type="string">
										<kendo:dataSource-schema-model-field-validation required="true" />
									</kendo:dataSource-schema-model-field>
								</kendo:dataSource-schema-model-fields>
							
							</kendo:dataSource-schema-model>
						</kendo:dataSource-schema>
					</kendo:dataSource>
					<kendo:grid-columns>
						<kendo:grid-column title="Country Name" field="countryName"></kendo:grid-column>
						<kendo:grid-column title="Continent" field="countryContinent"></kendo:grid-column>
						<kendo:grid-column title="Region" field="countryRegion"></kendo:grid-column>
						<kendo:grid-column title="Population" field="countryPopulation" ></kendo:grid-column>
						<kendo:grid-column title="HeadOfState" field="countryHeadOfState" ></kendo:grid-column>
						<kendo:grid-column title="Capital" field="countryCapital" ></kendo:grid-column>
						<kendo:grid-column title="City" field="city.cityName" template="#: city.cityName#"  editor="countryEditor"></kendo:grid-column>
						<kendo:grid-column title="Languages" field="language.countryLanguage" editor="languageEditor"></kendo:grid-column>
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
	<script type="text/javascript">
	function countryEditor(container,options)
	{
		$("<input data-text-field='city.cityName' data-value-field='city.cityName' data-bind='value: "+options.field+"' />")
		.appendTo(container)
		.kendoDropDownList({dataSource:{ transport:{read: "CountryController"} } });
	}
	function languageEditor(container,options)
	{
		$("<input data-text-field='language.countryLanguage' data-value-field='language.countryLanguage' data-bind='value: "+options.field+"' />")
		.appendTo(container)
		.kendoDropDownList({dataSource:{ transport:{read: "CountryController"} } });
	}
	</script>
</body>
</html>

