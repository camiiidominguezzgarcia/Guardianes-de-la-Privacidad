/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_entrega.pkg2_cdg_ihm_svd_nvb;

import java.util.Scanner;

/**
 *
 * @author Camila Dominguez
 */
public class Lab_Entrega2_CDG_IHM_SVD_NVB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String opcion;

        /*  usamos un do-while porque el menu se tiene que mostrar por lo menos una vez
            y se repite hasta que el usuario escoja la opcion 3, asi cuando termina una partida
            vuelve al menu y puede jugar otra vez */
        do {
            System.out.println("LOS GUARDIANES DE LA PRIVACIDAD \n");
            System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
            System.out.println("|   MENU DE INICIO:                         |\n|   ✔1. ¡Iniciemos la mision!               |\n|   ✔2. Consultar informacion del juego     |\n|   ✔3. Salir                               |");
            System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
            System.out.println("Digite la opcion que desea realizar:");
            opcion = entrada.nextLine().trim();
            switch (opcion) {
                case "1":
                    /* imprimimos la introduccion del juego */
                    System.out.println("\nCiudad digital esta en peligro 💔");
                    System.out.println("Dr. Datos quiere robar la informacion personal de sus habitantes.");
                    System.out.println("La alcaldia te ha elegido como guardian de la privacidad.");
                    System.out.println("Protege tu boveda digital tomando decisiones responsables 👅");
                    /* le avisamos desde el inicio que el final depende del puntaje digital (tiempo en redes y decisiones) */
                    System.out.println("Ojo: tu final depende de tu puntaje digital, que sube con tu tiempo en redes sociales");
                    System.out.println("y con cada decision insegura que tomes.");
                    System.out.println("(en la opcion 2 del menu puedes ver como se calcula)\n");
                    System.out.println("REGISTRO DEL JUGADOR");

                    /* declaramos las variables */
                    String nombre;
                    int edad;
                    int año;
                    int mes;
                    String mesf;
                    int dia;
                    String diaf;
                    int hora;
                    String horaf;
                    int minuto;
                    String minutof;
                    String franjaHoraria;
                    int cantidadHoras;
                    int diasDelMes;
                    int horaMilitar;
                    int minutosEntrada;
                    int minutosSalida;
                    int diaAdicional;
                    int horaDeSalida;
                    String horaDeSalidaf;
                    int minutoDeSalida;
                    String minutoDeSalidaf;
                    int puntuacionDia;
                    int diaSalida;
                    String diaSalidaf;
                    int mesSalida;
                    String mesSalidaf;
                    int añoSalida;
                    //String añoSalidaf;
                    int segundoDelDiaSalida;
                    String segundoDelDiaSalidaf;
                    String mensajeRiesgo;
                    String mensajeRiesgo2;
                    int contenido1;
                    int contenido2;
                    int proteccion;
                    int puntuacionContenido1;
                    int puntuacionContenido2;
                    int diaJuego;
                    int puntajeDigitalAcumulado;
                    int decisionesCorrectas;
                    int decisionesIncorrectas;

                    /*  variables para cuando la sesion se pasa de la media noche
                        minutosFechaInicio son los minutos que quedan en la fecha del dia y minutosFechaSiguiente los que pasan al otro dia
                        minutoLibreDiaSiguiente nos dice desde que minuto puede empezar el dia siguiente para que no se crucen las sesiones
                     */
                    int minutosFechaInicio;
                    int minutosFechaSiguiente;
                    int minutoLibreDiaSiguiente = 0;
                    String finSesionAnterior = "";

                    /*
                     * NUEVAS VARIABLES PARA LAS ESTADISTICAS DE TODA LA PARTIDA
                     * ---------------------------------------------------------
                     * Estas variables se declaran ANTES del ciclo de los siete dias,
                     * porque deben conservar sus valores mientras el jugador avanza.
                     * Si se declararan dentro del ciclo, volverian a cero cada dia.
                     */
                    int diasCompletados = 0;
                    int horasAcumuladas = 0;
                    int diasConUsoSaludable = 0;
                    String horaIngresoInicial = "";
                    String horaSalidaFinal = "";
                    String opcionContinuar = "S";
                    int nivelAlcanzado = 0;
                    String nombreNivel = "";
                    int diasDentroDelNivel = 0;
                    int diasNecesariosNivel = 0;
                    int bloquesProgreso = 0;
                    String barraProgreso = "";
                    int diasEquivalentesPorAño = 0;
                    String clasificacionFinal = "";
                    String diagnosticoFinal = "";
                    String finalHistoria = "";
                    int vidaDrDatos = 100;

                    /*  penalizacionNivel es lo que se le resta a la proteccion por cada decision insegura
                        y depende del nivel: el nivel 1 resta 15, el nivel 2 resta 20 y el nivel 3 resta 25
                        asi entre mas alto el nivel las decisiones tienen consecuencias mas importantes
                     */
                    int penalizacionNivel = 15;

                    /*
                     * LOGROS: cada variable booleana indica si el logro ya fue
                     * desbloqueado. Se mantienen durante toda la partida.
                     * logrosObtenidos cuenta cuantos logros lleva el jugador.
                     */
                    int logrosObtenidos;
                    boolean logroFakeNews;
                    boolean logroMensajes;
                    boolean logroReyDelTiempo;
                    decisionesCorrectas = 0;
                    decisionesIncorrectas = 0;
                    puntajeDigitalAcumulado = 0;
                    logrosObtenidos = 0;
                    logroFakeNews = false;
                    logroMensajes = false;
                    logroReyDelTiempo = false;
                    año = 0;
                    mes = 0;
                    dia = 0;
                    diasDelMes = 0;
                    proteccion = 100;

                    /* leer y validar las variables */
 /* despues de cada nextInt ponemos un nextLine para limpiar el enter que queda */

 /* Registro de usuario */
                    do {
                        System.out.print("Ingresa tu nombre: ");
                        nombre = entrada.nextLine();
                        if (nombre.trim().equals("")) {
                            System.out.println("Error: Debes ingresar un nombre\n");
                        }
                    } while (nombre.trim().equals(""));

                    do {
                        System.out.print("Ingresa tu edad: ");
                        edad = entrada.nextInt();
                        entrada.nextLine();
                        if (edad < 1 || edad > 120) {
                            System.out.println("Error: La edad debe estar entre 1 y 120\n");
                        }
                    } while (edad < 1 || edad > 120);

                    /*  ciclo de los siete dias: lo cambiamos de for a while para que el jugador pueda terminar antes
                        sin usar break, el ciclo sigue mientras no se pasen los 7 dias y opcionContinuar sea "S"
                     */
                    diaJuego = 1;
                    while (diaJuego <= 7 && opcionContinuar.equals("S")) {

                        /*  si estamos en el dia 1 de necesitamos la fecha de inicio del desafio 
                            las demas fechas de la semana diferentes al 1 dia no seran preguntadas sino que se calcularan incrementando un dia por cada ciclo
                         */
                        if (diaJuego == 1) {
                            do {
                                System.out.print("Ingresa el año de inicio: ");
                                año = entrada.nextInt();
                                entrada.nextLine();
                                if (año < 1900) {
                                    System.out.println("Error: el año debe ser mayor o igual a 1900\n");
                                }
                            } while (año < 1900);

                            do {
                                System.out.print("Ingresa el numero del mes de inicio: ");
                                mes = entrada.nextInt();
                                entrada.nextLine();
                                if (mes < 1 || mes > 12) {
                                    System.out.println("Error: el mes debe estar entre 1 y 12\n");
                                }
                            } while (mes < 1 || mes > 12);

                            do {
                                System.out.print("Ingresa el dia de inicio: ");
                                dia = entrada.nextInt();
                                entrada.nextLine();
                                /* buscamos cuantos dias tiene el mes */
                                switch (mes) {
                                    case 1:
                                        diasDelMes = 31;
                                        break;
                                    case 2:
                                        /*
                                        Año bisiesto: si es divisible entre 4,
                                        excepto los divisibles entre 100,
                                        salvo que también lo sean entre 400 (2024 sí, 1900 no, 2000 sí).
                                         */
                                        if ((año % 400 == 0) || ((año % 4 == 0) && (año % 100 != 0))) {
                                            diasDelMes = 29;
                                        } else {
                                            diasDelMes = 28;
                                        }
                                        break;
                                    case 3:
                                        diasDelMes = 31;
                                        break;
                                    case 4:
                                        diasDelMes = 30;
                                        break;
                                    case 5:
                                        diasDelMes = 31;
                                        break;
                                    case 6:
                                        diasDelMes = 30;
                                        break;
                                    case 7:
                                        diasDelMes = 31;
                                        break;
                                    case 8:
                                        diasDelMes = 31;
                                        break;
                                    case 9:
                                        diasDelMes = 30;
                                        break;
                                    case 10:
                                        diasDelMes = 31;
                                        break;
                                    case 11:
                                        diasDelMes = 30;
                                        break;
                                    case 12:
                                        diasDelMes = 31;
                                        break;
                                }
                                if (dia < 1 || dia > diasDelMes) {
                                    System.out.println("Error: el dia debe estar entre 1 y " + diasDelMes + "\n");
                                }
                            } while (dia < 1 || dia > diasDelMes);
                        } else {
                            /* incrementamos un dia para los siguintes dias diferentes al primero */
                            switch (mes) {
                                case 1:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        /*
                                        Año bisiesto: si es divisible entre 4, 
                                        excepto los divisibles entre 100, 
                                        salvo que también lo sean entre 400 (2024 sí, 1900 no, 2000 sí).
                                         */
                                        if ((año % 400 == 0) || ((año % 4 == 0) && (año % 100 != 0))) {
                                            diasDelMes = 29;
                                        } else {
                                            diasDelMes = 28;
                                        }
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 2:
                                    if (dia == diasDelMes) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 3:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 30;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 4:
                                    if (dia == 30) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 5:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 30;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 6:
                                    if (dia == 30) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 7:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 8:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 30;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 9:
                                    if (dia == 30) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 10:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 30;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 11:
                                    if (dia == 30) {
                                        dia = 1;
                                        mes = mes + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                                case 12:
                                    if (dia == 31) {
                                        dia = 1;
                                        mes = 1;
                                        año = año + 1;
                                        diasDelMes = 31;
                                    } else {
                                        dia = dia + 1;
                                    }
                                    break;
                            }
                        }

                        /* formateamos el dia y el mes para que queden de 2 digitos */
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

                        System.out.println("\nDIA: " + diaJuego);

                        /*  dependiendo del dia sacamos la penalizacion del nivel
                            en los dias 1, 3 y 6 empieza un nivel nuevo y por eso ahi el guia le avisa al jugador
                         */
                        if (diaJuego <= 2) {
                            penalizacionNivel = 15;
                        } else {
                            if (diaJuego <= 5) {
                                penalizacionNivel = 20;
                            } else {
                                penalizacionNivel = 25;
                            }
                        }

                        if (diaJuego == 1) {
                            System.out.println("\nGUIA: Bienvenido al NIVEL 1: PRINCIPIANTE DIGITAL.");
                            System.out.println("Aqui aprenderas las reglas basicas de la boveda:");
                            System.out.println("cada decision segura suma 10 de proteccion y cada decision");
                            System.out.println("insegura resta " + penalizacionNivel + " de proteccion y suma 1 punto de riesgo.");
                            System.out.println("¡Mucha suerte, guardian!");
                        } else {
                            if (diaJuego == 3) {
                                System.out.println("\nGUIA: ¡Subiste al NIVEL 2: USUARIO FRECUENTE!");
                                System.out.println("Ahora tus decisiones tienen consecuencias mas importantes.");
                                System.out.println("¡Atencion! Desde hoy cada decision insegura te restara");
                                System.out.println(penalizacionNivel + " puntos de proteccion (antes eran 15).");
                            } else {
                                if (diaJuego == 6) {
                                    System.out.println("\nGUIA: ¡Llegaste al NIVEL 3: EXPERTO DIGITAL!");
                                    System.out.println("Las situaciones seran mas complejas y exigentes.");
                                    System.out.println("¡Cuidado! Desde hoy cada decision insegura te restara");
                                    System.out.println(penalizacionNivel + " puntos de proteccion (antes eran 20).");
                                }
                            }
                        }
                        System.out.println("Penalizacion por decision insegura en este dia: -" + penalizacionNivel + "\n");

                        /* si la sesion de ayer se paso de la media noche le avisamos al jugador desde que hora puede empezar hoy */
                        if (minutoLibreDiaSiguiente > 0) {
                            System.out.println("Recuerda: tu sesion anterior termino hoy a las " + finSesionAnterior + " (formato militar).");
                            System.out.println("La sesion de hoy debe comenzar despues de esa hora.\n");
                        }

                        /*  pedimos la hora de inicio del dia, el do-while de afuera se repite si la hora
                            se cruza con la sesion del dia anterior
                         */
                        do {
                            do {
                                System.out.print("Ingresa la hora de inicio del dia " + diaJuego + ": ");
                                hora = entrada.nextInt();
                                entrada.nextLine();
                                if (hora < 1 || hora > 12) {
                                    System.out.println("Error: la hora debe estar entre 1 y 12\n");
                                }
                            } while (hora < 1 || hora > 12);

                            do {
                                System.out.print("Ingresa el minuto de inicio del dia " + diaJuego + ": ");
                                minuto = entrada.nextInt();
                                entrada.nextLine();
                                if (minuto < 0 || minuto > 59) {
                                    System.out.println("Error: los minutos deben estar entre 0 y 59\n");
                                }
                            } while (minuto < 0 || minuto > 59);

                            do {
                                System.out.print("Ingresa la franja horaria de inicio del dia " + diaJuego + " AM o PM: ");
                                franjaHoraria = entrada.nextLine().trim().toUpperCase();
                                if (!franjaHoraria.equals("AM") && !franjaHoraria.equals("PM")) {
                                    System.out.println("Error: la franja horaria debe ser AM o PM\n");
                                }
                            } while (!franjaHoraria.equals("AM") && !franjaHoraria.equals("PM"));

                            /*  Se inicia los calculos para presentarle al jugador su puntuación inicial de riesgo
                                antes de empezar los niveles
                             */
 /* calculamos la hora en formato militar 0 - 23 suponiendo inicialmente que nuestra hora es igual a la hora militar*/
                            horaMilitar = hora;
                            /* recalculamos la hora militar si se nos cumplean condiciones especiales propios de la hora militar */
                            if (franjaHoraria.equals("PM") && hora != 12) {
                                horaMilitar = hora + 12;
                            } else {
                                if (franjaHoraria.equals("AM") && hora == 12) {
                                    horaMilitar = 0;
                                }
                            }

                            /*  Calculamos los minutos de entrada desde la media noche y asi todo queda en minutos 
                                una hora tiene 60 minutos por lo tanto la hora militar * 60 nos convertiria esta en minutos y se
                                la sumamos a los minutos que ya tenemos como entrada inicial
                             */
                            minutosEntrada = horaMilitar * 60 + minuto;

                            if (minutosEntrada < minutoLibreDiaSiguiente) {
                                System.out.println("Error: esa hora se cruza con tu sesion anterior, que termino a las " + finSesionAnterior + ".\n");
                            }
                        } while (minutosEntrada < minutoLibreDiaSiguiente);

                        /*  pedimos las horas de redes sociales del dia, se aceptan de 1 a 23 horas
                            porque cada dia tiene una sola sesion y no puede durar un dia completo o mas
                         */
                        do {
                            System.out.print("Ingresa cuantas horas utilizara las redes sociales para el dia " + diaJuego + ": ");
                            cantidadHoras = entrada.nextInt();
                            entrada.nextLine();
                            if (cantidadHoras < 1 || cantidadHoras > 23) {
                                System.out.println("Error: la cantidad de horas en redes sociales debe estar entre 1 y 23\n");
                            }
                        } while (cantidadHoras < 1 || cantidadHoras > 23);

                        /*  Calculamos lo minutos de salida adicionando las horas de redes sociales convertidas a minutos
                            1 hora tiene 60 minuto por lo tanto la cantidad de horas multiplicadas por 60 nos convierte esta en minutos
                         */
                        minutosSalida = minutosEntrada + cantidadHoras * 60;
                        /*  Un dia tiene 1440 minutos si los minutos de salidas son mayores o iguales a 1440 entonces
    la operación me va arrojar 1 en caso de que los minutos empleados sean menores 1440 la operacion
    me arrojaria cero indicando que la salida no seria al dia siguiente
                         */
                        diaAdicional = minutosSalida / 1440;

                        /* Los minutos de salida se transforman en horas y minutos */
 /* calculamos la hora de salida conociendo que un dia tiene 1440 minutos y 1 hora tiene 60 minutos */
                        horaDeSalida = (minutosSalida % 1440) / 60;
                        /* calculamos los minutos sobrantes para obtener los minutos de salida */
                        minutoDeSalida = minutosSalida % 60;

                        /*  nos pinden adicionar un segundo a la hora a la fecha de salida, como esta tabajando hasta el orden de minuto 
                            suponemos que el segund de entrada fue 0 ya no se pide ese dato como entrada
                         */
                        segundoDelDiaSalida = 1;

                        /*  si la sesion se paso de la media noche miramos cuantos minutos quedaron en la fecha del dia
                            y cuantos pasaron a la fecha siguiente, esto es solo para mostrarlo porque las horas
                            se suman una sola vez al acumulador y asi no se cuentan dos veces
                         */
                        if (diaAdicional == 1) {
                            minutosFechaInicio = 1440 - minutosEntrada;
                            minutosFechaSiguiente = minutosSalida - 1440;
                        } else {
                            minutosFechaInicio = minutosSalida - minutosEntrada;
                            minutosFechaSiguiente = 0;
                        }

                        /*  Calculamos la fecha de salida basado en que hay que incrementar un dia si la variable diaAdicional resultó en
                            en uno debido a que la cantidad de horas de uso de redes sociales involucró un nuevo dia
                            inicialmente fecha de salida es la misma fecha de entrada a menos que se cumpla la condición anterior
                         */
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

                        /* hacermos los calculos que nos ha pendido, la puntuacion inicial del dia es 0 */
 /* Analisis de tiempo de uso para el dia */
 /* Si el tiempo de uso es mayor a 3 horas y menor a 8 horas, se sumarán 4 puntos. */
 /* Si ninguna de las condiciones anteriores se cumplo la puntuacion queda intacta */
                        mensajeRiesgo = "Tu tiempo de conexion no ha generado puntos de riesgo por duracion en esta evaluacion para el dia " + diaJuego + ".";
                        puntuacionDia = 0;
                        if (cantidadHoras > 3 && cantidadHoras < 8) {
                            puntuacionDia = puntuacionDia + 4;
                            mensajeRiesgo = "Tu tiempo de conexion para el dia " + diaJuego + " ha generado " + puntuacionDia + " puntos de riesgo digital.\nPasar varias horas conectado puede afectar tu descanso, tu rendimiento academico\ny tus relaciones personales.";
                        } else {
                            if (cantidadHoras >= 8) {
                                /* Si el tiempo de uso es igual o superior a 8 horas, se sumarán 7 puntos. */
                                puntuacionDia = puntuacionDia + 7;
                                mensajeRiesgo = "Tu tiempo de conexion para el dia " + diaJuego + " ha generado " + puntuacionDia + " puntos de riesgo digital.\nEsta cantidad de tiempo puede desplazar actividades\nimportantes como dormir lo suficiente, estudiar,\nhacer ejercicios o compartir con tus seres queridos.";
                            }
                        }

                        /* Analisis del horario del dia */
 /* revisamos si horario de uso esta en un rango saludable */
 /* el horario saludable es de 8 am a 8 pm en el dia */
 /* se creo la variable mensajeRiesgo2 para personalizar la salida de la puntuacion de riesgo y dar explicacion de acuerdo a la franja horaria */
 /*  en minutos el horario saludable va de 480 a 1200, aqui usamos minutosSalida sin quitarle el dia
                            para que si la sesion se pasa de la noche tambien cuente como fuera del horario
                         */
                        mensajeRiesgo2 = "Tu jornada para el dia " + diaJuego + " comienza y termina\ndentro del horario saludable.\nNo se han sumado puntos de riesgo adicionales por horario.";
                        if (minutosEntrada < 480 || minutosSalida > 1200) {
                            puntuacionDia = puntuacionDia + 4;
                            mensajeRiesgo2 = "Tu jornada para el dia " + diaJuego + " comienza o termina fuera del \nhorario saludable establecido para la mision, por esta razon se han sumado 4 puntos de riesgo.";
                        }

                        /*  la siguientes instrucciones se usaron para formatear el dia, el mes, la hora y los minutos para tener en cuenta que sean de 2 digitos y
                            para facilitar asi su impresion, para su uso se le dio el mismo nombre de la variable que contiene el valor respectivo una f al final que significa
                            que contiene el valor ya formateado en String
                         */
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

                        /* guardamos la hora de ingreso del primer dia y la hora de salida del ultimo dia para el reporte final */
                        if (diaJuego == 1) {
                            horaIngresoInicial = diaf + "/" + mesf + "/" + año + " " + horaf + ":" + minutof + " " + franjaHoraria;
                        }
                        horaSalidaFinal = diaSalidaf + "/" + mesSalidaf + "/" + añoSalida + " " + horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf;

                        /*  si la sesion se paso de la media noche guardamos desde que minuto puede empezar la sesion de mañana
                            le sumamos 1 por el segundo que se le adiciona a la salida
                         */
                        if (diaAdicional == 1) {
                            minutoLibreDiaSiguiente = (minutosSalida - 1440) + 1;
                            finSesionAnterior = horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf;
                        } else {
                            minutoLibreDiaSiguiente = 0;
                            finSesionAnterior = "";
                        }

                        System.out.println("\n_________________");
                        System.out.println("\n" + nombre + " tu jornada ha sido registrada exitosamente en la boveda digital\n");

                        /* MISIONES */
 /* en los dias 2 al 7 cada decision insegura tambien suma 1 punto de riesgo al puntaje del dia
                           (en el dia 1 el riesgo lo suma el contenido que se escoge) */
 /* cada decision segura suma 10 a la proteccion y cada decision insegura le resta penalizacionNivel */
                        switch (diaJuego) {
                            case 1:
                                /* MISION DEL DIA 1 */
                                System.out.println("MISION: REDES SOCIALES.");
                                /* Ahora pasamos a la primera misión del jugador donde tiene que escoger 2 tipos contenido que haya consumido durante
                                su jornada y añadiremos los puntos según el contenido que escoja*/

                                System.out.println("\nTu primera mision comienza ahora.");
                                System.out.println("En ciudad digital cada publicacion, noticia o videos puede influir en tus decisiones.");
                                System.out.println("Dr. Datos aprovecha la informacion engañosa y los descuidos de privacidad para debilitar");
                                System.out.println("las bovedas de los ciudadanos.");
                                System.out.println("¡Ayudanos a descubrir que tipo de contenido has consumido!");
                                System.out.println("\n. _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                                System.out.println("|   Selecciona 2 tipos de contenido que hayas consumido en tu jornada      |");
                                System.out.println("|   ✔1.  Contenido educativo.                                              |\n|   ✔2.  Noticias verificadas.                                             |\n|   ✔3.  Contenido cultural.                                               |\n|   ✔4.  Entretenimiento.                                                  |\n|   ✔5.  Noticias falsas.                                                  |\n|   ✔6.  Contenido violento.                                               |\n|   ✔7.  Informacion engañosa                                              |");
                                System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                                do {
                                    System.out.print("Selecciona el primer tipo de contenido: ");
                                    contenido1 = entrada.nextInt();
                                    entrada.nextLine();
                                    if (contenido1 < 1 || contenido1 > 7) {
                                        System.out.println("Error: debes elegir una opcion entre 1 y 7\n");
                                    }
                                } while (contenido1 < 1 || contenido1 > 7);
                                /* se asignan las puntuaciones de cada contenido para la primera eleccion */
 /* se deben asignar respuestas correctas e incorrectas desde ahora para poder acumularlas y decirle al usuario cuantas tuvo de cada una al final*/
                                switch (contenido1) {
                                    case 1:
                                        puntuacionContenido1 = -2;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 2:
                                        puntuacionContenido1 = -2;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 3:
                                        puntuacionContenido1 = -1;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 4:
                                        puntuacionContenido1 = 0;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 5:
                                        puntuacionContenido1 = 3;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    case 6:
                                        puntuacionContenido1 = 4;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    case 7:
                                        puntuacionContenido1 = 3;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    default:
                                        puntuacionContenido1 = 0;
                                }
                                /* validamos que el segundo contenido no sea igual al primero */
                                do {
                                    System.out.print("Selecciona el segundo tipo de contenido: ");
                                    contenido2 = entrada.nextInt();
                                    entrada.nextLine();
                                    if (contenido2 < 1 || contenido2 > 7) {
                                        System.out.println("Error: debes elegir una opcion entre 1 y 7\n");
                                    } else {
                                        if (contenido1 == contenido2) {
                                            System.out.println("Error: debes elegir una opcion distinta al primer contenido\n");
                                        }
                                    }
                                } while ((contenido2 < 1 || contenido2 > 7) || (contenido1 == contenido2));
                                /* se asignan las puntuaciones de cada contenido para la segunda eleccion */
                                switch (contenido2) {
                                    case 1:
                                        puntuacionContenido2 = -2;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 2:
                                        puntuacionContenido2 = -2;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 3:
                                        puntuacionContenido2 = -1;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 4:
                                        puntuacionContenido2 = 0;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        break;
                                    case 5:
                                        puntuacionContenido2 = 3;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    case 6:
                                        puntuacionContenido2 = 4;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    case 7:
                                        puntuacionContenido2 = 3;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        break;
                                    default:
                                        puntuacionContenido2 = 0;

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

                                /* ahora hacemos un analisis al jugador para evauluar su nuevo puntaje */
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: REDES SOCIALES");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("Hemos estudiado el contenido de tu jornada y\nactualizado el nivel riesgo de tu boveda digital.\n");
                                System.out.println("Recuerda que no se trata de juzgar tus gustos\nsino de reconocer como nuestras actividades digitales\npueden influir en nuestra seguridad.\n");
                                System.out.println("A continuacion encontraras los resultados\nde tu analisis y el puntaje acumulado hasta\neste momento de la mision:\n");
                                System.out.println("Primera eleccion: " + contenido1);
                                System.out.println("Puntuacion de riesgo: " + puntuacionContenido1);
                                System.out.println("Segunda eleccion: " + contenido2);
                                System.out.println("Puntuacion de riesgo: " + puntuacionContenido2);
                                // System.out.println("Tu puntaje de riesgo digital es: " + puntuacionDia + "\n");
                                System.out.println("Gracias por completar el analisis " + nombre + ", cada decision cuenta para proteger tu boveda digital.\n");
                                break;
                            case 2:
                                /* MISION DEL DIA 2 */
                                int respuestaNoticiaF;
                                int aciertosDia2;
                                aciertosDia2 = 0;
                                System.out.println("MISION: NOTICIAS FALSAS.");
                                System.out.println("\n¡Dr. Datos ha llenado Ciudad Digital de noticias falsas!");
                                System.out.println("Ayudanos a investigar tres publicaciones y decidir si son confiables. ");

                                /* PRIMERA PRUEBA */
                                System.out.println("\nPRUEBA 1: Una noticia sobre tecnologia.");
                                System.out.println("\nUna pagina de noticias publica que varias instituciones educativas estan \nincorporando herramientas de inteligencia artificial en sus clases. \nEl articulo menciona dos universidades que ya han anunciado proyectos de este tipo y \nenlaza sus comunicados oficiales. Sin embargo, el titular afirma que «todas las \nuniversidades del pais reemplazaran a sus profesores por inteligencia artificial el proximo año».");
                                System.out.println("✔1. Fake News");
                                System.out.println("✔2. Real News");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaNoticiaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaNoticiaF < 1 || respuestaNoticiaF > 2) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaNoticiaF < 1 || respuestaNoticiaF > 2);
                                switch (respuestaNoticiaF) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia2 = aciertosDia2 + 1;
                                        System.out.println("¡Correcto! El hecho inicial tiene respaldo, pero el \ntitular exagera y distorsiona la informacion");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("¡Incorrecto! El hecho inicial si tiene respaldo, pero el \ntitular exagera y distorsiona la informacion");
                                        break;
                                }
                                /* Limitamos la proteccion mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");

                                /* SEGUNDA PRUEBA */
                                System.out.println("\nPRUEBA 2: Una alerta en redes sociales.");
                                System.out.println("\nUna cuenta de noticias publica que se detectaron intentos de robo \nde cuentas de WhatsApp mediante codigos de verificacion. La publicacion explica como \nfunciona esta modalidad y recomienda no compartir codigos personales. La misma advertencia \naparece en el centro de ayuda oficial de WhatsApp, aunque la publicacion no incluye \nun enlace directo a esa fuente.");
                                System.out.println("✔1. Fake News");
                                System.out.println("✔2. Real News");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaNoticiaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaNoticiaF < 1 || respuestaNoticiaF > 2) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaNoticiaF < 1 || respuestaNoticiaF > 2);

                                switch (respuestaNoticiaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("¡Incorrecto! La advertencia puede verificarse en una fuente oficial.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia2 = aciertosDia2 + 1;
                                        System.out.println("¡Correcto! La advertencia puede verificarse en una fuente oficial.");
                                        break;
                                }

                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");

                                /* TERCERA PRUEBA */
                                System.out.println("\nPRUEBA 3: El supuesto cambio en las becas universitarias.");
                                System.out.println("\nUna publicacion compartida en varios grupos estudiantiles afirma que \nel Gobierno anuncio un nuevo requisito para acceder a las becas universitarias: todos los estudiantes \ndeberan realizar un tramite antes de finalizar el mes o perderan automaticamente el beneficio. La \npublicacion incluye una imagen con el logo de una entidad gubernamental y menciona una resolucion \nreciente. Sin embargo, al consultar la pagina oficial de la entidad, se encuentra \nla resolucion mencionada, pero esta habla de modificaciones en el proceso de inscripcion y \nno establece la perdida automatica de las becas.");
                                System.out.println("✔1. Fake News");
                                System.out.println("✔2. Real News");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaNoticiaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaNoticiaF < 1 || respuestaNoticiaF > 2) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaNoticiaF < 1 || respuestaNoticiaF > 2);
                                switch (respuestaNoticiaF) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia2 = aciertosDia2 + 1;
                                        System.out.println("¡Correcto! La existencia de una resolucion cualquiera no significa que \ntodo lo que dice la publicacion sea cierto.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("¡Incorrecto! Utiliza un documento verdadero para respaldar una afirmacion engañosa.");
                                        break;
                                }
                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");

                                /* si acerto las 3 noticias se desbloquea el logro, solo si no lo tenia antes */
                                if (aciertosDia2 == 3 && logroFakeNews == false) {
                                    logroFakeNews = true;
                                    logrosObtenidos = logrosObtenidos + 1;
                                    System.out.println("\n¡LOGRO DESBLOQUEADO!");
                                    System.out.println("DETECTIVE DE FAKE NEWS");
                                    System.out.println("¡Has identificado correctamente las tres \namenazas digitales de hoy!");
                                }
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: NOTICIAS FALSAS");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");
                                break;
                            case 3:
                                /* MISIONES DEL DIA 3 */
                                System.out.println("MISION: PRIVACIDAD. ");
                                int respuestaMision;
                                System.out.println("\nCOMIENZAN LOS DESAFIOS DE PRIVACIDAD");
                                System.out.println("La proteccion inicial de tu boveda es: " + proteccion + "/100");

                                /* Mision 1: solicitud de amistad */
                                System.out.println("\nMISION 1: EL CURIOSO ANONIMO 👅");
                                System.out.println("Un desconocido te envia una solicitud y pregunta en que colegio estudias... ¿Que vas a hacer?");
                                System.out.println("✔1.  Aceptarlo y decirle donde estudias.");
                                System.out.println("✔2.  Rechazar la solicitud y bloquear el perfil.");
                                System.out.println("✔3.  Aceptarlo porque tiene una foto agradable.");

                                do {
                                    System.out.println("Elige una opcion: ");
                                    respuestaMision = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaMision < 1 || respuestaMision > 3) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaMision < 1 || respuestaMision > 3);
                                switch (respuestaMision) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: revelaste informacion personal a un desconocido 💔");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("Seguro: bloqueaste el perfil y protegiste tus datos 😍");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: una foto agradable no garantiza que el perfil sea confiable 💔");
                                        break;
                                }
                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mision 2: contrasena segura */
                                System.out.println("\nMISION 2: LA SENORA CONTRASENA DEBIL 👅");
                                System.out.println("Debes elegir una contrasena para proteger tu cuenta.");
                                System.out.println("✔1. Tu fecha de nacimiento.");
                                System.out.println("✔2. La misma clave para todas tus cuentas.");
                                System.out.println("✔3. Una clave larga, incluyendo un numero y diferente para cada cuenta.");

                                do {
                                    System.out.print("Elige una opcion: ");
                                    respuestaMision = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaMision < 1 || respuestaMision > 3) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaMision < 1 || respuestaMision > 3);
                                switch (respuestaMision) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: los datos personales pueden ser faciles de adivinar 💔");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: si descubren una clave, podrian entrar a varias cuentas 💔");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("Seguro: las claves largas y unicas ayudan a reducir el riesgo 😍");
                                        break;
                                }

                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");

                                /* Mision 3: fotografia con ubicacion */
                                System.out.println("\nMISION 3: EL CAZADOR DE UBICACIONES 👅");
                                System.out.println("Quieres publicar una foto durante tus vacaciones.");
                                System.out.println("✔1.  Publicarla con ubicacion en tiempo real.");
                                System.out.println("✔2.  Desactivar la ubicacion y publicarla cuando regreses.");
                                System.out.println("✔3.  Desactivar la ubicacion y publicarla");

                                do {
                                    System.out.print("Elige una opcion: ");
                                    respuestaMision = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaMision < 1 || respuestaMision > 3) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaMision < 1 || respuestaMision > 3);
                                switch (respuestaMision) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: revelas donde estas en tiempo real 💔");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("Seguro: reduces la exposicion de tus movimientos 😍");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: aunque quites la ubicacion, publicar durante el viaje revela que tu casa esta sola 💔");
                                        break;
                                }
                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mision 4: falso soporte tecnico */
                                System.out.println("\nMISION 4: EL FALSO SOPORTE TECNICO 👅");
                                System.out.println("Un desconocido que dice ser tecnico pide tu contrasena y codigo de verificacion para ayudarte.");
                                System.out.println("✔1.  Enviar ambos datos.");
                                System.out.println("✔2.  Enviar solamente el codigo.");
                                System.out.println("✔3.  No compartirlos y contactar al servicio oficial.");

                                do {
                                    System.out.print("Elige una opcion: ");
                                    respuestaMision = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaMision < 1 || respuestaMision > 3) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaMision < 1 || respuestaMision > 3);
                                switch (respuestaMision) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: podrian tomar el control de tu cuenta 💔");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: nunca compartas codigos de verificacion 💔");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("Seguro: contactaste al servicio por un canal oficial 😍");
                                        break;
                                }
                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mision 5: permisos de aplicaciones */
                                System.out.println("\nMISION 5: EL VENDEDOR DE PERMISOS 👅");
                                System.out.println("Un juego pide acceso a tus contactos, camara, ubicacion y microfono sin motivo.");
                                System.out.println("✔1.  Conceder todos los permisos.");
                                System.out.println("✔2.  Denegar los permisos.");
                                System.out.println("✔3.  Aceptar el acceso a la camara y ubicacion.");

                                do {
                                    System.out.print("Elige una opcion: ");
                                    respuestaMision = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaMision < 1 || respuestaMision > 3) {
                                        System.out.println("Error: Opcion invalida\n");
                                    }
                                } while (respuestaMision < 1 || respuestaMision > 3);
                                switch (respuestaMision) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: la aplicacion podria acceder a datos privados 💔");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("Seguro: denegaste permisos innecesarios y protegiste tus datos 😍");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Peligro: aceptaste permisos innecesarios y expusiste tu informacion personal 💔");
                                        break;
                                }
                                /* Limitamos el riesgo para mantenerlo entre 0 y 100. */
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");

                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: PRIVACIDAD");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");
                                break;
                            case 4:
                                /* MISIONES DEL DIA 4 */
                                int respuestaTiempoP;
                                System.out.println("MISION: TIEMPO DE PANTALLA.");
                                System.out.println("\nAnaliza los habitos de uso del celular y aprende a \nidentificar cuando el tiempo frente a las pantallas esta \nafectando sus actividades diarias.");
                                System.out.println("Ayudanos a identificar las opciones correctas en estas cinco situaciones.");
                                /* Prueba 1 */
                                System.out.println("\nPRUEBA 1: Productividad engañosa.");
                                System.out.println("\nUn estudiante pasa seis horas al dia frente al celular. Dos horas las dedica \na actividades academicas, pero las otras cuatro se distribuyen entre redes sociales y videos. \nAunque cumple con sus tareas, suele interrumpir sus sesiones de estudio para revisar \nnotificaciones.");
                                System.out.println("¿Que estrategia seria mas efectiva?");
                                System.out.println("✔1. Reducir todo el uso del celular al minimo, incluyendo \nlas actividades academicas.");
                                System.out.println("✔2. Establecer limites para el entretenimiento y organizar \nperiodos de concentracion sin notificaciones.");
                                System.out.println("✔3. Sustituir las redes sociales por videojuegos para \ndiversificar el entretenimiento.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaTiempoP = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaTiempoP < 1 || respuestaTiempoP > 3) {
                                        System.out.println("Error: opcion invalida.\n");
                                    }
                                } while (respuestaTiempoP < 1 || respuestaTiempoP > 3);
                                switch (respuestaTiempoP) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... Reducir todo el uso del celular no es necesariamente la solucion.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Si! No todo el tiempo frente a una pantalla representa un riesgo.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... Reducir todo el uso del celular no es necesariamente la solucion.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Prueba 2 */
                                System.out.println("\n¡Continuemos!");
                                System.out.println("\nPRUEBA 2: El descanso interminable.");
                                System.out.println("Una estudiante utiliza videos cortos para descansar despues \nde estudiar. Aunque planea dedicarles quince minutos, termina pasando \nmas de una hora viendo contenido y aplazando otras actividades.");
                                System.out.println("¿Que medida ayudaria a corregir este habito?");
                                System.out.println("✔1. Utilizar unicamente aplicaciones que recomienden \ncontenido educativo.");
                                System.out.println("✔2. Mantener el uso libre, pero intentar compensarlo \nestudiando mas tarde.");
                                System.out.println("✔3. Configurar limites de uso y establecer descansos \nque no dependan de una pantalla.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaTiempoP = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaTiempoP < 1 || respuestaTiempoP > 3) {
                                        System.out.println("Error: opcion invalida.\n");
                                    }
                                } while (respuestaTiempoP < 1 || respuestaTiempoP > 3);
                                switch (respuestaTiempoP) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... Cambiar el tipo de contenido no necesariamente soluciona el problema.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... Cambiar el tipo de contenido no necesariamente soluciona el problema.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Establecer limites y buscar otras formas \nde descanso ayuda a evitar que el tiempo de pantalla se extienda mas de \nlo planeado.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Prueba 3 */
                                System.out.println("\nPRUEBA 3: La conexion constante.");
                                System.out.println("\nDurante una reunion familiar, un estudiante revisa repetidamente \nsus notificaciones, aunque no espera ningun mensaje importante. Cuando \nintenta dejar el telefono, siente que podria perderse alguna novedad.");
                                System.out.println("¿Que decision favoreceria un uso mas equilibrado?");
                                System.out.println("✔1. Desactivar las notificaciones no esenciales y establecer momentos \nespecificos para consultar el dispositivo.");
                                System.out.println("✔2. Revisar el telefono cada pocos minutos para evitar acumular \nnotificaciones.");
                                System.out.println("✔3. Dejar de utilizar cualquier dispositivo electronico durante \ntoda la semana.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaTiempoP = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaTiempoP < 1 || respuestaTiempoP > 3) {
                                        System.out.println("Error: opcion invalida.\n");
                                    }
                                } while (respuestaTiempoP < 1 || respuestaTiempoP > 3);
                                switch (respuestaTiempoP) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! No todas las notificaciones requieren atencion inmediata.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("¡Respuesta incorrecta! Revisar constantemente el dispositivo puede \nreforzar el habito de estar pendiente de las notificaciones.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("¡Respuesta incorrecta! Revisar constantemente el dispositivo puede \nreforzar el habito de estar pendiente de las notificaciones.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Prueba 4 */
                                System.out.println("\nPRUEBA 4: La multitarea digital.");
                                System.out.println("\nUn estudiante realiza un trabajo mientras mantiene abiertas varias \nredes sociales y responde mensajes. Considera que puede hacer ambas cosas \nal mismo tiempo, pero tarda mas de lo habitual y comete errores \nque normalmente no tendria.");
                                System.out.println("¿Que explicacion describe mejor lo que esta sucediendo?");
                                System.out.println("✔1. Utilizar varias aplicaciones simultaneamente siempre mejora la \nproductividad.");
                                System.out.println("✔2. Cambiar constantemente de actividad puede afectar la concentracion \ny aumentar los errores.");
                                System.out.println("✔3. El problema se debe exclusivamente a la cantidad de horas que lleva \nutilizando el celular.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaTiempoP = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaTiempoP < 1 || respuestaTiempoP > 3) {
                                        System.out.println("Error: opcion invalida.\n");
                                    }
                                } while (respuestaTiempoP < 1 || respuestaTiempoP > 3);
                                switch (respuestaTiempoP) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... La multitarea digital no siempre permite trabajar mejor.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Cambiar constantemente la atencion entre distintas tareas \npuede aumentar la carga mental y dificultar la concentracion.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("No... La multitarea digital no siempre permite trabajar mejor.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Prueba 5 */
                                System.out.println("\nPRUEBA 5: El algoritmo y tus habitos.");
                                System.out.println("\nUna persona comienza a recibir recomendaciones de videos sobre un tema \nque consulta frecuentemente. Aunque inicialmente dedica poco tiempo a la \naplicacion, las recomendaciones se vuelven cada vez mas personalizadas y \ntermina permaneciendo conectado mucho mas de lo planeado.");
                                System.out.println("¿Que accion permitiria recuperar el control sobre su consumo digital?");
                                System.out.println("✔1. Interactuar con mas publicaciones para que el algoritmo conozca \nmejor sus intereses.");
                                System.out.println("✔2. Revisar las recomendaciones unicamente cuando tenga tiempo libre.");
                                System.out.println("✔3. Establecer limites de uso, revisar sus habitos y controlar las \nrecomendaciones con las herramientas de la plataforma.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaTiempoP = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaTiempoP < 1 || respuestaTiempoP > 3) {
                                        System.out.println("Error: opcion invalida.\n");
                                    }
                                } while (respuestaTiempoP < 1 || respuestaTiempoP > 3);
                                switch (respuestaTiempoP) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Interactuar mas con las recomendaciones puede reforzar ese patron \nde consumo.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Interactuar mas con las recomendaciones puede reforzar ese patron \nde consumo.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Los algoritmos personalizan el contenido segun la actividad \ndel usuario. Reconocer este comportamiento y establecer limites ayuda \na tomar decisiones conscientes sobre el tiempo de pantalla.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: TIEMPO DE PANTALLA");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");
                                break;
                            case 5:
                                /* MISIONES DEL DIA 5 */
                                int respuestamensjSus;
                                int aciertosDia5;
                                aciertosDia5 = 0;
                                System.out.println("MISION: MENSAJES SOSPECHOSOS.");
                                System.out.println("\n¡" + nombre + "! El Dr. Datos esta mandando mensajes con estafas y \nnoticias falsas a los habitantes de Ciudad Digital, debemos analizar \ncinco mensajes y decidir cual es la respuesta más segura.");
                                /* Mensaje 1 */
                                System.out.println("\nMENSAJE 1: El mensaje del banco.");
                                System.out.println("\nRecibes un mensaje de texto que parece provenir de tu banco. Informa \nque se detecto un inicio de sesion inusual y que debes confirmar tus \ndatos mediante un enlace. El mensaje incluye tu nombre y los ultimos \ncuatro digitos de tu tarjeta, pero el enlace dirige a una pagina \ncon una direccion diferente a la pagina oficial del banco.");
                                System.out.println("¿Que deberias hacer?");
                                System.out.println("✔1. Abrir el enlace porque el mensaje contiene informacion \npersonal correcta.");
                                System.out.println("✔2. No ingresar informacion, contactar al banco mediante sus \ncanales oficiales y reportar el mensaje.");
                                System.out.println("✔3. Responder al mensaje preguntando si realmente pertenece \nal banco.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestamensjSus = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestamensjSus < 1 || respuestamensjSus > 3) {
                                        System.out.println("ERROR: opcion invalida.\n");
                                    }
                                } while (respuestamensjSus < 1 || respuestamensjSus > 3);
                                switch (respuestamensjSus) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Que un mensaje contenga datos reales no garantiza su autenticidad.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia5 = aciertosDia5 + 1;
                                        System.out.println("¡Correcto! Siempre verifica las solicitudes mediante canales oficiales.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Que un mensaje contenga datos reales no garantiza su autenticidad.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mensaje 2 */
                                System.out.println("\nMENSAJE 2: El archivo inesperado.");
                                System.out.println("\nUn compañero de clase te envia un archivo que supuestamente contiene \nlas calificaciones del semestre. El mensaje tiene una forma de escribir \ndiferente a la habitual y, cuando le preguntas si lo envio, \nresponde que no sabe de que estas hablando.");
                                System.out.println("¿Que deberias hacer?");
                                System.out.println("✔1. Descargar el archivo porque proviene de un contacto conocido.");
                                System.out.println("✔2. Reenviar el archivo a otros compañeros para comprobar si tambien \npueden abrirlo.");
                                System.out.println("✔3. No abrirlo, verificar la situacion directamente con tu compañero \ny reportar el mensaje sospechoso.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestamensjSus = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestamensjSus < 1 || respuestamensjSus > 3) {
                                        System.out.println("ERROR: opcion invalida.\n");
                                    }
                                } while (respuestamensjSus < 1 || respuestamensjSus > 3);
                                switch (respuestamensjSus) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Los mensajes enviados desde cuentas conocidas no siempre \nson seguros.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Los mensajes enviados desde cuentas conocidas no siempre \nson seguros.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia5 = aciertosDia5 + 1;
                                        System.out.println("¡Correcto! Una cuenta conocida tambien puede ser utilizada por otra persona \nsin autorizacion.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mensaje 3 */
                                System.out.println("\nMENSAJE 3: El falso soporte tecnico.");
                                System.out.println("\nRecibes una llamada de una persona que afirma trabajar para el servicio tecnico \nde una plataforma que utilizas. Dice que detectaron actividad sospechosa en \ntu cuenta y que necesita un codigo de verificacion que acaba de llegar \na tu celular para solucionar el problema.");
                                System.out.println("¿Que deberias hacer?");
                                System.out.println("✔1. Compartir el codigo si la persona demuestra conocer el nombre de \ntu cuenta.");
                                System.out.println("✔2. Finalizar la llamada y contactar directamente al soporte oficial \nde la plataforma.");
                                System.out.println("✔3. Solicitar que te envie un mensaje desde su numero corporativo antes \nde compartir el codigo.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestamensjSus = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestamensjSus < 1 || respuestamensjSus > 3) {
                                        System.out.println("ERROR: opcion invalida.\n");
                                    }
                                } while (respuestamensjSus < 1 || respuestamensjSus > 3);
                                switch (respuestamensjSus) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Conocer informacion de tu cuenta o utilizar un tono profesional \nno demuestra que una persona pertenezca al soporte tecnico.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia5 = aciertosDia5 + 1;
                                        System.out.println("¡Correcto! Los codigos de verificacion son personales y pueden permitir \nel acceso a tus cuentas.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Conocer informacion de tu cuenta o utilizar un tono profesional \nno demuestra que una persona pertenezca al soporte tecnico.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mensaje 4 */
                                System.out.println("\nMENSAJE 4: La oferta exclusiva.");
                                System.out.println("\nUna tienda en linea publica una promocion con descuentos muy superiores a \nlos habituales. La pagina utiliza el logo de una marca reconocida y tiene comentarios \npositivos, pero su direccion web contiene una palabra adicional y no aparece \nvinculada desde las redes oficiales de la empresa.");
                                System.out.println("¿Que deberias hacer?");
                                System.out.println("✔1. Comprar rapidamente antes de que termine la promocion.");
                                System.out.println("✔2. Verificar la direccion web y consultar la promocion en los \ncanales oficiales de la marca.");
                                System.out.println("✔3. Confiar en los comentarios positivos publicados en la \nmisma pagina.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestamensjSus = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestamensjSus < 1 || respuestamensjSus > 3) {
                                        System.out.println("ERROR: opcion invalida.\n");
                                    }
                                } while (respuestamensjSus < 1 || respuestamensjSus > 3);
                                switch (respuestamensjSus) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Los comentarios y elementos visuales pueden ser falsificados.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia5 = aciertosDia5 + 1;
                                        System.out.println("¡Correcto! Las paginas fraudulentas pueden copiar logos, diseños y comentarios \npara aparentar legitimidad.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Los comentarios y elementos visuales pueden ser falsificados.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                /* Mensajje 5*/
                                System.out.println("\nMENSAJE 5: La solicitud de un amigo.");
                                System.out.println("\nRecibes un mensaje desde la cuenta de un amigo que afirma haber perdido \nel acceso a su correo electronico. Te pide que le envies un codigo que llegara a tu telefono \npara recuperar su cuenta. El mensaje parece escrito por el y utiliza expresiones \nque suelen tener en sus conversaciones.");
                                System.out.println("¿Que deberias hacer?");
                                System.out.println("✔1. Enviar el codigo.");
                                System.out.println("✔2. Enviar una captura de pantalla del mensaje para que pueda utilizar \nla informacion.");
                                System.out.println("✔3. Contactarlo por otro medio para verificar la solicitud y no \ncompartir ningun codigo de seguridad.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestamensjSus = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestamensjSus < 1 || respuestamensjSus > 3) {
                                        System.out.println("ERROR: opcion invalida.\n");
                                    }
                                } while (respuestamensjSus < 1 || respuestamensjSus > 3);
                                switch (respuestamensjSus) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Reconocer la forma de escribir de una persona no garantiza \nque sea ella quien controla la cuenta.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Reconocer la forma de escribir de una persona no garantiza \nque sea ella quien controla la cuenta.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        aciertosDia5 = aciertosDia5 + 1;
                                        System.out.println("¡Correcto! Las cuentas pueden ser comprometidas y utilizadas para engañar \na los contactos de su propietario.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");

                                /* si acerto los 5 mensajes se desbloquea el logro, solo si no lo tenia antes */
                                if (aciertosDia5 == 5 && logroMensajes == false) {
                                    logroMensajes = true;
                                    logrosObtenidos = logrosObtenidos + 1;
                                    System.out.println("\n¡LOGRO DESBLOQUEADO!");
                                    System.out.println("DETECTOR DE AMENAZAS");
                                    System.out.println("¡Has identificado correctamente las cinco \namenazas digitales de hoy!");
                                }
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: MENSAJES SOSPECHOSOS");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");

                                break;
                            case 6:
                                /* MISIONES DEL DIA 6 */
                                int respuestaBienestar;
                                System.out.println("MISION: BIENESTAR DIGITAL. ");
                                System.out.println("\nLa Boveda Digital ha detectado alteraciones en los habitos tecnologicos \ndel usuario. Aunque sus conocimientos de seguridad han mejorado, su \nrelacion con la tecnologia todavia presenta algunos desequilibrios.");
                                System.out.println("Tu mision sera resolver siete desafios para recuperar el equilibrio digital.");

                                System.out.println("\n SITUACION 1: El ciclo de la productividad.");
                                System.out.println("\nUna estudiante utiliza aplicaciones de organizacion para planificar sus \nactividades. Sin embargo, dedica tanto tiempo a modificar sus \ncalendarios, revisar estadisticas y reorganizar tareas que \ntermina teniendo menos tiempo para realizarlas.");
                                System.out.println("¿Cual seria la mejor solucion?");
                                System.out.println("✔1. Incorporar mas herramientas de organizacion para automatizar la \nplanificacion.");
                                System.out.println("✔2. Establecer un tiempo maximo para planificar y priorizar la \nejecucion de las actividades.");
                                System.out.println("✔3. Eliminar todas las herramientas digitales y organizarse \nunicamente de memoria.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las herramientas digitales deben ayudar a organizar las \nactividades. Dedicar demasiado tiempo a planificar puede \nafectar la productividad.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Las herramientas de productividad deben facilitar las actividades, \nno convertirse en una actividad que consuma el tiempo destinado a \nrealizarlas.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las herramientas digitales deben ayudar a organizar las \nactividades. Dedicar demasiado tiempo a planificar puede \nafectar la productividad.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 2: La fatiga de la decision.");
                                System.out.println("\nUna persona recibe constantemente notificaciones, correos, \nrecomendaciones y mensajes de distintas aplicaciones. Aunque no \ntodas requieren atencion inmediata, siente que debe revisarlas \npara mantenerse al dia y termina agotada mentalmente.");
                                System.out.println("¿Que estrategia seria mas efectiva?");
                                System.out.println("✔1. Organizar las notificaciones por prioridad y establecer \nmomentos especificos para revisarlas.");
                                System.out.println("✔2. Revisar todas las notificaciones inmediatamente para evitar \nacumular informacion.");
                                System.out.println("✔3. Mantener las aplicaciones abiertas y responder unicamente \ncuando tenga tiempo.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Reducir las interrupciones y establecer prioridades \ndisminuye la carga de atencion y permite administrar mejor \nlos recursos mentales.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Revisar constantemente las notificaciones puede \naumentar las interrupciones.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Revisar constantemente las notificaciones puede \naumentar las interrupciones.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 3: La desconexion incompleta.");
                                System.out.println("\nUn estudiante decide descansar de las redes sociales durante una \nsemana. Sin embargo, reemplaza el tiempo que dedicaba a ellas con \nvideojuegos y videos en otras plataformas. Al finalizar la semana, \nsu tiempo total frente a las pantallas permanece practicamente igual.");
                                System.out.println("¿Que demuestra esta situacion?");
                                System.out.println("✔1. Que abandonar una aplicacion especifica garantiza mejorar el \nbienestar digital.");
                                System.out.println("✔2. Que el bienestar digital depende principalmente de la cantidad \nde aplicaciones instaladas.");
                                System.out.println("✔3. Que reducir una plataforma no necesariamente modifica los \nhabitos generales de consumo tecnologico.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Cambiar una plataforma por otra no necesariamente \nmodifica el tiempo total de pantalla.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Cambiar una plataforma por otra no necesariamente \nmodifica el tiempo total de pantalla.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! El bienestar digital no depende de abandonar una sola \naplicacion, sino de evaluar los habitos tecnologicos en \nconjunto.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 4: El descanso interrumpido.");
                                System.out.println("\nUna persona utiliza su telefono antes de dormir para escuchar musica \ny revisar mensajes. Aunque intenta acostarse temprano, las notificaciones y el \ncontenido recomendado prolongan su actividad hasta altas horas de la noche.");
                                System.out.println("¿Que cambio tendria mayor impacto?");
                                System.out.println("✔1. Mantener el telefono cerca para responder rapidamente y evitar \npreocupaciones.");
                                System.out.println("✔2. Establecer una rutina de desconexion antes de dormir y reducir \nlas interrupciones nocturnas.");
                                System.out.println("✔3. Cambiar las redes sociales por aplicaciones de entretenimiento \ncon menor cantidad de notificaciones.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Cambiar una aplicacion por otra no soluciona \nnecesariamente el problema.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Crear una rutina de desconexion y reducir los estimulos \ndigitales antes de dormir favorece los habitos de descanso.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Cambiar una aplicacion por otra no soluciona \nnecesariamente el problema.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 5: La comparacion digital.");
                                System.out.println("\nUna estudiante observa constantemente publicaciones de personas que \nmuestran logros academicos, viajes y estilos de vida aparentemente \nperfectos. Comienza a comparar su vida con esas publicaciones y \nsiente que sus propios avances son insuficientes.");
                                System.out.println("¿Que decision favoreceria su bienestar?");
                                System.out.println("✔1. Seguir mas cuentas que publiquen logros similares para motivarse.");
                                System.out.println("✔2. Intentar alcanzar el mismo estilo de vida que observa en las redes.");
                                System.out.println("✔3. Revisar sus habitos de consumo, limitar el contenido que le genera \nmalestar y recordar que las publicaciones muestran una seleccion \nde la realidad.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las publicaciones no representan necesariamente \nla realidad completa de las personas.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las publicaciones no representan necesariamente \nla realidad completa de las personas.");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Las redes sociales muestran representaciones seleccionadas \nde la vida de las personas. Reconocerlo ayuda a evitar comparaciones \npoco realistas.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 6: El equilibrio entre lo academico y lo personal.");
                                System.out.println("\nUn estudiante universitario utiliza el computador y el celular durante casi \ntoda su jornada. Aunque sus actividades academicas son importantes, ha dejado \nde dedicar tiempo a sus pasatiempos y encuentros sociales porque siente \nque siempre tiene algo pendiente en sus dispositivos.");
                                System.out.println("¿Que estrategia seria mas adecuada?");
                                System.out.println("✔1. Organizar horarios que contemplen responsabilidades academicas, actividades \npersonales, descanso y espacios de interaccion presencial.");
                                System.out.println("✔2. Aprovechar cada momento libre para adelantar actividades academicas \ndesde el celular.");
                                System.out.println("✔3. Reducir unicamente el tiempo dedicado a videojuegos y redes sociales, \nsin modificar el resto de la rutina.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! El bienestar digital requiere integrar la tecnologia de \nforma equilibrada con las responsabilidades, el descanso y las relaciones \npersonales.");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Reducir una sola actividad no garantiza recuperar \nel equilibrio.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Reducir una sola actividad no garantiza recuperar \nel equilibrio.");
                                        break;
                                }
                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n SITUACION 7: La autonomia digital.");
                                System.out.println("\nUna persona utiliza aplicaciones que registran su tiempo de pantalla \ny le muestran estadisticas semanales. Sin embargo, ignora las recomendaciones automaticas \nporque considera que sus habitos no necesitan modificaciones, aunque reconoce que \nfrecuentemente aplaza actividades importantes por permanecer conectada.");
                                System.out.println("¿Que representa una verdadera gestion del bienestar digital?");
                                System.out.println("✔1. Depender completamente de las recomendaciones automaticas \nde las aplicaciones.");
                                System.out.println("✔2. Analizar los propios habitos, reconocer sus consecuencias y \nestablecer cambios realistas de acuerdo con las necesidades personales.");
                                System.out.println("✔3. Reducir el tiempo de pantalla hasta alcanzar el minimo \nposible, sin considerar el proposito de cada actividad.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBienestar = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBienestar < 1 || respuestaBienestar > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBienestar < 1 || respuestaBienestar > 3);
                                switch (respuestaBienestar) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las aplicaciones pueden proporcionar informacion \nsobre los habitos digitales, pero cada persona debe analizar sus necesidades \ny tomar decisiones responsables.");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        System.out.println("¡Correcto! Las herramientas digitales pueden ayudar a identificar \npatrones, pero el bienestar requiere autonomia, reflexion y decisiones \nconscientes.");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        System.out.println("Incorrecto... Las aplicaciones pueden proporcionar informacion \nsobre los habitos digitales, pero cada persona debe analizar sus necesidades \ny tomar decisiones responsables.");
                                        break;
                                }

                                if (proteccion > 100) {
                                    proteccion = 100;
                                } else {
                                    if (proteccion < 0) {
                                        proteccion = 0;
                                    }
                                }
                                System.out.println("\nLa proteccion actual de tu boveda es: " + proteccion + "/100");
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: BIENESTAR DIGITAL");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");

                                break;
                            case 7:
                                /* MISIONES DEL DIA 7 */
 /* vidaDrDatos la declaramos arriba para poder mostrarla en el reporte final */
                                int respuestaBatallaF;
                                vidaDrDatos = 100;
                                System.out.println("MISION: BATALLA FINAL. ");
                                System.out.println("\nEl Dr. Datos ha conseguido infiltrarse en la Boveda Digital. \nDurante toda la semana ha observado tus decisiones y ahora \npretende utilizar sus conocimientos para tomar el control de \nsu informacion personal.");
                                System.out.println("\nLa unica forma de detenerlo es superar siete desafios que \npondran a prueba todo lo aprendido durante la mision.");
                                System.out.println("\n*¡Ha llegado el momento de demostrar que eres un verdadero Guardian de la Privacidad!*");
                                System.out.println("¡Cuidado! Dr. Datos tiene 100 puntos de vida, cada respuesta \ncorrecta le resta 15 puntos de energia y cada respuesta \nincorrecta le permite recuperar 5 puntos.");

                                System.out.println("\nDESAFIO 1: La identidad comprometida.");
                                System.out.println("Una estudiante recibe una solicitud de amistad de una cuenta \nque utiliza el nombre y las fotografias de una amiga cercana. \nLa cuenta conoce informacion sobre sus actividades recientes y le \nenvia un enlace para participar en una supuesta actividad universitaria. \nAl mismo tiempo, varias fotografias de la estudiante aparecen en perfiles \nque ella no reconoce.");
                                System.out.println("¿Cual seria la mejor estrategia para reducir la exposicion \nde su identidad digital?");
                                System.out.println("✔1. Bloquear las cuentas desconocidas y cambiar la contraseña \nde la red social donde aparecieron las fotografias.");
                                System.out.println("✔2. Verificar la identidad de la amiga, conservar evidencias de \nlos perfiles falsos, denunciar la suplantacion y revisar la \nprivacidad de sus publicaciones.");
                                System.out.println("✔3. Contactar a la amiga desde su cuenta original y solicitar \nque elimine las fotografias compartidas anteriormente.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                }

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

                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");

                                System.out.println("\nDESAFIO 2: La noticia manipulada.");
                                System.out.println("Una publicacion viral afirma que una universidad descubrio que \nutilizar dispositivos electronicos durante mas de cuatro horas \nal dia causa necesariamente problemas de memoria. La noticia incluye \nuna investigacion real sobre la relacion entre determinados habitos \ndigitales y la concentracion, pero el estudio no establece ese limite \nni demuestra una relacion causal.");
                                System.out.println("¿Que procedimiento permite evaluar mejor la afirmacion?");
                                System.out.println("✔1. Aceptar la noticia porque utiliza una investigacion academica \ny menciona una institucion reconocida.");
                                System.out.println("✔2. Comparar la publicacion con otros medios que hayan divulgado el \nmismo estudio y evaluar si coinciden sus titulares.");
                                System.out.println("✔3. Consultar la investigacion original, distinguir correlacion de \ncausalidad y comprobar si sus resultados respaldan el limite mencionado.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                }

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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");
                                System.out.println("\nDESAFIO 3: El acceso no autorizado.");
                                System.out.println("Un estudiante recibe una alerta de acceso desde una ubicacion \ndesconocida. Al revisar su cuenta, descubre que utiliza la misma contraseña \nen otras tres plataformas. Tambien recuerda haber concedido permisos \nde acceso a una aplicacion que ya no utiliza.");
                                System.out.println("¿Cual es el plan de respuesta mas completo?");
                                System.out.println("✔1. Cambiar la contraseña reutilizada, cerrar sesiones \ndesconocidas, activar la autenticacion en dos pasos y revisar los permisos \nconcedidos.");
                                System.out.println("✔2. Eliminar la aplicacion, cambiar la contraseña de la \ncuenta principal y esperar nuevas alertas antes de revisar las demas.");
                                System.out.println("✔3. Activar la autenticacion en dos pasos, conservar las \ncontraseñas actuales y desactivar las notificaciones de seguridad.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                }
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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");

                                System.out.println("\nDESAFIO 4: El algoritmo invisible.");
                                System.out.println("\nUn estudiante pasa cada vez mas tiempo en una plataforma de \nvideos. El algoritmo le recomienda contenido relacionado con sus \nintereses y opiniones, por lo que empieza a recibir perspectivas \nmuy similares. Al mismo tiempo, sus estadisticas muestran que ha \nreducido las horas dedicadas al estudio y al descanso.");
                                System.out.println("¿Cual seria la estrategia mas adecuada?");
                                System.out.println("✔1. Modificar sus preferencias de contenido para recibir \npublicaciones de otros temas y mantener sus horarios actuales \nde uso.");
                                System.out.println("✔2. Limitar el tiempo de pantalla, diversificar las fuentes \nde informacion y establecer espacios de desconexion para \nrecuperar otras actividades.");
                                System.out.println("✔3. Desactivar las recomendaciones personalizadas y conservar \nel mismo tiempo de uso para evitar perder contenido \nrelevante.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 2:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                }

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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");

                                System.out.println("\nDESAFIO 5: La trampa de los tres mensajes.");
                                System.out.println("\nUna estudiante recibe tres comunicaciones: un correo que \nparece provenir de su universidad y solicita actualizar sus credenciales, \nun mensaje de un amigo con un archivo inesperado y una alerta \nbancaria sobre una compra desconocida. Los tres mensajes contienen \ninformacion personal correcta.");
                                System.out.println("¿Cual es el procedimiento mas seguro?");
                                System.out.println("✔1. Responder a los tres remitentes para confirmar las \nsolicitudes antes de proporcionar informacion adicional.");
                                System.out.println("✔2. Abrir los enlaces desde el computador, comprobar que \nlas paginas tengan candado de seguridad y continuar \nsi parecen oficiales.");
                                System.out.println("✔3. Evitar los enlaces recibidos, contactar a cada entidad \npor canales independientes y verificar la identidad \ndel amigo antes de abrir el archivo.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                }

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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");
                                System.out.println("\nDESAFIO 6: El costo de estar conectado.");
                                System.out.println("\nUna estudiante organiza su jornada mediante aplicaciones \ndigitales. Sus estadisticas muestran que utiliza dispositivos durante \nnueve horas diarias, de las cuales cinco corresponden a actividades \nacademicas. Sin embargo, duerme menos de lo habitual, interrumpe sus comidas \npara revisar notificaciones y ha dejado de realizar actividades recreativas.");
                                System.out.println("¿Que interpretacion y estrategia son mas apropiadas?");
                                System.out.println("✔1. El uso academico justifica la mayor parte del tiempo de \npantalla, por lo que basta con limitar las aplicaciones recreativas.");
                                System.out.println("✔2. El tiempo total debe reducirse a un numero fijo de horas, \nindependientemente de las actividades y necesidades de la estudiante.");
                                System.out.println("✔3. Es necesario evaluar el impacto de los habitos digitales, \nreorganizar las jornadas y establecer limites que contemplen estudio, \ndescanso y actividades personales.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos aprovecha tu descuido!");
                                        break;
                                    case 3:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡Impacto directo!");
                                        break;
                                }

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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                System.out.println("¡Sigamos! ¡Tu puedes!");
                                System.out.println("\nDESAFIO 7: El ataque definitivo.");
                                System.out.println("\nEl Dr. Datos publica una noticia falsa sobre una filtracion \nde informacion universitaria. Para hacerla creible, utiliza el logo de la \ninstitucion, una fotografia de un documento real y testimonios de estudiantes. \nAl mismo tiempo, envia mensajes privados solicitando codigos de verificacion\n y comparte enlaces a una pagina que imita el portal universitario.");
                                System.out.println("¿Cual es la respuesta que permite enfrentar de manera \nintegral el ataque?");
                                System.out.println("✔1. Verificar el comunicado institucional, advertir a los \nposibles afectados, evitar los enlaces, proteger las cuentas y \nreportar los mensajes fraudulentos.");
                                System.out.println("✔2. Cambiar las contraseñas universitarias, eliminar las \npublicaciones relacionadas y esperar una confirmacion antes de \ncomunicar cualquier alerta.");
                                System.out.println("✔3. Compartir capturas de los mensajes, solicitar a los \nestudiantes que bloqueen los remitentes y consultar las noticias \nen medios conocidos.");
                                do {
                                    System.out.println("Elige una opcion:");
                                    respuestaBatallaF = entrada.nextInt();
                                    entrada.nextLine();
                                    if (respuestaBatallaF < 1 || respuestaBatallaF > 3) {
                                        System.out.println("ERROR: opcion invalida.");
                                    }
                                } while (respuestaBatallaF < 1 || respuestaBatallaF > 3);
                                switch (respuestaBatallaF) {
                                    case 1:
                                        proteccion = proteccion + 10;
                                        decisionesCorrectas = decisionesCorrectas + 1;
                                        vidaDrDatos = vidaDrDatos - 15;
                                        System.out.println("¡Correcto! ¡GOLPE FINAL!");
                                        break;
                                    case 2:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos resiste!");
                                        break;
                                    case 3:
                                        proteccion = proteccion - penalizacionNivel;
                                        decisionesIncorrectas = decisionesIncorrectas + 1;
                                        puntuacionDia = puntuacionDia + 1;
                                        vidaDrDatos = vidaDrDatos + 5;
                                        System.out.println("¡Incorrecto! ¡El Dr. Datos resiste!");
                                        break;
                                }

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
                                System.out.println("\nLa vida de DrDatos es: " + vidaDrDatos + "/100");
                                /* miramos si el Dr. Datos quedo sin vida */
                                if (vidaDrDatos == 0) {
                                    System.out.println("¡El Dr. Datos ha sido derrotado! La Boveda Digital esta a salvo.");
                                } else {
                                    System.out.println("El Dr. Datos logro escapar con " + vidaDrDatos + " puntos de vida...");
                                }
                                System.out.println("\n_________________");
                                System.out.println("\nINFORME DE LA MISION: BATALLA FINAL");
                                System.out.println("Analisis completado, " + nombre);
                                System.out.println("\nDIA " + diaJuego + " - ACTIVIDAD COMPLETADA");
                                System.out.println("\nRESULTADOS DE LA JORNADA");
                                System.out.println("Decisiones correctas acumuladas: " + decisionesCorrectas);
                                System.out.println("Decisiones incorrectas acumuladas: " + decisionesIncorrectas);
                                System.out.println("Logros desbloqueados: " + logrosObtenidos);
                                System.out.println("Gracias por completar la actividad de hoy, " + nombre + ", \ncada decision cuenta para proteger tu boveda digital.");
                                break;
                        }

                        /*
                         * ACUMULADORES Y CONTADORES DE LA SEMANA
                         * --------------------------------------
                         * Se actualizan una vez que el dia fue completado.
                         */
                        puntajeDigitalAcumulado = puntajeDigitalAcumulado + puntuacionDia;
                        diasCompletados = diasCompletados + 1;
                        horasAcumuladas = horasAcumuladas + cantidadHoras;

                        // Para el logro de tiempo saludable contamos dias de 3 horas o menos.
                        if (cantidadHoras <= 3) {
                            diasConUsoSaludable = diasConUsoSaludable + 1;
                        }

                        /*
                         * LOGRO "REY DEL TIEMPO":
                         * se obtiene al registrar al menos tres dias con 3 horas
                         * o menos de uso de redes sociales.
                         */
                        if (diasConUsoSaludable >= 3 && logroReyDelTiempo == false) {
                            logroReyDelTiempo = true;
                            logrosObtenidos = logrosObtenidos + 1;
                            System.out.println("\n¡LOGRO DESBLOQUEADO: REY DEL TIEMPO!");
                            System.out.println("Registraste tres dias con 3 horas o menos de uso.");
                        }

                        /* informe del dia */
                        System.out.println("\n_________________");
                        System.out.println("INFORME DE LA BOVEDA DIGITAL DEL DIA: " + diaJuego);
                        System.out.println("Nombre del jugador: " + nombre);
                        System.out.println("Edad del jugador: " + edad);
                        System.out.println("Fecha de entrada: " + diaf + "/" + mesf + "/" + año);
                        System.out.println("Hora de entrada del dia " + diaJuego + ": " + horaf + ":" + minutof + " " + franjaHoraria);
                        System.out.println("Horas de uso de redes sociales del dia " + diaJuego + ": " + cantidadHoras);
                        System.out.println("Fecha de salida: " + diaSalidaf + "/" + mesSalidaf + "/" + añoSalida);
                        System.out.println("Hora de salida en formato militar: " + horaDeSalidaf + ":" + minutoDeSalidaf + ":" + segundoDelDiaSalidaf);
                        if (diaAdicional == 1) {
                            System.out.println("Tu sesion cruzo la medianoche:");
                            System.out.println("  - " + (minutosFechaInicio / 60) + " h " + (minutosFechaInicio % 60) + " min el " + diaf + "/" + mesf + "/" + año);
                            /* si termino justo a la media noche solo queda el segundo adicional en la otra fecha */
                            if (minutosFechaSiguiente > 0) {
                                System.out.println("  - " + (minutosFechaSiguiente / 60) + " h " + (minutosFechaSiguiente % 60) + " min el " + diaSalidaf + "/" + mesSalidaf + "/" + añoSalida);
                            } else {
                                System.out.println("  - termino justo a la medianoche, la salida queda el " + diaSalidaf + "/" + mesSalidaf + "/" + añoSalida + " a las 00:00:01");
                            }
                        }
                        System.out.println("\nAnalisis del tiempo de uso del dia " + diaJuego + ":");
                        System.out.println(mensajeRiesgo + "\n");
                        System.out.println("Analisis del horario del dia " + diaJuego + ":");
                        System.out.println(mensajeRiesgo2 + "\n");
                        System.out.println("Evaluacion de riesgo del dia " + diaJuego + ", puntuacion: " + puntuacionDia);
                        System.out.println("Puntaje digital acumulado: " + puntajeDigitalAcumulado);
                        System.out.println("La proteccion actual de tu boveda es: " + proteccion + "/100");
                        System.out.println("_________________");

                        /*
                         * NIVEL ALCANZADO Y BARRA DE PROGRESO
                         * -----------------------------------
                         * Los niveles dependen de los dias COMPLETADOS:
                         * dias 1-2 = Nivel 1 (2 dias en total)
                         * dias 3-5 = Nivel 2 (3 dias en total)
                         * dias 6-7 = Nivel 3 (2 dias en total)
                         *
                         * La barra representa el avance dentro del nivel actual,
                         * no el porcentaje general de los siete dias.
                         */
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
                        System.out.println("\nNIVEL " + nivelAlcanzado + ": " + nombreNivel);

                        /* con el for armamos la barra de 10 bloques, los llenos con * y los vacios con - */
                        bloquesProgreso = (diasDentroDelNivel * 10) / diasNecesariosNivel;
                        barraProgreso = "";
                        for (int i = 1; i <= 10; i = i + 1) {
                            if (i <= bloquesProgreso) {
                                barraProgreso = barraProgreso + "*";
                            } else {
                                barraProgreso = barraProgreso + "-";
                            }
                        }
                        System.out.println("Progreso del nivel: [" + barraProgreso + "]");
                        System.out.println(diasDentroDelNivel + "/" + diasNecesariosNivel + " dias completados en este nivel.");
                        System.out.println("Semana digital: " + diasCompletados + "/7 dias completados.");

                        /* si todavia no es el dia 7 le preguntamos si quiere seguir, si dice N el while se termina solo */
                        if (diaJuego < 7) {
                            do {
                                System.out.print("\n¿Deseas continuar con el dia " + (diaJuego + 1) + "? (S/N): ");
                                opcionContinuar = entrada.nextLine().trim().toUpperCase();
                                if (!opcionContinuar.equals("S") && !opcionContinuar.equals("N")) {
                                    System.out.println("Error: responde S para continuar o N para terminar.");
                                }
                            } while (!opcionContinuar.equals("S") && !opcionContinuar.equals("N"));
                            if (opcionContinuar.equals("N")) {
                                System.out.println("\nHas decidido terminar la semana digital antes de tiempo.");
                                System.out.println("Generaremos tu reporte con los " + diasCompletados + " dias que completaste.");
                            }
                        }

                        /* pasamos al siguiente dia */
                        diaJuego = diaJuego + 1;
                    }

                    /*  dias equivalentes por año: con el promedio de horas por dia calculamos cuantos dias completos
                        de 24 horas pasaria en redes sociales en un año (365 dias)
                        usamos division entera, asi el resultado queda en dias completos
                     */
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

                    /*  finales: el final lo decide el puntaje digital con las categorias del diagnostico
                        menos de 5 = final bueno, de 5 a 13 = final regular, mas de 13 = final malo
                        el puntaje sube con el tiempo en redes, el horario, el contenido y las decisiones inseguras
                        la proteccion de la boveda no cambia el final, solo cambia el mensaje para explicar que paso
                     */
                    if (puntajeDigitalAcumulado < 5) {
                        if (proteccion >= 60) {
                            finalHistoria = "FINAL BUENO: protegiste tu boveda y mantuviste a salvo tu informacion en Ciudad Digital.\n"
                                    + "Tienes habitos digitales saludables. Recomendaciones: sigue usando claves unicas,\n"
                                    + "la autenticacion en dos pasos y limita los datos que publicas.";
                        } else {
                            finalHistoria = "FINAL BUENO: tus habitos digitales son saludables, aunque algunas decisiones\n"
                                    + "dejaron tu boveda menos protegida. Recomendaciones: revisa tus permisos,\n"
                                    + "usa claves unicas y piensa antes de compartir tus datos.";
                        }
                    } else {
                        if (puntajeDigitalAcumulado <= 13) {
                            if (proteccion >= 60) {
                                finalHistoria = "FINAL REGULAR: tomaste buenas decisiones y tu boveda esta bien protegida,\n"
                                        + "pero tu puntaje digital muestra que debes mejorar algunos habitos, como tu tiempo en redes\n"
                                        + "o tu horario de conexion. Recomendaciones: reduce tus horas y conectate dentro del horario saludable.";
                            } else {
                                finalHistoria = "FINAL REGULAR: detuviste parte de los ataques, pero tu boveda tiene puntos debiles\n"
                                        + "y debes mejorar algunos habitos digitales. Mejoraste parcialmente.\n"
                                        + "Recomendaciones: piensa antes de compartir tus datos y organiza mejor tu tiempo en redes.";
                            }
                        } else {
                            if (proteccion >= 60) {
                                finalHistoria = "FINAL MALO: tomaste buenas decisiones y tu boveda esta bien protegida,\n"
                                        + "pero tu uso de redes sociales no es saludable: pasaste demasiado tiempo conectado.\n"
                                        + "Aunque tus respuestas fueron seguras, el exceso de pantalla tambien es un riesgo.\n"
                                        + "Recomendaciones: reduce tus horas de conexion, evita conectarte de noche y busca actividades sin pantalla.";
                            } else {
                                if (proteccion >= 30) {
                                    finalHistoria = "FINAL MALO: tu boveda quedo con puntos debiles y tu uso de redes sociales no es saludable.\n"
                                            + "Recomendaciones: reduce tus horas de conexion, revisa tu privacidad\n"
                                            + "y no compartas codigos de verificacion.";
                                } else {
                                    finalHistoria = "FINAL MALO: tu boveda quedo debil y el Dr. Datos logro comprometer tu informacion.\n"
                                            + "Tu uso de redes sociales no es saludable. Recomendaciones: cambia tus claves,\n"
                                            + "no compartas codigos de verificacion, limita lo que publicas y reduce tu tiempo de pantalla.";
                                }
                            }
                        }
                    }

                    /*  en el final malo agregamos un matiz segun la clasificacion de la guia:
                        de 14 a 20 puntos es Usuario en Riesgo y mas de 20 es Dependencia Digital Alta
                     */
                    if (puntajeDigitalAcumulado > 13) {
                        if (puntajeDigitalAcumulado <= 20) {
                            finalHistoria = finalHistoria + "\nTus habitos te estan poniendo en riesgo, pero todavia estas a tiempo de cambiarlos.";
                        } else {
                            finalHistoria = finalHistoria + "\nTu relacion con las redes se volvio una dependencia: pide ayuda y desconectate poco a poco.";
                        }
                    }

                    /*  el resultado de la batalla con el Dr. Datos lo agregamos aparte segun su vida,
                        asi el final nunca dice que lo derrotaste si todavia le queda vida
                        y si el jugador no llego al dia 7 decimos que la batalla no se jugo.
                        Si lo derroto pero su puntaje digital no es bueno, le explicamos que sus habitos tambien cuentan
                     */
                    if (diasCompletados < 7) {
                        finalHistoria = finalHistoria + "\nNo llegaste a la batalla final: el Dr. Datos sigue escondido en Ciudad Digital.";
                    } else {
                        if (vidaDrDatos == 0) {
                            if (puntajeDigitalAcumulado < 5) {
                                finalHistoria = finalHistoria + "\nEn la batalla final derrotaste al Dr. Datos. ¡Ciudad Digital te lo agradece!";
                            } else {
                                finalHistoria = finalHistoria + "\nDerrotaste al Dr. Datos, pero el siguiente enemigo son tus propios habitos:\nla tecnologia tambien puede dañarte cuando la usas en exceso.";
                            }
                        } else {
                            finalHistoria = finalHistoria + "\nEn la batalla final el Dr. Datos escapo con " + vidaDrDatos + " puntos de vida... volvera a intentarlo.";
                        }
                    }

                    /* reporte final, sale aunque el jugador se haya salido antes del dia 7 */
                    System.out.println("\n=================================================");
                    System.out.println("        REPORTE FINAL DE LA SEMANA DIGITAL");
                    System.out.println("=================================================");
                    System.out.println("Jugador: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Dias completados: " + diasCompletados + "/7");
                    if (diasCompletados < 7) {
                        System.out.println("(Terminaste la semana digital antes del dia 7)");
                    }
                    System.out.println("\nDATOS BASICOS");
                    System.out.println("Hora de ingreso (primer dia): " + horaIngresoInicial);
                    System.out.println("Hora de salida (ultimo dia, militar): " + horaSalidaFinal);
                    System.out.println("Horas acumuladas de uso: " + horasAcumuladas);
                    System.out.println("Dias con uso saludable (3 horas o menos): " + diasConUsoSaludable);
                    System.out.println("Dias equivalentes por año: " + diasEquivalentesPorAño);
                    System.out.println("(proyeccion: si mantienes tu promedio diario de esta semana durante un año,");
                    System.out.println(" pasarias esa cantidad de dias completos de 24 horas en redes sociales)");
                    System.out.println("\nESTADISTICAS DE JUEGO");
                    System.out.println("Decisiones correctas: " + decisionesCorrectas);
                    System.out.println("Decisiones incorrectas: " + decisionesIncorrectas);
                    System.out.println("Nivel alcanzado: " + nivelAlcanzado + " - " + nombreNivel);
                    System.out.println("(completaste " + diasDentroDelNivel + " de " + diasNecesariosNivel + " dias de este nivel)");
                    System.out.println("Logros obtenidos: " + logrosObtenidos + "/3");
                    if (logroFakeNews == true) {
                        System.out.println("  ✔ DETECTIVE DE FAKE NEWS");
                    }
                    if (logroMensajes == true) {
                        System.out.println("  ✔ DETECTOR DE AMENAZAS");
                    }
                    if (logroReyDelTiempo == true) {
                        System.out.println("  ✔ REY DEL TIEMPO");
                    }
                    if (logrosObtenidos == 0) {
                        System.out.println("  (Aun no has desbloqueado logros)");
                    }
                    System.out.println("Puntaje digital acumulado: " + puntajeDigitalAcumulado);
                    System.out.println("Proteccion final de la boveda: " + proteccion + "/100");
                    if (diasCompletados == 7) {
                        System.out.println("Vida final del Dr. Datos: " + vidaDrDatos + "/100");
                    }
                    System.out.println("\nRANKING PERSONAL");
                    System.out.println("Puntaje: " + puntajeDigitalAcumulado);
                    System.out.println("Clasificacion: " + clasificacionFinal);
                    System.out.println("Diagnostico: " + diagnosticoFinal);
                    System.out.println("\nTu final se decide con tu puntaje digital: " + puntajeDigitalAcumulado + " (" + diagnosticoFinal + ")");
                    System.out.println(finalHistoria);
                    System.out.println("\nTus decisiones digitales construyen tu futuro.");
                    System.out.println("Para volver a jugar y demostrar que puedes derrotar al Dr. Datos,");
                    System.out.println("selecciona la opcion 1 en el menu principal.\n");
                    break;
                case "2":
                    System.out.println("\n______________");
                    System.out.println("\nMANUAL DEL GUARDIAN");
                    System.out.println("\n. _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   TU MISION:                                                            |");
                    System.out.println("|   Eres el guardian de la privacidad de ciudad digital                   |");
                    System.out.println("|   Tu mision es proteger la boveda digital y evitar que el Dr. Datos     |");
                    System.out.println("|   robe tu informacion personal.                                         |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   INSTRUCCIONES DEL JUEGO                                               |");
                    System.out.println("|   1. Registra tus datos y la sesion digital de cada dia                 |\n|   2. Revisa el analisis de tu tiempo de uso y tu horario                |\n|   3. Supera la mision de cada dia durante una semana (7 dias)           |\n|   4. Elige la opcion que consideres mas segura en cada situacion        |\n|   5. Sube de nivel, desbloquea logros y descubre tu final               |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    /* explicamos el puntaje digital, la proteccion y como se decide el final para que el jugador lo sepa antes de jugar */
                    System.out.println("|   EL PUNTAJE DIGITAL (empieza en 0, mas bajo es mejor)                  |");
                    System.out.println("|   Es el que decide tu final. Suma puntos de riesgo cada dia por:        |");
                    System.out.println("|   - usar redes mas de 3 y menos de 8 horas: +4    8 horas o mas: +7     |");
                    System.out.println("|   - conectarte antes de 8 am o despues de 8 pm: +4                      |");
                    System.out.println("|   - el contenido que eliges el dia 1 (puede sumar o restar)             |");
                    System.out.println("|   - cada decision insegura en las misiones de los dias 2 al 7: +1       |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   LA PROTECCION DE TU BOVEDA (empieza en 100)                           |");
                    System.out.println("|   decision segura: +10                                                  |");
                    System.out.println("|   decision insegura: Nivel 1: -15   Nivel 2: -20   Nivel 3: -25         |");
                    System.out.println("|   La proteccion y la batalla con el Dr. Datos cambian el mensaje        |");
                    System.out.println("|   de tu final, pero el tipo de final lo decide el puntaje digital.      |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   OJO: COMO SE DECIDE TU FINAL                                          |");
                    System.out.println("|   Aunque aciertes todo y derrotes al Dr. Datos, si pasas                |");
                    System.out.println("|   demasiado tiempo en redes tu puntaje digital sube y tu final          |");
                    System.out.println("|   puede ser malo, porque eso tambien es un habito de riesgo.            |");
                    System.out.println("|   Menos de 5 puntos:  FINAL BUENO   (uso saludable)                     |");
                    System.out.println("|   De 5 a 13 puntos:   FINAL REGULAR (debes mejorar algunos habitos)     |");
                    System.out.println("|   Mas de 13 puntos:   FINAL MALO    (uso no saludable)                  |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   CLASIFICACION (segun tu puntaje digital)                              |");
                    System.out.println("|   Menos de 5: Ciudadano Digital Ejemplar                                |");
                    System.out.println("|   De 5 a 13: Usuario Digital Responsable                                |");
                    System.out.println("|   De 14 a 20: Usuario en Riesgo                                         |");
                    System.out.println("|   Mas de 20: Dependencia Digital Alta                                   |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .");
                    System.out.println("|   OBJETIVO FINAL                                                        |");
                    System.out.println("|   Tendras que mantener la boveda digital protegida y evitar             |");
                    System.out.println("|   que el Dr. Datos comprometa tu informacion                            |");
                    System.out.println(". _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ .\n");
                    break;
                case "3":
                    System.out.println("Muchas gracias por utilizar el juego. ¡Hasta pronto, guardian!");
                    break;
                default:
                    System.out.println("Error: opcion invalida.\n");
            }
        } while (!opcion.equals("3"));
    }
}
