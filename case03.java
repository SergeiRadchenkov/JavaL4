import java.util.Stack;

public class case03 {
    public static void main(String[] args) {
        var exp = "1 2 3 * 4 * + 10 5 * / 20 -".split(" "); //  (2*3*4+1)/(10*5)-20
        //var exp = "20 30 - 10 *".split(" "); // (20-30)*10
        //var exp = "1 2 + 3 *".split(" "); // (1 + 2) * 3
        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        int res = 0;
        System.out.println(exp);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        System.out.println(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        System.out.println(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        System.out.println(res);
                        break;
                    case "/":
                        res = st.pop() / st.pop();
                        st.push(res);
                        System.out.println(res);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
