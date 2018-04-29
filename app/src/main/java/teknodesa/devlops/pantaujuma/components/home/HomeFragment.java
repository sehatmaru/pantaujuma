package teknodesa.devlops.pantaujuma.components.home;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;

public class HomeFragment extends Fragment {
    FragmentActivity activity;

    @BindView(R.id.homeCoordinatorLayout)
    CoordinatorLayout coordinatorLayout;

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

        return v;
    }
}