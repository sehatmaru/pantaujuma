package teknodesa.devlops.pantaujuma.components.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class RDKAdapter extends RecyclerView.Adapter<RDKAdapter.MyViewHolder> {
    private List<RDKRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickRDKListener onClicRDK;

    public RDKAdapter(Context context, List<RDKRealm> listData, OnClickRDKListener onClicRDK) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicRDK =onClicRDK;
    }

    public interface OnClickRDKListener {
        void OnClickRDK(String idRDK);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rdk, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RDKRealm rdk = listData.get(position);
        holder.textnama.setText(rdk.getNama());
        holder.textkegiatan.setText(rdk.getKegiatanJK());
        holder.texttanggal.setText(rdk.getTanggal());
        holder.textvarietas.setText(rdk.getVarietas());
        holder.texttarget.setText(rdk.getTarget());
        holder.cardview.setOnClickListener(view -> {
            onClicRDK.OnClickRDK(rdk.getHashId());
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
        TextView textkegiatan;
        TextView texttanggal;
        TextView textvarietas;
        TextView texttarget;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            textkegiatan = (TextView)itemView.findViewById(R.id.kegiatan);
            texttanggal = (TextView)itemView.findViewById(R.id.tanggal);
            textvarietas = (TextView)itemView.findViewById(R.id.varietas);
            texttarget = (TextView)itemView.findViewById(R.id.target);
            cardview = (CardView) itemView.findViewById(R.id.rdkCardView);
        }
    }

    public void animateTo(List<RDKRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<RDKRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final RDKRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<RDKRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final RDKRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, RDKRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<RDKRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final RDKRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final RDKRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}

