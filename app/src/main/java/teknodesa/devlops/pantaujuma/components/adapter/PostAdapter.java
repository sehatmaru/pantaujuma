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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    @Inject
    Realm realm;

    private List<PostRealm> listData;
    private LayoutInflater layoutInflater;
    public static Context mContext;
    private OnClickPostListener onClicPost;

    public PostAdapter(Context context, List<PostRealm> listData, OnClickPostListener onClicPost) {
        mContext = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.onClicPost =onClicPost;
    }

    public interface OnClickPostListener {
        void OnClickPost(String idPost);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_post , parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PostRealm postRealm = listData.get(position);
        holder.textjudul.setText(postRealm.getJudul());
        holder.textnama.setText(postRealm.getNamaUser());
        holder.cardview.setOnClickListener(view -> {
            onClicPost.OnClickPost(postRealm.getHashId());
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
        TextView textjudul;
        TextView textnama;
        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            textjudul = (TextView)itemView.findViewById(R.id.judul);
            textnama = (TextView)itemView.findViewById(R.id.nama);
            cardview = (CardView) itemView.findViewById(R.id.postCardView);
        }
    }
    public void animateTo(List<PostRealm> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }
    private void applyAndAnimateRemovals(List<PostRealm> newModels) {
        for (int i = listData.size() - 1; i >= 0; i--) {
            final PostRealm model = listData.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<PostRealm> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final PostRealm model = newModels.get(i);
            if (!listData.contains(model)) {
                addItem(i, model);
            }
        }
    }
    public void addItem(int position, PostRealm model) {
        listData.add(position, model);
        notifyItemInserted(position);
    }
    private void applyAndAnimateMovedItems(List<PostRealm> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final PostRealm model = newModels.get(toPosition);
            final int fromPosition = listData.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public void moveItem(int fromPosition, int toPosition) {
        final PostRealm model = listData.remove(fromPosition);
        listData.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
