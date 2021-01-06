package luhui1hao.xyz.offergo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private List<Module> mModuleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout containerModuleLayout;
        ImageView imgIcon;
        TextView tvModule;

        public ViewHolder(View view) {
            super(view);
            containerModuleLayout = view.findViewById(R.id.container_module);
            imgIcon = view.findViewById(R.id.img_icon);
            tvModule = view.findViewById(R.id.btn_module);
        }

    }

    public ModuleAdapter(List<Module> moduleList) {
        mModuleList = moduleList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Module module = mModuleList.get(position);
        holder.tvModule.setText(module.getName());

        holder.containerModuleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainApplication.getContext(), module.getName(), Toast.LENGTH_SHORT).show();
                Log.e("luhui", module.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModuleList.size();
    }
}