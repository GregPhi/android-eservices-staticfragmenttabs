package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends FragmentActivity implements DataToPass {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private int currentCounter;
    private TextView counterTextView;
    private Resources res;
    private String[] tabTitles = new String[]{FragmentOne.TAB_NAME,FragmentTwo.TAB_NAME};

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
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
         new TabLayoutMediator(tabLayout, viewPager,
                 new TabLayoutMediator.TabConfigurationStrategy() {
                     @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                         tab.setText(tabTitles[position]);
                     }
                 }).attach();
    }

    @Override
    public void dataPass(int data) {
        this.currentCounter += data;
        counterTextView.setText(String.format(this.res.getString(R.string.counter_text), this.currentCounter));
    }
}
