package nyiro.csaba.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button ko;
    private Button papir;
    private Button ollo;
    private ImageView sajatValasztott;
    private ImageView gepValasztott;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ko = findViewById(R.id.BTN_Ko);
        this.papir = findViewById(R.id.BTN_Papir);
        this.ollo = findViewById(R.id.BTN_Ollo);
        this.sajatValasztott = findViewById(R.id.IMG_SajatValasztott);
        this.gepValasztott = findViewById(R.id.IMG_GepValasztott);

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.rock);
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.paper);
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sajatValasztott.setImageResource(R.drawable.scissors);
            }
        });
    }
}
