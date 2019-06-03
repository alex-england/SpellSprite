package com.mgengland.spellsprite;

import com.mgengland.spellsprite.Logic.GoogleSpellChecker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * todo do a setup and tear down for a single google spell checker instance
 */
public class GoogleSpellCheckerTests
{
    /**
     * todo extract words from a test source to check multiple
     */
    @Test
    public void correctsMisspeltWord()
    {
        final String word = "exhageration";
        GoogleSpellChecker googleSpellChecker = new GoogleSpellChecker();
        String result = googleSpellChecker.Check(word);
        assertNotEquals(word, result);
        assertEquals("exaggeration", result);
    }
}
