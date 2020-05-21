import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Scanner;

public class EntornosAlvaroBot extends TelegramLongPollingBot {

    boolean start = false;
    boolean exit = false;

    //DOS MODOS DE JUEGO
    boolean competicion = false;
    boolean aleatorio = false;

    // AJUSTES PARA EL PRIMER MODO
    boolean ajustando = false;

    //JUGANDO A X MODO
    boolean jugando1 = false;
    boolean jugando2 = false;

    //PUNTUACIONES Y TURNOS
    int puntosGanador = 2;
    int turnos = 1;
    int turnos2 = 1;
    boolean ganador = false;

    //CONTADORES
    int contadorJugador1 = 0;
    int contadorJugador2 = 0;

    int contadorJuego2 = 2;

    int numeroAleatorio = (int)Math.floor(Math.random() * 23);
    //NUMERO DEL 0 AL 4


    public void onUpdateReceived( Update update) {
        // Esta función se invocará cuando nuestro bot reciba un mensaje

        Scanner sc = new Scanner(System.in);

        System.out.println(update.getMessage().getText());

            // We check if the update has a message and the message has text
            if (update.hasMessage() && update.getMessage().hasText()) {
                String message_text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();

                //Si introducimos /start
                if (message_text.equals("/start")) {

                    start = true;

                    contadorJugador1 = 0;
                    contadorJugador2 = 0;

                    //MENSAJE DE BIENVENIDA
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Bienvenido al fantastico... \n" +
                                    "¡Bot de trivial! Donde podrás jugar y aprender a la vez.\n" +
                                    "Existen 2 modos de juego a los que podrás acceder con\n" +
                                    "los siguientes comandos:\n" +
                                    "/competicion (Juego de 2 a 4 jugadores)\n" +
                                    "/aleatorio (Preguntas de cultura aleatorias)\n" +
                                    "Si deseas salir escribe /exit en cualquier momento.");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                }

                //Si no introducimos /start

                else if(start == false){
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("POR FAVOR INTRODUCE /start PARA EMPEZAR");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                //MODO DE JUEGO
                if (message_text.equals("/competicion")&& start == true) {

                    competicion = true;

                    //CARACTERISTICAS DEL MODO
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("---Este es el modo competicion---\n" +
                                    "Para ver las instrucciones escibe /instrucciones\n" +
                                    "Para cambiar el numero de puntos necesarios para ganar escribe /ajustes ( " + puntosGanador + " actualmente )\n" +
                                    "Para empezar a jugar escribe /jugar\n" +
                                    "Para salir escribe /salir");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }


                }

                //SI ESTAS JUGANDO AL PRIMER MODO Y ESCRIBES INSTRUCCIONES
                //TE DA LAS INSTRUCCIONES DE ESE JUEGO
                if (message_text.equals("/instrucciones")&& competicion == true) {

                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Este juego consiste en una prueba de cultura general. \n" +
                                    "Los participantes responderán\n" +
                                    "a preguntas de seis temas diferentes:\n" +
                                    "Geografía, " +
                                    "Arte y Literatura, " +
                                    "Historia, " +
                                    "Entretenimiento, " +
                                    "Ciencias y Naturaleza, " +
                                    "Deportes y Pasatiempos." +
                                    "\nEl primero en llegar a el numero de puntos establecido ( " + puntosGanador + " ) gana.\n" +
                                    "Escribe /competicion para volver al menú del juego");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                //EN ESTE IF SE AJUSTAN LOS PUNTOS PARA GANAR
                if (message_text.equals("/ajustes")&& competicion == true) {

                    ajustando = true;

                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Escribe el numero de puntos necesarios para ganar 1-10");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }


                }

                //LIMITES DE LOS AJUSTES
                if (ajustando == true){
                    if (Integer.parseInt(message_text) < 1 || Integer.parseInt(message_text) > 10 ){
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("El numero ha de ser entre 1 y 10");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }else {

                        puntosGanador = Integer.parseInt(message_text);

                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Numero de puntos necesarios para ganar establecido en " + puntosGanador + "\n" +
                                        "Para ver las opciones escribe /competicion de nuevo");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                        ajustando = false;


                    }
                }
                //SALIR
                if (message_text.equals("/salir")){

                    exit = true;
                    start = false;

                    competicion = false;
                    aleatorio = false;

                    ajustando = false;

                    jugando1 = false;
                    jugando2 = false;

                    puntosGanador = 2;
                    turnos = 1;
                    turnos2 = 1;
                    ganador = false;

                    contadorJugador1 = 0;
                    contadorJugador2 = 0;


                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("¡Hasta la proxima!\nSi deseas volver escribe /start");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                }

                //JUGAR AL PRIMER MODO
                if (message_text.equals("/jugar") && competicion == true){
                    jugando1 = true;
                }
                System.out.println("PUNTUACION JUGADOR 1");
                System.out.println(contadorJugador1);
                System.out.println("PUNTUACION JUGADOR 2");
                System.out.println(contadorJugador2);

