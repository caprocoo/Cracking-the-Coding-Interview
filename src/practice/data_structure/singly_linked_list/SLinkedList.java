package practice.data_structure.singly_linked_list;

import java.util.NoSuchElementException;

//Cloneable가 없이 clone을 하게 되면 CloneNotSupportedException 에러가 난다.
public class SLinkedList<E> implements List<E>,Cloneable{
    
    private Node<E> head;   // 노드의 첫 부분
    private Node<E> tail;   // 노드의 마지막 부분
    private int size;       // 요소 개수

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 특정 위치의 노드를 반환하는 메소드
    private Node<E> search(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = head; // head가 가리키는 노드부터 시작
        for (int i = 0; i < index; i++) {
            x = x.next; // x노드의 다음 노드를 x에 저장한다
        }
        return x;
    }

    // addFirst(E value)
    // 1. make new Node -> 2. linking -> 3. update head
    public void addFirst(E value){
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;
        head = newNode;
        size++;

        /**
         * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우)
         * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
         * 마지막 노드다. 즉 tail = head 다.
         */
        if (head.next == null) {
            tail = head;
        }
    }

    // add(E value) & addLast(E value)
    // 1. make new Node -> 2. linking -> 3. update tail
    //linkedList의 add함수는 기본적으로 마지막 노드로 추가된다 (=addLast)
    @Override
    public boolean add(E value){
        addLast(value);
        return true;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<E>(value);

        if(size==0){
            addFirst(value);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;

    }

    // add(int index, E value)
    // 1. make new Node -> 2. unlinking -> 3. linking

    @Override
    public void add(int index, E value){

        // 잘못된 인덱스를 참조할 경우 예외 발생
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
        if (index == 0) {
            addFirst(value);
            return;
        }
        // 추가하려는 index가 마지막 위치일 경우 addLast 호출
        if (index == size) {
            addLast(value);
            return;
        }

        // 추가하려는 위치의 이전 노드
        Node<E> prev_Node = search(index - 1);

        // 추가하려는 위치의 노드
        Node<E> next_Node = prev_Node.next;

        // 추가하려는 노드
        Node<E> newNode = new Node<E>(value);

        /**
         * 이전 노드가 가리키는 노드를 끊은 뒤
         * 새 노드로 변경해준다.
         * 또한 새 노드가 가리키는 노드는 next_Node로
         * 설정해준다.
         */
        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;
    }


    // remove ()
    // default는 '가장 앞에 있는 요소'를 제거하는 것이다.
    // 1. search head Node and remove(null) -> 2. unlinking -> 3. update head
    public E remove(){
        Node<E> headNode = head;

        if (headNode == null)
            // 리스트에 아무 요소가 없는데 삭제를 시도하는 경우 요소를 찾을 수 없기 때문에 예외처리를 한다.
            throw new NoSuchElementException();

        // 삭제된 노드를 반환하기 위한 임시 변수
        E element = headNode.data;

        // head의 다음 노드
        Node<E> nextNode = head.next;

        // head 노드의 데이터들을 모두 삭제
        head.data = null;
        head.next = null;

        // head 가 다음 노드를 가리키도록 업데이트
        head = nextNode;
        size--;

        /**
         * 삭제된 요소가 리스트의 유일한 요소였을 경우
         * 그 요소는 head 이자 tail이었으므로
         * 삭제되면서 tail도 가리킬 요소가 없기 때문에
         * size가 0일경우 tail도 null로 변환
         */
        if(size == 0) {
            tail = null;
        }
        return element;
    }

    //remove(int index)
    // 1. search head Node and remove(null) -> 2. unlinking -> 3. linking
    @Override
    public E remove(int index) {

        // 삭제하려는 노드가 첫 번째 원소일 경우
        if (index == 0) {
            return remove();
        }

        // 잘못된 범위에 대한 예외
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index - 1);	// 삭제할 노드의 이전 노드
        Node<E> removedNode = prevNode.next;	// 삭제할 노드
        Node<E> nextNode = removedNode.next;	// 삭제할 노드의 다음 노드

        E element = removedNode.data;	// 삭제되는 노드의 데이터를 반환하기 위한 임시변수

        // 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경
        prevNode.next = nextNode;

        // 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
        if(prevNode.next == null) {
            tail = prevNode;
        }
        // 데이터 삭제
        removedNode.next = null;
        removedNode.data = null;
        size--;

        return element;
    }


    //remove(Object value)
    // 1. search head Node and remove(null) -> 2. unlinking -> 3. linking

    @Override
    public boolean remove(Object value) {

        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> x = head;	// removedNode

        // value 와 일치하는 노드를 찾는다.
        for (; x != null; x = x.next) {
            if (value.equals(x.data)) {
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        // 일치하는 요소가 없을 경우 false 반환
        if(x == null) {
            return false;
        }

        // 만약 삭제하려는 노드가 head라면 기존 remove()를 사용
        if (x.equals(head)) {
            remove();
            return true;
        }

        else {
            // 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
            prevNode.next = x.next;

            // 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
            if(prevNode.next == null) {
                tail = prevNode;
            }
            x.data = null;
            x.next = null;
            size--;
            return true;
        }
    }

    //get(int index)
    @Override
    public E get(int index) {
        return search(index).data;
    }

    //set(int index, E value)
    @Override
    public void set(int index, E value){
        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

    //indexOf(Object value)
    @Override
    public int indexOf(Object value){
        int index = 0;
        for(Node<E> x = head; x!=null; x = x.next){
            if(value.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    //contains(Object item)
    @Override
    public boolean contains(Object item){
        return indexOf(item)>=0;
    }

    //size()
    @Override
    public int size() {
        return size;
    }

    //isEmpty()
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //clear()
    @Override
    public void clear() {
        for (Node<E> x = head; x != null;) {
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    public Object clone() throws CloneNotSupportedException{

        // <? super T> : T 타입과 T 타입이 상속받은 조상 클래스 타입만을 사용할 수 있음.
        // super.clone()을 하게되면 객체 자체는 생성되나 내부까지 데이터 복제가 이루어지지 않는 얕은 복사가 되어버린다.
        @SuppressWarnings("unchecked")
        SLinkedList<? super E> clone = (SLinkedList<? super E>) super.clone();

        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        for (Node<E> x = head; x != null; x = x.next) {
            clone.addLast(x.data);
        }

        return clone;

    }
    public Object[] toArray() {
        Object[] array = new Object[size];
        int idx = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            array[idx++] = (E) x.data;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Array.newInstance(컴포넌트 타입, 생성할 크기)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.data;
        }
        return a;
    }








}
