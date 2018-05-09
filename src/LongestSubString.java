import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
java2novice longest substring is [a2novice]
java_language_is_sweet longest substring is [uage_is]
java_java_java_java longest substring is [va_j, _jav]
abcabcbb longest substring is [bca, abc, cab]

 */
public class LongestSubString {
	private Set<String> subStrList = new HashSet<String>();
	private int finalSubStrSize = 0;

	public Set<String> getLongestSubstr(String input) {
		// reset instance variables
		subStrList.clear();
		finalSubStrSize = 0;
		// have a boolean flag on each character ascii value
//		boolean[] flag = new boolean[256];
		Map<Character,Character> map = new HashMap<>();
		int j = 0;
		char[] inputCharArr = input.toCharArray();
		for (int i = 0; i < inputCharArr.length; i++) {
			char c = inputCharArr[i];
			if (map.containsKey(c)  /*flag[c]*/) {
				extractSubString(inputCharArr, j, i);
				for (int k = j; k < i; k++) {
					if (inputCharArr[k] == c) {
						j = k + 1;
						break;
					}
					//flag[c] = false;
				}
			} else {
//				flag[c] = true;
				map.put(c,c);
			}
		}
		extractSubString(inputCharArr, j, inputCharArr.length);
		return subStrList;
	}

	private String extractSubString(char[] inputArr, int start, int end) {

		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(inputArr[i]);
		}
		String subStr = sb.toString();
		if (subStr.length() > finalSubStrSize) {
			finalSubStrSize = subStr.length();
			subStrList.clear();
			subStrList.add(subStr);
		} else if (subStr.length() == finalSubStrSize) {
			subStrList.add(subStr);
		}
		return sb.toString();
	}

	public static void main(String a[]) {
		LongestSubString mls = new LongestSubString();
		System.out.println("java2novice longest substring is " + mls.getLongestSubstr("java2novice"));
		 System.out.println("java_language_is_sweet longest substring is " + mls.getLongestSubstr("java_language_is_sweet"));
		 System.out.println("java_java_java_java longest substring is " + mls.getLongestSubstr("java_java_java_java"));
		 System.out.println("abcabcbb longest substring is " + mls.getLongestSubstr("abcabcbb"));
	}
}