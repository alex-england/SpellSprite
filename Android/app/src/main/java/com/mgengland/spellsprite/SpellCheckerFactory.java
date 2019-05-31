package com.mgengland.spellsprite;
import android.service.textservice.SpellCheckerService;

public class SpellCheckerFactory extends SpellCheckerService
{
    @Override
    public Session createSession()
    {
        return new SpellCheckerSession();
    }
}
