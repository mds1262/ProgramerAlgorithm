package algorithmsort1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 extends Thread {

	public static void main(String[] args) {
//        Thread t = new Test2();
//        t.start();
		int[] arr = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] com = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		solution(arr, com);

		int[] c = { 3, 0, 6, 1, 5 };
		solution(c);

		int[] d = { 3, 30, 34, 5, 9 };
		solution1(d);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};

		List<Integer> l = Arrays.stream(array).boxed().collect(Collectors.toList());

		int[] a = Arrays.stream(commands).map(x -> {
			int str = x[0] - 1;
			int end = x[1];
			int idx = x[2] - 1;
			List<Integer> n = l.subList(str, end);
			n = n.stream().sorted().collect(Collectors.toList());
			return n.get(idx);
		}).mapToInt(x -> x).toArray();
		return answer;
	}

	public static int solution(int[] citations) {
		int answer = 0;
		double d = Arrays.stream(citations).sorted().average().getAsDouble();
		return answer;
	}

	public static String solution1(int[] numbers) {

		Comparator<String> c = (a, b) -> (b + a).compareTo(a + b);

		List<String> strNums = Arrays.stream(numbers).boxed().map(x -> x + "").sorted(c).collect(Collectors.toList());

		if (strNums.get(0).startsWith("0")) {
			return "0";
		}
		return strNums.stream().reduce("", (a, b) -> a + b).toString();

//        return "";
	}

}
