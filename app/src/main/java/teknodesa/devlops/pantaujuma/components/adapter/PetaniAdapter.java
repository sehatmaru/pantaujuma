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
import io.realm.Sort;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

/**
 * Created by Marthin on 10/13/2017.
 */

public class PetaniAdapter extends RecyclerView.Adapter<PetaniAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<PetaniRealm> listData;
    private List<PendudukRealm> listPenduduk;
    PendudukRealm penduduk;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPetaniListener onClicPetani;

    public PetaniAdapter(Context context, List<PetaniRealm> listData, OnClickPetaniListener onClicPetani) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPetani = onClicPetani;
    }

    public interface OnClickPetaniListener {
        void OnClickPetani(String idPetani);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_petani, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PetaniRealm petani = listData.get(position);
        String biodata = petani.getBiodata();

        PendudukRealm penduduk = realm.where(PendudukRealm.class).equalTo("hashId", biodata).findFirst();

        holder.textname.setText(penduduk.getNamaDepan()+" "+ penduduk.getNamaBelakang());
        holder.textnik.setText(penduduk.getNIK());
        holder.textjk.setText(penduduk.getJenisKelamin());
        holder.textttl.setText(penduduk.getTempatLahir()+", "+penduduk.getTanggalLahir());
        holder.cardview.setOnClickListener(view -> {
            onClicPetani.OnClickPetani(petani.getHashId());
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
        TextView textname;
        TextView textnik;
        TextView textjk;
        TextView textttl;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textnik = (TextView)itemView.findViewById(R.id.nik);
            textjk = (TextView)itemView.findViewById(R.id.jenisKelamin);
            textttl = (TextView)itemView.findViewById(R.id.ttl);
            cardview = (CardView) itemView.findViewById(R.id.petaniCardView);
        }
    }
    public void animateTo(List<PetaniRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PetaniRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PetaniRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PetaniRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PetaniRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PetaniRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PetaniRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PetaniRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PetaniRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
