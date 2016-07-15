package com.android.lgas.lgainfolist.entitities;

import java.io.Serializable;

/**
 * Created by Michael Okuboyejo on 7/15/16.
 * Phase Shift Labs
 * mykelokuboyejo@gmail.com
 */
public class LocalGovernmentAreaInfo implements Serializable {

  String name;
  String latitude;
  String longitude;
  String state;
  String stateCode;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public LocalGovernmentAreaInfo(String stateCode, String state,String name,   String latitude, String longitude) {
    this.name = name;
    this.state = state;
    this.stateCode = stateCode;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}
