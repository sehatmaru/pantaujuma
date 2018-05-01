package teknodesa.devlops.pantaujuma.components;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;

public class CRUActivity extends Activity {
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.btnAction)
    Button btnAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cru);
        ButterKnife.bind(this);
    }
}
