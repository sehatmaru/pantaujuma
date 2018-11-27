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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class TokoAlsintanAdapter extends RecyclerView.Adapter<TokoAlsintanAdapter.MyViewHolder> {

    private List<TokoAlsintanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickTokoAlsintanListener onClicTokoAlsintan;

    public TokoAlsintanAdapter(Context context, List<TokoAlsintanRealm> listData, OnClickTokoAlsintanListener onClicTokoAlsintan) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicTokoAlsintan = onClicTokoAlsintan;
    }

    public interface OnClickTokoAlsintanListener {
        void OnClickTokoAlsintan(String idAlsintan);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_toko, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TokoAlsintanRealm toko = listData.get(position);

        holder.textnama.setText("Toko: " + toko.getNama_contact());
        holder.textnohp.setText("HP: " + toko.getNo_hp());
        holder.textharga.setText("Harga: " + toko.getHarga());
        holder.textstock.setText("Stock: " + toko.getStok());
        holder.cardview.setOnClickListener(view -> {
            onClicTokoAlsintan.OnClickTokoAlsintan(toko.getId());
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
        TextView textnama;
        TextView textnohp;
        TextView textharga;
        TextView textstock;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            textnohp = (TextView)itemView.findViewById(R.id.nohp);
            textharga = (TextView)itemView.findViewById(R.id.harga);
            textstock = (TextView)itemView.findViewById(R.id.stock);
            cardview = (CardView) itemView.findViewById(R.id.tokoCardView);
        }
    }
    public void animateTo(List<TokoAlsintanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<TokoAlsintanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final TokoAlsintanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<TokoAlsintanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final TokoAlsintanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, TokoAlsintanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<TokoAlsintanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final TokoAlsintanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final TokoAlsintanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
