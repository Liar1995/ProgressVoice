package sunmeng.com.progressvoice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Sunmeng on 2016年7月15日
 * E-Mail:Sunmeng995@gmail.com
 * Description:
 */

public class MainActivity extends AppCompatActivity {


    private boolean isPlaying = false;
    private static final int SECOND_MS = 1000;
    private int currentDuration = 0;
    private Handler mHandler = new Handler();
    private ProgressLayout progressLayout;

    private CustImageView custImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressLayout= (ProgressLayout) findViewById(R.id.progressLayout);
        initView();
        custImageView3= (CustImageView) findViewById(R.id.custImageView3);
        custImageView3.setProgress(100F);
        progressLayout.start();
    }

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            currentDuration += 1;
            mHandler.postDelayed(mRunnable, SECOND_MS);
        }
    };

    private void initView() {
        progressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    isPlaying = true;
                    progressLayout.start();
                    mHandler.postDelayed(mRunnable, 0);
                } else {
                    isPlaying = false;
                    progressLayout.stop();
                    mHandler.removeCallbacks(mRunnable);
                }
            }
        });
    }
}
