package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    /* player represtation
      0 -x
      1 -0
     */
   int activeplayer =0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    /* state meaning
      0 - x
      1- 0
      2 -Null
     */
    int [][] winposition ={ {0,1,2},{3,4,5},{6,7,8},
                             {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}
                           };
     public void playerTap(View view)
     {
         ImageView img = (ImageView) view;
         int tappedImage = Integer.parseInt(img.getTag().toString());
         if (!gameactive) {
             gameReset(view);
         }
         if (gamestate[tappedImage] == 2) {
             gamestate[tappedImage] = activeplayer;
             img.setTranslationY(-1000F);
             if (activeplayer == 1) {
                 img.setImageResource(R.drawable.o);
                 activeplayer = 0;
                 TextView status = findViewById(R.id.status);
                 status.setText("X's Turn To Play");
             } else {
                 img.setImageResource(R.drawable.x);
                 activeplayer = 1;
                 TextView status = findViewById(R.id.status);
                 status.setText("O's Turn To Play");
             }
             img.animate().translationYBy(1000f).setDuration(300);
         }
         //check for winner
         for (int[] winposition : winposition)
         {
             if (gamestate[winposition[0]] == gamestate[winposition[1]] &&
                     gamestate[winposition[1]] == gamestate[winposition[2]] &&
                     gamestate[winposition[0]] != 2)
             { //somebody has won find who
                 String winnerstr;
                 gameactive =false;
                 if (gamestate[winposition[0]] == 0) {
                     winnerstr = "x Has Won";
                 } else {
                     winnerstr = "O Has Won";
                 }
                 //update the staus bar
                 TextView status = findViewById(R.id.status);
                 status.setText(winnerstr);

             }
         }
     }
         public void gameReset(View view){
             activeplayer=0;
             for(int i=0;i<gamestate.length;i++)
                 gamestate[i]=2;
             gameactive=true;
             ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
             ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
             TextView status = findViewById(R.id.status);
             status.setText("X's Turn To Play");

         }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
