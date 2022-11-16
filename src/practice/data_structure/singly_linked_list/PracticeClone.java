package practice.data_structure.singly_linked_list;

public class PracticeClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        SLinkedList<Integer> original = new SLinkedList<>();
        original.add(10);

        // 단순히 '=' 연산자로 객체를 복사하면 '주소'를 복사하는 것이기 때문에 원본 객체에도 영향을 미친다.
        // => 얕은복사(shallow copy)
        SLinkedList<Integer> copy = original;
        copy.add(20);

        //original 출력
        System.out.println("original list");
        for(int i = 0; i < original.size(); i++) {
            System.out.println("index " + i + " data = " + original.get(i));
        }

        //copy 출력
        System.out.println("copy list");
        for(int i = 0; i < copy.size(); i++) {
            System.out.println("index " + i + " data = " + copy.get(i));
        }

        //original과 copy의 주소 값이 같다
        System.out.println("original list reference : " + original);
        System.out.println("copy list reference : " + copy);

        SLinkedList<Integer> clone = (SLinkedList<Integer>) original.clone();
        clone.add(30);
        System.out.println("\nclone list");
        for(int i = 0; i < clone.size(); i++) {
            System.out.println("index " + i + " data = " + clone.get(i));
        }

        System.out.println("clone list reference : " + clone);


//        총 출력(console)
//        original list
//        index 0 data = 10
//        index 1 data = 20
//        copy list
//        index 0 data = 10
//        index 1 data = 20
//        original list reference : practice.data_structure.singly_linked_list.SLinkedList@1b6d3586
//        copy list reference : practice.data_structure.singly_linked_list.SLinkedList@1b6d3586

//        clone list
//        index 0 data = 10
//        index 1 data = 20
//        index 2 data = 30
//        clone list reference : practice.data_structure.singly_linked_list.SLinkedList@4554617c
    }


}
