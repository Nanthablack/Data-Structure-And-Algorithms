
// นายศิริวัจน์ ตรังคานุวัฒน์ 63050191
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeInfix {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void main(String[] args) {
        MyQueueLString queueS = new MyQueueLString();
        MyStackLString stack = new MyStackLString();
        ComputeRPN calRPN = new ComputeRPN();
        System.out.print(" Enter your equation : ");
        Scanner sc = new Scanner(System.in);
        String rpn = sc.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t)) {
                // queue.enqueue(Double.parseDouble(t));
                // queue.enqueue(Integer.parseInt(t));
                queueS.enqueue(t);
            } 
            else 
            {
                if (stack.isEmpty()) {
                    stack.push(t);
                }
                else if (t.equals("+") || t.equals("-")) {
                    if (!stack.top().equals("(")) {
                        queueS.enqueue(stack.pop());
                    }
                    stack.push(t);
                }
                else if(t.equals("*") || t.equals("/")){
                    if(stack.top().equals("*") || stack.top().equals("/")){
                        queueS.enqueue(stack.pop());
                    }
                    stack.push(t);
                }
                else if (t.equals("(")) {
                    stack.push(t);
                } else if (t.equals(")")) {
                    while (!stack.top().equals("(")) {
                        queueS.enqueue(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            queueS.enqueue(stack.pop());
        }
        System.out.println("Infix \t: "+rpn);
        // System.out.println("Postfix : "+queueS.toString());
        System.out.println("Postfix\t: "+queueS.toString1());
        // System.out.println(stack.toString());
        System.out.println("result \t: "+calRPN.computeRPN(queueS.toString1()));
        sc.close();
    }
}
