package com.example.muza10k.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArtistCommandToArtist implements Converter<com.example.muza10k.commands.ArtistCommand, com.example.muza10k.model.Artist> {

    @Synchronized
    @Nullable
    @Override
    public com.example.muza10k.model.Artist convert(com.example.muza10k.commands.ArtistCommand source) {
        if (source == null) {
            return null;
        }

        final com.example.muza10k.model.Artist artist = new com.example.muza10k.model.Artist();
        artist.setFirstName(source.getFirstName());
        artist.setLastName(source.getLastName());
        artist.setNick(source.getNick());

        return artist;
    }
}
