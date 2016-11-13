package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.constants.ChampionType;
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
                        .addName(R.string.aatrox_name)
                        .addTitle(R.string.aatrox_title)
                        .addChampionType(ChampionType.FIGHTER)
                        .addHistory(R.string.text_history_aatrox)
                        .setFinished()
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ahri)
                        .addName(R.string.ahri_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_ahri)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_akali)
                        .addName(R.string.akali_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_akali)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_alistar)
                        .addName(R.string.alistar_name)
                        .addChampionType(ChampionType.SUPPORT)
                        .addHistory(R.string.text_history_alistar)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_amumu)
                        .addName(R.string.amumu_name)
                        .addChampionType(ChampionType.TANK)
                        .addHistory(R.string.text_history_amumu)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_anivia)
                        .addName(R.string.anivia_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_anivia)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ennie)
                        .addName(R.string.annie_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_annie)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ahse)
                        .addName(R.string.ashe_name)
                        .addChampionType(ChampionType.MARKSMAN)
                        .addHistory(R.string.text_history_ashe)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_aosol)
                        .addName(R.string.aurelion_sol_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_aurelion_sol)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_azir)
                        .addName(R.string.azir_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_azir)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_bard)
                        .addName(R.string.bard_name)
                        .addChampionType(ChampionType.SUPPORT)
                        .addHistory(R.string.text_history_bard)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_blitzcrank)
                        .addName(R.string.blitzcrank_name)
                        .addChampionType(ChampionType.SUPPORT)
                        .addHistory(R.string.text_history_blitzkrank)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_brand)
                        .addName(R.string.brand_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_brand)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_braum)
                        .addName(R.string.braum_name)
                        .addChampionType(ChampionType.SUPPORT)
                        .addHistory(R.string.text_history_braum)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_katlyn)
                        .addName(R.string.caitlyn_name)
                        .addChampionType(ChampionType.MARKSMAN)
                        .addHistory(R.string.text_history_katlyn)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_casiopeia)
                        .addName(R.string.cassiopeia_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_kasiopea)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_chogath)
                        .addName(R.string.chogath_name)
                        .addChampionType(ChampionType.TANK)
                        .addHistory(R.string.text_history_chogath)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_korki)
                        .addName(R.string.corki_name)
                        .addChampionType(ChampionType.MARKSMAN)
                        .addHistory(R.string.text_history_corki)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_darius)
                        .addName(R.string.darius_name)
                        .addChampionType(ChampionType.FIGHTER)
                        .addHistory(R.string.text_history_darius)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_diana)
                        .addName(R.string.diana_name)
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_diana)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_drmundo)
                        .addName(R.string.drmundo_name)
                        .addChampionType(ChampionType.TANK)
                        .addHistory(R.string.text_history_drmundo)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_dreiven)
                        .addName((R.string.draven_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .addHistory(R.string.text_history_drawen)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ekko)
                        .addName((R.string.ekko_name))
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_ekko)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_elizza)
                        .addName((R.string.elise_name))
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_elise)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_eveline)
                        .addName((R.string.evelynn_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .addHistory(R.string.text_history_evelyne)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_ezraelle)
                        .addName((R.string.ezreal_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .addHistory(R.string.text_history_ezrael)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fiddlestics)
                        .addName((R.string.fiddlesticks_name))
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_fiddlestics)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fiora)
                        .addName((R.string.fiora_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .addHistory(R.string.text_history_fiora)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_fizz)
                        .addName((R.string.fizz_name))
                        .addChampionType(ChampionType.MAGE)
                        .addHistory(R.string.text_history_fizz)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_galeo)
                        .addName((R.string.galio_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gangplank)
                        .addName((R.string.gangplank_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_garen)
                        .addName((R.string.garen_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gnar)
                        .addName((R.string.gnar_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_gragas)
                        .addName((R.string.gragas_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_greivz)
                        .addName((R.string.graves_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_hecarim)
                        .addName((R.string.hecarim_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_heimerdinger)
                        .addName((R.string.heimerdinger_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_irelia)
                        .addName((R.string.irelia_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_janna)
                        .addName((R.string.janna_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jarvan4)
                        .addName((R.string.jarvaniv_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jax)
                        .addName((R.string.jax_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_jeis)
                        .addName((R.string.jayce_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_junx)
                        .addName((R.string.jinx_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_calista)
                        .addName((R.string.kalista_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_karma)
                        .addName((R.string.karma_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_cartus)
                        .addName((R.string.karthus_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kassadin)
                        .addName((R.string.kassadin_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_katarina)
                        .addName((R.string.katarina_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_keil)
                        .addName((R.string.kayle_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kennen)
                        .addName((R.string.kennen_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_khazics)
                        .addName((R.string.khazix_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_kogmaw)
                        .addName((R.string.kogmaw_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leblan)
                        .addName((R.string.leblanc_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leesin)
                        .addName((R.string.leesin_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_leona)
                        .addName((R.string.leona_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lisandra)
                        .addName((R.string.lissandra_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lician)
                        .addName((R.string.lucian_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lulu)
                        .addName((R.string.lulu_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_lux)
                        .addName((R.string.lux_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_malphite)
                        .addName((R.string.malphite_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_malzahar)
                        .addName((R.string.malzahar_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_maokai)
                        .addName((R.string.maokai_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_master_yi)
                        .addName((R.string.masteryi_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_miss_fortuna)
                        .addName((R.string.missfortune_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_mordecaiser)
                        .addName((R.string.mordekaiser_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_morgana)
                        .addName((R.string.morgana_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nami)
                        .addName((R.string.nami_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nasus)
                        .addName((R.string.nasus_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nautilus)
                        .addName((R.string.nautilus_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nedalee)
                        .addName((R.string.nidalee_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nocturn)
                        .addName((R.string.nocturne_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_nunu)
                        .addName((R.string.nunu_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_olaph)
                        .addName((R.string.olaf_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_oriana)
                        .addName((R.string.orianna_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_panteon)
                        .addName((R.string.pantheon_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_poppy)
                        .addName((R.string.poppy_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_queen)
                        .addName((R.string.quinn_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rammus)
                        .addName((R.string.rammus_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_recsai)
                        .addName((R.string.reksai_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_renecton)
                        .addName((R.string.renekton_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rengar)
                        .addName((R.string.rengar_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_riven)
                        .addName((R.string.riven_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_rumble)
                        .addName((R.string.rumble_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_raiz)
                        .addName((R.string.ryze_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_senjuani)
                        .addName((R.string.sejuani_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shaco)
                        .addName((R.string.shaco_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shen)
                        .addName((R.string.shen_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_shivanna)
                        .addName((R.string.shyvana_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sinjed)
                        .addName((R.string.singed_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sion)
                        .addName((R.string.sion_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sivir)
                        .addName((R.string.sivir_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_scarner)
                        .addName((R.string.skarner_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_sonna)
                        .addName((R.string.sona_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_soraca)
                        .addName((R.string.soraka_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_swein)
                        .addName((R.string.swain_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_syndra)
                        .addName((R.string.syndra_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_thamn_kench)
                        .addName((R.string.tahmkench_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_thalon)
                        .addName((R.string.talon_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tharic)
                        .addName((R.string.taric_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_teemo)
                        .addName((R.string.teemo_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tresh)
                        .addName((R.string.thresh_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_tristana)
                        .addName((R.string.tristana_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_trundle)
                        .addName((R.string.trundle_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_trindamere)
                        .addName((R.string.tryndamere_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_twitch)
                        .addName((R.string.twitch_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_udyr)
                        .addName((R.string.udyr_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_urgot)
                        .addName((R.string.urgot_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_varus)
                        .addName((R.string.varus_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vein)
                        .addName((R.string.vayne_name))
                        .addChampionType(ChampionType.MARKSMAN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_veigar)
                        .addName((R.string.veigar_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_velkoz)
                        .addName((R.string.velkoz_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vi)
                        .addName((R.string.vi_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_viktor)
                        .addName((R.string.viktor_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vladimir)
                        .addName((R.string.vladimir_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_voleybear)
                        .addName((R.string.volibear_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_varvik)
                        .addName((R.string.warwick_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_vukong)
                        .addName((R.string.wukong_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_xerath)
                        .addName((R.string.xerath_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_xinjao)
                        .addName((R.string.xinzhao_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_yasuo)
                        .addName((R.string.yasuo_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_youric)
                        .addName((R.string.yorick_name))
                        .addChampionType(ChampionType.FIGHTER)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zak)
                        .addName((R.string.zac_name))
                        .addChampionType(ChampionType.TANK)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zed)
                        .addName((R.string.zed_name))
                        .addChampionType(ChampionType.ASSASSIN)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zigs)
                        .addName((R.string.ziggs_name))
                        .addChampionType(ChampionType.MAGE)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zilean)
                        .addName((R.string.zilean_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),

                new Champion.Builder().addIcon(R.drawable.ic_zyra)
                        .addName((R.string.zyra_name))
                        .addChampionType(ChampionType.SUPPORT)
                        .build(),
        }));
    }
}
