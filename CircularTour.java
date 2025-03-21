import java.util.*;

class StockSpan {
    static int[] calculateSpan(int price[]) {
        Stack<Integer> stack = new Stack<>();
        int span[] = new int[price.length];

        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}

// Input: [100, 80, 60, 70, 60, 75, 85]
// Output: [1, 1, 1, 2, 1, 4, 6]