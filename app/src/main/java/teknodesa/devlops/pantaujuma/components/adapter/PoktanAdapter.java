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
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

/**
 * Created by Marthin on 10/13/2017.
 */

public class PoktanAdapter extends RecyclerView.Adapter<PoktanAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<PoktanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPoktanListener onClicPoktan;

    public PoktanAdapter(Context context, List<PoktanRealm> listData, OnClickPoktanListener onClicPoktan) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPoktan = onClicPoktan;
    }

    public interface OnClickPoktanListener {
        void OnClickPoktan(String idPoktan);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainApplication) mContext.getApplicationContext())
                .getComponent()
                .inject(this);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_poktan, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PoktanRealm poktan = listData.get(position);

        holder.textnama.setText(poktan.getNama());
        holder.textdesa.setText("Didiikan: " + poktan.getTanggalDidirikan());
        holder.textnohp.setText("Alamat: " + poktan.getAlamat());
        holder.cardview.setOnClickListener(view -> {
            onClicPoktan.OnClickPoktan(poktan.getHashId());
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
        TextView textdesa;
        TextView textnohp;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            textdesa = (TextView)itemView.findViewById(R.id.desa);
            textnohp = (TextView)itemView.findViewById(R.id.nohp);
            cardview = (CardView) itemView.findViewById(R.id.poktanCardView);
        }
    }
    public void animateTo(List<PoktanRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PoktanRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PoktanRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PoktanRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PoktanRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PoktanRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PoktanRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PoktanRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PoktanRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
