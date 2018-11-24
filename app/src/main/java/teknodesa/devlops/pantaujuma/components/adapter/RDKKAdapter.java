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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class RDKKAdapter extends RecyclerView.Adapter<RDKKAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<RDKKPupukSubsidiRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickRDKKListener onClicRDKK;

    public RDKKAdapter(Context context, List<RDKKPupukSubsidiRealm> listData, OnClickRDKKListener onClicRDKK) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicRDKK = onClicRDKK;
    }

    public interface OnClickRDKKListener {
        void OnClickRDKK(String idRDKK);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rdkk, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RDKKPupukSubsidiRealm rdkk = listData.get(position);
        holder.setIsRecyclable(false);

        String idkomoditas = rdkk.getKomoditas();
        String idpoktan = rdkk.getPoktan();
        String idpetani = rdkk.getPetani();
        String idpupuk = rdkk.getPupuk();

        PoktanRealm poktan = realm.where(PoktanRealm.class).equalTo("hashId", idpoktan).findFirst();
        KomoditasRealm komoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idkomoditas).findFirst();
        PetaniRealm petani = realm.where(PetaniRealm.class).equalTo("hashId", idpetani).findFirst();
        String biodata = null;
        if (petani != null) {
            biodata = petani.getBiodata();
        }
        PendudukRealm penduduk = realm.where(PendudukRealm.class).equalTo("hashId", biodata).findFirst();
        PupukRealm pupuk = realm.where(PupukRealm.class).equalTo("hashId", idpupuk).findFirst();

        if(rdkk.getIsSync() == 0 ){
            holder.cardview.setCardBackgroundColor(Color.CYAN);
        }

        String namaPoktan;
        String namaPetani;
        String namaKomoditas;
        String namaPupuk;

        if(rdkk.getPoktan() == null || rdkk.getPoktan().compareTo("")==0){
            namaPoktan="-";
        }else{
            namaPoktan = poktan.getNama();
        }

        holder.textpoktan.setText("Poktan: " + namaPoktan);

        if(rdkk.getPetani() == null || rdkk.getPetani().compareTo("")==0){
            namaPetani="-";
        }else{
            namaPetani = penduduk.getNamaDepan() + " " + penduduk.getNamaBelakang();
        }

        holder.textpetani.setText("Petani: " + namaPetani);

        if(rdkk.getKomoditas() == null || rdkk.getKomoditas().compareTo("")==0){
            namaKomoditas="-";
        }else{
            namaKomoditas = komoditas.getNama();
        }

        holder.textkomoditas.setText("Komoditas: " + namaKomoditas);

        if(rdkk.getPupuk() == null || rdkk.getPupuk().compareTo("")==0){
            namaPupuk="-";
        }else{
            namaPupuk = pupuk.getNama();
        }

        holder.textpupuk.setText("Pupuk: " + namaPupuk);

        holder.cardview.setOnClickListener(view -> {
            onClicRDKK.OnClickRDKK(rdkk.getHashId());
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
        TextView textpoktan;
        TextView textpetani;
        TextView textkomoditas;
        TextView textpupuk;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textpoktan = (TextView)itemView.findViewById(R.id.poktan);
            textpetani = (TextView)itemView.findViewById(R.id.petani);
            textkomoditas = (TextView)itemView.findViewById(R.id.komoditas);
            textpupuk = (TextView)itemView.findViewById(R.id.pupuk);
            cardview = (CardView) itemView.findViewById(R.id.rdkkCardView);
        }
    }
    public void animateTo(List<RDKKPupukSubsidiRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<RDKKPupukSubsidiRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final RDKKPupukSubsidiRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<RDKKPupukSubsidiRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final RDKKPupukSubsidiRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, RDKKPupukSubsidiRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<RDKKPupukSubsidiRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final RDKKPupukSubsidiRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final RDKKPupukSubsidiRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
