package com.example.chandler.hack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Node;

import java.io.File;

/**
 * Created by Chandler on 1/14/2017.
 */

public class AddWineActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wine);
    }

    /*The following is to allow the use of a linked list (w/ nodes) to have an efficient way to
        store data. While also being able to efficiently access the data.
     */

    private class  WineNode{
        String wineName;    //the name of the wine
        float rating;   //the rating the user gives the wine, OUT OF FIVE STARS?
        File image;     //the image the user provides of the wine bottle
        String description; //user's description & opinon's of the wine
        /*
           * might give the user the ability to enter multiple flavor notes if wanted
           * also the ability to choose given flavor notes we give the user
         */
        String flavor;  //just a single flavor note

        //The node has an option to have a flavor note. Hence, two constructors.

        //constructor1
        public WineNode(String wineName, float rating, File image,String description ){
            this.wineName = wineName;
            this.rating = rating;
            this.image = image;
            this.description = description;
        }

        //constructor2
        public WineNode(String wineName, float rating, File image, String description, String flavor){
            this.wineName = wineName;
            this.rating = rating;
            this.image = image;
            this.description = description;
            this.flavor = flavor;
        }

        //time for getters

        public String getWineName(){
            return wineName;
        }

        public float getRating(){
            return rating;
        }

        public File getImage(){
            return image;
        }

        public String getDescription(){
            return description;
        }

        public String getFlavor(){
            //Since flavor is optional, let's return a null string if flavor is null
            if(flavor == null){return "";}
            else{return flavor;}
        }
        //setter's might be necessary if user did not enter all the necessary info. Such as the
        //user not entering the wine name.

    }//end nodeWine class

    /*
       * We want the list to list every node from newest entry to oldest. So, backwards from the
       * conventional linked list order.
     */
    private class WineLinkedList{

    }



}
