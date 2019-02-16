package com.example.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> secretWords = new ArrayList(Arrays.asList("SCARY", "DAREDEVIL", "HORROR"));
    public TextView scrambledWord, guessesRemaing, GameOver, ChanceCounter;
    public EditText cryptoWord;
    public Button start, GUESS;

    public String thisWord;

    public String shuffleWord(String shuffleWord) {
        shuffleWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(shuffleWord.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffleWord += c;
        return shuffleWord;



    }
    public String getSecretWord(){

        int thisWord = ((int)(Math.random()*3));
        switch (thisWord){
            case 0:
                thisWord = secretWords.indexOf(0);
                break;
            case 1:
                thisWord = secretWords.indexOf(1);
                break;
            case 2:
                thisWord = secretWords.indexOf(2);
        }
        return Integer.toString(thisWord);
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text and edittext views
        scrambledWord = (TextView) findViewById(R.id.scrambledWord);
        cryptoWord = (EditText) findViewById(R.id.cryptoWord);
        guessesRemaing = (TextView) findViewById(R.id.guessesRamaining);
        GameOver = (TextView) findViewById(R.id.GameOver);
        ChanceCounter = (TextView) findViewById(R.id.ChanceCounter);

        //buttons
        start = (Button) findViewById(R.id.start);
        GUESS = (Button) findViewById(R.id.GUESS);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void startClick(View v) {

        //display Scrambled word
        Button start = (Button) v;
        getSecretWord();
    }


    public void GUESSClick(View v){


        //initialize chance counter
        int chanceCounter = 0;
        final int MAX_VALUE = 5;
        if (chanceCounter == MAX_VALUE){
            GameOver.setText("You have expended all your chaces without guessing the letter");
        }

         //compare string in edittext to string in textview
        String S = getSecretWord();
        S.equals(cryptoWord);



        //resetting chance counter on each letter
        // and placing letter in current position
        //or increment counter on missed guess
        boolean correctLetter;
        if (correctLetter = true) {
            chanceCounter = 0;

            //appending correct letters to text stream in edittext.
            cryptoWord.append(S);

        }
        else
            for (chanceCounter =  0; chanceCounter >= MAX_VALUE; chanceCounter++);

    }

}
