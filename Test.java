public class Test {
	
	public void taxTables(){
		// initialises an array of incomes in increasing order
		int[] incIncomes = {25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 500, 550};
		// initialises an array of taxes for each of the income value
		int[] tax = new int[incIncomes.length]; 
		// creates TaxChart object
		TaxChart chart = new TaxChart(incIncomes);
		// calculates tax payable for each income
		chart.taxCalculation(incIncomes, tax);
		// draws the bar chart based on the incomes and tax payable
		chart.draw(incIncomes, tax);
		// prints the table of net incomes and tax payable
		chart.printTable(incIncomes, tax);
		}
	
	public static int smallestSalary() {
		// giving the starting value of 1 for the income
		int income = 1; 
		while (income != TaxCalculator.calculateTax(income)) {  // when the income becomes the same as the tax payable it means that the net income is 0
			// increasing the value of income every time
			income++;
		}
		// returns the value of the income when the calculated net income is 0
		return income;
	}
	


	public static void main(String[] args) {
		// creates object of Test class
		Test testing = new Test();
		// calls the taxTables method
		testing.taxTables();
		// prints the value of the smallest salary where the calculated net income is 0
		System.out.println("Smallest salary where the net income is 0: \n" + smallestSalary());
	}

}