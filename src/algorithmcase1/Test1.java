package algorithmcase1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		int a = 6;
		int[] b = { 7, 10 };
		solution(a, b);
	}

	public static long solution(int n, int[] times) {
		// 1.최초 처음 감독관수만큼 인원수 제거
		// 2.items을 최소 시간순으로 정렬
		// 3.가장 작은수 * 인원수 => 그다음 작은수보다 작은경우 해당 인원수만큼 추
		// 클경우 그 전 인원수만큼만 추가
		// 각각의 소모된 시간 * 인원수을 비교하여 가장큰숫자

		/**
		 * 이분탐색으로 해야된다 start mid end
		 */

		long answer = Long.MAX_VALUE;

		Arrays.sort(times);

		long start = times[0]; // 1분 부터
		long end = (long) times[times.length - 1] * (long) n; // times에는 심사대 마다 걸리는 시간이 걸려있으니 최대시간 = 가장오래걸리는시간 * 인원수

		long mid; // 최소분
		long sum = 0;
		int idx = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			for (int time : times) {
				sum += mid / time;
			}
			System.out.println(idx + " 회차 : " + "start : " + start + " end : " + end + " mid : " + mid + " sum : " + sum + " answer : " + answer);
			if (sum >= n) {
				answer = Math.min(answer, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
			System.out.println(idx + " 회차 : " + "start : " + start + " end : " + end + " mid : " + mid + " sum : " + sum + " answer : " + answer);
			idx += 1;
		}

//        List<Integer> l2 = l.stream().collect(Collectors.groupingBy(i -> i))
//        .entrySet().stream()
//        .sorted((a,b) -> {
//        	int s1 = a.getValue().stream().mapToInt(o -> o).sum();
//        	int s2 = b.getValue().stream().mapToInt(o -> o).sum();
//        	return s1 - s2;
//        }).flatMapToInt(x -> x.getKey().intValue())
//        .boxed().collect(Collectors.toList());

		return answer;
	}

//	public int searchTime(int idx, int[] times, List<Integer> item) {
//		int time = times[idx];
//		
//		int tiemSum = item.stream().filter(i -> i==time).mapToInt(i -> i).sum();
//		
//		
//	}
}
