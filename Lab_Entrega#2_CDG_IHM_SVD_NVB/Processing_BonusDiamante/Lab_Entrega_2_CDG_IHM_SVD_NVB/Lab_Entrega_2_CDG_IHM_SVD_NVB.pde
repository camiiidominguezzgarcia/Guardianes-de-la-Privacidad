/* LOS GUARDIANES DE LA PRIVACIDAD - BONUS DIAMANTE en Processing */

/* biblioteca para que los GIF se animen */
import gifAnimation.*;

/* biblioteca de sonido de Processing (Sound) para la musica */
import processing.sound.*;

/* musica de fondo del juego y el boton para quitarla o ponerla */
SoundFile musica;
PImage iconoSonido;
PImage iconoSinSonido;
boolean sonidoActivo = true;
boolean sobreBotonSonido = false;

/* imagenes del juego */
PImage menuPrincipal;
PImage menuInfo;

/* segunda pagina de la informacion del juego (puntaje, logros y finales) */
PImage menuInfo2;
PImage menuSalir;
PImage habitacion;

/* habitacion con la cama, la alfombra y el reloj azules (cuando el jugador escoge el guardian) */
PImage habitacionNino;
Gif personaje;

/* los dos personajes que se pueden escoger; personaje toma el que elija el jugador */
Gif personajeNina;
Gif personajeNino;

/* el Dr. Datos (dia 7): feliz mientras no le aciertan y enojado cuando recibe un golpe */
Gif drDatosFeliz;
Gif drDatosEnojado;

/* vida que se dibuja en la barra: baja (o sube) de a 1 punto por cuadro hasta llegar a vidaDrDatos */
int vidaMostrada = 100;

/* cuadros que dura el "golpe" (el Dr. Datos tiembla y se pone rojo cuando le aciertan) */
int golpe = 0;
PImage pcRegistro;
PImage pcInformeRegistro;
PImage pcDia1Situacion1;
PImage pcInformeDia1;
PImage pcInformeDia;

/* pantallas de las misiones de los dias 2, 3 y 4 (diseños del equipo) */
PImage pcD2S1;
PImage pcD2S2;
PImage pcD2S3;
PImage pcD3S1;
PImage pcD3S2;
PImage pcD3S3;
PImage pcD3S4;
PImage pcD3S5;
PImage pcD4S1;
PImage pcD4S2;
PImage pcD4S3;
PImage pcD4S4;
PImage pcD4S5;

/* pantallas de las misiones de los dias 5 y 6 */
PImage pcD5S1;
PImage pcD5S2;
PImage pcD5S3;
PImage pcD5S4;
PImage pcD5S5;
PImage pcD6S1;
PImage pcD6S2;
PImage pcD6S3;
PImage pcD6S4;
PImage pcD6S5;
PImage pcD6S6;
PImage pcD6S7;

/* pantallas de la batalla final (dia 7) */
PImage pcD7S1;
PImage pcD7S2;
PImage pcD7S3;
PImage pcD7S4;
PImage pcD7S5;
PImage pcD7S6;
PImage pcD7S7;
PImage pcD7Contexto;
PImage pcD7Mision;
PImage pcD7Instrucciones;

/* paginas del reporte final: 1 tus datos, 2 tu desempeño y 3 el final (bueno, regular o malo) */
PImage pcReporteDatos;
PImage pcReporteDesempeno;
PImage pcFinalBueno;
PImage pcFinalRegular;
PImage pcFinalMalo;
PImage imagenFinal;

/* introduccion de la historia: 4 pantallas antes del registro */
PImage pcIntro1;
PImage pcIntro2;
PImage pcIntro3;
PImage pcIntro4;

/* pantallas de introduccion de los dias 2 a 6 */
PImage pcD2Contexto;
PImage pcD2Instruccion;
PImage pcD3Nivel;
PImage pcD3Desafios;
PImage pcD3Proteccion;
PImage pcD4Contexto;
PImage pcD4Instruccion;
PImage pcD5Intro;
PImage pcD6Nivel;
PImage pcD6Contexto;
PImage pcD6Instruccion;

/* pantallas de progreso al terminar cada dia (dia 1 a dia 6) */
PImage pcProgreso1;
PImage pcProgreso2;
PImage pcProgreso3;
PImage pcProgreso4;
PImage pcProgreso5;
PImage pcProgreso6;

/* tipo de letra del juego */
PFont fuente;

/* pantalla que se esta mostrando */
 
int pantalla = 0;

/* ultima pantalla del computador donde estaba el jugador si sale con la X y vuelve a entrar, sigue por donde iba antes */
int pantallaComputador = 15;

/* pantalla con la que empezo el cuadro actual para saber que escala se uso al dibujar */
int pantallaDibujada = 0;

/* cursor del mouse: mano es verdadero si el mouse esta sobre algo que se puede presionar en este cuadro, y manoAntes guarda como quedo el cursor, para cambiarlo solo cuando hace falta asi no parpadea */
boolean mano = false;
boolean manoAntes = false;

/* contador para animar el circulo de nivel */
int latido = 0;

/* el juego se diseña en 1200 x 843 y se pone grande o pequeño para llenar la pantalla completa */
float escala;
float offsetX;
float offsetY;
int mx;
int my;

/* las pantallas del computador son 16:9 (1920 x 1080) asi que se agrandan aparte para poder llenar toda la pantalla, escalaPC es cuanto se agrandan y offPCX / offPCY donde quedan */
float escalaPC;
float offPCX;
float offPCY;

/* posicion en pixeles reales donde se pegan las imagenes ya agrandadas */
int menuX;
int menuY;
int pcX;
int pcY;

/* fondos borrosos para rellenar los lados del menu y de la habitacion */
PImage fondoMenuPrincipal;
PImage fondoMenuInfo;
PImage fondoMenuInfo2;
PImage fondoMenuSalir;

/* pantalla para escoger personaje (diseño del equipo en Canva) y su fondo borroso */
PImage elegirPersonaje;
PImage fondoElegir;
PImage fondoHabitacion;
PImage fondoHabitacionNino;

/* para saber si se acaba de hacer clic y no contar el mismo clic muchas veces */
boolean mouseAntes = false;
boolean clic = false;

/* para saber si se acaba de presionar una tecla y no escribir la misma letra muchas veces */
boolean teclaAntes = false;
char ultimaTecla = ' ';
boolean teclaNueva = false;

/* posicion y tamaño del personaje en la habitacion */
int personajeX = 520;
int personajeY = 520;
int tamPersonaje = 180;
int velocidad = 5;

/* si el personaje esta junto al computador */
boolean cercaDelComputador = false;

/* lo que el jugador va escribiendo en cada recuadro del registro */
String txtNombre = "";
String txtEdad = "";
String txtAño = "";
String txtMes = "";
String txtDia = "";
String txtHora = "";
String txtMinuto = "";
String txtFranja = "";
String txtHoras = "";

/* recuadro donde se esta escribiendo */
int campoActivo = 1;

/* mensaje de error del registro vacio si no hay error */
String mensajeError = "";
boolean intentarRegistro = false;

/* datos del jugador ya validados */
String nombre = "";
int edad;
int año;
int mes;
int dia;
int hora;
int minuto;
String franjaHoraria = "";
int cantidadHoras;
int diasDelMes;

/* variables de los calculos de la jornada */
int diaJuego = 1;
int horaMilitar;
int minutosEntrada;
int minutosSalida;
int diaAdicional;
int horaDeSalida;
int minutoDeSalida;
int segundoDelDiaSalida;
int diaSalida;
int mesSalida;
int añoSalida;
int puntuacionDia;
String mensajeRiesgo = "";
String mensajeRiesgo2 = "";

/* vaiables para hacer el formato de 2 digitos e imprimirlo */
String diaf = "";
String mesf = "";
String horaf = "";
String minutof = "";
String diaSalidaf = "";
String mesSalidaf = "";
String horaDeSalidaf = "";
String minutoDeSalidaf = "";
String segundoDelDiaSalidaf = "";

/* numero del mensaje que se esta mostrando en la caja de dialogo con click se pasa */
int pasoDialogo = 1;

/* variables de la mision del dia 1*/
int contenido1 = 0;
int contenido2 = 0;
int puntuacionContenido1;
int puntuacionContenido2;
String nombreContenido1 = "";
String nombreContenido2 = "";
int botonElegido;

/* acumuladores y contadores*/
int decisionesCorrectas = 0;
int decisionesIncorrectas = 0;
int proteccion = 100;
int penalizacionNivel = 15;
int puntajeDigitalAcumulado = 0;
int diasCompletados = 0;
int horasAcumuladas = 0;
int diasConUsoSaludable = 0;

/* para los logros cada variable booleana indica si el logro ya fue desbloqueado.
   logrosObtenidos cuenta cuantos logros lleva el jugador. */
int logrosObtenidos = 0;
boolean logroFakeNews = false;
boolean logroMensajes = false;
boolean logroReyDelTiempo = false;

/* datos de la semana para el reporte final */
String horaIngresoInicial = "";
String horaSalidaFinal = "";
int vidaDrDatos = 100;
int aciertosDia = 0;

/* para que la sesion de un dia no se cruce con la del dia siguiente si paso la media noche */
int minutoLibreDiaSiguiente = 0;
String finSesionAnterior = "";

/* variables de las preguntas de las misiones*/
int numPregunta = 1;
int totalPreguntas;
int totalIntro;
PImage imagenPregunta;
PImage imagenIntro;
PImage imagenProgreso;
int numOpciones;
int correcta;
String mensaje1 = "";
String mensaje2 = "";
String mensaje3 = "";
boolean respondida = false;
int respuestaElegida = 0;
String mensajeRespuesta = "";
String mensajeCierre = "";

/* posicion y tamaño de los botones de la pregunta actual */
int b1x;
int b1y;
int b1w;
int b1h;
int b2x;
int b2y;
int b2w;
int b2h;
int b3x;
int b3y;
int b3w;
int b3h;

/* nivel y barra de progreso */
int nivelAlcanzado = 1;
String nombreNivel = "";
int diasDentroDelNivel;
int diasNecesariosNivel;
int bloquesProgreso;

/* ultimo dia del juego */
int ultimoDia = 7;

/* reporte final */
String tipoFinal = "";
int diasEquivalentesPorAño;
String clasificacionFinal = "";
String diagnosticoFinal = "";
String finalHistoria = "";

