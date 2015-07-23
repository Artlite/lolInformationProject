package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.CurrentApplication;
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
                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Aatrox.png").
                        addName(getName(R.string.aatrox_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Ahri.png").
                        addName(getName(R.string.ahri_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Akali.png")
                        .addName(getName(R.string.akali_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Alistar.png")
                        .addName(getName(R.string.alistar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Amumu.png")
                        .addName(getName(R.string.amumu_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Anivia.png")
                        .addName(getName(R.string.anivia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Annie.png")
                        .addName(getName(R.string.annie_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ashe.png")
                        .addName(getName(R.string.ashe_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Azir.png")
                        .addName(getName(R.string.azir_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Bard.png")
                        .addName(getName(R.string.bard_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Blitzcrank.png")
                        .addName(getName(R.string.blitzcrank_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Brand.png")
                        .addName(getName(R.string.brand_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Braum.png")
                        .addName(getName(R.string.braum_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Caitlyn.png")
                        .addName(getName(R.string.caitlyn_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Cassiopeia.png")
                        .addName(getName(R.string.cassiopeia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Chogath.png")
                        .addName(getName(R.string.chogath_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Corki.png")
                        .addName(getName(R.string.corki_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Darius.png")
                        .addName(getName(R.string.darius_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Diana.png")
                        .addName(getName(R.string.diana_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/DrMundo.png")
                        .addName(getName(R.string.drmundo_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Draven.png")
                        .addName(getName(R.string.draven_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ekko.png")
                        .addName(getName(R.string.ekko_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Elise.png")
                        .addName(getName(R.string.elise_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Evelynn.png")
                        .addName(getName(R.string.evelynn_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ezreal.png")
                        .addName(getName(R.string.ezreal_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/FiddleSticks.png")
                        .addName(getName(R.string.fiddlesticks_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Fiora.png")
                        .addName(getName(R.string.fiora_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Fizz.png")
                        .addName(getName(R.string.fizz_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Galio.png")
                        .addName(getName(R.string.galio_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gangplank.png")
                        .addName(getName(R.string.gangplank_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Garen.png")
                        .addName(getName(R.string.garen_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gnar.png")
                        .addName(getName(R.string.gnar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gragas.png")
                        .addName(getName(R.string.gragas_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Graves.png")
                        .addName(getName(R.string.graves_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Hecarim.png")
                        .addName(getName(R.string.hecarim_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Heimerdinger.png")
                        .addName(getName(R.string.heimerdinger_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Irelia.png")
                        .addName(getName(R.string.irelia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Janna.png")
                        .addName(getName(R.string.janna_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/JarvanIV.png")
                        .addName(getName(R.string.jarvaniv_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jax.png")
                        .addName(getName(R.string.jax_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jayce.png")
                        .addName(getName(R.string.jayce_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jinx.png")
                        .addName(getName(R.string.jinx_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kalista.png")
                        .addName(getName(R.string.kalista_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Karma.png")
                        .addName(getName(R.string.karma_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Karthus.png")
                        .addName(getName(R.string.karthus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kassadin.png")
                        .addName(getName(R.string.kassadin_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Katarina.png")
                        .addName(getName(R.string.katarina_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kayle.png")
                        .addName(getName(R.string.kayle_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kennen.png")
                        .addName(getName(R.string.kennen_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Khazix.png")
                        .addName(getName(R.string.khazix_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/KogMaw.png")
                        .addName(getName(R.string.kogmaw_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Leblanc.png")
                        .addName(getName(R.string.leblanc_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/LeeSin.png")
                        .addName(getName(R.string.leesin_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Leona.png")
                        .addName(getName(R.string.leona_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lissandra.png")
                        .addName(getName(R.string.lissandra_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lucian.png")
                        .addName(getName(R.string.lucian_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lulu.png")
                        .addName(getName(R.string.lulu_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lux.png")
                        .addName(getName(R.string.lux_name))
                        .build(),
        }));
    }

    public String getName(int nameID) {
        return CurrentApplication.getInstance().getString(nameID);
    }
}
