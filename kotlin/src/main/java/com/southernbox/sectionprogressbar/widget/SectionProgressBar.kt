package com.southernbox.sectionprogressbar.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.southernbox.sectionprogressbar.R
import kotlinx.android.synthetic.main.layout_section_progress.view.*

/**
 * Created by nanquan.lin on 2016/12/30 0030.
 * 带节点的进度条控件
 */

class SectionProgressBar @JvmOverloads constructor(context: Context,
                                                   attrs: AttributeSet? = null,
                                                   defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_section_progress, this)
    }

    fun setProgress(stage: Float) {
        val progressWidth = rootView.iv_progress.width
        val animator = ObjectAnimator.ofFloat(rootView.iv_progress, "translationX", stage * progressWidth)
        animator.duration = (Math.abs(stage - currentStage) * 1000).toInt().toLong()
        animator.start()
        currentStage = stage
    }

    companion object {
        //不同阶段进度条所在位置
        val STAGE0 = 0f
        val STAGE1 = 0.046f
        val STAGE2 = 0.285f
        val STAGE3 = 0.523f
        val STAGE4 = 0.761f
        val STAGE5 = 1f
        //当前阶段
        private var currentStage: Float = 0.toFloat()
    }

}
