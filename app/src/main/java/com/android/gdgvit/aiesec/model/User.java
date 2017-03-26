package com.android.gdgvit.aiesec.model;

import com.google.gson.annotations.SerializedName;

public class User{


        @SerializedName("name")
        private String name;
        @SerializedName("contact")
        private String contactNumber;
        @SerializedName("email")
        private String email;
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getContactNumber() {
                return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }





    }