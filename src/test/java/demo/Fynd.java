package demo;

import org.apache.commons.collections.map.HashedMap;

import java.util.LinkedList;
import java.util.Queue;




/**
 *
 * Map <String, List<Log>>
 *
 * Mon 28 1:43 PM GET 192.168.1.1 200
 * Mon 28 1:44 PM GET 192.168.1.1 200
 * Mon 28 1:45 PM GET 192.168.1.2 200
 * Mon 28 1:46 PM GET 192.168.1.3 201
 *
 * use
 * <p>
 * FIFO
 * <p>
 * 1,2,3
 * <p>
 * 1,
 * 2,
 * <p>
 * <p>
 * <p>
 * 3,1,2
 */

public class Fynd {

    private Queue<User> userPool = new LinkedList<>();



    public Fynd() {
        User user1 = new User("Saurabh", "saurabh1", "8889999999");
        User user2 = new User("XYZ", "XYZ1", "8889899999");
        userPool.add(user1);
        userPool.add(user2);
        userPool.add(null);
    }

    public User getUser() {
        if (userPool.isEmpty()) {
            throw new RuntimeException("userList is empty.");
        }
        User user = userPool.poll();
        userPool.add(user);
        return user;
    }

    public static void main(String[] args) {
        try {
            Fynd fynd = new Fynd();
            System.out.println(fynd.getUser().getName());
            System.out.println(fynd.getUser().getName());
            System.out.println(fynd.getUser().getName());
            System.out.println(fynd.getUser().getName());
        } catch ( NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

}
