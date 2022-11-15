package answer.data_structure.array_and_string;

// 1.3 문자열 두 개를 입력으로 받아 그 중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.

public class _1_3 {

    // 1. 두 문자열을 정렬한 후 같은지 비교하는 로직
    public String sort (String a){

        char [] ch = a.toCharArray();
        java.util.Arrays.sort(ch);
        return new String(ch);
    }
    public boolean permutation (String a, String b){

        if(a.length()!=b.length()){
            return false;
        }
        return sort(a).equals(b);
    }

    // 2. 문자열에 포함된 문자의 출현 횟수가 같은지 검사하는 로직
    public boolean permutation2(String a, String b){
        
        if(a.length()!=b.length()) return false;
        
        // 문자집합으로 아스키 코드를 사용한다 가정함.
        int [] check = new int[256];

        // 매개변수 a를 char 배열 ch_a에 담는다.
        char [] ch_a = a.toCharArray();

        // ch_a에 있는 단어만큼 check 위치에 + 시킨다.
        for(char c : ch_a){
            check[c]++;
        }
        // b의 단어 index에 따라 check -를 적용하고, check[b값] 가 0보다 작을 시 수열이 아니라고 판단.
        for(int i=0; i<check.length; i++){
            int c = b.charAt(i);
            if(--check[c]<0){
                return false;
            }
        }

        
        return true;
    }

    public static void main(String[] args) {
        _1_3 solution = new _1_3();
        solution.permutation("dog", "god");
        solution.permutation2("dog", "god");
    }
}
