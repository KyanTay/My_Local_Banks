package sg.edu.rp.c346.id20037834.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String dbsNumber = "18001111111";

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
        } else if (btnSelected.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentOCBC);
            } else if (item.getItemId() == 1) {
                Intent intentHotlineOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333L));
                startActivity(intentHotlineOCBC);
            }
        } else if (btnSelected.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentUOB);
            } else if (item.getItemId() == 1) {
                Intent intentHotlineUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentHotlineUOB);
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
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
        }
        else if(id == R.id.ChineseSelection){
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}