                if (jugando1 == true) {


                        // TURNO JUGADOR 1
                        if (turnos == 1 && ganador == false && jugando1 == true && contadorJugador2 != puntosGanador && contadorJugador1 != puntosGanador) {

                            SendMessage message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("TURNO JUGADOR 1");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            //PREGUNTA
                            juego1 juego = new juego1();


                            message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText(juego1.Preguntas(numeroAleatorio));
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            message_text = "none";


                            turnos2 = 0;
                            turnos = 2;

                        //TURNO DE RESPUESTA
                        } if (turnos == 2 && ganador == false && jugando1 == true && message_text !="none" ){


                            //RESPUESTA
                        if (message_text.equals(juego1.Respuestas(numeroAleatorio))){

                            if (turnos2 == 0){
                                contadorJugador1 = contadorJugador1+1;
                            }else{
                                contadorJugador2 = contadorJugador2+1;
                            }


                            numeroAleatorio = (int)Math.floor(Math.random() * 23);

                            SendMessage message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("Respuesta correcta");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            //ESTO CREA UN BUCLE INFINITO
                        if (turnos2 == 0) {
                            turnos = turnos + 1;
                        } else {
                            turnos = turnos - 1;

                             message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("Escriba /siguiente para continuar");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }



                        }

                        } else {

                            numeroAleatorio = (int)Math.floor(Math.random() * 23);

                                SendMessage message = new SendMessage() // Create a message object object
                                        .setChatId(chat_id)
                                        .setText("Respuesta incorrecta");
                                try {
                                    execute(message); // Sending our message object to user
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }


                            if (turnos2 == 0) {
                                turnos = turnos + 1;
                            } else {
                                turnos = turnos - 1;

                                 message = new SendMessage() // Create a message object object
                                        .setChatId(chat_id)
                                        .setText("Escriba /siguiente para continuar");
                                try {
                                    execute(message); // Sending our message object to user
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }

                            }
                        }





                        }
                        //PARA QUE ENTRE AL TURNO DOS EL CONTADOR DE PUNTOS NO PUEDE SER IGUAL A LOS PUNTOS PARA GANAR
                        //Y HA DE ESTAR JUGANDO A ESTE JUEGO
                        if (turnos == 3 && ganador == false && jugando1 == true && contadorJugador2 != puntosGanador && contadorJugador1 != puntosGanador){

                            System.out.println(ganador);
                            SendMessage message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("TURNO JUGADOR 2");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            //PREGUNTA
                            juego1 juego = new juego1();


                            message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText(juego1.Preguntas(numeroAleatorio));
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            message_text = "none";

                        turnos = 2;
                        turnos2 = 1;

                        }


                        //DA UN GANADOR
                    if (contadorJugador1 == puntosGanador){


                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("GANADOR JUGADOR 1\n\nESCRIBE /start PARA VOLVER A EMPEZAR");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                        exit = true;
                        start = false;

                        competicion = false;
                        aleatorio = false;

                        ajustando = false;

                        jugando1 = false;
                        jugando2 = false;

                        turnos = 1;
                        turnos2 = 1;



                    }
                    if (contadorJugador2 == puntosGanador){


                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("GANADOR JUGADOR 2\n\nESCRIBE /start PARA VOLVER A EMPEZAR");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                        exit = true;
                        start = false;

                        competicion = false;
                        aleatorio = false;

                        ajustando = false;

                        jugando1 = false;
                        jugando2 = false;

                        puntosGanador = 2;
                        turnos = 1;
                        turnos2 = 1;


                    }


                }

                //SEGUNDO MODO DE JUEGO
                if (message_text.equals("/aleatorio")&& start == true) {

                    aleatorio = true;

                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("---Este es el modo aleatorio---\n" +
                                    "Este modo consiste en responder a preguntas aleatorias sin fin.\n" +
                                    "Para empezar a jugar escribe /jugar\n" +
                                    "Cuando quieras parar de jugar escribe /salir");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                //ENTRA AL JUEGO
                if (message_text.equals("/jugar") && aleatorio == true){
                    jugando2 = true;
                }

                if (jugando2 == true){

                    juego1 juego2 = new juego1();

                    if(contadorJuego2 % 2 == 0) {
                        //PREGUNTA


                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText(juego1.Preguntas(numeroAleatorio));
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                        contadorJuego2 = contadorJuego2 + 1;
                        message_text = "none";

                    }if (contadorJuego2 % 2 != 0 && message_text != "none"){

                        if (message_text.equals(juego1.Respuestas(numeroAleatorio))){

                            System.out.println("PUNTUACION JUGADOR");
                            System.out.println(contadorJuego2 / 2);

                            numeroAleatorio = (int)Math.floor(Math.random() * 23);

                            SendMessage message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("Respuesta correcta\n\nEscribe /siguiente para continuar\nEscriba /salir si desea terminar el juego");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            contadorJuego2 = contadorJuego2 + 1;

                        } else {

                            numeroAleatorio = (int)Math.floor(Math.random() * 23);

                            SendMessage message = new SendMessage() // Create a message object object
                                    .setChatId(chat_id)
                                    .setText("Respuesta incorrecta\n\nEscribe /siguiente para continuar\nEscriba /salir si desea terminar el juego");
                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            contadorJuego2 = contadorJuego2 + 1;

                        }

                    }


                }




            } else if (update.hasCallbackQuery()) {}
    }



    public String getBotUsername() {
        return "entornos_alvaro_bot";
    }

    public String getBotToken() {
        return "1082088615:AAFL08XzHwi2BEJXRq-u5B_QS8CgzrYUhTQ";
    }
}
