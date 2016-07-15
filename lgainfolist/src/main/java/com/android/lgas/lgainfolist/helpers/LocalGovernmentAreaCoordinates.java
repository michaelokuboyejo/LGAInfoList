package com.android.lgas.lgainfolist.helpers;

import android.app.Activity;
import com.android.lgas.lgainfolist.R;
import com.android.lgas.lgainfolist.entitities.LocalGovernmentArea;
import com.android.lgas.lgainfolist.entitities.LocalGovernmentAreaInfo;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Michael Okuboyejo on 7/15/16.
 * Phase Shift Labs
 * mykelokuboyejo@gmail.com
 */
public class LocalGovernmentAreaCoordinates {
  public LocalGovernmentAreaCoordinates(){}

  public static List<LocalGovernmentAreaInfo> getLocalGovernmentAreasList(Activity activity){
    InputStream inputStream = activity.getResources().openRawResource(R.raw.local_government_areas);
    LocalGovernmentArea localGovernmentAreas = new LocalGovernmentArea(inputStream);
    return localGovernmentAreas.list();

  }
}
