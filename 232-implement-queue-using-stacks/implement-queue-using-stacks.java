import java.util.Stack;

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        input.push(x);
    }

    // Remove and return front element
    public int pop() {
        peek(); // Ensure output stack has elements
        return output.pop();
    }

    // Get front element
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Check if queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
