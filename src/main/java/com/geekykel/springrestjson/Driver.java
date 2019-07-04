package com.geekykel.springrestjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekykel.springrestjson.entities.Address;
import com.geekykel.springrestjson.entities.Student;

import java.io.File;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        try{

            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("src/main/data/sample-full.json"), Student.class);

            System.out.println("Student FN : " + student.getFirstName());
            System.out.println("Student LN : " + student.getLastName());

            Address address = student.getAddress();

            System.out.println("Student Street : " + address.getStreet());
            System.out.println("Student City : " + address.getCity());

            for (String lang : student.getLanguages()) {
                System.out.println("Language >> " + lang);
            }

            System.out.println("Languages To String: " + Arrays.toString(student.getLanguages()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
