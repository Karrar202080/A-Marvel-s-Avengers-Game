package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class Location {

    private String story;
    private ArrayList<String> options;
    private ArrayList<Location> nextLocations;
    private ArrayList<Integer> changeHealth;
    public Location(String story) {
        this.story=story;
        options=new ArrayList<>(); nextLocations=new ArrayList<>(); changeHealth=new ArrayList<>();
    }
    public String getStory() {
        return story; }
    public ArrayList<String> getOptions(){
        return options; }
    public ArrayList<Location> getNextLocations(){
        return nextLocations; }
    public void printStory() {
        System.out.println(story); }
    public void printOptions() {
        System.out.println("Do you want to: "); for(int i=0;i<options.size();i++) {
            System.out.println(i+": "+ options.get(i)); }
    }
    public Location selectOption(User u) {
        Scanner scan=new Scanner(System.in); int option=scan.nextInt(); if(option<0||option>=options.size()) {
            System.out.println("Invalid option please try again");
            return this; }
        if(options.get(option).equals("Check Health")) { System.out.println("Your health is: "+ u.getHealth());
            return this; }
        u.setHealth(u.getHealth()+changeHealth.get(option));
        return nextLocations.get(option); }
    public Location addNextLocation(String option, String story, int healthChange){ options.add(option);
        changeHealth.add(healthChange);
        Location nextLoc= new Location(story);
        nextLocations.add(nextLoc);
        return nextLoc;
    }
    public void addNextLocation(String option, Location loc, int healthChange){ options.add(option);
        changeHealth.add(healthChange);
        nextLocations.add(loc);
    } }
