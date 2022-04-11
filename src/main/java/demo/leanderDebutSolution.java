package demo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'smallestNegativeBalance' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY debts as parameter.
     */

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here
        Map<String, Integer> balance = new HashMap<>();
        for (List<String> debt : debts) {
            if (balance.containsKey(debt.get(0))) {
                balance.put(debt.get(0), balance.get(debt.get(0)) - Integer.parseInt(debt.get(2)));
            } else {
                balance.put(debt.get(0), Integer.parseInt(debt.get(2)) * -1);
            }
        }
        for (List<String> debt : debts) {
            if (balance.containsKey(debt.get(1))) {
                balance.put(debt.get(1), balance.get(debt.get(1)) + Integer.parseInt(debt.get(2)));
            } else {
                balance.put(debt.get(1), Integer.parseInt(debt.get(2)));
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(balance.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int min = 0;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> set : list) {
            if (set.getValue() <= min && set.getValue() < 0) {
                min = set.getValue();
                result.add(set.getKey());
            }
        }

        Collections.sort(result);
        if (result.size() == 0)
            result.add("Nobody has a negative balance");

        return result;

    }
}

public class leanderDebutSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int debtsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int debtsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> debts = new ArrayList<>();

        IntStream.range(0, debtsRows).forEach(i -> {
            try {
                debts.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.smallestNegativeBalance(debts);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}