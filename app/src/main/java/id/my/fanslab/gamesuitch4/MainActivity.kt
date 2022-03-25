package id.my.fanslab.gamesuitch4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import id.my.fanslab.gamesuitch4.action.BatuAction
import id.my.fanslab.gamesuitch4.action.GuntingAction
import id.my.fanslab.gamesuitch4.action.InvalidAction
import id.my.fanslab.gamesuitch4.action.KertasAction
import id.my.fanslab.gamesuitch4.data.DataSources
import id.my.fanslab.gamesuitch4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playerBatu.setOnClickListener {
            binding.playerBatu.background = getDrawable(R.drawable.player_background)
            binding.playerGunting.background = getDrawable(R.drawable.player_unselected)
            binding.playerKertas.background = getDrawable(R.drawable.player_unselected)
            val comp = getRandom()
            getResult("batu", comp)
        }

        binding.playerGunting.setOnClickListener {
            binding.playerGunting.background = getDrawable(R.drawable.player_background)
            binding.playerBatu.background = getDrawable(R.drawable.player_unselected)
            binding.playerKertas.background = getDrawable(R.drawable.player_unselected)
            val comp = getRandom()
            getResult("gunting", comp)
        }

        binding.playerKertas.setOnClickListener {
            binding.playerKertas.background = getDrawable(R.drawable.player_background)
            binding.playerBatu.background = getDrawable(R.drawable.player_unselected)
            binding.playerGunting.background = getDrawable(R.drawable.player_unselected)
            val comp = getRandom()
            getResult("kertas", comp)
        }

        binding.btnRefresh.setOnClickListener {
            setupLayout()
        }
    }

    private fun getRandom(): String {
        val suitDataComp = DataSources.getRandomSuit()
        return suitDataComp.name
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getResult(player: String, comp: String) = with(binding) {
        println("Player choose : $player")
        println("Computer get : $comp")
        val suitPlayer = when (player) {
            "kertas" -> KertasAction()
            "batu" -> BatuAction()
            "gunting" -> GuntingAction()
            else -> InvalidAction()
        }
        when (comp) {
            "kertas" -> {
                comKertas.background = getDrawable(R.drawable.player_background)
                comBatu.background = getDrawable(R.drawable.player_unselected)
                comGunting.background = getDrawable(R.drawable.player_unselected)
            }
            "batu" -> {
                comKertas.background = getDrawable(R.drawable.player_unselected)
                comBatu.background = getDrawable(R.drawable.player_background)
                comGunting.background = getDrawable(R.drawable.player_unselected)
            }
            "gunting" -> {
                comKertas.background = getDrawable(R.drawable.player_unselected)
                comBatu.background = getDrawable(R.drawable.player_unselected)
                comGunting.background = getDrawable(R.drawable.player_background)
            }
            else -> {
                comKertas.background = getDrawable(R.drawable.player_unselected)
                comBatu.background = getDrawable(R.drawable.player_unselected)
                comGunting.background = getDrawable(R.drawable.player_unselected)
            }
        }

        val result = suitPlayer.action(comp)
        println("Result is : $result")
        tvResult.text = result
        tvResult.background = if (result == "DRAW") getDrawable(R.drawable.result_draw)
        else getDrawable(R.drawable.result_win)

        mapsVisibility(true)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupLayout() = with(binding) {
        playerGunting.background = getDrawable(R.drawable.player_unselected)
        playerBatu.background = getDrawable(R.drawable.player_unselected)
        playerKertas.background = getDrawable(R.drawable.player_unselected)
        comGunting.background = getDrawable(R.drawable.player_unselected)
        comKertas.background = getDrawable(R.drawable.player_unselected)
        comBatu.background = getDrawable(R.drawable.player_unselected)
        mapsVisibility()
    }

    private fun mapsVisibility(isResult: Boolean = false) = with(binding) {
        tvVs.isVisible = isResult.not()
        tvResult.isVisible = isResult
    }
}