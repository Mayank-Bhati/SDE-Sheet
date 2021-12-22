import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "a+(b*c(d/e^f)*g)*h)";
        System.out.println(postfix(infix));
    }

    public static int precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    public static String postfix(String s) {
        String out = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
                out += c;
            else if (c == '(' || ((c == '+' || c == '-' || c == '/' || c == '*' || c == '^') && st.empty()))
                st.push(c);
            else if (c == ')') {
                while (!st.empty() && st.peek() != '(') {
                    out += st.pop();
                }
                if (!st.empty() && st.peek() == '(')
                    st.pop();
            } else if ((c == '+' || c == '-' || c == '/' || c == '*' || c == '^') && precedence(c) > precedence(st.peek()))
                st.push(c);
            else if ((c == '+' || c == '-' || c == '/' || c == '*' || c == '^') && precedence(c) <= precedence(st.peek())) {
                while (!st.empty()) {
                    if (precedence(c) <= st.peek() && st.peek() != '(')
                        out += st.pop();
                    else
                        break;
                }
                st.push(c);
            }
        }
        while (!st.empty()) {
            if (st.peek() != '(')
                out += st.pop();
            else
                st.pop();
        }
        return out;
    }
}