class User {
    private String name;
    private int health;
    public User(String name, int health) { this.name=name;
        this.health=health; }
    public String getName() {
        return name; }
    public int getHealth() {
        return health; }
    public void setHealth(int health) {
        this.health=health; }
}
public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        User u=new User("Captain America", 100);
        Location firstLocation= new Location("Thanos did exactly what he said, he wiped off half of the population. Hello "+ u.getName()+", what is your nextmove");
                firstLocation.addNextLocation("Find Thanos", "Thanos is resting in a place what he calls the garden",0);
        firstLocation.addNextLocation("Find Iron Man", "Iron man is lost in the universe",0);
        firstLocation.getNextLocations().get(0).addNextLocation("Ask Thanos for infinity stones", "Thanos used infinity stones to destroy infinity stones", 0);
        firstLocation.getNextLocations().get(0).addNextLocation("Check Health", "Checking Health", 0);
        firstLocation.getNextLocations().get(1).addNextLocation(firstLocation.getOptions(). get(0), firstLocation.getNextLocations().get(0), 0);
        firstLocation.getNextLocations().get(1).addNextLocation("Talk to Ant Man", "Ant man just returned from the quantum realm, he's proposing time travel as a solution to get everyone back", 0);
        firstLocation.getNextLocations().get(1).addNextLocation("Check Health", "Checking Health", 0);
        firstLocation.getNextLocations().get(0).getNextLocations().get(0).addNextLocation(" Kill Thanos", "Thanos dies", -20);
        firstLocation.getNextLocations().get(0).getNextLocations().get(0).addNextLocation(" Check Health", "Checking Health", 0);
        firstLocation.getNextLocations().get(1).getNextLocations().get(1).addNextLocation(" Talk to Hulk", "Hulk tries but is inadequate to help with time travel", 0);
        firstLocation.getNextLocations().get(1).getNextLocations().get(1).addNextLocation(" Check Health", "Checking Health", 0);
        Location newLoc1= firstLocation.getNextLocations().get(0).getNextLocations().get(0).getNextLocations(
        ).get(0); firstLocation.getNextLocations().get(1).getNextLocations().get(1).getNextLocations(
        ).get(0);
        newLoc1.addNextLocation("Search Iron Man", "With help of Captain Marvel Iron Man is found", 0);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        Location newLoc2 = null;

        newLoc2.addNextLocation(newLoc1.getOptions().get(0), newLoc1.getNextLocations().get(0),0);
        newLoc2.addNextLocation("Check Health", "checking health", 0); newLoc1=newLoc1.getNextLocations().get(0);
        newLoc1.addNextLocation("Find Thor", "Thor is a changed person. He's still filled with guilt. He feels he couldn't do anything to stop Thanos. But Hulk convinces him to come back", 0);
        newLoc1.addNextLocation("Convince Iron Man for time travel", "Iron man's family is still alive. He doesn't want to leave whatever he's left with now. But Tony sees a picture of Peter Parker and he gives time travel a shot", 0);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        Location temp= newLoc1; newLoc1=newLoc1.getNextLocations().get(0); newLoc2=temp.getNextLocations().get(1);
        newLoc1.addNextLocation("Go back in time and get the infinity stones", "You're now at the avengers tower. While finding the tessearct you find another version of youself from the past", 0);
        newLoc2.addNextLocation(newLoc1.getOptions().get(0), newLoc1.getNextLocations().get(0),0);
        newLoc1.addNextLocation("Check Health", "checking health", 0); newLoc2.addNextLocation("Check Health", "checking health", 0);
        newLoc1= newLoc1.getNextLocations().get(0);
        newLoc1.addNextLocation("Fight another Captain America", "While fighting you told captain that Bucky is alive and hit him with the sceptor", -30);
        newLoc1.addNextLocation("Surrender and tell the truth", "You and captain took you for someone who's part of Loki's army and killed now dead. GAME OVER",Integer.MIN_VALUE); newLoc1.addNextLocation("Check Health", "checking health", 0);
        newLoc1= newLoc1.getNextLocations().get(0);
        newLoc2 = newLoc1.addNextLocation("Accept the fate", "You're now back in the future. But you lost tesseract and the only chance to bring everyone back.", Integer.MIN_VALUE);
        newLoc1.addNextLocation("Go further back in time to get tesseract", "You're at the office of Stark Industries. You manage to get tesseract, CONGRATULATIONS!!. You're now returning to the future. But time travel had a serious impact on your health", -20);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        newLoc1= newLoc1.getNextLocations().get(1);
        newLoc1.addNextLocation("Wear the gauntlet", "You were not able to survive the radiations of the infinity stones. You're dead.", Integer.MIN_VALUE); newLoc1.addNextLocation("Let Hulk wear the gauntlet", "Hulk snaps and everyone who disappeared comes back alive. But Thanos' army also finds a way to come to future", +20);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        newLoc1= newLoc1.getNextLocations().get(1);
        newLoc1.addNextLocation("Fight Thanos", "In your fight with Thanos, Iron Man wears the gauntlet and snaps, Thanos is dead. But you lose Iron Man too.",
                -50);
        newLoc1.addNextLocation("Leave the fight", "You're living in remorse. Thanos won again. Things could have been different if you didn't leave the fight", Integer.MIN_VALUE);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        newLoc1=newLoc1.getNextLocations().get(0);
        newLoc1.addNextLocation("Return infinity stones to their timeline", "You've defeated Thanos' army. Now you're back in time to return inifnity stones. But you see Paige here.", 20);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        newLoc1=newLoc1.getNextLocations().get(0);
        newLoc1.addNextLocation("Stay with Paige", "You're now dancing with Paige. It all ends well", 3000);
        newLoc1.addNextLocation("You return back", "You're now back with the avengers family. It all ends well", 3000);
        newLoc1.addNextLocation("Check Health", "checking health", 0);
        while(firstLocation.getNextLocations().size()!=0) { firstLocation.printStory(); firstLocation.printOptions(); firstLocation=firstLocation.selectOption(u); if(u.getHealth()<=0) {
            firstLocation.printStory(); System.out.println("YOU LOSE"); return;
        }
            if(u.getHealth()>1000) { firstLocation.printStory(); System.out.println("YOU WIN!!!!"); return;
            }
        }

    }
}
