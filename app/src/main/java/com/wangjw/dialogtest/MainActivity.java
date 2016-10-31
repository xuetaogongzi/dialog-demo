package com.wangjw.dialogtest;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements TestDialogFragment.TestDialogListener {

    private Button mBtnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAction = (Button) findViewById(R.id.Button_Action);
        mBtnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showDialog();
                showMoreDialog();
            }
        });
    }

    private void showDialog() {
        TestDialogFragment fragment = new TestDialogFragment();
        fragment.show(getSupportFragmentManager(), "TestDialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialogFragment) {
        Log.d(AppGlobal.LOG_TAG, "PositiveClick");
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialogFragment) {
        Log.d(AppGlobal.LOG_TAG, "NegativeClick");
    }

    private void showMoreDialog() {
        final MoreFunDialog funDialog = new MoreFunDialog(this);
        funDialog.setMoreClickListener(new MoreFunDialog.OnMoreClickListener() {
            @Override
            public void shareClick() {
                Log.d(AppGlobal.LOG_TAG, "Share");
            }

            @Override
            public void reportClick() {
                Log.d(AppGlobal.LOG_TAG, "Report");
            }
        });
        funDialog.show();
    }
}
