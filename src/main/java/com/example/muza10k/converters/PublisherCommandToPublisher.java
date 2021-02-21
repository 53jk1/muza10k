package com.example.muza10k.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PublisherCommandToPublisher implements Converter<com.example.muza10k.commands.PublisherCommand, com.example.muza10k.model.Publisher> {

    @Synchronized
    @Nullable
    @Override
    public com.example.muza10k.model.Publisher convert(com.example.muza10k.commands.PublisherCommand source) {
        if (source == null) {
            return null;
        }

        final com.example.muza10k.model.Publisher publisher = new com.example.muza10k.model.Publisher();
        publisher.setName(source.getName());
        publisher.setNip(source.getNip());
        publisher.setAddress(source.getAddress());

        return publisher;
    }
}
