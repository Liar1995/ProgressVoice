package sunmeng.com.progressvoice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by Sunmeng on 2016年7月15日
 * E-Mail:Sunmeng995@gmail.com
 * Description:
 */

public class CustImageView extends ImageView {

    private float progress = 0;

    public CustImageView(Context context) {
        this(context, null);
    }

    public CustImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                startProgress();
            }
        }, 10);
    }

    private void startProgress() {
        ObjectAnimator progressAnimator = ObjectAnimator
                .ofFloat(this, "progress", 0, 100)
                .setDuration(5000);
        progressAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();//绘制的路径
        path.moveTo(0, 0);//不进行绘制 只用于移动
        int pathWidth = (int) (getWidth() * progress / 100);
        path.lineTo(pathWidth, 0);//绘制直线
        path.lineTo(pathWidth, getHeight());
        path.lineTo(0, getHeight());
        path.close();
        canvas.clipPath(path);
        super.onDraw(canvas);
    }


    void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

}
