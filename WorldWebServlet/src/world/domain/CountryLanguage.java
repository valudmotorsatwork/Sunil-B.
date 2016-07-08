package world.domain;

public class CountryLanguage 
{
	private String countryCode;
	private String countryLanguage;
	private String isOfficial;
	private String percentage;
	public CountryLanguage(){}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryLanguage() {
		return countryLanguage;
	}
	public void setCountryLanguage(String countryLanguage) {
		this.countryLanguage = countryLanguage;
	}
	public String getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public CountryLanguage(String countryCode, String countryLanguage) {
		super();
		this.countryCode = countryCode;
		this.countryLanguage = countryLanguage;
	}	
	
}
