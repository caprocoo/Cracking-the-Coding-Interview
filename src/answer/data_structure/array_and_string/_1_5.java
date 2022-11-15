package answer.data_structure.array_and_string;

//1.5 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
//        가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3와 같이 압축되어야 한다.
//        압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열을 그대로 반환해야 한다.

public class _1_5 {

    public String replaceSpaces(String str){
        
        // 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우 기존 문자열 리턴
        int size = countCompression(str);
        if(size>=str.length()) return str;

        //압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지는 경우
        char [] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char c = ch[0];
        int count = 1;

        for(int i=1; i<ch.length; i++){
            if(c==ch[i]){
                count++;
            }else{
                sb.append(c);
                sb.append(count);
                c = ch[i];
                count =1;
            }
        }
        sb.append(c);
        sb.append(count);

        return String.valueOf(sb);
    }
    
    // 압축 결과로 만들어지는 문자열의 개수 리턴
    public int countCompression(String str){
        //만약 문자열이 비어있거나 null 인 경우 0 출력
        if(str.isEmpty() || str == null) return 0;
        int count = 0;
        int size = 0;
        char [] ch = str.toCharArray();
        char c = ch[0];
        for(int i=1; i<ch.length; i++){
            if(c==ch[i]) count++;
            else{
                // size : 문자와 연속된 문자의 개수의 길이 (여기서 1은 문자 하나를 가정하여 넣은 것)
                // ex) count : 3, String.valueOf(count) : 1 / count : 30, String.valueOf(count) : 2
                size = size+String.valueOf(count).length()+1;
                count = 1;
                //새로운 문자를 기입해준다.
                c = ch[i];
            }
        }
        //마지막에 한번 더 넣어줘야함
        size = size+String.valueOf(count).length()+1;
        return size;
    }

    public static void main(String[] args) {
        _1_5 solution = new _1_5();
        String a = "aabccccccccaaa";
//        String a = "ababab";
        solution.replaceSpaces(a);
//        System.out.println(solution.replaceSpaces(a));
    }
}
