public class Solution {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int cases = reader.nextInt();
		HashMap<Integer, BigInteger> results = new HashMap<Integer, BigInteger>();
		int counter = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (counter < cases) {
			int input = reader.nextInt();
			if (input >= 1 && input <= 500) {
				list.add(input);
				counter++;
			}
		}

		for (Integer i : list) {
			if (results.containsKey(i)) {
				System.out.println(results.get(i));

			} else {
				results.put(i, getMultiple(i));
				System.out.println(getMultiple(i));
			}
		}
	}

	public static BigInteger getMultiple(int input) {

		String inputAsString = "" + input;
		BigInteger inputAsBifInteger = new BigInteger(inputAsString);
		BigInteger first = new BigInteger("9");
		if (first.mod(inputAsBifInteger).equals(BigInteger.ZERO)) {
			return first;
		}

		LinkedList<BigInteger> list = new LinkedList<BigInteger>();
		list.add(first);

		int counter = 1;
		BigInteger number = BigInteger.ONE;
		while (true) {
			number = BigInteger.ONE;
			for (int i = 0; i < counter; i++) {
				number = number.multiply(BigInteger.TEN);
			}
			number = number.multiply(list.get(0));
			if (number.mod(inputAsBifInteger).equals(BigInteger.ZERO)) {
				break;
			}
			counter++;
			list.add(number);
			int index = list.indexOf(number);

			for (int i = 0; i < index; i++) {
				BigInteger n = list.get(index).add(list.get(i));

				if (n.mod(inputAsBifInteger).equals(BigInteger.ZERO)) {
					return n;
				}
				list.add(n);
			}
		}
		return number;
	}
}
