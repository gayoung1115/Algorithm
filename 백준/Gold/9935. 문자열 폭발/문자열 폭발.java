import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        String word = br.readLine();

        StringBuilder output = new StringBuilder();

        if (word.length() > input.length()) {
            output.append(input);
        } else {
            for (int i = 0; i < input.length(); i++) {
                stack.add(input.charAt(i));
                if (stack.size() >= word.length() && stack.peek() == word.charAt(word.length() - 1)) {
                    boolean check = false;
                    for (int j = 0; j < word.length(); j++) {
                        if (stack.get(stack.size() - word.length() + j) != word.charAt(j)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        for (int j = 0; j < word.length(); j++)
                            stack.pop();
                    }
                }
            }
            for (Character c : stack)
                output.append(c);

            if (output.length() > 0)
                System.out.print(output.toString());
            else
                System.out.print("FRULA");
        }

    }
}