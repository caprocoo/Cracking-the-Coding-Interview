package practice.data_structure.singly_linked_list;

public class Node<E> {
    E data;         // real data
    Node<E> next;   // 다음 노드객체를 가리키는 reference 변수

    Node(E data){
        this.data = data;
        this.next = null;
    }


}
