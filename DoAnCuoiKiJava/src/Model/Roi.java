package Model;

import java.io.Serializable;

public class Roi implements Serializable{
	private static final long serialVersionUID = 1L;
	private double times;
	private String currency;
	private double percentage;
	
	
	
	
	public Roi(double times, String currency, double percentage) {
		super();
		this.times = times;
		this.currency = currency;
		this.percentage = percentage;
	}
	
	
	
	public Roi() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getTimes() {
		return times;
	}
	public void setTimes(double times) {
		this.times = times;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}



	@Override
	public String toString() {
		return "Roi:\ntimes=" + times + "\ncurrency=" + currency + "\npercentage=" + percentage;
	}
	
	
}
