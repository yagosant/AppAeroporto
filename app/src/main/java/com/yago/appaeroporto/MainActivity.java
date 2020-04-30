package com.yago.appaeroporto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    TextView txtTexto;
    ImageView imgSeta;
    Button btnClique;
    Animation aparece, some;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
       txtTexto = findViewById(R.id.txtTexto);
       imgSeta = findViewById(R.id.imgSeta);
       btnClique = findViewById(R.id.btnClique);

        //setando um texto para o txtTexto, edição do mesmo no strings
       txtTexto.setText(R.string.direcao);
       imgSeta.setVisibility(View.INVISIBLE);

       btnClique.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Math.random() < 0.5){
                   //mudando a direção da seta
                   imgSeta.setScaleX(-1f);
                   txtTexto.setText(R.string.clique_direita);
                   Log.i("info","Botao clicado para Direita");

               }else{
                    //mudando a direção da seta
                   imgSeta.setScaleX(1f);
                   txtTexto.setText(R.string.clique_esquerda);
                   Log.i("info","Botao clicado para Esquerda");
               }
               imgSeta.startAnimation(aparece);

               /*
               new Timer().schedule(new TimerTask() {
                   @Override
                   public void run() {
                       imgSeta.startAnimation(some);
                   }
               },2000);
               */
           }
       });



        animaImg();
    }

    //metodo para realizar as animações
    private void animaImg() {
        //realizando as animações no botão
        aparece = new AlphaAnimation(0,1);
        aparece.setDuration(500);

        some = new AlphaAnimation(1,0);
        some.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgSeta.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgSeta.setVisibility(View.VISIBLE);
                imgSeta.startAnimation(some);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgSeta.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgSeta.setVisibility(View.INVISIBLE);
                txtTexto.setText(R.string.direcao);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
