package android.alex.edu.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.alex.edu.implicitintents.R.id.etGoogleSearch;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGoogleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGoogleSearch = (EditText)findViewById(R.id.etGoogleSearch);
        editTextGoogleSearch.setText("");
    }

    public void website(View view)
    {
        Uri address = null;

        switch(((Button)view).getId())
        {
            case R.id.btnGoogle:
                address = Uri.parse("https://www.google.co.il/");
                break;
            case R.id.btnSport5:
                address = Uri.parse("http://www.sport5.co.il/");
                break;
            case R.id.btnNess:
                address =  Uri.parse("https://www.ness-college.co.il/");
                break;
            case R.id.btnAndroid:
                address = Uri.parse("https://developer.android.com/guide/index.html");
                break;
            case R.id.btnYnet:
                address = Uri.parse("http://www.ynet.co.il/home/0,7340,L-8,00.html");
                break;
            case R.id.btnKarate:
                address = Uri.parse("http://www.karateisrael.co.il/");
                break;
            default:
                throw new RuntimeException("Unexpected button id");
        }

        Intent webIntent = new Intent(Intent.ACTION_VIEW, address);

        if(canOpen(webIntent))
        {
            startActivity(webIntent);
        }
    }

    public void googleSearch(View view)
    {
        Uri address = null;
        String editTextString = editTextGoogleSearch.getText().toString();
        if(editTextString.equals("") || editTextString.trim().equals(""))
        {
            Toast.makeText(this, "You need to tap the text for search \nat Edit Text rectangular", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            address = Uri.parse("https://www.google.co.il/search?q=" + editTextString);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, address);

            if(canOpen(webIntent))
            {
                startActivity(webIntent);
            }
        }
    }

    private boolean canOpen(Intent intent)
    {
        return intent.resolveActivity(getPackageManager()) != null;
    }

}
