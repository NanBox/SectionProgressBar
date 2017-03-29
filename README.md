![](/images/SectionProgressBar.gif)

带节点进度条的实现方法不止一个，但是如果要实现图中这种效果的，初步看好像还不简单。进度条的形状不规则、背景是渐变颜色、节点上面还有个勾。这里提供一个很简单的思路，简单的都不好意思说了......


为了实现这个效果，我们需要三张图片，就是下面这三张。

![](/images/section_progress_bar.png)

![](/images/section_progress_bar_bg.png)

![](/images/section_progress_bar_cover.png)

看到这里可能你已经知道要怎么做了，三张图片分别是：

1.进度条填充部分的背景，带渐变颜色带节点小勾  
2.进度条未填充部分的背景，纯色  
3.进度条外框背景，是一张镂空图，颜色和进度条外的颜色一致  

注意这三张图片的大小必须一致，将这三张图片叠加到一起就是我们的进度条了。至于进度条的动画，我们只要对第二层的那张图片实现一个属性动画就可以了：

```java

public void setProgress(float stage) {
    int progressWidth = ivProgress.getWidth();
    ObjectAnimator animator = ObjectAnimator.ofFloat(ivProgress, "translationX", stage * progressWidth);
    animator.setDuration((int) (Math.abs(stage - currentStage) * 1000));
    animator.start();
    currentStage = stage;
}
    
```

至于如何控制到哪一个节点，这个可以自己拿尺子量一下，多试几次，上面代码中的 stage 就是这个作用，它从这里取值：

```java

//不同阶段进度条所在位置
public static final float STAGE0 = 0f;
public static final float STAGE1 = 0.046f;
public static final float STAGE2 = 0.285f;
public static final float STAGE3 = 0.523f;
public static final float STAGE4 = 0.761f;
public static final float STAGE5 = 1f;
    
```

这样就已经实现了一个看上去有点复杂的进度条了，妥妥的。