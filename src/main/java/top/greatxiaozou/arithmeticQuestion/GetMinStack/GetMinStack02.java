package top.greatxiaozou.arithmeticQuestion.GetMinStack;
import java.util.Stack;

public class GetMinStack02 {

        //数据栈
        private Stack<Integer> dataStack = new Stack();
        //最小栈
        private Stack<Integer> minStack = new Stack();


        //只压入最小的
        public void push(int newNum){
            dataStack.push(newNum);
            if (minStack.isEmpty()) minStack.push(newNum);
            else if (newNum<=minStack.peek()){
                minStack.push(newNum);
            }else {         //与解法1不同的是，外部每次压入一个元素时，最小栈都会压入一个元素
                minStack.push(minStack.peek());
            }
        }

        //由于在压入时进行了重复压入最小栈，此时只需要跟正常一样pop即可保证最小了
        public int pop() throws Exception {
            if (minStack.isEmpty()) throw new Exception("栈为空");
            int val = dataStack.pop();
            minStack.pop();
            return val;
        }

        public int getMin() throws Exception {
            if (minStack.isEmpty()){
                throw new Exception("栈为空！");
            }
            return minStack.peek();
        }
}
