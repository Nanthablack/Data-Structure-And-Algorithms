// นายศิริวัจน์ ตรังคานุวัฒน์ 63050191
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum){
        if(strNum == null){
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    public double computeRPN(String rpn){
        MyStackL stack = new MyStackL();
        StringTokenizer st = new StringTokenizer(rpn);
        while(st.hasMoreTokens()){
            String t = st.nextToken();
            if(isNumeric(t)){
                stack.push(Double.parseDouble(t));
                // stack.push(Integer.parseInt(t));
            }
            else{
                double b = stack.pop();
                double a = stack.pop();
                if(t.equals("+")){
                    stack.push(a+b);
                }else if(t.equals("-")){
                    stack.push(a-b);
                }
                else if(t.equals("*")){
                    stack.push(a*b);
                }
                else if(t.equals("/")){
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }
}
