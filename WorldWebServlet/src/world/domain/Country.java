package world.domain;

public class Country
{
	private String countryCode;
	private String countryName;
	private String countryContinent;
	private String countryRegion;
	private String countryPopulation;
	private String countryHeadOfState;
	private String countryCapital;
	private CountryLanguage language;
	private City city;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryContinent() {
		return countryContinent;
	}
	public void setCountryContinent(String countryContinent) {
		this.countryContinent = countryContinent;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(String countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	public String getCountryHeadOfState() {
		return countryHeadOfState;
	}
	public void setCountryHeadOfState(String countryHeadOfState) {
		this.countryHeadOfState = countryHeadOfState;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public CountryLanguage getLanguage() {
		return language;
	}
	public void setLanguage(CountryLanguage language) {
		this.language = language;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}
