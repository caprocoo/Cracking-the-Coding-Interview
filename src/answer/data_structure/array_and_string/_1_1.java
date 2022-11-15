package answer.data_structure.array_and_string;

// 1.1 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
//         다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?

public class _1_1 {

    public boolean unique(String a){

        boolean flag = true;
        if(a.length()>256){
            flag = false;
        }
        boolean[] check = new boolean[256];
        for(int i=0; i<a.length(); i++){
            int value = a.charAt(i);
            if(check[value]){
                flag = false;
                break;
            }
            check[value] = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        _1_1 solution = new _1_1();
        solution.unique("atst");
    }
}
