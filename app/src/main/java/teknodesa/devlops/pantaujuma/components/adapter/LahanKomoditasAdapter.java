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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;

/**
 * Created by Marthin on 8/2/2018.
 */

public class LahanKomoditasAdapter extends RecyclerView.Adapter<LahanKomoditasAdapter.MyViewHolder> {

    private List<RiwayatLahanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickKomoditasListener onClick;

    public LahanKomoditasAdapter(Context context, List<RiwayatLahanRealm> listData, OnClickKomoditasListener onClick) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClick =onClick;
    }

    public interface OnClickKomoditasListener {
        void OnClickKomoditas(RiwayatLahanRealm riwayatLahanRealm);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_komoditas_lahan, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        RiwayatLahanRealm data = listData.get(position);
//        holder.namaPemilikLahan.setText(""+data.getNamaPemilikLahan());
//        holder.alamatLahan.setText(""+data.getAlamat());
//        holder.tanggalMulaiLahan.setText(""+data.getTanggalMulai());
//        holder.tanggalAkhirLahan.setText(""+data.getTanggalAkhir());
//        holder.tanggalMasaKegiatan.setText(""+data.getMasaKegiatan());
//        holder.luas.setText(""+data.getLuas());
//        holder.cardView.setOnClickListener(view -> {
//            onClick.OnClickKomoditas(data);
//        });
//
//    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namaPemilikLahan;
        TextView alamatLahan;
        TextView tanggalMulaiLahan;
        TextView tanggalAkhirLahan;
        TextView tanggalMasaKegiatan;
        TextView luas;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            namaPemilikLahan = itemView.findViewById(R.id.namaPemilikLahan);
            alamatLahan = itemView.findViewById(R.id.alamatLahan);
            tanggalMulaiLahan = itemView.findViewById(R.id.tanggalMulaiLahan);
            tanggalAkhirLahan = itemView.findViewById(R.id.tanggalAkhirLahan);
            tanggalMasaKegiatan = itemView.findViewById(R.id.tanggalMasaKegiatan);
            luas = itemView.findViewById(R.id.luas);
            cardView =  itemView.findViewById(R.id.cardView);
        }
    }

    public void animateTo(List<RiwayatLahanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<RiwayatLahanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final RiwayatLahanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<RiwayatLahanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final RiwayatLahanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, RiwayatLahanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<RiwayatLahanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final RiwayatLahanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final RiwayatLahanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
