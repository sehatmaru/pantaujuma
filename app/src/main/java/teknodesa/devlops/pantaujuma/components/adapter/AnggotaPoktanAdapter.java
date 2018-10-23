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

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.R;

/**
 * Created by Marthin on 7/18/2018.
 */

public class AnggotaPoktanAdapter extends RecyclerView.Adapter<AnggotaPoktanAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    public static Context mContext;
    private List<AnggotaPoktanRealm> listData;
    private LayoutInflater layoutInflater;

    public AnggotaPoktanAdapter(Context context, List<AnggotaPoktanRealm> listData) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public AnggotaPoktanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_anggotapoktan, parent, false);
        return new AnggotaPoktanAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnggotaPoktanAdapter.MyViewHolder holder, int position) {
        AnggotaPoktanRealm anggotaPoktan = listData.get(position);
        String idPetani = anggotaPoktan.getPetaniAnggota();

        PetaniRealm petani = realm.where(PetaniRealm.class)
                .equalTo("hashId", idPetani)
                .findFirst();

        String idPenduduk = petani.getBiodata();

        PendudukRealm penduduk = realm.where(PendudukRealm.class)
                .equalTo("hashId", idPenduduk)
                .findFirst();

        holder.textname.setText(penduduk.getNamaDepan()+" "+ penduduk.getNamaBelakang());
        holder.textnik.setText(penduduk.getNIK());
        holder.texttanggal.setText("Masuk : " + anggotaPoktan.getTanggalMasuk());
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
        TextView texttanggal;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textnik = (TextView)itemView.findViewById(R.id.nik);
            texttanggal = (TextView)itemView.findViewById(R.id.tanggal);
            cardview = (CardView) itemView.findViewById(R.id.pendudukCardView);
        }
    }

    public void animateTo(List<AnggotaPoktanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<AnggotaPoktanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final AnggotaPoktanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<AnggotaPoktanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final AnggotaPoktanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, AnggotaPoktanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<AnggotaPoktanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final AnggotaPoktanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final AnggotaPoktanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
