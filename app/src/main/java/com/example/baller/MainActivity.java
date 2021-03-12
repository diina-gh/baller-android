package com.example.baller;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String [] clubs = {
            "Diambar",
            "Génération Foot",
            "Pikine",
            "Excellence",
            "Teungueth FC",
            "Jaraaf",
            "Stade Mbour",
            "Casa Sports",
            "Dakar SC",
            "Ndiambour",
            "Mbour PC",
            "US Gorée",
            "Niary Tally"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_games, R.id.navigation_teams, R.id.navigation_plus)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Teams view
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.clubs, R.id.textView, this.clubs);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /* appending Happy with festival name */
                String value = "Happy " + adapter.getItem(i);
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }

}