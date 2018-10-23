package teknodesa.devlops.pantaujuma.components.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PengecerPupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class AlsintanPengecerPupukAdapter extends RecyclerView.Adapter<AlsintanPengecerPupukAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<PengecerPupukRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPupukListener onClicPupuk;

    public AlsintanPengecerPupukAdapter(Context context, List<PengecerPupukRealm> listData, OnClickPupukListener onClicPupuk) {
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
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_pupuk, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlsintanPengecerPupukAdapter.MyViewHolder holder, int position) {
        PengecerPupukRealm pengecerpupuk = listData.get(position);

        PupukRealm pupuk = realm.where(PupukRealm.class).equalTo("hashId", pengecerpupuk.getPupuk()).findFirst();

        holder.textname.setText(pupuk.getNama());
        holder.textjenis.setText(pupuk.getJenis());
        holder.textharga.setText(pengecerpupuk.getHarga());
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
        TextView textharga;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textjenis = (TextView)itemView.findViewById(R.id.jenis);
            textharga = (TextView)itemView.findViewById(R.id.harga);
            cardview = (CardView) itemView.findViewById(R.id.pupukCardView);
        }
    }
    public void animateTo(List<PengecerPupukRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PengecerPupukRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PengecerPupukRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PengecerPupukRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PengecerPupukRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PengecerPupukRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PengecerPupukRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PengecerPupukRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PengecerPupukRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
