package com.southernbox.sectionprogressbar.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.southernbox.sectionprogressbar.R;

/**
 * Created by SouthernBox on 2016/12/30 0030.
 * 带节点的进度条控件
 */

public class SectionProgressBar extends LinearLayout {

    private Context mContext;
    private ImageView ivProgress;

    //不同阶段进度条所在位置
    public static final float STAGE0 = 0f;
    public static final float STAGE1 = 0.046f;
    public static final float STAGE2 = 0.285f;
    public static final float STAGE3 = 0.523f;
    public static final float STAGE4 = 0.761f;
    public static final float STAGE5 = 1f;
    //当前阶段
    private static float currentStage;

    public SectionProgressBar(Context context) {
        this(context, null);
    }

    public SectionProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SectionProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.layout_section_progress, this);
        ivProgress = (ImageView) rootView.findViewById(R.id.iv_progress);
    }

    public void setProgress(float stage) {
        int progressWidth = ivProgress.getWidth();
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivProgress, "translationX", stage * progressWidth);
        animator.setDuration((int) (Math.abs(stage - currentStage) * 1000));
        animator.start();
        currentStage = stage;
    }

}
