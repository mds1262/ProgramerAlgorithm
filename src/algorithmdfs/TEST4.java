package algorithmdfs;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Supplier;

public class TEST4 {
	
	public static void main(String[] args) {
		double a = computePi(5.0, 5.0, 5.0, 80.0);
		System.out.println(a);
	}
	
	public static Double computePi(double x, double y, double r, double v) {
		DoubleBinaryOperator getArea = (a, b) -> Math.pow(a, 2) + Math.pow(b, 2);
		Supplier<Boolean> isInCircleArea = () -> getArea.applyAsDouble(r, v) < 1d;
		DoubleUnaryOperator assumePi = (input) -> {
			double validCnt = 0;
			for (double i = 0; i < input; i++)
				if (isInCircleArea.get()) {
					validCnt++;
				}
			return r * validCnt / input;
		};
		return assumePi.applyAsDouble(v);
	}
}
