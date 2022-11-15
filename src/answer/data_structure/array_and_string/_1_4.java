package answer.data_structure.array_and_string;

// 1.4 주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라.
//        문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.
//        그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.
//        (주의 : Java로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 하라.)

public class _1_4 {

    public void replaceSpaces(String str, int length){
        char [] ch = str.toCharArray();

        int count = 0;
        //공백의 수 카운트
        for(int i =0; i<length; i++){
            if(ch[i] == ' ') count++;
        }
        
        //새 배열에 들어가는 배열크기 (공백->특정문자)
        int newLength = length + count*2;
        char [] newChar = new char[newLength];

        // 거꾸로부터 공백이 있으면 특정 문자로 바꾸어 채우는 로직
        for(int i=length-1; i>=0; i--){
            if(ch[i]==' '){
                newChar[newLength-1] = '0';
                newChar[newLength-2] = '2';
                newChar[newLength-3] = '%';
                newLength-=3;
            }else{
                newChar[newLength-1] = ch[i];
                newLength-=1;
            }
        }
        // 잘 출력하는지 확인
        System.out.println(String.valueOf(newChar));
    }

    public static void main(String[] args) {
        _1_4 solution = new _1_4();
        String a = "Mr John Smith";
        solution.replaceSpaces(a, 13);
    }
}
