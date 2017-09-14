package com.od.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.od.core.Rest;
import com.od.core.observer.NetSubscriber;
import com.od.core.observer.transformer.Transformer;
import com.od.core.rest.NetParams;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
                Rest.getInstance().create(KDService.class)
                        .getCoupons("yuantong", "11111111111")
                        .compose(Transformer.<KDBean>defaultSchedulers())
                        .subscribe(new NetSubscriber<KDBean>() {
                            @Override
                            protected void onSuccess(KDBean kdBean) {
                                textView.setText(kdBean.toString());
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
