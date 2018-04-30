package teknodesa.devlops.pantaujuma.components.post;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;

public class PostAdapter  extends RealmRecyclerViewAdapter<PostRealm, PostAdapter.MyViewHolder> {

    private Context mContext;
    private RealmList<PostRealm> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.count)
        TextView count;
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.overflow)
        ImageView overflow;

        public MyViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }

    public PostAdapter(RealmResults<PostRealm> dataList) {
        super(dataList, true);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_post, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final PostRealm obj = getItem(position);

        String strJudul = obj.getJudul();
        String strCount = obj.getViewCount();
        String strThumbnail = obj.getThumbnail();
        //Log.d("HORAS", idPemain+" "+nmDepan+" "+nmBelakang);

        holder.title.setText(" "+strJudul);
        holder.count.setText(strCount+" view(s)");
        // loading album cover using Glide library
        Glide.with(mContext).load(strThumbnail).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_post, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, mContext.getString(R.string.action_add_favourite), Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_read_next:
                    Toast.makeText(mContext, mContext.getString(R.string.action_read_next), Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}