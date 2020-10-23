package nyiro.csaba.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ko;
    private Button papir;
    private Button ollo;
    private ImageView sajatValasztott;
    private ImageView gepValasztott;
    private Random rnd;
    private TextView pontok;
    private int sajatNyeresPont;
    private int gepNyeresPont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ko = findViewById(R.id.BTN_Ko);
        this.papir = findViewById(R.id.BTN_Papir);
        this.ollo = findViewById(R.id.BTN_Ollo);
        this.sajatValasztott = findViewById(R.id.IMG_SajatValasztott);
        this.gepValasztott = findViewById(R.id.IMG_GepValasztott);
        this.pontok = findViewById(R.id.pontok);

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
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // NYERT A GÉP
                        gepNyeresPont++;
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // NYERT A JÁTÉKOS
                        sajatNyeresPont++;
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
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
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // DÖNTETLEN
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // NYERT A GÉP
                        gepNyeresPont++;
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
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
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
                        break;
                    case 1:
                        gepValasztott.setImageResource(R.drawable.paper);
                        // NYERT A JÁTÉKOS
                        sajatNyeresPont++;
                        pontok.setText("Eredmény: Ember: " + sajatNyeresPont + " Computer: " + gepNyeresPont);
                        break;
                    case 2:
                        gepValasztott.setImageResource(R.drawable.scissors);
                        // DÖNTETLEN
                        break;
                }
            }
        });
    }
}
