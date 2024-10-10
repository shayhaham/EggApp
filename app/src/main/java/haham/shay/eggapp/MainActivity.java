package haham.shay.eggapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Button btnGetOut;
    private int counter;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 10;
        TextView counterTextView = findViewById(R.id.textview_counter);
        counterTextView.setText(" " + counter);
        btnGetOut = (Button) findViewById(R.id.btnGETOUT);
        EvantHandler();

    }

    public void knock(View view) {
        if (counter > 0) {
            counter--;
            TextView counterTextView = findViewById(R.id.textview_counter);
            counterTextView.setText(" " + counter);
            if (counter == 0) {
                ImageView eggimageview = findViewById(R.id.imageView_egg);
                eggimageview.setImageResource(R.drawable.surprise_egg);
            }
        }

    }

    public void reset(View view) {
        counter = 10;
        TextView counterTextView = findViewById(R.id.textview_counter);
        counterTextView.setText(" " + counter);
        ImageView eggimageview = findViewById(R.id.imageView_egg);
        eggimageview.setImageResource(R.drawable.green_egg);
    }

    private void EvantHandler() {
        btnGetOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder Builder = new AlertDialog.Builder(MainActivity.this);
                Builder.setMessage("Are You Sure You Wanna Leave?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog Alert = Builder.create();
                Alert.show();
            }

            ;
        });
        Log.e(TAG, "MainActivity::OnCreate");
    }
}