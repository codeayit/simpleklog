package com.ayit.simpleklog;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ayit.klog.KLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    public static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    public static DateFormat dataFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
     int count = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KLog.init(this,true,true,"zlog", Environment.getExternalStorageDirectory().getAbsolutePath()+"/simpleKlog/",3);
//        KLog.init(this,true,"zlog",Environment.getExternalStorageDirectory().getAbsolutePath()+"/simpleKlog2/",3);
        KLog.d("123");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    SystemClock.sleep(50);
                    KLog.d(formatter.format(new Date())+"  log ---------------------------- "+"2019-10-31");
                    count--;
                    if (count ==0){
                        break;
                    }
                }
                KLog.d("打印完毕");
            }
        }).start();


//        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission
//                    .WRITE_EXTERNAL_STORAGE)) {
//                Toast.makeText(this, "请开通相关权限，否则无法正常使用本应用！", Toast.LENGTH_SHORT).show();
//            }
//                Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
//            //申请权限
//            Log.d("KLog","111");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
//            Log.d("KLog","111111");
//        } else {
//            Log.d("KLog","222");
//            Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();
//            KLog.init(this,true);
//            KLog.d("123");
//            Log.d("KLog","xxxx");
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("KLog","resume");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("KLog","333");
        if (requestCode == 1){
            Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();
            KLog.init(this,true);
            KLog.d("123");
        }
    }

}
