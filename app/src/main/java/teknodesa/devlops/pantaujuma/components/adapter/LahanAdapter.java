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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class LahanAdapter extends RecyclerView.Adapter<LahanAdapter.MyViewHolder> {
    private List<LahanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickLahanListener onClicLahan;

    public LahanAdapter(Context context, List<LahanRealm> listData, OnClickLahanListener onClicLahan) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicLahan =onClicLahan;
    }

    public interface OnClickLahanListener {
        void OnClickLahan(String idLahan);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_lahan, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LahanRealm lahan = listData.get(position);
        holder.textnamapemilik.setText(lahan.getNamaPemilikLahan());
        holder.textluas.setText(lahan.getLuas());
        holder.textalamatlahan.setText(lahan.getAlamat());
        holder.textbatastimur.setText(lahan.getBatasTimur());
        holder.textbatasselatan.setText(lahan.getBatasSelatan());
        holder.textbatasbarat.setText(lahan.getBatasBarat());
        holder.textbatasutara.setText(lahan.getBatasUtara());
        holder.cardview.setOnClickListener(view -> {
            onClicLahan.OnClickLahan(lahan.getHashId());
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
        TextView textnamapemilik;
        TextView textluas;
        TextView textalamatlahan;
        TextView textbatastimur;
        TextView textbatasselatan;
        TextView textbatasbarat;
        TextView textbatasutara;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnamapemilik = (TextView)itemView.findViewById(R.id.namaPemilikLahan);
            textluas = (TextView)itemView.findViewById(R.id.luas);
            textalamatlahan = (TextView)itemView.findViewById(R.id.alamatlahan);
            textbatastimur = (TextView)itemView.findViewById(R.id.batastimur);
            textbatasselatan = (TextView)itemView.findViewById(R.id.batasselatan);
            textbatasbarat = (TextView)itemView.findViewById(R.id.batasbarat);
            textbatasutara = (TextView)itemView.findViewById(R.id.batasutara);
            cardview = (CardView) itemView.findViewById(R.id.lahanCardView);
        }
    }
    public void animateTo(List<LahanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<LahanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final LahanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<LahanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final LahanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, LahanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<LahanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final LahanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final LahanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }

}
