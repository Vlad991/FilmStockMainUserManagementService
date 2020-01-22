package com.filmstock.converter;

import com.filmstock.dto.MarkDTO;
import com.filmstock.entity.Mark;
import com.filmstock.entity.MarkValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarkConverter {
    @Autowired
    private UserConverter userConverter;

    public MarkDTO convertToDto(Mark mark) {
        MarkDTO markDTO = new MarkDTO();
        markDTO.setUser(userConverter.convertToDto(mark.getUser()));
        markDTO.setMovieId(mark.getMovieId());
        markDTO.setMark(mark.getMark().getValue());
        return markDTO;
    }

    public Mark convertToEntity(MarkDTO markDTO) {
        Mark mark = new Mark();
        mark.setUser(userConverter.convertToEntity(markDTO.getUser()));
        mark.setMovieId(markDTO.getMovieId());
        mark.setMark(MarkValue.getMarkValue(markDTO.getMark()));
        return mark;
    }

    public List<MarkDTO> convertToListDto(List<Mark> marks) {
        return marks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
