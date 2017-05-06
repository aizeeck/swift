package lesson10_DataStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task7_StackMax {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")) {
            switch (command[0]) {
                case "PUSH":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "POP":
                    System.out.println(stack.pop());
                    break;
                case "MAX":
                    System.out.println(getMaxElement(stack));
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        stack.forEach(integer -> System.out.print(integer + " "));
    }

    private static int getMaxElement(ArrayDeque<Integer> stack) {
        ArrayList<Integer> stackElements = new ArrayList<>();
        stackElements.addAll(stack);
        stackElements.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2);
            }
        });
        return stackElements.get(stackElements.size() - 1);
    }
}
