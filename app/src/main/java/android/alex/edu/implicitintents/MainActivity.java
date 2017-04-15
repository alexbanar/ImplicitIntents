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
                address = Uri.parse(getString(R.string.google_address_site));
                break;
            case R.id.btnSport5:
                address = Uri.parse(getString(R.string.sport5_address_site));
                break;
            case R.id.btnNess:
                address =  Uri.parse(getString(R.string.ness_college_addres_site));
                break;
            case R.id.btnAndroid:
                address = Uri.parse(getString(R.string.android_developer_guide_address_site));
                break;
            case R.id.btnYnet:
                address = Uri.parse(getString(R.string.ynet_address_site));
                break;
            case R.id.btnKarate:
                address = Uri.parse(getString(R.string.karate_IOGKF_address_site));
                break;
            default:
                throw new RuntimeException(getString(R.string.unexpected_button_id));
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
            Toast.makeText(this, R.string.must_tap_text, Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            address = Uri.parse(getString(R.string.google_search_address_site) + editTextString);
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
