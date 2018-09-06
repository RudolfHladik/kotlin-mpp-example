package org.konan.multiplatform.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import data.model.DeathStar
import data.remote.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import org.konan.multiplatform.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        header.text = Calculator.sum(1,1).toString()

//        Api.getDeathStar {
//            header.text = it.name
//        }
        launch(UI) {
            val ds = withContext(CommonPool) { Api.getDeathStar()  }
            header.text = ds.name
        }
    }
}
