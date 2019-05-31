package com.mgengland.spellsprite;

import android.service.textservice.SpellCheckerService;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;

import static android.view.textservice.SuggestionsInfo.RESULT_ATTR_IN_THE_DICTIONARY;
import static android.view.textservice.SuggestionsInfo.RESULT_ATTR_LOOKS_LIKE_TYPO;

public class SpellCheckerSession extends SpellCheckerService.Session
{
    private GoogleSpellChecker _checker; // todo make collection of interfaces

    @Override
    public void onCreate()
    {
        this._checker = new GoogleSpellChecker();
    }

    @Override
    public SuggestionsInfo onGetSuggestions(TextInfo textInfo, int suggestionsLimit) {

        String result = this._checker.Check(textInfo.getText()); // todo handle case sensitivity

        if (result == null) // todo null might mean an error, API will change
        {
            String[] suggestions = new String[0];
            SuggestionsInfo suggestionsInfo = new SuggestionsInfo(RESULT_ATTR_IN_THE_DICTIONARY, suggestions);
            return suggestionsInfo;
        }
        String[] suggestions = new String[1];
        suggestions[0] = result;
        SuggestionsInfo suggestionsInfo = new SuggestionsInfo(RESULT_ATTR_LOOKS_LIKE_TYPO, suggestions);
        return suggestionsInfo;
    }

    @Override
    public SentenceSuggestionsInfo[] onGetSentenceSuggestionsMultiple(TextInfo[] textInfos, int suggestionsLimit) {
        SentenceSuggestionsInfo[] sentenceSuggestionsInfos = new SentenceSuggestionsInfo[0];

        for (int i = 0; i < textInfos.length; i++)
        {
            TextInfo textInfo = textInfos[i];
            String text = textInfo.getText();
            String sequence =
        }


        return sentenceSuggestionsInfos;
    }
}
