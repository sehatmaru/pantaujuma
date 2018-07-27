package teknodesa.devlops.pantaujuma.components.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.adapter.ImageSlideAdapter;
import teknodesa.devlops.pantaujuma.components.alsintan.ListAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.harga.ListHargaActivity;
import teknodesa.devlops.pantaujuma.components.komoditas.ListKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.ListPoktanActivity;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.ListRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rktp.ListRKTPActivity;
import teknodesa.devlops.pantaujuma.components.survei.ListSurveiActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;
import teknodesa.devlops.pantaujuma.utils.pageindicator.CheckNetworkConnection;
import teknodesa.devlops.pantaujuma.utils.pageindicator.CirclePageIndicator;
import teknodesa.devlops.pantaujuma.utils.pageindicator.PageIndicator;

public class HomeFragment extends Fragment implements HomeContract.View{
    FragmentActivity activity;

    @BindView(R.id.homeCoordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Inject
    HomeController mController;

    //Penduduk
    @BindView(R.id.btnPenduduk)
    Button btnPenduduk;
    @OnClick(R.id.btnPenduduk)
    void clickListPenduduk(){startActivity(ListPendudukActivity.createIntent(getContext()));}

    //Petani
    @BindView(R.id.btnPetani)
    Button btnPetani;
    @OnClick(R.id.btnPetani)
    void clickListPetani(){
        startActivity(ListPetaniActivity.createIntent(getContext()));
    }

    //Poktan
    @BindView(R.id.btnPoktan)
    Button btnPoktan;
    @OnClick(R.id.btnPoktan)
    void clickListPoktan(){
        startActivity(ListPoktanActivity.createIntent(getContext()));
    }

    //RDK
    @BindView(R.id.btnRDK)
    Button btnRDK;
    @OnClick(R.id.btnRDK)
    void clickListRDK(){
        startActivity(ListRDKActivity.createIntent(getContext()));
    }

    //RDKK
    @BindView(R.id.btnRDKK)
    Button btnRDKK;
    @OnClick(R.id.btnRDKK)
    void clickListRDKK(){
        startActivity(ListRDKKActivity.createIntent(getContext()));
    }

    //RKTP
    @BindView(R.id.btnRKTP)
    Button btnRKTP;
    @OnClick(R.id.btnRKTP)
    void clickListRKTP(){
        startActivity(ListRKTPActivity.createIntent(getContext()));
    }

    //Target
    @BindView(R.id.btnTarget)
    Button btnTarget;
    @OnClick(R.id.btnTarget)
    void clickListTarget(){
        startActivity(ListTargetActivity.createIntent(getContext()));
    }
    //Lahan
    @BindView(R.id.btnLahan)
            Button btnLahan;
    @OnClick(R.id.btnLahan)
    void clickListLahan(){
        startActivity(ListLahanActivity.createIntent(getContext()));
    }
    //Komoditas
    @BindView(R.id.btnKomoditas)
            Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickListKomoditas(){
        startActivity(ListKomoditasActivity.createIntent(getContext()));
    }
    //Alsintan
    @BindView(R.id.btnAlsintan)
    Button btnAlsintan;
    @OnClick(R.id.btnAlsintan)
    void clickListAlsintan(){
        startActivity(ListAlsintanActivity.createIntent(getContext()));
    }
    //Harga
    @BindView(R.id.btnHarga)
    Button btnHarga;
    @OnClick(R.id.btnHarga)
    void clickListHarga(){
        startActivity(ListHargaActivity.createIntent(getContext()));
    }

    //Survei
    @BindView(R.id.btnSurvei)
    Button btnSurvei;
    @OnClick(R.id.btnSurvei)
    void clickListSurvei(){
        startActivity(ListSurveiActivity.createIntent(getContext()));
    }


    //Slider
    private static final long ANIM_VIEWPAGER_DELAY = 5000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 10000;
    AlertDialog alertDialog;
    PageIndicator mIndicator;
    private Runnable animateViewPager;
    private Handler handler;
    boolean stopSliding = false;
    List<Promotion> products;
    RequestImgTask task;
    String message;
    ViewPager mViewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);
        mViewPager = (ViewPager)v.findViewById(R.id.view_pager);
        mIndicator = (CirclePageIndicator) v.findViewById(R.id.indicator);
        mController.setView(this);
        mController.getPromotion();
        return v;
    }

    @Override
    public void resultPromotion(boolean status, List<Promotion> item) {
        products= new ArrayList<Promotion>();
        for(int a=0;a<item.size();a++){
            products.add(item.get(a));
        }
        mIndicator.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnTouchListener((v, event) -> {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            switch (event.getAction()) {

                case MotionEvent.ACTION_CANCEL:
                    break;

                case MotionEvent.ACTION_UP:
                    // calls when touch release on ViewPager
                    if (products != null && products.size() != 0) {
                        stopSliding = false;
                        runnable(products.size());
                        handler.postDelayed(animateViewPager,
                                ANIM_VIEWPAGER_DELAY_USER_VIEW);
                    }
                    break;

                case MotionEvent.ACTION_MOVE:
                    // calls when ViewPager touch
                    if (handler != null && stopSliding == false) {
                        stopSliding = true;
                        handler.removeCallbacks(animateViewPager);
                    }
                    break;
            }
            return false;
        });
    }
    private class RequestImgTask extends AsyncTask<String, Void, List<Promotion>> {
        private final WeakReference<Activity> activityWeakRef;
        Throwable error;

        public RequestImgTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Promotion> doInBackground(String... urls) {

            return products;
        }


        @Override
        protected void onPostExecute(List<Promotion> result) {
            super.onPostExecute(result);

            if (activityWeakRef != null && !activityWeakRef.get().isFinishing()) {
                if (error != null && error instanceof IOException) {
                    message = getResources().getString(R.string.time_out);
                    showAlertDialog(message, true);
                } else if (error != null) {
                    message = getResources().getString(R.string.error_occured);
                    showAlertDialog(message, true);
                } else {
                    products = result;
                    if (result != null) {
                        if (products != null && products.size() != 0) {

                            mViewPager.setAdapter(new ImageSlideAdapter(
                                    activity, products, HomeFragment.this));

                            mIndicator.setViewPager(mViewPager);
                            runnable(products.size());
                            handler.postDelayed(animateViewPager,
                                    ANIM_VIEWPAGER_DELAY);
                        } else {
                            //imgNameTxt.setText("No Products");
                        }
                    } else {
                    }
                }
            }
        }
    }
    public void showAlertDialog(String message, final boolean finish) {
        alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                (dialog, which) -> {
                    dialog.dismiss();
                    if (finish)
                        activity.finish();
                });
        alertDialog.show();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                if (products != null) {

                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
        }
    }
    public void runnable(final int size) {
        handler = new Handler();
        animateViewPager = () -> {
            if (!stopSliding) {
                if (mViewPager.getCurrentItem() == size - 1) {
                    mViewPager.setCurrentItem(0);
                } else {
                    mViewPager.setCurrentItem(
                            mViewPager.getCurrentItem() + 1, true);
                }
                handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
            }
        };
    }
    @Override
    public void onResume() {
        if (products == null) {
            sendRequest();
        } else {
            mViewPager.setAdapter(new ImageSlideAdapter(activity, products,
                    HomeFragment.this));

            mIndicator.setViewPager(mViewPager);
            runnable(products.size());
            handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
        }
        super.onResume();
    }
    private void sendRequest() {
        if (CheckNetworkConnection.isConnectionAvailable(activity)) {
            task = new RequestImgTask(activity);
            task.execute();
        } else {
            //message = getResources().getString(R.string.no_internet_connection);
            showAlertDialog("No internet connection", true);
        }
    }
    @Override
    public void onPause() {
        if (task != null)
            task.cancel(true);
        if (handler != null) {
            //Remove callback
            handler.removeCallbacks(animateViewPager);
        }
        super.onPause();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}