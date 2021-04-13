package com.example.speechtotext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private Button speechHindi,speechEnglish;
    private ImageView imgMic;
    private EditText txtSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMic = findViewById(R.id.imgMic);
        txtSpeech = findViewById(R.id.etSpeech);

        imgMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(() -> {

                    if (!isFinishing()){
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("Select Language");
                        String[] items = {"Hindi","English","Marathi","Tamil","Telugu"};
                        int checkedItem = 0;
                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        alertDialog.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
                        alertDialog.setSingleChoiceItems(items, checkedItem, (dialog, which) -> {
                            switch (which) {
                                case 0:
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "hi");
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to Text");
                                    startActivityForResult(intent,1);
                                    dialog.dismiss();
                                    break;
                                case 1:
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en");
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to Text");
                                    startActivityForResult(intent,1);
                                    dialog.dismiss();
                                    break;
                                case 2:
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "mr-IN");
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to Text");
                                    startActivityForResult(intent,1);
                                    dialog.dismiss();
                                    break;
                                case 3:
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ta-IN");
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to Text");
                                    startActivityForResult(intent,1);
                                    dialog.dismiss();
                                    break;
                                case 4:
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "te-IN");
                                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to Text");
                                    startActivityForResult(intent,1);
                                    dialog.dismiss();
                                    break;
                            }
                        });
                        AlertDialog alert = alertDialog.create();
                        alert.setCanceledOnTouchOutside(true);
                        alert.show();
                    }
                });

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            txtSpeech.setText(matches.get(0));
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}