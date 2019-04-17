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
        size = 0;
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
//            root = current; // so now root will eventually have min value
            swap(data, current, parent);
            //System.out.println("We swapped data[current] = " + data[current] + " and data[parent] = " + data[parent]);
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
        int remoItem;
        try {
            if (size == 0) {

            throw new Exception("Size is 0!!!");

            }
        }catch (Exception e) {
            System.out.println("Error!");
        }

            remoItem = data[0];
            swap(data, 0, size - 1);
            this.size --;
            if (this.size > 0) {
                shiftDown(0); }
        return remoItem;

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
        int parent  = position;
        int leftChild = 2 * parent + 1;
        int rightChild = 2* parent + 2;
        // base case
        if (leftChild >= size || rightChild >= size) // if out of bounds
        {
            // stop!
            return;
        }

        if (data[leftChild] > data[rightChild] && data[rightChild] < data[parent]) { // finds smaller child
           // System.out.println("position: " + position + " rigtchild " + rightChild );
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
//        System.out.println("current: " + current);
//        System.out.println("parent: " + parent);
    }

    private int getSize() {
        return this.size;
    }

    private void printData() {
        for (int index = 0; index < this.size; index ++) {
            System.out.print(this.data[index] + " ");
        }

    }

    /*public static void main(String[] args) {
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

    }*/

}
