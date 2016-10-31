package com.wangjw.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/28.
 */
public class MoreFunDialog extends Dialog implements View.OnClickListener {

    private Context mContext;

    private LinearLayout mDialogRoot;
    private TextView mTvShare;
    private TextView mTvReport;
    private Button mBtnCancel;

    private OnMoreClickListener mMoreClickListener;

    public MoreFunDialog(Context context) {
        super(context, R.style.CustomDialog);

        mContext = context;

        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.CommDialogEnterExit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_more_fun);

        mDialogRoot = (LinearLayout) findViewById(R.id.Dialog_Root);
        mTvShare = (TextView) findViewById(R.id.TextView_Share);
        mTvReport = (TextView) findViewById(R.id.TextView_Report);
        mBtnCancel = (Button) findViewById(R.id.Button_Cancel);

        DisplayMetrics metric = mContext.getResources().getDisplayMetrics();
        int screen_width = metric.widthPixels;

        ViewGroup.LayoutParams params = mDialogRoot.getLayoutParams();
        params.width = screen_width;
        mDialogRoot.setLayoutParams(params);

        mTvShare.setOnClickListener(this);
        mTvReport.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        if (v == mTvShare) {
            if (mMoreClickListener != null) {
                mMoreClickListener.shareClick();
            }
        } else if (v == mTvReport) {
            if (mMoreClickListener != null) {
                mMoreClickListener.reportClick();
            }
        } else if (v == mBtnCancel) {

        }
    }

    public void setMoreClickListener(OnMoreClickListener onMoreClickListener) {
        mMoreClickListener = onMoreClickListener;
    }

    public interface OnMoreClickListener {
        void shareClick();
        void reportClick();
    }
}
