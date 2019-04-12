public class BinaryHeap {

    private float[] data;
    private int size;
    private int INITIAL_SIZE = 10;
    private int root;

    public BinaryHeap{
        Object[] tempArray = (T[]) new Object[INITIAL_SIZE];
        data = (T[]) tempArray;
        // or
        data = new float[INITIAL_SIZE];
        size = INITIAL_SIZE;
    }

    /**
     * Adds a given item to the array
     * @param item the item to be added/inserted
     */
    public void add(float item) {
        // grow array if needed
        if (data.length == size) {
            growArray();
        }
        data[size ++] = item; // put item at the end, then increment size
        int current = size - 1; // current position is penultimate index
        int parent = (current - 1)/2; // formula for finding the parent index

        // swaps to make array numerical order
        while(data[current] < data[parent] && current != 0); {// as long as the
        // current value is less than the parent object, switch! Make sure to stop swapping if current
            // does not have parent
            root = current; // so now root will eventually have min value
            swap(data, current, parent);
            current = parent;
            parent = (parent - 1)/2;
        }
    }

    /**
     * Removes the last item from the array
     * @return the last item that is removed
     */
    public float remove() {
        /*
        Swap the last item with the root, or the smallest item
         */
        swap(data, 0, size - 1);
        data[root] = data[size - 1];
        data[size - 1] = 0;
        size --;
        if (size > 0) {
            shiftDown(0);
        }
        return data[size];

        /*
        int left_child = (2*parent_index) + 1
        int right_child = (2*parent_index) + 2
        int parent = (child_index - 1)/2
        while parent < child {
        child = parent;
        parent = (parent - 1)/2;
         */

    }

    public void shiftDown(int position){
        int child = 2 * position + 1;
        // base case
        if (size < child) {
            if (data[child] > data[child + 1]) { // finds smaller child
                child ++;
            }
            if (data[position] > data[child]) { // compares position and child
                swap(data, child, position); // swaps if necessary
                shiftDown(child);
            }
        }

    }

    /**
     * Grows the array to twice its length
     */
    public void growArray() {
        float[] twiceArray = new float[data.length * 2];
        for (int index = 0; index < data.length; index ++)
        {
            twiceArray[index] = data[index];
        }
        data = twiceArray;
    }



    /**
     * Swaps 2 given values from a give array
     * @param data the given aray
     * @param current one value to be swapped
     * @param parent another value to be swapped
     */
    private void swap(float[] data, int current, int parent) {
        float temp = data[current];
        data[current] = data[parent];
        data[parent] = temp;
    }
}
