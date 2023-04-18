import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        String[] words = new String[]{"mama", "papa", "їж їжак желе"};

        Set<Character> uniqueChars = DoHometask(words);

        System.out.println(uniqueChars);
    }


    public static Set<Character> DoHometask(String[] words)
    {
        List<String> wordsWithPairCharacters = new ArrayList<>();
        Set<Character> uniqueChars = new HashSet<>();

        for (String line : words)
        {
            Map<Character, Integer> charactersInLine = new HashMap<>();

            char[] characters = line.toCharArray();

            for (int i = 0; i < characters.length; i++)
            {
                char charKey = characters[i];

                int foundedCharCount = charactersInLine.getOrDefault(charKey, 0);

                foundedCharCount++;

                charactersInLine.put(charKey, foundedCharCount);
            }

            if (IsCharactersCountPair(charactersInLine))
            {
                wordsWithPairCharacters.add(line);
                uniqueChars.addAll(charactersInLine.keySet());
            }

            if (wordsWithPairCharacters.size() >= 2)
            {
                break;
            }
        }

        return uniqueChars;
    }

    public static Boolean IsCharactersCountPair(Map<Character, Integer> charactersInLine)
    {
        boolean isCountPair = true;

        for (Character key : charactersInLine.keySet())
        {
            int charCount = charactersInLine.get(key);
            if (charCount % 2 != 0)
            {
                isCountPair = false;
                break;
            }
        }

        return isCountPair;
    }


}