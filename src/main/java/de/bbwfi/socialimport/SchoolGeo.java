package de.bbwfi.socialimport;

import com.google.gson.annotations.SerializedName;

public class SchoolGeo {
    public Features[] features;
    public Features[] getFeatures() {
        return features;
    }

    public class Features {
        @SerializedName("properties")
        public Schule school;
        public Schule getSchool() {
            return school;
        }

        public void setSchool(Schule school) {
            this.school = school;
        }
    }

}