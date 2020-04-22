package stu.edu.InterviewQuestion;

/**
 * @author Admin
 * 替换字符串中的空格
 */
public class ReplaceSpace {

    public static String replaceSpace(String target) {
        if(target == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = target.length();
        for (int i = 0; i < length; i++) {
            if(String.valueOf(target.charAt(i)).equals(" ")) {
                sb.append("%20");
            }else {
                sb.append(target.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String target = "Hello World !";
        System.out.println(replaceSpace(target));
    }

}
