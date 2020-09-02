public class TaxCalculator {

	public static int calculateTax(int income) {
		
		int[] incomeRanges = {0, 100, 150, 200, 300, 400}; // given income ranges
		int[] taxRates = {0, 5, 10, 15, 20, 150}; // tax rates by income in percentages 
		double taxPayable = 0;
		
		for (int i = incomeRanges.length-1; i >= 0; i--) {
			double difference = 0;
			if (income > incomeRanges[i]) {
				difference = income - incomeRanges[i];  // calculates the difference between the income and the highest value of the range that the income is in
				taxPayable += taxRates[i] * 0.01 * difference; // calculates the tax payable
				income -= difference; // gives income a new value by subtracting difference from the income
			}
		}
		
		return ((int) (0.5 + taxPayable)); // returns the tax payable rounded to the nearest whole number
	}

}
	