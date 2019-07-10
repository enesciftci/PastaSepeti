package com.example.ibrahimenescifti.pastasepeti.PastaneIcerik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.R;

import java.util.ArrayList;
import java.util.List;

public class PastaneIcerik extends AppCompatActivity {
public static  String pastaneId;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
   public static ArrayList urunler=new ArrayList();
   ListView urunlerList;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pastane_icerik);
    urunlerList=findViewById(R.id.pastaneIcerikMenuListView);
    try {
        Intent intent = getIntent();
        pastaneId = intent.getStringExtra("id");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
        pastaSepetiDAL.PastaneIcerikGetirCalistir(pastaneId);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
    private void setupViewPager(ViewPager viewPager) {
    try {
        PastaneIcerikAdapter adapter = new PastaneIcerikAdapter(getSupportFragmentManager());

        adapter.addFragment(new PastaneIcerikMenuFragment(), "Menü");
        adapter.addFragment(new PastaneIcerikYorumlarFragment(), "Yorumlar");
        viewPager.setAdapter(adapter);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }
}

 class PastaneIcerikAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public PastaneIcerikAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
