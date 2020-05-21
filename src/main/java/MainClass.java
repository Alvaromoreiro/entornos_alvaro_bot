import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainClass {

        public static void main(String[] args) {
            // Se inicializa el contexto de la API
            ApiContextInitializer.init();

            // Se crea un nuevo Bot b
            final TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

            try {
                // Se registra el bot
                telegramBotsApi.registerBot(new EntornosAlvaroBot());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }

}
