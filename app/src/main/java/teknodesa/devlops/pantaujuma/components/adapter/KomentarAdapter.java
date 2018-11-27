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
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<KomentarRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;

    public KomentarAdapter(Context context, List<KomentarRealm> listData) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_komentar , parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        KomentarRealm komentarRealm = listData.get(position);
        holder.textnama.setText(komentarRealm.getNamaUser());
        holder.textkomentar.setText(komentarRealm.getDeskripsi());
        holder.textdate.setText(komentarRealm.getTanggal());
        holder.texttime.setText(komentarRealm.getWaktu());
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
        TextView textkomentar;
        TextView textdate;
        TextView texttime;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            textkomentar = (TextView)itemView.findViewById(R.id.komentar);
            textdate = (TextView)itemView.findViewById(R.id.date);
            texttime = (TextView)itemView.findViewById(R.id.time);
            cardview = (CardView) itemView.findViewById(R.id.komentarCardView);
        }
    }
    public void animateTo(List<KomentarRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<KomentarRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final KomentarRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<KomentarRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final KomentarRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, KomentarRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<KomentarRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final KomentarRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final KomentarRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
