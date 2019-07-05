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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ibrahimenescifti.pastasepeti.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.R;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class PastaneIcerik extends AppCompatActivity {
PastaSepetiDAL pastaSepetiDAL=new PastaSepetiDAL();
PastaneIcerikModel pastaneIcerikModel=new PastaneIcerikModel();
ArrayAdapter icerikAdapter;
ArrayList<String >icerikArray=new ArrayList<>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pastane_icerik);

    toolbar =  findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    viewPager =  findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    tabLayout =findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);

    Intent intent = getIntent();
    String pastaneId = intent.getStringExtra("id");
    System.out.println(pastaneId+"+++++++++++++++");
    pastaSepetiDAL.PastaneIcerikGetirCalistir(pastaneId);
    try {
        Thread.sleep(1500);
    } catch (Exception e) {
        e.printStackTrace();
    }
    ListView pastaneIcerikListView = findViewById(R.id.pastaneIcerikListView);

    try {
        for (int i = 0; i < PastaSepetiDAL.PastaneIcerikList.size(); i++) {
            ObjectMapper mapper = new ObjectMapper();
            pastaneIcerikModel = mapper.readValue(PastaSepetiDAL.PastaneIcerikList.get(i), PastaneIcerikModel.class);
            icerikArray.add(pastaneIcerikModel.getUrunAdi());
            System.out.println(icerikArray.get(i));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    icerikAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, icerikArray);
//    pastaneIcerikListView.setAdapter(icerikAdapter);
}
    private void setupViewPager(ViewPager viewPager) {
        PastaneIcerikAdapter adapter = new PastaneIcerikAdapter(getSupportFragmentManager());
        adapter.addFragment(new PastaneIcerikMenuFragment(), "ONE");
        viewPager.setAdapter(adapter);
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
