package me.aronne.app.api;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import me.aronne.app.frame.ApplicationFrame;

import java.net.SocketException;
import java.util.List;

public class Gpt3interface {

    // this is insecure, but it's just a demo
    static OpenAiService service = new OpenAiService("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");


    public static void sendRequest(String text, ApplicationFrame frame) throws Exception {

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(text)
                .temperature(0.9)
                .maxTokens(100)
                .frequencyPenalty(0.2)
                .presencePenalty(0.7)
                .topP(1.0)
                .n(1)
                .echo(true)
                .build();
        List<CompletionChoice> completionChoices = service.createCompletion("text-davinci-001", completionRequest).getChoices().stream().toList();

        if (!text.endsWith(" ")){
            frame.setTextCleanly(completionChoices.get(0).getText().substring(text.length()));
        } else {
            frame.setTextCleanly(completionChoices.get(0).getText().substring(text.length()));
        }

    }
}
