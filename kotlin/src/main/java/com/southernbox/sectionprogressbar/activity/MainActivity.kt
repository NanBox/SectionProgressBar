package com.southernbox.sectionprogressbar.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.southernbox.sectionprogressbar.R
import com.southernbox.sectionprogressbar.widget.SectionProgressBar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_stage0.setOnClickListener(this)
        btn_stage1.setOnClickListener(this)
        btn_stage2.setOnClickListener(this)
        btn_stage3.setOnClickListener(this)
        btn_stage4.setOnClickListener(this)
        btn_stage5.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_stage0 -> section_progress_bar.setProgress(SectionProgressBar.STAGE0)
            R.id.btn_stage1 -> section_progress_bar.setProgress(SectionProgressBar.STAGE1)
            R.id.btn_stage2 -> section_progress_bar.setProgress(SectionProgressBar.STAGE2)
            R.id.btn_stage3 -> section_progress_bar.setProgress(SectionProgressBar.STAGE3)
            R.id.btn_stage4 -> section_progress_bar.setProgress(SectionProgressBar.STAGE4)
            R.id.btn_stage5 -> section_progress_bar.setProgress(SectionProgressBar.STAGE5)
        }
    }
}
