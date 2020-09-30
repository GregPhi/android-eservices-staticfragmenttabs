package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "REMOVE TO COUNTER";

    public FragmentTwo() {
        //TODO
    }

    public static FragmentTwo newInstance() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO
        View view =  inflater.inflate(R.layout.fragment_two,container,false);
        /*Button increment = (Button)view.findViewById(R.id.button_increment);
        increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

            }
        });*/
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

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
