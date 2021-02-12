# Prácticas Mayores Segundo Trimestre

## Cafesito Práctica n1: CRUD en Android

<details>
  <summary>Cafesito (v1.0)</summary>

![Democafesito](https://media.giphy.com/media/Zx9ZcMmvuyMi4Zelk4/giphy.gif)
</details>


<details>
  <summary>Cafesito (v1.1)SharedProperties</summary>

![preferences](https://media.giphy.com/media/8LyxgapqBqkhpQSZ7S/giphy.gif)
</details>

## Contador Práctica n2
<details>
<summary>Instrucciones</summary>

- Toast: Se mostrará un mensaje Toast con la cuenta actual.
- Count: Sumara uno a la actual cuenta.
- El sistema debe de recordar el último número en contar. 
- Si es la primera vez empieza en 0.
- Ampliación: 
  - Incluir botón “CERO” para reiniciar la cuenta.
  - El título del activity será: Hello + Nombre

![Imgur](https://i.imgur.com/VSQrxDl.png)

</details>

<details>
  <summary>Demo Contador</summary>

  
</details>

## Intents Implícitos Práctica n3

<details>
<summary>Resultado</summary>

![gif](https://media.giphy.com/media/YKDZ7QXoBX19PUlgZq/giphy.gif)
</details>



<details>
<summary>Práctica 3 Instrucciones</summary>

  En esta práctica, tenéis que crear una aplicación que envía un intent implícito para realizar cada una de las siguientes tareas:
    • Abrir una URL en un navegador web.
    • Abrir una ubicación en un mapa.
    • Compartir texto.

  Compartir (enviar información a otras personas a través del correo electrónico o las redes sociales) es una característica popular en muchas aplicaciones. Para la acción de compartir, usa ShareCompat.IntentBuilder, lo que facilita la creación de una intención implícita para compartir datos.

  Como actividad de ampliación podéis crear un receptor con un intent simple que acepta un intent implícito para una acción específica.

</details>

<details>
<summary>Explicación</summary>

Esta práctica consta de dos proyectos o apps en Android.
  1. ImplicitIntentsPractica 3: Aplicación que lanza 3 tipos distintos de Intents
  2. IntentReceiverPractica 3: Una aplicación que recibe Intents que lanzan URL
     1. Muestra la URL contenida en el Intent
     2. Da la opción de lanzar el enlace en un vagegador

1. Creamos Layout con 3 EditText + 3 Button
   1. LinearLayout con orientación vertical
   2. [Extra] Añado un estilo con fuente personalizada
      1. res>new>resourcefile>font
      2. Añado la fuente satisfy.ttf a res>font
      3. Creo un estilo en styles.xml
      ```xml
          <style name="shareText">
            <item name="fontFamily">@font/Satisfy</item>
            <item name="android:textSize">25sp</item>
            <item name="android:textStyle">bold</item>
            <item name="android:gravity">center</item>
          </style>
      ```
      1. Añado el estilo en el EditText
        ```xml
        style="@style/shareText"
        ```
   3. Añado listener en cada botón usando el atributo onClick
    ```xml
      <Button
        android:onClick="shareText"
      />
    ```
2. Creo variable de clase y referencio el View
3. Implemento el método referenciado en onClick
   ```java
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
   ```
4. Implemento el Intent para abir localización en google maps. El Intent tiene la misma acción. Sólo cambia el string que le pasamos en la petición
   ```java
    Uri locUri = Uri.parse( //parseamos la localización
                "geo:0,0?q=" //geo search query
                + location //se añade el texto a la peticón
        );
   ```
5. Implemento shareText(). Un intent que me permite compartir texto con las aplicaciones disponibles que puedan usarlo.
Me valgo de la clase ShareCompat.IntentBuilder.

IntentReceiverPractica3

  Una aplicación que, cuando está abierta, permite recibir URLs lanzadas desde otro Intent

  1. Preparación del layout
  2. Creación del intent-filter. Vemos que nuestra aplicación sólo abrirá direcciones con protocolo https y que pertenezca
  al dominio "eduardado.github.io", de lo contrario serán recogidas por el navegador por defecto del móvil.
  ```xml
    <intent-filter >
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data
                android:scheme="https"
                android:host="eduardado.github.io" />
    </intent-filter>
  ```
  3. Implementar la recogida del Intent

  ```java
    Intent intent = getIntent();
          Uri uri = intent.getData();
          if (uri != null) {
              String uriString = uri.toString();
              mWebSiteEditText.setText(uriString);

          }
  ```


</details>

## WikiApiVolleyP4

<details>
<summary>Requerimientos</summary>

   1. Crear un listado (con un objeto personalizado: nombre, código, descripción, etc.) 
   usando RecycledView. 
   2. Usar Glide para mostrar imágenes dentro del listado: Usando http y https. 
   3. Implementar para ambos el método OnClick. 
   4. Al acceder al detalle de cada uno de los elementos realizar una búsqueda dentro de la 
   Wikipedia usando su API REST para buscar resultados relacionados con el detalle. 
   https://es.wikipedia.org/w/api.php?action=query&list=search&srsearch=%TEXTO_BUS
   QUEDA%&format=json.
   5. Implementar un botón que genere una notificación con alguna propiedad del objeto 
   que tengamos en el detalle.

</details>

<details>
<summary>Explicaciones</summary>

<details>
<summary>Hacer cada ítem del RecyclerView clickable usando una interfaz</summary>

### Hacer cada ítem del RecyclerView clickable usando una interfaz

#### Resumen

1. Implementamos OnClickListener en el ViewHolder
2. Definimos una interfaz con un método que seleccione un objeto Game
3. Implementamos la interfaz en nuestro Activity
4. Le pasamos la interfaz al constructor del adaptador

#### Paso a paso

1. Dentro de la clase adaptadora "GameRecyclerViewAdapter", definimos una interfaz "OngameListener", que define un método "onGameClick()" que deberá ser implementado por aquella clase que implemente esta interfaz. Nótese que este último método recibirá por parámetro un Integer, que corresponde a la posición del ítem en el que estamos haciendo click dentro del LinkedList que contiene los datos.
  ```java
  public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameRecyclerViewAdapter.GameViewHolder> {
    //...
    public interface OnGameListenerInterface{
            void onGameClick(Integer position);
        }
  }
  ```
2. La clase ViewHolder que está anidada dentro de nuestra clase adaptadora, en nuestro caso "GameViewHolder", deberá implementar la clase "View.OnClickListener". Dicho listener, tendrá que ser también asignado al ítem sobre el que se está haciendo click.
```java
public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{ //1
  //...
  public GameViewHolder(@NonNull View itemView, GameRecyclerViewAdapter gameListAdapter, OnGameListener onGameListener) {
    //...
    itemView.setOnClickListener(this);//2
  }

  @Override
        public void onClick(View v) {
            //uso de la interfaz (lo veremos luego)
        }
}
```
3. Fuera de esta clase, dentro de MainActivity, tendremos que implementar la interfaz del paso nº1 "OnGameListenerInterface"
```java
  public class MainActivity extends AppCompatActivity  implements GameRecyclerViewAdapter.OnGameListenerInterface {}
```
4. Una vez hacemos que la clase implemente la interfaz, tendremos que implementar el método onClick que dicha interfaz define
  ```java
    @Override
        public void onGameClick(Integer position) {
            Intent intent = new Intent(this, GameDetailsActivity.class); //cambia a otra Activity
            startActivity(intent);
        }
  ```
5. Tenemos ahora que asegurarnos que, cuando instanciamos la clase adaptadora, ésta recibe por parámetro no sólo el Activity y el linkedList con los datos, sino también la interfaz (definida por la propia clase)
```java
mGameRecyclerViewAdapter = new GameRecyclerViewAdapter(
                this, //El Activity
                mGameLinkedList, //los datos
                this); // La interfaz (también implementada por esta clase)
```
6. Queda gestionar cómo la referencia de la interfaz que hemos definido en el MainActivity llega hasta la clase anidada
   1. Definir una variable de clase
   ```java
    public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameRecyclerViewAdapter.GameViewHolder> {
      private OnGameListenerInterface mOnGameListenerInterface;
      //...
    }
   ```
   2. Pasarle la referencia a la instancia de la interfaz en el constructor
   ```java
   public GameRecyclerViewAdapter(Context context, LinkedList<Game> gameLinkedList, OnGameListenerInterface onGameListener) {
        //...
        mOnGameListenerInterface = onGameListener;
    }
   ```
   3. Dentro del método que instancia cada ViewHolder (GameViewHolder en nuestro caso). Hay que pasarle la isntancia de la interfaz
    ```java
      @NonNull
      @Override
      public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          //...
          return new GameViewHolder(mItemView, this, mOnGameListenerInterface); //<-aquí
      }
    ```
   4. La clase anidada GameViewHolder, lo recibe en su constructor y lo asigna a la clase
   ```java
   public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //..

        private OnGameListenerInterface onGameListenerInterface;


        public GameViewHolder(@NonNull View itemView, GameRecyclerViewAdapter gameListAdapter, OnGameListenerInterface onGameListener) {
            //..
            this.onGameListenerInterface = onGameListener; //<-aquí

        }
    }
   
   ```
   5. Finalmente, a través del método getAdapterPosition() de la clase Adapter, le pasamos a la interfaz la posición del ítem. Lo que ocurrirá es que, cada vez que se hace

   ```java
   public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

      //..
        @Override
        public void onClick(View v) {
            onGameListenerInterface.onGameClick(getAdapterPosition());
        }

    }
   
   ```
#### Recapitulación: ¿qué ocurre en ejecución?

1. La clase de lanzamiento, GameListMainActivity, implementa la interfaz GameRecyclerViewAdapter.OnGameListenerInterface.
   1. Espera recibir una posición 
   2. Crea un intent hacia otra actividad
   3. Obtiene la posición del objeto que está siendo pulsado.
   4. Obtiene el objeto del LinkedList a partir de dicha posición
   5. Manda dicho objeto en el Intent a otra actividad
2. ¿ Por qué recibe la posición el método onGameClick(Integer position)?
   1. La clase ViewHolder del adaptador implementa la el listener OnClick
   2. Cada ítem del ViewHolder, recibe el listener en el constructor de su clase por lo que estará "escuchando los clicks"
   3. Cuando el usuario hace click en cualquier ítem, la clase ViewHolder a través del método getAdapterPosition() le pasa al método onGamkeClick() de la interfaz, la posición del ítem que está siendo clicado.
</details>

<<details>
<summary>Pasar informacion de una Activity a otra Usando Parcelable Objects + Intents</summary>


</details>>

 
</details>




<details>
<summary>TODO</summary>

- [x] Hacer los ítem más sencillos: nombre + foto.
- [x] User Gridlayout Manager en lugar de LinearLayoutManager
- [x] Al pulsar el ítem te lleva a otra Activity con los detalles.
- [x] Implementar el listener usando una interfaz (buenas prácticas)
- [ ] El Activity con detalles muestra Foto, Nombre y además año, desarrollador
- [ ] El Activity detalles tiene un botón que, al pulsarlo, se consulta a la Wikipedia. La wikipedia devuelve un JSON que se mostrará en un textView abajo.

IDEAS
- [ ] Mostrar en el detalle un vídeo incrustado de youtube con gampeplay del juego.
</details>

<details>
<summary>Notas</summary>

- Si usamos esta [direccion http](https://es.wikipedia.org/w/api.php?action=query&list=search&srsearch=%25The_Secret_of_monkey_island&format=json) la API de Wiki pedia nos devuelve directamente un JSON





</details>

## Notificaciones (Práctica 5)

<details>
<summary>Explicaciones</summary>

1. Creamos un canal para las notificaciones (buenas prácticas)
   1. Creamos una constante con el ID del canal de notificaciones.
   2. 



</details>

<details>
<summary>Código usado</summary>

NotificactionChannel
NotificationManager
Activity: getSystemService()
</details>

## Pasar informacion de una Activity a otra Usando Parcelable Objects + Intents

1. Implementar la interfaz Parcelable en el objeto
   1. Implementar los métodos
   2. Añadir implementación de Parcelable