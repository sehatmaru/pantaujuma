package teknodesa.devlops.pantaujuma.components.poktan;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.poktan.form.AnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.IdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.PengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.AnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.IdentitasPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.PengurusPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class CRUPoktanFragment extends Fragment implements PoktanContract.ViewController<PoktanRealm>, PoktanContract.View {

    IdentitasPoktan identitasData = null;
    AnggotaPoktan anggotaData = null;
    PengurusPoktan pengurusData = null;

    @Inject
    Realm realm;

    private AppComponent appComponent;
    FragmentActivity activity;

    @Inject
    IdentitasPoktanFragment identitasPoktanFragment;

    @Inject
    AnggotaPoktanFragment anggotaPoktanFragment;

    @Inject
    PengurusPoktanFragment pengurusPoktanFragment;

    ViewPagerAdapter adapter;

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupoktan, container, false);
        ButterKnife.bind(this, v);
        
        identitasPoktanFragment = new IdentitasPoktanFragment();
        anggotaPoktanFragment = new AnggotaPoktanFragment();
        pengurusPoktanFragment = new PengurusPoktanFragment();
        
        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);
        //viewPager.getCurrentItem();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    private void setupTabIcons() {
        //Pager Identitas
        TextView tabIdentitas = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabIdentitas.setText("Identitas Poktan");
        tabIdentitas.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(0).setCustomView(tabIdentitas).setIcon(R.drawable.penduduk);

        //Pager Anggota
        TextView tabAnggota = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabAnggota.setText("Anggota Poktan");
        tabAnggota.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(1).setCustomView(tabAnggota).setIcon(R.drawable.alamat);

        //Pager Pengurus
        TextView tabPengurus = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabPengurus.setText("Pengurus Poktan");
        tabPengurus.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(2).setCustomView(tabPengurus).setIcon(R.drawable.alamat);
    }

    private void setViewpager() {
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(identitasPoktanFragment);
        adapter.addFragment(anggotaPoktanFragment);
        adapter.addFragment(pengurusPoktanFragment);

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public PoktanRealm getUIData() {

        identitasData = identitasPoktanFragment.getUIData();
        anggotaData = anggotaPoktanFragment.getUIData();
        pengurusData = pengurusPoktanFragment.getUIData();

        String hashId = getSaltString();

        PoktanRealm newRealmItem = new PoktanRealm();
        newRealmItem.setHashId(hashId);
        newRealmItem.setNama(identitasData.getNama());
        newRealmItem.setDesa(identitasData.getDesa());
        newRealmItem.setKecamatan(identitasData.getKecamatan());
        newRealmItem.setTanggalDidirikan(identitasData.getTanggalDidirikan());
        newRealmItem.setAlamat(identitasData.getAlamat());
        newRealmItem.setNoHP(identitasData.getNoHp());
        newRealmItem.setNoTelp(identitasData.getNoTelp());
        newRealmItem.setDeskripsi(identitasData.getDeskripsi());
        newRealmItem.setPoktanAnggota(hashId);
        newRealmItem.setPetaniAnggota(anggotaData.getPetani());
        newRealmItem.setTanggalMasuk(anggotaData.getTanggalMasuk());
        newRealmItem.setPoktanPengurus(hashId);
        newRealmItem.setPetaniPengurus(pengurusData.getPetani());
        newRealmItem.setJabatan(pengurusData.getJabatan());
        newRealmItem.setPeriode(pengurusData.getPeriode());
        newRealmItem.setIdDesa(AkunFragment.idDesa);

        Log.e("poktan",newRealmItem.toString());
        return newRealmItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PoktanContract.Controller<PoktanRealm> mController = new PoktanController(this, appComponent);
        PoktanRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((PoktanRealm) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListPoktanActivity.createIntent(CRUActivity.mContext));
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

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return timeStamp + "" + salt.toString();
    }
}
