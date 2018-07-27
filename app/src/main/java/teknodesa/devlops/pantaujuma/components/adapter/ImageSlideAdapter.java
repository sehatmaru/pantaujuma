package teknodesa.devlops.pantaujuma.components.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;


public class ImageSlideAdapter extends PagerAdapter {

	FragmentActivity activity;
	List<Promotion> products;
	HomeFragment fragmentHome;

	public ImageSlideAdapter(FragmentActivity activity, List<Promotion> products,
                             HomeFragment fragmentHome) {
		this.activity = activity;
		this.fragmentHome = fragmentHome;
		this.products = products;
	}

	@Override
	public int getCount() {
		return products.size();
	}

	@Override
	public View instantiateItem(ViewGroup container, final int position) {
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.vp_image, container, false);

		ImageView mImageView = (ImageView) view
				.findViewById(R.id.image_display);
		mImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		Glide.with(activity.getApplicationContext()).load(((Promotion) products.get(position)).getImagePromotion()).into(mImageView);

		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

}