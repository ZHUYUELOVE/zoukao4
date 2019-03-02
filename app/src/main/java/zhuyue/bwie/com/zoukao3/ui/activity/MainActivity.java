package zhuyue.bwie.com.zoukao3.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import zhuyue.bwie.com.zoukao3.R;
import zhuyue.bwie.com.zoukao3.fragment.CircleFragment;
import zhuyue.bwie.com.zoukao3.fragment.HomeFragment;
import zhuyue.bwie.com.zoukao3.fragment.ListFragment;
import zhuyue.bwie.com.zoukao3.fragment.MyFragment;
import zhuyue.bwie.com.zoukao3.fragment.ShoppFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vp.setCurrentItem(0);
                    return true;
                case R.id.navigation_circle:
                    vp.setCurrentItem(1);
                    return true;
                case R.id.navigation_shopp:
                    vp.setCurrentItem(2);
                    return true;
                case R.id.navigation_list:
                    vp.setCurrentItem(3);
                    return true;
                case R.id.navigation_my:
                    vp.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };
    private ViewPager vp;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        vp = findViewById(R.id.vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_circle);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_shopp);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_list);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.navigation_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new CircleFragment();

                    case 2:
                        return new ShoppFragment();

                    case 3:
                        return new ListFragment();
                    case 4:
                        return new MyFragment();




                }


                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

    }

}
