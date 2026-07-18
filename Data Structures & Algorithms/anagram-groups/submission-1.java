class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();
        
        for(String str:strs){
            char[] sortedChars = str.toCharArray();
            Arrays.sort(sortedChars);
            String sortedStr = new String(sortedChars);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<String>());
            }

            map.get(sortedStr).add(str);
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }
}

// Input aisa hai : ["act","pots","tops","cat","stop","hat"]
// to hame map inke corresponding sorted words pe banana hai
/* mtlb aise 
    sortedWords | words from string str
        act     |       act,cat
        opts    |       pots,tops,stop
        aht     |       hat

    mtlb map lenge jisme string aur unke corresponding list of strings honge String, List<String>

    next hame abb sare index wale string ko character array me save krna hai taki hum usse sort kar pae
    mtlb index 0 -> "act" ....... corresponding array = [a|c|t]
    abb sort krnge -> Arrays.sort(corresponding array)  = [a|c|t]
    save it to some string variable = "act"
    abb map pe check krnge ki sorted string map me exist krta hai? nhi krta hai to exist krwaenge
    done
    map me sorted wale str ko key bna diya abb unsorted string ko value me daal do

    map -> sortedWords | words from string str
            act        |       act

    moving on to next index 1 -> "pots" corrs. array = [p|o|t|s]
    sorting -> [o|p|t|s]
    string = "opts"
    checking in map not there make a key for it and then saving the original string present in that index
    map -> sortedWords | words from string str
            act        |        act
            opts       |        pots

    next index 2-> "tops" corrs. array = [t|o|p|s]
    sorting -> [o|p|t|s]
    string = "opts"
    checking in map not there make a key for it and then saving the original string present in that index
    map ->  sortedWords | words from string str
                act     |       act
                opts    |       pots,tops
    
    next index 3 -> "cat" corrs.array = [c|a|t]
    sorting = [a|c|t]
    string = "act"
    checking in map not there make a key for it and then saving the original string present in that index
    map ->  sortedWords | words from string str
                act     |       act,cat
                opts    |       pots,tops

    next index 4 -> "stop" corrs. array = [s|t|o|p]
    sorting  = [o|p|t|s]
    string = "opts"
    checking in map not there make a key for it and then saving the original string present in that index
    map ->  sortedWords | words from string str
                act     |       act,cat
                opts    |       pots,tops,stop

    next index 5-> "hat" corrs.array = [h|a|t]
    sorting = [a|h|t]
    string  = "aht"
    checking in map not there make a key for it and then saving the original string present in that index
    map ->  sortedWords | words from string str
                act     |       act,cat
                opts    |       pots,tops,stop
                aht     |       hat
*/