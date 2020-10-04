package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends FragmentActivity implements DataToPass {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.currentCounter = 0;
        setupViewPagerAndTabs();
        counterTextView = findViewById(R.id.counter_textview);
        this.res = getResources();
        counterTextView.setText(String.format(this.res.getString(R.string.counter_text), this.currentCounter));
    }

     private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void dataPass(int data) {
        this.currentCounter += data;
        counterTextView.setText(String.format(this.res.getString(R.string.counter_text), this.currentCounter));
    }
}
