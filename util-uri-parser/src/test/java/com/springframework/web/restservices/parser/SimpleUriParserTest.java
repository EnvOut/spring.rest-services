package com.springframework.web.restservices.parser;


import com.springframework.web.restservices.domain.contract.parser.UriParser;
import com.springframework.web.restservices.domain.contract.uri.Language;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleUriParserTest {
    private UriParser parser;



    @Nested
    @DisplayName("test url that contains all valid variables")
    class FullCorrectCases {
        private String correctUrl = "https://www.some.com:3000/1.0/en/users/1/roles.json?embed=id,name&name=super&sort=-name,surname&page=1&size=3&pretty=true&q=alesha";

        @BeforeEach
        @SneakyThrows
        public void init() {
            parser = SimpleUriParser.from(new URI(correctUrl));
        }

        @Test
        public void checkApiVersion() {
            assertThat(parser.getVersion())
                    .isEqualTo(1.0);
        }

        @Test
        public void checkLanguage(){
            assertThat(parser.getLanguage())
                    .isEqualTo(Language.EN);
        }

    }
}