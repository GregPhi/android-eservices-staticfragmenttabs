package android.eservices.staticfragmenttabs;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

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
}
