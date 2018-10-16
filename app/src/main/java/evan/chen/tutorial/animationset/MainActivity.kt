package evan.chen.tutorial.animationset

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.view.animation.AlphaAnimation


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fromDegree = 0.0f
        var toDegree = 0.0f

        rotate.setOnClickListener {

            var rotateDegree = 90
            toDegree = fromDegree + rotateDegree

            //旋轉動畫
            val animation = RotateAnimation(
                    fromDegree, //起始角度
                    toDegree, //結束角度
                    RotateAnimation.RELATIVE_TO_SELF, //pivotXType
                    0.5f, //設定x旋轉中心點
                    RotateAnimation.RELATIVE_TO_SELF,
                    0.5f) //設定y旋轉中心點

            //動畫持續時間
            animation.duration = 1000

            //將圖片載入動畫
            this.image.startAnimation(animation)

            fromDegree = toDegree
        }

        scale.setOnClickListener {

            //放大1.5放
            val animation = ScaleAnimation(
                    1.0f,// x起始縮放比例
                    1.5f, // x結束縮放比例
                    1.0f,// x起始縮放比例
                    1.5f, // y結束縮放比例
                    Animation.RELATIVE_TO_SELF, 1f,
                    Animation.RELATIVE_TO_SELF, 1f)
            animation.duration = 1000

            this.image.startAnimation(animation)
        }

        translate.setOnClickListener {
            //x座標增加100，y座標減少100
            val animation = TranslateAnimation(
                    0f,
                    100f,
                    0f,
                    -100f)
            animation.duration = 1000

            this.image.startAnimation(animation)
        }

        alpha.setOnClickListener {

            //透明過至0.2
            val animation = AlphaAnimation(1.0f, 0.2f)
            animation.duration = 1000

            this.image.startAnimation(animation)
        }
    }
}
