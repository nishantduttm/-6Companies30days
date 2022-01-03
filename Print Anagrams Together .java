class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        Map<String, List<String>> m = new HashMap<>();
        for(int i = 0; i < string_list.length; i++){
            String s = sort(string_list[i]);
            List<String> l = m.getOrDefault(s, new ArrayList<>());
            l.add(string_list[i]);
            m.put(s, l);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : m.keySet()){
            res.add(m.get(key));
        }
        return res;
    }
    
    
    String sort(String s){
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            while(count[i] > 0){
                sb.append('a' + i);
                count[i]--;
            }
        }
        return sb.toString();
    }
}