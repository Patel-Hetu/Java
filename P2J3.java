public class P2J3 
{
    public static void reverseAscendingSubarrays(int[] items) {
        int start = 0;
    
        while (start < items.length) {
            int end = start + 1;
            while (end < items.length && items[end] > items[end - 1]) {
                end++;
            }
    
            int left = start, right = end - 1;
            while (left < right) {
                int temp = items[left];
                items[left++] = items[right];
                items[right--] = temp;
            }
    
            start = end;
        }
    }
    
    
    public static String pancakeScramble(String text) {
        if (text.length() == 0) {
            return "";
        }
    
        char[] charArray = text.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            int temp = i;
            for (int j = 0; j < temp && temp > 0; j++) {
                char swap = charArray[temp];
                charArray[temp] = charArray[j];
                charArray[j] = swap;
                System.out.println(charArray);
                temp -= 1;
            }
        }
        text = new String(charArray);
        return text;
    }
    
    public static String reverseVowels(String text) {
        char[] chars = text.toCharArray();
        int i = 0, j = chars.length - 1;
    
        while (i < j) {
            while (i < j && !isVowel(chars[i])) i++;
            while (i < j && !isVowel(chars[j])) j--;
    
            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
    
                if (Character.isUpperCase(chars[i]) != Character.isUpperCase(chars[j])) {
                    chars[i] = Character.isUpperCase(chars[i]) ? Character.toLowerCase(chars[i]) : Character.toUpperCase(chars[i]);
                    chars[j] = Character.isUpperCase(chars[j]) ? Character.toLowerCase(chars[j]) : Character.toUpperCase(chars[j]);
                }
    
                i++;
                j--;
            }
        }
    
        return new String(chars);
    }
    
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}