void setup() {
  fullScreen();
  smooth();

  /* creamos el tipo de letra en tamaño grande para que se pueda ver nitido aunque se agrande la pantalla */
  fuente = createFont("Segoe UI Semibold", 64, true);
  textFont(fuente);

  /* calculamos cuanto hay que agrandar el juego para que quepa en la pantalla sin deformarse */
  escala = width / 1200.0;
  if (height / 843.0 < escala) {
    escala = height / 843.0;
  }
  /* lo que sobra a los lados, arriba o abajo, lo repartimos para la centracion del juego */
  offsetX = (width - 1200 * escala) / 2;
  offsetY = (height - 843 * escala) / 2;

  /* para el computador la parte que se ve de sus imagenes mide 1200 x 675 (16:9y empieza en y = 84, por eso le restamos 84 * escalaPC*/
  escalaPC = width / 1200.0;
  if (height / 675.0 > escalaPC) {
    escalaPC = height / 675.0;
  }
  offPCX = (width - 1200 * escalaPC) / 2;
  offPCY = (height - 675 * escalaPC) / 2 - 84 * escalaPC;

  menuX = round(offsetX);
  menuY = round(offsetY);
  pcX = round(offPCX);
  pcY = round(offPCY + 84 * escalaPC);

  menuPrincipal = loadImage("menuPrincipal.png");
  menuInfo = loadImage("menuInfo.png");
  menuInfo2 = loadImage("menuInfo2.png");
  menuSalir = loadImage("menuSalir.png");
  elegirPersonaje = loadImage("elegirPersonaje.png");
  habitacion = loadImage("habitacion_hd.png");
  habitacionNino = loadImage("habitacion_nino.png");
  /* cargamos los dos personajes; empieza con la guardiana hasta que el jugador escoja */
  personajeNina = new Gif(this, "personajeJuego.GIF");
  personajeNina.loop();
  personajeNino = new Gif(this, "personajeNino.gif");
  personajeNino.loop();
  personaje = personajeNina;
  drDatosFeliz = new Gif(this, "personaje2feliz.gif");
  drDatosFeliz.loop();
  drDatosEnojado = new Gif(this, "personaje2.gif");
  drDatosEnojado.loop();
  pcIntro1 = loadImage("introduccion1.png");
  pcIntro2 = loadImage("introduccion2.png");
  pcIntro3 = loadImage("introduccion3.png");
  pcIntro4 = loadImage("introduccion4.png");
  pcRegistro = loadImage("Registro.png");
  pcInformeRegistro = loadImage("Informe post-registro.png");
  pcDia1Situacion1 = loadImage("Día 1, situación 1.png");
  pcInformeDia1 = loadImage("informe_dia1_mision1.png");
  pcInformeDia = loadImage("informe_dia_limpio.png");

  /* iconos del boton de sonido */
  iconoSonido = loadImage("sonido.png");
  iconoSinSonido = loadImage("sinSonido.png");
  iconoSonido.resize(64, 64);
  iconoSinSonido.resize(64, 64);

  /* cargamos la musica y la ponemos pra que cuando se acabe comience otra vez*/
  musica = new SoundFile(this, "musica.wav");
  musica.loop();
  pcD2S1 = loadImage("Día 2, situación 1.png");
  pcD2S2 = loadImage("Día 2, situación 2.png");
  pcD2S3 = loadImage("Día 2, situación 3.png");
  pcD3S1 = loadImage("Día 3, situación 1.png");
  pcD3S2 = loadImage("Día 3, situación 2.png");
  pcD3S3 = loadImage("Día 3, situación 3.png");
  pcD3S4 = loadImage("Día 3, situación 4.png");
  pcD3S5 = loadImage("Día 3, situación 5.png");
  pcD4S1 = loadImage("Día 4, situación 1.png");
  pcD4S2 = loadImage("Día 4, situación 2.png");
  pcD4S3 = loadImage("Día 4, situación 3.png");
  pcD4S4 = loadImage("Día 4, situación 4.png");
  pcD4S5 = loadImage("Día 4, situación 5.png");
  pcD5S1 = loadImage("Día 5, situación 1.png");
  pcD5S2 = loadImage("Día 5, situación 2.png");
  pcD5S3 = loadImage("Día 5, situación 3.png");
  pcD5S4 = loadImage("Día 5, situación 4.png");
  pcD5S5 = loadImage("Día 5, situación 5.png");
  pcD6S1 = loadImage("Día 6, situación 1.png");
  pcD6S2 = loadImage("Día 6, situación 2.png");
  pcD6S3 = loadImage("Día 6, situación 3.png");
  pcD6S4 = loadImage("Día 6, situación 4.png");
  pcD6S5 = loadImage("Día 6, situación 5.png");
  pcD6S6 = loadImage("Día 6, situación 6.png");
  pcD6S7 = loadImage("Día 6, situación 7.png");
  pcD7S1 = loadImage("Día 7, situación 1.png");
  pcD7S2 = loadImage("Día 7, situación 2.png");
  pcD7S3 = loadImage("Día 7, situación 3.png");
  pcD7S4 = loadImage("Día 7, situación 4.png");
  pcD7S5 = loadImage("Día 7, situación 5.png");
  pcD7S6 = loadImage("Día 7, situación 6.png");
  pcD7S7 = loadImage("Día 7, situación 7.png");
  pcD7Contexto = loadImage("Día 7, contexto.png");
  pcD7Mision = loadImage("Día 7, misión.png");
  pcD7Instrucciones = loadImage("Día 7, instrucciones.png");
  pcReporteDatos = loadImage("reporte final2.png");
  pcReporteDesempeno = loadImage("reporte final.png");
  pcFinalBueno = loadImage("finalBueno.png");
  pcFinalRegular = loadImage("finalRegular.png");
  pcFinalMalo = loadImage("finalMalo.png");
  pcD2Contexto = loadImage("Día 2, mensaje de nivel.png");
  pcD2Instruccion = loadImage("Día 2, mensaje2.png");
  pcD3Nivel = loadImage("Día 3, mensaje de nivel.png");
  pcD3Desafios = loadImage("Día 3, mensaje2.png");
  pcD3Proteccion = loadImage("Día 3, mensaje proteccion.png");
  pcD4Contexto = loadImage("Día 4, contexto.png");
  pcD4Instruccion = loadImage("Día 4, instruccion.png");
  pcD5Intro = loadImage("Día 5, mensaje de nivel.png");
  pcD6Nivel = loadImage("Día 6, mensaje de nivel.png");
  pcD6Contexto = loadImage("Día 6, contexto.png");
  pcD6Instruccion = loadImage("Día 6, instruccion.png");
  pcProgreso1 = loadImage("informe dia1.png");
  pcProgreso2 = loadImage("informe dia2.png");
  pcProgreso3 = loadImage("informe dia3.png");
  pcProgreso4 = loadImage("informe dia4.png");
  pcProgreso5 = loadImage("informe dia5.png");
  pcProgreso6 = loadImage("informe dia6.png");

  /* agrandamos cada imagen UNA sola vez al tamaño exacto de la pantalla. para que el personaje se mueve rapido */
  menuPrincipal.resize(round(1200 * escala), round(843 * escala));
  menuInfo.resize(round(1200 * escala), round(843 * escala));
  menuInfo2.resize(round(1200 * escala), round(843 * escala));
  menuSalir.resize(round(1200 * escala), round(843 * escala));
  elegirPersonaje.resize(round(1200 * escala), round(843 * escala));
  habitacion.resize(round(1200 * escala), round(843 * escala));
  habitacionNino.resize(round(1200 * escala), round(843 * escala));
  pcIntro1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcIntro2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcIntro3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcIntro4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcRegistro.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcInformeRegistro.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcDia1Situacion1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcInformeDia1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcInformeDia.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD2S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD2S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD2S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3S4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3S5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4S4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4S5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5S4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5S5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S6.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6S7.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S6.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7S7.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7Contexto.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7Mision.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD7Instrucciones.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcReporteDatos.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcReporteDesempeno.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcFinalBueno.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcFinalRegular.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcFinalMalo.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD2Contexto.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD2Instruccion.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3Nivel.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3Desafios.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD3Proteccion.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4Contexto.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD4Instruccion.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD5Intro.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6Nivel.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6Contexto.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcD6Instruccion.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso1.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso2.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso3.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso4.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso5.resize(round(1200 * escalaPC), round(675 * escalaPC));
  pcProgreso6.resize(round(1200 * escalaPC), round(675 * escalaPC));

  /* fondos borrosos, copiamos la imagen, la ponemos pequeña mucho, la desenfocamos con BLUR y la volvemos a agrandar al tamaño de toda la pantalla */
  fondoMenuPrincipal = menuPrincipal.copy();
  fondoMenuPrincipal.resize(width / 12, height / 12);
  fondoMenuPrincipal.filter(BLUR, 2);
  fondoMenuPrincipal.resize(width, height);

  fondoMenuInfo = menuInfo.copy();
  fondoMenuInfo.resize(width / 12, height / 12);
  fondoMenuInfo.filter(BLUR, 2);
  fondoMenuInfo.resize(width, height);

  fondoMenuInfo2 = menuInfo2.copy();
  fondoMenuInfo2.resize(width / 12, height / 12);
  fondoMenuInfo2.filter(BLUR, 2);
  fondoMenuInfo2.resize(width, height);

  fondoMenuSalir = menuSalir.copy();
  fondoMenuSalir.resize(width / 12, height / 12);
  fondoMenuSalir.filter(BLUR, 2);
  fondoMenuSalir.resize(width, height);

  fondoElegir = elegirPersonaje.copy();
  fondoElegir.resize(width / 12, height / 12);
  fondoElegir.filter(BLUR, 2);
  fondoElegir.resize(width, height);

  fondoHabitacion = habitacion.copy();
  fondoHabitacion.resize(width / 12, height / 12);
  fondoHabitacion.filter(BLUR, 2);
  fondoHabitacion.resize(width, height);

  fondoHabitacionNino = habitacionNino.copy();
  fondoHabitacionNino.resize(width / 12, height / 12);
  fondoHabitacionNino.filter(BLUR, 2);
  fondoHabitacionNino.resize(width, height);
}

