class Solution {
    public boolean wordPattern(String pattern, String s) {
      /* 1. iterate s , create word till space , create a variable of index ,till space 1 index
         2. put that word in hash map & value will be patter.charAt(index)
         3. if word exist check if value is same as patter.charAt(index) if not then false
         4. keep till end of s
         5. at last return true
        Time = o(n) , n is character in s , space no. of words in s o(n) */

        HashMap<String,Character> sMap = new HashMap<>();
        HashMap<Character,String> pMap = new HashMap<>();

        StringBuilder st = new StringBuilder();
        int index = 0;

        int i = 0;
        char temp = pattern.charAt(index);
        while( i <= s.length() ){

            if( i < s.length() && s.charAt(i) != ' ' && i !=  s.length()){
                st.append( s.charAt(i) );
                i++;
            }
            else{
                if( index < pattern.length() ){
                    temp = pattern.charAt(index);
                }
                else
                {
                    return false;
                }
                if( !pMap.containsKey(temp) ){
                    pMap.put( temp , st.toString() );
                }

                if( !sMap.containsKey(st.toString()) ){
                    sMap.put(st.toString() ,temp );

                    if( pMap.containsKey(temp) ){
                        if( !pMap.get( temp ).equals(st.toString()) ){
                            return false;
                        }
                    }
                }
                else if( sMap.containsKey( st.toString() ) ){
                    if( sMap.get(st.toString()) != temp ){
                        return false;
                    }
                }
                i++;
                index++;
                st = new StringBuilder();

            }

        }
        if( index != pattern.length() ){
            return false;
        }

        return true;



    }
}