package algorithmLevel2;

import java.util.Arrays;

public class Test1 {
	
	public static void main(String[] args) {
		int [] weiths = {30, 30, 70, 40};	
				int limit = 100;
		System.out.println(solution(weiths, limit));
		
		System.out.println(solution(78));
	}
//	문제 설명
//	무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
//
//	예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
//
//	구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
//
//	사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
//
//	제한사항
//	무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
//	각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
//	구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
//	구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
//	입출력 예
//	people	limit	return
//	[70, 50, 80, 50]	100	3
//	[70, 80, 50]	100	3	
    public static int solution(int[] people, int limit) {
    	int cnt = 0;
        int j = 0;
        Arrays.sort(people);
        
        for(int i = people.length-1; i > j; i--) {
        	if(people[i] + people[j] <= limit) {
        		cnt++; 
        		j++;
        	}        		      	
        }
        
        return people.length - cnt;
    }
    
//    자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//    조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//    조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//    조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//    예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//    자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
//
//    제한 사항
//    n은 1,000,000 이하의 자연수 입니다.
//    입출력 예
//    n	result
//    78	83
//    15	23
//    입출력 예 설명
//    입출력 예#1
//    문제 예시와 같습니다.
//    입출력 예#2
//    15(1111)의 다음 큰 숫자는 23(10111)입니다.    
//    public int solution(int n) {
    public static int solution(int n) {
        int bitCount = Integer.bitCount(n);
          for(int i = n+1; ;i++) {
        	  int s = Integer.bitCount(i);
              if(bitCount == Integer.bitCount(i)) {
                  return i;
              }
          }
    }
}
