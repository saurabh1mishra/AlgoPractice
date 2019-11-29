package AddshutDown;

import javax.sound.midi.Soundbank;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Object f = new Object() {
            public void finalize() {
                System.out.println("Running finalize()");
            }
        };
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Running Shutdown Hook");
            }
        });

        f = null;
        System.out.println("test");
        System.gc();

        System.out.println("Calling System.exit()");
     System.exit(1);
    }
}
