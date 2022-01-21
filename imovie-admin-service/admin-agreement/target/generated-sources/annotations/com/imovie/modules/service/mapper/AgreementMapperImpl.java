package com.imovie.modules.service.mapper;

import com.imovie.modules.domain.Agreement;
import com.imovie.modules.service.dto.AgreementDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T11:06:45+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_312 (Amazon.com Inc.)"
)
@Component
public class AgreementMapperImpl implements AgreementMapper {

    @Override
    public Agreement toEntity(AgreementDto dto) {
        if ( dto == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setId( dto.getId() );
        agreement.setTitle( dto.getTitle() );
        agreement.setContent( dto.getContent() );
        agreement.setType( dto.getType() );
        agreement.setCreateTime( dto.getCreateTime() );
        agreement.setUpdateTime( dto.getUpdateTime() );

        return agreement;
    }

    @Override
    public AgreementDto toDto(Agreement entity) {
        if ( entity == null ) {
            return null;
        }

        AgreementDto agreementDto = new AgreementDto();

        agreementDto.setId( entity.getId() );
        agreementDto.setTitle( entity.getTitle() );
        agreementDto.setContent( entity.getContent() );
        agreementDto.setType( entity.getType() );
        agreementDto.setCreateTime( entity.getCreateTime() );
        agreementDto.setUpdateTime( entity.getUpdateTime() );

        return agreementDto;
    }

    @Override
    public List<Agreement> toEntity(List<AgreementDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Agreement> list = new ArrayList<Agreement>( dtoList.size() );
        for ( AgreementDto agreementDto : dtoList ) {
            list.add( toEntity( agreementDto ) );
        }

        return list;
    }

    @Override
    public List<AgreementDto> toDto(List<Agreement> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AgreementDto> list = new ArrayList<AgreementDto>( entityList.size() );
        for ( Agreement agreement : entityList ) {
            list.add( toDto( agreement ) );
        }

        return list;
    }
}
