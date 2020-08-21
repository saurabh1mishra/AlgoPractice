public final class ExceptionHandling {
    private ExceptionHandling() {
        //not called
    }

    private static String testTryCatchBlock() {
        try {
            return "try";
        } catch (Exception e) {
            return "catch";
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * @param args default args
     */
    public static void main(final String[] args) {
        System.out.println(testTryCatchBlock());
    }
}
