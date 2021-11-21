package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;

    }

    public PhoneBook() {
        this.phonebook = new HashMap<>(); //HashMap is a concrete class of Map

    }

    public void add(String name, String phoneNumber) {

        //we want to locate the Key: name
//        List<String> existingNumbers = phonebook.getOrDefault(name, new ArrayList<>());
        phonebook.putIfAbsent(name, new ArrayList<>());
        //we will then add a new input of String: phoneNumber to that list
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) { //String... is a primitive list
        //addAll is to add all the values into the specific key
        //get the phone
        //access the specific key location
        //add all the values into that specific key location
        phonebook.putIfAbsent(name, new ArrayList<>());
        //for each phoneNumber in this phoneNumber array
        for(String phoneNumber : phoneNumbers){
            //access the phoneBook, get this key (name), and add the phoneNumber to that location
            phonebook.get(name).add(phoneNumber);
        }
    }

    public void remove(String name) {
        //access the phoneBook
        //given the key name
        //remove the key
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name, String phoneNumber) {
        //access our phonebook
        //we are checking to see if that key location has any input in it
        //if it does, check to see if the phone exist
        return phonebook.getOrDefault(name, new ArrayList<>()).contains(phoneNumber);

    }

    public Boolean hasEntry(String name) {
        //access our phonebook
        //we are checking to see if that key location has any input in it
        //if it does, check to see if the phone exist
        return phonebook.containsKey(name);

    }


    public List<String> lookup(String name) {
        //access our phonebook
        //check to see if there is anything of value at that location

        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    public String reverseLookup(String phoneNumber) {
        //access the phonebook
        //given the phoneNumber, find the key
        //you can only use a for(each) loop on a type of collection: List, arraylists, and array
        //for each entry of this map in the phonebook containing keyset (Key, value)
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            //if the value in that map contains the specific phoneNumber
            if (entry.getValue().contains(phoneNumber)) {
                //give us the key of that value
                return entry.getKey();
            }
        }
        //tell us that there is nothing there
        return null;
    }

    public List<String> getAllContactNames() {

        //access phonebook
        //get all the keys in our phoneBook
        //return the List of names (key input of this map)
       return new ArrayList<>(phonebook.keySet());

    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
