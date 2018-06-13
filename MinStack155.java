import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
题意：实现一个栈，这个栈有push，pop，getMin，top的方法
思路：主要还是一个栈，现成的数据结构，getMin的话，可以用另外一个栈来记录当前节点对应的min，push的时候，看情况push当前值或者min最小值，pop时候直接顺带pop就可以了
收获：击败了77 熟悉了类 构造方法 等
 */
class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> min = new Stack();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()||x<min.peek()){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek().intValue();
    }
    
    public int getMin() {
        return min.peek().intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */