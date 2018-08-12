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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class RKTPAdapter extends RecyclerView.Adapter<RKTPAdapter.MyViewHolder> {

    private List<RKTPRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickRKTPListener onClicRKTP;

    public RKTPAdapter(Context context, List<RKTPRealm> listData, OnClickRKTPListener onClicRKTP) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicRKTP =onClicRKTP;
    }

    public interface OnClickRKTPListener {
        void OnClickRKTP(String idRKTP);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rktp , parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RKTPRealm RKTPRealm = listData.get(position);
        holder.textpenanggungjawab.setText(RKTPRealm.getPelaksana());
        holder.texttujuan.setText(String.valueOf(RKTPRealm.getTujuan()));
        holder.cardview.setOnClickListener(view -> {
            onClicRKTP.OnClickRKTP(RKTPRealm.getHashId());
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
        TextView textpenanggungjawab;
        TextView texttujuan;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textpenanggungjawab = (TextView)itemView.findViewById(R.id.penanggungjawab);
            texttujuan = (TextView)itemView.findViewById(R.id.tujuan);
            cardview = (CardView) itemView.findViewById(R.id.rktpCardView);
        }
    }
    public void animateTo(List<RKTPRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<RKTPRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final RKTPRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<RKTPRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final RKTPRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, RKTPRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<RKTPRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final RKTPRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final RKTPRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
