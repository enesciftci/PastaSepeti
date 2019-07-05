package com.example.ibrahimenescifti.pastasepeti;

import android.app.Activity;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter {


//Listviewe sub item eklemek için açıldı

    private final Activity context;
    private final String[] pastaneAdiArray;
    private final Integer[] resimIdArray;

    private final String[] puanArray;

    private final String[] minFiyatArray;

public CustomAdapter(Activity context, String[]pastaneAdiArray, Integer[] resimIdArray
,String []puanArray,String []minFiyatArray)
{
    super(context,R.layout.fragment_anasayfa,pastaneAdiArray);
    this.context=context;
    this.resimIdArray=resimIdArray;
    this.minFiyatArray=minFiyatArray;
    this.pastaneAdiArray=pastaneAdiArray;
    this.puanArray=puanArray;
}
}