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
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<TargetPetugas> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickTargetListener onClicTarget;

    public TargetAdapter(Context context, List<TargetPetugas> listData, OnClickTargetListener onClicTarget) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicTarget =onClicTarget;
    }

    public interface OnClickTargetListener {
        void OnClickTarget(String idTarget);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_target, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TargetPetugas targetPetugas = listData.get(position);

        KomoditasRealm komoditasRealm = realm.where(KomoditasRealm.class)
                .equalTo("hashId", targetPetugas.getKomoditas())
                .findFirst();

        if(targetPetugas.getIsSync() == 0 ){
            holder.cardview.setCardBackgroundColor(Color.CYAN);
        }

        String komoditas;

        if(targetPetugas.getKomoditas() == null || targetPetugas.getKomoditas().compareTo("")==0){
            komoditas="";
        }else{
            komoditas = komoditasRealm.getNama();
        }

        holder.textkomoditas.setText(komoditas);

        String keterangan;
        if(targetPetugas.getKeterangan() == null || targetPetugas.getKeterangan().compareTo("")==0){
            keterangan="";
        }else{
            keterangan = targetPetugas.getKeterangan();
        }

        holder.textketerangan.setText("Keterangan: " + keterangan);
        holder.cardview.setOnClickListener(view -> {
            onClicTarget.OnClickTarget(targetPetugas.getHashId());
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
        TextView textketerangan;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textkomoditas = (TextView)itemView.findViewById(R.id.komoditas);
            textketerangan = (TextView)itemView.findViewById(R.id.keterangan);
            cardview = (CardView) itemView.findViewById(R.id.targetCardView);
        }
    }
    public void animateTo(List<TargetPetugas> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<TargetPetugas> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final TargetPetugas model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<TargetPetugas> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final TargetPetugas model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, TargetPetugas model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<TargetPetugas> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final TargetPetugas model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final TargetPetugas model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
