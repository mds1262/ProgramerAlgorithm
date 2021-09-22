package algorithmLevel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mytest3 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
//	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, 
//	solution을 완성해주세요.
//	s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//	제한 사항
//	str은 길이 1 이상인 문자열입니다.
//	입출력 예
//	s			return
//	"Zbcdefg"	"gfedcbZ"
	
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String a = solution(s);
		System.out.println(a);
//		
//		String [] arr = {"Jane", "Kim"}; 
//		String a = solution(arr);
//		System.out.println(a);
		
	}
	
    public static String solution(String s) {
        String answer = "";
        String [] arr = s.split("");
        
//        answer = Arrays.stream(arr).sorted((a,b) -> b.compareTo(a)).reduce("",(p, n) -> {
//        	p += n;
//        	return p;
//        });
        List<String> l = new ArrayList<String>();
        for (String ss : arr) {
        		l.add(ss);
        }
        
        Collections.sort(l, Collections.reverseOrder());

        return String.join("", l);
    }
//    
//    문제 설명
//    String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, 
//    "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
//    seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
//
//    제한 사항
//    seoul은 길이 1 이상, 1000 이하인 배열입니다.
//    seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
//    "Kim"은 반드시 seoul 안에 포함되어 있습니다.
//    입출력 예
//    seoul	return
//    ["Jane", "Kim"]	"김서방은 1에 있다"
	
//    public static String solution(String[] seoul) {
//        String answer = "";
//        int i = 0;
//        for(String s : seoul) {
//        	if (s.equals("Kim")) {
//        		break;
//        	}
//        	i += 1;
//        }
//        
//        answer = String.format("김서방은 %d에 있다", i);
//        return answer;
//    }
}
