package com.example.testing.test161019;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.testing.test161019.qqshare.BaseUiListener;
import com.example.testing.test161019.recyclerviewadapterhelper.BaseRecyclerViewAdapter;
import com.example.testing.test161019.refresh_test.ThirdActivity;
import com.tencent.open.GameAppOperation;
import com.tencent.tauth.Tencent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @Bind(R.id.imageview)
    ImageView imageview;
    @Bind(R.id.textview)
    TextView textview;
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.id_seekBar)
    SeekBar idSeekBar;
    @Bind(R.id.id_tv1)
    TextView idTv1;
    @Bind(R.id.id_tv2)
    TextView idTv2;

    Tencent mTencent;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.et_1)
    EditText et1;
    @Bind(R.id.rv_list)
    RecyclerView rvList;
//    @Bind(R.id.gif)
//    GifView gif;

    private BaseUiListener listener;

    private BaseRecyclerViewAdapter adapter;

    private List<String> data;

    private ClipboardManager mClipboard = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTencent = Tencent.createInstance("1105815471", getApplicationContext());
        ButterKnife.bind(this);

        idSeekBar.setOnSeekBarChangeListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                openCamera();
//                initRecycleView();
                copyText("sdfs" + "\n" + "\n" + "123");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
//                share();
//                openCamera();
            }
        });
        setAdapterData();
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    private void copyText(String text) {
        if (Build.VERSION.SDK_INT > 10) {
            ClipData clip = ClipData.newPlainText("simple text", text);
            if (null == mClipboard) {
                mClipboard = (ClipboardManager) getSystemService(
                        Context.CLIPBOARD_SERVICE);

            }
            // 把clip对象放在剪贴板中：
            mClipboard.setPrimaryClip(clip);
        } else {
            android.text.ClipboardManager mClipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            // 把clip对象放在剪贴板中：
            mClipboard.setText(text);
        }
    }

    private void setAdapterData() {
        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add(i + "");
        }
    }

    private void initRecycleView() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseRecyclerViewAdapter(null);
        adapter.openLoadAnimation();
        rvList.setAdapter(adapter);
        adapter.setNewData(data);
    }

    private String getEmojiStringByUnicode(int unicode) {
        char[] a = Character.toChars(unicode);
        String b = new String(a);
        return b;
    }

    public void openCamera() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() +
                        "/Yiniu/.UserInfo/" + "avatar_temp.jpg")));
        startActivityForResult(intentFromCapture, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                cropImage(Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() +
                        "/Yiniu/.UserInfo/" + "avatar_temp.jpg")));
                break;
            case 2:
                if (data != null)
                    break;
        }
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
    }

    public void cropImage(Uri uri) {
        String filePath = Environment.getExternalStorageDirectory().toString() +
                "/Yiniu/.UserInfo/" + "avatar_temp.jpg";
        if (filePath == null) {
            return;
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(Uri.fromFile(new File(filePath)), "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高\
        intent.putExtra("outputX", 400);
        intent.putExtra("outputY", 400);
        intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() +
                "/Yiniu/.UserInfo/" + "avatar_temp.jpg")));
        intent.putExtra("return-data", false);
        startActivityForResult(intent, 2);
    }


    //================================seekbar 进度监听方法==========================================
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        idTv1.setText("正在拖动");
        idTv2.setText("当前数值:" + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        idTv1.setText("开始拖动");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        idTv1.setText("停止拖动");
    }

    //==============================================================================================


    public void share() {
//        final Bundle params = new Bundle();
//        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
//        params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
//        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
//        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.baidu.com");
//        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
//        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
//        mTencent.shareToQQ(MainActivity.this, params, new BaseUiListener());

        //授权登陆
//        mTencent.login(this, "get_user_info,add_t", new BaseUiListener());
        //添加好友
//        Tencent mTencent = Tencent.createInstance("1105404183",this);
        Bundle params = new Bundle();
        mTencent.setOpenId("78F8C06103195E8A1002521E27A22A3D");
        params.putString(GameAppOperation.GAME_FRIEND_OPENID, "5360E979A82239A12BD7550991FC72EE");
        params.putString(GameAppOperation.GAME_FRIEND_LABEL, "好友");
        params.putString(GameAppOperation.GAME_FRIEND_ADD_MESSAGE, "测试");
        mTencent.makeFriend(MainActivity.this, params);
//        89AF5EA763ECFC57917A8C1D8C62FF2E
    }
}
