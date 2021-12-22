import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        System.out.println(evaluate("100 200 + 2 / 5 * 7 +"));
    }

    public static int evaluate(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (int) (c - '0');
                i++;
            }
            else if (c == ' ') {
                if (num != 0) {
                    st.push(num);
                    num = 0;
                    i++;
                } else {
                    i++;
                    num = 0;
                }
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                i++;
                int val1 = st.pop();
                int val2 = st.pop();
                switch (c)
                {
                    case '+': st.push(val2 + val1); break;
                    case '-': st.push(val2 - val1); break;
                    case '*': st.push(val2 * val1); break;
                    case '/': st.push(val2/val1); break;
                    case '^': st.push(val2^val1); break;
                }
            }
        }
        return st.pop();
    }
}
