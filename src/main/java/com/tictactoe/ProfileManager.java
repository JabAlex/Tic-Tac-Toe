package com.tictactoe;

import java.io.*;
import java.util.*;

public class ProfileManager {

    File savedProfiles = new File("profile.list");
    private List<Profile> profileList = new ArrayList<>();
    public ProfileManager(){
        loadProfiles();
    }
    public Profile chooseProfile(Profile currentProfile, boolean isPlayer2){
        listProfiles(true, false);
        Profile profile;
        int option;
        while (true) {
            try {
                if(currentProfile != null && !isPlayer2) System.out.println("Current profile: " + currentProfile.getName());
                if(isPlayer2)System.out.print("Choose profile for player 2: ");
                else System.out.println("Choose profile: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option == profileList.size() + 1) break;
                if(option >= 1 && option <= profileList.size()){
                    if(isPlayer2) {
                        assert currentProfile != null;
                        if (currentProfile.equals(profileList.get(option - 1))) throw new SameProfileException();
                    }
                    break;
                }
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            } catch (SameProfileException e){
                System.out.println("Can't choose the same profile");
            }
        }
        if(option == profileList.size() + 1){
            while(true) {
                try {
                    System.out.print("Choose name(max 10 characters): ");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.next();
                    if(name.length() > 10) throw new InputMismatchException();
                    profile = new Profile(name);
                    profileList.add(profile);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, Please try again");
                }
            }
        }
        else profile = profileList.get(option - 1);
        saveProfiles();
        return profile;
    }
    public void deleteProfile(Profile currentProfile){
        listProfiles(false, true);
        int option;
        while (true) {
            try {
                System.out.print("Choose profile: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option == profileList.size() + 1) break;
                if (option >= 1 && option <= profileList.size()){
                    if(currentProfile.equals(profileList.get(option - 1))) throw new SameProfileException();
                    break;
                }
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            } catch (SameProfileException e){
                System.out.println("Can't delete current profile");
            }
        }
        if(option != profileList.size() + 1) profileList.remove(option - 1);
        saveProfiles();
    }
    private void listProfiles(boolean showCreateNewProfile, boolean showBack){
        int index = 1;
        for (Profile profile: profileList) {
            System.out.println(index + ". " + profile.getName());
            index++;
        }
        if(showCreateNewProfile) System.out.println(index + ". Create new profile");
        if(showBack) System.out.println(index + ". Back");
        System.out.println();
    }
    public void saveProfiles(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedProfiles));
            oos.writeObject(profileList);
            oos.close();
        } catch (Exception e) {
            System.out.println("save error");
        }
    }
    @SuppressWarnings("unchecked")
    private void loadProfiles(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedProfiles));
            profileList = (ArrayList<Profile>)ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("load error");
        }    }

    public List<Profile> getProfileList() {
        return profileList;
    }
}
