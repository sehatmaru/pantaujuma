package teknodesa.devlops.pantaujuma.components.harga;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.lahan.DetailLahanFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.AlamatFragment;


public class CRUHargaFragment extends Fragment {
    FragmentActivity activity;

    DetailLahanFragment detailLahanFragment;
    AlamatFragment alamatFragment;
    CRUHargaFragment.ViewPagerAdapter adapter;

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crulahan, container, false);
        ButterKnife.bind(this, v);

        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);
        //viewPager.getCurrentItem();
        return v;
    }

    private void setupTabIcons() {
        //Pager Detail Lahan
        TextView tabPenduduk = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabPenduduk.setText("Detail Lahan");
        tabPenduduk.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(0).setCustomView(tabPenduduk).setIcon(R.drawable.penduduk);

        //Pager Alamat
        TextView tabAlamat = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabAlamat.setText("Alamat");
        tabAlamat.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(1).setCustomView(tabAlamat).setIcon(R.drawable.alamat);
    }
    private void setViewpager() {
        detailLahanFragment = new DetailLahanFragment();
        alamatFragment = new AlamatFragment();

        adapter = new CRUHargaFragment.ViewPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(detailLahanFragment);
        adapter.addFragment(alamatFragment);

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.viewPager, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
