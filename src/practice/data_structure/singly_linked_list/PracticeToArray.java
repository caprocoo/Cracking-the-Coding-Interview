package practice.data_structure.singly_linked_list;

// toArray() 는 크게 두 가지가 있다.
// 1. 아무런 인자 없이 현재 있는 리스트를 객체배열 (Object[])로 반환해주는 Object[] toArray().
// 2. 리스트를 이미 생성된 다른 배열에 복사해주고자 할 때 쓰는 T[]toArray(T[] a).
public class PracticeToArray {

    public static void main(String[] args)   {
        SLinkedList<Integer> list = new SLinkedList<>();

        // get list to array (using toArray())
        //장점 : SLinkedList에 있는 요소의 수만큼 정확하게 배열의 크기가 할당되어 반환된다.
        Object[] array1 = list.toArray();

        // get list to array (using toArray(T[] a)
        // 장점 : 객체 클래스로 상속관계에 있는 타입이나 Wrapper(Integer -> Number)같이 데이터 타입을 유연하게 캐스팅할 여지가 있다.
        Integer[] array2 = new Integer[10];
        array2 = list.toArray(array2);
    }


}
