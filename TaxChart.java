public class TaxChart {
	
	// width of the bar
	private static int BAR_WIDTH = 5;

	private int[] incomes;
	
	// Constructor 
	public TaxChart(int[] incomes){
		for(int i = 0; i < incomes.length - 1; i++){
			if(incomes[i+1] > incomes[i]){  // checks if the values are in an ascending order
				this.incomes = incomes;  // stores the integer in the array
			}
			else {
				throw new IllegalArgumentException();  // stops the program 
			}
		}
	}
	
	public void taxCalculation (int[] incomes, int[] tax){
		// tax calculation for each income using the calculateTax method from the TaxCalculator class
		for (int i = 0; i <= incomes.length-1; i++){
			tax[i] = TaxCalculator.calculateTax(incomes[i]);
		}
	}
	

	
	public void makeAxis() {
		
		// creates x and y axis
		Bar xAxis = new Bar();
		Bar yAxis = new Bar();
		// makes x and y axis visible
		xAxis.makeVisible();
	    yAxis.makeVisible();
	    // changes the size of x and y axis (1 pixel = £3 on the y axis)
	    xAxis.changeSize(1, 210);  
	    yAxis.changeSize(210, 1);
	    // makes the x and y axis overlap
	    xAxis.moveVertical(10);
	    // moves y axis
	    yAxis.moveVertical(210);
	    // makes the x and y axis overlap
	    yAxis.moveHorizontal(-10); 
	    // changes the colour of x and y axis to blue
        xAxis.changeColour(Colour.BLUE);
        yAxis.changeColour(Colour.BLUE);
		
	} 
	
	public void draw(int [] incomes, int [] tax){
		makeAxis(); // calls a method to create axis
		int space  = 5; // space between the bars
		for (int i = 0; i <= incomes.length-1; i++){
			// creates a new net income bar
			Bar netIncomeBar = new Bar();
			// changes the size and colour of the net income bar and moves it
			netIncomeBar.changeSize(BAR_WIDTH, (incomes[i]) / 3); // division by 3, because 1 pixel = £3 on the y axis
			netIncomeBar.changeColour(Colour.YELLOW);
			netIncomeBar.moveVertical(210 - incomes[i] / 3);
			// makes space between bars
			netIncomeBar.moveHorizontal(space);
			// makes the bar visible
			netIncomeBar.makeVisible();
			
			//creates a new tax bar
			Bar taxBar = new Bar();
			// changes the size of the tax bar and moves it
			taxBar.changeSize(BAR_WIDTH, tax[i] / 3);
			taxBar.moveVertical(210 - incomes[i] / 3);
			// creates space between bars
			taxBar.moveHorizontal(space);
			// makes the bars visible
	        taxBar.makeVisible();
	        // increases the space between the bars
	        space += 10;
	        // if the space exceeds the length of the x axis, stops drawing
	        if (space > 200) {
	        	throw new IllegalArgumentException();
	        }
		}
		
	}
	
	public void printTable(int [] incomes, int [] tax){
		// writes and formats the words Net Income and Tax Payable
		System.out.format("| %-10s | %-11s | %n", "Net Income", "Tax Payable");
		// for loop that prints and formats all the values of net incomes and tax payable
		for (int i = 0; i <= incomes.length-1; i++) {
			System.out.format("| %6d%6s%7d%7s %n", incomes[i], "|", tax[i], "|");
		}
	}

}

