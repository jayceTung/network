package com.od.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.od.core.NetPost;
import com.od.core.observer.NetSubscriber;
import com.od.core.observer.transformer.Transformer;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.bt_rest);
        textView = (TextView) findViewById(R.id.tv_rest);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NetPost.getInstance().create(KDService.class)
//                        .getCoupons("yuantong", "11111111111")
//                        .compose(Transformer.<KDBean>defaultSchedulers())
//                        .subscribe(new NetSubscriber<KDBean>() {
//                            @Override
//                            protected void onSuccess(KDBean kdBean) {
//                                textView.setText(kdBean.toString());
//                            }
//
//                            @Override
//                            protected void onFail(String message) {
//                                textView.setText(message);
//                            }
//                        });


                Map<String, Object> map = new HashMap<>();
                map.put("mobile", "15990010346");
                map.put("password", "123456");
                NetPost.getInstance().create(KDService.class)
                        .LoginByPhone("15990010346", "123456")
                        .compose(Transformer.<Result<LoginInfo>>defaultSchedulers())
                        .subscribe(new NetSubscriber<Result<LoginInfo>>() {
                            @Override
                            protected void onSuccess(Result<LoginInfo> kdBean) {
                                Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_LONG);
                            }

                            @Override
                            protected void onFail(String message) {
                                textView.setText(message);
                            }
                        });
            }
        });


    }
}
