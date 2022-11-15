package answer.data_structure.array_and_string;

// 1.8 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메서드가 있다고 하자.
//        s1과 s2의 두 문자열이 주어졌을 때,
//        s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstirng을 한 번만 호출하도록 하여 작성하라.
//        (가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다.

public class _1_8 {

    //s1에 s2가 포함되어 있는지 확인하는 메서드
    // 포함 : true / 미포함 : false
    public boolean isSubstring(String s1, String s2){
        if(s1.contains(s2)){
            return true;
        }
        return false;
    }


    // s1을 연속으로 붙여서 s1에 s2가 포함되어 있는지 확인
    // case1
    public boolean isRotated(String s1, String s2){
        String s1s1 = s1+s1;
        return isSubstring(s1s1, s2);
    }
    // case2
    public boolean isRotated2(String s1, String s2){
        return isSubstring(s1.concat(s1), s2);
    }

    public static void main(String[] args) {
        _1_8 main = new _1_8();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
// 		String s2 = "bottle";
        System.out.println(main.isRotated(s1, s2));
        System.out.println(main.isRotated2(s1, s2));
    }

}
