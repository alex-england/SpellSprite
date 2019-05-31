package com.mgengland.spellsprite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;


// todo yyuuuccck! Needs to be async, handle errors, write in kotlin? investigate at google API rather than simple web request
public class GoogleSpellChecker
{
    // check if the word is spelt correctly, return of null either means an error or no suggestion, otherwise will return the suggestion
    // todo implement an API around this class, define better return types (no suggestion, correctly spelt, error, suggestion)
    public String Check(String word)
    {
        try
        {
            URL request = new URL(String.format("https://www.google.com/search?q=%s", word));
            URLConnection connection = request.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String data = reader.lines().collect(Collectors.joining());

            int searchIndex = data.indexOf("Showing results for");

            // Google didn't have any suggestions, return null
            if (searchIndex == -1)
            {
                searchIndex = data.indexOf("Did you mean:");
                if (searchIndex == -1)
                    return null;
            }

            String refinedData = data.substring(searchIndex, searchIndex + 1000);
            int startTagIndex = refinedData.indexOf("<i>");
            int endTagIndex = refinedData.indexOf("</i>");

            // someGarbage<i>result</i>moreGarbage
            // start = 11
            // end = 20
            // resultStart = start + len(<i>) = 11 + 3 = 14
            // resultLength = end - start - len(<i>) = 20 - 11 - 3 = 6

            int resultStart = startTagIndex + 3;
            int resultLength = endTagIndex - startTagIndex - 3;
            String result = refinedData.substring(resultStart, resultStart + resultLength); // todo this was pasted from my C# mock of this where substring works differently (second arg is length rather than end index), there is probs a better way to do this ... too sleepy right now ...

            reader.close();

            return result;
        }
        catch (Exception e)
        {
            // todo yeah ... see above todo notes
            System.out.println("hmmm");
        }
        return null;
    }
}
