package app.wakayama.tama.renda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //残り時間
    var second = 10

    //タップを数える変数の準備
    var tapCount = 0

    //タイマーを設定する
    val timer: CountDownTimer = object : CountDownTimer(10000, 1000){
        override fun onFinish() {
            //STARTボタンを見える状態にする
            //gradleのappに
            // kotlinOptions {
            //        jvmTarget = '1.8'
            //    }　　　　を追加
            startButton.isVisible = true
            //TAPボタンを灰色にセットする
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_glay)
            //残り時間を10秒に戻す
            second = 10
            //タップを数える変数を0に戻す
            tapCount = 0
        }

        override fun onTick(millisUntilFinished: Long) {
            //TAPボタンをピンクにセットする
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            //残り時間をマイナス1秒する
            second = second - 1
            //残り時間をテキストビューに反映する
            secondText.text = second.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {

            countText.text = tapCount.toString()
            startButton.isVisible = false

            timer.start()
        }

        tapButton.setOnClickListener {
            if (second < 10) {
                tapCount = tapCount + 1
                //タップされた数をテキストビューに反映する
                countText.text = tapCount.toString()
            }
        }
    }
}