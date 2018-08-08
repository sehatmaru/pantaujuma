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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

public class FragmentKomoditasAdapter extends RecyclerView.Adapter<FragmentKomoditasAdapter.MyViewHolder> {

    private List<KomoditasRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickKomoditasListener onClicKomoditas;

    public FragmentKomoditasAdapter(Context context, List<KomoditasRealm> listData, OnClickKomoditasListener onClicKomoditas) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicKomoditas =onClicKomoditas;
    }

    public interface OnClickKomoditasListener {
        void OnClickKomoditas(String idKomoditas, String nama, String deskripsi);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_search_komoditas, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FragmentKomoditasAdapter.MyViewHolder holder, int position) {
        KomoditasRealm komoditas = listData.get(position);
        holder.textname.setText(komoditas.getNama());
        holder.textnik.setText(komoditas.getDeskripsi());
        holder.cardview.setOnClickListener(view -> { onClicKomoditas.OnClickKomoditas(komoditas.getHashId(),komoditas.getNama(), komoditas.getDeskripsi());});

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
        TextView textname;
        TextView textnik;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textnik = (TextView)itemView.findViewById(R.id.deskripsi);
            cardview = (CardView) itemView.findViewById(R.id.komoditasCardView);
        }
    }
    public void animateTo(List<KomoditasRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<KomoditasRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final KomoditasRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<KomoditasRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final KomoditasRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, KomoditasRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<KomoditasRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final KomoditasRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final KomoditasRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
