package algorithmcase1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAvg {

	public static void main(String[] args) {
		int[][] a = { { 50, 90 }, { 50, 87 } };

		solution(a);
	}

	public static String solution(int[][] scores) {
		String answer = "";
		List<List<MemScores>> r = IntStream.range(0, scores.length).mapToObj(i -> {
			return IntStream.range(0, scores[i].length).mapToObj(j -> new MemScores(i, scores[j][i]))
					.collect(Collectors.toList());
		}).map(x -> {
			int max = x.stream().mapToInt(y -> y.getScore()).max().getAsInt();
			int min = x.stream().mapToInt(y -> y.getScore()).min().getAsInt();
			int no = x.get(0).getId();
			int noScore = x.get(no).getScore();

			int cnt = (int) x.stream().filter(u -> u.getScore() == noScore).count();

			if (noScore == max || noScore == min) {
				if (cnt == 1) {
					x.remove(no);
				}
			}
			return x;
		}).collect(Collectors.toList());

		List<Double> s = r.stream().map(x -> x.stream().mapToInt(i -> i.getScore()).average().getAsDouble())
				.collect(Collectors.toList());
		List<String> l = s.stream().map(x -> {
			String lev = "";

			if (x >= 90) {
				lev = "A";
			} else if (x >= 80 && x < 90) {
				lev = "B";
			} else if (x >= 70 && x < 80) {
				lev = "C";
			} else if (x >= 50 && x < 70) {
				lev = "D";
			}else {
				lev = "F";
			}

			return lev;
		}).collect(Collectors.toList());
		answer = String.join("", l);
		System.out.println(Arrays.toString(scores[0]));
		System.out.println(scores[0][0]);
		return answer;
	}
}

class MemScores {
	int id;
	int score;

	public MemScores(int i, int s) {
		this.id = i;
		this.score = s;

	}

	public int getId() {
		return this.id;
	}

	public int getScore() {
		return this.score;
	}
}