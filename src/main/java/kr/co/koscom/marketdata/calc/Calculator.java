package kr.co.koscom.marketdata.calc;

public class Calculator {
	public double sigmoid(double x) {
		return (1 / (1 + Math.pow(Math.E, (-1 * x))));
	}

}
