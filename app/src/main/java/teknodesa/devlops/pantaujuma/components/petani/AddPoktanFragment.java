package teknodesa.devlops.pantaujuma.components.petani;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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
import teknodesa.devlops.pantaujuma.components.penduduk.AddPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.AlamatFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.BiodataFragment;

public class AddPoktanFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_addpoktan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }
}
