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
        String str = "{\"method\":\"get\",\"url\":\"http:\\\\/\\\\/www.houluzhai.top:9310\\\\/coffeeVendor\\\\/device\\\\/getGoodsLibsStrategyDetailByDeviceId\",\"params\":{\"deviceSn\":\"44:18:08:09:3f:c2\",\"deviceId\":\"80\"},\"headers\":{\"sn\":\"44:18:08:09:3f:c2\"},\"response_success\":{\"message\":\"ok\",\"content\":{\"agent\":42,\"remark\":\"\",\"isDel\":0,\"updated\":\"\",\"strategyCode\":\"STR000066\",\"isWater\":1,\"priceList\":[{\"cupParam\":\"[{\\\"index\\\":0,\\\"value\\\":\\\"大杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"20\\\",\\\"materialWeight\\\":\\\"30\\\",\\\"price\\\":\\\"3\\\"},{\\\"index\\\":1,\\\"value\\\":\\\"中杯\\\",\\\"isShow\\\":false},{\\\"index\\\":2,\\\"value\\\":\\\"小杯\\\",\\\"isShow\\\":false}]\",\"libsCupParam\":\"\",\"cupPrice\":\"\",\"updated\":\"\",\"imageUrl\":\"http:\\\\/\\\\/www.houluzhai.top\\\\/imgs\\\\/1220d907cedf4de8ad3193134592fd70卡布奇诺_coffee.jpg\",\"isHot\":\"1\",\"strategyId\":66,\"id\":270,\"boxCode\":\"1号通道\",\"hotPrice\":0,\"price\":20,\"createTime\":\"2019-12-26 11:07:07\",\"libsId\":102,\"boxId\":272,\"goodsName\":\"卡布奇诺咖啡\",\"created\":\"jakecy\",\"imagePath\":\"\"},{\"cupParam\":\"[{\\\"index\\\":0,\\\"value\\\":\\\"大杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"20\\\",\\\"materialWeight\\\":\\\"10\\\",\\\"price\\\":\\\"10\\\"},{\\\"index\\\":1,\\\"value\\\":\\\"中杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"30\\\",\\\"materialWeight\\\":\\\"20\\\",\\\"price\\\":\\\"5\\\"},{\\\"index\\\":2,\\\"value\\\":\\\"小杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"35\\\",\\\"materialWeight\\\":\\\"30\\\",\\\"price\\\":\\\"0\\\"}]\",\"libsCupParam\":\"\",\"cupPrice\":\"\",\"updated\":\"\",\"imageUrl\":\"http:\\\\/\\\\/www.houluzhai.top\\\\/imgs\\\\/56be7cf503d34ce3bde58db4fa1ded65HarinaCoffee.jpg\",\"isCold\":1,\"isHot\":\"1\",\"strategyId\":66,\"id\":271,\"boxCode\":\"2号通道\",\"hotPrice\":3,\"price\":15,\"createTime\":\"2019-12-26 11:07:07\",\"libsId\":102,\"coldPrice\":0,\"boxId\":273,\"goodsName\":\"瑞幸咖啡\",\"created\":\"jakecy\",\"imagePath\":\"\"},{\"cupParam\":\"[{\\\"index\\\":0,\\\"value\\\":\\\"大杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"20\\\",\\\"materialWeight\\\":\\\"10\\\",\\\"price\\\":\\\"10\\\"},{\\\"index\\\":1,\\\"value\\\":\\\"中杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"30\\\",\\\"materialWeight\\\":\\\"20\\\",\\\"price\\\":\\\"5\\\"},{\\\"index\\\":2,\\\"value\\\":\\\"小杯\\\",\\\"isShow\\\":true,\\\"waterWeight\\\":\\\"35\\\",\\\"materialWeight\\\":\\\"30\\\",\\\"price\\\":\\\"0\\\"}]\",\"libsCupParam\":\"\",\"cupPrice\":\"\",\"updated\":\"\",\"imageUrl\":\"http:\\\\/\\\\/www.houluzhai.top\\\\/imgs\\\\/1e9d2b0fee4a4fdc96436cc017833890焦糖拿铁咖啡.jpg\",\"isHot\":\"1\",\"strategyId\":66,\"id\":272,\"boxCode\":\"3号通道\",\"hotPrice\":0,\"price\":13,\"createTime\":\"2019-12-26 11:07:07\",\"libsId\":102,\"boxId\":274,\"goodsName\":\"焦糖拿铁\",\"created\":\"jakecy\",\"imagePath\":\"\"}],\"companyName\":\"名捕科技有限公司(代理商)\",\"id\":66,\"libsName\":\"\",\"createTime\":\"2019-12-26 11:08:28\",\"libsId\":102,\"companyType\":1,\"strategyName\":\"元旦优惠价\",\"created\":\"jakecy\",\"companyId\":42},\"code\":200,\"success\":true}}";

        KLog.setOnLogListener(new KLog.OnLogListener() {
            @Override
            public void onLog(String log) {
                Log.d("lis",log);
            }
        });

        for (int i = 0; i < 10; i++) {
            KLog.json(str);
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
