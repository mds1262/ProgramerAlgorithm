package algorithmdfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test5 {

	public static void main(String[] args) {
		int[][] a = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] b = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		solution(a, b);
	}

	public static int solution(int[][] game_board, int[][] table) {
		int answer = -1;

		List<Blocks> boards = IntStream.range(0, game_board.length).mapToObj(i -> {
			int cnt = (int) Arrays.stream(game_board[i]).filter(n -> n == 0).count();
			Blocks b = new Blocks(cnt, game_board[i].length);
			return b;
		}).collect(Collectors.toList());

		List<Blocks> tables = IntStream.range(0, table.length).mapToObj(i -> {
			int cnt = (int) Arrays.stream(table[i]).filter(n -> n == 1).count();
			Blocks b = new Blocks(cnt, table[i].length);
			return b;
		}).collect(Collectors.toList());

		int[] sum = IntStream.range(0, tables.size()).filter(i -> {
			int bCnt = boards.get(i).getCnt();
			int tCnt = tables.get(i).getCnt();
			int size = boards.get(i).getSize();
			boolean b = (bCnt+tCnt) == size;
			return true;
		}).map(j -> j).toArray();
//				.mapToObj(j -> {
//			System.out.println(j);
//			return tables.get(j);
//		}).mapToInt(t -> {
//			System.out.println(t);
//			return t.getCnt();
//				}).sum();
		
		return answer;
	}
}

class Blocks {
	int cnt;
	int size;

	public Blocks(int c, int s) {
		this.cnt = c;
		this.size = s;
	}
	
	public int getCnt() {
		return this.cnt;
	}
	
	public int getSize() {
		return this.size;
	}
}
