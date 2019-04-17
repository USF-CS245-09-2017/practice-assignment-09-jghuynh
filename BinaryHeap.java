import java.sql.SQLOutput;

public class BinaryHeap {

    private int[] data;
    private int size;
    private int INITIAL_SIZE = 10;
    private int root;

    public BinaryHeap() {
//        Object[] tempArray = (T[]) new Object[INITIAL_SIZE];
//        data = (T[]) tempArray;
        // or
        data = new int[INITIAL_SIZE];
    }

    /**
     * Adds a given item to the array
     * @param item the item to be added/inserted
     */
    public void add(int item) {
        // grow array if needed
        if (this.size >= this.data.length) {
            growArray();
        }
        this.data[size ++] = item; // put item at the end, then increment size

        int current = this.size - 1; // current position is penultimate index
        int parent = (current - 1)/2; // formula for finding the parent index
        //System.out.println("Current = " + current + "\t data[current] = " + data[current]);
        //System.out.println("Parent = " + parent + "\t data[parent] = " + data[parent]);

        // swaps to make array numerical order
        while((data[current] < data[parent]) && current > 0) {// as long as the
        // current value is less than the parent object, switch! Make sure to stop swapping if current
            // does not have parent
            root = current; // so now root will eventually have min value
            swap(data, current, parent);
            //System.out.println("We swapped data[current] = " + data[current] + " and data[parent] = " + data[parent]);
            current = parent;
            parent = (current - 1)/2; // find current's parents
        }
    }

    /**
     * Removes the last item from the array
     * @return the last item that is removed
     */
    public int remove() {
        swap(data, 0, size - 1);
        System.out.println("Size = " + size);
        System.out.println("Just swapped position1 = " + 0 + "\t position2 = " + (size - 1));
        System.out.println("Now data[0] = " + data[0] + "\t data[size - 1] = " + data[size - 1]);
        int removedItem = data[0];
        System.out.println("RemovedItem = " + removedItem);
        this.data[this.root] = this.data[this.size - 1]; // root item copies the last item (position still at root)
        this.data[0] = data[root];
        System.out.println("Root = " + root);
        System.out.println("data[root] = " + data[size - 1]);
        this.data[this.size - 1] = 0; // get rid of the empty space
        System.out.println("data[size - 1] = last index = " + data[size - 1]);
        this.size --;
        System.out.println("Size = " + size);
        if (this.size > 0) {
            shiftDown(0);
        }
        System.out.println("removedItem = " + removedItem);
        System.out.println("data[size - 1] = last index = " + data[size - 1]);
        return removedItem;

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

    private int getSize() {
        return this.size;
    }

    private void printData() {
        for (int index = 0; index < this.size; index ++) {
            System.out.print(this.data[index] + " ");
        }

    }

    public static void main(String[] args) {
        BinaryHeap myHeap = new BinaryHeap();
        System.out.println("Adding 4");
        myHeap.add(4);
        System.out.println("Adding 5");
        myHeap.add(5);
        myHeap.printData();
        System.out.println("Removing 5");
        System.out.println(myHeap.remove());
        System.out.println("Heap after removing 5");
        myHeap.printData();
        System.out.println("Adding 3");

        myHeap.add(3);
        myHeap.printData();
        System.out.println("Adding 8");
        myHeap.add(8);
        myHeap.printData();
        System.out.println("Size = " + myHeap.getSize());
        System.out.println("Removing " + 8);
        myHeap.remove();
        myHeap.printData();
        // 3, 4
        // shit remove doesn't always remove the biggest number
        //myHeap.add(2);

        System.out.println("For-loop");
        for (int index = 0; index < myHeap.getSize(); index ++) {
            myHeap.printData();
            System.out.println("size = " + myHeap.getSize());
        }

    }

}
