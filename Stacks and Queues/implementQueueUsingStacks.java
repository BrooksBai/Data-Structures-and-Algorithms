/*
  LeetCode 232. Implement Queue using Stacks: https://leetcode.com/problems/implement-queue-using-stacks/
  Time: push, empty - O(1), pop, peek - amortized O(1)
  Space: O(n)
*/

class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        ensureThereAreItemsInPopStack();
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        ensureThereAreItemsInPopStack();
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }
    
    /** Put all items from the pushStack into the popStack if the popStack is empty. */
    private void ensureThereAreItemsInPopStack() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}