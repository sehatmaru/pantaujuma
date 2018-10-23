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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class FragmentPupukAdapter extends RecyclerView.Adapter<FragmentPupukAdapter.MyViewHolder> {

    private List<PupukRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPupukListener onClicPupuk;

    public FragmentPupukAdapter(Context context, List<PupukRealm> listData, OnClickPupukListener onClicPupuk) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPupuk =onClicPupuk;
    }

    public interface OnClickPupukListener {
        void OnClickPupuk(String idPupuk, String namaDepan, String namaBelakang, String nik);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_search_pupuk, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FragmentPupukAdapter.MyViewHolder holder, int position) {
        PupukRealm pupuk = listData.get(position);

        holder.textname.setText(pupuk.getNama());
        holder.textjenis.setText("Jenis : "+ pupuk.getJenis());
        holder.cardview.setOnClickListener(view -> { onClicPupuk.OnClickPupuk(pupuk.getHashId(), pupuk.getNama(), pupuk.getJenis(), pupuk.getDeskripsi());});
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
        TextView textjenis;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textjenis = (TextView)itemView.findViewById(R.id.jenis);
            cardview = (CardView) itemView.findViewById(R.id.pupukCardView);
        }
    }
    public void animateTo(List<PupukRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PupukRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PupukRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PupukRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PupukRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PupukRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PupukRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PupukRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PupukRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
