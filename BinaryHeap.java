public class BinaryHeap {

    private int[] data;
    private int size;
    private int INITIAL_SIZE = 10;

    public BinaryHeap() {
        data = new int[INITIAL_SIZE];
    }

    /**
     * Adds a given item to the array
     * @param item the item to be added/inserted
     */
    public void add(int item) {
        if (this.size >= this.data.length) {
            growArray();
        }
        this.data[size ++] = item; // put item at the end, then increment size

        int current = this.size - 1; // current position is last index
        int parent = (current - 1)/2; // formula for finding the parent index

        // swaps to make array numerical order
        while((data[current] < data[parent]) && current > 0) {// as long as the
        // current value is less than the parent object, switch!
            // Make sure to stop swapping if current does not have parent
            swap(data, current, parent);
            current = parent;
            parent = (parent - 1)/2; // find current's parents
        }
    }

    /**
     * Removes the last item from the array
     * @return the last item that is removed
     */
    public int remove() {
        //throw exception for size = 0
        try {
            if (size == 0) {

            throw new Exception("Size is 0!!!");

            }
        }catch (Exception e) {
            System.out.println("Error!");
        }
            swap(data, 0, size - 1);
            this.size --;
            if (this.size > 0) {
                shiftDown(0); }
        return data[size];

        /*
        int left_child = (2*parent_index) + 1
        int right_child = (2*parent_index) + 2
        int parent = (child_index - 1)/2
         */


    }

    public void shiftDown(int position){
        int parent  = position;
        int leftChild = 2 * parent + 1;
        int rightChild = 2* parent + 2;
        // base case
        if (leftChild >= size || rightChild >= size) // if out of bounds
        {
            return;
        }

        if (data[leftChild] > data[rightChild] && data[rightChild] < data[parent]) { // finds smaller child
            swap(data, parent, rightChild);
            shiftDown(rightChild);
        }
        else if(data[rightChild] > data[leftChild] && data[leftChild] < data[parent]) {
            swap(data, parent, leftChild);
            shiftDown(leftChild);
        }

    }

    /**
     * Grows the array to twice its length
     */
    public void growArray() {
        int[] twiceArray = new int[data.length * 2];
        for (int index = 0; index < data.length; index ++)
        {
            twiceArray[index] = data[index];
        }
        data = twiceArray;
    }

    /**
     * Swaps 2 given values from a give array
     * @param data the given aray
     * @param current position 1: one value to be swapped
     * @param parent position 2: another value to be swapped
     */
    private void swap(int[] data, int current, int parent) {
        int temp = data[current];
        data[current] = data[parent];
        data[parent] = temp;
    }

}


