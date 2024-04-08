import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    private int count;

    // Constructor
    public AccessCountArrayList() {
        super();
        count = 0;
    }

    // Overridden get method
    @Override
    public E get(int index) {
        count++; // Increment the access counter
        return super.get(index); // Call the superclass version of the get method
    }

    // Overridden set method
    @Override
    public E set(int index, E element) {
        count++; // Increment the access counter
        return super.set(index, element); // Call the superclass version of the set method
    }

    // New method: getAccessCount
    public int getAccessCount() {
        return count;
    }

    // New method: resetCount
    public void resetCount() {
        count = 0;
    }
}
