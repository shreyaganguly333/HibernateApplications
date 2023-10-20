package org.anudip.hibernateXmlApplication.bean;


public class Country {
	private Integer countryCode;
	private String countryName;
	private String capital;
	private Double gdp;
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(Integer countryCode, String countryName, String capital, Double gdp) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.capital = capital;
		this.gdp = gdp;
	}
	public Integer getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Double getGdp() {
		return gdp;
	}
	public void setGdp(Double gdp) {
		this.gdp = gdp;
	}
	@Override
	public String toString() {
		String output=String.format("%-5s %-15s %-10s %-10s",countryCode,countryName,capital,gdp);
		return output;
	}

}