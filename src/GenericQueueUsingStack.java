import java.util.Stack;

public class GenericQueueUsingStack<T> {

    Stack<T> stack;

    GenericQueueUsingStack(){
        this.stack = new Stack<>();
    }

    public static void main(String[] args) throws Exception {
        GenericQueueUsingStack<Integer> ge = new GenericQueueUsingStack<>();
        ge.add(1);
        ge.add(2);
        ge.add(3);
        System.out.println("removing " + ge.remove());
        System.out.println("removing " + ge.remove());
        System.out.println("removing " + ge.remove());

    }

    private T remove() throws Exception {
        T t = null;
        Stack<T> tempStack = new Stack<>();
        while(!this.stack.empty()){
            tempStack.push(this.stack.pop());
        }
        if(!tempStack.empty()) {
            t = tempStack.pop();
//            System.out.println("removing " + tempStack.peek());
        }else {
            System.out.println("queue is empty");
            throw new Exception("No such element");
        }
        while (!tempStack.empty()){
            this.stack.push(tempStack.pop());
        }
        return t;
    }

    private void add(T i) {
        System.out.println("pushing "  + i);
        stack.push(i);
        System.out.println(stack);
    }

}
