public class juego1 extends EntornosAlvaroBot{
    public static String Preguntas(int aleatorio){

        String[] preguntas = {"¿En qué país europeo el rey Simeón se convirtió en Primer ministro?" +
                        "\n/A en bulgaria\n/B en croacia\n/C en Eslovaquia",
                "¿Dónde tiene su despacho el presidente de los Estados Unidos?" +
                        "\n/A En la Casa Blanca\n/B en el Edificio Lincoln\n/C en el Pentágono",
                "¿Qué estación ferroviaria se construyó antes en los Estados Unidos?" +
                        "\n/A la de Detroid\n/B la de Chicago\n/C la de Dallas",
                "¿Cuál de estos tres nombres no corresponde con un monumento antiguo construido en piedra?" +
                        "\n/A Totem\n/B Obelisco\n/C Menhir",
                "¿Cuál es el volcan mas activo de Europa?" +
                        "\n/A el Teide\n/B el Etna\n/C el Santa Helena",
                "¿Qué plantas no llevan a cabo la función clorifílica?" +
                        "\n/A las parras\n/B los girasoles\n/C el césped",
                "¿En que fecha se encontró por primera vez un calamar de 7 metros de largo?" +
                        "\n/A 1886\n/B 1997\n/C 2001",
                "¿Dónde está el nacimiento del Miño?" +
                        "\n/A en Cabeza de Manzaneda\n/B en Fontemiña\n/C en Santa Tecla",
                "¿De qué parte del violín se obtiene su sonido?" +
                        "\n/A de las cuerdas\n/B del arco\n/C de la caja de resonancia",
                "¿Cuánto mide de ancho la boca de la estatua de la libertad?" +
                        "\n/A 1 metro\n/B 2,5 metros\n/C 4 metros",
                "¿Que Evangelista escribió el Apocalipsis?" +
                        "\n/A San Juan\n/B San Lucas\n/C San Mateo",
                "¿Cuántas cuerdas, como maximo, tiene una guitarra?" +
                        "\n/A Seis\n/B Ocho\n/C Doce",
                "¿De qué heroina de Disney estaba enamorado Gastón?" +
                        "\n/A de Blancanieves\n/B de Bella\n/C de Cenicienta",
                "¿Cuántos eran los teletubies?" +
                        "\n/A 3\n/B 4\n/C 6",
                "¿Qué fracción equivale al formato de cine?" +
                        "\n/A 16:9\n/B 4:3\n/C 8:4",
                "¿Cómo se llama la protagonista de la pelicula Final Fantasy?" +
                        "\n/A Aki\n/B Garnet\n/C Rinoa",
                "¿Al jugar al billar cual seria la ulrima bola que meterias?" +
                        "\n/A Blanca\n/B Negra\n/C Roja",
                "¿Con qué deporte se entretien los neoyorkinos en Forest Hill?"+
                        "\n/A Con el tenis\n/B Con el béisbol\n/C Con el baloncesto",
                "¿En qué campo de fútbol concluye la San Silvestre de Madrid?" +
                        "\n/A en el Santiago Bernabeu\n/B en Vallecas\n/C en el Wanda",
                "¿En qué lugar olímpico hay corcheras?" +
                        "\n/A en el estadio\n/B en el gimnasio\n/C en la piscina",
                "¿Qué planeta del Sistema Solar recibió su nombre del dios griego de la guerra?" +
                        "\n/A Marte\n/B Mercurio\n/C Venus",
                "¿Cuál es la principal empresa alemana del automovil?"+
                        "\n/A Audi\n/B Volkswagen\n/C Volvo",
                "¿Qué instrumento inscribe sobre un cilindro las vibraciones de cualquier sonido?"+
                        "\n/A el Vibrator\n/B el disco compacto\n/C el fonógrafo",
                "¿Qué tipo de software es el Panda?"+
                        "\n/A Un antivirus\n/B Una hoja de calculo\n/C Un procesador de texto"};

        return preguntas[aleatorio];
    }
    public static String Respuestas(int aleatorio){

        String[] respuestas = {"/A", "/A", "/B", "/A", "/B", "/C", "/B", "/B", "/C", "/A", "/A", "/C",
                "/B", "/B", "/A", "/A", "/B", "/A", "/B", "/C", "/A", "/B", "/C", "/A"};

        return respuestas[aleatorio];
    }
}
