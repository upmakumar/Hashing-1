class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // iterate strs , create a string key for hashMap which has a to z with count of character in it
        // for that key store strs value in List
        // in the end return all values


        HashMap<String,List<String>> map = new HashMap();

        for( int i = 0; i< strs.length; i++ ){
            int[] arr = new int[26]; // for every word reset array
            for( int j = 0; j < strs[i].length(); j++ ){
                char temp = strs[i].charAt(j);
                arr[temp - 'a'] += 1; // for each char we are updating appropriate index of array with its occurrence
            }
            StringBuilder st = new StringBuilder();

            for( int k = 0; k<arr.length; k++ ){ // iterating that array to get our key
                char letter = (char) ('a' + k);
                st.append(letter); // appending letter
                st.append(arr[k]); // appending letter with its occurence
            }
            if( !map.containsKey(st.toString())){
                map.put( st.toString() , new ArrayList<>() ); // if map doesn't have key , add & initialize list
                map.get(st.toString()).add(strs[i]);
            }
            else{
                map.get(st.toString()).add(strs[i]); // else add strs word to that list
            }


        }

        ArrayList<List<String>> res = new ArrayList<>();

        for( List<String> s : map.values()){  //List<String> list : map.values()
            res.add(s);
        }

        return res;
    }
}