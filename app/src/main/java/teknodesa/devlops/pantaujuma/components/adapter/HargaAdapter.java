package teknodesa.devlops.pantaujuma.components.adapter;

import android.content.Context;
import android.graphics.Color;
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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class HargaAdapter extends RecyclerView.Adapter<HargaAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<HargaRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickHargaListener onClicHarga;

    public HargaAdapter(Context context, List<HargaRealm> listData, OnClickHargaListener onClicHarga) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicHarga = onClicHarga;
    }

    public interface OnClickHargaListener {
        void OnClickHarga(String idHarga);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_harga, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HargaRealm harga = listData.get(position);
        holder.setIsRecyclable(false);

        KomoditasRealm komoditas = realm.where(KomoditasRealm.class)
                .equalTo("hashId", harga.getHashKomoditas())
                .findFirst();

        if(harga.getIsSync() == 0 ){
            holder.cardview.setCardBackgroundColor(Color.CYAN);
        }

        String nama;
        String tanggal;
        String nilai;
        String satuan;

        if(harga.getHashKomoditas() == null || harga.getHashKomoditas().compareTo("")==0){
            nama="";
        }else{
            nama = komoditas.getNama();
        }

        holder.textkomoditas.setText("Komoditas: " + nama);

        if(harga.getTanggal() == null || harga.getTanggal().compareTo("")==0){
            tanggal="";
        }else{
            tanggal = harga.getTanggal();
        }

        holder.texttanggal.setText("Tanggal: " + tanggal);

        if(harga.getSatuan() == null || harga.getSatuan().compareTo("")==0){
            satuan="";
        }else{
            satuan = harga.getSatuan();
        }

        holder.textsatuan.setText("Satuan : " + satuan);

        if(harga.getNilai() == null || harga.getNilai().compareTo("")==0){
            nilai="";
        }else{
            nilai = harga.getNilai();
        }

        holder.textharga.setText("Harga : Rp " + nilai);

        holder.cardview.setOnClickListener(view -> {
            onClicHarga.OnClickHarga(harga.getHashId());
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
        TextView textkomoditas;
        TextView texttanggal;
        TextView textsatuan;
        TextView textharga;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textkomoditas = (TextView)itemView.findViewById(R.id.komoditas);
            texttanggal = (TextView)itemView.findViewById(R.id.tanggal);
            textharga = (TextView)itemView.findViewById(R.id.harga);
            textsatuan = (TextView)itemView.findViewById(R.id.satuan);
            cardview = (CardView) itemView.findViewById(R.id.hargaCardView);
        }
    }
    public void animateTo(List<HargaRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<HargaRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final HargaRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<HargaRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final HargaRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, HargaRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<HargaRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final HargaRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final HargaRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
