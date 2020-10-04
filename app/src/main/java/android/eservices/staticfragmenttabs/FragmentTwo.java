package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "REMOVE TO COUNTER";

    public static FragmentTwo newInstance() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button decrement = (Button) view.findViewById(R.id.button_decrement);
        decrement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setDataToPass(-1);
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
