package teknodesa.devlops.pantaujuma.components.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class AlsintanAdapter extends RecyclerView.Adapter<AlsintanAdapter.MyViewHolder> {

    private List<AlsintanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickAlsintanListener onClicAlsintan;

    public AlsintanAdapter(Context context, List<AlsintanRealm> listData, OnClickAlsintanListener onClicAlsintan) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicAlsintan = onClicAlsintan;
    }

    public interface OnClickAlsintanListener {
        void OnClickAlsintan(String idAlsintan);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_alsintan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AlsintanRealm alsintan = listData.get(position);

        holder.textnamaAlat.setText("Nama: " +alsintan.getNamaAlat());
        holder.textdeskripsi.setText("Deskripsi: " +alsintan.getDeskripsi());
        holder.cardview.setOnClickListener(view -> {
            onClicAlsintan.OnClickAlsintan(alsintan.getHashId());
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textnamaAlat;
        TextView textdeskripsi;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnamaAlat = (TextView)itemView.findViewById(R.id.namaalat);
            textdeskripsi = (TextView)itemView.findViewById(R.id.deskripsi);
            cardview = (CardView) itemView.findViewById(R.id.alsintanCardView);
        }
    }
    public void animateTo(List<AlsintanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<AlsintanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final AlsintanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<AlsintanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final AlsintanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, AlsintanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<AlsintanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final AlsintanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final AlsintanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
