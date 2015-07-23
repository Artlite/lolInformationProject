package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.providers.abs.BaseProvider;

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
                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Aatrox.png")
                        .addName(getString(R.string.aatrox_name))
                        .addTitle(getString(R.string.aatrox_title))
                        .addDefaultSkin("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg")
                        .setFinished()
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Ahri.png")
                        .addName(getString(R.string.ahri_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.13.1/img/champion/Akali.png")
                        .addName(getString(R.string.akali_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Alistar.png")
                        .addName(getString(R.string.alistar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Amumu.png")
                        .addName(getString(R.string.amumu_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Anivia.png")
                        .addName(getString(R.string.anivia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Annie.png")
                        .addName(getString(R.string.annie_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ashe.png")
                        .addName(getString(R.string.ashe_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Azir.png")
                        .addName(getString(R.string.azir_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Bard.png")
                        .addName(getString(R.string.bard_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Blitzcrank.png")
                        .addName(getString(R.string.blitzcrank_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Brand.png")
                        .addName(getString(R.string.brand_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Braum.png")
                        .addName(getString(R.string.braum_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Caitlyn.png")
                        .addName(getString(R.string.caitlyn_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Cassiopeia.png")
                        .addName(getString(R.string.cassiopeia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Chogath.png")
                        .addName(getString(R.string.chogath_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Corki.png")
                        .addName(getString(R.string.corki_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Darius.png")
                        .addName(getString(R.string.darius_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Diana.png")
                        .addName(getString(R.string.diana_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/DrMundo.png")
                        .addName(getString(R.string.drmundo_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Draven.png")
                        .addName(getString(R.string.draven_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ekko.png")
                        .addName(getString(R.string.ekko_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Elise.png")
                        .addName(getString(R.string.elise_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Evelynn.png")
                        .addName(getString(R.string.evelynn_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ezreal.png")
                        .addName(getString(R.string.ezreal_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/FiddleSticks.png")
                        .addName(getString(R.string.fiddlesticks_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Fiora.png")
                        .addName(getString(R.string.fiora_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Fizz.png")
                        .addName(getString(R.string.fizz_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Galio.png")
                        .addName(getString(R.string.galio_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gangplank.png")
                        .addName(getString(R.string.gangplank_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Garen.png")
                        .addName(getString(R.string.garen_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gnar.png")
                        .addName(getString(R.string.gnar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Gragas.png")
                        .addName(getString(R.string.gragas_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Graves.png")
                        .addName(getString(R.string.graves_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Hecarim.png")
                        .addName(getString(R.string.hecarim_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Heimerdinger.png")
                        .addName(getString(R.string.heimerdinger_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Irelia.png")
                        .addName(getString(R.string.irelia_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Janna.png")
                        .addName(getString(R.string.janna_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/JarvanIV.png")
                        .addName(getString(R.string.jarvaniv_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jax.png")
                        .addName(getString(R.string.jax_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jayce.png")
                        .addName(getString(R.string.jayce_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Jinx.png")
                        .addName(getString(R.string.jinx_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kalista.png")
                        .addName(getString(R.string.kalista_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Karma.png")
                        .addName(getString(R.string.karma_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Karthus.png")
                        .addName(getString(R.string.karthus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kassadin.png")
                        .addName(getString(R.string.kassadin_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Katarina.png")
                        .addName(getString(R.string.katarina_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kayle.png")
                        .addName(getString(R.string.kayle_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Kennen.png")
                        .addName(getString(R.string.kennen_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Khazix.png")
                        .addName(getString(R.string.khazix_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/KogMaw.png")
                        .addName(getString(R.string.kogmaw_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Leblanc.png")
                        .addName(getString(R.string.leblanc_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/LeeSin.png")
                        .addName(getString(R.string.leesin_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Leona.png")
                        .addName(getString(R.string.leona_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lissandra.png")
                        .addName(getString(R.string.lissandra_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lucian.png")
                        .addName(getString(R.string.lucian_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lulu.png")
                        .addName(getString(R.string.lulu_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Lux.png")
                        .addName(getString(R.string.lux_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Malphite.png")
                        .addName(getString(R.string.malphite_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Malzahar.png")
                        .addName(getString(R.string.malzahar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Maokai.png")
                        .addName(getString(R.string.maokai_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/MasterYi.png")
                        .addName(getString(R.string.masteryi_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/MissFortune.png")
                        .addName(getString(R.string.missfortune_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Mordekaiser.png")
                        .addName(getString(R.string.mordekaiser_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Morgana.png")
                        .addName(getString(R.string.morgana_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nami.png")
                        .addName(getString(R.string.nami_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nasus.png")
                        .addName(getString(R.string.nasus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nautilus.png")
                        .addName(getString(R.string.nautilus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nidalee.png")
                        .addName(getString(R.string.nidalee_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nocturne.png")
                        .addName(getString(R.string.nocturne_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Nunu.png")
                        .addName(getString(R.string.nunu_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Olaf.png")
                        .addName(getString(R.string.olaf_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Orianna.png")
                        .addName(getString(R.string.orianna_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Pantheon.png")
                        .addName(getString(R.string.pantheon_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Poppy.png")
                        .addName(getString(R.string.poppy_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Quinn.png")
                        .addName(getString(R.string.quinn_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Rammus.png")
                        .addName(getString(R.string.rammus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/RekSai.png")
                        .addName(getString(R.string.reksai_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Renekton.png")
                        .addName(getString(R.string.renekton_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Rengar.png")
                        .addName(getString(R.string.rengar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Riven.png")
                        .addName(getString(R.string.riven_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Rumble.png")
                        .addName(getString(R.string.rumble_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ryze.png")
                        .addName(getString(R.string.ryze_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Sejuani.png")
                        .addName(getString(R.string.sejuani_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Shaco.png")
                        .addName(getString(R.string.shaco_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Shen.png")
                        .addName(getString(R.string.shen_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Shyvana.png")
                        .addName(getString(R.string.shyvana_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Singed.png")
                        .addName(getString(R.string.singed_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Sion.png")
                        .addName(getString(R.string.sion_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Sivir.png")
                        .addName(getString(R.string.sivir_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Skarner.png")
                        .addName(getString(R.string.skarner_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Sona.png")
                        .addName(getString(R.string.sona_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Soraka.png")
                        .addName(getString(R.string.soraka_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Swain.png")
                        .addName(getString(R.string.swain_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Syndra.png")
                        .addName(getString(R.string.syndra_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/TahmKench.png")
                        .addName(getString(R.string.tahmkench_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Talon.png")
                        .addName(getString(R.string.talon_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Taric.png")
                        .addName(getString(R.string.taric_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Teemo.png")
                        .addName(getString(R.string.teemo_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Thresh.png")
                        .addName(getString(R.string.thresh_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Tristana.png")
                        .addName(getString(R.string.tristana_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Trundle.png")
                        .addName(getString(R.string.trundle_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Tryndamere.png")
                        .addName(getString(R.string.tryndamere_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Twitch.png")
                        .addName(getString(R.string.twitch_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Udyr.png")
                        .addName(getString(R.string.udyr_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Urgot.png")
                        .addName(getString(R.string.urgot_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Varus.png")
                        .addName(getString(R.string.varus_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Vayne.png")
                        .addName(getString(R.string.vayne_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Veigar.png")
                        .addName(getString(R.string.veigar_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Velkoz.png")
                        .addName(getString(R.string.velkoz_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Vi.png")
                        .addName(getString(R.string.vi_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Viktor.png")
                        .addName(getString(R.string.viktor_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Vladimir.png")
                        .addName(getString(R.string.vladimir_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Volibear.png")
                        .addName(getString(R.string.volibear_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Warwick.png")
                        .addName(getString(R.string.warwick_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/MonkeyKing.png")
                        .addName(getString(R.string.wukong_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Xerath.png")
                        .addName(getString(R.string.xerath_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/XinZhao.png")
                        .addName(getString(R.string.xinzhao_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Yasuo.png")
                        .addName(getString(R.string.yasuo_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Yorick.png")
                        .addName(getString(R.string.yorick_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Zac.png")
                        .addName(getString(R.string.zac_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Zed.png")
                        .addName(getString(R.string.zed_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Ziggs.png")
                        .addName(getString(R.string.ziggs_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Zilean.png")
                        .addName(getString(R.string.zilean_name))
                        .build(),

                new Champion.Builder().addIcon("http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/Zyra.png")
                        .addName(getString(R.string.zyra_name))
                        .build(),
        }));
    }

    public String getString(int nameID) {
        return CurrentApplication.getInstance().getString(nameID);
    }
}
