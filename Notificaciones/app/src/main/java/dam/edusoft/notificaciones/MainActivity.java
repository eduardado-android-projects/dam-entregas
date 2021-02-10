package dam.edusoft.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 0;
    private Button btnNofity;
    private static final String PRIMARY_CHANNEL_ID = "canal_notificacion_principal"; //ID del canal de notificación
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNofity = findViewById(R.id.btn_notify);
        btnNofity.setOnClickListener(this);

        createNotificationChannel();
    }

    public void createNotificationChannel(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); //obtenemos una referencia a la clase que gestiona los servicios del sistema

        // comprobamos que el dispositivo esté usando una API superior a la 26 porque antes no había canales de notificación
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            //Creamos el canal de notificación
            NotificationChannel notificationChannel= new NotificationChannel(
                    PRIMARY_CHANNEL_ID,
                    "Edusoft Notification",
                    NotificationManager.IMPORTANCE_HIGH);

            // Todas las notificaciones de este canal tendrán estas propiedades
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.YELLOW);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notificación de la app de EDU");
            notificationManager.createNotificationChannel(notificationChannel);


        }

    }



    private NotificationCompat.Builder getNotificationBuilder(){
        //instancia la notificación
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID);
        return null;
    }

    private void sendNotification(){

    }

    @Override
    public void onClick(View v) {

    }
}