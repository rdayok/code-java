package play;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Braces {


    public boolean isValidArrangement(String s) {
        final int ZERO = 0;
        if(s.length() % 2 != 0 || s.isEmpty()) return false;
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') return false;
        ArrayList<String> characters =  new ArrayList<>(Arrays.asList(s.split("")));

        boolean listOfCharactersIsNotEmpty = !characters.isEmpty();
        while (listOfCharactersIsNotEmpty){

            boolean weDidNotGet_aCloseBrace = true;
            if(Objects.equals(characters.get(ZERO), "(")){
                for (int index = 0; index < characters.size(); index++){
                    if(Objects.equals(characters.get(index), ")") && index % 2 == 1){
                        characters.remove(index);
                        characters.remove(ZERO);
                        weDidNotGet_aCloseBrace = false;
                        break;
                    }
                }
            } else if(Objects.equals(characters.get(ZERO), "{")){
                for (int index = 0; index < characters.size(); index++){
                    if(Objects.equals(characters.get(index), "}") && index % 2 == 1){
                        characters.remove(index);
                        characters.remove(ZERO);
                        weDidNotGet_aCloseBrace = false;
                        break;
                    }
                }
            } else if(Objects.equals(characters.get(ZERO), "[")){
                System.out.println("yo am in");
                for (int index = 0; index < characters.size(); index++){
                    if(Objects.equals(characters.get(index), "]") && index % 2 == 1){
                        characters.remove(index);
                        characters.remove(ZERO);
                        for(String ss : characters) System.out.println(ss);
                        weDidNotGet_aCloseBrace = false;
                        break;
                    }
                }
            }
            if(weDidNotGet_aCloseBrace) return false;
            if(characters.isEmpty()) return true;
        }
        return true;
    }
}
