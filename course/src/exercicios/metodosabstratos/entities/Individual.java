package exercicios.metodosabstratos.entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double percentage = this.getAnualIncome() < 20000.00 ? 0.15 : 0.25;		
		return (this.getAnualIncome() * percentage) - (this.healthExpenditures * 0.5);
	}

}
