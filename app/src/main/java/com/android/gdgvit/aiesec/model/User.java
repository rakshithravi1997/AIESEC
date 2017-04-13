package com.android.gdgvit.aiesec.model;

import com.google.gson.annotations.SerializedName;

public class User{


        @SerializedName("name")
        private String name;
    @SerializedName("raisedBy")
    private String raisedBy;
        @SerializedName("email")
        private String email;
    @SerializedName("contact")
    private String contact;

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }





        public String[] getCountryPreferences() {
                return countryPreferences;
        }

        public void setCountryPreferences(String[] countryPreferences) {
                this.countryPreferences = countryPreferences;
        }

        @SerializedName("country_pref")
        private String [] countryPreferences;
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }



        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }





    }