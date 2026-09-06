package slack_sonora.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class SlackService {

    private final RestClient restClient;
    private final String webhookUrl;

    public SlackService(
            @Value("${slack.webhook-url}") String webhookUrl
    ) {
        this.restClient = RestClient.builder().build();
        this.webhookUrl = webhookUrl;
    }

    public void enviarMensagem(String mensagem) {

        Map<String, String> payload = Map.of(
                "text", mensagem
        );

        restClient.post()
                .uri(webhookUrl)
                .body(payload)
                .retrieve()
                .toBodilessEntity();
    }
}