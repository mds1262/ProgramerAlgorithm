package algorithmLevel1;

import java.util.Arrays;

public class Mytest2 implements Runnable{
	
//	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
//	예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//
//	제한 조건
//	strings는 길이 1 이상, 50이하인 배열입니다.
//	strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//	strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//	모든 strings의 원소의 길이는 n보다 큽니다.
//	인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
//	입출력 예
//	strings	n	return
//	["sun", "bed", "car"]	1	["car", "bed", "sun"]
//	["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
//	입출력 예 설명
//	입출력 예 1
//	"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
//
//	입출력 예 2
//	"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다. "abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.

//	public static void main(String[] args) {
//		String[] answer = {};
//		int n = 1;
//		String[] a = { "sun", "bed", "car" };
//		
//
//		List<String> l = new ArrayList<String>(Arrays.asList(a));
//
//		answer = l.stream()
//		.sorted((p,q) -> String.valueOf(p.charAt(n)).compareTo(String.valueOf(q.charAt(n))))
//		.toArray(String[]::new);
////		.collect(Collectors.toList());
//		
//		System.out.println(l.toString());
//	}

//	슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 
//	요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
//
//	이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
//	역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 
//	오렐리를 위해 실패율을 구하는 코드를 완성하라.
//
//	실패율은 다음과 같이 정의한다.
//	스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//	전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
//	실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
//
//	제한사항
//	스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
//	stages의 길이는 1 이상 200,000 이하이다.
//	stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
//	각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
//	단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
//	만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
//	스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
//	입출력 예
//	N	stages						result
//	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//	4	[4,4,4,4,4]					[4,1,2,3]
//	입출력 예 설명
//	입출력 예 #1
//	1번 스테이지에는 총 8명의 사용자가 도전했으며, 
//	이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
//	1 번 스테이지 실패율 : 1/8

//	2번 스테이지에는 총 7명의 사용자가 도전했으며, 
//	이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
//	2 번 스테이지 실패율 : 3/7

//	마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
//	3 번 스테이지 실패율 : 2/4

//	4번 스테이지 실패율 : 1/2

//	5번 스테이지 실패율 : 0/1

//	각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
//
//	[3,4,2,1,5]
//	입출력 예 #2
//
//	모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
//
//	[4,1,2,3]
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int N = 5; 
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] result = solution(N, stages);
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String[] args) {
		Mytest2 mt = new Mytest2();
		
		Thread t = new Thread(mt, "game");
		t.start();
		
	}
	
	public int[] solution(int N, int[] stages) {
		int[] answer = new int [N];
		int cnt, tnt = stages.length;
		
		Stage [] s = new Stage[N];
		
		//Stage와 실패율 구하기
		for(int i = 1; i <= answer.length; i++) {
			cnt = 0;
			for(int stage : stages) {
				if(stage == i) {
					cnt += 1;
				}
			}
			
			s[i -1] = new Stage(i, (float)cnt/(float)tnt);
			tnt = tnt - cnt;
		}
		
		Arrays.sort(s, (a, b) -> {
			if (a.failPer < b.failPer) {
				return 1;
			}else if(a.failPer > b.failPer) {
				return -1;
			}else {
				if(a.stage < b.stage) {
					return -1;
				}
			}
			
			return 0;
		});
		
		for(int i =0; i < answer.length; i +=1) {
			answer[i] = s[i].stage;
		}
		
		return answer;
	}
	
	class Stage {
		int stage;
		float failPer;
		
		Stage(int n, float p){
			this.stage = n;
			this.failPer = p;	
		}
	}
}
