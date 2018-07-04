package teknodesa.devlops.pantaujuma.components.penduduk;

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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class FragmentPendudukAdapter extends RecyclerView.Adapter<FragmentPendudukAdapter.MyViewHolder> {

    private List<PendudukRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPendudukListener onClicPenduduk;

    public FragmentPendudukAdapter(Context context, List<PendudukRealm> listData, OnClickPendudukListener onClicPenduduk) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPenduduk =onClicPenduduk;
    }

    public interface OnClickPendudukListener {
        void OnClickPenduduk(int idPenduduk, String nama);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_nama_penduduk, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FragmentPendudukAdapter.MyViewHolder holder, int position) {
        PendudukRealm penduduk = listData.get(position);
        holder.textname.setText(penduduk.getNamaDepan()+" "+ penduduk.getNamaBelakang());
        holder.textnik.setText("NIK : "+penduduk.getNIK());
        holder.cardview.setOnClickListener(view -> { onClicPenduduk.OnClickPenduduk(penduduk.getIdPenduduk(),penduduk.getNamaDepan()+" "+penduduk.getNamaBelakang());});

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
            textnik = (TextView)itemView.findViewById(R.id.nik);
            cardview = (CardView) itemView.findViewById(R.id.pendudukCardView);
        }
    }
    public void animateTo(List<PendudukRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PendudukRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PendudukRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PendudukRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PendudukRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PendudukRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PendudukRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PendudukRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PendudukRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
