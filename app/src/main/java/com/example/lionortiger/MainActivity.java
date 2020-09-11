package com.example.lionortiger;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p1,p2;

    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private Button btnreset;
    private GridLayout gridLayout;
    enum Player{ONE,TWO,No}
    Boolean gameover;
    MediaPlayer winnersound;
    ImageView btnsoundonoff;
    int ele=0;
    Player currentplayer=Player.ONE;
    Player[] playerchoice=new Player[9];
    int [][] winnerrowcolumn={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout=findViewById(R.id.gridlayout);
        winnersound=MediaPlayer.create(this,R.raw.winnersound);
        btnreset=findViewById(R.id.btnreset);
        gameover=false;
        for (int i=0;i<9;i++) {
            playerchoice[i] = Player.No;
        }
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resetthegame();
            }
        });

    }

    private void Resetthegame() {
        for (int index=0;index<gridLayout.getChildCount();index++){
            ImageView imageView=(ImageView)gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
        }
        currentplayer=Player.ONE;
        for (int i=0;i<9;i++) {
            playerchoice[i] = Player.No;
        }
        gameover=false;
        btnreset.setVisibility(View.GONE);
    }

    public void imageviewistapped(View imageview) throws InterruptedException {
        ImageView tappedimage = (ImageView) imageview;
        if (playerchoice[Integer.parseInt(tappedimage.getTag().toString())]==Player.No&&gameover==false) {
            tappedimage.setTranslationX(-2000);
            playerchoice[Integer.parseInt(tappedimage.getTag().toString())] = currentplayer;
            if (currentplayer == Player.ONE) {
                tappedimage.setImageResource(R.drawable.tiger);
                currentplayer = Player.TWO;
            } else if (currentplayer == Player.TWO) {
                tappedimage.setImageResource(R.drawable.lion);
                currentplayer = Player.ONE;
            }
            tappedimage.animate().translationXBy(2000).rotation(36000).setDuration(1000);
            for (int winnerrow[] : winnerrowcolumn) {
                if (playerchoice[winnerrow[0]] == playerchoice[winnerrow[1]] && playerchoice[winnerrow[1]] == playerchoice[winnerrow[2]] && playerchoice[winnerrow[0]] != Player.No)
                {
                    gameover=true;
                    String winner = "";
                    btnreset.setVisibility(View.VISIBLE);
                    if (currentplayer == Player.ONE) {
                        winner = "Player Two";
                    } else if (currentplayer == Player.TWO) {
                        winner = "Player One";
                    }
                    winnersound.start();
                    Toast.makeText(this, winner + " is the winner", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //If noone win
                    ele=0;
                    for (int i=0;i<playerchoice.length;i++){
                        if (playerchoice[i]!=Player.No){
                            ele++;
                        }
                        if (ele==9){
                            btnreset.setVisibility(View.VISIBLE);
                        }
                    }

                }

            }


        }
    }


}