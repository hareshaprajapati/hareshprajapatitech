public class FindLargestSubstitution {

    public static void main(String[] args) {
//        String str = "wwqqqqqwaaaacaac";
        String str = "wwqqqsssssss";
        System.out.println(findLongestSubstitution(str));
    }

    private static String findLongestSubstitution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        int length = str.length();
        String currentMax = "";
        char ch1 = 0;
        char ch2 = 0;
        int ch2Count =0;
        if(str.length()<=2){
            return str;
        }
        for(int i =0; i < length; i++){
            if(ch1 == 0 || ( ch1 == ch[i] && ch2 == 0 )){
                sb.append(ch[i]);
                ch1 = ch[i];
                continue;
            }
            if(ch2==0){
                ch2 = ch[i];
                sb.append(ch[i]);
                ch2Count++;
                continue;
            }
            if(ch1 == ch[i]){
                sb.append(ch[i]);
                ch1 = ch2;
                ch2 = ch[i];
                ch2Count=1;
            }else if(ch2 == ch[i]){
                ch2Count++;
                sb.append(ch[i]);
            }else if(ch1 != ch[i] && ch2 != ch[i]){
                ch1 = ch2;
                ch2 = ch[i];
                String substring = sb.substring(sb.length() - ch2Count);
                ch2Count = 1;
                if(currentMax.length() < sb.length()){
                    currentMax = sb.toString();
                }
                sb.delete(0,sb.length());
                sb.append(substring);
                sb.append(ch2);
            }

        }
        if(currentMax.length() == sb.toString().length()){
            return currentMax + "  " + sb.toString();
        }
        if(currentMax.length() > sb.toString().length()){
            return currentMax;
        }else{
            return sb.toString();
        }
    }
}
