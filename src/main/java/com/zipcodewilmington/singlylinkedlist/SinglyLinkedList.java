package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <SomeType extends Comparable<SomeType>> {

    private Node head;

    class Node {

        private SomeType element;
        private Node next;

        private Node() {}

        public Node(SomeType element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(element)
                    .append(",")
                    .append(" ")
                    .append(next)
                    .toString();
        }
    }

    public void addElement(SomeType elementToAdd) {
        Node tail = head;
        if (head == null) {
            head = new Node(elementToAdd);
        }
        else {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new Node(elementToAdd);
        }
    }

    public SomeType getElementAtNodeIndex(Integer nodeIndex) {
        Node tail = head;
        if (nodeIndex == 0) {
            return head.element;
        }
        else {
            while (nodeIndex > 0) {
                tail = tail.next;
                nodeIndex--;
            }
        }
        return tail.element;
    }

    public void removeElementAtIndex(Integer indexToRemove) {
        int count = 1;
        Node tail = head;
        SinglyLinkedList<SomeType> listWithElementRemoved = new SinglyLinkedList<SomeType>();
        if (head == null) {

        }
        else if (indexToRemove == 0) {
            head.element = null;
        }
        else {
            listWithElementRemoved.addElement(head.element);
            while (tail.next != null) {
                if (count != indexToRemove) {
                    listWithElementRemoved.addElement(tail.next.element);
                }
                tail = tail.next;
                count++;
            }
            head = listWithElementRemoved.head;
        }
    }

    public boolean containsElement(SomeType elementToFind) {
        Node tail = head;
        if (head.element.equals(elementToFind)) {
            return true;
        }
        else {
            while (!tail.element.equals(elementToFind)) {
                tail = tail.next;
                if (tail.next == null) {
                    break;
                }
            }
            if (tail.element.equals(elementToFind)) {
                return true;
            }
        }
        return false;
    }

    public Integer findElementIndex(SomeType elementToFind) {
        int count = 0;
        Node tail = head;
        if (containsElement(elementToFind)) {
            while (!tail.element.equals(elementToFind)) {
                tail = tail.next;
                count++;
                if (tail.next == null) {
                    break;
                }
            }
            if (tail.element.equals(elementToFind)) {
                return count;
            }
        }
        return -1;
    }

    public Integer sizeOfList() {
        int count = 1;
        Node tail = head;
        if (head == null) {
            return 0;
        }
        else if (head.next == null) {
            return 1;
        }
        else {
            while (tail.next != null) {
                tail = tail.next;
                count++;
            }
            return count;
        }
    }

    public SinglyLinkedList<SomeType> copyList() {
        Node tail = head;
        SinglyLinkedList<SomeType> newList = new SinglyLinkedList<SomeType>();
        if (head == null) {
            return newList;
        }
        newList.addElement(head.element);
        while (tail.next != null) {
            newList.addElement(tail.next.element);
            tail = tail.next;
        }
        return newList;
    }

    public void sortList() {
        SinglyLinkedList<SomeType> newList = new SinglyLinkedList<SomeType>();
        for (int i = 0; i < this.sizeOfList(); i++) {
            Node tail = head;
            if (tail != null) {
                while (tail.next != null) {
                    if (tail.element.compareTo(tail.next.element) == -1) {
                        newList.addElement(tail.element);
                    } else {
                        SomeType temp = tail.next.element;
                        tail.next.element = tail.element;
                        tail.element = temp;
                        newList.addElement((tail.element));
                    }
                    tail = tail.next;
                }
            }
        }
    }

    public int compareTo(SomeType object1, SomeType object2) {
        return object1.compareTo(object2);
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList[ " + head + " " + ']';
    }
}
