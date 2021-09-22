package algorithmLevel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyTest {
/**
 * 숫자를 역순으로 sort
 * @param args
 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		long n = 12345;
//		
//        int[] answer = {};
//        
//        String strN = ""+n;
//        
//        String arrN [] = strN.split("");
//        
//        List<String> l = new ArrayList<String>(Arrays.asList(arrN));
//        
//        answer = l.stream().sorted((a,b) -> b.compareTo(a)).mapToInt(i -> Integer.parseInt(i)).toArray();
//        System.out.println(Arrays.toString(answer));
//        
//	}
	/**
	 * 약수를 구해서 약수갯수에 따라 합과 차를 구하기
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//        int answer = 0;
//        for (int i=24; i<=27; i++){
//            if (i % Math.sqrt(i) == 0 ){
//                answer -= i;
//            } else {
//                answer += i;
//            }
//            
//            System.out.println(i + ":" + answer + " : " + (i % Math.sqrt(i) == 0));
//        }
//       System.out.println(answer);
//    }
	
//	class Solution {
//	    boolean solution(String s) {
//	        boolean answer = true;
//
//	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//	        System.out.println("Hello Java");
//
//	        return answer;
//	    }
//	}
	
//	문제 설명
//	대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//	예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
//
//	제한사항
//	문자열 s의 길이 : 50 이하의 자연수
//	문자열 s는 알파벳으로만 이루어져 있습니다.
//	입출력 예
//	s	answer
//	"pPoooyY"	true
//	"Pyy"	false
//	입출력 예 설명
//	입출력 예 #1
//	'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.
//
//	입출력 예 #2
//	'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.
	//========================================================
	
//	자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//			예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
//
//			제한사항
//			N의 범위 : 100,000,000 이하의 자연수
//			입출력 예
//			N	answer
//			123	6
//			987	24
//			입출력 예 설명
//			입출력 예 #1
//			문제의 예시와 같습니다.
//
//			입출력 예 #2
//			9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
	/**
	 *입려된 숫자들의 합
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int i = 123;
//		int answer = 0;
//		String s = i + "";
//		
//		String [] arr = s.split("");
//		
//		List<String> l = new ArrayList<String>(Arrays.asList(arr));
//		
//		answer = l.stream().mapToInt(n -> Integer.parseInt(n)).reduce(answer, (a,b) -> a+b);
//		System.out.println(answer);
//    }	
	/**
	 * 최소공약수 구하기 및 최대공약수 구하기
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  		int n = 3;
  		int m =12;
		
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		System.out.println("answer[0] : " + answer[0]);
		answer[1] = n * m / answer[0];
		System.out.println("n : " + n + " m : " + m + " n * m / answer[0] : " + (n * m / answer[0]));
		System.out.println(Arrays.toString(answer));
	}

	static int gcd(int a, int b) {
		while(b != 0) {
			System.out.println("a : " + a + " b : " + b + " a%b :" + (a%b));
			int r = a % b;
			a = b;
			b = r;
			System.out.println("r : " + r + " a : " + a + " b : " + b);
		}
		return a;
	}

//	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
//	예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
//
//	제한 사항
//	두 수는 1이상 1000000이하의 자연수입니다.
//	입출력 예
//	n	m	return
//	3	12	[3, 12]
//	2	5	[1, 10]
//	입출력 예 설명
//	입출력 예 #1
//	위의 설명과 같습니다.
//
//	입출력 예 #2
//	자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
}
