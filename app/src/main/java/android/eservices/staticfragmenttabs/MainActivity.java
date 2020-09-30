package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int currentCounter=0;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPagerAndTabs();
        counterTextView = findViewById(R.id.counter_textview);
        Resources res = getResources();
        counterTextView.setText(String.format(res.getString(R.string.counter_text), this.currentCounter));
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle tragment change inside
        //viewpager.setAdapter(...);

        viewPager = findViewById(R.id.tab_viewpager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch(position){
                    case 0:
                        return FragmentOne.newInstance();
                    case 1:
                        return FragmentTwo.newInstance();
                    default:
                        return null;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch(position){
                    case 0:
                        return FragmentOne.TAB_NAME;
                    case 1:
                        return FragmentTwo.TAB_NAME;
                    default:
                        return null;
                }
            }
        });
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
