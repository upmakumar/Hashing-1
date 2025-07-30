class Solution {
    public boolean isIsomorphic(String s, String t) {
        // create hashmap for s
        // if s contains char & if value is different this time then return false else continue
        // keep storing the value in HashSet , if character is new & value exist in HashSet then false

        HashMap<Character,Character> map= new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        int i = 0;
        while( i < s.length() ){
            if( !map.containsKey( s.charAt(i) ) ){
                map.put( s.charAt(i) , t.charAt(i) );
                if( set.contains(t.charAt(i)) ){
                    return false;
                }
                else{
                    set.add(  t.charAt(i) );
                }

            }
            else{
                if( map.get( s.charAt(i) ) != t.charAt(i) ){
                    return false;
                }
            }
            i++;
        }

        return true;
    }
}