package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayer=0;
    boolean gameactive=true;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winposition={{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    public void Playertap(View view){
        ImageView img= (ImageView) view;
        int tappedimage= Integer.parseInt(img.getTag().toString());
        if (!gameactive){
            gamereset(view);
        }

        if (gamestate[tappedimage]==2){
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer==0){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] pos:winposition){
            if (gamestate[pos[0]]==gamestate[pos[1]] && gamestate[pos[1]]==gamestate[pos[2]] && gamestate[pos[0]]!=2){
                String winstr;
                gameactive=false;
                if(gamestate[pos[0]]==0){
                    winstr="X has won the game";
                }
                else{
                    winstr="O has won the game";
                }
                TextView status=findViewById(R.id.status);
                status.setText(winstr);

            }
        }

    }
    public void gamereset(View view){
        gameactive = true;
        activeplayer = 0;
        for(int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
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
        status.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
