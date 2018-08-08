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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class FragmentPoktanAdapter extends RecyclerView.Adapter<FragmentPoktanAdapter.MyViewHolder> {

    private List<PoktanRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPoktanListener onClicPoktan;

    public FragmentPoktanAdapter(Context context, List<PoktanRealm> listData, OnClickPoktanListener onClicPoktans) {
        mContext =context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPoktan =onClicPoktans;
    }

    public interface OnClickPoktanListener {
        void OnClickPoktan(String idPoktan, String nama, String deskripsi);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_search_poktan, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PoktanRealm poktan = listData.get(position);
        holder.textname.setText(poktan.getNama());
        //holder.textnik.setText(poktan.getDesa());
        holder.textnik.setText("");
        holder.cardview.setOnClickListener(view -> { onClicPoktan.OnClickPoktan(poktan.getHashId(),poktan.getNama(), poktan.getDeskripsi());});

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
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.nama);
            textnik = (TextView)itemView.findViewById(R.id.nik);
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