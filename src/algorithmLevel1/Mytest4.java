package algorithmLevel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mytest4 {
//	문제 설명
//	점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
//	다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
//	학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
//	예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
//	체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//	전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
//	여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
//	체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//	제한사항
//	전체 학생의 수는 2명 이상 30명 이하입니다.
//	체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//	여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//	여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//	여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//	입출력 예
//	n	lost	reserve	   return
//	5	[2, 4]	[1, 3, 5]	5
//	5	[2, 4]	[3]	        4
//	3	[3]	    [1]	        2
//	입출력 예 설명
//	예제 #1
//	1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
//
//	예제 #2
//	3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
//
//	출처
//
//	※ 공지 - 2019년 2월 18일 지문이 리뉴얼되었습니다.
//	※ 공지 - 2019년 2월 27일, 28일 테스트케이스가 추가되었습니다.

	public static void main(String[] args) {
		int n = 6;
		int[] lost = { 2, 4, 5, 6 };
		int[] reserve = { 3, 5 };
		System.out.println(solution(n, lost, reserve));
		
//		int[] arr = {5, 9, 7, 10};
//		int div = 5;
//		System.out.println(Arrays.toString(solution3(arr, div)));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lost1 = 0;
        int count = 0;
        
        //여벌 옷을 가지고 있는 학생이 도난 당하면 빌려줄 수 없도록 만든다.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost1++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        //옷을 빌려주고 -1로 만들어 뒤의 학생에게 빌려주지 않게 한다.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        //answer은 전체 학생수에서 잃어버린 학생 수를 뺀다.
        //후에 여벌옷을 가진 학생이 도난 당했으면 그 수만큼 더해주고 옷을 빌려준 학생 수 만큼 다시 더해준다.
        answer = n - lost.length + lost1 + count;
        
        return answer;
	}

//문제 설명
//어떤 정수들이 있습니다. 
//이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 
//실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//absolutes의 길이는 1 이상 1,000 이하입니다.
//absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
//signs의 길이는 absolutes의 길이와 같습니다.
//signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
//입출력 예
//absolutes	signs	result
//[4,7,12]	[true,false,true]	9
//[1,2,3]	[false,false,true]	0
//입출력 예 설명
//입출력 예 #1
//
//signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
//따라서 세 수의 합인 9를 return 해야 합니다.
//입출력 예 #2
//
//signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
//따라서 세 수의 합인 0을 return 해야 합니다.    
	public int solution1(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < absolutes.length; i += 1) {
			if (signs[i]) {
				answer += absolutes[i];
				continue;
			}
			answer -= absolutes[i];
		}
		return answer;
	}
	
//	문제 설명
//	단어 s의 가운데 글자를 반환하는 함수, 
//	solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//
//	재한사항
//	s는 길이가 1 이상, 100이하인 스트링입니다.
//	입출력 예
//	s	return
//	"abcde"	"c"
//	"qwer"	"we"
    public String solution2(String s) {
        String answer = "";
        String [] arr = s.split("");
        
        if (arr.length % 2 == 0) {
        	int c = (int) Math.ceil(arr.length /2);
        	answer = arr[c];
        	answer += arr[c+1];
        	return answer;
        }
        
        int c = (int) Math.ceil(arr.length /2);
    	answer = arr[c];
        
        return answer;
    }
    
//    문제 설명
//    array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
//    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
//
//    제한사항
//    arr은 자연수를 담은 배열입니다.
//    정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//    divisor는 자연수입니다.
//    array는 길이 1 이상인 배열입니다.
//    입출력 예
//    arr	        divisor	  return 
//    [5, 9, 7, 10]	 5	      [5, 10]
//    [2, 36, 1, 3]	 1	      [1, 2, 3, 36]
//    [3, 2, 6]	     10	      [-1]
//    입출력 예 설명
//    입출력 예#1
//    arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
//
//    입출력 예#2
//    arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
//
//    입출력 예#3
//    3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.  
    
    public static int[] solution3(int[] arr, int divisor) {
    	int[] answer = null;
//    	List<Integer> l = new ArrayList<Integer>();
    	
//        answer = l.stream().mapToInt(i -> i.intValue()).toArray();
        return answer;
    }
}
