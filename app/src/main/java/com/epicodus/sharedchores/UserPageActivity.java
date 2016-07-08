package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserPageActivity extends AppCompatActivity {
    private  ListView mGroupListView;
    @Bind(R.id.createGroupHeader)
    TextView mCreateGroupHeader;
    @Bind(R.id.choreInputField)
    EditText mGroupNameInputField;
    @Bind(R.id.createGroupButton)
    Button mCreateGroupButton;
    @Bind(R.id.groupHeader)
    TextView mGroupHeader;


    private String[] groups = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);


        ButterKnife.bind(this);

        mGroupListView = (ListView) findViewById(R.id.groupListView);

//FONTS EVERYTHING

        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateGroupHeader.setTypeface(boldieFont);
        mCreateGroupButton.setTypeface(boldieFont);
        mGroupHeader.setTypeface(boldieFont);
// END OF FONTS


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, groups);
        mGroupListView.setAdapter(adapter);

        mGroupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String groupName = ((TextView) view).getText().toString();
                Intent intent = new Intent(UserPageActivity.this, ChoresActivity.class);
                startActivity(intent);

            }

        });

    }
}





