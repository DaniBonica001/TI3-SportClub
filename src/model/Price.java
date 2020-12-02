/**
* <b>Name: Price</b><br>
* This is a interface with two methods to calculate the market price and the stars level of an employee.<br>
*/
package model;
public interface Price{
	/**
	*<b>Name: calculateMarketPrice</b><br>
	* This method is to calculate the market price of an employee.
	*/
	public double calculateMarketPrice();
	/**
	* <b>Name: calculateStarsLevel</b><br>
	* This method is to calculate the stars level of an employee.
	*/
	public double calculateStarsLevel();
}