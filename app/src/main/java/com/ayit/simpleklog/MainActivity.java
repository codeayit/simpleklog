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

import org.json.JSONException;
import org.json.JSONObject;

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

        KLog.init(this, true, true, "zlog", Environment.getExternalStorageDirectory().getAbsolutePath() + "/simpleKlog/", 3);
//        KLog.init(this,true,"zlog",Environment.getExternalStorageDirectory().getAbsolutePath()+"/simpleKlog2/",3);
//        KLog.d("123");
        String str = "《红楼梦》，中国古代章回体长篇小说，又名《石头记》等，被列为中国古典四大名著之首，一般认为是清代作家曹雪芹所著。小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美，可以说是一部从各个角度展现女性美以及中国古代社会世态百相的史诗性著作。\n" +
                "《红楼梦》版本可分为120回“程本”和80回“脂本”两大系统。程本为程伟元排印的印刷本，脂本为脂砚斋在不同时期抄评的早期手抄本。脂本是程本的底本。\n" +
                "《红楼梦》是一部具有世界影响力的人情小说，举世公认的中国古典小说巅峰之作，中国封建社会的百科全书，传统文化的集大成者。小说以“大旨谈情，实录其事”自勉，只按自己的事体情理，按迹循踪，摆脱旧套，新鲜别致，取得了非凡的艺术成就。“真事隐去，假语村言”的特殊笔法更是令后世读者脑洞大开，揣测之说久而遂多。二十世纪以来，学术界因《红楼梦》异常出色的艺术成就和丰富深刻的思想底蕴而产生了以《红楼梦》为研究对象的专门学问——红学。";

        JSONObject object = new JSONObject();
        try {
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            object.put("title",str);
            for (int i = 0; i < 10000; i++) {
                object.put("index",i);
                KLog.json(object.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



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
        Log.d("KLog", "resume");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("KLog", "333");
        if (requestCode == 1) {
            Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();
            KLog.init(this, true);
            KLog.d("123");
        }
    }

}
