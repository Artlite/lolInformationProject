package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.providers.abs.BaseProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionProvider implements BaseProvider<Champion> {
    @Override
    public List<Champion> get() {
        return new ArrayList<>(Arrays.asList(new Champion[]{
                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Aatrox.png").addName("Aatrox").build(),
                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Ahri.png").addName("Ahri").build(),
                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Akali.png").addName("Akali").build(),
        }));
    }
}
