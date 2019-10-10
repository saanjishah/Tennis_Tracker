package com.example.tennistrackerappsaanji;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Player> playerMatches;
    private ArrayList<String> opponentNames;
    private TextView txtHome, txtAway, txtAGame, txtHGame, txtASet, txtHSet;
    private Spinner spMatch;
    private ArrayList<String> positions = new ArrayList<>();
//    private String positions[] = new String[2];//{gameClass.getTeamONEplayerONE(), gameClass.getTeamONEplayerTWO(), gameClass.getTeamTWOplayerONE(), gameClass.getTeamTWOplayerTWO()};
    ArrayAdapter<String> adptPosition;
    int selectedMatch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerMatches = new ArrayList<Player>();
        opponentNames = new ArrayList<String>();
        positions.add("1 singles");
        positions.add("2 singles");
//        positions.add("1 doubles");
//        positions.add("2 doubles");
//        positions.add("3 doubles");
        spMatch = (Spinner) findViewById(R.id.spMatch);
        adptPosition = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, positions);
        spMatch.setAdapter(adptPosition);
        addPlayer("Bob");
        addOpponent("Joe", 0);
        addPlayer("Billy");
        addOpponent("John", 1);
        txtHome = (TextView) findViewById(R.id.txtHome);
        txtAway = (TextView) findViewById(R.id.txtAway);
        txtAGame = (TextView) findViewById(R.id.txtAGame);
        txtHGame = (TextView) findViewById(R.id.txtHGame);
        txtASet = (TextView) findViewById(R.id.txtASet);
        txtHSet = (TextView) findViewById(R.id.txtHSet);
        spMatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long id) {
                selectedMatch = index;
                Toast.makeText(MainActivity.this, positions.get(index), Toast.LENGTH_SHORT).show();
                updateTxt(index);
                //CALL a FUNCTION TO UPDATE ALL THE TEXTVIEW
                Toast.makeText(MainActivity.this, "ignore", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void addPlayer(String name){
        playerMatches.add(new Player(name));
    }
    public void addOpponent(String name, int index){
        opponentNames.set(index, name);
    }
    public void updateTxt(int index){
        txtHome.setText(playerMatches.get(index).getName());
        txtAway.setText(opponentNames.get(index));
        txtAGame.setText(playerMatches.get(index).getGamesLost());
        txtHGame.setText(playerMatches.get(index).getGamesWon());
        txtASet.setText(playerMatches.get(index).getSetsLost());
        txtHSet.setText(playerMatches.get(index).getSetsWon());
    }
    public void addHGame(View view){
        playerMatches.get(selectedMatch).addGame(true);
        updateTxt(selectedMatch);
    }
    public void addAGame(View view){
        playerMatches.get(selectedMatch).addGame(false);
        updateTxt(selectedMatch);
    }
}
