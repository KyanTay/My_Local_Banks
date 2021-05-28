package sg.edu.rp.c346.id20037834.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String btnSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0,2,2,"Favourite");
        menu.add(0,3,3,"Unfavourite");

        if (v == btnDBS) {
            btnSelected = "DBS";
        } else if (v == btnOCBC) {
            btnSelected = "OCBC";
        } else if (v == btnUOB) {
            btnSelected = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (btnSelected.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentDBS);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentHotlineDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111L));
                startActivity(intentHotlineDBS);
            }
            else if(item.getItemId() == 2){
                btnDBS.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3){
                btnDBS.setTextColor(Color.BLACK);
            }
        } else if (btnSelected.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentOCBC);
            } else if (item.getItemId() == 1) {
                Intent intentHotlineOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333L));
                startActivity(intentHotlineOCBC);
            }
            else if(item.getItemId() == 2){
                btnOCBC.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3){
                btnOCBC.setTextColor(Color.BLACK);
            }
        } else if (btnSelected.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentUOB);
            } else if (item.getItemId() == 1) {
                Intent intentHotlineUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentHotlineUOB);
            }
            else if(item.getItemId() == 2){
                btnUOB.setTextColor(Color.RED);
            }
            else if(item.getItemId() == 3){
                btnUOB.setTextColor(Color.BLACK);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.EnglishSelection){
            btnDBS.setText(R.string.btnDBS);
            btnOCBC.setText(R.string.btnOCBC);
            btnUOB.setText(R.string.btnUOB);
        }
        else if(id == R.id.ChineseSelection){
            btnDBS.setText(R.string.chineseDBS);
            btnOCBC.setText(R.string.chineseOCBC);
            btnUOB.setText(R.string.chineseUOB);
        }
        return super.onOptionsItemSelected(item);
    }
}