package teknodesa.devlops.pantaujuma.components.lahan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;

public class CRUKegiatanPengeringanFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_kegiatanpengeringan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }
}
