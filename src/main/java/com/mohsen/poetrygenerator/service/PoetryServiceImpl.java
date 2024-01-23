package com.mohsen.poetrygenerator.service;

import com.mohsen.poetrygenerator.dto.PoetryDto;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoetryServiceImpl implements PoetryService {

    public static final String WRITE_ME_HAIKU_ABOUT_ROBOT = "Write a Haiku about robots. It must start with the word robot.";
    private final ChatClient chatClient;

    @Autowired
    public PoetryServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    @Override
    public String getRobotHaiku() {
        return chatClient.generate(WRITE_ME_HAIKU_ABOUT_ROBOT);
    }

    @Override
    public PoetryDto getPoetryByGenreAndTheme(String genre, String theme) {
        BeanOutputParser<PoetryDto> poetryDtoBeanOutputParser = new BeanOutputParser<>(PoetryDto.class);

        String promptString = """
                Write me {genre} poetry about {theme}
                {format}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptString);
        promptTemplate.add("genre", genre);
        promptTemplate.add("theme", theme);
        promptTemplate.add("format", poetryDtoBeanOutputParser.getFormat());

        promptTemplate.setOutputParser(poetryDtoBeanOutputParser);

        ChatResponse response = chatClient.generate(promptTemplate.create());
        return poetryDtoBeanOutputParser.parse(response.getGeneration().getContent());
    }
}