void draw() {
  /* clic es verdadero solo en el momento en que se presiona el mouse */
  clic = mousePressed && !mouseAntes;

  /* teclaNueva es verdadero solo cuando se presiona una tecla nueva */
  teclaNueva = keyPressed && (!teclaAntes || key != ultimaTecla);

  /* pintamos el fondo de toda la pantalla*/
  background(232, 238, 246);

  /* todo se dibuja en tamaño 1200 x 843:*/
  if (pantalla <= 3 || pantalla == 16 || pantalla == 18) {
    translate(offsetX, offsetY);
    scale(escala);
    mx = int((mouseX - offsetX) / escala);
    my = int((mouseY - offsetY) / escala);
  } else {
    translate(offPCX, offPCY);
    scale(escalaPC);
    mx = int((mouseX - offPCX) / escalaPC);
    my = int((mouseY - offPCY) / escalaPC);
  }
  pantallaDibujada = pantalla;

  /* suponemos que el mouse no esta sobre ningun boton cuando empezamosa */
  mano = false;

  /* ponemos el boton de sonido en la habitacion y la pantalla del computador*/
  sobreBotonSonido = false;
  if (pantalla == 3 && mx >= 1018 && mx <= 1062 && my >= 28 && my <= 72) {
    sobreBotonSonido = true;
  }
  if (pantalla >= 4 && pantalla != 11 && pantalla != 14 && pantalla != 16 && pantalla != 18 && mx >= 676 && mx <= 708 && my >= 196 && my <= 228) {
    sobreBotonSonido = true;
  }
  if (sobreBotonSonido) {
    mano = true;
    if (clic) {
      /* si sonaba la apagamos (volumen 0) y si estaba apagada la volvemos a subir */
      if (sonidoActivo) {
        sonidoActivo = false;
        musica.amp(0);
      } else {
        sonidoActivo = true;
        musica.amp(1.0);
      }
      clic = false;
    }
  }

  /* el contador del latido avanza en cada cuadro y vuelve a 0 al llegar a 60 (60 cuadros = 1 segundo) */
  latido = latido + 1;
  if (latido >= 60) {
    latido = 0;
  }

  switch (pantalla) {
    case 0:
      /* resetMatrix quita el translate y el scale para pegar las imagenes ya agrandadas tal cual, pushMatrix y popMatrix guardan y devuelven el translate y el scale para lo demas */
      pushMatrix();
      resetMatrix();
      image(fondoMenuPrincipal, 0, 0);
      image(menuPrincipal, menuX, menuY);
      popMatrix();

      /* boton INICIAR LA MISION */
      if (mx >= 216 && mx <= 990 && my >= 478 && my <= 606) {
        mano = true;
        /* si el mouse se pone encima del botom lo oscurecemos con un rectangulo negro transparente*/
        noStroke();
        fill(0, 0, 0, 45);
        rect(216, 478, 774, 128, 50);
        if (clic) {
          pantalla = 16;
        }
      }
      /* boton INFO */
      if (mx >= 306 && mx <= 584 && my >= 656 && my <= 760) {
        mano = true;
        /* si el mouse se pone encima del botom lo oscurecemos con un rectangulo negro transparente*/
        noStroke();
        fill(0, 0, 0, 45);
        rect(306, 656, 278, 102, 40);
        if (clic) {
          pantalla = 1;
        }
      }
      /* boton SALIR */
      if (mx >= 616 && mx <= 896 && my >= 656 && my <= 758) {
        mano = true;
        /* si el mouse se pone encima del botom lo oscurecemos con un rectangulo negro transparente*/
        noStroke();
        fill(0, 0, 0, 45);
        rect(616, 656, 280, 102, 40);
        if (clic) {
          pantalla = 2;
        }
      }
      break;

    case 16:
      /* ESCOGER PERSONAJE: el jugador decide si juega con la guardiana o con el guardian
         el fondo, los textos y las tarjetas son la imagen hecha en Canva; los GIF se dibujan encima para que se muevan */
      pushMatrix();
      resetMatrix();
      image(fondoElegir, 0, 0);
      image(elegirPersonaje, menuX, menuY);
      popMatrix();

      /* los dos personajes animados dentro de cada tarjeta */
      image(personajeNina, 295, 300, 240, 240);
      image(personajeNino, 665, 300, 240, 240);

      /* si el mouse esta encima de una tarjeta la marcamos con un borde rosado */
      noFill();
      stroke(214, 84, 145);
      strokeWeight(5);
      if (mx >= 270 && mx <= 560 && my >= 280 && my <= 620) {
        mano = true;
        rect(270, 280, 290, 340, 24);
        if (clic) {
          personaje = personajeNina;
          pantalla = 3;
        }
      }
      if (mx >= 640 && mx <= 930 && my >= 280 && my <= 620) {
        mano = true;
        rect(640, 280, 290, 340, 24);
        if (clic) {
          personaje = personajeNino;
          pantalla = 3;
        }
      }
      noStroke();

      /* boton VOLVER al menu, se oscurece al pasar el mouse */
      if (mx >= 530 && mx <= 670 && my >= 650 && my <= 696) {
        mano = true;
        fill(0, 0, 0, 45);
        rect(530, 650, 140, 46, 23);
        if (clic) {
          pantalla = 0;
        }
      }
      break;

    case 1:
      /* INFORMACION DEL JUEGO */
      pushMatrix();
      resetMatrix();
      image(fondoMenuInfo, 0, 0);
      image(menuInfo, menuX, menuY);
      popMatrix();

      /* boton SIGUIENTE para pasar a la segunda pagina */
      if (mx >= 976 && mx <= 1121 && my >= 778 && my <= 804) {
        mano = true;
        noStroke();
        fill(0, 0, 0, 45);
        rect(976, 778, 145, 26, 8);
        if (clic) {
          pantalla = 18;
        }
      }
      break;

    case 18:
      /* INFORMACION DEL JUEGO, PAGINA 2: puntaje, logros y finales */
      pushMatrix();
      resetMatrix();
      image(fondoMenuInfo2, 0, 0);
      image(menuInfo2, menuX, menuY);
      popMatrix();

      /* boton MENU para volver al menu principal */
      if (mx >= 1047 && mx <= 1124 && my >= 790 && my <= 816) {
        mano = true;
        noStroke();
        fill(0, 0, 0, 45);
        rect(1047, 790, 77, 26, 8);
        if (clic) {
          pantalla = 0;
        }
      }
      break;

    case 2:
      /* PANTALLA DE SALIDA */
      pushMatrix();
      resetMatrix();
      image(fondoMenuSalir, 0, 0);
      image(menuSalir, menuX, menuY);
      popMatrix();

      /* exit = boton SALIR es el que cierra el juego*/
      if (mx >= 358 && mx <= 518 && my >= 586 && my <= 634) {
        mano = true;
        noStroke();
        fill(0, 0, 0, 45);
        rect(358, 586, 160, 48, 10);
        if (clic) {
          exit();
        }
      }
      /* boton VOLVER*/
      if (mx >= 666 && mx <= 858 && my >= 586 && my <= 634) {
        mano = true;
        noStroke();
        fill(0, 0, 0, 45);
        rect(666, 586, 192, 48, 10);
        if (clic) {
          pantalla = 0;
        }
      }
      break;

    case 3:
      /* HABITACION */
      pushMatrix();
      resetMatrix();
      /* si el jugador escogio el guardian se muestra la habitacion azul, si no la rosada */
      if (personaje == personajeNino) {
        image(fondoHabitacionNino, 0, 0);
        image(habitacionNino, menuX, menuY);
      } else {
        image(fondoHabitacion, 0, 0);
        image(habitacion, menuX, menuY);
      }
      popMatrix();

      /* boton MENU*/
      if (mx >= 1072 && mx <= 1170 && my >= 28 && my <= 72) {
        mano = true;
        noStroke();
        fill(0, 0, 0, 45);
        rect(1072, 28, 98, 44, 10);
        if (clic) {
          pantalla = 0;
        }
      }

      /* movemos al personaje con las flechas del teclado mientras la tecla este presionada */
      if (keyPressed && key == CODED) {
        if (keyCode == LEFT) {
          personajeX = personajeX - velocidad;
        }
        if (keyCode == RIGHT) {
          personajeX = personajeX + velocidad;
        }
        if (keyCode == UP) {
          personajeY = personajeY - velocidad;
        }
        if (keyCode == DOWN) {
          personajeY = personajeY + velocidad;
        }
      }

      /* no dejamos que el personaje se salga del piso de la habitacion */
      if (personajeX < 20) {
        personajeX = 20;
      }
      if (personajeX > 1200 - tamPersonaje - 20) {
        personajeX = 1200 - tamPersonaje - 20;
      }
      if (personajeY < 200) {
        personajeY = 200;
      }
      if (personajeY > 843 - tamPersonaje - 20) {
        personajeY = 843 - tamPersonaje - 20;
      }

      /* dibujamos al personaje */
      image(personaje, personajeX, personajeY, tamPersonaje, tamPersonaje);

      /* revisamos si el personaje llego al computador (el escritorio esta entre x 560 y 720)
         usamos el centro del personaje y la altura de sus pies */
      cercaDelComputador = false;
      if (personajeX + tamPersonaje / 2 >= 560 && personajeX + tamPersonaje / 2 <= 720
          && personajeY + tamPersonaje >= 380 && personajeY + tamPersonaje <= 520) {
        cercaDelComputador = true;
      }

      /* caja de dialogo rosadita*/
      noStroke();
      fill(245, 147, 191);
      rect(150, 700, 900, 80, 25);
      fill(255);
      textSize(24);
      textAlign(LEFT, CENTER);
      if (cercaDelComputador) {
        text("Presiona ESPACIO para usar el computador.", 190, 740);
      } else {
        text("Usa las flechas del teclado para acercarte al computador.", 190, 740);
      }

      /* si esta cerca y presiona espacio hacemos que entre al computador */
      if (cercaDelComputador && keyPressed && key == ' ') {
        pantalla = pantallaComputador;
      }
      break;

    case 15:
      /* previo contexto de la historia antes de empezar */
      switch (pasoDialogo) {
        case 1:
          imagenIntro = pcIntro1;
          break;
        case 2:
          imagenIntro = pcIntro2;
          break;
        case 3:
          imagenIntro = pcIntro3;
          break;
        default:
          imagenIntro = pcIntro4;
      }
      pushMatrix();
      resetMatrix();
      image(imagenIntro, pcX, pcY);
      popMatrix();

      /* el personaje escogido va en el espacio de la izquierda */
      image(personaje, 249, 332, 251, 251);

      /* caja de dialogo abajo */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(20);
      textAlign(LEFT, CENTER);
      text("Mensaje " + pasoDialogo + " de 4: conoce tu mision antes de registrarte.", 185, 671, 830, 58);
      textSize(17);
      textAlign(RIGHT, CENTER);
      text("click para continuar >>", 1020, 742);
      
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (clic) {
          pasoDialogo = pasoDialogo + 1;
          /* despues del cuarto mensaje empieza el registro */
          if (pasoDialogo > 4) {
            pasoDialogo = 1;
            pantalla = 4;
          }
        }
      }
      break;
      
    case 4:
      /*registro*/
      pushMatrix();
      resetMatrix();
      image(pcRegistro, pcX, pcY);
      popMatrix();

      /* el personaje escogido va junto a los recuadros */
      image(personaje, 705, 447, 195, 195);
      
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      }

      /* si el mouse esta sobre un recuadro donde se puede escribir*/
      if (diaJuego == 1) {
        if ((mx >= 292 && mx <= 600 && my >= 301 && my <= 351) || (mx >= 292 && mx <= 505 && my >= 399 && my <= 448)
            || (my >= 495 && my <= 545 && ((mx >= 292 && mx <= 424) || (mx >= 440 && mx <= 555) || (mx >= 570 && mx <= 685)))) {
          mano = true;
        }
      }
      if ((my >= 601 && my <= 651 && ((mx >= 292 && mx <= 379) || (mx >= 398 && mx <= 514) || (mx >= 533 && mx <= 649)))
          || (mx >= 705 && mx <= 898 && my >= 330 && my <= 389)) {
        mano = true;
      }

      /* al hacer clic en un recuadro se puede escribir ahi */
      if (clic) {
        /* nombre, edad y fecha solo se escriben el dia 1, los otros dias la fecha se calcula sola */
        if (diaJuego == 1) {
          if (mx >= 292 && mx <= 600 && my >= 301 && my <= 351) {
            campoActivo = 1;
          }
          if (mx >= 292 && mx <= 505 && my >= 399 && my <= 448) {
            campoActivo = 2;
          }
          if (mx >= 292 && mx <= 424 && my >= 495 && my <= 545) {
            campoActivo = 3;
          }
          if (mx >= 440 && mx <= 555 && my >= 495 && my <= 545) {
            campoActivo = 4;
          }
          if (mx >= 570 && mx <= 685 && my >= 495 && my <= 545) {
            campoActivo = 5;
          }
        }
        if (mx >= 292 && mx <= 379 && my >= 601 && my <= 651) {
          campoActivo = 6;
        }
        if (mx >= 398 && mx <= 514 && my >= 601 && my <= 651) {
          campoActivo = 7;
        }
        if (mx >= 533 && mx <= 649 && my >= 601 && my <= 651) {
          campoActivo = 8;
        }
        if (mx >= 705 && mx <= 898 && my >= 330 && my <= 389) {
          campoActivo = 9;
        }
      }

  
      if (teclaNueva) {
        if (key == BACKSPACE) {
          switch (campoActivo) {
            case 1:
              if (txtNombre.length() > 0) {
                txtNombre = txtNombre.substring(0, txtNombre.length() - 1);
              }
              break;
            case 2:
              if (txtEdad.length() > 0) {
                txtEdad = txtEdad.substring(0, txtEdad.length() - 1);
              }
              break;
            case 3:
              if (txtAño.length() > 0) {
                txtAño = txtAño.substring(0, txtAño.length() - 1);
              }
              break;
            case 4:
              if (txtMes.length() > 0) {
                txtMes = txtMes.substring(0, txtMes.length() - 1);
              }
              break;
            case 5:
              if (txtDia.length() > 0) {
                txtDia = txtDia.substring(0, txtDia.length() - 1);
              }
              break;
            case 6:
              if (txtHora.length() > 0) {
                txtHora = txtHora.substring(0, txtHora.length() - 1);
              }
              break;
            case 7:
              if (txtMinuto.length() > 0) {
                txtMinuto = txtMinuto.substring(0, txtMinuto.length() - 1);
              }
              break;
            case 8:
              if (txtFranja.length() > 0) {
                txtFranja = txtFranja.substring(0, txtFranja.length() - 1);
              }
              break;
            case 9:
              if (txtHoras.length() > 0) {
                txtHoras = txtHoras.substring(0, txtHoras.length() - 1);
              }
              break;
          }
        } else {
          if (key == TAB) {
            /* TAB pasa al siguiente recuadro */
            campoActivo = campoActivo + 1;
            if (campoActivo > 9) {
              if (diaJuego == 1) {
                campoActivo = 1;
              } else {
                campoActivo = 6;
              }
            }
          } else {
            if (key == ENTER || key == RETURN) {
              intentarRegistro = true;
            } else {
              if (key != CODED) {
                /* el nombre acepta cualquier letra, los demas recuadros solo numeros, y el de la franja horaria solo las letras necesaria*/
                switch (campoActivo) {
                  case 1:
                    if (txtNombre.length() < 18) {
                      txtNombre = txtNombre + key;
                    }
                    break;
                  case 2:
                    if (key >= '0' && key <= '9' && txtEdad.length() < 3) {
                      txtEdad = txtEdad + key;
                    }
                    break;
                  case 3:
                    if (key >= '0' && key <= '9' && txtAño.length() < 4) {
                      txtAño = txtAño + key;
                    }
                    break;
                  case 4:
                    if (key >= '0' && key <= '9' && txtMes.length() < 2) {
                      txtMes = txtMes + key;
                    }
                    break;
                  case 5:
                    if (key >= '0' && key <= '9' && txtDia.length() < 2) {
                      txtDia = txtDia + key;
                    }
                    break;
                  case 6:
                    if (key >= '0' && key <= '9' && txtHora.length() < 2) {
                      txtHora = txtHora + key;
                    }
                    break;
                  case 7:
                    if (key >= '0' && key <= '9' && txtMinuto.length() < 2) {
                      txtMinuto = txtMinuto + key;
                    }
                    break;
                  case 8:
                    if ((key == 'a' || key == 'A' || key == 'p' || key == 'P' || key == 'm' || key == 'M') && txtFranja.length() < 2) {
                      txtFranja = (txtFranja + key).toUpperCase();
                    }
                    break;
                  case 9:
                    if (key >= '0' && key <= '9' && txtHoras.length() < 2) {
                      txtHoras = txtHoras + key;
                    }
                    break;
                }
              }
            }
          }
        }
      }

      /* escribimos el texto dentro de cada recuadro */
      fill(214, 84, 145);
      textSize(26);
      textAlign(LEFT, CENTER);
      text(txtNombre, 312, 326);
      text(txtEdad, 312, 424);
      text(txtAño, 310, 520);
      text(txtMes, 458, 520);
      text(txtDia, 588, 520);
      text(txtHora, 308, 626);
      text(txtMinuto, 416, 626);
      text(txtFranja, 552, 626);
      text(txtHoras, 725, 360);

      /* marcamos con un borde el recuadro */
      noFill();
      stroke(214, 84, 145);
      strokeWeight(3);
      switch (campoActivo) {
        case 1:
          rect(292, 301, 308, 50, 25);
          break;
        case 2:
          rect(292, 399, 213, 49, 25);
          break;
        case 3:
          rect(292, 495, 132, 50, 25);
          break;
        case 4:
          rect(440, 495, 115, 50, 25);
          break;
        case 5:
          rect(570, 495, 115, 50, 25);
          break;
        case 6:
          rect(292, 601, 87, 50, 25);
          break;
        case 7:
          rect(398, 601, 116, 50, 25);
          break;
        case 8:
          rect(533, 601, 116, 50, 25);
          break;
        case 9:
          rect(705, 330, 193, 59, 25);
          break;
      }
      noStroke();

      /* caja de dialogo abajo de instrucciones o errores */
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(19);
      textAlign(LEFT, CENTER);
      if (mensajeError.equals("")) {
        if (diaJuego > 1 && minutoLibreDiaSiguiente > 0 && campoActivo >= 6 && campoActivo <= 8) {
          text("Tu sesion de ayer termino hoy a las " + finSesionAnterior + ". Escribe una hora de inicio despues de esa.", 185, 671, 620, 82);
        } else {
          switch (campoActivo) {
            case 1:
              text("Escribe tu NOMBRE. Con TAB pasas al siguiente recuadro.", 185, 671, 620, 82);
              break;
            case 2:
              text("Escribe tu EDAD (de 1 a 120 años).", 185, 671, 620, 82);
              break;
            case 3:
            case 4:
            case 5:
              text("Escribe la FECHA en que empieza tu semana digital: año, mes y dia (por ejemplo 2026 / 11 / 18).", 185, 671, 620, 82);
              break;
            case 6:
            case 7:
            case 8:
              text("Escribe la HORA en que EMPIEZAS hoy (ej: 9 : 00 AM). Tip: entre 8 a.m. y 8 p.m. no sumas riesgo.", 185, 671, 620, 82);
              break;
            default:
              text("¿CUÁNTAS HORAS usarás hoy las redes? (de 1 a 23). Tip: 3 horas o menos no suman riesgo. Luego pulsa CONTINUAR.", 185, 671, 620, 82);
          }
        }
      } else {
        text(mensajeError, 185, 671, 620, 82);
      }

      /* boton CONTINUAR*/
      fill(255);
      if (mx >= 830 && mx <= 1020 && my >= 684 && my <= 740) {
        fill(225, 215, 222);
        mano = true;
        if (clic) {
          intentarRegistro = true;
        }
      }
      rect(830, 684, 190, 56, 28);
      fill(214, 84, 145);
      textSize(24);
      textAlign(CENTER, CENTER);
      text("CONTINUAR", 925, 711);

      /* VALIDACION */
      if (intentarRegistro) {
        intentarRegistro = false;
        mensajeError = "";

        if (txtNombre.trim().equals("")) {
          mensajeError = "Error: Debes ingresar un nombre";
        }

        edad = int(txtEdad);
        if (mensajeError.equals("") && (edad < 1 || edad > 120)) {
          mensajeError = "Error: La edad debe estar entre 1 y 120";
        }

        año = int(txtAño);
        if (mensajeError.equals("") && año < 1900) {
          mensajeError = "Error: el año debe ser mayor o igual a 1900";
        }

        mes = int(txtMes);
        if (mensajeError.equals("") && (mes < 1 || mes > 12)) {
          mensajeError = "Error: el mes debe estar entre 1 y 12";
        }

        /* cantidad de dias del mes para febrero (case 2) */
        switch (mes) {
          case 2:
            /* año bisiesto, si es divisible entre 4, excepto los divisibles entre 100, salvo que tambien lo sean entre 400*/
            if ((año % 400 == 0) || ((año % 4 == 0) && (año % 100 != 0))) {
              diasDelMes = 29;
            } else {
              diasDelMes = 28;
            }
            break;
          case 4:
          case 6:
          case 9:
          case 11:
            diasDelMes = 30;
            break;
          default:
            diasDelMes = 31;
        }

        dia = int(txtDia);
        if (mensajeError.equals("") && (dia < 1 || dia > diasDelMes)) {
          mensajeError = "Error: el dia debe estar entre 1 y " + diasDelMes;
        }

        hora = int(txtHora);
        if (mensajeError.equals("") && (hora < 1 || hora > 12)) {
          mensajeError = "Error: la hora debe estar entre 1 y 12";
        }

        minuto = int(txtMinuto);
        if (mensajeError.equals("") && (txtMinuto.equals("") || minuto < 0 || minuto > 59)) {
          mensajeError = "Error: los minutos deben estar entre 0 y 59";
        }

        franjaHoraria = txtFranja;
        if (mensajeError.equals("") && !franjaHoraria.equals("AM") && !franjaHoraria.equals("PM")) {
          mensajeError = "Error: la franja horaria debe ser AM o PM";
        }

        cantidadHoras = int(txtHoras);
        if (mensajeError.equals("") && (cantidadHoras < 1 || cantidadHoras > 23)) {
          mensajeError = "Error: las horas en redes sociales deben estar entre 1 y 23";
        }

        /* la sesion de hoy no puede empezar antes de que termine la de ayer (si ayer paso la media noche) */
        if (mensajeError.equals("")) {
          horaMilitar = hora;
          if (franjaHoraria.equals("PM") && hora != 12) {
            horaMilitar = hora + 12;
          } else {
            if (franjaHoraria.equals("AM") && hora == 12) {
              horaMilitar = 0;
            }
          }
          minutosEntrada = horaMilitar * 60 + minuto;
          if (minutosEntrada < minutoLibreDiaSiguiente) {
            mensajeError = "Error: esa hora se cruza con tu sesion anterior, que termino a las " + finSesionAnterior;
          }
        }

        /* si no hubo ningun error, el registro queda listo y empezamos calculos de jornada */
        if (mensajeError.equals("")) {
          nombre = txtNombre.trim();

          /* calculamos la hora en formato militar*/
          horaMilitar = hora;
          if (franjaHoraria.equals("PM") && hora != 12) {
            horaMilitar = hora + 12;
          } else {
            if (franjaHoraria.equals("AM") && hora == 12) {
              horaMilitar = 0;
            }
          }

          /* minutos de entrada desde la media noche que son la hora militar * 60 mas los minutos */
          minutosEntrada = horaMilitar * 60 + minuto;

          /* minutos de salida, a estos le sumamos las horas de redes sociales convertidas a minutos */
          minutosSalida = minutosEntrada + cantidadHoras * 60;

          /* un dia tiene 1440 minutos, entonces si la salida pasa de 1440 la division da 1*/
          diaAdicional = minutosSalida / 1440;

          /* hora y minutos de salida */
          horaDeSalida = (minutosSalida % 1440) / 60;
          minutoDeSalida = minutosSalida % 60;

          /* se adiciona un segundo a la hora de salida pra cumplir los requerimientos */
          segundoDelDiaSalida = 1;

          /* fecha de salida, es la misma de entrada a menos que la sesion pase de media noche */
          diaSalida = dia;
          mesSalida = mes;
          añoSalida = año;
          if (diaAdicional == 1) {
            diaSalida = dia + 1;
            if (diaSalida > diasDelMes) {
              diaSalida = 1;
              mesSalida = mesSalida + 1;
              if (mesSalida > 12) {
                mesSalida = 1;
                añoSalida = añoSalida + 1;
              }
            }
          }

          /* Analisis de tiempo de uso*/
          mensajeRiesgo = "Tu tiempo de conexion no ha generado puntos de riesgo por duracion en esta evaluacion.";
          puntuacionDia = 0;
          if (cantidadHoras > 3 && cantidadHoras < 8) {
            puntuacionDia = puntuacionDia + 4;
            mensajeRiesgo = "Tu tiempo de conexion ha generado " + puntuacionDia + " puntos de riesgo digital. Pasar varias horas conectado puede afectar tu descanso, tu rendimiento academico y tus relaciones personales.";
          } else {
            if (cantidadHoras >= 8) {
              puntuacionDia = puntuacionDia + 7;
              mensajeRiesgo = "Tu tiempo de conexion ha generado " + puntuacionDia + " puntos de riesgo digital. Esta cantidad de tiempo puede desplazar actividades importantes como dormir, estudiar, hacer ejercicio o compartir con tus seres queridos.";
            }
          }

          /* Analisis del horario saludable o no saludable */
          mensajeRiesgo2 = "Tu jornada comienza y termina dentro del horario saludable. No se han sumado puntos de riesgo por horario.";
          if (minutosEntrada < 480 || minutosSalida > 1200) {
            puntuacionDia = puntuacionDia + 4;
            mensajeRiesgo2 = "Tu jornada comienza o termina fuera del horario saludable establecido para la mision, por esta razon se han sumado 4 puntos de riesgo.";
          }

          /* formateamos dia, mes, hora y minutos a 2 digitoscon las variables previamnete creadas*/
          if (dia >= 1 && dia <= 9) {
            diaf = "0" + dia;
          } else {
            diaf = "" + dia;
          }
          if (mes >= 1 && mes <= 9) {
            mesf = "0" + mes;
          } else {
            mesf = "" + mes;
          }
          if (hora >= 0 && hora <= 9) {
            horaf = "0" + hora;
          } else {
            horaf = "" + hora;
          }
          if (minuto >= 0 && minuto <= 9) {
            minutof = "0" + minuto;
          } else {
            minutof = "" + minuto;
          }
          if (diaSalida >= 1 && diaSalida <= 9) {
            diaSalidaf = "0" + diaSalida;
          } else {
            diaSalidaf = "" + diaSalida;
          }
          if (mesSalida >= 1 && mesSalida <= 9) {
            mesSalidaf = "0" + mesSalida;
          } else {
            mesSalidaf = "" + mesSalida;
          }
          if (horaDeSalida >= 0 && horaDeSalida <= 9) {
            horaDeSalidaf = "0" + horaDeSalida;
          } else {
            horaDeSalidaf = "" + horaDeSalida;
          }
          if (minutoDeSalida >= 0 && minutoDeSalida <= 9) {
            minutoDeSalidaf = "0" + minutoDeSalida;
          } else {
            minutoDeSalidaf = "" + minutoDeSalida;
          }
          segundoDelDiaSalidaf = "0" + segundoDelDiaSalida;

          /* guardamos la hora de ingreso del primer dia y la hora de salida del ultimo dia para reporte final */
          if (diaJuego == 1) {
            horaIngresoInicial = diaf + "/" + mesf + "/" + año + " " + horaf + ":" + minutof + " " + franjaHoraria;
          }
          horaSalidaFinal = diaSalidaf + "/" + mesSalidaf + "/" + añoSalida + " " + horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf;

          /* si la sesion se paso de la media noche guardamos desde que minuto puede empezar la de mañana*/
          if (diaAdicional == 1) {
            minutoLibreDiaSiguiente = (minutosSalida - 1440) + 1;
            finSesionAnterior = horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf;
          } else {
            minutoLibreDiaSiguiente = 0;
            finSesionAnterior = "";
          }

          /* pasamos al informe y empezamos los mensajes desde el primero */
          pasoDialogo = 1;
          pantalla = 5;
        }
      }
      break;

    case 5:
      /*INFORME DEL REGISTRO */
      pushMatrix();
      resetMatrix();
      image(pcInformeRegistro, pcX, pcY);
      popMatrix();

      /* llenamos los recuadros del informe con los datos y los calculos */
      fill(214, 84, 145);
      textSize(24);
      textAlign(LEFT, CENTER);
      text(nombre, 312, 326);
      text(cantidadHoras + " horas", 662, 326);
      text(edad + " años", 312, 423);
      text(diaSalidaf + "/" + mesSalidaf + "/" + añoSalida, 662, 423);
      text(diaf + "/" + mesf + "/" + año, 312, 520);
      text(horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf, 662, 520);
      text(horaf + ":" + minutof + " " + franjaHoraria, 312, 627);
      text(puntuacionDia + " puntos", 662, 628);

      /* caja de dialogo abajo, un mensaje a la vez, cada clic pasar al siguiente */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(18);
      textAlign(LEFT, CENTER);
      switch (pasoDialogo) {
        case 1:
          text(nombre + " tu jornada ha sido registrada exitosamente en la boveda digital.", 185, 671, 830, 58);
          break;
        case 2:
          text(mensajeRiesgo, 185, 671, 830, 58);
          break;
        case 3:
          text(mensajeRiesgo2, 185, 671, 830, 58);
          break;
        case 4:
          text("Evaluacion inicial de riesgo: " + puntuacionDia + " puntos.", 185, 671, 830, 58);
          break;
        case 5:
          if (diaJuego == 1) {
            text("Tu primera mision comienza ahora.", 185, 671, 830, 58);
          } else {
            text("La mision del dia " + diaJuego + " comienza ahora.", 185, 671, 830, 58);
          }
          break;
      }
      textSize(17);
      textAlign(RIGHT, CENTER);
      text("click para continuar >>", 1020, 742);

      /* volver habitacion nuevamente en caso de x */
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        /* cualquier otro clic pasa al siguiente mensaje, despues del ultimo empieza la mision */
        if (clic) {
          pasoDialogo = pasoDialogo + 1;
          if (pasoDialogo > 5) {
            pasoDialogo = 1;
            if (diaJuego == 1) {
              pantalla = 6;
            } else {
              numPregunta = 1;
              respondida = false;
              aciertosDia = 0;
              if (diaJuego == 7) {
                vidaDrDatos = 100;
                vidaMostrada = 100;
                golpe = 0;
              }
              pantalla = 10;
            }
          }
        }
      }
      break;

    case 6:
      /*MISION DEL DIA 1 - REDES SOCIALES */
      pushMatrix();
      resetMatrix();
      image(pcDia1Situacion1, pcX, pcY);
      popMatrix();

      /* marcamos con un borde el contenido que ya se escogio como la primera eleccion de comenido */
      noFill();
      stroke(214, 84, 145);
      strokeWeight(4);
      switch (contenido1) {
        case 1:
          rect(349, 404, 232, 48, 20);
          break;
        case 2:
          rect(349, 475, 232, 48, 20);
          break;
        case 3:
          rect(349, 543, 232, 48, 20);
          break;
        case 4:
          rect(620, 404, 231, 48, 20);
          break;
        case 5:
          rect(620, 475, 231, 48, 20);
          break;
        case 6:
          rect(620, 543, 231, 48, 20);
          break;
        case 7:
          rect(486, 610, 231, 48, 20);
          break;
      }
      noStroke();

      /* mientras salen los mensajes de abajo oscurecemos toda la pantalla con un rectangulo negro casi transparente, asi resalta solo la caja de dialogo*/
      if (pasoDialogo < 4) {
        pushMatrix();
        resetMatrix();
        noStroke();
        fill(0, 0, 0, 120);
        rect(0, 0, width, height);
        popMatrix();
      }

      /* caja de dialogo*/
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(19);
      textAlign(LEFT, CENTER);
      switch (pasoDialogo) {
        case 1:
          text("En ciudad digital cada publicacion, noticia o video puede influir en tus decisiones.", 185, 671, 830, 58);
          break;
        case 2:
          text("Dr. Datos aprovecha la informacion engañosa y los descuidos de privacidad para debilitar las bovedas de los ciudadanos.", 185, 671, 830, 58);
          break;
        case 3:
          text("¡Ayudanos a descubrir que tipo de contenido has consumido!", 185, 671, 830, 58);
          break;
        case 4:
          if (!mensajeError.equals("")) {
            text(mensajeError, 185, 671, 830, 58);
          } else {
            if (contenido1 == 0) {
              text("Selecciona el PRIMER tipo de contenido que hayas consumido en tu jornada.", 185, 671, 830, 58);
            } else {
              text("Ahora selecciona el SEGUNDO tipo de contenido (debe ser distinto al primero).", 185, 671, 830, 58);
            }
          }
          break;
      }
      if (pasoDialogo < 4) {
        textSize(17);
        textAlign(RIGHT, CENTER);
        text("click para continuar >>", 1020, 742);
      }

      /* revisamos en que boton esta el mouse*/
      botonElegido = 0;
      if (mx >= 349 && mx <= 581 && my >= 404 && my <= 452) {
        botonElegido = 1;
      }
      if (mx >= 349 && mx <= 581 && my >= 475 && my <= 523) {
        botonElegido = 2;
      }
      if (mx >= 349 && mx <= 581 && my >= 543 && my <= 590) {
        botonElegido = 3;
      }
      if (mx >= 620 && mx <= 851 && my >= 404 && my <= 452) {
        botonElegido = 4;
      }
      if (mx >= 620 && mx <= 851 && my >= 475 && my <= 523) {
        botonElegido = 5;
      }
      if (mx >= 620 && mx <= 851 && my >= 543 && my <= 590) {
        botonElegido = 6;
      }
      if (mx >= 486 && mx <= 717 && my >= 610 && my <= 658) {
        botonElegido = 7;
      }
      if (botonElegido > 0 && pasoDialogo == 4) {
        mano = true;
        /* oscurecemos el boton que esta debajo del mouse */
        noStroke();
        fill(0, 0, 0, 40);
        switch (botonElegido) {
          case 1:
            rect(349, 404, 232, 48, 20);
            break;
          case 2:
            rect(349, 475, 232, 48, 20);
            break;
          case 3:
            rect(349, 543, 232, 48, 20);
            break;
          case 4:
            rect(620, 404, 231, 48, 20);
            break;
          case 5:
            rect(620, 475, 231, 48, 20);
            break;
          case 6:
            rect(620, 543, 231, 48, 20);
            break;
          default:
            rect(486, 610, 231, 48, 20);
        }
      }

      /* boton X para salir*/
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (clic) {
          if (pasoDialogo < 4) {
            /* mientras haya mensajes, el clic pasa al otro que sigue */
            pasoDialogo = pasoDialogo + 1;
          } else {
            if (botonElegido > 0) {
              if (contenido1 == 0) {
                /* primera eleccion */
                contenido1 = botonElegido;
                mensajeError = "";
              } else {
                if (botonElegido == contenido1) {
                  mensajeError = "Error: debes elegir una opcion distinta al primer contenido";
                } else {
                  /* segunda eleccion*/
                  contenido2 = botonElegido;
                  mensajeError = "";

                  /* se asignan las puntuaciones de cada contenido para la primera eleccion y se acumulan ndecisiones correctas e incorrectas para reporte*/
                  switch (contenido1) {
                    case 1:
                      puntuacionContenido1 = -2;
                      nombreContenido1 = "Contenido educativo";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 2:
                      puntuacionContenido1 = -2;
                      nombreContenido1 = "Noticias verificadas";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 3:
                      puntuacionContenido1 = -1;
                      nombreContenido1 = "Contenido cultural";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 4:
                      puntuacionContenido1 = 0;
                      nombreContenido1 = "Entretenimiento";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 5:
                      puntuacionContenido1 = 3;
                      nombreContenido1 = "Noticias falsas";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                    case 6:
                      puntuacionContenido1 = 4;
                      nombreContenido1 = "Contenido violento";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                    case 7:
                      puntuacionContenido1 = 3;
                      nombreContenido1 = "Informacion engañosa";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                  }
                  /* se asignan las puntuaciones de cada contenido para la segunda eleccion */
                  switch (contenido2) {
                    case 1:
                      puntuacionContenido2 = -2;
                      nombreContenido2 = "Contenido educativo";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 2:
                      puntuacionContenido2 = -2;
                      nombreContenido2 = "Noticias verificadas";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 3:
                      puntuacionContenido2 = -1;
                      nombreContenido2 = "Contenido cultural";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 4:
                      puntuacionContenido2 = 0;
                      nombreContenido2 = "Entretenimiento";
                      decisionesCorrectas = decisionesCorrectas + 1;
                      break;
                    case 5:
                      puntuacionContenido2 = 3;
                      nombreContenido2 = "Noticias falsas";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                    case 6:
                      puntuacionContenido2 = 4;
                      nombreContenido2 = "Contenido violento";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                    case 7:
                      puntuacionContenido2 = 3;
                      nombreContenido2 = "Informacion engañosa";
                      decisionesIncorrectas = decisionesIncorrectas + 1;
                      break;
                  }

                  /* sumamos los puntos de los dos contenidos al riesgo del dia */
                  puntuacionDia = puntuacionDia + puntuacionContenido1 + puntuacionContenido2;
                  /* validamos que el puntaje de riesgo no sea negativo */
                  if (puntuacionDia < 0) {
                    puntuacionDia = 0;
                  }

                  /* si el contenido no da riesgo sube la proteccion y si da riesgo la baja */
                  if (puntuacionContenido1 <= 0) {
                    proteccion = proteccion + 10;
                  } else {
                    proteccion = proteccion - penalizacionNivel;
                  }
                  if (puntuacionContenido2 <= 0) {
                    proteccion = proteccion + 10;
                  } else {
                    proteccion = proteccion - penalizacionNivel;
                  }
                  if (proteccion < 0) {
                    proteccion = 0;
                  } else {
                    if (proteccion > 100) {
                      proteccion = 100;
                    }
                  }

                  /* infrome mision */
                  pasoDialogo = 1;
                  pantalla = 7;
                }
              }
            }
          }
        }
      }
      break;

    case 7:
      /*INFORME DE LA MISION DEL DIA 1 */
      pushMatrix();
      resetMatrix();
      image(pcInformeDia1, pcX, pcY);
      popMatrix();

      /* llenamos los recuadros con lo que se escogio y sus puntos */
      fill(214, 84, 145);
      textSize(20);
      textAlign(LEFT, CENTER);
      text(nombreContenido1, 310, 347);
      text(puntuacionContenido1 + " puntos", 310, 436);
      text(nombreContenido2, 310, 525);
      text(puntuacionContenido2 + " puntos", 310, 615);
      textAlign(CENTER, CENTER);
      textSize(26);
      text(puntuacionDia + " puntos", 766, 491);

      /* caja de dialogo de abajo */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(19);
      textAlign(LEFT, CENTER);
      switch (pasoDialogo) {
        case 1:
          text("Analisis completado, " + nombre + ". Hemos estudiado el contenido de tu jornada y actualizado el nivel de riesgo de tu boveda digital.", 185, 671, 830, 58);
          break;
        case 2:
          text("Recuerda que no se trata de juzgar tus gustos sino de reconocer como nuestras actividades digitales pueden influir en nuestra seguridad.", 185, 671, 830, 58);
          break;
        case 3:
          text("A continuacion encontraras los resultados de tu analisis y el puntaje acumulado hasta este momento de la mision.", 185, 671, 830, 58);
          break;
        case 4:
          text("Gracias por completar el analisis " + nombre + ", cada decision cuenta para proteger tu boveda digital.", 185, 671, 830, 58);
          break;
      }
      textSize(17);
      textAlign(RIGHT, CENTER);
      text("click para continuar >>", 1020, 742);

      /* volver a la habitacion*/
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (clic) {
          pasoDialogo = pasoDialogo + 1;
          if (pasoDialogo > 4) {
            pasoDialogo = 1;
            pantalla = 11;
          }
        }
      }
      break;

    case 8:
      /* INFORME DE LA BOVEDA DIGITAL DEL DIA */
      pushMatrix();
      resetMatrix();
      image(pcInformeDia, pcX, pcY);
      popMatrix();

      /* el personaje escogido va a la derecha del informe */
      image(personaje, 740, 341, 194, 194);

      /* escribimos los datos del informe, color azulito*/
      fill(113, 197, 241);
      textSize(17);
      textAlign(LEFT, CENTER);
      text("ANALISIS COMPLETADO, " + nombre.toUpperCase(), 298, 345);
      text("DIA " + diaJuego + " - ACTIVIDAD COMPLETADA", 298, 368);
      text("DECISIONES CORRECTAS ACUMULADAS: " + decisionesCorrectas, 298, 450);
      text("DECISIONES INCORRECTAS ACUMULADAS: " + decisionesIncorrectas, 298, 473);
      text("LOGROS DESBLOQUEADOS: " + logrosObtenidos, 298, 496);
      text("TU PUNTAJE DE RIESGO DIGITAL: " + puntajeDigitalAcumulado, 298, 583);
      text("LA PROTECCION ACTUAL DE TU BOVEDA ES: " + proteccion + "/100", 298, 605);
      text("GRACIAS POR COMPLETAR LA ACTIVIDAD DE HOY, " + nombre.toUpperCase() + ",", 298, 632);
      text("CADA DECISION CUENTA PARA PROTEGER TU BOVEDA DIGITAL.", 298, 652);

      /* caja de dialogo */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(19);
      textAlign(LEFT, CENTER);
      text(mensajeCierre, 185, 671, 830, 58);
      textSize(17);
      textAlign(RIGHT, CENTER);
      text("click para continuar >>", 1020, 742);
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (clic) {
          /* despues de la batalla final vamos directo al ultimo reporte */
          if (diaJuego == 7) {
            pantalla = 14;
          } else {
            pantalla = 12;
          }
        }
      }
      break;

    case 10:
      /* INTRODUCCION DE LA MISION DEL DIA
         cada mensaje es una imagen del equipo; con el switch elegimos cual mostrar segun el dia y el mensaje */
      switch (diaJuego) {
        case 2:
          totalIntro = 2;
          switch (pasoDialogo) {
            case 1:
              imagenIntro = pcD2Contexto;
              break;
            default:
              imagenIntro = pcD2Instruccion;
          }
          break;
        case 3:
          totalIntro = 3;
          switch (pasoDialogo) {
            case 1:
              imagenIntro = pcD3Nivel;
              break;
            case 2:
              imagenIntro = pcD3Desafios;
              break;
            default:
              imagenIntro = pcD3Proteccion;
          }
          break;
        case 4:
          totalIntro = 2;
          switch (pasoDialogo) {
            case 1:
              imagenIntro = pcD4Contexto;
              break;
            default:
              imagenIntro = pcD4Instruccion;
          }
          break;
        case 5:
          totalIntro = 1;
          imagenIntro = pcD5Intro;
          break;
        case 6:
          totalIntro = 3;
          switch (pasoDialogo) {
            case 1:
              imagenIntro = pcD6Nivel;
              break;
            case 2:
              imagenIntro = pcD6Contexto;
              break;
            default:
              imagenIntro = pcD6Instruccion;
          }
          break;
        default:
          totalIntro = 3;
          switch (pasoDialogo) {
            case 1:
              imagenIntro = pcD7Contexto;
              break;
            case 2:
              imagenIntro = pcD7Mision;
              break;
            default:
              imagenIntro = pcD7Instrucciones;
          }
      }

      pushMatrix();
      resetMatrix();
      image(imagenIntro, pcX, pcY);
      popMatrix();

      /* el personaje escogido va en el espacio de la izquierda */
      image(personaje, 250, 371, 252, 252);

      /* aparece doctor datos */
      if (diaJuego == 7) {
        image(drDatosFeliz, 955, 380, 230, 230);
      }

      /* en el mensaje de la proteccion escribimos el valor dentro del recuadro */
      if (diaJuego == 3 && pasoDialogo == 3) {
        fill(214, 84, 145);
        textSize(30);
        textAlign(CENTER, CENTER);
        text(proteccion + "/100", 699, 535);
      }

      /* caja de dialogo de abajo */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(20);
      textAlign(LEFT, CENTER);
      text("Mensaje " + pasoDialogo + " de " + totalIntro + ": lee con atencion antes de empezar la mision.", 185, 671, 830, 58);
      textSize(17);
      textAlign(RIGHT, CENTER);
      text("click para continuar >>", 1020, 742);

      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (clic) {
          pasoDialogo = pasoDialogo + 1;
          if (pasoDialogo > totalIntro) {
            pasoDialogo = 1;
            pantalla = 9;
          }
        }
      }
      break;

    case 9:
      /*PREGUNTA DE LA MISION*/

      /* cuantas preguntas tiene cada dia */
      switch (diaJuego) {
        case 2:
          totalPreguntas = 3;
          break;
        case 6:
        case 7:
          totalPreguntas = 7;
          break;
        default:
          totalPreguntas = 5;
      }

      switch (diaJuego * 10 + numPregunta) {
        case 21:
          imagenPregunta = pcD2S1;
          b1x = 349; b1y = 594; b1w = 232; b1h = 48;
          b2x = 620; b2y = 594; b2w = 231; b2h = 48;
          numOpciones = 2;
          correcta = 1;
          mensaje1 = "¡Correcto! El hecho inicial tiene respaldo, pero el titular exagera y distorsiona la informacion.";
          mensaje2 = "¡Incorrecto! El hecho inicial si tiene respaldo, pero el titular exagera y distorsiona la informacion.";
          break;
        case 22:
          imagenPregunta = pcD2S2;
          b1x = 349; b1y = 585; b1w = 232; b1h = 48;
          b2x = 620; b2y = 585; b2w = 231; b2h = 48;
          numOpciones = 2;
          correcta = 2;
          mensaje1 = "¡Incorrecto! La advertencia puede verificarse en una fuente oficial.";
          mensaje2 = "¡Correcto! La advertencia puede verificarse en una fuente oficial.";
          break;
        case 23:
          imagenPregunta = pcD2S3;
          b1x = 349; b1y = 612; b1w = 232; b1h = 48;
          b2x = 620; b2y = 612; b2w = 231; b2h = 48;
          numOpciones = 2;
          correcta = 1;
          mensaje1 = "¡Correcto! La existencia de una resolucion cualquiera no significa que todo lo que dice la publicacion sea cierto.";
          mensaje2 = "¡Incorrecto! Utiliza un documento verdadero para respaldar una afirmacion engañosa.";
          break;
        case 31:
          imagenPregunta = pcD3S1;
          b1x = 309; b1y = 469; b1w = 588; b1h = 48;
          b2x = 309; b2y = 536; b2w = 588; b2h = 48;
          b3x = 309; b3y = 604; b3w = 588; b3h = 48;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Peligro: revelaste informacion personal a un desconocido.";
          mensaje2 = "Seguro: bloqueaste el perfil y protegiste tus datos.";
          mensaje3 = "Peligro: una foto agradable no garantiza que el perfil sea confiable.";
          break;
        case 32:
          imagenPregunta = pcD3S2;
          b1x = 309; b1y = 445; b1w = 588; b1h = 48;
          b2x = 309; b2y = 513; b2w = 588; b2h = 48;
          b3x = 309; b3y = 580; b3w = 588; b3h = 66;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Peligro: los datos personales pueden ser faciles de adivinar.";
          mensaje2 = "Peligro: si descubren una clave, podrian entrar a varias cuentas.";
          mensaje3 = "Seguro: las claves largas y unicas ayudan a reducir el riesgo.";
          break;
        case 33:
          imagenPregunta = pcD3S3;
          b1x = 309; b1y = 459; b1w = 588; b1h = 48;
          b2x = 309; b2y = 526; b2w = 588; b2h = 48;
          b3x = 309; b3y = 594; b3w = 588; b3h = 48;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Peligro: revelas donde estas en tiempo real.";
          mensaje2 = "Seguro: reduces la exposicion de tus movimientos.";
          mensaje3 = "Peligro: aunque quites la ubicacion, publicar durante el viaje revela que tu casa esta sola.";
          break;
        case 34:
          imagenPregunta = pcD3S4;
          b1x = 309; b1y = 469; b1w = 588; b1h = 48;
          b2x = 309; b2y = 536; b2w = 588; b2h = 48;
          b3x = 309; b3y = 604; b3w = 588; b3h = 48;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Peligro: podrian tomar el control de tu cuenta.";
          mensaje2 = "Peligro: nunca compartas codigos de verificacion.";
          mensaje3 = "Seguro: contactaste al servicio por un canal oficial.";
          break;
        case 35:
          imagenPregunta = pcD3S5;
          b1x = 309; b1y = 456; b1w = 588; b1h = 48;
          b2x = 309; b2y = 523; b2w = 588; b2h = 48;
          b3x = 309; b3y = 590; b3w = 588; b3h = 48;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Peligro: la aplicacion podria acceder a datos privados.";
          mensaje2 = "Seguro: denegaste permisos innecesarios y protegiste tus datos.";
          mensaje3 = "Peligro: aceptaste permisos innecesarios y expusiste tu informacion personal.";
          break;
        case 41:
          imagenPregunta = pcD4S1;
          b1x = 292; b1y = 493; b1w = 304; b1h = 69;
          b2x = 606; b2y = 493; b2w = 301; b2h = 69;
          b3x = 292; b3y = 582; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "No... Reducir todo el uso del celular no es necesariamente la solucion.";
          mensaje2 = "No... Reducir todo el uso del celular no es necesariamente la solucion.";
          mensaje3 = "¡Si! No todo el tiempo frente a una pantalla representa un riesgo.";
          break;
        case 42:
          imagenPregunta = pcD4S2;
          b1x = 292; b1y = 498; b1w = 304; b1h = 65;
          b2x = 604; b2y = 498; b2w = 304; b2h = 65;
          b3x = 292; b3y = 586; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "No... Cambiar el tipo de contenido no necesariamente soluciona el problema.";
          mensaje2 = "No... Cambiar el tipo de contenido no necesariamente soluciona el problema.";
          mensaje3 = "¡Correcto! Establecer limites y buscar otras formas de descanso ayuda a evitar que el tiempo de pantalla se extienda mas de lo planeado.";
          break;
        case 43:
          imagenPregunta = pcD4S3;
          b1x = 292; b1y = 498; b1w = 304; b1h = 74;
          b2x = 606; b2y = 498; b2w = 301; b2h = 76;
          b3x = 292; b3y = 586; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "¡Respuesta incorrecta! Revisar constantemente el dispositivo puede reforzar el habito de estar pendiente de las notificaciones.";
          mensaje2 = "¡Respuesta incorrecta! Revisar constantemente el dispositivo puede reforzar el habito de estar pendiente de las notificaciones.";
          mensaje3 = "¡Correcto! No todas las notificaciones requieren atencion inmediata.";
          break;
        case 44:
          imagenPregunta = pcD4S4;
          b1x = 292; b1y = 498; b1w = 304; b1h = 74;
          b2x = 606; b2y = 498; b2w = 301; b2h = 76;
          b3x = 292; b3y = 586; b3w = 612; b3h = 62;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "No... La multitarea digital no siempre permite trabajar mejor.";
          mensaje2 = "¡Correcto! Cambiar constantemente la atencion entre distintas tareas puede aumentar la carga mental y dificultar la concentracion.";
          mensaje3 = "No... La multitarea digital no siempre permite trabajar mejor.";
          break;
        case 45:
          imagenPregunta = pcD4S5;
          b1x = 292; b1y = 518; b1w = 302; b1h = 64;
          b2x = 606; b2y = 518; b2w = 301; b2h = 64;
          b3x = 292; b3y = 599; b3w = 612; b3h = 64;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Incorrecto... Interactuar mas con las recomendaciones puede reforzar ese patron de consumo.";
          mensaje2 = "Incorrecto... Interactuar mas con las recomendaciones puede reforzar ese patron de consumo.";
          mensaje3 = "¡Correcto! Los algoritmos personalizan el contenido segun la actividad del usuario. Reconocer este comportamiento y establecer limites ayuda a tomar decisiones conscientes sobre el tiempo de pantalla.";
          break;
        case 51:
          imagenPregunta = pcD5S1;
          b1x = 294; b1y = 532; b1w = 302; b1h = 62;
          b2x = 608; b2y = 532; b2w = 301; b2h = 62;
          b3x = 294; b3y = 613; b3w = 612; b3h = 44;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Que un mensaje contenga datos reales no garantiza su autenticidad.";
          mensaje2 = "¡Correcto! Siempre verifica las solicitudes mediante canales oficiales.";
          mensaje3 = "Incorrecto... Que un mensaje contenga datos reales no garantiza su autenticidad.";
          break;
        case 52:
          imagenPregunta = pcD5S2;
          b1x = 298; b1y = 510; b1w = 301; b1h = 62;
          b2x = 611; b2y = 510; b2w = 301; b2h = 62;
          b3x = 298; b3y = 592; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Incorrecto... Los mensajes enviados desde cuentas conocidas no siempre son seguros.";
          mensaje2 = "Incorrecto... Los mensajes enviados desde cuentas conocidas no siempre son seguros.";
          mensaje3 = "¡Correcto! Una cuenta conocida tambien puede ser utilizada por otra persona sin autorizacion.";
          break;
        case 53:
          imagenPregunta = pcD5S3;
          b1x = 298; b1y = 519; b1w = 301; b1h = 62;
          b2x = 611; b2y = 519; b2w = 301; b2h = 62;
          b3x = 298; b3y = 600; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Conocer informacion de tu cuenta o utilizar un tono profesional no demuestra que una persona pertenezca al soporte tecnico.";
          mensaje2 = "¡Correcto! Los codigos de verificacion son personales y pueden permitir el acceso a tus cuentas.";
          mensaje3 = "Incorrecto... Conocer informacion de tu cuenta o utilizar un tono profesional no demuestra que una persona pertenezca al soporte tecnico.";
          break;
        case 54:
          imagenPregunta = pcD5S4;
          b1x = 298; b1y = 519; b1w = 301; b1h = 65;
          b2x = 611; b2y = 519; b2w = 301; b2h = 64;
          b3x = 298; b3y = 600; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Incorrecto... Reconocer la forma de escribir de una persona no garantiza que sea ella quien controla la cuenta.";
          mensaje2 = "Incorrecto... Reconocer la forma de escribir de una persona no garantiza que sea ella quien controla la cuenta.";
          mensaje3 = "¡Correcto! Las cuentas pueden ser comprometidas y utilizadas para engañar a los contactos de su propietario.";
          break;
        case 55:
          imagenPregunta = pcD5S5;
          b1x = 298; b1y = 519; b1w = 284; b1h = 66;
          b2x = 604; b2y = 519; b2w = 309; b2h = 66;
          b3x = 298; b3y = 600; b3w = 612; b3h = 45;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Los comentarios y elementos visuales pueden ser falsificados.";
          mensaje2 = "¡Correcto! Las paginas fraudulentas pueden copiar logos, diseños y comentarios para aparentar legitimidad.";
          mensaje3 = "Incorrecto... Los comentarios y elementos visuales pueden ser falsificados.";
          break;
        case 61:
          imagenPregunta = pcD6S1;
          b1x = 298; b1y = 509; b1w = 301; b1h = 62;
          b2x = 611; b2y = 509; b2w = 301; b2h = 62;
          b3x = 298; b3y = 590; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Las herramientas digitales deben ayudar a organizar las actividades. Dedicar demasiado tiempo a planificar puede afectar la productividad.";
          mensaje2 = "¡Correcto! Las herramientas de productividad deben facilitar las actividades, no convertirse en una actividad que consuma el tiempo destinado a realizarlas.";
          mensaje3 = "Incorrecto... Las herramientas digitales deben ayudar a organizar las actividades. Dedicar demasiado tiempo a planificar puede afectar la productividad.";
          break;
        case 62:
          imagenPregunta = pcD6S2;
          b1x = 298; b1y = 509; b1w = 301; b1h = 62;
          b2x = 611; b2y = 509; b2w = 301; b2h = 62;
          b3x = 298; b3y = 590; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 1;
          mensaje1 = "¡Correcto! Reducir las interrupciones y establecer prioridades disminuye la carga de atencion y permite administrar mejor los recursos mentales.";
          mensaje2 = "Incorrecto... Revisar constantemente las notificaciones puede aumentar las interrupciones.";
          mensaje3 = "Incorrecto... Revisar constantemente las notificaciones puede aumentar las interrupciones.";
          break;
        case 63:
          imagenPregunta = pcD6S3;
          b1x = 298; b1y = 519; b1w = 301; b1h = 64;
          b2x = 611; b2y = 519; b2w = 301; b2h = 64;
          b3x = 298; b3y = 600; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Incorrecto... Cambiar una plataforma por otra no necesariamente modifica el tiempo total de pantalla.";
          mensaje2 = "Incorrecto... Cambiar una plataforma por otra no necesariamente modifica el tiempo total de pantalla.";
          mensaje3 = "¡Correcto! El bienestar digital no depende de abandonar una sola aplicacion, sino de evaluar los habitos tecnologicos en conjunto.";
          break;
        case 64:
          imagenPregunta = pcD6S4;
          b1x = 298; b1y = 519; b1w = 301; b1h = 64;
          b2x = 611; b2y = 519; b2w = 301; b2h = 65;
          b3x = 298; b3y = 600; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Cambiar una aplicacion por otra no soluciona necesariamente el problema.";
          mensaje2 = "¡Correcto! Crear una rutina de desconexion y reducir los estimulos digitales antes de dormir favorece los habitos de descanso.";
          mensaje3 = "Incorrecto... Cambiar una aplicacion por otra no soluciona necesariamente el problema.";
          break;
        case 65:
          imagenPregunta = pcD6S5;
          b1x = 298; b1y = 519; b1w = 301; b1h = 64;
          b2x = 611; b2y = 519; b2w = 301; b2h = 64;
          b3x = 298; b3y = 600; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "Incorrecto... Las publicaciones no representan necesariamente la realidad completa de las personas.";
          mensaje2 = "Incorrecto... Las publicaciones no representan necesariamente la realidad completa de las personas.";
          mensaje3 = "¡Correcto! Las redes sociales muestran representaciones seleccionadas de la vida de las personas. Reconocerlo ayuda a evitar comparaciones poco realistas.";
          break;
        case 66:
          imagenPregunta = pcD6S6;
          b1x = 298; b1y = 529; b1w = 301; b1h = 75;
          b2x = 611; b2y = 529; b2w = 301; b2h = 75;
          b3x = 299; b3y = 616; b3w = 612; b3h = 45;
          numOpciones = 3;
          correcta = 1;
          mensaje1 = "¡Correcto! El bienestar digital requiere integrar la tecnologia de forma equilibrada con las responsabilidades, el descanso y las relaciones personales.";
          mensaje2 = "Incorrecto... Reducir una sola actividad no garantiza recuperar el equilibrio.";
          mensaje3 = "Incorrecto... Reducir una sola actividad no garantiza recuperar el equilibrio.";
          break;
        case 67:
          imagenPregunta = pcD6S7;
          b1x = 298; b1y = 524; b1w = 301; b1h = 85;
          b2x = 611; b2y = 523; b2w = 301; b2h = 88;
          b3x = 298; b3y = 620; b3w = 612; b3h = 45;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "Incorrecto... Las aplicaciones pueden proporcionar informacion sobre los habitos digitales, pero cada persona debe analizar sus necesidades y tomar decisiones responsables.";
          mensaje2 = "¡Correcto! Las herramientas digitales pueden ayudar a identificar patrones, pero el bienestar requiere autonomia, reflexion y decisiones conscientes.";
          mensaje3 = "Incorrecto... Las aplicaciones pueden proporcionar informacion sobre los habitos digitales, pero cada persona debe analizar sus necesidades y tomar decisiones responsables.";
          break;
        case 71:
          imagenPregunta = pcD7S1;
          b1x = 299; b1y = 526; b1w = 302; b1h = 79;
          b2x = 609; b2y = 528; b2w = 301; b2h = 78;
          b3x = 298; b3y = 622; b3w = 612; b3h = 52;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje2 = "¡Correcto! ¡Impacto directo!";
          mensaje3 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          break;
        case 72:
          imagenPregunta = pcD7S2;
          b1x = 298; b1y = 524; b1w = 301; b1h = 85;
          b2x = 611; b2y = 523; b2w = 301; b2h = 88;
          b3x = 298; b3y = 620; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje2 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje3 = "¡Correcto! ¡Impacto directo!";
          break;
        case 73:
          imagenPregunta = pcD7S3;
          b1x = 298; b1y = 489; b1w = 301; b1h = 96;
          b2x = 611; b2y = 489; b2w = 301; b2h = 96;
          b3x = 296; b3y = 596; b3w = 612; b3h = 61;
          numOpciones = 3;
          correcta = 1;
          mensaje1 = "¡Correcto! ¡Impacto directo!";
          mensaje2 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje3 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          break;
        case 74:
          imagenPregunta = pcD7S4;
          b1x = 298; b1y = 503; b1w = 301; b1h = 95;
          b2x = 611; b2y = 502; b2w = 301; b2h = 96;
          b3x = 296; b3y = 610; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 2;
          mensaje1 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje2 = "¡Correcto! ¡Impacto directo!";
          mensaje3 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          break;
        case 75:
          imagenPregunta = pcD7S5;
          b1x = 298; b1y = 493; b1w = 301; b1h = 95;
          b2x = 611; b2y = 493; b2w = 301; b2h = 95;
          b3x = 296; b3y = 600; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje2 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje3 = "¡Correcto! ¡Impacto directo!";
          break;
        case 76:
          imagenPregunta = pcD7S6;
          b1x = 298; b1y = 512; b1w = 301; b1h = 82;
          b2x = 611; b2y = 512; b2w = 301; b2h = 82;
          b3x = 296; b3y = 606; b3w = 612; b3h = 60;
          numOpciones = 3;
          correcta = 3;
          mensaje1 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje2 = "¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!";
          mensaje3 = "¡Correcto! ¡Impacto directo!";
          break;
        case 77:
          imagenPregunta = pcD7S7;
          b1x = 298; b1y = 502; b1w = 301; b1h = 92;
          b2x = 611; b2y = 502; b2w = 301; b2h = 92;
          b3x = 296; b3y = 606; b3w = 612; b3h = 68;
          numOpciones = 3;
          correcta = 1;
          mensaje1 = "¡Correcto! ¡GOLPE FINAL!";
          mensaje2 = "¡Incorrecto! ¡El Dr. Datos resiste!";
          mensaje3 = "¡Incorrecto! ¡El Dr. Datos resiste!";
          break;
      }

      pushMatrix();
      resetMatrix();
      image(imagenPregunta, pcX, pcY);
      popMatrix();

      /* BATALLA FINAL, la guardiana a la izquierda con el Dr. Datos a la derecha,*/
      if (diaJuego == 7) {
        image(personaje, 25, 380, 230, 230);

        /* la barra sube o baja de a 1 punto por cuadro hasta llegar a la vida real*/
        if (vidaMostrada > vidaDrDatos) {
          vidaMostrada = vidaMostrada - 1;
        }
        if (vidaMostrada < vidaDrDatos) {
          vidaMostrada = vidaMostrada + 1;
        }

        /* durante 30 cuadros el Dr. Datos tiembla de lado a lado y se pone rojo */
        int temblor = 0;
        if (golpe > 0) {
          golpe = golpe - 1;
          if (golpe % 6 < 3) {
            temblor = 6;
          } else {
            temblor = -6;
          }
          tint(255, 120, 120);
        }
        /* si el jugador acerto, el doctor datos se enoja, si fallo (o aun no responde este sigue feliz */
        if (respondida && respuestaElegida == correcta) {
          image(drDatosEnojado, 955 + temblor, 380, 230, 230);
        } else {
          image(drDatosFeliz, 955 + temblor, 380, 230, 230);
        }
        noTint();

        /* barra de vida del doc datos encima de el */
        noStroke();
        fill(60, 30, 40);
        textSize(16);
        textAlign(CENTER, CENTER);
        text("DR. DATOS", 1070, 330);
        fill(60, 30, 40);
        rect(978, 343, 184, 26, 13);
        fill(255);
        rect(981, 346, 178, 20, 10);
        if (vidaMostrada > 0) {
          /* el color cambia segun cuanta vida le queda:*/
          if (vidaMostrada > 60) {
            fill(120, 200, 120);
          } else {
            if (vidaMostrada > 30) {
              fill(245, 190, 90);
            } else {
              fill(225, 70, 80);
            }
          }
          rect(981, 346, 178 * vidaMostrada / 100, 20, 10);
        }
        fill(60, 30, 40);
        textSize(14);
        text(vidaMostrada + "/100", 1070, 356);
      }

      /* en que boton esta el mouse */
      botonElegido = 0;
      if (mx >= b1x && mx <= b1x + b1w && my >= b1y && my <= b1y + b1h) {
        botonElegido = 1;
      }
      if (mx >= b2x && mx <= b2x + b2w && my >= b2y && my <= b2y + b2h) {
        botonElegido = 2;
      }
      if (numOpciones == 3 && mx >= b3x && mx <= b3x + b3w && my >= b3y && my <= b3y + b3h) {
        botonElegido = 3;
      }

      if (!respondida && botonElegido > 0) {
        noStroke();
        fill(0, 0, 0, 40);
        switch (botonElegido) {
          case 1:
            rect(b1x, b1y, b1w, b1h, 16);
            break;
          case 2:
            rect(b2x, b2y, b2w, b2h, 16);
            break;
          default:
            rect(b3x, b3y, b3w, b3h, 16);
        }
      }

      if (respondida) {
        noFill();
        strokeWeight(5);
        if (respuestaElegida == correcta) {
          stroke(80, 190, 120);
        } else {
          stroke(230, 80, 90);
        }
        switch (respuestaElegida) {
          case 1:
            rect(b1x, b1y, b1w, b1h, 16);
            break;
          case 2:
            rect(b2x, b2y, b2w, b2h, 16);
            break;
          case 3:
            rect(b3x, b3y, b3w, b3h, 16);
            break;
        }
        noStroke();
      }

      /* caja de dialogo abajo*/
      int dialogoY = 668;
      if (numOpciones == 3 && b3y + b3h + 6 > dialogoY) {
        dialogoY = b3y + b3h + 6;
      }
      noStroke();
      fill(245, 147, 191);
      rect(160, dialogoY, 880, 756 - dialogoY, 24);
      fill(255);
      textAlign(LEFT, CENTER);
      if (respondida) {
        textSize(17);
        text(mensajeRespuesta, 185, dialogoY + 1, 830, 734 - dialogoY);
        textSize(17);
        text("Proteccion de tu boveda: " + proteccion + "/100", 185, 742);
        textAlign(RIGHT, CENTER);
        text("click para continuar >>", 1020, 742);
      } else {
        textSize(20);
        text("Pregunta " + numPregunta + " de " + totalPreguntas + ": elige la opcion que consideres mas segura.", 185, dialogoY + 3, 830, 726 - dialogoY);
      }
      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      } else {
        if (!respondida) {
          if (botonElegido > 0) {
            mano = true;
          }
          if (clic && botonElegido > 0) {
            respondida = true;
            respuestaElegida = botonElegido;
            if (respuestaElegida == correcta) {
              /* decision segura: suma proteccion y cuenta como correcta */
              proteccion = proteccion + 10;
              decisionesCorrectas = decisionesCorrectas + 1;
              aciertosDia = aciertosDia + 1;
              if (diaJuego == 7) {
                vidaDrDatos = vidaDrDatos - 15;
                golpe = 30;
              }
            } else {
              /* decision insegura: resta la penalizacion del nivel y suma 1 punto de riesgo */
              proteccion = proteccion - penalizacionNivel;
              decisionesIncorrectas = decisionesIncorrectas + 1;
              puntuacionDia = puntuacionDia + 1;
              if (diaJuego == 7) {
                vidaDrDatos = vidaDrDatos + 5;
              }
            }
            /* limitamos proteccion y la vida del doctor datos entre 0 y 100 */
            if (proteccion > 100) {
              proteccion = 100;
            } else {
              if (proteccion < 0) {
                proteccion = 0;
              }
            }
            if (vidaDrDatos > 100) {
              vidaDrDatos = 100;
            } else {
              if (vidaDrDatos < 0) {
                vidaDrDatos = 0;
              }
            }
            switch (respuestaElegida) {
              case 1:
                mensajeRespuesta = mensaje1;
                break;
              case 2:
                mensajeRespuesta = mensaje2;
                break;
              default:
                mensajeRespuesta = mensaje3;
            }
          }
        } else {
          /* el clic pasa a la siguiente pregunta o termina el dia cuando respode*/
          if (clic) {
            respondida = false;
            numPregunta = numPregunta + 1;
            if (numPregunta > totalPreguntas) {
              numPregunta = 1;
              pantalla = 11;
            }
          }
        }
      }
      break;

    case 11:
      /*ACUMULADORES Y CONTADORES DE LA SEMANA (cierre)*/
      puntajeDigitalAcumulado = puntajeDigitalAcumulado + puntuacionDia;
      diasCompletados = diasCompletados + 1;
      horasAcumuladas = horasAcumuladas + cantidadHoras;

      if (cantidadHoras <= 3) {
        diasConUsoSaludable = diasConUsoSaludable + 1;
      }

      mensajeCierre = "¡Muy bien, " + nombre + "! Revisa el informe de tu boveda digital.";

      /* LOGRO "DETECTIVE DE FAKE NEWS": acertar las 3 noticias del dia 2 */
      if (diaJuego == 2 && aciertosDia == 3 && logroFakeNews == false) {
        logroFakeNews = true;
        logrosObtenidos = logrosObtenidos + 1;
        mensajeCierre = "¡LOGRO DESBLOQUEADO: DETECTIVE DE FAKE NEWS! Identificaste correctamente las tres noticias de hoy.";
      }
      /* LOGRO "DETECTOR DE AMENAZAS": acertar los 5 mensajes del dia 5 */
      if (diaJuego == 5 && aciertosDia == 5 && logroMensajes == false) {
        logroMensajes = true;
        logrosObtenidos = logrosObtenidos + 1;
        mensajeCierre = "¡LOGRO DESBLOQUEADO: DETECTOR DE AMENAZAS! Identificaste correctamente las cinco amenazas de hoy.";
      }
      /* LOGRO "REY DEL TIEMPO": al menos tres dias con 3 horas o menos de uso */
      if (diasConUsoSaludable >= 3 && logroReyDelTiempo == false) {
        logroReyDelTiempo = true;
        logrosObtenidos = logrosObtenidos + 1;
        mensajeCierre = "¡LOGRO DESBLOQUEADO: REY DEL TIEMPO! Registraste tres dias con 3 horas o menos de uso.";
      }
      /* resultado de la batalla del dia 7 */
      if (diaJuego == 7) {
        if (vidaDrDatos == 0) {
          mensajeCierre = "¡El Dr. Datos ha sido derrotado! La Boveda Digital esta a salvo.";
        } else {
          mensajeCierre = "El Dr. Datos logro escapar con " + vidaDrDatos + " puntos de vida...";
        }
      }

      pasoDialogo = 1;
      pantalla = 8;
      break;

    case 12:
      /* COMPUTADOR: NIVEL, BARRA DE PROGRESO Y CONTINUAR */

      /* NIVEL ALCANZADO Y BARRA DE PROGRESO */
      if (diasCompletados <= 2) {
        nivelAlcanzado = 1;
        nombreNivel = "PRINCIPIANTE DIGITAL";
        diasDentroDelNivel = diasCompletados;
        diasNecesariosNivel = 2;
      } else {
        if (diasCompletados <= 5) {
          nivelAlcanzado = 2;
          nombreNivel = "USUARIO FRECUENTE";
          diasDentroDelNivel = diasCompletados - 2;
          diasNecesariosNivel = 3;
        } else {
          nivelAlcanzado = 3;
          nombreNivel = "EXPERTO DIGITAL";
          diasDentroDelNivel = diasCompletados - 5;
          diasNecesariosNivel = 2;
        }
      }
      bloquesProgreso = (diasDentroDelNivel * 10) / diasNecesariosNivel;
      
      switch (diaJuego) {
        case 1:
          imagenProgreso = pcProgreso1;
          break;
        case 2:
          imagenProgreso = pcProgreso2;
          break;
        case 3:
          imagenProgreso = pcProgreso3;
          break;
        case 4:
          imagenProgreso = pcProgreso4;
          break;
        case 5:
          imagenProgreso = pcProgreso5;
          break;
        default:
          imagenProgreso = pcProgreso6;
      }
      pushMatrix();
      resetMatrix();
      image(imagenProgreso, pcX, pcY);
      popMatrix();

      /* aura o latido de ciculito de nivel dos anillos que salen del circulo y se van desvaneciendo*/
      noFill();
      strokeWeight(5);
      stroke(245, 147, 191, 200 - latido * 3);
      ellipse(389, 443, 178 + latido, 178 + latido);
      int latido2 = latido + 30;
      if (latido2 >= 60) {
        latido2 = latido2 - 60;
      }
      stroke(245, 147, 191, 200 - latido2 * 3);
      ellipse(389, 443, 178 + latido2, 178 + latido2);

      /* brillo del borde del circulo:*/
      int brillo = latido;
      if (latido > 30) {
        brillo = 60 - latido;
      }
      stroke(255, 255, 255, brillo * 6);
      strokeWeight(8);
      ellipse(389, 443, 170, 170);
      noStroke();

      /* datos de la partida dentro de los tres recuadros */
      fill(214, 84, 145);
      textSize(22);
      textAlign(CENTER, CENTER);
      text(proteccion + "/100", 576, 571);
      text("" + puntajeDigitalAcumulado, 716, 571);
      text(logrosObtenidos + "/3", 857, 571);

      if (diaJuego < ultimoDia) {
        fill(0, 0, 0, 45);
        if (mx >= 289 && mx <= 581 && my >= 624 && my <= 669) {
          rect(289, 624, 292, 45, 12);
        }
        if (mx >= 619 && mx <= 910 && my >= 624 && my <= 669) {
          rect(619, 624, 291, 45, 12);
        }
      } else {
        /* VER REPORTE FINAL */
        fill(255);
        rect(275, 615, 650, 62);
        fill(245, 147, 191);
        if (mx >= 450 && mx <= 750 && my >= 624 && my <= 669) {
          fill(214, 84, 145);
        }
        rect(450, 624, 300, 45, 12);
        fill(255);
        textSize(20);
        text("VER REPORTE FINAL", 600, 645);
      }

      if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
        mano = true;
        if (clic) {
          pantallaComputador = pantalla;
          pantalla = 3;
        }
      }

      if (diaJuego < ultimoDia) {
        if (mx >= 289 && mx <= 581 && my >= 624 && my <= 669) {
          mano = true;
          if (clic) {
            diaJuego = diaJuego + 1;

            /* penalizacion segun el nivel del dia*/
            if (diaJuego <= 2) {
              penalizacionNivel = 15;
            } else {
              if (diaJuego <= 5) {
                penalizacionNivel = 20;
              } else {
                penalizacionNivel = 25;
              }
            }

            /* incrementamos un dia, en caso de que si se pasa del ultimo dia del mes, pasamos al mes siguiente (y en diciembre al año siguiente); los dias del mes se recalculan en el registro */
            dia = dia + 1;
            if (dia > diasDelMes) {
              dia = 1;
              mes = mes + 1;
              if (mes > 12) {
                mes = 1;
                año = año + 1;
              }
            }
            txtDia = "" + dia;
            txtMes = "" + mes;
            txtAño = "" + año;

            /* limpiamos los datos de la jornada para escribir los del nuevo dia */
            txtHora = "";
            txtMinuto = "";
            txtFranja = "";
            txtHoras = "";
            campoActivo = 6;
            mensajeError = "";
            pantalla = 4;
          }
        }
        /* TERMINAR si el jugador se sale y mostrar lo que jugo*/
        if (mx >= 619 && mx <= 910 && my >= 624 && my <= 669) {
          mano = true;
          if (clic) {
            pantalla = 14;
          }
        }
      } else {
        if (mx >= 450 && mx <= 750 && my >= 624 && my <= 669) {
          mano = true;
          if (clic) {
            pantalla = 14;
          }
        }
      }
      break;

    case 14:
      /* CALCULOS DEL REPORTE FINAL*/

      /* dias equivalentes por año: con el promedio de horas por dia calculamos cuantos dias completos de 24 horas pasaria en redes sociales en un año (365 dias), usando div*/
      diasEquivalentesPorAño = (horasAcumuladas * 365) / (diasCompletados * 24);

      /* clasificacion segun el puntaje acumulado */
      if (puntajeDigitalAcumulado < 5) {
        clasificacionFinal = "Ciudadano Digital Ejemplar";
      } else {
        if (puntajeDigitalAcumulado <= 13) {
          clasificacionFinal = "Usuario Digital Responsable";
        } else {
          if (puntajeDigitalAcumulado <= 20) {
            clasificacionFinal = "Usuario en Riesgo";
          } else {
            clasificacionFinal = "Dependencia Digital Alta";
          }
        }
      }

      /* diagnostico final */
      if (puntajeDigitalAcumulado < 5) {
        diagnosticoFinal = "Uso saludable de redes sociales.";
      } else {
        if (puntajeDigitalAcumulado <= 13) {
          diagnosticoFinal = "Debes mejorar algunos habitos digitales.";
        } else {
          diagnosticoFinal = "Uso no saludable de redes sociales.";
        }
      }

      /* finales y la proteccion solo cambia el mensaje para explicar que paso */
      if (puntajeDigitalAcumulado < 5) {
        if (proteccion >= 60) {
          tipoFinal = "FINAL BUENO";
          finalHistoria = "Protegiste tu boveda y mantuviste a salvo tu informacion en Ciudad Digital. Tienes habitos digitales saludables. Sigue usando claves unicas, la autenticacion en dos pasos y limita los datos que publicas.";
        } else {
          tipoFinal = "FINAL BUENO";
          finalHistoria = "Tus habitos digitales son saludables, aunque algunas decisiones dejaron tu boveda menos protegida. Revisa tus permisos, usa claves unicas y piensa antes de compartir tus datos.";
        }
      } else {
        if (puntajeDigitalAcumulado <= 13) {
          if (proteccion >= 60) {
            tipoFinal = "FINAL REGULAR";
            finalHistoria = "Tomaste buenas decisiones y tu boveda esta bien protegida, pero tu puntaje digital muestra que debes mejorar algunos habitos, como tu tiempo en redes o tu horario de conexion.";
          } else {
            tipoFinal = "FINAL REGULAR";
            finalHistoria = "Detuviste parte de los ataques, pero tu boveda tiene puntos debiles y debes mejorar algunos habitos digitales. Piensa antes de compartir tus datos y organiza mejor tu tiempo en redes.";
          }
        } else {
          if (proteccion >= 60) {
            tipoFinal = "FINAL MALO";
            finalHistoria = "Tomaste buenas decisiones y tu boveda esta bien protegida, pero tu uso de redes sociales no es saludable: pasaste demasiado tiempo conectado. El exceso de pantalla tambien es un riesgo.";
          } else {
            if (proteccion >= 30) {
              tipoFinal = "FINAL MALO";
              finalHistoria = "Tu boveda quedo con puntos debiles y tu uso de redes sociales no es saludable. Reduce tus horas de conexion, revisa tu privacidad y no compartas codigos de verificacion.";
            } else {
              tipoFinal = "FINAL MALO";
              finalHistoria = "Tu boveda quedo debil y el Dr. Datos logro comprometer tu informacion. Tu uso de redes sociales no es saludable. Cambia tus claves y reduce tu tiempo de pantalla.";
            }
          }
        }
      }

      if (puntajeDigitalAcumulado > 13) {
        if (puntajeDigitalAcumulado <= 20) {
          finalHistoria = finalHistoria + " Tus habitos te estan poniendo en riesgo, pero todavia estas a tiempo de cambiarlos.";
        } else {
          finalHistoria = finalHistoria + " Tu relacion con las redes se volvio una dependencia: pide ayuda y desconectate poco a poco.";
        }
      }

      /* el resultado de la batalla con el Dr. Datos lo agregamos aparte segun su vida */
      if (diasCompletados < 7) {
        finalHistoria = finalHistoria + " No llegaste a la batalla final: el Dr. Datos sigue escondido en Ciudad Digital.";
      } else {
        if (vidaDrDatos == 0) {
          /* si lo derroto pero su puntaje digital no es bueno, le explicamos que sus habitos tambien cuentan, hscemos esa aclaracion */
          if (puntajeDigitalAcumulado < 5) {
            finalHistoria = finalHistoria + " En la batalla final derrotaste al Dr. Datos. ¡Ciudad Digital te lo agradece!";
          } else {
            finalHistoria = finalHistoria + " Derrotaste al Dr. Datos, pero el siguiente enemigo son tus propios habitos: la tecnologia tambien puede dañarte cuando la usas en exceso.";
          }
        } else {
          finalHistoria = finalHistoria + " En la batalla final el Dr. Datos escapo con " + vidaDrDatos + " puntos de vida... volvera a intentarlo.";
        }
      }

      pasoDialogo = 1;
      pantalla = 13;
      break;

    case 13:
      /* REPORTE FINAL DE LA SEMANA DIGITAL*/
      switch (pasoDialogo) {
        case 1:
          pushMatrix();
          resetMatrix();
          image(pcReporteDatos, pcX, pcY);
          popMatrix();
          break;
        case 2:
          pushMatrix();
          resetMatrix();
          image(pcReporteDesempeno, pcX, pcY);
          popMatrix();
          break;
        default:
          /* el final que salio decide la imagen */
          if (puntajeDigitalAcumulado < 5) {
            imagenFinal = pcFinalBueno;
          } else {
            if (puntajeDigitalAcumulado <= 13) {
              imagenFinal = pcFinalRegular;
            } else {
              imagenFinal = pcFinalMalo;
            }
          }
          pushMatrix();
          resetMatrix();
          image(imagenFinal, pcX, pcY);
          popMatrix();
          /* el personaje escogido va en el espacio de la izquierda */
          image(personaje, 250, 387, 252, 252);
      }

      noStroke();
      switch (pasoDialogo) {
        case 1:
          fill(214, 84, 145);
          textSize(22);
          textAlign(LEFT, CENTER);
          for (int i = 1; i <= 8; i = i + 1) {
            String datoTarjeta = "";
            switch (i) {
              case 1:
                datoTarjeta = nombre;
                break;
              case 2:
                datoTarjeta = edad + " años";
                break;
              case 3:
                datoTarjeta = horaIngresoInicial;
                break;
              case 4:
                datoTarjeta = horaSalidaFinal;
                break;
              case 5:
                datoTarjeta = diasCompletados + " de " + ultimoDia;
                break;
              case 6:
                datoTarjeta = horasAcumuladas + " horas";
                break;
              case 7:
                datoTarjeta = "" + diasConUsoSaludable;
                break;
              default:
                datoTarjeta = diasEquivalentesPorAño + " dias";
            }
            /* los impares van a la izquierda y los pares a la derecha */
            int tarjetaX = 310;
            if (i % 2 == 0) {
              tarjetaX = 629;
            }
            /* altura de cada fila de recuadros */
            int tarjetaY = 326;
            if (i == 3 || i == 4) {
              tarjetaY = 423;
            }
            if (i == 5 || i == 6) {
              tarjetaY = 520;
            }
            if (i == 7 || i == 8) {
              tarjetaY = 626;
            }
            text(datoTarjeta, tarjetaX, tarjetaY);
          }
          break;

        case 2:
          /* TU DESEMPEÑO*/
          noFill();
          strokeWeight(5);
          stroke(245, 147, 191, 200 - latido * 3);
          ellipse(390, 442, 178 + latido, 178 + latido);
          int aura2 = latido + 30;
          if (aura2 >= 60) {
            aura2 = aura2 - 60;
          }
          stroke(245, 147, 191, 200 - aura2 * 3);
          ellipse(390, 442, 178 + aura2, 178 + aura2);
          noStroke();

          /* puntaje digital dentro del circulo y la clasificacion en el cuadro de abajo */
          fill(255);
          textAlign(CENTER, CENTER);
          textSize(56);
          text("" + puntajeDigitalAcumulado, 390, 474);
          textSize(15);
          text(clasificacionFinal, 285, 561, 210, 42);

          /* proteccion */
          fill(113, 197, 241);
          textSize(16);
          textAlign(LEFT, CENTER);
          text(proteccion + "/100", 778, 348);
          if (proteccion > 0) {
            fill(245, 147, 191);
            rect(526, 371, 380 * proteccion / 100, 18, 9);
          }

          /* decisiones correctas e incorrectas */
          textAlign(CENTER, CENTER);
          textSize(30);
          fill(60, 150, 90);
          text("" + decisionesCorrectas, 616, 454);
          fill(170, 60, 70);
          text("" + decisionesIncorrectas, 817, 454);

          /* nivel alcanzado*/
          fill(255);
          textSize(20);
          textAlign(LEFT, CENTER);
          text(nivelAlcanzado + ": " + nombreNivel, 614, 506);

          /* cuantos logros*/
          fill(255);
          rect(596, 546, 56, 24);
          fill(113, 197, 241);
          textSize(16);
          textAlign(LEFT, CENTER);
          text(logrosObtenidos + "/3", 600, 557);
          textAlign(CENTER, CENTER);

          /* los logros ganados se pintan de rosado */
          textSize(11);
          if (logroFakeNews) {
            fill(245, 147, 191);
            rect(526, 575, 98, 48, 12);
            fill(255);
            text("DETECTIVE DE FAKE NEWS", 530, 577, 90, 44);
          }
          if (logroMensajes) {
            fill(245, 147, 191);
            rect(640, 575, 98, 48, 12);
            fill(255);
            text("DETECTOR DE AMENAZAS", 644, 577, 90, 44);
          }
          if (logroReyDelTiempo) {
            fill(245, 147, 191);
            rect(754, 575, 97, 48, 12);
            fill(255);
            text("REY DEL TIEMPO", 758, 577, 89, 44);
          }

          /* diagnostico*/
          fill(255);
          rect(450, 644, 330, 24);
          fill(180, 201, 225);
          rect(280, 636, 640, 28, 14);
          fill(255);
          textSize(13);
          if (diasCompletados == 7) {
            text("DIAGNOSTICO: " + diagnosticoFinal + "  |  DR. DATOS: " + vidaDrDatos + "/100", 600, 650);
          } else {
            text("DIAGNOSTICO: " + diagnosticoFinal, 600, 650);
          }
          break;

        default:
          /* TU FINAL*/
          if (puntajeDigitalAcumulado < 5) {
            fill(90, 125, 75);
          } else {
            if (puntajeDigitalAcumulado <= 13) {
              fill(215, 125, 55);
            } else {
              fill(141, 84, 84);
            }
          }
          /* por si esta muy largo*/
          if (finalHistoria.length() > 330) {
            textSize(15);
          } else {
            textSize(17);
          }
          textAlign(CENTER, CENTER);
          text(finalHistoria, 512, 398, 374, 232);
      }

      /* caja de dialogo abajo */
      noStroke();
      fill(245, 147, 191);
      rect(160, 668, 880, 88, 24);
      fill(255);
      textSize(20);
      textAlign(LEFT, CENTER);
      switch (pasoDialogo) {
        case 1:
          text("Pagina 1 de 3: asi fue tu semana digital, " + nombre + ".", 185, 671, 830, 58);
          break;
        case 2:
          text("Pagina 2 de 3: tu final se decide con tu puntaje digital, que fue de " + puntajeDigitalAcumulado + " puntos.", 185, 671, 830, 58);
          break;
        default:
          text("Pagina 3 de 3: tus decisiones digitales construyen tu futuro. ¡Gracias por jugar!", 185, 671, 830, 58);
      }
      textSize(17);
      textAlign(RIGHT, CENTER);
      if (pasoDialogo < 3) {
        text("click para continuar >>", 1020, 742);
      } else {
        text("click para volver al menu >>", 1020, 742);
      }

      /* cada clic pasa a la siguiente pagina */
      if (clic) {
        pasoDialogo = pasoDialogo + 1;
      }

      /* volvemos al menu al acabar partida */
      if (pasoDialogo > 3) {
        txtNombre = "";
        txtEdad = "";
        txtAño = "";
        txtMes = "";
        txtDia = "";
        txtHora = "";
        txtMinuto = "";
        txtFranja = "";
        txtHoras = "";
        campoActivo = 1;
        mensajeError = "";
        diaJuego = 1;
        contenido1 = 0;
        contenido2 = 0;
        decisionesCorrectas = 0;
        decisionesIncorrectas = 0;
        proteccion = 100;
        penalizacionNivel = 15;
        puntajeDigitalAcumulado = 0;
        diasCompletados = 0;
        horasAcumuladas = 0;
        diasConUsoSaludable = 0;
        logrosObtenidos = 0;
        logroFakeNews = false;
        logroMensajes = false;
        logroReyDelTiempo = false;
        vidaDrDatos = 100;
        vidaMostrada = 100;
        golpe = 0;
        minutoLibreDiaSiguiente = 0;
        finSesionAnterior = "";
        horaIngresoInicial = "";
        horaSalidaFinal = "";
        numPregunta = 1;
        respondida = false;
        pasoDialogo = 1;
        pantallaComputador = 15;
        pantalla = 0;
      }
      break;
  }

  if (pantallaDibujada >= 4 && pantallaDibujada != 11 && pantallaDibujada != 14 && pantallaDibujada != 16 && pantallaDibujada != 18) {
    noStroke();
    fill(120, 196, 229);
    rect(712, 196, 227, 32);
    fill(255);
    rect(770, 200, 159, 23, 11);
    if (diasCompletados > 0) {
      fill(246, 180, 215);
      stroke(240, 140, 185);
      strokeWeight(1);
      rect(770, 200, 159 * diasCompletados / 7, 23, 11);
      noStroke();
    }
    fill(255);
    textSize(18);
    textAlign(CENTER, CENTER);
    text(diasCompletados + "/7", 741, 211);

    /* boton de sonido */
    fill(255);
    ellipse(692, 212, 30, 30);
    if (sonidoActivo) {
      image(iconoSonido, 680, 200, 24, 24);
    } else {
      image(iconoSinSonido, 680, 200, 24, 24);
    }
    if (sobreBotonSonido) {
      fill(0, 0, 0, 40);
      ellipse(692, 212, 30, 30);
    }

    /*oscurecemos tambien el contador y el boton de sonido en los mensajes del dia*/
    if (pantallaDibujada == 6 && pasoDialogo < 4) {
      fill(0, 0, 0, 120);
      rect(712, 196, 227, 32);
      ellipse(692, 212, 30, 30);
    }

    if (mx >= 900 && mx <= 940 && my >= 148 && my <= 182) {
      fill(0, 0, 0, 40);
      rect(900, 148, 40, 34, 8);
    }
  }

  if (pantallaDibujada == 3) {
    noStroke();
    fill(255);
    ellipse(1040, 50, 44, 44);
    if (sonidoActivo) {
      image(iconoSonido, 1023, 33, 34, 34);
    } else {
      image(iconoSinSonido, 1023, 33, 34, 34);
    }
    if (sobreBotonSonido) {
      fill(0, 0, 0, 40);
      ellipse(1040, 50, 44, 44);
    }
  }


  if (mano && !manoAntes) {
    cursor(HAND);
  }
  if (!mano && manoAntes) {
    cursor(ARROW);
  }
  manoAntes = mano;

  mouseAntes = mousePressed;
  teclaAntes = keyPressed;
  ultimaTecla = key;
}
