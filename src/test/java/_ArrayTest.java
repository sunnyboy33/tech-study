import static org.junit.jupiter.api.Assertions.*;

import ds._Array;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ds._Array unit test")
class _ArrayTest {

    private _Array arr;

    @BeforeEach
    void setUp() {
        arr = new _Array(5);
    }

    @Test
    @DisplayName("add() should increase size and store values correctly.")
    void testAddAndGet(){
        arr.add(10);
        arr.add(20);

        assertEquals(2, arr.size());
        assertEquals(10, arr.get(0));
        assertEquals(20, arr.get(1));
    }

    @Test
    @DisplayName("set() should modify the value at the given index.")
    void testSetAndGet(){
        arr.add(10);
        arr.add(20);

        arr.set(1, 37);
        assertEquals(37, arr.get(1));
    }

    @Test
    @DisplayName("remove() should delete the element and shift remaining elements left.")
    void testRemove(){
        arr.add(10);
        arr.add(20);
        arr.add(30);

        arr.remove(1);
        assertEquals(2, arr.size());
        assertEquals(30, arr.get(1));
    }

    @Test
    @DisplayName("remove() should throw exception when array is empty.")
    void testRemoveOnEmptyArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(0));
    }

    @Test
    @DisplayName("get() should throw exception when index is invalid.")
    void testInvalidIndex(){
        arr.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(5));
    }

    @Test
    @DisplayName("isEmpty() should reflect the current array state correctly.")
    void testIsEmpty() {
        assertTrue(arr.isEmpty());
        arr.add(1);
        assertFalse(arr.isEmpty());
    }
}