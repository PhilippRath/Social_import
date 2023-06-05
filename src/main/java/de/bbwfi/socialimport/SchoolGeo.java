package de.bbwfi.socialimport;

import com.google.gson.annotations.SerializedName;

public class SchoolGeo {
    public Features[] features;
    public Features[] getFeatures() {
        return features;
    }

    public class Features {
        @SerializedName("properties")
        public School school;
        public School getSchool() {
            return school;
        }

        public void setSchool(School school) {
            this.school = school;
        }
    }

}