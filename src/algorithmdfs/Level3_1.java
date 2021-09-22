package algorithmdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level3_1 {

	public static void main(String[] args) {
		String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
//		String[] a = { "cog", "log", "lot", "dog", "dot", "hot" };
		String b = "hit";
		String t = "cog";

//		b = "hit";
//		t = "hhh";
//		String[] wodrs = { "hhh", "hht" };

//		String [] a = {"1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"};
//		String [] a = {"0 1 2 3 4","1 12 13 14"};
//		System.out.println(solution(a, 0, 12));

		System.out.println(solution(b, t, a));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		List<String> l = new ArrayList<String>(Arrays.asList(words));

		// target이 없는 경
		if (!l.contains(target)) {
			return 0;
		}

		answer = solution1(0, begin, target, l);
		// 변경 문자열이 target 비교시 한번 변경인지 확인

		// 2번 이상일경우 다음 문자열와 비교
		// 2번 이상 변경일경우 패스, 1번일경우 해당 문자열 변경

		// 그리고 해당 idx와 문자열?을 return?

		return 1 + words.length - answer;
	}

	public static int solution1(int idx, String begin, String target, List<String> words) {
		String[] beginArr = begin.split("");
		String[] targetArr = target.split("");

		int matCnt = 0;
		for (int i = 0; i < beginArr.length; i++) {
			if (!beginArr[i].equals(targetArr[i])) {
				matCnt += 1;
			}
		}

		if (matCnt == 1) {
			return words.size();
		}

		String[] wordArr = words.get(idx).split("");
		matCnt = 0;
		for (int i = 0; i < beginArr.length; i++) {
			if (!beginArr[i].equals(wordArr[i])) {
				matCnt += 1;
			}
		}

		if (matCnt == 1) {
			begin = words.get(idx);
			words.remove(idx);
			idx = 0;
			return solution1(idx, begin, target, words);
		}
		
		return solution1(idx + 1, begin, target, words);

//		while (true) {
//			if (idx > words.size()) {
//				return 0;
//			}
//
//			matCnt = 0;
//			for (int i = 0; i < beginArr.length; i++) {
//				if (!beginArr[i].equals(wordArr[i])) {
//					matCnt += 1;
//				}
//			}
//
//			if (matCnt == 1) {
//				begin = words.get(idx);
//				words.remove(idx);
//				idx = 0;
//				return 1 + solution1(idx + 1, begin, target, words);
//			}
//
//			return solution1(idx + 1, begin, target, words);
//		}

	}

//    public static int solution(String[] subway, int start, int end) {
//        int answer = 0;
//        List<List<SubWaysDto>> r = IntStream.range(0, subway.length).mapToObj(j -> {
//        	String [] arr = subway[j].split(" ");
//        	List<SubWaysDto> l =Arrays.stream(arr).map(x -> new SubWaysDto(j+"", Integer.parseInt(x))).collect(Collectors.toList());
//        	return l;
//        }).collect(Collectors.toList());
//        
//        List<SubWaysDto> first = r.stream().filter(x -> {
//        	return x.get(0).getNo() == start;
//        }).map(y -> y).collect(Collectors.toList()).get(0);
//
//        
//        List<SubWaysDto> last = r.stream().filter(x -> {
//        	return x.stream().filter(e -> e.getNo() == end).count() > 0;
//        }).map(y -> y).collect(Collectors.toList()).get(0);
//        
//        List<List<SubWaysDto>> l2 = r.stream().filter(x ->{
//        	String firstName = first.get(0).getName();
//        	String lastName = first.get(0).getName();
//        	return x.get(0).getName() != firstName || x.get(0).getName() != lastName; 
//        }).collect(Collectors.toList());
//        
//        
//        List<SubWaysDto> r1 = first.stream().filter(f -> {
//        	return f.getNo() == end;
//        }).collect(Collectors.toList());
//        
//        if (r1.size() > 0) {
//        	answer = 0;
//        	return answer;
//        }
//         
//        List<SubWaysDto> r2 = last.stream().filter(l -> {
//        	return first.stream().filter(f -> f.getNo() == f.getNo()).count() > 0;
//        }).collect(Collectors.toList());
//        
//        if (r2.size() > 0) {
//        	answer = 1;
//        	return answer;
//        }
//        
//        List<String> d1 = l2.stream().filter(ll -> {
//        	List<Integer> ii = first.stream().mapToInt(uu -> uu.getNo()).boxed().collect(Collectors.toList());
//        	
//        	return ll.stream().filter(y -> ii.contains(y.getNo())).count() > 0;
//        }).map(p -> p.get(0).getName()).collect(Collectors.toList());
//        
//        List<String> d2 = l2.stream().filter(ll -> {
//        	List<Integer> ii = last.stream().mapToInt(uu -> uu.getNo()).boxed().collect(Collectors.toList());
//        	
//        	return ll.stream().filter(y -> ii.contains(y.getNo())).count() > 0;
//        }).map(p -> p.get(0).getName()).collect(Collectors.toList());
//        
//        
//        List<String> aa = d1.stream().filter(oo -> {
//        	return d2.stream().filter(dd -> dd.equals(oo)).count() > 0;
//        }).collect(Collectors.toList());
//        answer = 1 + aa.size();
//         return answer;
//    }

}

class SubWaysDto {
	String name;
	int no;

	public SubWaysDto(String na, int n) {
		this.name = na + "";
		this.no = n;
	}

	public String getName() {
		return this.name;
	}

	public int getNo() {
		return this.no;
	}
}
