package com.example.block7crudvalidation;

import org.springframework.stereotype.Component;

@Component
public class Validations {

    //Validate user --> not null and in a range between 6 and 10 characters
    public static boolean validate_user(String user){

        boolean valid = true;

        if(user.length()<6 || user.length()>10 || user.isBlank()){ valid = false;};

        return valid;
    }

    // Validate filds of text not null: password, name, company_email, personal_email and city
    public static boolean validate_str_notNull(String pass){
        boolean valid = true;

        if(pass.length()<1){
            valid = false;
        }
        return valid;
    }

    // A null boolean turns automatically into false


        public static boolean validate_date(String date){
        boolean valid = true;

        if(date.toString().length()<10 || date.toString().length()>11){
            valid = false;
        }
            return valid;
        }





}
