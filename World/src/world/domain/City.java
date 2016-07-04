package world.domain;

public class City 
{
	private int cityId;
	private String cityName;
	private String cityDistrict;
	private int cityPopulation;
	private String cityCountryCode;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityDistrict() {
		return cityDistrict;
	}
	public void setCityDistrict(String cityDistrict) {
		this.cityDistrict = cityDistrict;
	}
	public int getCityPopulation() {
		return cityPopulation;
	}
	public void setCityPopulation(int cityPopulation) {
		this.cityPopulation = cityPopulation;
	}
	public String getCityCountryCode() {
		return cityCountryCode;
	}
	public void setCityCountryCode(String cityCountryCode) {
		this.cityCountryCode = cityCountryCode;
	}	
}
