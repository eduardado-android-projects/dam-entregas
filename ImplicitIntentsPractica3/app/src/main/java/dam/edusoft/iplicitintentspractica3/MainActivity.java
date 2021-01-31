package dam.edusoft.iplicitintentspractica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebSiteEditText;
    private EditText mLocationEditText;
    private EditText mSharedEditText;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GUI references
        mWebSiteEditText = findViewById(R.id.editText_uri);
        mLocationEditText = findViewById(R.id.editText_loc);
        mSharedEditText = findViewById(R.id.editText_share);


    }

    public void visitWebSite(View view) {
        String url = mWebSiteEditText.getText().toString(); //Obtengo el String del EditText
        Uri websiteUri = Uri.parse(url); //parseo a URL
        //Creación de Intent Implícito
        Intent intent = new Intent(Intent.ACTION_VIEW //especificamos una acción
                ,websiteUri); //especificamos datos requeridos para la acción

        if(intent.resolveActivity(getPackageManager())!= null){ //nos aseguramos de que haya alguna Activity que pueda resolver nuestro Intent Implicito
            startActivity(intent); //si existe al menos una Activity que pueda manejar el Intent, se lanza
        }else{
            Log.d(TAG, "No hay navegador disponible");
        }
    }

    public void openLocation(View view) {
        String location = mLocationEditText.getText().toString();
        Uri locUri = Uri.parse( //parseamos la localización
                "geo:0,0?q=" //geo search query
                + location //se añade el texto a la peticón
        );

        Intent intent = new Intent(Intent.ACTION_VIEW,locUri);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d(TAG, "No hay navegador disponible");
        }
    }

    public void shareText(View view) {
        String sharedText = mSharedEditText.getText().toString();
        String mimeType = "text/plain"; //para indicar que es texto plano
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Compartir este texto con: ")
                .setText(sharedText)
                .startChooser();
    }
}