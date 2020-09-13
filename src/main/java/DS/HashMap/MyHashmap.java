package DS.HashMap;

import java.util.ArrayList;
import java.util.List;

public class MyHashmap<k, v> {
    // bucketArray is used to store array of chains
    private List<HashNode<k, v>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    public MyHashmap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(k key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public void add(k key, v value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<k, v> head = bucketArray.get(bucketIndex);
        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<k, v> newNode = new HashNode<k, v>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
    }

    public v get(k key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<k, v> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;

    }


}
