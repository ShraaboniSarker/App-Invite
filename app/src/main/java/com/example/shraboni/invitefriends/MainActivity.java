package com.example.shraboni.invitefriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {

    EditText etSendMsg;
    Button inviteUrFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSendMsg = findViewById(R.id.etSendMsg);
        inviteUrFriends = findViewById(R.id.inviteUrFriends);

        inviteUrFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent share = new Intent();
                    share.setAction(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    String strShareMessage = " "+etSendMsg.getText().toString();
                    //strShareMessage = strShareMessage + Html.fromHtml("<a href=\"https://play.google.com/store/apps/details?id=com.jarvishub.eman\">link</a> ");
                    share.putExtra(Intent.EXTRA_TEXT, strShareMessage);
                    share.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent.createChooser(share, "Share"));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "cant go to the panel", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
