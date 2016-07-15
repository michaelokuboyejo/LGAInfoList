package com.android.lgas.lgainfolist.entitities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Okuboyejo on 7/15/16.
 * Phase Shift Labs
 * mykelokuboyejo@gmail.com
 */
public class LocalGovernmentArea {
  private InputStream inputStream;

  public LocalGovernmentArea(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public List<LocalGovernmentAreaInfo> list(){
    List<LocalGovernmentAreaInfo> resultList = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    try {
      String csvLine;
      while ((csvLine = reader.readLine()) != null) {
        String[] row = csvLine.split(",");
        resultList.add(new LocalGovernmentAreaInfo(row[0], row[1], row[2], row[3], row[4]));
      }
    }
    catch (IOException ex) {
      throw new RuntimeException("Error in reading CSV file: "+ex);
    }
    finally {
      try {
        inputStream.close();
      }
      catch (IOException e) {
        throw new RuntimeException("Error while closing input stream: "+e);
      }
    }
    return resultList;
  }
}
