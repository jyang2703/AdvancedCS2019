import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Conversion2 {
	/*
	 * Make sure you check -128 which should give you - 10000000 (positive/neg) 127
	 * which should give you - 01111111 -32768 which should give you -
	 * 1000000000000000 (positive/neg) 32767 which should give you -
	 * 0111111111111111 -2^31 (-2147483648) which is -
	 * 10000000000000000000000000000000 (positive/neg) 2^31-1 (2147483647) which is
	 * - 01111111111111111111111111111111 2^63 (-9223372036854775808) -
	 * 1000000000000000000000000000000000000000000000000000000000000000
	 * 2^63-1(9223372036854775807) -
	 * 0111111111111111111111111111111111111111111111111111111111111111
	 */
	public static final int MAX_BITS = 64;
	public static final int LONG = 64; // -9223372036854775808 9223372036854775807
	public static final int INT = 32;
	public static final int SHORT = 16;
	public static final int BYTE = 8;
	// Data Type Codes...
	public static final int STRING_TYPE = 0;
	public static final int INT_TYPE = 1;
	public static final int FLOAT_TYPE = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dataType = -1;
		Scanner s = null;
		boolean allGood = false;
		try {
			s = new Scanner(new File("testClass.txt"));
			// System.out.println("It's open");
			allGood = true;
		} catch (Exception e) {
			System.out.println("It's not open.  There is an issue opening your file.");
		}

		if (allGood) {
			while (s != null && s.hasNextLine()) {
				String nextNumIn = s.nextLine();

				if (itsNotANumber(nextNumIn)) {
					// check for bad input
					System.out.println(nextNumIn + " is bad input");
					dataType = STRING_TYPE;
				} else if (isADecimal(nextNumIn)) {
					// check for a decimal
					System.out.println(nextNumIn + " is a decimal");
					dataType = FLOAT_TYPE;
				} else {
					// its an integer
					System.out.println(nextNumIn + " is an integer");
					dataType = INT_TYPE;
				}

				// now process the numbers....
				if (dataType == INT_TYPE) {
					String binInt = "";
					try {
						long x = Long.parseLong(nextNumIn);
						// This is my conversion method...
						binInt = binConvertInt(x);
						System.out.println(binInt);

					} catch (Exception e) {
						System.out.println(nextNumIn + " -- Number is too Large...");
						binInt = "" + nextNumIn + " is too big for Long";
					}

				} else if (dataType == FLOAT_TYPE) {
					// ORIGINAL FLOATING POINT METHOD
					String binFloat = "";
					try {
						float x = Float.parseFloat(nextNumIn);
						// This is my conversion method...
						binFloat = binConvertFloat(x);
						System.out.println(binFloat);

					} catch (Exception e) {
						System.out.println(nextNumIn + " -- Number is too Large...");
						binFloat = "" + nextNumIn + " is too big for Long";
					}

				} else {
					// Strings??
				}
			}
			s.close();
		}
	}

	private static String binConvertFloat(float x) {
		String temp = decimalBinaryConversion(x);
		String ieeeString = convertToIEEE(temp, x);
		return ieeeString;

	}

	private static String convertToIEEE(String binNum, float num) {
		String binString = "";
		int binary = 0, count = 0;

		String[] parts = binNum.split("\\.");

		// parts[0] = left side of the "."
		// parts[1] = right side of the "."

		int power = parts[0].length() - 1 + 127;
		int exponent = 127 + power;
		String exponentBits = binConvertInt(power);

		char[] mantissa = new char[23]; // excluding the first term, goes to the end
		Arrays.fill(mantissa, '0'); // all elements are now filled with 0

		int j = 0; // example: 111000.001001, solves for the left side of the ".", excluding the
					// first term
		for (int i = 1; i < parts[0].length(); i++) {
			mantissa[j] = parts[0].charAt(i);
			j++;
		}
		for (int i = 0; i < parts[1].length() && j < 23; i++) { // solves for the right side of the ".", including all
																// terms
			mantissa[j] = parts[1].charAt(i);
			j++;
		}

		String mantissaString = new String(mantissa);

		String sign = "0"; // checks for negative numbers
		if (num < 0)
			sign = "1";

		String result = sign + exponentBits + mantissaString;
		System.out.println("your result is " + result);

		return binString;
	}

	private static String decimalBinaryConversion(float input) {
		String binString = "";
		int binary = 0;
		int count = 0;
		if (input < 0) {
			input *= -1;
		}
		int intPart = (int) input;
		// BigDecimal dfloatPart =
		// BigDecimal.valueOf(input).subtract(BigDecimal.valueOf((int) input));
		// double decimalPart = Double.valueOf(dfloatPart);
		double decimalPart = Double.valueOf("0." + String.valueOf(input).split("\\.")[1]);

		while (intPart > 0) {
			binary = intPart % 2;
			if (binary == 1) {
				count++;
			}

			binString = binary + "" + binString;
			intPart = intPart / 2;
		}

		binString = binString + ('.');
		int j = 0;

		while (decimalPart > 0 && j < 23) {
			j++;
			decimalPart = decimalPart * 2;
			int decimalBit = (int) decimalPart;
			if (j == 22 && decimalPart >= 0.5) {
				decimalBit = 1;
			}
			if (decimalBit == 1) {
				decimalPart -= (int) decimalPart;
				binString += (char) (1 + '0');
			} else {
				binString += (char) (0 + '0');
			}

		}
		return binString;

	}

	public static boolean itsNotANumber(String nextNumIn) {
		boolean itsNotANumber = false;
		String nonNums = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+= {[}]|\\:;\"'<,>?/";

		for (int l = 0; l < nonNums.length(); l++) {
			if (nextNumIn.contains("" + nonNums.charAt(l))) {
				itsNotANumber = true;
			}
		}
		return itsNotANumber;
	}

	public static boolean isADecimal(String nextNumIn) {
		boolean itsADecimal = false;
		if (nextNumIn.contains(".")) {
			itsADecimal = true;
		}
		return itsADecimal;
	}

	public static String binConvertInt(long num) {
		// This is your code for binary byte, short, int and long conversion
		String binString = "";

		// ORIGINAL CODE FOR INT BINCONVERT

		long binary = 0;
		int count = 0;
		if (num >= 0) {
			while (num > 0) {
				binary = num % 2;
				if (binary == 1) {
					count++;
				}
				binString = binary + "" + binString;
				num = num / 2;
			}

		}

		else {

			num = -1 * num;

			while (num > 0) {
				binary = num % 2;
				if (binary == 1) {
					count++;
				}

				binString = binary + "" + binString;
				num = num / 2;
			}

			// flip the binary to negative conversion

			char ch[] = binString.toCharArray();
			boolean addedOne = false;

			for (int i = binString.length() - 1; i >= 0; i--) {
				if (addedOne == false && ch[i] == '1') { // if everything before is 0, this is the first "one" that the
															// code reads (right to left)
					addedOne = true;

				} else if (addedOne && ch[i] == 0) {
					ch[i] = 1;
				} else if (addedOne && ch[i] == 1) {
					ch[i] = 0;
				}

			}
		}
		return binString;
	}

}
