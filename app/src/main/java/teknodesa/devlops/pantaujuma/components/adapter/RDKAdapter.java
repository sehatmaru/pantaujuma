package teknodesa.devlops.pantaujuma.components.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class RDKAdapter extends RecyclerView.Adapter<RDKAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<RDKRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private RDKAdapter.OnClickRDKListener onClicRDK;

    public RDKAdapter(Context context, List<RDKRealm> listData, RDKAdapter.OnClickRDKListener onClicRDK) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicRDK = onClicRDK;
    }

    public interface OnClickRDKListener {
        void OnClickRDK(String idRDK);
    }

    @Override
    public RDKAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rdk, parent, false);
        return new RDKAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RDKAdapter.MyViewHolder holder, int position) {
        RDKRealm rdk = listData.get(position);
        String idpoktan = rdk.getPoktan();

        PoktanRealm poktan = realm.where(PoktanRealm.class).equalTo("hashId", idpoktan).findFirst();

        if(rdk.getIsSync() == 0 ){
            holder.cardview.setCardBackgroundColor(Color.CYAN);
        }

        String nama;
        String tanggal;
        String keterangan;

        if(rdk.getPoktan() == null || rdk.getPoktan().compareTo("")==0){
            nama="";
        }else{
            nama = poktan.getNama();
        }

        holder.textnama.setText(nama);

        if(rdk.getTanggal() == null || rdk.getTanggal().compareTo("")==0){
            tanggal="";
        }else{
            tanggal = rdk.getTanggal();
        }

        holder.texttanggal.setText("Tanggal: " + tanggal);

        if(rdk.getKeterangan() == null || rdk.getKeterangan().compareTo("")==0){
            keterangan="-";
        }else{
            keterangan = rdk.getKeterangan();
        }

        holder.textketerangan.setText("Keterangan: " + keterangan);

        holder.cardview.setOnClickListener(view -> {
            onClicRDK.OnClickRDK(rdk.getHashId());
            Log.e("ini detail rdk", rdk.toString());
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
        TextView texttanggal;
        TextView textketerangan;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            textketerangan = (TextView)itemView.findViewById(R.id.keterangan);
            texttanggal = (TextView)itemView.findViewById(R.id.tanggal);
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
