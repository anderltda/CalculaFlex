package br.com.anderson.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.anderson.calculaflex.extensions.format
import br.com.anderson.calculaflex.extensions.formatDecimal
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        caculate()

    }


    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()

        return super.onSupportNavigateUp()
    }

    fun caculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE", 0.0)
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE", 0.0)

        val perfomanceMyCar = ethanolAverage / gasAverage
        val priceIndice = ethanolPrice / gasPrice

        if (priceIndice <= perfomanceMyCar) {
            tvSuggestion.text = getString(R.string.label_ethanol)
        } else {
            tvSuggestion.text = getString(R.string.label_gasoline)
        }


        tvGasAverageResult.text = String().formatDecimal(2, (gasPrice / gasAverage))
        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)

        tvFuelRatio.text = getString(R.string.label_ration_fuel, perfomanceMyCar.format(2))
    }
}
