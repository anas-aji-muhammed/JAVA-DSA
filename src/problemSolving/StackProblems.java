package problemSolving;

import java.util.Stack;

public class StackProblems {
    public static String removeOuterParentheses(String s) {
        Stack<Character> openParentheses = new Stack<>();
        Stack<Character> closeParentheses = new Stack<>();
        StringBuilder output = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);

            if(c == '('){
                openParentheses.push(c);
            } else if (c == ')') {
                closeParentheses.push(c);
            }

            if(openParentheses.size()==closeParentheses.size()){
                for(int j=0; j<openParentheses.size(); j++){
                    if(openParentheses.size()%2==0){
                        output.append(openParentheses.pop());
                        output.append(closeParentheses.pop());
                    }
                    else{
                        output.append(openParentheses.pop());
                        output.append(openParentheses.pop());
                    }

                }

                openParentheses.clear();
                closeParentheses.clear();
            }
        }

        return output.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())()(()))"));
//        System.out.println(removeOuterParentheses("(()())"));
    }

}
