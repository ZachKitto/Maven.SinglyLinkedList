package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();

    @Test
    public void nullaryConstructorTest() {
        // Given
        SinglyLinkedList.Node expectedHead = null;

        // When
        SinglyLinkedList.Node actualHead = singlyLinkedList.getHead();

        // Then
        Assert.assertEquals(expectedHead, actualHead);
    }

    @Test
    public void addNodeTest_FirstElementInList() {
        // Given
        Integer expectedElementAdded = 6;

        // When
        singlyLinkedList.addElement(expectedElementAdded);
        Integer actualElementAdded = singlyLinkedList.getElementAtNodeIndex(0);

        // Then
        Assert.assertEquals(expectedElementAdded, actualElementAdded);
    }

    @Test
    public void addNodeTest() {
        // Given
        Integer expectedFirstElementAdded = 4;
        Integer expectedSecondElementAdded = 6;
        Integer expectedThirdElementAdded = 10;

        // When
        singlyLinkedList.addElement(expectedFirstElementAdded);
        singlyLinkedList.addElement(expectedSecondElementAdded);
        singlyLinkedList.addElement(expectedThirdElementAdded);
        Integer actualFirstElementAdded = singlyLinkedList.getElementAtNodeIndex(0);
        Integer actualSecondElementAdded = singlyLinkedList.getElementAtNodeIndex(1);
        Integer actualThirdElementAdded = singlyLinkedList.getElementAtNodeIndex(2);

        // Then
        Assert.assertEquals(expectedFirstElementAdded, actualFirstElementAdded);
        Assert.assertEquals(expectedSecondElementAdded, actualSecondElementAdded);
        Assert.assertEquals(expectedThirdElementAdded, actualThirdElementAdded);
    }

    @Test
    public void getElementAtNodeIndexTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        Integer thirdNodeIndex = 2;
        Integer expectedElement = 10;

        // When
        Integer actualElement = singlyLinkedList.getElementAtNodeIndex(thirdNodeIndex);


        // Then
        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void removeElementAtIndexTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(87);
        singlyLinkedList.addElement(1);

        // When
        System.out.println(singlyLinkedList);
        singlyLinkedList.removeElementAtIndex(4);
        System.out.println(singlyLinkedList);
        boolean doesContain10 = singlyLinkedList.containsElement(10);
        boolean doesContain5 = singlyLinkedList.containsElement(5);
        boolean doesContain34 = singlyLinkedList.containsElement(34);


        // Then
        Assert.assertTrue(doesContain10);
        Assert.assertTrue(doesContain5);
        Assert.assertFalse(doesContain34);
    }

    @Test
    public void containsElementTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(87);
        singlyLinkedList.addElement(1);

        // When
        boolean doesContain87 = singlyLinkedList.containsElement(87);
        boolean doesContain10 = singlyLinkedList.containsElement(10);
        boolean doesContain5 = singlyLinkedList.containsElement(5);

        // Then
        Assert.assertTrue(doesContain87);
        Assert.assertTrue(doesContain10);
        Assert.assertTrue(doesContain5);
    }

    @Test
    public void findElementIndexTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(87);
        singlyLinkedList.addElement(1);
        Integer expectedIndexOfElement87 = 5;
        Integer expectedIndexOfElement10 = 2;
        Integer expectedIndexOfElement5 = 1;
        Integer expectedIndexOfElement99 = -1;

        // When
        Integer actualIndexOfElement87 = singlyLinkedList.findElementIndex(87);
        Integer actualIndexOfElement10 = singlyLinkedList.findElementIndex(10);
        Integer actualIndexOfElement5 = singlyLinkedList.findElementIndex(5);
        Integer actualIndexOfElement99 = singlyLinkedList.findElementIndex(99);

        // Then
        Assert.assertEquals(expectedIndexOfElement87, actualIndexOfElement87);
        Assert.assertEquals(expectedIndexOfElement10, actualIndexOfElement10);
        Assert.assertEquals(expectedIndexOfElement5, actualIndexOfElement5);
        Assert.assertEquals(expectedIndexOfElement99, actualIndexOfElement99);
    }

    @Test
    public void sizeOfListTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(87);
        Integer expectedSizeOfList1 = 6;
        Integer expectedSizeOfList2 = 7;

        // When
        Integer actualSizeOfList1 = singlyLinkedList.sizeOfList();
        singlyLinkedList.addElement(1);
        Integer actualSizeOfList2 = singlyLinkedList.sizeOfList();

        // Then
        Assert.assertEquals(expectedSizeOfList1, actualSizeOfList1);
        Assert.assertEquals(expectedSizeOfList2, actualSizeOfList2);
    }

    @Test
    public void copyListTest() {
        // Given
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(87);
        SinglyLinkedList<Integer> expectedList = new SinglyLinkedList<Integer>();
        expectedList.addElement(4); expectedList.addElement(5); expectedList.addElement(10);
        expectedList.addElement(55); expectedList.addElement(34); expectedList.addElement(87);

        // When
        SinglyLinkedList<Integer> actualList = singlyLinkedList.copyList();

        // Then
        for (int i = 0; i < singlyLinkedList.sizeOfList(); i++) {
            Assert.assertEquals(expectedList.findElementIndex(i), actualList.findElementIndex(i));
        }
    }

    @Test
    public void sortListTest() {
        // Given
        singlyLinkedList.addElement(55);
        singlyLinkedList.addElement(87);
        singlyLinkedList.addElement(10);
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(34);
        singlyLinkedList.addElement(5);
        Integer expectedFirstElement = 4;
        Integer expectedSecondElement = 5;

        // When
        singlyLinkedList.sortList();
        Integer actualFirstElement = singlyLinkedList.getElementAtNodeIndex(0);
        Integer actualSecondElement = singlyLinkedList.getElementAtNodeIndex(1);

        // Then
        Assert.assertEquals(expectedFirstElement, actualFirstElement);
        Assert.assertEquals(expectedSecondElement, actualSecondElement);
    }
}
