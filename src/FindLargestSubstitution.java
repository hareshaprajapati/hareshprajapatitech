public class FindLargestSubstitution {

    public static void main(String[] args) {
        String str = "abcdbcbcbcbbcabcbccccccccccccccccccccccccccccc";
        System.out.println(findLongestSubstitution(str));
    }

    private static String findLongestSubstitution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        int length = str.length();
        String currentMax = "";
        for(int i =0; i < length; i++){
            if(i+1 < length && i+2 < length){
                if(ch[i] == ch[i+1] || ch[i] == ch[i+2] || sb.toString().contains(Character.toString(ch[i]))){
                    sb.append(ch[i]);
                }else{
                    currentMax = sb.toString();
                    sb.delete(0,sb.length());
                }
            }else if(i+1 < length){
                if(ch[i] == ch[i+1] || sb.toString().contains(Character.toString(ch[i]))){
                    sb.append(ch[i]);
                }
            }else{
                if(sb.toString().contains(Character.toString(ch[i]))){
                    sb.append(ch[i]);
                }
            }
        }
        if(currentMax.length() > sb.toString().length()){
            return currentMax;
        }else{
            return sb.toString();
        }
    }
}
