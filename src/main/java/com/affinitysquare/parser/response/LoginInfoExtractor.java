package com.affinitysquare.parser.response;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LoginInfoExtractor implements HtmlDataExtractor<Boolean> {
    /**
     * Method looks for the text-input type and name attributes in a given html form to identify if the
     * given html form has a login information or not
     * @param document Jsoup document object
     * @return true if the document has a login information, false otherwise.
     */
    @Override
    public Boolean extract(Document document) {
        Elements inputs = document.getElementsByTag("input");
        return inputs.stream().anyMatch(input -> {
                    Attributes attributes = input.attributes();
                    String name = attributes.get("name");
                    String type = attributes.get("type");

                    return switch (type) {
                        case "text" -> isUsernameInput(name);
                        case "password" -> isPasswordInput(name);
                        case "email" -> isEmailInput(name);
                        default -> false;
                    };

                }
        );
    }

    private boolean isUsernameInput(String name) {
        return name.equals("user") || name.equals("login") || name.equals("username") || name.equals("session_key");
    }

    private boolean isPasswordInput(String name) {
        return name.equals("password") || name.equals("session_password");
    }

    private boolean isEmailInput(String name) {
        return name.equals("email") || name.equals("emailAddress");
    }
}
