package nyiro.csaba.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton ko;
    private ImageButton papir;
    private ImageButton ollo;
    private ImageView gepSziv1;
    private ImageView gepSziv2;
    private ImageView gepSziv3;
    private ImageView jatekosSziv1;
    private ImageView jatekosSziv2;
    private ImageView jatekosSziv3;
    private ImageView sajatValasztott;
    private ImageView gepValasztott;
    private Random rnd;
    private TextView pontok;
    private int sajatNyeresPont;
    private int gepNyeresPont;
    private TextView dontetlenText;
    private int dontetlen;
    private Toast toast;
    private AlertDialog felugroUzenet;
    private AlertDialog.Builder felugroUzenetbuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ko = findViewById(R.id.BTN_Ko);
        this.papir = findViewById(R.id.BTN_Papir);
        this.ollo = findViewById(R.id.BTN_Ollo);
        this.sajatValasztott = findViewById(R.id.IMG_SajatValasztott);
        this.gepValasztott = findViewById(R.id.IMG_GepValasztott);
        this.gepSziv1 = findViewById(R.id.gepSziv1);
        this.gepSziv2 = findViewById(R.id.gepSziv2);
        this.gepSziv3 = findViewById(R.id.gepSziv3);
        this.jatekosSziv1 = findViewById(R.id.jatekosSziv1);
        this.jatekosSziv2 = findViewById(R.id.jatekosSziv2);
        this.jatekosSziv3 = findViewById(R.id.jatekosSziv3);
        this.dontetlenText = findViewById(R.id.dontetlenText);
        dontetlen++;
        felugroUzenetbuilder = new AlertDialog.Builder(MainActivity.this);
        felugroUzenetbuilder.setMessage("Szeretnél új játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sajatNyeresPont = 0;
                        gepNyeresPont = 0;
                        dontetlen = 0;
                        gepSziv1.setImageResource(R.drawable.heart2);
                        gepSziv2.setImageResource(R.drawable.heart2);
                        gepSziv3.setImageResource(R.drawable.heart2);
                        jatekosSziv1.setImageResource(R.drawable.heart2);
                        jatekosSziv2.setImageResource(R.drawable.heart2);
                        jatekosSziv3.setImageResource(R.drawable.heart2);
                        dontetlenText.setText("Döntetlenek száma: 0");
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.cancel();
                    }
                })
                .setTitle("Játék vége")
                .setCancelable(false);
        felugroUzenet = felugroUzenetbuilder.create();

        rnd = new Random();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.rock);
                int gepValasztottIndex = rnd.nextInt(3);
                switch(gepValasztottIndex) {
                    case 0:
                        gepValasztott.setImageResource(R.drawable.rock);
                        // DÖNTETLEN
                        dontetlen++;
                        dontetlenText.setText("Döntetlenek száma: " + dontetlen);
                        Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // NYERT A GÉP
                        gepNyeresPont++;
                        if(gepNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a gép!", Toast.LENGTH_SHORT).show();
                        }
                        switch (gepNyeresPont) {
                            case 1:
                                jatekosSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                jatekosSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                jatekosSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // NYERT A JÁTÉKOS
                        sajatNyeresPont++;
                        if(sajatNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a játékos!", Toast.LENGTH_SHORT).show();
                        }
                        switch (sajatNyeresPont) {
                            case 1:
                                gepSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                gepSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                gepSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                }
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.paper);
                int gepValasztottIndex = rnd.nextInt(3);
                switch(gepValasztottIndex) {
                    case 0:
                        gepValasztott.setImageResource(R.drawable.rock);
                        // NYERT A JÁTÉKOS
                        sajatNyeresPont++;
                        if(sajatNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a játékos!", Toast.LENGTH_SHORT).show();
                        }
                        switch (sajatNyeresPont) {
                            case 1:
                                gepSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                gepSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                gepSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // DÖNTETLEN
                        dontetlen++;
                        dontetlenText.setText("Döntetlenek száma: " + dontetlen);
                        Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // NYERT A GÉP
                        gepNyeresPont++;
                        if(gepNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a gép!", Toast.LENGTH_SHORT).show();
                        }
                        switch (gepNyeresPont) {
                            case 1:
                                jatekosSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                jatekosSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                jatekosSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                }
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.scissors);
                int gepValasztottIndex = rnd.nextInt(3);
                switch(gepValasztottIndex) {
                    case 0:
                        gepValasztott.setImageResource(R.drawable.rock);
                        // NYERT A GÉP
                        gepNyeresPont++;
                        if(gepNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a gép!", Toast.LENGTH_SHORT).show();
                        }
                        switch (gepNyeresPont) {
                            case 1:
                                jatekosSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                jatekosSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                jatekosSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // NYERT A JÁTÉKOS
                        sajatNyeresPont++;
                        if(sajatNyeresPont == 3) {
                            // MUTASD A DIALOGOT
                            felugroUzenet.show();
                        } else {
                            Toast.makeText(MainActivity.this,"Nyert a játékos!", Toast.LENGTH_SHORT).show();
                        }
                        switch (sajatNyeresPont) {
                            case 1:
                                gepSziv3.setImageResource(R.drawable.heart1);
                                break;
                            case 2:
                                gepSziv2.setImageResource(R.drawable.heart1);
                                break;
                            case 3:
                                gepSziv1.setImageResource(R.drawable.heart1);
                                break;
                        }
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // DÖNTETLEN
                        dontetlen++;
                        dontetlenText.setText("Döntetlenek száma: " + dontetlen);
                        Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
