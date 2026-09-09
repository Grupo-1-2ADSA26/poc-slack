package slack_sonora.demo.controller;

import slack_sonora.demo.service.SlackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlackController {

    private final SlackService slackService;

    public SlackController(SlackService slackService) {
        this.slackService = slackService;
    }

    @GetMapping("/slack")
    public String testarSlack() {

        slackService.enviarMensagem(
                "🎵 Olá! Nós somos a Sonora, como podemos te ajudar?"
        );

        return "Mensagem enviada para o Slack!";
    }
}