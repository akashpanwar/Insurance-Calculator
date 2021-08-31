package com.pepperminzia.utility.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="geographical")
public class Geographical {

    @Id
    private Long geographicalId;
    private String alpha_2;
    private String alpha_2_region_code;
    private String region1;
    private String region2;
    private String region3;
    private String region4;
    private String postalcode;
    private String location;
    private String area1;
    private String area2;
    private String latitude;
    private String longitude;
    private String timezone;
    private String utc;
    private String summertime;
    private String active;

    public Geographical() {
    }

    public Geographical(Long geographicalId, String alpha_2, String alpha_2_region_code, String region1, String region2, String region3,
                        String region4, String postalcode, String location, String area1, String area2, String latitude,
                        String longitude, String timezone, String utc, String summertime, String active) {
        this.geographicalId = geographicalId;
        this.alpha_2 = alpha_2;
        this.alpha_2_region_code = alpha_2_region_code;
        this.region1 = region1;
        this.region2 = region2;
        this.region3 = region3;
        this.region4 = region4;
        this.postalcode = postalcode;
        this.location = location;
        this.area1 = area1;
        this.area2 = area2;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.utc = utc;
        this.summertime = summertime;
        this.active = active;
    }

    public Long getGeographicalId() {
        return geographicalId;
    }

    public void setGeographicalId(Long geographicalId) {
        this.geographicalId = geographicalId;
    }

    public String getAlpha_2() {
        return alpha_2;
    }

    public void setAlpha_2(String alpha_2) {
        this.alpha_2 = alpha_2;
    }

    public String getAlpha_2_region_code() {
        return alpha_2_region_code;
    }

    public void setAlpha_2_region_code(String alpha_2_region_code) {
        this.alpha_2_region_code = alpha_2_region_code;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    public String getRegion3() {
        return region3;
    }

    public void setRegion3(String region3) {
        this.region3 = region3;
    }

    public String getRegion4() {
        return region4;
    }

    public void setRegion4(String region4) {
        this.region4 = region4;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getSummertime() {
        return summertime;
    }

    public void setSummertime(String summertime) {
        this.summertime = summertime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
