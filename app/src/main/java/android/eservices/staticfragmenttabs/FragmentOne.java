package android.eservices.staticfragmenttabs;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment {
    public static final String TAB_NAME = "ADD TO COUNTER";

    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_one,container,false);
        Button button = view.findViewById(R.id.button_increment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataToPass(1);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    DataToPass dataPass;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPass = (DataToPass) context;
    }

    public void setDataToPass(int data){
        dataPass.dataPass(data);
    }
}
