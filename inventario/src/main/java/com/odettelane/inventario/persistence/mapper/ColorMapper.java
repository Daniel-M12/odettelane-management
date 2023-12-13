package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.ColorDto;
import com.odettelane.inventario.persistence.entity.Color;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ColorMapper {
    public ColorDto colorToDto(Color color){
        ColorDto colorDto = ColorDto.builder()
                .id(color.getId())
                .primaryColor(color.getPrimaryColor())
                .build();

        if (color.getSecondaryColor() != null && !color.getSecondaryColor().isEmpty()){
            colorDto.setSecondaryColor(color.getSecondaryColor());
            colorDto.setDistribution(color.getDistribution());
        }

        if (color.getDistribution() != null && !color.getDistribution().isEmpty()){
            colorDto.setDistribution(colorDto.getDistribution());
        }

        if (color.getDistribution() != null && color.getDistribution().isEmpty()){
            colorDto.setDistribution(null);
        }

        return colorDto;
    }

    public abstract List<ColorDto> toColorDtos(List<Color> colors);

    public abstract Color dtoToColor(ColorDto colorDto);

    public abstract List<Color> dtoToColors(List<ColorDto> colorDtos);
}
