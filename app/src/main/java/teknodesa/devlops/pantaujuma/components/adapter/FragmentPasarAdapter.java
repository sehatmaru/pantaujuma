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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class FragmentPasarAdapter extends RecyclerView.Adapter<FragmentPasarAdapter.MyViewHolder> {

    private List<PasarRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPasarListener onClicPasar;

    public FragmentPasarAdapter(Context context, List<PasarRealm> listData, OnClickPasarListener onClicPasar) {

        Log.e("adapter", listData.size() + "");
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPasar =onClicPasar;
    }

    public interface OnClickPasarListener {
        void OnClickPasar(String idPasar, String nama, String alamat, String kecamatan, String kabupaten);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_search_pasar, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FragmentPasarAdapter.MyViewHolder holder, int position) {
        PasarRealm pasar = listData.get(position);

        holder.textname.setText(pasar.getNamaPasar());
        holder.textkecamatan.setText("Kecamatan : "+ pasar.getKecamatan());
        holder.cardview.setOnClickListener(view -> { onClicPasar.OnClickPasar(pasar.getHashId(), pasar.getNamaPasar(), pasar.getAlamat(), pasar.getKecamatan(), pasar.getKabupaten());});
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
        TextView textkecamatan;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textkecamatan = (TextView)itemView.findViewById(R.id.kecamatan);
            cardview = (CardView) itemView.findViewById(R.id.pasarCardView);
        }
    }
    public void animateTo(List<PasarRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PasarRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PasarRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PasarRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PasarRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PasarRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PasarRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PasarRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PasarRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
