package manhnguyen.animalcrossing.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtMark;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbOne, sbTwo, sbThree;
    ImageButton btnPlay;
    boolean checkWin = false;
    int mark = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);
        txtMark.setText(mark + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                Random random2 = new Random();
                Random random3 = new Random();
                if (sbOne.getProgress() >= sbOne.getMax()) {
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_LONG).show();
                    enableCheckBox();
                    checkWin = true;
                    if (cbOne.isChecked()) {
                        mark += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                    } else {
                        mark -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    txtMark.setText(mark + "");
                }
                if (sbTwo.getProgress() >= sbTwo.getMax()) {
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_LONG).show();
                    enableCheckBox();
                    checkWin = true;
                    if (cbTwo.isChecked()) {
                        mark += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                    } else {
                        mark -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    txtMark.setText(mark + "");
                }
                if (sbThree.getProgress() >= sbThree.getMax()) {
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_LONG).show();
                    checkWin = true;
                    enableCheckBox();
                    if (cbThree.isChecked()) {
                        mark += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                    } else {
                        mark -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    txtMark.setText(mark + "");
                }
                sbOne.setProgress(sbOne.getProgress() + random.nextInt(5));
                sbTwo.setProgress(sbTwo.getProgress() + random2.nextInt(5));
                sbThree.setProgress(sbThree.getProgress() + random3.nextInt(5));


            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    disableCheckBox();
                    Toast.makeText(MainActivity.this, "Begin", Toast.LENGTH_SHORT).show();
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this, "Please Choose one ANIMAL to play", Toast.LENGTH_SHORT).show();
                }


            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });
    }

    private void enableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void disableCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void Anhxa() {
        txtMark = (TextView) findViewById(R.id.mark);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne = (SeekBar) findViewById(R.id.seekbarOne);
        sbTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        sbThree = (SeekBar) findViewById(R.id.seekbarThree);
        btnPlay = (ImageButton) findViewById(R.id.buttonPlay);
    }
}