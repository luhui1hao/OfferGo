package luhui1hao.xyz.offergo.okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import luhui1hao.xyz.offergo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static luhui1hao.xyz.offergo.constant.Constant.HOST;

public class OkHttpActivity extends AppCompatActivity {

    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_get, R.id.btn_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get: {
                requestGet();
            }
            break;
            case R.id.btn_post:
                break;
        }
    }

    private void requestGet() {
        String url = HOST + "/api/getRequest";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("luhui", response.body().string());
                tvContent.setText(response.body().string());
            }
        });
    }
}