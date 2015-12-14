package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.constants.ChampionType;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
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
                new Champion.Builder().addIcon(R.drawable.ic_aatrox)
                        .addName(getString(R.string.aatrox_name))
                        .addTitle(getString(R.string.aatrox_title))
                        .addDefaultSkin("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg")
                        .addChampionType(ChampionType.FIGHTER)
                        .addHistory(getString(R.string.text_history_aatrox))
                        .setFinished()
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ahri)
                        .addName(getString(R.string.ahri_name))
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(getString(R.string.text_history_ahri))
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_akali)
                        .addName(getString(R.string.akali_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_alistar)
                        .addName(getString(R.string.alistar_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_amumu)
                        .addName(getString(R.string.amumu_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_anivia)
                        .addName(getString(R.string.anivia_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ennie)
                        .addName(getString(R.string.annie_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ahse)
                        .addName(getString(R.string.ashe_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_azir)
                        .addName(getString(R.string.azir_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_bard)
                        .addName(getString(R.string.bard_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_blitzcrank)
                        .addName(getString(R.string.blitzcrank_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_brand)
                        .addName(getString(R.string.brand_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_braum)
                        .addName(getString(R.string.braum_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_katlyn)
                        .addName(getString(R.string.caitlyn_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_casiopeia)
                        .addName(getString(R.string.cassiopeia_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_chogath)
                        .addName(getString(R.string.chogath_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_korki)
                        .addName(getString(R.string.corki_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_darius)
                        .addName(getString(R.string.darius_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_diana)
                        .addName(getString(R.string.diana_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_drmundo)
                        .addName(getString(R.string.drmundo_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_dreiven)
                        .addName(getString(R.string.draven_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ekko)
                        .addName(getString(R.string.ekko_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_elizza)
                        .addName(getString(R.string.elise_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_eveline)
                        .addName(getString(R.string.evelynn_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ezraelle)
                        .addName(getString(R.string.ezreal_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fiddlestics)
                        .addName(getString(R.string.fiddlesticks_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fiora)
                        .addName(getString(R.string.fiora_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fizz)
                        .addName(getString(R.string.fizz_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_galeo)
                        .addName(getString(R.string.galio_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gangplank)
                        .addName(getString(R.string.gangplank_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_garen)
                        .addName(getString(R.string.garen_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gnar)
                        .addName(getString(R.string.gnar_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gragas)
                        .addName(getString(R.string.gragas_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_greivz)
                        .addName(getString(R.string.graves_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_hecarim)
                        .addName(getString(R.string.hecarim_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_heimerdinger)
                        .addName(getString(R.string.heimerdinger_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_irelia)
                        .addName(getString(R.string.irelia_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_janna)
                        .addName(getString(R.string.janna_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jarvan4)
                        .addName(getString(R.string.jarvaniv_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jax)
                        .addName(getString(R.string.jax_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jeis)
                        .addName(getString(R.string.jayce_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_junx)
                        .addName(getString(R.string.jinx_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_calista)
                        .addName(getString(R.string.kalista_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_karma)
                        .addName(getString(R.string.karma_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_cartus)
                        .addName(getString(R.string.karthus_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kassadin)
                        .addName(getString(R.string.kassadin_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_katarina)
                        .addName(getString(R.string.katarina_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_keil)
                        .addName(getString(R.string.kayle_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kennen)
                        .addName(getString(R.string.kennen_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_khazics)
                        .addName(getString(R.string.khazix_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kogmaw)
                        .addName(getString(R.string.kogmaw_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leblan)
                        .addName(getString(R.string.leblanc_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leesin)
                        .addName(getString(R.string.leesin_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leona)
                        .addName(getString(R.string.leona_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lisandra)
                        .addName(getString(R.string.lissandra_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lician)
                        .addName(getString(R.string.lucian_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lulu)
                        .addName(getString(R.string.lulu_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lux)
                        .addName(getString(R.string.lux_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_malphite)
                        .addName(getString(R.string.malphite_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_malzahar)
                        .addName(getString(R.string.malzahar_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_maokai)
                        .addName(getString(R.string.maokai_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_master_yi)
                        .addName(getString(R.string.masteryi_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_miss_fortuna)
                        .addName(getString(R.string.missfortune_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_mordecaiser)
                        .addName(getString(R.string.mordekaiser_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_morgana)
                        .addName(getString(R.string.morgana_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nami)
                        .addName(getString(R.string.nami_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nasus)
                        .addName(getString(R.string.nasus_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nautilus)
                        .addName(getString(R.string.nautilus_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nedalee)
                        .addName(getString(R.string.nidalee_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nocturn)
                        .addName(getString(R.string.nocturne_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nunu)
                        .addName(getString(R.string.nunu_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_olaph)
                        .addName(getString(R.string.olaf_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_oriana)
                        .addName(getString(R.string.orianna_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_panteon)
                        .addName(getString(R.string.pantheon_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_poppy)
                        .addName(getString(R.string.poppy_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_queen)
                        .addName(getString(R.string.quinn_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rammus)
                        .addName(getString(R.string.rammus_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_recsai)
                        .addName(getString(R.string.reksai_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_renecton)
                        .addName(getString(R.string.renekton_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rengar)
                        .addName(getString(R.string.rengar_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_riven)
                        .addName(getString(R.string.riven_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rumble)
                        .addName(getString(R.string.rumble_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_raiz)
                        .addName(getString(R.string.ryze_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_senjuani)
                        .addName(getString(R.string.sejuani_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shaco)
                        .addName(getString(R.string.shaco_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shen)
                        .addName(getString(R.string.shen_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shivanna)
                        .addName(getString(R.string.shyvana_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sinjed)
                        .addName(getString(R.string.singed_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sion)
                        .addName(getString(R.string.sion_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sivir)
                        .addName(getString(R.string.sivir_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_scarner)
                        .addName(getString(R.string.skarner_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sonna)
                        .addName(getString(R.string.sona_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_soraca)
                        .addName(getString(R.string.soraka_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_swein)
                        .addName(getString(R.string.swain_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_syndra)
                        .addName(getString(R.string.syndra_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_thamn_kench)
                        .addName(getString(R.string.tahmkench_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_thalon)
                        .addName(getString(R.string.talon_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tharic)
                        .addName(getString(R.string.taric_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_teemo)
                        .addName(getString(R.string.teemo_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tresh)
                        .addName(getString(R.string.thresh_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tristana)
                        .addName(getString(R.string.tristana_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_trundle)
                        .addName(getString(R.string.trundle_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_trindamere)
                        .addName(getString(R.string.tryndamere_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_twitch)
                        .addName(getString(R.string.twitch_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_udyr)
                        .addName(getString(R.string.udyr_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_urgot)
                        .addName(getString(R.string.urgot_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_varus)
                        .addName(getString(R.string.varus_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vein)
                        .addName(getString(R.string.vayne_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_veigar)
                        .addName(getString(R.string.veigar_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_velkoz)
                        .addName(getString(R.string.velkoz_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vi)
                        .addName(getString(R.string.vi_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_viktor)
                        .addName(getString(R.string.viktor_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vladimir)
                        .addName(getString(R.string.vladimir_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_voleybear)
                        .addName(getString(R.string.volibear_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_varvik)
                        .addName(getString(R.string.warwick_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vukong)
                        .addName(getString(R.string.wukong_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_xerath)
                        .addName(getString(R.string.xerath_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_xinjao)
                        .addName(getString(R.string.xinzhao_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_yasuo)
                        .addName(getString(R.string.yasuo_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_youric)
                        .addName(getString(R.string.yorick_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zak)
                        .addName(getString(R.string.zac_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zed)
                        .addName(getString(R.string.zed_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zigs)
                        .addName(getString(R.string.ziggs_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zilean)
                        .addName(getString(R.string.zilean_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zyra)
                        .addName(getString(R.string.zyra_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),
        }));
    }

    public String getString(int nameID) {
        return CurrentApplication.getInstance().getString(nameID);
    }
}
