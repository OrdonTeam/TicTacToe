package com.ordonteam.hanabi.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ordonteam.hanabi.R
import com.ordonteam.hanabi.game.HanabiCard

class GameInfoView extends LinearLayout {

    ImageView tipsImgage
    TextView tipsNumberText

    ImageView thunderImage
    TextView thundersNumberText

    CardView knownCards

    GameInfoView(Context context, AttributeSet attrs) {
        super(context, attrs)
        setOrientation(HORIZONTAL)

        tipsImgage = new ImageView(context)
        tipsNumberText = new TextView(context, attrs)

        thunderImage = new ImageView(context)
        thundersNumberText = new TextView(context, attrs)

        knownCards = new CardView(context, attrs)

        tipsImgage.setImageResource(R.drawable.question)
        tipsNumberText.setText("8")
        tipsNumberText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40)

        thunderImage.setImageResource(R.drawable.thunder)
        thundersNumberText.setText("3")
        thundersNumberText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40)

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context, attrs)
        layoutParams.weight = 1

        [tipsImgage, tipsNumberText, thunderImage, thundersNumberText, knownCards].each {
            it.setLayoutParams(layoutParams)
            addView(it)
        }
    }

    void setTipsNumber(int tipsNumber) {
        tipsNumberText.setText("$tipsNumber")
    }

    void setThundersNumber(int thundersNumber) {
        thundersNumberText.setText("$thundersNumber")
    }

    void setTopRejectedCard(HanabiCard hanabiCard) {
        if (hanabiCard) {
            knownCards.setColor(hanabiCard.color.color)
            knownCards.setNumber("${hanabiCard.value.value}")
        }
    }
}
