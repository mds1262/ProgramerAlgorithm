package algorithmLevel2;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String[] c = { "classic", "pop", "classic", "classic", "pop" };
		int[] d = { 500, 600, 150, 800, 2500 };
		System.out.println(solution(c, d));
		super.run();
	}
	public static void main(String[] args) {
//		String[] a = { "4789", "1567", "3882", "231123", "47889", "478922" };
//		System.out.println(solution(a));
//
//		String[][] b = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" }, { "green_turban", "headgear" } };
//		System.out.println(solution(b));
//
//		String[] c = { "classic", "pop", "classic", "classic", "pop" };
//		int[] d = { 500, 600, 150, 800, 2500 };
//		System.out.println(solution(c, d));
        Thread t = new Test2();
        t.start();
	}
//	문제 설명
//	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
//
//	구조대 : 119
//	박준영 : 97 674 223
//	지영석 : 11 9552 4421
//	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
//
//	제한 사항
//	phone_book의 길이는 1 이상 1,000,000 이하입니다.
//	각 전화번호의 길이는 1 이상 20 이하입니다.
//	같은 전화번호가 중복해서 들어있지 않습니다.
//	입출력 예제
//	phone_book	return
//	["119", "97674223", "1195524421"]	false
//	["123","456","789"]	true
//	["12","123","1235","567","88"]	false
//	입출력 예 설명
//	입출력 예 #1
//	앞에서 설명한 예와 같습니다.
//
//	입출력 예 #2
//	한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
//
//	입출력 예 #3
//	첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.	

	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		List<String> l = new ArrayList<String>(Arrays.asList(phone_book));
		String result = l.stream().reduce((a, b) -> {
			if (b.startsWith(a)) {
				return "";
			}
			return b;
		}).get().strip();

		return true;

//		for (int i = 0; i < phone_book.length - 1; i++) {
//			System.out.println(phone_book[i] + " : " +phone_book[i + 1]);
//			if (phone_book[i + 1].startsWith(phone_book[i])) {
//				return false;
//			}
//		}
//		return true;
	}

	public static int solution(String[][] clothes) {
		System.out.println(Arrays.stream(clothes).collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
				.values().stream().collect(reducing(1L, (x, y) -> {
					System.out.println(x);
					System.out.println(y);
					System.out.println("합 : " + (x * (y + 1)));
					return x * (y + 1);
				})));
		return Arrays.stream(clothes).collect(groupingBy(p -> p[1], mapping(p -> p[0], counting()))).values().stream()
				.collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}

	public int[] solution(String[] genres, int[] plays) {
		int[] a = IntStream.range(0, genres.length)
				.mapToObj(i -> new Songs(i, genres[i], plays[i]))
				.collect(Collectors.groupingBy(Songs::getGen))
				.entrySet().stream()
				.sorted((p, n) -> {
					int s1 = p.getValue().stream().mapToInt(s -> s.play).reduce(0, (y,z) -> y + z);
					int s2 = n.getValue().stream().mapToInt(s -> s.play).reduce(0, (y,z) -> y + z);
					return s2 - s1;
				}).flatMap(x -> x.getValue().stream().sorted().limit(2))
				.mapToInt(x -> x.id).toArray();
		
		return a;
	}

	class Songs implements Comparable<Songs> {
		private int id;
		private String gen;
		private int play;

		public Songs(int i, String g, int p) {
			// TODO Auto-generated constructor stub
			this.id = i;
			this.gen = g;
			this.play = p;
		}

		public String getGen() {
			return this.gen;
		}

		@Override
		public int compareTo(Songs o) {
			if (this.play == o.play)
				return this.id - o.id;
			return o.play - this.play;
		}
	}

}
