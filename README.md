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
<summary>Explicación</summary>

1. Creo el dataset.
   1. Modelo: Animal
   2. Dataset: Simulo acceso a una BD con la clase DatasetAnimales 
2. Creo adaptador
   1. 
</details>