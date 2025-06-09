public class RemoveConsecutiveCharacter{
    public static void main(String[] args) {
        String str = "aabb";
        String result = removeConsecutiveCharacter(str);
        System.out.println(result);
    }

    public static String removeConsecutiveCharacter(String s){
        char characters[] = s.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        
        int first = 0;
        result.add(characters[0]);
        for(int i=1; i<characters.length; i++){
            if(characters[first] != characters[i]){
                first++;
                characters[first] = characters[i];
                result.add(characters[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }
        String unique = sb.toString();
        
        return unique;
    }
}
