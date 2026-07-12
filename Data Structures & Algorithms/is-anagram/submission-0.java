class Solution {
    public boolean isAnagram(String s, String t) {
        int count[] = new int[26];

        for(int ch:s.toCharArray()){
            count[ch-'a']++;
        }    
        for(int ch:t.toCharArray()){
            count[ch-'a']--;
        }
        
        for(int i = 0;i<count.length;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    
}}
