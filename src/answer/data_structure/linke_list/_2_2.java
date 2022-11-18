package answer.data_structure.linke_list;

//2.2 단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.

import java.util.LinkedList;

public class _2_2 {

    public int prac(LinkedList list, int n){
        list.get(list.size()-n);
        System.out.println(list.get(list.size()-n));
        return 0;
    }


    public static void main(String[] args) {
        _2_2 solution = new _2_2();
        int n = 2;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(34);
        list.add(56);
        list.add(78);
        solution.prac(list, n);
    }
}
