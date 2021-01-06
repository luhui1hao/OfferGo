package luhui1hao.xyz.offergo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Module> moduleList = new ArrayList<>();
    private ModuleAdapter moduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initModules();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        moduleAdapter = new ModuleAdapter(this, moduleList);
        recyclerView.setAdapter(moduleAdapter);
    }

    private void initModules() {
        moduleList.clear();
        moduleList.add(new Module("OkHttp", "luhui1hao.xyz.offergo.okhttp.OkHttpActivity"));
    }

}