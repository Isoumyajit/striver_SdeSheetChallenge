public class anagram {
    public static boolean areAnagram(String str1, String str2) {
        // Write your code here.
        int[] hash = new int[26];
        for (char x : str1.toCharArray())
            hash[x - 'a']++;
        for (char x : str2.toCharArray())
            hash[x - 'a']--;
        for (int a : hash)
            if (a > 0)
                return false;
        return true;
    }
}