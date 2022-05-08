package com.example.connectit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0:heart , 1:diamond, 2:empty

    // keeping track of the gamestate that will be updated as the player makes the moves
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    //to track all the possibilities of winning the game using their positions from tags
    int[][] winningPositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    // we using integer instead of boolean to represent the current active player so that we can extend the app to multiplayer
    int activePlayer = 0;

    //to stop the game after someone has already won
    boolean gameActive = true;

    // through this method we are accessing the imageview
    // it will drop in the icon on whichever imageview is tapped
    public void dropIn(View view){
        //creating a variable of the type imageview
        ImageView counter =(ImageView) view;

        //to get the tag value of each cell
        //Log.i("tag",counter.getTag().toString());

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        // to take some action only when the space is empty otherwise nothing will happen to the already occupied cell
        // along with this, we check if the game is active as well
        if(gameState[tappedCounter] ==2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            // translating the counter out of the screen initially and then drop in eventually
            counter.setTranslationY(-2500);

            //to play alternatively
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.iheart);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.idiamond);
                activePlayer = 0;
            }

            // to drop in the counter
            counter.animate().translationYBy(2500).setDuration(100);

            //to determine who has won, we will loop through the array of winning positions and gamestate as well
            for (int[] winningPositions : winningPositions) {
                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                    // this means that someone has won the match
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Heart";
                    } else {
                        winner = "Diamond";
                    }
                   // Toast.makeText(this, winner + " has WON!!", Toast.LENGTH_SHORT).show();

                    // initially we have set the button and textview as invisible but after the match
                    // we will display the winner by making textview visible and
                    // enabling the play again option by making the button visible again

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerText = (TextView) findViewById(R.id.winnerText);

                    // we set the winner textview and display the winner
                    winnerText.setText(winner + " is the winner!");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);
                }

            }
        }
    }

    public void playAgain(View view){
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerText = (TextView) findViewById(R.id.winnerText);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerText.setVisibility(View.INVISIBLE);

        // to make the game restart once its already complete
        GridLayout gridLayout =(GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);

        }
        for(int  i=0; i <gameState.length;i++){
            gameState[i]=2;
        }
        activePlayer = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}