package teknodesa.devlops.pantaujuma.components.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.ListDataActivity;

public class HomeJumaFragment extends Fragment {
    FragmentActivity activity;

    @BindView(R.id.btnPetani)
    Button continueCheckOut;
    @OnClick(R.id.btnPetani)
    void clickCheckOut(){
        startActivity(ListDataActivity.createIntent(getContext(), "petani"));
    }


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

        View v = inflater.inflate(R.layout.fragment_homejuma, container, false);
        ButterKnife.bind(this, v);

        return v;
    }
}